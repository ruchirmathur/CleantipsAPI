/*
 * 
 */
package com.cleantips.api;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequestInterceptor;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.SuggestionBuilder;
import org.elasticsearch.search.suggest.completion.CompletionSuggestion;
import org.elasticsearch.search.suggest.completion.FuzzyOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.auth.AWS4Signer;
import com.amazonaws.util.StringUtils;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.cleantips.api.model.ArchitectureSearchRequest;
import com.cleantips.api.model.ArchitectureSearchResponse;
import com.cleantips.api.model.GenerateTemplateRequest;
import com.cleantips.api.model.GenerateTemplateResponse;
import com.cleantips.template.TemplateGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CleanTipsController {

	@Value("${elasticsearch.url}")
	private String elasticSearchEndPoint;

	@Value("${elasticsearch.index}")
	private String index;

	@Value("${default.region}")
	private String defaultRegion;
	
	 static final AWSCredentialsProvider credentialsProvider = new DefaultAWSCredentialsProviderChain();

	/**
	 * 
	 * @param inputPayload
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws IOException
	 */
	@RequestMapping(value = "/templates", method = RequestMethod.POST, produces="application/json")
	public GenerateTemplateResponse generateTemplates(@RequestBody GenerateTemplateRequest inputPayload)
			throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {

		GenerateTemplateRequest generateChangeSetRequest = inputPayload;

		if (generateChangeSetRequest != null && generateChangeSetRequest.getRegion() != null
				& StringUtils.isNullOrEmpty(generateChangeSetRequest.getRegion())) {
			{
				generateChangeSetRequest.setRegion(defaultRegion);
			}

		}

		GenerateTemplateResponse generateTemplateResponse = new GenerateTemplateResponse();

		generateTemplateResponse = generateTemplate(generateChangeSetRequest, generateTemplateResponse);

		return generateTemplateResponse;
	}

	/**
	 * 
	 * @param inputPayload
	 * @return
	 * @throws JsonProcessingException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetExceptio
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/services", method = RequestMethod.POST,produces="application/json")
	public ArrayList<ArchitectureSearchResponse> getApplicationServicesV1(
			@RequestBody ArchitectureSearchRequest inputPayload)
			throws JsonProcessingException, NoSuchMethodException, SecurityException, ClassNotFoundException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		ArchitectureSearchRequest architectureSearchRequest = inputPayload;

		ArrayList<ArchitectureSearchResponse> response = getAppArchitectureResponseV1(architectureSearchRequest);

		return response;
	}

	/**
	 * 
	 * @param architectureSearchRequest
	 * @return
	 */
	private ArrayList<ArchitectureSearchResponse> getAppArchitectureResponseV1(
			ArchitectureSearchRequest architectureSearchRequest) {

		ArchitectureSearchResponse architectureSearchResponse = null;

		ArrayList<ArchitectureSearchResponse> arr = null;

		String suggestText = null;

		System.out.println("test the url:::"+elasticSearchEndPoint);
		RestHighLevelClient restClient = esClient(elasticSearchEndPoint,"us-west-2","es"); 

		SearchRequest searchRequest = new SearchRequest(index);

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

		SuggestionBuilder<?> termSuggestionBuilder = SuggestBuilders.completionSuggestion("suggest")
				.prefix(architectureSearchRequest.getArchitectureType().toLowerCase(),
						FuzzyOptions.builder().setFuzziness(Fuzziness.AUTO).build())
				.skipDuplicates(true);

		SuggestBuilder suggestBuilder = new SuggestBuilder();

		suggestBuilder.addSuggestion("suggest_architecture", termSuggestionBuilder);

		searchSourceBuilder.suggest(suggestBuilder);

		searchRequest.source(searchSourceBuilder);

		SearchResponse response;

		try {
			response = restClient.search(searchRequest, RequestOptions.DEFAULT);

			ObjectMapper objectMapper = new ObjectMapper();

			Suggest suggest = response.getSuggest();

			CompletionSuggestion entries = suggest.getSuggestion("suggest_architecture");

			for (CompletionSuggestion.Entry entry : entries) {

				arr = new ArrayList<ArchitectureSearchResponse>();

				for (CompletionSuggestion.Entry.Option option : entry.getOptions()) {

					suggestText = option.getText().string();

					architectureSearchResponse = objectMapper.readValue(option.getHit().getSourceAsString(),
							ArchitectureSearchResponse.class);

					architectureSearchResponse.setArchitecture(suggestText);

					arr.add(architectureSearchResponse);

					System.out.println(suggestText);
				}
			}
			restClient.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arr;

	}

	/**
	 * 
	 * @param generateTemplateRequest
	 * @param generateTemplateResponse
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws IOException
	 */
	private GenerateTemplateResponse generateTemplate(GenerateTemplateRequest generateTemplateRequest,
			GenerateTemplateResponse generateTemplateResponse)
			throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {

		TemplateGenerator templateGenerator = new TemplateGenerator();

		generateTemplateResponse = templateGenerator.execute(generateTemplateRequest);

		return generateTemplateResponse;

	}
	
	public static RestHighLevelClient esClient(String elasticSearchEndPoint, String region, String serviceName) {
        AWS4Signer signer = new AWS4Signer();
        signer.setServiceName(serviceName);
        signer.setRegionName(region);
        HttpRequestInterceptor interceptor = new SigningInterceptor(serviceName, signer, credentialsProvider);
        return new RestHighLevelClient(RestClient.builder(HttpHost.create(elasticSearchEndPoint)).setHttpClientConfigCallback(hacb -> hacb.addInterceptorLast(interceptor)));
    }
}

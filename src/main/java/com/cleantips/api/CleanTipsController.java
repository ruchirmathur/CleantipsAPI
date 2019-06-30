package com.cleantips.api;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.suggest.Suggest;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.SuggestionBuilder;
import org.elasticsearch.search.suggest.completion.CompletionSuggestion;
import org.elasticsearch.search.suggest.completion.FuzzyOptions;
import org.elasticsearch.search.suggest.completion.FuzzyOptions.Builder;
import org.elasticsearch.search.suggest.term.TermSuggestion;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequestInterceptor;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import com.amazonaws.auth.AWS4Signer;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.http.AWSRequestSigningApacheInterceptor;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.auth.AWS4Signer;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.cleantips.api.model.ApplicationServicesRequest;
import com.cleantips.api.model.ApplicationServicesResponse;
import com.cleantips.api.model.Appservices;
import com.cleantips.api.model.ArchitectureSearchRequest;
import com.cleantips.api.model.ArchitectureSearchResponse;
import com.cleantips.api.model.ArchitectureSearchResponse2;
import com.cleantips.api.model.Services;
import com.cleantips.template.TemplateGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CleanTipsController {

	private static String serviceName = "es";
	private static String region = "us-west-1";
	private static String aesEndpoint = "http://localhost:9200"; // e.g.
																	// https://search-mydomain.us-west-1.es.amazonaws.com
	private static String index = "services";
	private static String type = "_doc";
	private static String id = "1";

	static final AWSCredentialsProvider credentialsProvider = new DefaultAWSCredentialsProviderChain();

	@RequestMapping(value = "/getApplicationServices", method = RequestMethod.POST)
	public ApplicationServicesResponse getApplicationServices(@RequestBody ApplicationServicesRequest inputPayload)
			throws JsonProcessingException, NoSuchMethodException, SecurityException, ClassNotFoundException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		ApplicationServicesRequest applicationServicesRequest = inputPayload;

		ApplicationServicesResponse response = getAppArchitectureResponse(applicationServicesRequest);

		return response;
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getApplicationServicesv1", method = RequestMethod.POST)
	public ArrayList<ArchitectureSearchResponse2> getApplicationServicesV1(@RequestBody ArchitectureSearchRequest inputPayload)
			throws JsonProcessingException, NoSuchMethodException, SecurityException, ClassNotFoundException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		ArchitectureSearchRequest architectureSearchRequest = inputPayload;

		ArrayList<ArchitectureSearchResponse2> response = getAppArchitectureResponseV1(architectureSearchRequest);

		return response;
	}

	@RequestMapping(value = "/generateTemplate", method = RequestMethod.POST)
	public ApplicationServicesResponse generateTemplate(@RequestBody ApplicationServicesRequest inputPayload)
			throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {

		ApplicationServicesRequest applicationServicesRequest = inputPayload;

		ApplicationServicesResponse response = getAppArchitectureResponse(applicationServicesRequest);

		response = generateTemplates(response);

		return response;
	}

	private ApplicationServicesResponse getAppArchitectureResponse(
			ApplicationServicesRequest applicationServicesRequest) {

		ApplicationServicesResponse applicationServicesResponse = new ApplicationServicesResponse();

		AmazonDynamoDB dynamoDB = AmazonDynamoDBClientBuilder.standard().withRegion("us-east-1").build();

		DynamoDBMapper mapper = new DynamoDBMapper(dynamoDB);

		Appservices app = new Appservices();

		app.setArchitecture(applicationServicesRequest.getArchitectureType());

		Appservices ap = mapper.load(app);

		if (ap != null) {

			Collections.sort(ap.getServices());

			applicationServicesResponse.setAppServices(ap.getServices());

			applicationServicesResponse.setArchitecture(ap.getArchitecture());

			applicationServicesResponse.setArchitectureImage(ap.getArchitectureImage());

			applicationServicesResponse.setStatus("success");

		} else {

			applicationServicesResponse.setStatus("failure");
		}

		return applicationServicesResponse;

	}

	private ArrayList<ArchitectureSearchResponse2> getAppArchitectureResponseV1(
			ArchitectureSearchRequest architectureSearchRequest) {

		ArchitectureSearchResponse architectureSearchResponse = new ArchitectureSearchResponse();;

		ArchitectureSearchResponse2 architectureSearchResponse2 = null;

		RestHighLevelClient restClient = new RestHighLevelClient(RestClient.builder(HttpHost.create(aesEndpoint)));

		SearchRequest searchRequest = new SearchRequest(index);
		
		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

		SuggestionBuilder termSuggestionBuilder = SuggestBuilders.completionSuggestion("suggest")
				.prefix(architectureSearchRequest.getArchitectureType().toLowerCase(),FuzzyOptions.builder().setFuzziness(Fuzziness.AUTO).build()).skipDuplicates(true);

		SuggestBuilder suggestBuilder = new SuggestBuilder();

		suggestBuilder.addSuggestion("suggest_architecture", termSuggestionBuilder);

		searchSourceBuilder.suggest(suggestBuilder);

		searchRequest.source(searchSourceBuilder);

		SearchResponse response;

		ArrayList arr = null;

		try {
			response = restClient.search(searchRequest, RequestOptions.DEFAULT);
			
			 ObjectMapper objectMapper = new ObjectMapper();

			System.out.println(response);
			String suggestText = null;
			Suggest suggest = response.getSuggest();
			CompletionSuggestion entries = suggest.getSuggestion("suggest_architecture");

			for (CompletionSuggestion.Entry entry : entries) {
				
				arr = new ArrayList();
				
				for (CompletionSuggestion.Entry.Option option : entry.getOptions()) {

					suggestText = option.getText().string();
					
					architectureSearchResponse2 = objectMapper.readValue(option.getHit().getSourceAsString(), ArchitectureSearchResponse2.class);
					
					architectureSearchResponse2.setArchitecture(suggestText);
					
					arr.add(architectureSearchResponse2);

					System.out.println(suggestText);
				}
			}
			/*
			 * SearchHits hits = response.getHits();
			 * 
			 * String sourceAsString = null;
			 * 
			 * for (SearchHit hit : hits) {
			 * 
			 * arr = new ArrayList();
			 * 
			 * sourceAsString = hit.getSourceAsString();
			 * 
			 * arr.add(sourceAsString);
			 * 
			 * System.out.println(sourceAsString); }
			 */

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arr;

	}

	private ApplicationServicesResponse generateTemplates(ApplicationServicesResponse applicationServicesResponse)
			throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {

		TemplateGenerator templateGenerator = new TemplateGenerator();

		templateGenerator.execute(applicationServicesResponse.getAppServices());

		return applicationServicesResponse;

	}

	public static RestHighLevelClient esClient(String serviceName, String region) {
		AWS4Signer signer = new AWS4Signer();
		signer.setServiceName(serviceName);
		signer.setRegionName(region);
		HttpRequestInterceptor interceptor = new AWSRequestSigningApacheInterceptor(serviceName, signer,
				credentialsProvider);
		return new RestHighLevelClient(RestClient.builder(HttpHost.create(aesEndpoint))
				.setHttpClientConfigCallback(hacb -> hacb.addInterceptorLast(interceptor)));
	}
}

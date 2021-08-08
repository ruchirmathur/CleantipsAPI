/*
 * 
 */
package com.cleantips.api;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequestInterceptor;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.WriteRequest.RefreshPolicy;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.common.xcontent.XContentType;
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
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.AmazonCloudFormationClientBuilder;
import com.amazonaws.services.cloudformation.model.DescribeStacksRequest;
import com.amazonaws.services.cloudformation.model.DescribeStacksResult;
import com.amazonaws.services.cloudformation.model.Stack;
import com.amazonaws.services.comprehend.AmazonComprehend;
import com.amazonaws.services.comprehend.AmazonComprehendClientBuilder;
import com.amazonaws.services.comprehend.model.DetectEntitiesRequest;
import com.amazonaws.services.comprehend.model.DetectEntitiesResult;
import com.amazonaws.services.comprehend.model.DetectKeyPhrasesRequest;
import com.amazonaws.services.comprehend.model.DetectKeyPhrasesResult;
import com.amazonaws.services.comprehend.model.DetectSyntaxRequest;
import com.amazonaws.services.comprehend.model.DetectSyntaxResult;
import com.amazonaws.services.comprehend.model.SyntaxToken;
import com.amazonaws.util.StringUtils;
import com.cleantips.api.model.ArchitectureSearchRequest;
import com.cleantips.api.model.ArchitectureSearchResponse;
import com.cleantips.api.model.GenerateTemplateRequest;
import com.cleantips.api.model.GenerateTemplateResponse;
import com.cleantips.api.model.SaveArchitectureRequest;
import com.cleantips.api.model.Services;
import com.cleantips.api.model.StatusRequest;
import com.cleantips.api.model.StatusResponse;
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
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/templates", method = RequestMethod.POST, produces = "application/json")
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
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws IOException
	 * @throws InvocationTargetExceptio
	 */
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/services", method = RequestMethod.POST, produces = "application/json")
	public ArrayList<ArchitectureSearchResponse> getApplicationServicesV1(
			@RequestBody ArchitectureSearchRequest inputPayload)
			throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {

		ArchitectureSearchRequest architectureSearchRequest = inputPayload;

		SaveArchitectureRequest finalsaveArchitectureRequest = new SaveArchitectureRequest();

		ArchitectureSearchResponse res = new ArchitectureSearchResponse();

		ArrayList<ArchitectureSearchResponse> responses = new ArrayList();

		ArrayList<ArchitectureSearchResponse> response = getAppArchitectureResponseV1(architectureSearchRequest);

		com.cleantips.api.model.Suggest suggester = new com.cleantips.api.model.Suggest();

		ArrayList<com.cleantips.api.model.Suggest> suggest = new ArrayList<>();

		// System.out.println("response IN::::" + response);

		// ArrayList<Services> appServices = new ArrayList<>();

		ArrayList<Services> finalServices = new ArrayList<>();
		
		ArrayList<String> datalist = new ArrayList<String>();

		HashSet<Services> set = new HashSet<>();

		HashMap<String, Services> hash = new HashMap();
		Iterator hmIterator =null;
		// Set<Services> set = null;

		if (response==null || response.size() == 0) {

			LinkedList<String> text = getTextAnalysis(architectureSearchRequest.getArchitectureType());

			// HashMap ser = null ;

			for (String data : text) {

				 System.out.println("data:::::::::::::::::::::::::::::::::" + data);
				// System.out.println("getArchitectureType:::::::::::::::::::::::::::::::::" +
				 //architectureSearchRequest.getArchitectureType());
				SaveArchitectureRequest saveArchitectureRequest = readData(data,
						architectureSearchRequest.getArchitectureType());

				ArrayList<Services> appServices = saveArchitectureRequest.getAppServices();

				// System.out.println("srv size:::::::::::::::::::::::::::::::::" +
				// appServices.size());

				if (appServices != null) {
					// System.out.println("appServices size:::::::::::::::::::::::::::::::::" +
					// appServices.size());
					for (Services service : appServices) {

						hmIterator = service.getProperties().entrySet().iterator();

						Entry mapElement = null;
						
						if (hash.get(data)==null) {

						while (hmIterator.hasNext()) {

							mapElement = (Entry) hmIterator.next();
							
							// System.out.println("test the service:::::"+mapElement.getKey().toString());

							if (mapElement.getKey().toString().contains(data)) {

								// System.out.println("condition met"+mapElement.getKey().toString());
								
								 		datalist.add(mapElement.getKey().toString());
									
										service.getProperties().put(data, "test");
									
										break;

							

							}
						}
						}
						hash.put(service.getType(), service);
						
						
					}

				}

			}
			//System.out.println("key ::::" + architectureSearchRequest.getArchitectureType());
			Iterator hmIterators = hash.entrySet().iterator();

			ArrayList<Services> list = new ArrayList<>();

			Entry mapElement = null;

			while (hmIterators.hasNext()) {

				mapElement = (Entry) hmIterators.next();
				
				// hmIterator.remove();
				// ser.remove(data);
				Services s = (Services) mapElement.getValue();
				
				for (String test:datalist) {
					 System.out.println("check the test "+test);
					s.getProperties().remove(test);
					
					s.getProperties().put(test,"test");
				}
				
				// System.out.println("check the data "+s.getProperties());
				// service.setProperties(ser);
				list.add(s);
			}
			System.out.println("list ::::" + list.size());
			res.setArchitecture(architectureSearchRequest.getArchitectureType());

			res.setAppServices(list);

			res.setArchitectureImage("");

			suggester.setInput(architectureSearchRequest.getArchitectureType());

			suggester.setWeight(1);

			suggest.add(suggester);

			res.setSuggest(suggest);

			responses.add(res);

			if (list != null && list.size() > 0) {
				
				res.setId(RandomStringUtils.randomAlphabetic(10));

				saveDocument(res);

				return responses;

			}

		} else {

			return response;
		}

		return null;
	}

	private static <T> Predicate<T> distinctByKeys(Function<? super T, ?>... keyExtractors) {
		final Map<List<?>, Boolean> seen = new ConcurrentHashMap<>();

		return t -> {
			final List<?> keys = Arrays.stream(keyExtractors).map(ke -> ke.apply(t)).collect(Collectors.toList());

			return seen.putIfAbsent(keys, Boolean.TRUE) == null;
		};
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

		// System.out.println("test the url:::" + elasticSearchEndPoint);
		RestHighLevelClient restClient = esClient("https://search-cleansearch-cqqegf6joxwgbbx5hukpplj3m4.us-west-2.es.amazonaws.com", "us-west-2", "es");

		// System.out.println(architectureSearchRequest.getArchitectureType());

		SearchRequest searchRequest = new SearchRequest(index);

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

		SuggestBuilder suggestBuilder = new SuggestBuilder();

		SuggestionBuilder<?> termSuggestionBuilder = SuggestBuilders.completionSuggestion("suggest")
				.prefix(architectureSearchRequest.getArchitectureType().toLowerCase(),
						FuzzyOptions.builder().setFuzziness(Fuzziness.AUTO).build())
				.skipDuplicates(true);

		suggestBuilder.addSuggestion("suggest_architecture", termSuggestionBuilder);

		searchSourceBuilder.suggest(suggestBuilder);

		searchRequest.source(searchSourceBuilder);

		SearchResponse response;

		try {
			response = restClient.search(searchRequest, RequestOptions.DEFAULT);

			 //System.out.println("response:::" + response);

			ObjectMapper objectMapper = new ObjectMapper();

			Suggest suggest = response.getSuggest();

			CompletionSuggestion entries = suggest.getSuggestion("suggest_architecture");

			for (CompletionSuggestion.Entry entry : entries) {

				arr = new ArrayList<ArchitectureSearchResponse>();

				for (CompletionSuggestion.Entry.Option option : entry.getOptions()) {

					suggestText = option.getText().string();

					System.out.println("option.getHit().getSourceAsString()" +
					 option.getHit().getVersion());

					architectureSearchResponse = objectMapper.readValue(option.getHit().getSourceAsString(),
							ArchitectureSearchResponse.class);

					architectureSearchResponse.setArchitecture(suggestText);

					arr.add(architectureSearchResponse);

					// System.out.println(suggestText);
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
	
	private void saveDocument(@RequestBody ArchitectureSearchResponse inputPayload) throws IOException {

		RestHighLevelClient restClient = esClient("https://search-cleansearch-cqqegf6joxwgbbx5hukpplj3m4.us-west-2.es.amazonaws.com", "us-west-2", "es");

		IndexRequest request = new IndexRequest("services");
		
		request.type("_doc");

		ArchitectureSearchResponse saveArchitectureRequest = inputPayload;

		Map<String, Object> jsonMap = new HashMap();

		ObjectMapper objectMapper = new ObjectMapper();

		jsonMap.put("architectureImage", saveArchitectureRequest.getArchitectureImage());
		jsonMap.put("architecture", saveArchitectureRequest.getArchitecture());
		jsonMap.put("regionName", "test");
		jsonMap.put("appServices", saveArchitectureRequest.getAppServices());
		jsonMap.put("suggest", saveArchitectureRequest.getSuggest());

		String jsonInString = objectMapper.writeValueAsString(saveArchitectureRequest);
		
		 System.out.println("test::::jsonInString:"+saveArchitectureRequest.getAppServices().size());
		request.id(saveArchitectureRequest.getId());
		request.source(jsonInString, XContentType.JSON);
		// System.out.println("test::::dones:");

		IndexResponse response = restClient.index(request, RequestOptions.DEFAULT);
		// org.elasticsearch.action.support.master.AcknowledgedResponse
		// putMappingResponse = restClient.indices().putMapping(request,
		// RequestOptions.DEFAULT);
		
		UpdateRequest requests = new UpdateRequest("services", response.getId());
		
		//UpdateResponse re=restClient.update(requests, RequestOptions.DEFAULT);

		 System.out.println("test:::::" + response.getIndex());

		 System.out.println("test:::::" + response.getId());
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json")
	private void saveDocuments(@RequestBody ArchitectureSearchResponse inputPayload) throws IOException {

		RestHighLevelClient restClient = esClient("https://search-cleansearch-cqqegf6joxwgbbx5hukpplj3m4.us-west-2.es.amazonaws.com", "us-west-2", "es");
		ArchitectureSearchResponse saveArchitectureRequest = inputPayload;
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonInString = objectMapper.writeValueAsString(saveArchitectureRequest);
		UpdateRequest requests = new UpdateRequest("services", saveArchitectureRequest.getId());
		requests.doc(jsonInString, XContentType.JSON);
		requests.docAsUpsert(true);
		requests.upsert(jsonInString, XContentType.JSON);	
		UpdateResponse response = restClient.update(requests, RequestOptions.DEFAULT);

	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getstatus", method = RequestMethod.POST, produces = "application/json")
	private StatusResponse Status(@RequestBody StatusRequest inputPayload) throws IOException {

		StatusRequest statusRequest = inputPayload;

		StatusResponse statusResponse = new StatusResponse();

		AmazonCloudFormation awssCFTClient = AmazonCloudFormationClientBuilder.defaultClient();

		DescribeStacksRequest describeStack = new DescribeStacksRequest();
		describeStack.setStackName(statusRequest.getTemplateName());

		DescribeStacksResult rs = awssCFTClient.describeStacks();

		for (Stack st : rs.getStacks()) {

			if (statusRequest != null && statusRequest.getTemplateName().equalsIgnoreCase(st.getStackName())) {
				statusResponse.setStatus(st.getStackStatus());

				System.out.println("getStackName:::::" + st.getStackName());
				System.out.println("test:::::" + st.getStackStatus());

				break;
			}
		}

		return statusResponse;

	}

	public static RestHighLevelClient esClient(String elasticSearchEndPoint, String region, String serviceName) {
		AWS4Signer signer = new AWS4Signer();
		signer.setServiceName(serviceName);
		signer.setRegionName(region);
		HttpRequestInterceptor interceptor = new SigningInterceptor(serviceName, signer, credentialsProvider);
		return new RestHighLevelClient(RestClient.builder(HttpHost.create("https://search-cleansearch-cqqegf6joxwgbbx5hukpplj3m4.us-west-2.es.amazonaws.com"))
				.setHttpClientConfigCallback(hacb -> hacb.addInterceptorLast(interceptor)));
	}

	private LinkedList<String> getTextAnalysis(String architectureType) {

		AmazonComprehend comprehend = AmazonComprehendClientBuilder.defaultClient();

		LinkedList<String> textList = new LinkedList<>();

		DetectSyntaxRequest detect = new DetectSyntaxRequest().withText(architectureType).withLanguageCode("en");

		DetectSyntaxResult result = comprehend.detectSyntax(detect);

		// result.getSyntaxTokens().forEach(System.out::println);

		for (SyntaxToken token : result.getSyntaxTokens()) {

			if (token.getPartOfSpeech().getTag() != null && (token.getPartOfSpeech().getTag().equalsIgnoreCase("NOUN")
					|| token.getPartOfSpeech().getTag().equalsIgnoreCase("PROPN"))) {

				textList.add(token.getText());

			}

		}

		return textList;

	}

	private ArrayList<String> putMessage(ArrayList messages) {

		return messages;

	}

	private SaveArchitectureRequest readData(String data, String dataFirst) {

		com.cleantips.api.model.Suggest suggester = new com.cleantips.api.model.Suggest();

		suggester.setInput(dataFirst);

		SaveArchitectureRequest saveArchitectureRequest = new SaveArchitectureRequest();

		ArchitectureSearchResponse architectureSearchResponse = null;

		ArrayList<SaveArchitectureRequest> arr = null;

		String suggestText = null;

		// System.out.println("data::::::::"+data);

		// System.out.println("test the url:::" + elasticSearchEndPoint);
		RestHighLevelClient restClient = esClient("https://search-cleansearch-cqqegf6joxwgbbx5hukpplj3m4.us-west-2.es.amazonaws.com", "us-west-2", "es");

		SearchRequest searchRequest = new SearchRequest(index);

		SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

		SuggestBuilder suggestBuilder = new SuggestBuilder();

		SuggestionBuilder<?> termSuggestionBuilder = SuggestBuilders.completionSuggestion("suggest")
				.prefix(data.toLowerCase(), FuzzyOptions.builder().setFuzziness(Fuzziness.AUTO).build())
				.skipDuplicates(true);

		suggestBuilder.addSuggestion("suggest_architecture", termSuggestionBuilder);

		searchSourceBuilder.suggest(suggestBuilder);

		searchRequest.source(searchSourceBuilder);

		SearchResponse response;

		ArrayList<Services> namesList = null;

		HashSet<Services> hashSet = null;

		try {
			response = restClient.search(searchRequest, RequestOptions.DEFAULT);

			ObjectMapper objectMapper = new ObjectMapper();

			Suggest suggest = response.getSuggest();

			CompletionSuggestion entries = suggest.getSuggestion("suggest_architecture");

			for (CompletionSuggestion.Entry entry : entries) {

				arr = new ArrayList<SaveArchitectureRequest>();

				for (CompletionSuggestion.Entry.Option option : entry.getOptions()) {

					suggestText = option.getText().string();

					architectureSearchResponse = objectMapper.readValue(option.getHit().getSourceAsString(),
							ArchitectureSearchResponse.class);

					hashSet = new HashSet(architectureSearchResponse.getAppServices());

					namesList = new ArrayList<>(hashSet);

					saveArchitectureRequest.setAppServices(architectureSearchResponse.getAppServices());

					arr.add(saveArchitectureRequest);

					break;
				}
			}
			restClient.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return saveArchitectureRequest;

	}

}

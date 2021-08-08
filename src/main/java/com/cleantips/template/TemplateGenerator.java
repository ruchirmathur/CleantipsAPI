package com.cleantips.template;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.util.StringUtils;

import com.amazonaws.services.cloudformation.AmazonCloudFormation;
import com.amazonaws.services.cloudformation.AmazonCloudFormationClientBuilder;
import com.amazonaws.services.cloudformation.model.Capability;
import com.amazonaws.services.cloudformation.model.CreateStackRequest;
import com.amazonaws.services.cloudformation.model.DescribeStacksResult;
import com.amazonaws.services.cloudformation.model.EstimateTemplateCostResult;
import com.amazonaws.services.cloudformation.model.ValidateTemplateRequest;
import com.amazonaws.services.cloudformation.model.ValidateTemplateResult;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.cloudformation.model.*;
import com.cleantips.api.model.GenerateTemplateRequest;
import com.cleantips.api.model.GenerateTemplateResponse;
import com.cleantips.api.model.Services;
import com.cleantips.api.model.StackProperties;
import com.cleantips.api.model.TemplateProperties;
import com.cleantips.model.Outputs;
import com.cleantips.model.Parameters;
import com.cleantips.model.Properties;
import com.cleantips.model.Stack;
import com.cleantips.model.Template;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The Class TemplateGenerator.
 */
public class TemplateGenerator {

	/**
	 * Execute.
	 *
	 * @param request the request
	 * @return the generate template response
	 * @throws NoSuchMethodException     the no such method exception
	 * @throws SecurityException         the security exception
	 * @throws ClassNotFoundException    the class not found exception
	 * @throws InstantiationException    the instantiation exception
	 * @throws IllegalAccessException    the illegal access exception
	 * @throws IllegalArgumentException  the illegal argument exception
	 * @throws InvocationTargetException the invocation target exception
	 * @throws IOException               Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("rawtypes")
	public GenerateTemplateResponse execute(GenerateTemplateRequest request) {

		GenerateTemplateResponse generateTemplateResponse = new GenerateTemplateResponse();

		String bucketName = null;

		ArrayList<String> bucketList = new ArrayList<String>();
		
		TemplateProperties templateProperties =null;
		
		StackProperties stackProperties = null;
		
		StackProperties mainStackProperties = new StackProperties();
		
		TemplateProperties mainTemplate =new TemplateProperties();

		String json = null;

		String region = null;

		try {

			if (request != null && request.getAppServices() != null && request.getAppServices().size() > 0) {

				region = request.getRegion();

				Template template = new Template();
				
				ArrayList<TemplateProperties> arr= new ArrayList();

				HashMap output = createServices(request.getAppServices());
				
			     Iterator hashIterator = output.entrySet().iterator();
			     
			     while (hashIterator.hasNext()) { 
			            Map.Entry mapElement = (Map.Entry)hashIterator.next(); 
			            HashMap hash = ((HashMap)mapElement.getValue()); 
			            Iterator hashIterators = hash.entrySet().iterator();
			            System.out.println("mapElement::::::::::"+mapElement.getKey() + " : " + hash); 
			        	templateProperties = new TemplateProperties();
			        	stackProperties = new StackProperties();
			        	
			        	templateProperties.setStackName(mapElement.getKey().toString());
			            while (hashIterators.hasNext()) { 
			            	
			            	Map.Entry mapElements = (Map.Entry)hashIterators.next(); 
			            	String serviceDetails = ((String)mapElements.getValue());
			            	
			            
			            	if (mapElements.getKey()!=null && mapElements.getKey().toString().equalsIgnoreCase("TemplateUrl")) {
			            		
			            		stackProperties.setTemplateURL(serviceDetails);
			            	}
			        
			            	
			            	
			            	System.out.println("New::::::::::"+mapElements.getKey() + " : " + serviceDetails); 
			            }
			            templateProperties.setStack(stackProperties);
			            arr.add(templateProperties);
			        } 
				


				if (output != null) {

					template = generateTemplateVersion(template);

					template = generateResources(template, request.getAppServices(), output);

					template = generateParameters(template);

					template = generateOutput(template, request.getAppServices(), output);

					template = generateMappings(template);

					template = generateConditions(template);

					ObjectMapper objectMapper = new ObjectMapper();

					File file = new File("stack");

					json = objectMapper.writeValueAsString(template);

					System.out.println(json);

					objectMapper.writeValue(file, template);

					bucketName = Util.getBucketLocation(null, region, file, request.getArchitecture());
					
					mainStackProperties.setTemplateURL(bucketName);
					
					mainTemplate.setStack(mainStackProperties);
					
					mainTemplate.setStackName("PrimaryStack");

					generateTemplateResponse.setStatus("Success");
					
					arr.add(mainTemplate);

					generateTemplateResponse.setTemplateProperties(arr);
					
					String costUrl = generateArchitecture(bucketName, request.getArchitecture());
					
					generateTemplateResponse.setCostUrl(costUrl);

				} else {
					generateTemplateResponse.setStatus("Failure");

					generateTemplateResponse.setTemplateProperties(null);
				}

			} else {

				generateTemplateResponse.setTemplateProperties(null);

				generateTemplateResponse.setStatus("Failure");
			}
		} catch (Exception ex) {

			ex.printStackTrace();

			generateTemplateResponse.setStatus("Failure");
			
			generateTemplateResponse.setDescription(ex.getMessage());

		}
		return generateTemplateResponse;
	}

	/**
	 * Generate template version.
	 *
	 * @param template the template
	 * @return the template
	 */
	private static Template generateTemplateVersion(Template template) {

		template.setAWSTemplateFormatVersion("2010-09-09");

		return template;

	}

	/**
	 * Generate parameters.
	 *
	 * @param template the template
	 * @return the template
	 */
	private static Template generateParameters(Template template) {

		Parameters parameters = new Parameters();

		template.setParameters(parameters);

		return template;

	}

	/**
	 * Generate mappings.
	 *
	 * @param template the template
	 * @return the template
	 */
	private static Template generateMappings(Template template) {
		return template;

	}

	/**
	 * Generate conditions.
	 *
	 * @param template the template
	 * @return the template
	 */
	private static Template generateConditions(Template template) {
		return template;

	}

	/**
	 * Generate resources.
	 *
	 * @param <T>      the generic type
	 * @param template the template
	 * @param services the services
	 * @param output   the output
	 * @return the template
	 */
	private static Template generateResources(Template template, ArrayList<Services> services, HashMap output) {

		HashMap<String, Stack> res = new HashMap<String, Stack>();

		Properties properties = null;

		Parameters parameters = null;

		ArrayList list = null;

		Stack stack = null;

		HashMap<String, Object> map = new HashMap();

		HashMap<String, Object> maps = null;

		String templateUrl = null;

		for (Services srv : services) {

			stack = new Stack();

			properties = new Properties();

			parameters = new Parameters();

			templateUrl = new String();

			HashMap<String, String> out = (HashMap<String, String>) output.get(srv.getType() + "Stack");

			if (out != null) {
				for (Map.Entry<String, String> entry : out.entrySet()) {

					System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

					if (entry.getKey().equalsIgnoreCase("TemplateUrl")) {

						templateUrl = entry.getValue();
					}

				}
			}
			properties.setTemplateURL(templateUrl);

			HashMap<String, HashMap> outputs = (HashMap) output.get(srv.getDependentOn() + "Stack");

			System.out.println("actual service:::" + srv.getType());
			System.out.println("actual service::dependent on:" + srv.getDependentOn());
			if (outputs != null) {

				for (Map.Entry<String, HashMap> entry : outputs.entrySet()) {
					System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

					list = new ArrayList<String>();

					maps = new HashMap<String, Object>();

					list.add(srv.getDependentOn().concat("Stack"));

					list.add(entry.getValue());

					maps.put("Fn::GetAtt", list);

					map.put(entry.getKey(), maps);

					map.remove("TemplateUrl");
					map.remove("Service");

					properties.setParameters(map);
				}

			}

			properties.setTimeoutInMinutes("60");

			stack.setProperties(properties);

			res.put(srv.getType() + "Stack", stack);

		}

		template.setResources(res);

		return template;

	}

	/**
	 * Generate output.
	 *
	 * @param <T>      the generic type
	 * @param template the template
	 * @param services the services
	 * @param output   the output
	 * @return the template
	 */
	private static Template generateOutput(Template template, ArrayList<Services> services, HashMap<?, ?> output) {

		Outputs outputs = new Outputs();

		HashMap<String, Stack> res = new HashMap();

		ArrayList list = null;

		Stack stack = null;

		HashMap<String, Object> map = new HashMap();

		HashMap<String, Object> maps = null;

		HashMap<String, Object> valueMaps = null;

		String templateUrl = null;

		for (Services srv : services) {

			HashMap<String, HashMap> out = (HashMap) output.get(srv.getType() + "Stack");

			System.out.println("actual service:::" + srv.getType());
			System.out.println("actual service::dependent on:" + srv.getDependentOn());
			if (out != null) {

				for (Map.Entry<String, HashMap> entry : out.entrySet()) {
					System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

					list = new ArrayList();

					maps = new HashMap();

					valueMaps = new HashMap();

					list.add(srv.getType().concat("Stack"));

					list.add(entry.getValue());

					maps.put("Fn::GetAtt", list);

					valueMaps.put("Value", maps);

					map.put(entry.getKey(), valueMaps);

					map.remove("TemplateUrl");
					map.remove("Service");

				}

			}

		}
		template.setOutputs(map);

		return template;

	}

	/**
	 * Creates the services.
	 *
	 * @param services the services
	 * @return the hash map
	 * @throws NoSuchMethodException     the no such method exception
	 * @throws SecurityException         the security exception
	 * @throws ClassNotFoundException    the class not found exception
	 * @throws InstantiationException    the instantiation exception
	 * @throws IllegalAccessException    the illegal access exception
	 * @throws IllegalArgumentException  the illegal argument exception
	 * @throws InvocationTargetException the invocation target exception
	 */
	private static HashMap<String, HashMap<?, ?>> createServices(ArrayList<Services> services) {

		HashMap<String, HashMap<?, ?>> output = new HashMap<String, HashMap<?, ?>>();
		
		HashMap<String, HashMap> serviceParam = new HashMap<String, HashMap>();

		try {

			for (Services srv : services) {

				if (srv != null && !StringUtils.isEmpty(srv.getType())) {
					
					System.out.println("temp::::"+"com.cleantips." + srv.getType().toLowerCase() + ".generator."
							+ srv.getType() + "TemplateGenerator");

					Class<?> cls = Class.forName("com.cleantips." + srv.getType().toLowerCase() + ".generator."
							+ srv.getType() + "TemplateGenerator");

					Object obj = cls.newInstance();

					ConcurrentHashMap<?, ?> map = srv.getProperties();

					Method method = cls.getDeclaredMethod("execute", ConcurrentHashMap.class, String.class, HashMap.class);
					
					
					System.out.println("srv.getType():::::"+srv.getType());
					
					System.out.println("srv.serviceParam():::::"+serviceParam);

					HashMap<?, ?> serviceOutput = (HashMap<?, ?>) method.invoke(obj, map, srv.getType(),serviceParam);

					
					if (serviceOutput!=null) {
						
						for (Entry<?, ?> entry : serviceOutput.entrySet()) {
							System.out.println("test:::::"+entry.getKey());
							HashMap maps = new HashMap();
							maps.put("Type", "String");
							maps.put("Description", "test");
							serviceParam.put((String) entry.getKey(), maps);
							serviceParam.remove("TemplateUrl");
						}
						
						
					}
					
					output.put(srv.getType().concat("Stack"), serviceOutput);

				} else {
					output = null;
					break;
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return output;

	}

	private static String generateArchitecture(String bucketName, String architect) {
		
		AmazonCloudFormation awssCFTClient = AmazonCloudFormationClientBuilder.defaultClient();
		CreateStackRequest createStackRequest = new CreateStackRequest();
	    createStackRequest.setStackName(architect);
	    createStackRequest.setTemplateURL(bucketName);
	    awssCFTClient.createStack(createStackRequest);
	    
	    EstimateTemplateCostRequest cost = new EstimateTemplateCostRequest();
	    cost.setTemplateURL(bucketName);
	    EstimateTemplateCostResult result = awssCFTClient.estimateTemplateCost(cost);
	    System.out.println("test the cost:::"+result.getUrl());  
	    
	    return result.getUrl();
	}
}
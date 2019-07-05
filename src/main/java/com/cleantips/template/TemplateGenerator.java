package com.cleantips.template;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.cleantips.api.model.GenerateTemplateRequest;
import com.cleantips.api.model.GenerateTemplateResponse;
import com.cleantips.api.model.Services;
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

		String json = null;

		String region = null;

		try {

			if (request != null && request.getAppServices() != null && request.getAppServices().size() > 0) {

				region = request.getRegion();

				Template template = new Template();

				HashMap output = createServices(request.getAppServices());

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

					bucketName = Util.getBucketLocation(null, region, file, "stack");

					bucketList.add(bucketName);

					generateTemplateResponse.setStatus("Success");

					generateTemplateResponse.setTemplateUrls(bucketList);

				} else {
					generateTemplateResponse.setStatus("Failure");

					generateTemplateResponse.setTemplateUrls(null);
				}

			} else {

				generateTemplateResponse.setTemplateUrls(null);

				generateTemplateResponse.setStatus("Failure");
			}
		} catch (Exception ex) {

			ex.printStackTrace();

			generateTemplateResponse.setStatus("Failure");

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

		try {

			for (Services srv : services) {

				if (srv != null && !StringUtils.isEmpty(srv.getType())) {
					
					System.out.println("temp::::"+"com.cleantips." + srv.getType().toLowerCase() + ".generator."
							+ srv.getType() + "TemplateGenerator");

					Class<?> cls = Class.forName("com.cleantips." + srv.getType().toLowerCase() + ".generator."
							+ srv.getType() + "TemplateGenerator");

					Object obj = cls.newInstance();

					HashMap<?, ?> map = srv.getProperties();

					Method method = cls.getDeclaredMethod("execute", HashMap.class, String.class);

					HashMap<?, ?> serviceOutput = (HashMap<?, ?>) method.invoke(obj, map, srv.getType());

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

}
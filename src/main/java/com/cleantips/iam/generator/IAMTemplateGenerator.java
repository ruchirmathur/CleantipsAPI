/*
 * 
 */
package com.cleantips.iam.generator;

import java.io.File;
import java.util.HashMap;

import com.amazonaws.util.StringUtils;
import com.cleantips.iam.base.model.Parameters;
import com.cleantips.iam.base.model.Resources;
import com.cleantips.iam.base.model.Template;
import com.cleantips.iam.group.model.Group;
import com.fasterxml.jackson.databind.ObjectMapper;

// TODO: Auto-generated Javadoc
/**
 * The Class IAMTemplateGenerator.
 */
public class IAMTemplateGenerator {

	/**
	 * Execute method is the primary method that generates the Cloudformation
	 * template for a service.
	 *
	 * @param propertyMap the property map
	 * @param type the type
	 * @return the hash map
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public HashMap<?, ?> execute(HashMap<?, ?> propertyMap, String type) {

		System.out.println("in the rote");

		String bucketName = null;

		ObjectMapper objectMapper = null;

		HashMap outputMap = new HashMap();

		try {

			if (propertyMap != null && propertyMap.size() > 0 && !StringUtils.isNullOrEmpty(type)) {

				Template template = new Template();

				generateTemplateVersion(template, propertyMap);

				generateDescription(template, propertyMap);

				generateParameters(template, propertyMap);

				generateResources(template, propertyMap);

				generateMappings(template, propertyMap);

				generateConditions(template, propertyMap);

				objectMapper = new ObjectMapper();

				File file = new File(type);

				String json = objectMapper.writeValueAsString(template);

				System.out.println(json);

				objectMapper.writeValue(file, template);

				bucketName = Util.getBucketLocation(propertyMap, file, type);

				generateOutput(template, propertyMap, outputMap, bucketName);

			} else {

				outputMap = null;
			}
		} catch (Exception ex) {

			ex.printStackTrace();

			outputMap.put("TemplateUrl", null);
			outputMap.put("Status", "Failure");
			outputMap.put("Message", ex.getMessage());

		}
		return outputMap;

	}

	/**
	 * Generate template version.
	 *
	 * @param template the template
	 * @param propertyMap the property map
	 */
	private static void generateTemplateVersion(Template template, HashMap<?,?> propertyMap) {

		template.setAWSTemplateFormatVersion("2010-09-09");

	}


	/**
	 * Generate description.
	 *
	 * @param template the template
	 * @param propertyMap the property map
	 */
	private static void generateDescription(Template template, HashMap<?, ?> propertyMap) {

		if (propertyMap.get("architecture") != null) {

			template.setDescription(propertyMap.get("architecture").toString());

		}

	}

	/**
	 * Generate parameters.
	 *
	 * @param template the template
	 * @param propertyMap the property map
	 */
	private static void generateParameters(Template template, HashMap<?, ?> propertyMap) {

		Parameters parameters = new Parameters();

		template.setParameters(parameters);

	}

	/**
	 * Generate mappings.
	 *
	 * @param template the template
	 * @param propertyMap the property map
	 */
	private static void generateMappings(Template template, HashMap<?, ?> propertyMap) {

	}

	/**
	 * Generate conditions.
	 *
	 * @param template the template
	 * @param propertyMap the property map
	 */
	private static void generateConditions(Template template, HashMap<?, ?> propertyMap) {

	}

	/**
	 * Generate conditions.
	 *
	 * @param template the template
	 */
	private static void generateConditions(Template template) {

	}

	/**
	 * Generate resources.
	 *
	 * @param <T> the generic type
	 * @param template the template
	 * @param propertyMap the property map
	 */
	private static void generateResources(Template template, HashMap<?,?> propertyMap) {

		Group group = Util.createGroup(propertyMap);

		Resources resources = new Resources();

		resources.setGroup(group);

		template.setResources(resources);

	}

	/**
	 * Generate output.
	 *
	 * @param template    the template
	 * @param propertyMap the property map
	 * @param outputMap the output map
	 * @param templateUrl the template url
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void generateOutput(Template template, HashMap<?, ?> propertyMap, HashMap outputMap,
			String templateUrl) {

		outputMap.put("TemplateUrl", templateUrl);
	}


}

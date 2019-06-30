package com.cleantips.iam.generator;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.cleantips.iam.base.model.Parameter;
import com.cleantips.iam.base.model.Parameters;
import com.cleantips.iam.base.model.Resources;
import com.cleantips.iam.base.model.Template;
import com.cleantips.iam.group.model.Group;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IAMTemplateGenerator {

	public HashMap execute(HashMap map, String type) throws IOException {
		
		String region = "us-east-1a";
		
		HashMap output= new HashMap();
		
		Template template = new Template();

		generateTemplateVersion(template);
		
		generateDescription(template,map);
		
		generateParameters(template,region,map);

//		template = generateResources(template,region,map);

		generateOutput(template,output);

		//template = generateMappings(template);

		///template = generateConditions(template);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		File file = new File("iam.json");
		
		String json = objectMapper.writeValueAsString(template);
		
		System.out.println(json);
		
		objectMapper.writeValue(file,template);
		
		return output;

	}

	private static void generateTemplateVersion(Template template) {

		template.setAWSTemplateFormatVersion("2010-09-09");

	}
	private static void generateDescription(Template template, HashMap map) {

		//template.setDescription(map.get("architecture").toString());

	}

	private static void generateParameters(Template template, String region, HashMap map) {

		Parameters parameters = new Parameters();
		
		Parameter parameter = new Parameter();
		
	

		template.setParameters(parameters);

	}

	private static void generateMappings(Template template) {

	}

	private static void generateConditions(Template template) {

	}

	private static <T> void generateResources(Template template,String regionName, HashMap map) {
		
		Group group = Util.createGroup(map);
		
		Resources resources= new Resources();
		
		resources.setGroup(group);
		
		template.setResources(resources);

	}

	private static void generateOutput(Template template,HashMap map) {

	}

}

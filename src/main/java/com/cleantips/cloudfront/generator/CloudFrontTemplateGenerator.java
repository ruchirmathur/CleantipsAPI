package com.cleantips.cloudfront.generator;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import com.cleantips.cloudfront.base.model.Parameters;
import com.cleantips.cloudfront.base.model.Resources;
import com.cleantips.cloudfront.base.model.Template;
import com.cleantips.cloudfront.distribution.model.Distribution;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CloudFrontTemplateGenerator {

	public HashMap execute(ConcurrentHashMap map,String type,HashMap paramMap) throws IOException {
		System.out.println("In CT");
		String region = "us-east-1a";
		
		HashMap output = new HashMap();
		
		Template template = new Template();

		generateTemplateVersion(template);
		
		generateDescription(template,map);
		
		generateParameters(template,region,map,paramMap);

		generateResources(template,region,map,paramMap);

		//template = generateMappings(template);

		///template = generateConditions(template);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		File file = new File(type);
		
		System.out.println("getDistribution::"+template.getResources().getDistribution().getType());
		
		String json = objectMapper.writeValueAsString(template);
		
		System.out.println(json);
		
		objectMapper.writeValue(file,template);
		
		String bucketName = Util.getBucketLocation(map,region,file,type);
		
		generateOutput(template,output,bucketName);
		
		System.out.println(output.get("TemplateUrl").toString());
		
		output.put("Service", "Cloudfront");
		
		return output;

	}

	private static void generateTemplateVersion(Template template) {

		template.setAWSTemplateFormatVersion("2010-09-09");

	}
	private static void generateDescription(Template template, ConcurrentHashMap map) {

		template.setDescription(map.get("architecture").toString());

	}

	private static void generateParameters(Template template, String region, ConcurrentHashMap map,HashMap paramMap) {

		HashMap parameters = new HashMap();
		
		paramMap.remove("Service");
		
		parameters = paramMap;
		
		
		template.setParameters(parameters);

	}

	private static void generateMappings(Template template) {

	}

	private static void generateConditions(Template template) {

	}

	private static <T> void generateResources(Template template,String regionName, ConcurrentHashMap map,HashMap paramMap) {
		
		Distribution distribution = Util.createDistribution(map, regionName,paramMap);
	
		Resources resources= new Resources();
		
		resources.setDistribution(distribution);
		
		template.setResources(resources);
		
		System.out.println("In generateDistributionProperties"+template.getResources().getDistribution().getProperties().getDistributionConfig().getRestrictions());

	}

	private static void generateOutput(Template template, HashMap map, String templateUrl) {
		System.out.println("ecstemplatess::"+templateUrl);
		map.put("TemplateUrl", templateUrl);
	}

}

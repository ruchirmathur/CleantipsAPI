package com.cleantips.s3.generator;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.cleantips.cloudfront.base.model.Parameters;
import com.cleantips.cloudfront.base.model.Resources;
import com.cleantips.cloudfront.base.model.Template;
import com.cleantips.cloudfront.distribution.model.Distribution;
import com.cleantips.s3.bucket.model.Bucket;
import com.fasterxml.jackson.databind.ObjectMapper;

public class S3TemplateGenerator {

	public HashMap execute(HashMap map,String type) throws IOException {
		
		String region = "us-east-1a";
		
		HashMap output = new HashMap();
		
		Template template = new Template();

		generateTemplateVersion(template);
		
		generateDescription(template,map);
		
		generateParameters(template,region,map);

		generateResources(template,region,map);

		//template = generateMappings(template);

		///template = generateConditions(template);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		File file = new File(type);
		
		String json = objectMapper.writeValueAsString(template);
		
		System.out.println(json);
		
		objectMapper.writeValue(file,template);
		
		//String bucketName = Util.getBucketLocation(map,region,file,type);
		
		//generateOutput(template,output,bucketName);
		
		System.out.println(output.get("TemplateUrl").toString());
		
		return output;

	}

	private static void generateTemplateVersion(Template template) {

		template.setAWSTemplateFormatVersion("2010-09-09");

	}
	private static void generateDescription(Template template, HashMap map) {

		template.setDescription(map.get("architecture").toString());

	}

	private static void generateParameters(Template template, String region, HashMap map) {

		Parameters parameters = new Parameters();
		
		template.setParameters(parameters);

	}

	private static void generateMappings(Template template) {

	}

	private static void generateConditions(Template template) {

	}

	private static <T> void generateResources(Template template,String regionName, HashMap map) {
		
		Bucket bucket = Util.createBucket(map, regionName);
	
		Resources resources= new Resources();
		
	//	resources.setDistribution(distribution);
		
		template.setResources(resources);

	}

	private static void generateOutput(Template template, HashMap map, String templateUrl) {
		System.out.println("ecstemplatess::"+templateUrl);
		map.put("TemplateUrl", templateUrl);
	}

}

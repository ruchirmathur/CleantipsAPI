package com.cleantips.s3.generator;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.cleantips.s3.base.model.Parameters;
import com.cleantips.s3.base.model.Resources;
import com.cleantips.s3.base.model.Template;
import com.cleantips.s3.bucket.model.Bucket;
import com.fasterxml.jackson.databind.ObjectMapper;

public class S3TemplateGenerator {

	public HashMap execute(HashMap map,String type) {
		
		HashMap output = new HashMap();
		
		try {
		
		String region = "us-east-1a";
		
		
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
		
		String bucketName = Util.getBucketLocation(map,region,file,type);
		
		generateOutput(template,output,bucketName);
		
		}catch( Exception ex) {
			ex.printStackTrace();
		}
		
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
		
		//resources.setDistribution(distribution);
		
	//	resources.setDistribution(distribution);
		
		template.setResources(resources);

	}

	private static void generateOutput(Template template, HashMap map, String templateUrl) {
		System.out.println("ecstemplatess::"+templateUrl);
		map.put("TemplateUrl", templateUrl);
	}

}

package com.cleantips.s3.generator;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.cleantips.s3.base.model.Parameters;
import com.cleantips.s3.base.model.Resources;
import com.cleantips.s3.base.model.Template;
import com.cleantips.s3.bucket.model.Bucket;
import com.cleantips.s3.bucket.model.Ref;
import com.cleantips.s3.base.model.Outputs;
import com.cleantips.s3.base.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class S3TemplateGenerator {

	public HashMap execute(ConcurrentHashMap map, String type,HashMap paramMap) {

		HashMap output = new HashMap();

		try {

			String region = "us-east-1";

			Template template = new Template();

			generateTemplateVersion(template);

			generateDescription(template, map);

			generateParameters(template, region, map);

			generateResources(template, region, map);
			
			generateOutput(template, output);

			ObjectMapper objectMapper = new ObjectMapper();

			File file = new File(type);

			String json = objectMapper.writeValueAsString(template);

			System.out.println(json);

			objectMapper.writeValue(file, template);

			System.out.println(region);

			String bucketName = Util.getBucketLocation(map, region, file, type);
			
			output.put("TemplateUrl", bucketName);
			output.put("Service", "S3");


		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return output;

	}

	private static void generateTemplateVersion(Template template) {

		template.setAWSTemplateFormatVersion("2010-09-09");

	}

	private static void generateDescription(Template template, ConcurrentHashMap map) {

		template.setDescription(map.get("architecture").toString());

	}

	private static void generateParameters(Template template, String region, ConcurrentHashMap map) {

		Parameters parameters = new Parameters();


	}

	private static void generateMappings(Template template) {

	}

	private static void generateConditions(Template template) {

	}

	private static <T> void generateResources(Template template, String regionName, ConcurrentHashMap map) {

		Bucket bucket = Util.createBucket(map, regionName);

		Resources resources = new Resources();

		resources.setBucket(bucket);

		template.setResources(resources);

	}

	private static void generateOutput(Template template, HashMap map) {

		Outputs outputs = new Outputs();
		
		Map bucketMap=new HashMap();

		Ref bucket = new Ref();
		
		bucket.setRef("Bucket");
		
		bucketMap.put("Value", bucket);
		
		map.put("Bucket", "Outputs.Bucket");
		
		outputs.setBucket(bucketMap);

		template.setOutputs(outputs);
	}

}

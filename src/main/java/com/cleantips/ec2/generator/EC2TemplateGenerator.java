package com.cleantips.ec2.generator;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.cleantips.ec2.base.model.Parameters;
import com.cleantips.ec2.base.model.Resources;
import com.cleantips.ec2.base.model.Template;
import com.cleantips.ec2.instance.model.Instance;
import com.cleantips.ec2.instance.model.Parameter;
import com.cleantips.vpc.eip.model.EIP;
import com.cleantips.vpc.gateway.model.VpcGateway;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EC2TemplateGenerator {

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
		
		String bucketName = Util.getBucketLocation(map,region,file,type);
		
		generateOutput(template,output,bucketName);
		
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
		
		Parameter instanceType = Util.createInstanceTypeParameter(region,map);
		
		parameters.setInstanceType(instanceType);
		
		Parameter internetGaetway = Util.createInternetGatewayParameter(region,map);
		
		parameters.setInternetGateway(internetGaetway);
		
		Parameter vpc = Util.createVpcParameter(region,map);
		
		parameters.setVPC(vpc);
		
		Parameter subnet = Util.createSubnetParameter(region,map);
		
		parameters.setSubnet(subnet);
		
		Parameter securityGroup = Util.createSecurityGroupParameter(region,map);
		
		parameters.setSecurityGroup(securityGroup);
		
		Parameter imageType=Util.createImageTypeParameter(map);
		
		parameters.setImageType(imageType);
		
		Parameter keyType=Util.createKeyNameParameter(map);
		
		parameters.setKeyName(keyType);

		template.setParameters(parameters);

	}

	private static void generateMappings(Template template) {

	}

	private static void generateConditions(Template template) {

	}

	private static <T> void generateResources(Template template,String regionName, HashMap map) {
		
		Instance instance = Util.createInstance(regionName,map);
		
		EIP eip = Util.createEip(regionName,map);
		
		VpcGateway gateway = Util.createGateway(regionName,map);
		
		Resources resources= new Resources();
		
		resources.setInstance(instance);
		
		resources.setEIP(eip);
		
		resources.setVpcGateway(gateway);
		
		template.setResources(resources);

	}

	private static void generateOutput(Template template, HashMap map, String templateUrl) {
		System.out.println("ecstemplatess::"+templateUrl);
		map.put("TemplateUrl", templateUrl);
	}

}

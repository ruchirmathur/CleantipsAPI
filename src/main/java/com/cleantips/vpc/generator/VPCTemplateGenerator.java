package com.cleantips.vpc.generator;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.cleantips.vpc.base.model.Outputs;
import com.cleantips.vpc.base.model.Parameters;
import com.cleantips.vpc.base.model.Resources;
import com.cleantips.vpc.base.model.Template;
import com.cleantips.vpc.eip.model.EIP;
import com.cleantips.vpc.gateway.model.VpcGateway;
import com.cleantips.vpc.internetgateway.model.InternetGateway;
import com.cleantips.vpc.model.Parameter;
import com.cleantips.vpc.model.VPC;
import com.cleantips.vpc.route.model.Route;
import com.cleantips.vpc.routetable.model.RouteTable;
import com.cleantips.vpc.securitygroup.model.SecurityGroup;
import com.cleantips.vpc.subnet.model.Ref;
import com.cleantips.vpc.subnet.model.Subnet;
import com.cleantips.vpc.subnetroutetableassociation.model.SubnetRouteTableAssociation;
import com.fasterxml.jackson.databind.ObjectMapper;

public class VPCTemplateGenerator {

	public HashMap execute(HashMap map, String type) throws IOException {
		
		String region = "us-east-1a";
		
		HashMap output = new HashMap();
		
		Template template = new Template();

		generateTemplateVersion(template);

		generateResources(template,map,region);

		generateParameters(template,map,region);

		//template = generateMappings(template);

		///template = generateConditions(template);
		
		ObjectMapper objectMapper = new ObjectMapper();
		
		File file = new File("vpc.json");

		String json = objectMapper.writeValueAsString(template);
		
		objectMapper.writeValue(file,template);
		
		System.out.println(json);
		
		String bucketName = Util.getBucketLocation(map,region,file,type);
		
		generateOutput(template,output,bucketName);
		
		System.out.println(output.get("TemplateUrl").toString());
		
		return output;

	}

	private static void generateTemplateVersion(Template template) {

		template.setAWSTemplateFormatVersion("2010-09-09");

	}
	private static void generateDescription(Template template, HashMap map) {

		template.setDescription("This is the VPC template");

	}

	private static void generateParameters(Template template,HashMap map, String region) {

		Parameters parameters = new Parameters();
		
		Parameter vpcCidr = new Parameter();
		
		vpcCidr = Util.createVpcCidr(region, map);
		
		Parameter privateSubnetCidr = new Parameter();
		
		privateSubnetCidr = Util.createPrivateSubnetCidr(region, map);
		
		Parameter publicSubnetCidr = new Parameter();
		
		publicSubnetCidr = Util.createPublicSubnetCidr(region, map);		
		
		parameters.setVpcCidr(vpcCidr);
		
		parameters.setPrivateSubnetCidr(privateSubnetCidr);
		
		parameters.setPublicSubnetCidr(publicSubnetCidr);

		template.setParameters(parameters);

	}

	private static Template generateMappings(Template template) {
		return template;

	}

	private static void generateConditions(Template template) {

	}

	private static <T> void generateResources(Template template, HashMap map, String region) {
		
		VPC vpc = Util.createVPC(map);
		
		Subnet privateSubnet = null;
		
		Subnet publicSubnet = null;
		
		if ((boolean)map.get("privateSubnet")) {
			
			 privateSubnet = Util.createPrivateSubnet(map,region);
		
		}
		if ((boolean)map.get("publicSubnet")) {
			
			 publicSubnet = Util.createPublicSubnet(map,region);
		}
		
		InternetGateway internetGateway= Util.createInternetGateway();
		
		VpcGateway vpcGateway = Util.createVpcGatewayAttachment(map, region);
		
		Route route = Util.createRoute(map, region);
		
		RouteTable routeTable= Util.createRouteTable();
		
		//SecurityGroupEgress securityGroupEgress = Util.createSecurityGroupEgress();
		
		///SecurityGroupIngress securityGroupIngress =Util.createSecurityGroupIngress();
		
		SubnetRouteTableAssociation subnetRouteTableAssociation= Util.createSubnetRouteTableAssociation();
		
		SecurityGroup securityGroup = Util.createSecurityGroup(map);
		
		EIP eip= Util.createEip();
		
		EIP eipAssociation= Util.createEIPAssociation();
		
		Resources resources= new Resources();
		
		resources.setVPC(vpc);
		
		resources.setPrivateSubnet(privateSubnet);
		
		resources.setPublicSubnet(publicSubnet);
		
		resources.setVpcGateway(vpcGateway);
		
		resources.setInternetGateway(internetGateway);
		
		resources.setRoute(route);
		
		resources.setRouteTable(routeTable);
		
		///resources.setSecurityGroupEgress(securityGroupEgress);
		
		resources.setSubnetRouteTableAssociation(subnetRouteTableAssociation);
		
		//resources.setSecurityGroupIngress(securityGroupIngress);
		
		//resources.setEIP(eip);
		
		//resources.setEIPAssociation(eipAssociation);
		
		resources.setSecurityGroup(securityGroup);
		
		template.setResources(resources);
	

	}

	private static void generateOutput(Template template, HashMap map, String templateUrl) {
		
		Outputs outputs = new Outputs();
		
		Ref vpcRef = new Ref();
		vpcRef.setRef("Vpc");
		map.put("Vpc", "Outputs.Vpc");
	
		Ref subnetRef =new Ref();
		subnetRef.setRef("PrivateSubnet");
		map.put("PrivateSubnet", "Outputs.PrivateSubnet");
		
		Ref securityGroupRef = new Ref();
		subnetRef.setRef("SecurityGroup");
		map.put("SecurityGroup", "Outputs.SecurityGroup");
		System.out.println("templatess::"+templateUrl);
		map.put("TemplateUrl", templateUrl);
		
		Ref internetGatewayRef = new Ref();
		internetGatewayRef.setRef("InternetGateway");
		
		map.put("InternetGateway", "Outputs.InternetGateway");
		
		outputs.setInternetGateway(internetGatewayRef);
		outputs.setSecurityGroup(securityGroupRef);
		outputs.setSubnet(subnetRef);
		outputs.setVPC(vpcRef);
		
		template.setOutputs(outputs);

	}

}

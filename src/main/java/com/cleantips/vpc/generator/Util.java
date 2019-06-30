package com.cleantips.vpc.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.AvailabilityZone;
import com.amazonaws.services.ec2.model.DescribeAvailabilityZonesRequest;
import com.amazonaws.services.ec2.model.DescribeAvailabilityZonesResult;
import com.amazonaws.services.ec2.model.DescribeRegionsResult;
import com.amazonaws.services.ec2.model.Region;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.GetBucketLocationRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.cleantips.vpc.eip.model.EIP;
import com.cleantips.vpc.gateway.model.VpcGateway;
import com.cleantips.vpc.internetgateway.model.InternetGateway;
import com.cleantips.vpc.model.Parameter;
import com.cleantips.vpc.model.Properties;
import com.cleantips.vpc.model.VPC;
import com.cleantips.vpc.route.model.Route;
import com.cleantips.vpc.routetable.model.RouteTable;
import com.cleantips.vpc.securitygroup.model.SecurityGroup;
import com.cleantips.vpc.securitygroupegress.model.SecurityGroupEgress;
import com.cleantips.vpc.securitygroupingress.model.SecurityGroupIngress;
import com.cleantips.vpc.subnet.model.Ref;
import com.cleantips.vpc.subnet.model.Subnet;
import com.cleantips.vpc.subnetroutetableassociation.model.SubnetRouteTableAssociation;

public class Util {

	@SuppressWarnings("unused")
	public static VPC createVPC(HashMap map) {

		VPC vpc = new VPC();

		Properties properties = generateVPCProperties(vpc, map);
		
		vpc.setProperties(properties);

		return vpc;

	}

	public static InternetGateway createInternetGateway() {

		InternetGateway internetGateway = new InternetGateway();

		return internetGateway;

	}
	private static Properties generateVPCProperties(VPC vpc, HashMap map) {

		Properties properties = new Properties();
		
		Ref vpcCidr= new Ref();
		
		vpcCidr.setRef("VpcCidr");

		properties.setCidrBlock(vpcCidr);
		
		properties.setEnableDnsHostnames((boolean)map.get("enableDnsHostnames"));
		
		properties.setEnableDnsSupport((boolean)map.get("enableDnsSupport"));

		vpc.setProperties(properties);

		return properties;

	}
	@SuppressWarnings("unused")
	public static Subnet createPrivateSubnet(HashMap map,String regionName) {

		Subnet privateSubnet = new Subnet();

		com.cleantips.vpc.subnet.model.Properties properties = generatePrivateSubnetProperties(regionName);
		
		privateSubnet.setProperties(properties);

		return privateSubnet;

	}
	public static Subnet createPublicSubnet(HashMap map,String regionName) {

		Subnet publicSubnet = new Subnet();

		com.cleantips.vpc.subnet.model.Properties properties = generatePublicSubnetProperties(regionName);
		
		publicSubnet.setProperties(properties);

		return publicSubnet;

	}
	public static VpcGateway createVpcGatewayAttachment(HashMap map,String regionName) {

		VpcGateway vpcGateway = new VpcGateway();

		com.cleantips.vpc.gateway.model.Properties properties = generateVpcGatewayProperties(regionName);
		
		vpcGateway.setProperties(properties);

		return vpcGateway;

	}
	public static Route createRoute(HashMap map,String regionName) {

		Route route = new Route();

		com.cleantips.vpc.route.model.Properties properties = generateRouteProperties(regionName);
		
		route.setProperties(properties);

		return route;

	}
	public static EIP createEip() {

		EIP eip = new EIP();


		return eip;

	}
	public static EIP createEIPAssociation() {

		EIP eipAssociation = new EIP();


		return eipAssociation;

	}
	public static SecurityGroup createSecurityGroup(HashMap map) {

		SecurityGroup securityGroup = new SecurityGroup();
		
		ArrayList<SecurityGroupIngress> securityGroupIngress = createSecurityGroupIngress(map);
		
		ArrayList<SecurityGroupEgress> securityGroupEgress = createSecurityGroupEgress(map);
		
		com.cleantips.vpc.securitygroup.model.Properties properties = generateSecurityProperties(securityGroupIngress,securityGroupEgress);
		
		securityGroup.setProperties(properties);

		return securityGroup;

	}
	public static RouteTable createRouteTable() {

		RouteTable routeTable = new RouteTable();
		
		com.cleantips.vpc.routetable.model.Properties properties = generateRouteTableProperties();
		
		routeTable.setProperties(properties);

		return routeTable;

	}
	public static ArrayList<SecurityGroupIngress> createSecurityGroupIngress(HashMap map) {
		
		ArrayList<SecurityGroupIngress> securityGroupIngressList = new ArrayList();

		SecurityGroupIngress securityGroupIngress = new SecurityGroupIngress();
		
		securityGroupIngress.setCidrIp(map.get("ingressCidrIp").toString());
		
		securityGroupIngress.setFromPort((int)map.get("ingressFrom"));
		
		securityGroupIngress.setToPort((int)map.get("ingressTo"));
		
		securityGroupIngress.setIpProtocol(map.get("ingressProtocol").toString());
		
		securityGroupIngressList.add(securityGroupIngress);
		
		System.out.println("test::securityGroupIngress: before"+securityGroupIngressList.size());

		return securityGroupIngressList;

	}
	public static ArrayList<SecurityGroupEgress> createSecurityGroupEgress(HashMap map) {
		
		ArrayList<SecurityGroupEgress> securityGroupEgressList = new ArrayList();

		SecurityGroupEgress securityGroupEgress = new SecurityGroupEgress();
		
		securityGroupEgress.setCidrIp(map.get("egressCidrIp").toString());
		
		securityGroupEgress.setFromPort((int)map.get("egressFrom"));
		
		securityGroupEgress.setToPort((int)map.get("egressTo"));
		
		securityGroupEgress.setIpProtocol(map.get("egressProtocol").toString());
		
		securityGroupEgressList.add(securityGroupEgress);

		return securityGroupEgressList;

	}
	
	public static SubnetRouteTableAssociation createSubnetRouteTableAssociation() {
		
		com.cleantips.vpc.subnetroutetableassociation.model.Properties properties = generateSubnetRouteAssociationProperties();

		SubnetRouteTableAssociation subnetRouteTableAssociation = new SubnetRouteTableAssociation();

		subnetRouteTableAssociation.setProperties(properties);

		return subnetRouteTableAssociation;

	}
	private static com.cleantips.vpc.subnet.model.Properties generatePrivateSubnetProperties(String regionName) {

		com.cleantips.vpc.subnet.model.Properties properties = new com.cleantips.vpc.subnet.model.Properties();
		
		Ref privateSubnet= new Ref();
		
		privateSubnet.setRef("PrivateSubnetCidr");

		properties.setCidrBlock(privateSubnet);
		
		properties.setAvailabilityZone(getAvaibilityZone(regionName).get(0));
		
		Ref vpc= new Ref();
		
		vpc.setRef("Vpc");
		
		properties.setVpcId(vpc);

		return properties;

	}
	private static com.cleantips.vpc.subnet.model.Properties generatePublicSubnetProperties(String regionName) {

		com.cleantips.vpc.subnet.model.Properties properties = new com.cleantips.vpc.subnet.model.Properties();
		
		Ref publicSubnet= new Ref();
		
		publicSubnet.setRef("PublicSubnetCidr");

		properties.setCidrBlock(publicSubnet);
		
		properties.setAvailabilityZone(getAvaibilityZone(regionName).get(1));
		
		Ref vpc= new Ref();
		
		vpc.setRef("Vpc");
		
		properties.setVpcId(vpc);

		return properties;

	}
	private static com.cleantips.vpc.gateway.model.Properties generateVpcGatewayProperties(String regionName) {

		com.cleantips.vpc.gateway.model.Properties properties = new com.cleantips.vpc.gateway.model.Properties();
		
		Ref vpcRef= new Ref();
		
		Ref internetGatewayRef= new Ref();
		
		internetGatewayRef.setRef("InternetGateway");
		
		vpcRef.setRef("Vpc");
		
		properties.setVpcId(vpcRef);
		
		properties.setInternetGatewayId(internetGatewayRef);

		return properties;

	}
	private static com.cleantips.vpc.securitygroup.model.Properties generateSecurityProperties(ArrayList<SecurityGroupIngress> securityGroupIngress,ArrayList<SecurityGroupEgress> securityGroupEgress) {

		com.cleantips.vpc.securitygroup.model.Properties properties = new com.cleantips.vpc.securitygroup.model.Properties();
		
		properties.setGroupDescription("Webserver");

		properties.setGroupName("Webserver");
		System.out.println("test::securityGroupIngress:"+securityGroupIngress.size());
		properties.setSecurityGroupEgress(securityGroupEgress);
		
		properties.setSecurityGroupIngress(securityGroupIngress);

		return properties;

	}
	private static com.cleantips.vpc.routetable.model.Properties generateRouteTableProperties() {

		com.cleantips.vpc.routetable.model.Properties properties = new com.cleantips.vpc.routetable.model.Properties();
		
		Ref vpc= new Ref();
		
		vpc.setRef("Vpc");

		properties.setVpcId(vpc);

		return properties;

	}
	private static com.cleantips.vpc.subnetroutetableassociation.model.Properties generateSubnetRouteAssociationProperties() {

		com.cleantips.vpc.subnetroutetableassociation.model.Properties properties = new com.cleantips.vpc.subnetroutetableassociation.model.Properties();
		
		Ref routeTableId= new Ref();
		
		routeTableId.setRef("RouteTable");
		
		Ref subnetId= new Ref();
		
		subnetId.setRef("PublicSubnet");

		properties.setRouteTableId(routeTableId);
		
		properties.setSubnetId(subnetId);

		return properties;

	}
	public static String getRegion() {

		final AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();

		String regionName = null;

		DescribeRegionsResult regions = ec2.describeRegions();

		for (Region region : regions.getRegions()) {

			regionName = region.getRegionName();
		}
		return regionName;
	}

	public static ArrayList<String> getAvaibilityZone(String regionName) {

		final AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();
		
		ArrayList<String> azList = new ArrayList<String>();
		
		String azName=null;

		DescribeAvailabilityZonesResult availabilityZonesResult = ec2
				.describeAvailabilityZones(new DescribeAvailabilityZonesRequest().withFilters(
						new com.amazonaws.services.ec2.model.Filter().withName("state").withValues("available")));

		for (AvailabilityZone zone : availabilityZonesResult.getAvailabilityZones()) {
			
			azName = zone.getZoneName();
			
			azList.add(azName);
		}

		return azList;

	}
	public static Parameter createVpcCidr(String region,HashMap map) {

		Parameter vpcCirdr = new Parameter();

		vpcCirdr.setDescription("This is the VPC CIDR");
		
		vpcCirdr.setType("String");
		
		vpcCirdr.setDefault(map.get("vpcCidr").toString());

		return vpcCirdr;

	}
	public static Parameter createPrivateSubnetCidr(String region,HashMap map) {

		Parameter privateCidr = new Parameter();

		privateCidr.setDescription("This is the private subnet CIDR");
		
		privateCidr.setType("String");
		
		privateCidr.setDefault(map.get("privateSubnetCidr").toString());

		return privateCidr;

	}
	public static Parameter createPublicSubnetCidr(String region,HashMap map) {

		Parameter publicCidr = new Parameter();

		publicCidr.setDescription("This is the public subnet VPC CIDR");
		
		publicCidr.setType("String");
		
		publicCidr.setDefault(map.get("publicSubnetCidr").toString());

		return publicCidr;

	}
	private static com.cleantips.vpc.route.model.Properties generateRouteProperties(String regionName) {

		com.cleantips.vpc.route.model.Properties properties = new com.cleantips.vpc.route.model.Properties();
		
		Ref routeId = new Ref();
		
		routeId.setRef("RouteTable");
		
		Ref gatewayId = new Ref();
		
		routeId.setRef("RouteTable");
		
		gatewayId.setRef("InternetGateway");
		
		properties.setDestinationCidrBlock("0.0.0.0/0");
		
		properties.setRouteTableId(routeId);
		
		properties.setGatewayId(gatewayId);

		return properties;

	}
	public static String getBucketLocation(HashMap map, String region, File file, String type) {
		
		String bucketName = map.get("architecture").toString();
		
		String finalBucketName = bucketName.concat(type.toLowerCase());
		
		System.out.println("bucker nme::::"+finalBucketName);
		
		final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
		
		
		if (!s3.doesBucketExistV2(finalBucketName)) {
			
			System.out.println("finalBucketName nme::::"+finalBucketName);
			
			Bucket bucket = s3.createBucket(finalBucketName);
	        // Upload a file as a new object with ContentType and title specified.
	 
			
		} 
		PutObjectRequest request = new PutObjectRequest(finalBucketName,  type, file);
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType("plain/text");
        metadata.addUserMetadata("x-amz-meta-title", "someTitle");
        request.setMetadata(metadata);
        s3.putObject(request);
		System.out.println("finalBucketName nme::all::"+finalBucketName);
        String bucketLocation = s3.getUrl(finalBucketName, type).toExternalForm();
        System.out.println("bucketLocation nme::::"+bucketLocation);
		return bucketLocation;
		
	}

}

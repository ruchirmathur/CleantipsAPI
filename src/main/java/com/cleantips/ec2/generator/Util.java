package com.cleantips.ec2.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.amazonaws.services.ec2.model.DescribeImagesRequest;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.AvailabilityZone;
import com.amazonaws.services.ec2.model.DescribeAvailabilityZonesRequest;
import com.amazonaws.services.ec2.model.DescribeAvailabilityZonesResult;
import com.amazonaws.services.ec2.model.DescribeRegionsResult;
import com.amazonaws.services.ec2.model.DescribeReservedInstancesOfferingsRequest;
import com.amazonaws.services.ec2.model.DescribeReservedInstancesOfferingsResult;
import com.amazonaws.services.ec2.model.Image;
import com.amazonaws.services.ec2.model.Region;
import com.amazonaws.services.ec2.model.ReservedInstancesOffering;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazonaws.services.s3.model.GetBucketLocationRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.cleantips.ec2.instance.model.AvailibilityZone;
import com.cleantips.ec2.instance.model.BlockDeviceMappings;
import com.cleantips.ec2.instance.model.Ebs;
import com.cleantips.ec2.instance.model.ElasticInferenceAccelerators;
import com.cleantips.ec2.instance.model.Instance;
import com.cleantips.ec2.instance.model.NetworkInterfaces;
import com.cleantips.ec2.instance.model.Parameter;
import com.cleantips.ec2.instance.model.Properties;
import com.cleantips.ec2.instance.model.Ref;
import com.cleantips.vpc.eip.model.EIP;
import com.cleantips.vpc.gateway.model.VpcGateway;

public class Util {

	@SuppressWarnings("unused")
	public static Instance createInstance(String regionName, HashMap map) {

		Instance instance = new Instance();

		Properties properties = generateProperties(instance, regionName, map);

		instance.setProperties(properties);

		return instance;

	}

	public static Parameter createInstanceTypeParameter(String region, HashMap map) {

		Parameter instanceType = new Parameter();

		instanceType.setAllowedValues((ArrayList<?>) getAvaibilityZone(region));

		instanceType.setDefault(map.get("instanceType").toString());

		instanceType.setType("String");

		instanceType.setDescription("This is the instance type");

		return instanceType;

	}

	public static Parameter createSubnetParameter(String region, HashMap map) {

		Parameter subnetType = new Parameter();

		subnetType.setType("String");

		subnetType.setDescription("This is the public subnet");

		return subnetType;

	}

	public static Parameter createVpcParameter(String region, HashMap map) {

		Parameter vpc = new Parameter();

		vpc.setType("String");

		vpc.setDescription("This is the vpc");

		return vpc;

	}

	public static Parameter createSecurityGroupParameter(String region, HashMap map) {

		Parameter securityGroup = new Parameter();

		securityGroup.setType("String");

		securityGroup.setDescription("This is the securityGroup");

		return securityGroup;

	}

	public static Parameter createInternetGatewayParameter(String region, HashMap map) {

		Parameter internetGateway = new Parameter();

		internetGateway.setType("String");

		internetGateway.setDescription("This is the internetGateway");

		return internetGateway;

	}

	public static Parameter createImageTypeParameter(HashMap map) {

		Parameter imageType = new Parameter();

		imageType.setAllowedValues((ArrayList) createImage(map));

		imageType.setType("String");

		imageType.setDescription("This is the image type of the instance");

		return imageType;

	}

	public static Parameter createKeyNameParameter(HashMap map) {

		Parameter keyName = new Parameter();

		keyName.setType("String");

		keyName.setDescription("Key name of the key used");

		return keyName;

	}

	private static Properties generateProperties(Instance instance, String regionName, HashMap map) {

		Properties properties = new Properties();

		Ref imageTypeRef = new Ref();

		Ref instanceTypeRef = new Ref();

		Ref keyNameRef = new Ref();

		properties.setAdditionalInfo(null);

		properties.setAffinity(map.get("affinity").toString());

		properties.setAvailabilityZone(createAz(regionName));

		properties.setBlockDeviceMappings(createBlockDeviceMappings(map));

		properties.setCreditSpecification(createCreditSpecification(map));

		properties.setDisableApiTermination(true);

		properties.setEbsOptimized((boolean) map.get("ebsOptimized"));

		// properties.setElasticGpuSpecifications(elasticGpuSpecifications);

		// properties.setElasticInferenceAccelerators(createElasticAccelerator(map));
		if (!map.get("affinity").toString().equalsIgnoreCase("default")) {

			properties.setHostId("");

		}

		// properties.setIamInstanceProfile(iamInstanceProfile);
		imageTypeRef.setRef("ImageType");
		properties.setImageId(imageTypeRef);

		properties.setInstanceInitiatedShutdownBehavior(map.get("instanceInitiatedShutdownBehavior").toString());
		instanceTypeRef.setRef("InstanceType");
		properties.setInstanceType(instanceTypeRef);

		keyNameRef.setRef("KeyName");
		properties.setKeyName(keyNameRef);

		// properties.setIpv6AddressCount(ipv6AddressCount);

		// properties.setIpv6Addresses(ipv6Addresses);

		// properties.setKernelId(kernelId);

		// properties.setLaunchTemplateSpecification(launchTemplateSpecification);

		// properties.setLicenseSpecifications(licenseSpecifications);

		properties.setMonitoring((boolean) map.get("monitoring"));

		properties.setNetworkInterfaces(createNetworkInterfaces(map));

		// properties.setPlacementGroupName(placementGroupName);

		// properties.setPrivateIpAddress(privateIpAddress);

		// properties.setRamdiskId(ramdiskId);

		// properties.setSecurityGroupIds(securityGroupIds);

		// properties.setSecurityGroups(securityGroups);

		// properties.setSourceDestCheck(sourceDestCheck);

		// properties.setSsmAssociations(ssmAssociations);

		// properties.setSubnetId(subnetId);

		// properties.setTenancy(tenancy);

		// properties.setUserData(userData);

		instance.setProperties(properties);

		return properties;

	}

	public static String getRegion() {

		final AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();

		String regionName = null;

		DescribeRegionsResult regions = ec2.describeRegions();

		for (Region region : regions.getRegions()) {

			regionName = region.getRegionName();
			System.out.println("test:::region:" + region.getRegionName());
		}
		return regionName;
	}

	public static ArrayList<String> getAvaibilityZone(String regionName) {

		final AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();

		ArrayList<String> azList = new ArrayList<String>();

		DescribeAvailabilityZonesResult availabilityZonesResult = ec2
				.describeAvailabilityZones(new DescribeAvailabilityZonesRequest().withFilters(
						new com.amazonaws.services.ec2.model.Filter().withName("state").withValues("available")));

		for (AvailabilityZone zone : availabilityZonesResult.getAvailabilityZones()) {

			azList.add(zone.getZoneName());
		}
		ArrayList describeInstancesRequest = createInstanceTypes(azList);

		return describeInstancesRequest;

	}

	private static ArrayList createInstanceTypes(ArrayList<String> azList) {
		final AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();

		String instanceType = null;
		ArrayList instanceTypeList = new ArrayList<>();

		DescribeReservedInstancesOfferingsResult describeInstancesResult = ec2
				.describeReservedInstancesOfferings(new DescribeReservedInstancesOfferingsRequest()
						.withFilters(new com.amazonaws.services.ec2.model.Filter().withName("availability-zone")
								.withValues(azList)));

		for (ReservedInstancesOffering r : describeInstancesResult.getReservedInstancesOfferings()) {

			instanceType = r.getInstanceType();

			instanceTypeList.add(instanceType);
		}
		System.out.println("test the ins:::::" + instanceTypeList.size());
		return instanceTypeList;
	}

	public static AvailibilityZone createAz(String regionName) {

		ArrayList<String> getAz = getAvaibilityZone(regionName);

		AvailibilityZone av = new AvailibilityZone();

		Ref ref = new Ref();

		HashMap<Integer, Ref> test = new HashMap<Integer, Ref>();

		ref.setRef("TESTREF");

		test.put(1, ref);

		HashMap<Integer, Ref> test1 = new HashMap<Integer, Ref>();
		Ref ref1 = new Ref();

		ref1.setRef("TESTREFFF");

		test1.put(2, ref1);

		ArrayList select = new ArrayList<>();

		select.add(test);
		select.add(test1);

		av.setFnSelect(select);

		return av;
	}

	public static ArrayList<BlockDeviceMappings> createBlockDeviceMappings(HashMap map) {

		ArrayList blockDeviceMappings = new ArrayList();

		BlockDeviceMappings blockDeviceMapping = new BlockDeviceMappings();

		Ebs ebs = new Ebs();

		blockDeviceMapping.setDeviceName(map.get("root-device-name").toString());

		ebs.setVolumeSize(map.get("volumeSize").toString());

		ebs.setEncrypted(false);

		ebs.setVolumeType(map.get("block-device-mapping.volume-type").toString());

		ebs.setDeleteOnTermination(true);

		ebs.setIops((int) map.get("iops"));

		blockDeviceMapping.setEbs(ebs);

		blockDeviceMapping.setNoDevice(null);

		blockDeviceMapping.setVirtualName(null);

		blockDeviceMappings.add(blockDeviceMapping);

		return blockDeviceMappings;

	}

	public static com.cleantips.ec2.instance.model.CreditSpecification createCreditSpecification(HashMap map) {

		com.cleantips.ec2.instance.model.CreditSpecification creditSpecification = new com.cleantips.ec2.instance.model.CreditSpecification();

		creditSpecification.setCPUCredits(map.get("creditSpec").toString());

		return creditSpecification;

	}

	public static ArrayList<ElasticInferenceAccelerators> createElasticAccelerator(HashMap map) {

		ArrayList elasticInferenceAccelerators = new ArrayList();

		ElasticInferenceAccelerators elasticInferenceAccelerator = new ElasticInferenceAccelerators();

		elasticInferenceAccelerator.setType("");

		elasticInferenceAccelerators.add(elasticInferenceAccelerator);

		return elasticInferenceAccelerators;

	}

	public static List<Image> createImage(HashMap ec2Prop) {

		final AmazonEC2 ec2 = AmazonEC2ClientBuilder.defaultClient();

		String imageId = null;

		List imageList = new ArrayList<>();

		DescribeImagesRequest describeImagesRequest = new DescribeImagesRequest();

		com.amazonaws.services.ec2.model.DescribeImagesResult describeInstancesResult = ec2
				.describeImages(new com.amazonaws.services.ec2.model.DescribeImagesRequest()
						.withFilters(new com.amazonaws.services.ec2.model.Filter().withName("architecture")
								.withValues(ec2Prop.get("architecture").toString()))
						.withFilters(new com.amazonaws.services.ec2.model.Filter().withName("owner-alias")
								.withValues(ec2Prop.get("owner-alias").toString()))
						.withFilters(new com.amazonaws.services.ec2.model.Filter().withName("root-device-type")
								.withValues(ec2Prop.get("root-device-type").toString()))
						.withFilters(new com.amazonaws.services.ec2.model.Filter().withName("is-public")
								.withValues(ec2Prop.get("is-public").toString()))
						.withFilters(new com.amazonaws.services.ec2.model.Filter()
								.withName("block-device-mapping.delete-on-termination")
								.withValues(ec2Prop.get("block-device-mapping.delete-on-termination").toString()))
						.withFilters(new com.amazonaws.services.ec2.model.Filter()
								.withName("block-device-mapping.volume-type")
								.withValues(ec2Prop.get("block-device-mapping.volume-type").toString()))
						.withFilters(new com.amazonaws.services.ec2.model.Filter().withName("virtualization-type")
								.withValues(ec2Prop.get("virtualization-type").toString()))

						.withFilters(new com.amazonaws.services.ec2.model.Filter().withName("hypervisor")
								.withValues(ec2Prop.get("hypervisor").toString()))

						.withFilters(new com.amazonaws.services.ec2.model.Filter().withName("root-device-name")
								.withValues(ec2Prop.get("root-device-name").toString())));

		System.out.println("DescribeImagesResult::::size:::" + describeInstancesResult.getImages().size());

		for (Image im : describeInstancesResult.getImages()) {

			imageId = im.getImageId();

			imageList.add(imageId);
		}

		return imageList;
	}

	public static ArrayList<NetworkInterfaces> createNetworkInterfaces(HashMap map) {

		ArrayList<NetworkInterfaces> networkList = new ArrayList<NetworkInterfaces>();

		Ref groupSet = new Ref();

		Ref subnetRef = new Ref();

		subnetRef.setRef("Subnet");

		groupSet.setRef("SecurityGroup");

		NetworkInterfaces networkInterfaces = new NetworkInterfaces();

		networkInterfaces.setAssociatePublicIpAddress(true);

		networkInterfaces.setDeleteOnTermination((boolean) map.get("block-device-mapping.delete-on-termination"));

		networkInterfaces.setDescription("Test interface");

		networkInterfaces.setDeviceIndex("0");

		networkInterfaces.setGroupSet(groupSet);

		networkInterfaces.setSubnetId(subnetRef);

		networkList.add(networkInterfaces);

		return networkList;

	}

	public static EIP createEip(String regionName, HashMap map) {

		EIP eip = new EIP();

		com.cleantips.vpc.eip.model.Properties properties = generateEipProperties(regionName, map);

		eip.setProperties(properties);

		eip.setDependsOn("VpcGateway");

		return eip;
	}

	private static com.cleantips.vpc.eip.model.Properties generateEipProperties(String regionName, HashMap map) {

		com.cleantips.vpc.eip.model.Properties properties = new com.cleantips.vpc.eip.model.Properties();

		com.cleantips.vpc.subnet.model.Ref eipRef = new com.cleantips.vpc.subnet.model.Ref();

		eipRef.setRef("Instance");

		properties.setInstanceId(eipRef);

		return properties;

	}

	public static VpcGateway createGateway(String regionName, HashMap map) {

		VpcGateway vpcGateway = new VpcGateway();

		com.cleantips.vpc.gateway.model.Properties properties = generateGatewayProperties(regionName, map);

		vpcGateway.setProperties(properties);

		return vpcGateway;
	}

	private static com.cleantips.vpc.gateway.model.Properties generateGatewayProperties(String regionName,
			HashMap map) {

		com.cleantips.vpc.gateway.model.Properties properties = new com.cleantips.vpc.gateway.model.Properties();

		com.cleantips.vpc.subnet.model.Ref gatewayRef = new com.cleantips.vpc.subnet.model.Ref();

		gatewayRef.setRef("InternetGateway");

		com.cleantips.vpc.subnet.model.Ref vpcRef = new com.cleantips.vpc.subnet.model.Ref();

		vpcRef.setRef("VPC");

		properties.setInternetGatewayId(gatewayRef);

		properties.setVpcId(vpcRef);

		return properties;

	}

	public static String getBucketLocation(HashMap map, String region, File file, String type) {

		String bucketName = map.get("architecture").toString();

		String finalBucketName = bucketName.concat(type.toLowerCase());

		System.out.println("bucker nme::::" + finalBucketName);

		final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();

		if (!s3.doesBucketExistV2(finalBucketName)) {

			System.out.println("finalBucketName nme::::" + finalBucketName);

			Bucket bucket = s3.createBucket(finalBucketName);
			// Upload a file as a new object with ContentType and title specified.

		}
		PutObjectRequest request = new PutObjectRequest(finalBucketName, type, file);
		ObjectMetadata metadata = new ObjectMetadata();
		metadata.setContentType("plain/text");
		metadata.addUserMetadata("x-amz-meta-title", "someTitle");
		request.setMetadata(metadata);
		s3.putObject(request);
		System.out.println("finalBucketName nme::all::" + finalBucketName);
		String bucketLocation = s3.getUrl(finalBucketName, type).toExternalForm();
		System.out.println("bucketLocation nme::::" + bucketLocation);
		return bucketLocation;

	}

}

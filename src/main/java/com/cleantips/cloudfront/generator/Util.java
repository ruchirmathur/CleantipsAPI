package com.cleantips.cloudfront.generator;

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
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.cleantips.vpc.eip.model.EIP;
import com.cleantips.cloudfront.distribution.model.*;

public class Util {

	@SuppressWarnings("unused")
	public static Distribution createDistribution(HashMap map,String regionName) {
		
		Distribution distribution = null ;
		try {
		System.out.println("In createDistribution");
		 distribution = new Distribution();

		Properties properties = generateDistributionProperties(distribution, regionName,map);
		
		distribution.setProperties(properties);
		
		System.out.println("distribution.setProperties::"+distribution.getProperties().getDistributionConfig().getComment());
		
		}catch (Exception ex) {
			ex.printStackTrace();
		}

		return distribution;

	}

	private static Properties generateDistributionProperties(Distribution distribution, String regionName, HashMap map) {
		System.out.println("In generateDistributionProperties");
		Properties properties = new Properties();

		properties.setDistributionConfig(createDistributionConfig(regionName,map));

		properties.setTag(createTags());
		
		return properties;

	}
	@SuppressWarnings("unused")
	public static DistributionConfig createDistributionConfig(String regionName, HashMap map) {

		DistributionConfig distributionConfig = new DistributionConfig();

		//distributionConfig.setAliases(aliases);
		
		distributionConfig.setCacheBehaviors(createCacheBehavior(map));
		
		distributionConfig.setComment("S3 Cloudfront distro set up");
		
		distributionConfig.setCustomErrorResponses(createCustomErrrorResponse());

		distributionConfig.setDefaultCacheBehavior(createDefaultCacheBehavior(map));
		
		//distributionConfig.setDefaultRootObject(defaultRootObject);
		
		distributionConfig.setEnabled(true);
		
		distributionConfig.setHttpVersion("http2");
		
		distributionConfig.setIPV6Enabled(false);
		
		distributionConfig.setLogging(null);
		
		distributionConfig.setOrigin(createOrigin());
		
		distributionConfig.setPriceClass("PriceClass_All");
		
		//distributionConfig.setRestrictions(restrictions);
		
		//distributionConfig.setViewerCertificate(viewerCertificate);
		
		//distributionConfig.setWebACLId(webACLId);
		
		return distributionConfig;

	}

	public static ArrayList<Tags> createTags() {

		ArrayList tags = new ArrayList();
		
		Tags tag = new Tags();

		tag.setKey("");

		tag.setValue("");
		
		tags.add(tag);
		
		return tags;

	}
	public static ArrayList<CustomErrorResponses> createCustomErrrorResponse() {
		
		ArrayList customErrorResponses = new ArrayList();
		
		CustomErrorResponses customErrorResponse = new CustomErrorResponses();
		
		customErrorResponse.setErrorCachingMinTTL(2);
		
		customErrorResponse.setErrorCode(404);
		
		customErrorResponse.setResponseCode(200);
		
		customErrorResponse.setResponsePagePath("");
		
		customErrorResponses.add(customErrorResponse);
		
		return customErrorResponses;
		
	}
	
	public static ArrayList<CacheBehaviors> createCacheBehavior(HashMap map) {

		ArrayList<CacheBehaviors> cacheBehaviors = new ArrayList();
		
		CacheBehaviors cacheBehavior = new CacheBehaviors();
		
		cacheBehavior.setAllowedMethods((ArrayList) map.get("allowedMethods"));

		cacheBehavior.setCompress(false);
		
		cacheBehavior.setDefaultTTL(120);
		
		//cacheBehavior.setFieldLevelEncryptionId(fieldLevelEncryptionId);
		
		//cacheBehavior.setForwardedValues(forwardedValues);
		
		//cacheBehavior.setLambdaFunctionAssociations(lambdaFunctionAssociations);
		
		cacheBehavior.setMaxTTL(120);
		
		cacheBehavior.setMinTTL(20);

		cacheBehavior.setPathPattern("*");
		
		cacheBehavior.setSmoothStreaming((boolean) map.get("smoothStreaming"));
		
		cacheBehavior.setTargetOriginId(null);
		
		//cacheBehavior.setTrustedSigners(trustedSigners);
		
		cacheBehavior.setViewerProtocolPolicy("allow-all");
		
		cacheBehaviors.add(cacheBehavior);

		return cacheBehaviors;

	}
	
	public static DefaultCacheBehavior createDefaultCacheBehavior(HashMap map) {

		
		DefaultCacheBehavior cacheBehavior = new DefaultCacheBehavior();
		
		cacheBehavior.setAllowedMethods((ArrayList) map.get("allowedMethods"));

		cacheBehavior.setCompress(false);
		
		cacheBehavior.setDefaultTTL(120);
		
		//cacheBehavior.setFieldLevelEncryptionId(fieldLevelEncryptionId);
		
		//cacheBehavior.setForwardedValues(forwardedValues);
		
		//cacheBehavior.setLambdaFunctionAssociations(lambdaFunctionAssociations);
		
		cacheBehavior.setMaxTTL(120);
		
		cacheBehavior.setMinTTL(20);
		
		cacheBehavior.setSmoothStreaming((boolean) map.get("smoothStreaming"));
		
		cacheBehavior.setTargetOriginId(null);
		
		//cacheBehavior.setTrustedSigners(trustedSigners);
		
		cacheBehavior.setViewerProtocolPolicy("allow-all");

		return cacheBehavior;

	}
	
	public static ArrayList<Origins> createOrigin() {

		ArrayList<Origins> origins = new ArrayList();
		
		Origins origin = new Origins();
		
		origin.setCustomOriginConfig(createCustomOriginConfig());
		
		origin.setDomainName("");
		
		origin.setId("");
		
		//origin.setOriginCustomHeaders(originCustomHeaders);
		
		//origin.setOriginPath(originPath);
		
		origin.setS3OriginConfig(createS3OriginConfig());
		
		origins.add(origin);

		return origins;

	}
	public static CustomOriginConfig createCustomOriginConfig() {

		CustomOriginConfig customOriginConfig = new CustomOriginConfig();

		customOriginConfig.setHTTPPort(80);
		
		customOriginConfig.setHTTPSPort(443);
		
		customOriginConfig.setOriginKeepaliveTimeout(30);
		
		customOriginConfig.setOriginProtocolPolicy("match-viewer");
		
		customOriginConfig.setOriginReadTimeout(30);
		
		//customOriginConfig.setOriginSSLProtocols(originSSLProtocols);

		return customOriginConfig;

	}
	public static S3OriginConfig createS3OriginConfig() {

		S3OriginConfig s3OriginConfig = new S3OriginConfig();
		
		s3OriginConfig.setOriginAccessIdentity("");

		return s3OriginConfig;

	}
	public static GeoRestriction createGeoRestriction() {

		GeoRestriction geoRestriction = new GeoRestriction();
		
		//geoRestriction.setLocations(locations);
		
		//geoRestriction.setRestrictionType(restrictionType);

		return geoRestriction;

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

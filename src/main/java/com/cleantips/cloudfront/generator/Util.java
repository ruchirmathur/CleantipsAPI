package com.cleantips.cloudfront.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

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
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.cleantips.vpc.eip.model.EIP;
import com.cleantips.cloudfront.distribution.model.*;

public class Util {

	@SuppressWarnings("unused")
	public static Distribution createDistribution(ConcurrentHashMap map,String regionName,HashMap paramMap) {
		
		Distribution distribution = null ;
		try {
		System.out.println("In createDistribution");
		 distribution = new Distribution();

		Properties properties = generateDistributionProperties(distribution, regionName,map,paramMap);
		
		distribution.setProperties(properties);
		
		System.out.println("distribution.setProperties::"+distribution.getProperties().getDistributionConfig().getComment());
		
		}catch (Exception ex) {
			ex.printStackTrace();
		}

		return distribution;

	}

	private static Properties generateDistributionProperties(Distribution distribution, String regionName, ConcurrentHashMap map,HashMap paramMap) {
		System.out.println("In generateDistributionProperties");
		Properties properties = new Properties();

		properties.setDistributionConfig(createDistributionConfig(regionName,map, paramMap));

		//properties.setTag(createTags());
		
		return properties;

	}
	@SuppressWarnings("unused")
	public static DistributionConfig createDistributionConfig(String regionName, ConcurrentHashMap map,HashMap paramMap) {

		DistributionConfig distributionConfig = new DistributionConfig();

		//distributionConfig.setAliases(aliases);
		
		distributionConfig.setCacheBehaviors(createCacheBehavior(map, paramMap));
		
		distributionConfig.setComment("S3 Cloudfront distro set up");
		
		distributionConfig.setCustomErrorResponses(createCustomErrrorResponse());

		distributionConfig.setDefaultCacheBehavior(createDefaultCacheBehavior(map));
		
		//distributionConfig.setDefaultRootObject(defaultRootObject);
		
		distributionConfig.setEnabled(true);
		
		distributionConfig.setHttpVersion("http2");
		
		
		distributionConfig.setLogging(null);
		
		distributionConfig.setOrigins(createOrigin());
		
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
		
		customErrorResponse.setErrorCachingMinTTL(20);
		
		customErrorResponse.setErrorCode(404);
		
		customErrorResponse.setResponseCode(404);
		
		customErrorResponse.setResponsePagePath("/4xx-errors/403-forbidden.html");
		
		customErrorResponses.add(customErrorResponse);
		
		return customErrorResponses;
		
	}
	
	public static ArrayList<CacheBehaviors> createCacheBehavior(ConcurrentHashMap map,HashMap paramMap) {

		ArrayList<CacheBehaviors> cacheBehaviors = new ArrayList();
		
		ForwardedValues forwardedValues= new ForwardedValues();
		
		CacheBehaviors cacheBehavior = new CacheBehaviors();
		
		if (map.get("allowedMethods")!=null) {
		
		cacheBehavior.setAllowedMethods((ArrayList) map.get("allowedMethods"));
		
		}

		cacheBehavior.setCompress(false);
		
		cacheBehavior.setDefaultTTL(120);
		
		//cacheBehavior.setFieldLevelEncryptionId(fieldLevelEncryptionId);
		
		forwardedValues.setQueryString(false);
		
		cacheBehavior.setForwardedValues(forwardedValues);
		
		//cacheBehavior.setLambdaFunctionAssociations(lambdaFunctionAssociations);
		
		cacheBehavior.setMaxTTL(120);
		
		cacheBehavior.setMinTTL(20);

		cacheBehavior.setPathPattern("*");
		
		if (map.get("smoothStreaming")!=null) {
		
		cacheBehavior.setSmoothStreaming((boolean) map.get("smoothStreaming"));
		
		}
		//for (Entry<?, ?> entry : paramMap.) {
			//System.out.println("test:::::"+entry.getKey());
		//}
		
		
		Ref target=new Ref();
		target.setRef("Bucket");
		cacheBehavior.setTargetOriginId(target);
		
		//cacheBehavior.setTrustedSigners(trustedSigners);
		
		cacheBehavior.setViewerProtocolPolicy("allow-all");
		
		cacheBehaviors.add(cacheBehavior);

		return cacheBehaviors;

	}
	
	public static DefaultCacheBehavior createDefaultCacheBehavior(ConcurrentHashMap map) {

		
		DefaultCacheBehavior cacheBehavior = new DefaultCacheBehavior();
		
		ForwardedValues forwardedValues= new ForwardedValues();
		
		if (map.get("allowedMethods")!=null) {
		
		cacheBehavior.setAllowedMethods((ArrayList) map.get("allowedMethods"));
		
		}

		cacheBehavior.setCompress(false);
		
		cacheBehavior.setDefaultTTL(120);
		
		//cacheBehavior.setFieldLevelEncryptionId(fieldLevelEncryptionId);
		
		forwardedValues.setQueryString(false);
		
		cacheBehavior.setForwardedValues(forwardedValues);
		
		//cacheBehavior.setLambdaFunctionAssociations(lambdaFunctionAssociations);
		
		cacheBehavior.setMaxTTL(120);
		
		cacheBehavior.setMinTTL(20);

		//cacheBehavior.setPathPattern("*");
		
		if (map.get("smoothStreaming")!=null) {
		
		cacheBehavior.setSmoothStreaming((boolean) map.get("smoothStreaming"));
		
		}
		//for (Entry<?, ?> entry : paramMap.) {
			//System.out.println("test:::::"+entry.getKey());
		//}
		
		
		Ref target=new Ref();
		target.setRef("Bucket");
		cacheBehavior.setTargetOriginId(target);
		
		//cacheBehavior.setTrustedSigners(trustedSigners);
		
		cacheBehavior.setViewerProtocolPolicy("allow-all");
		
		return cacheBehavior;
	}
	
	public static ArrayList<Origin> createOrigin() {

		ArrayList<Origin> origins = new ArrayList();
		
		Origin origin = new Origin();
		
		origin.setCustomOriginConfig(createCustomOriginConfig());
		
		origin.setDomainName("myawsbucket.s3.amazonaws.com");
		
		Ref target=new Ref();
		target.setRef("Bucket");
		
		origin.setId(target);
		
		//origin.setOriginCustomHeaders(originCustomHeaders);
		
		//origin.setOriginPath(originPath);
		
		//origin.setS3OriginConfig(createS3OriginConfig());
		
		origins.add(origin);

		return origins;

	}
	public static CustomOriginConfig createCustomOriginConfig() {

		CustomOriginConfig customOriginConfig = new CustomOriginConfig();

		//customOriginConfig.setHTTPPort(80);
		
		//customOriginConfig.setHTTPSPort(443);
		
		customOriginConfig.setOriginKeepaliveTimeout(30);
		
		customOriginConfig.setOriginProtocolPolicy("match-viewer");
		
		customOriginConfig.setOriginReadTimeout(30);
		
		//customOriginConfig.setOriginSSLProtocols(originSSLProtocols);

		return customOriginConfig;

	}
	public static S3OriginConfig createS3OriginConfig() {

		S3OriginConfig s3OriginConfig = new S3OriginConfig();
		
		//s3OriginConfig.setOriginAccessIdentity("");

		return s3OriginConfig;

	}
	public static GeoRestriction createGeoRestriction() {

		GeoRestriction geoRestriction = new GeoRestriction();
		
		//geoRestriction.setLocations(locations);
		
		//geoRestriction.setRestrictionType(restrictionType);

		return geoRestriction;

	}

	public static String getBucketLocation(ConcurrentHashMap map, String region, File file, String type) {

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
		request.setCannedAcl(CannedAccessControlList.PublicRead);
		s3.putObject(request);
		System.out.println("finalBucketName nme::all::" + finalBucketName);
		String bucketLocation = s3.getUrl(finalBucketName, type).toExternalForm();
		System.out.println("bucketLocation nme::::" + bucketLocation);
		return bucketLocation;

	}
}

package com.cleantips.s3.generator;

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
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.cleantips.s3.bucket.model.AccelerateConfiguration;
import com.cleantips.s3.bucket.model.Bucket;
import com.cleantips.s3.bucket.model.BucketEncryption;
import com.cleantips.s3.bucket.model.CorsConfiguration;
import com.cleantips.s3.bucket.model.CorsRule;
import com.cleantips.s3.bucket.model.LifecycleConfiguration;
import com.cleantips.s3.bucket.model.Properties;
import com.cleantips.s3.bucket.model.RedirectAllRequestsTo;
import com.cleantips.s3.bucket.model.Rule;
import com.cleantips.s3.bucket.model.VersioningConfiguration;
import com.cleantips.s3.bucket.model.WebsiteConfiguration;

public class Util {

	@SuppressWarnings("unused")
	public static Bucket createBucket(HashMap map, String regionName) {

		Bucket bucket = new Bucket();

		Properties properties = generateBucketProperties(bucket, regionName, map);

		bucket.setProperties(properties);

		return bucket;

	}

	private static Properties generateBucketProperties(Bucket bucket, String regionName, HashMap map) {

		Properties properties = new Properties();

		properties.setAccelerateConfiguration(createAccelerateConfig(regionName, map));

		properties.setAccessControl(map.get("accessControl").toString());

		 properties.setAnalyticsConfigurations(null);

		if (map.get("bucketType").toString().equalsIgnoreCase("website")) {

			properties.setBucketEncryption(null);

		} else {

			// properties.setBucketEncryption(createBucketEncryption(regionName,map));
		}

		properties.setBucketName(map.get("bucketName").toString());

		if (map.get("bucketType").toString().equalsIgnoreCase("website")) {

			properties.setCorsConfiguration(createCorsConfig(regionName, map));

		} else {

			properties.setCorsConfiguration(null);
		}
		properties.setInventoryConfigurations(null);

		if (!map.get("bucketType").toString().equalsIgnoreCase("website")) {

			properties.setLifecycleConfiguration(createLifeCycleConfiguration(regionName, map));

		}
		if (!map.get("bucketType").toString().equalsIgnoreCase("website")) {

			// properties.setLoggingConfiguration(loggingConfiguration);
		}
		if (!map.get("bucketType").toString().equalsIgnoreCase("website")) {
			// properties.setMetricsConfigurations(metricsConfigurations);
		}
		if (!map.get("bucketType").toString().equalsIgnoreCase("website")) {
			// .//properties.setNotificationConfiguration(notificationConfiguration);
		}
		if (!map.get("bucketType").toString().equalsIgnoreCase("website")) {
			// properties.setObjectLockConfiguration(objectLockConfiguration);
		}
		if (!map.get("bucketType").toString().equalsIgnoreCase("website")) {
			properties.setObjectLockEnabled(false);
		}
		
		// properties.setPublicAccessBlockConfiguration(createPublicAccessBlockConfiguration(regionName,map));

//		//properties.setReplicationConfiguration(replicationConfiguration);

		// properties.setTags(tags);

		properties.setVersioningConfiguration(createVersionConfig(regionName,map));

		properties.setWebsiteConfiguration(createWebsiteConfig(regionName, map));

		return properties;

	}

	@SuppressWarnings("unused")
	public static AccelerateConfiguration createAccelerateConfig(String regionName, HashMap map) {

		AccelerateConfiguration accelerateConfiguration = new AccelerateConfiguration();

		accelerateConfiguration.setAccessControlTranslation("Enabled");

		return accelerateConfiguration;

	}
	public static VersioningConfiguration createVersionConfig(String regionName, HashMap map) {

		VersioningConfiguration versioningConfiguration = new VersioningConfiguration();

		versioningConfiguration.setStatus("Enabled");

		return versioningConfiguration;

	}

	public static BucketEncryption createBucketEncryption(String regionName, HashMap map) {

		BucketEncryption bucketEncryption = new BucketEncryption();

		// bucketEncryption.setServerSideEncryptionConfiguration(serverSideEncryptionConfiguration);

		return bucketEncryption;

	}

	public static CorsConfiguration createCorsConfig(String regionName, HashMap map) {

		CorsConfiguration corsConfiguration = new CorsConfiguration();

		CorsRule corsRule = new CorsRule();

		corsRule.setAllowedHeaders(null);

		if (map.get("allowedMethods") != null) {

			corsRule.setAllowedMethods((ArrayList<String>) map.get("allowedMethods"));

		}
		if (map.get("allowedOrigins") != null) {

			corsRule.setAllowedOrigins((ArrayList<String>) map.get("allowedOrigins"));

		}

		corsRule.setExposedHeaders(null);

		corsRule.setId("corsrule");

		corsRule.setMaxAge(3600);

		ArrayList<CorsRule> corsList = new ArrayList();

		corsList.add(corsRule);

		corsConfiguration.setCorsRules(corsList);

		return corsConfiguration;

	}

	public static LifecycleConfiguration createLifeCycleConfiguration(String regionName, HashMap map) {

		LifecycleConfiguration lifecycleConfiguration = new LifecycleConfiguration();

		Rule rule = new Rule();

		rule.setAbortIncompleteMultipartUpload(null);

		rule.setExpirationInDays(null);

		lifecycleConfiguration.setRules(null);

		return lifecycleConfiguration;

	}

	public static WebsiteConfiguration createWebsiteConfig(String regionName, HashMap map) {

		WebsiteConfiguration websiteConfiguration = new WebsiteConfiguration();

		websiteConfiguration.setErrorDocument(null);

		websiteConfiguration.setIndexDocument(map.get("indexDocument").toString());

		websiteConfiguration.setRedirectAllRequestsTo(null);

		websiteConfiguration.setRoutingRules(null);

		return websiteConfiguration;

	}

	public static RedirectAllRequestsTo createRoutingRule(String regionName, HashMap map) {

		RedirectAllRequestsTo redirectAllRequestsTo = new RedirectAllRequestsTo();

		redirectAllRequestsTo.setHostName(map.get("host").toString());

		redirectAllRequestsTo.setProtocol("https");

		return redirectAllRequestsTo;

	}

	/*public static ArrayList<CustomErrorResponses> createCustomErrrorResponse() {

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

		// cacheBehavior.setFieldLevelEncryptionId(fieldLevelEncryptionId);

		// cacheBehavior.setForwardedValues(forwardedValues);

		// cacheBehavior.setLambdaFunctionAssociations(lambdaFunctionAssociations);

		cacheBehavior.setMaxTTL(120);

		cacheBehavior.setMinTTL(20);

		cacheBehavior.setPathPattern("*");

		cacheBehavior.setSmoothStreaming((boolean) map.get("smoothStreaming"));

		cacheBehavior.setTargetOriginId(null);

		// cacheBehavior.setTrustedSigners(trustedSigners);

		cacheBehavior.setViewerProtocolPolicy("allow-all");

		cacheBehaviors.add(cacheBehavior);

		return cacheBehaviors;

	}

	public static DefaultCacheBehavior createDefaultCacheBehavior(HashMap map) {

		DefaultCacheBehavior cacheBehavior = new DefaultCacheBehavior();

		cacheBehavior.setAllowedMethods((ArrayList) map.get("allowedMethods"));

		cacheBehavior.setCompress(false);

		cacheBehavior.setDefaultTTL(120);

		// cacheBehavior.setFieldLevelEncryptionId(fieldLevelEncryptionId);

		// cacheBehavior.setForwardedValues(forwardedValues);

		// cacheBehavior.setLambdaFunctionAssociations(lambdaFunctionAssociations);

		cacheBehavior.setMaxTTL(120);

		cacheBehavior.setMinTTL(20);

		cacheBehavior.setSmoothStreaming((boolean) map.get("smoothStreaming"));

		cacheBehavior.setTargetOriginId(null);

		// cacheBehavior.setTrustedSigners(trustedSigners);

		cacheBehavior.setViewerProtocolPolicy("allow-all");

		return cacheBehavior;

	}

	public static ArrayList<Origins> createOrigin() {

		ArrayList<Origins> origins = new ArrayList();

		Origins origin = new Origins();

		origin.setCustomOriginConfig(createCustomOriginConfig());

		origin.setDomainName("");

		origin.setId("");

		// origin.setOriginCustomHeaders(originCustomHeaders);

		// origin.setOriginPath(originPath);

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

		// customOriginConfig.setOriginSSLProtocols(originSSLProtocols);

		return customOriginConfig;

	}

	public static S3OriginConfig createS3OriginConfig() {

		S3OriginConfig s3OriginConfig = new S3OriginConfig();

		s3OriginConfig.setOriginAccessIdentity("");

		return s3OriginConfig;

	}

	public static GeoRestriction createGeoRestriction() {

		GeoRestriction geoRestriction = new GeoRestriction();

		// geoRestriction.setLocations(locations);

		// geoRestriction.setRestrictionType(restrictionType);

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

	}*/
}

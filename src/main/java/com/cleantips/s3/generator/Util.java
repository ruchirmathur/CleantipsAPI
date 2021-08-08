package com.cleantips.s3.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CanonicalGrantee;
import com.amazonaws.services.s3.model.EmailAddressGrantee;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.cleantips.s3.bucket.model.AccelerateConfiguration;
import com.cleantips.s3.bucket.model.AnalyticsConfiguration;
import com.cleantips.s3.bucket.model.Bucket;
import com.cleantips.s3.bucket.model.BucketEncryption;
import com.cleantips.s3.bucket.model.CorsConfiguration;
import com.cleantips.s3.bucket.model.CorsRule;
import com.cleantips.s3.bucket.model.LifecycleConfiguration;
import com.cleantips.s3.bucket.model.Properties;
import com.cleantips.s3.bucket.model.RedirectAllRequestsTo;
import com.cleantips.s3.bucket.model.RedirectRule;
import com.cleantips.s3.bucket.model.RoutingRule;
import com.cleantips.s3.bucket.model.RoutingRuleCondition;
import com.cleantips.s3.bucket.model.Rule;
import com.cleantips.s3.bucket.model.VersioningConfiguration;
import com.cleantips.s3.bucket.model.WebsiteConfiguration;

public class Util {

	@SuppressWarnings("unused")
	public static Bucket createBucket(ConcurrentHashMap map, String regionName) {

		Bucket bucket = new Bucket();

		Properties properties = generateBucketProperties(bucket, regionName, map);

		bucket.setProperties(properties);

		return bucket;

	}

	private static Properties generateBucketProperties(Bucket bucket, String regionName, ConcurrentHashMap map) {

		Properties properties = new Properties();

		properties.setAccelerateConfiguration(createAccelerateConfig(regionName, map));

		if (map.get("privateaccess") != null) {

			properties.setAccessControl(AccessControl.Private.toString());

		}else if (map.get("fullaccess") != null) {
			
			properties.setAccessControl(AccessControl.PublicReadWrite.toString());
		}
		else if (map.get("readonlyaccess") != null) {
			
			properties.setAccessControl(AccessControl.PublicRead.toString());
		}
		if (map.get("analyticsConfigurations") != null
				&& !map.get("analyticsConfigurations").toString().equalsIgnoreCase("")) {

			properties.setAnalyticsConfigurations(createAnalytics(regionName, map));

		}
		if (map.get("bucketEncryption") != null && !map.get("bucketEncryption").toString().equalsIgnoreCase("")) {

			properties.setBucketEncryption(createBucketEncryption(regionName, map));

		}

		properties.setBucketName(getAlphaNumericString(8));

		if ((map.get("bucketType") != null && map.get("bucketType").toString().equalsIgnoreCase("bucketType"))||
				(map.get("website") != null && map.get("website").toString().equalsIgnoreCase("website"))||
				(map.get("app") != null && map.get("app").toString().equalsIgnoreCase("app"))||
				(map.get("webapp") != null && map.get("webapp").toString().equalsIgnoreCase("webapp"))||
				(map.get("static") != null && map.get("static").toString().equalsIgnoreCase("static"))) {

			properties.setBucketEncryption(null);

			properties.setAnalyticsConfigurations(null);

			properties.setCorsConfiguration(createCorsConfig(regionName, map));

			properties.setWebsiteConfiguration(createWebsiteConfig(regionName, map));

		}
		if (map.get("bucketType") != null && !map.get("bucketType").toString().equalsIgnoreCase("website")) {

			if (map.get("encryption") != null && !map.get("encryption").toString().equalsIgnoreCase("")) {

				properties.setBucketEncryption(createBucketEncryption(regionName, map));

			}
			if (map.get("loggingConfiguration") != null
					&& !map.get("loggingConfiguration").toString().equalsIgnoreCase("")) {

				// properties.setLoggingConfiguration(loggingConfiguration);
			}

			if (map.get("metricsConfigurations") != null
					&& !map.get("metricsConfigurations").toString().equalsIgnoreCase("")) {

				// properties.setMetricsConfigurations(metricsConfigurations);;
			}
			if (map.get("notificationConfiguration") != null
					&& !map.get("notificationConfiguration").toString().equalsIgnoreCase("")) {

				// properties.setNotificationConfiguration(notificationConfiguration);
			}
			if (map.get("objectLockConfiguration") != null
					&& !map.get("objectLockConfiguration").toString().equalsIgnoreCase("")) {

				// properties.setObjectLockConfiguration(objectLockConfiguration);
			}
			if (map.get("objectLockEnabled") != null && !map.get("objectLockEnabled").toString().equalsIgnoreCase("")) {

				properties.setObjectLockEnabled(true);
			}

			// properties.setTags(tags);
			// properties.setReplicationConfiguration(replicationConfiguration);

			if (map.get("publicAccessBlockConfiguration") != null
					&& !map.get("publicAccessBlockConfiguration").toString().equalsIgnoreCase("")) {

				// properties.setPublicAccessBlockConfiguration(createPublicAccessBlockConfiguration(regionName,map));

			}

		}
		if (map.get("lifeCycleConfiguration") != null
				&& !map.get("lifeCycleConfiguration").toString().equalsIgnoreCase("")) {

			properties.setLifecycleConfiguration(createLifeCycleConfiguration(regionName, map));

			if (map.get("inventoryConfiguration") != null
					&& !map.get("inventoryConfiguration").toString().equalsIgnoreCase("")) {

				properties.setInventoryConfigurations(null);
			}

			// properties.setVersioningConfiguration(createVersionConfig(regionName, map));
		}
		return properties;

	}

	@SuppressWarnings("unused")
	public static AccelerateConfiguration createAccelerateConfig(String regionName, ConcurrentHashMap map) {

		AccelerateConfiguration accelerateConfiguration = new AccelerateConfiguration();
		
		System.out.println("test:::"+map.get("acceleration").toString());

		if (map.get("acceleration") != null) {

			accelerateConfiguration.setAccelerationStatus(Accelerate.Enabled.toString());

		}else {
			
			accelerateConfiguration.setAccelerationStatus(Accelerate.Suspended.toString());
		}

		return accelerateConfiguration;

	}

	public static VersioningConfiguration createVersionConfig(String regionName, HashMap map) {

		VersioningConfiguration versioningConfiguration = new VersioningConfiguration();

		versioningConfiguration.setStatus("Enabled");

		return versioningConfiguration;

	}

	public static BucketEncryption createBucketEncryption(String regionName, ConcurrentHashMap map) {

		BucketEncryption bucketEncryption = new BucketEncryption();

		// bucketEncryption.setServerSideEncryptionConfiguration(serverSideEncryptionConfiguration);

		return bucketEncryption;

	}

	public static CorsConfiguration createCorsConfig(String regionName, ConcurrentHashMap map) {

		CorsConfiguration corsConfiguration = new CorsConfiguration();

		CorsRule corsRule = new CorsRule();

		corsRule.setAllowedHeaders(null);
		
		ArrayList<String> method=new ArrayList<String>();
		
		method.add("GET");
		method.add("POST");
		method.add("DELETE");
		method.add("HEAD");

		corsRule.setAllowedMethods(method);

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

	public static LifecycleConfiguration createLifeCycleConfiguration(String regionName, ConcurrentHashMap map) {

		LifecycleConfiguration lifecycleConfiguration = new LifecycleConfiguration();

		Rule rule = new Rule();

		rule.setAbortIncompleteMultipartUpload(null);

		rule.setExpirationInDays(null);

		lifecycleConfiguration.setRules(null);

		return lifecycleConfiguration;

	}

	public static WebsiteConfiguration createWebsiteConfig(String regionName, ConcurrentHashMap map) {

		WebsiteConfiguration websiteConfiguration = new WebsiteConfiguration();

		if (map.get("indexDocument") != null) {

			websiteConfiguration.setIndexDocument(map.get("indexDocument").toString());
		}

		websiteConfiguration.setRoutingRules(createRoutingRule(regionName, map));

		websiteConfiguration.setErrorDocument("error.html");

		// websiteConfiguration.setRedirectAllRequestsTo(createRedirectRule(regionName,map));

		return websiteConfiguration;

	}

	public static RedirectAllRequestsTo createRedirectRule(String regionName, HashMap map) {

		RedirectAllRequestsTo redirectAllRequestsTo = new RedirectAllRequestsTo();

		redirectAllRequestsTo.setHostName("test");

		redirectAllRequestsTo.setProtocol("https");

		return redirectAllRequestsTo;

	}

	public static ArrayList<AnalyticsConfiguration> createAnalytics(String regionName, ConcurrentHashMap map) {

		AnalyticsConfiguration analyticsConfiguration = new AnalyticsConfiguration();

		ArrayList<AnalyticsConfiguration> list = new ArrayList<AnalyticsConfiguration>();

		// analyticsConfiguration.setId(id);

		// analyticsConfiguration.setPrefix(prefix);

		// analyticsConfiguration.setStorageClassAnalysis(storageClassAnalysis);

		// analyticsConfiguration.setTagFilters(tagFilters);

		return list;

	}

	public static ArrayList<RoutingRule> createRoutingRule(String regionName, ConcurrentHashMap map) {

		RoutingRule routingRule = new RoutingRule();

		RedirectRule redirectRule = new RedirectRule();

		redirectRule.setHostName("test");

		redirectRule.setHttpRedirectCode("302");

		redirectRule.setProtocol("http");

		RoutingRuleCondition routingRuleCondition = new RoutingRuleCondition();

		routingRuleCondition.setHttpErrorCodeReturnedEquals("404");

		routingRuleCondition.setKeyPrefixEquals("report-404/");

		routingRule.setRedirectRule(redirectRule);

		routingRule.setRoutingRuleCondition(routingRuleCondition);

		ArrayList routingRules = new ArrayList();

		routingRules.add(routingRule);

		return routingRules;

	}

	public static String getBucketLocation(ConcurrentHashMap map, String region, File file, String type) {

		String bucketName = map.get("architecture").toString();

		System.out.println("bucketName:::" + bucketName);
		System.out.println("type:::" + type);
		System.out.println("region:::" + region);

		String finalBucketName = "dsadweewwe".concat(type.toLowerCase());

		System.out.println("bucker nme::::" + finalBucketName);

		final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();

		if (!s3.doesBucketExistV2(finalBucketName)) {

			System.out.println("finalBucketName nme::::" + finalBucketName);

			com.amazonaws.services.s3.model.Bucket bucket = s3.createBucket(finalBucketName);
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

		return bucketLocation;

	}

	static String getAlphaNumericString(int n) {

		// chose a Character random from this String
		String AlphaNumericString = "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}
	
	enum Accelerate 
    { 
        Enabled, Suspended; 
    } 
	enum AccessControl {
		Private, PublicRead, PublicReadWrite, AuthenticatedRead, LogDeliveryWrite, BucketOwnerRead, BucketOwnerFullControl,AwsExecRead
	}
}

/*
 * 
 */
package com.cleantips.route53.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.StringUtils;
import com.cleantips.route53.hostedzone.model.HostedZone;
import com.cleantips.route53.hostedzone.model.HostedZoneConfig;
import com.cleantips.route53.hostedzone.model.HostedZoneTag;
import com.cleantips.route53.hostedzone.model.Properties;
import com.cleantips.route53.hostedzone.model.VPC;
import com.cleantips.route53.recordset.model.AliasTarget;
import com.cleantips.route53.recordset.model.Geolocation;
import com.cleantips.route53.recordset.model.RecordSet;
import com.cleantips.route53.recordset.model.Ref;

/**
 * The Class Util.
 */
public class Util {

	/**
	 * This method is used to create a hosted zone on route 53.
	 *
	 * @param map        the map
	 * @param regionName the region name
	 * @return the hosted zone
	 */
	public static HostedZone createHostedZone(HashMap<?, ?> map) {

		HostedZone hostedZone = new HostedZone();

		Properties properties = generateHostedZoneProperties(map, hostedZone);

		hostedZone.setProperties(properties);

		return hostedZone;

	}

	/**
	 * This method is used to create a record set in Route53.
	 *
	 * @param map        the map
	 * @param regionName the region name
	 * @return the record set
	 */
	public static RecordSet createRecordSet(HashMap<?, ?> map) {

		RecordSet recordSet = new RecordSet();

		com.cleantips.route53.recordset.model.Properties properties = generateRecordSetProperties(map, recordSet);

		recordSet.setProperties(properties);

		return recordSet;

	}

	/**
	 * This method generates the Hosted Zone properties.
	 *
	 * @param map        the map
	 * @param hostedZone the hosted zone
	 * @param regionName the region name
	 * @return the properties
	 */
	private static Properties generateHostedZoneProperties(HashMap<?, ?> map, HostedZone hostedZone) {

		Properties properties = new Properties();

		String regionName = null;

		if (map.get("regionName") != null) {

			properties.setHostedZoneConfig(createHostedZoneConfig(map, regionName));

			properties.setHostedZoneTags(null);

			if (map.get("domainName") != null && !StringUtils.isNullOrEmpty(map.get("domainName").toString())) {

				properties.setName(map.get("domainName").toString());
			}

			// properties.setQueryLoggingConfig(queryLoggingConfig);

			if (map.get("isPublic") != null && !StringUtils.isNullOrEmpty(map.get("isPublic").toString())
					&& map.get("isPublic").toString().equalsIgnoreCase("false")) {

				// properties.setVPCs(createVPC(map, regionName));
			}
		} else {
			
			properties = null;
		}
		return properties;

	}

	/**
	 * Generate record set properties.
	 *
	 * @param map        the map
	 * @param recordSet  the record set
	 * @param regionName the region name
	 * @return the com.cleantips.route 53 .recordset.model. properties
	 */
	private static com.cleantips.route53.recordset.model.Properties generateRecordSetProperties(HashMap<?, ?> map,
			RecordSet recordSet) {

		com.cleantips.route53.recordset.model.Properties properties = new com.cleantips.route53.recordset.model.Properties();
		
		if (map.get("regionName")!=null) {

		String regionName = map.get("regionName").toString();
				
		}

		Ref hostedZoneId = new Ref();

		hostedZoneId.setRef("HostedZone");

		properties.setAliasTarget(createAliasTarget(map));

		properties.setComment("Creating a record set");

		// properties.setFailover(failover);

		// properties.setGeoLocation(createGeolocation(map));

		// properties.setHealthCheckId(healthCheckId);

		properties.setHostedZoneId(hostedZoneId);

		//properties.setHostedZoneName(hostedZoneName);

		// properties.setMultiValueAnswer(multiValueAnswer);

		// properties.setName(name);

		//properties.setRegion(regionName);

		// properties.setResourceRecords(resourceRecords);

		// properties.setSetIdentifier(setIdentifier);

		// properties.setTTL(tTL);
		if (map.get("source") != null && map.get("source").toString().equalsIgnoreCase("Cloudfront")) {

			properties.setType("A");

		}

		// properties.setWeight(weight);
		return properties;

	}

	/**
	 * Creates the alias target.
	 *
	 * @return the alias target
	 */
	public static AliasTarget createAliasTarget(HashMap<?, ?> map) {

		AliasTarget aliasTarget = new AliasTarget();

		Ref hostedZone = new Ref();

		hostedZone.setRef("HostedZone");

		Ref dnsName = new Ref();

		dnsName.setRef("DnsName");

		aliasTarget.setDNSName(dnsName);

		// aliasTarget.setEvaluateTargetHealth(null);

		aliasTarget.setHostedZoneId(hostedZone);

		return aliasTarget;

	}

	/**
	 * Creates the geolocation.
	 *
	 * @param map the map
	 * @return the geolocation
	 */
	public static Geolocation createGeolocation(HashMap<?, ?> map) {

		Geolocation geolocation = new Geolocation();

		geolocation.setContinentCode(map.get("continent").toString());

		geolocation.setCountryCode(map.get("countryCode").toString());

		// geolocation.setSubdivisionCode(map.get("subDivisionCode").toString());

		return geolocation;

	}

	/**
	 * This method provides a comment on the Hosted zone created.
	 *
	 * @param map        the map
	 * @param regionName the region name
	 * @return the hosted zone config
	 */
	@SuppressWarnings("unused")
	public static HostedZoneConfig createHostedZoneConfig(HashMap<?, ?> map, String regionName) {

		HostedZoneConfig hostedZoneConfig = new HostedZoneConfig();

		hostedZoneConfig.setComment("This is a public hosted zone");

		return hostedZoneConfig;

	}

	/**
	 * Creates the VPC.
	 *
	 * @param map        the map
	 * @param regionName the region name
	 * @return the array list
	 */
	@SuppressWarnings("unused")
	public static ArrayList<VPC> createVPC(HashMap<?, ?> map, String regionName) {

		VPC vpc = new VPC();

		return null;

	}

	/**
	 * Creates the hosted zone tag.
	 *
	 * @return the array list
	 */
	@SuppressWarnings("unused")
	public static ArrayList<HostedZoneTag> createHostedZoneTag() {

		ArrayList<HostedZoneTag> hostedZoneTags = new ArrayList<HostedZoneTag>();

		HostedZoneTag hostedZoneTag = new HostedZoneTag();

		hostedZoneTag.setKey("");

		hostedZoneTag.setValue("");

		hostedZoneTags.add(hostedZoneTag);

		return hostedZoneTags;

	}

	/**
	 * Gets the bucket location where the template is stored
	 *
	 * @param map    the map
	 * @param region the region
	 * @param file   the file
	 * @param type   the type
	 * @return the bucket location
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	public static String getBucketLocation(HashMap map, File file, String type) {

		String bucketLocation = null;

		String bucketName = null;

		String finalBucketName = null;

		try {

			if (map.get("architecture") != null) {

				finalBucketName = bucketName.concat(type.toLowerCase());

				final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();

				if (!s3.doesBucketExistV2(finalBucketName)) {

					Bucket bucket = s3.createBucket(finalBucketName);

				}
				PutObjectRequest request = new PutObjectRequest(finalBucketName, type, file);

				ObjectMetadata metadata = new ObjectMetadata();

				metadata.setContentType("plain/text");

				metadata.addUserMetadata("x-amz-meta-title", "someTitle");

				request.setMetadata(metadata);

				s3.putObject(request);

				bucketLocation = s3.getUrl(finalBucketName, type).toExternalForm();

			} else {
				
				bucketLocation = null;
			}

		} catch (Exception ex) {

			ex.printStackTrace();

			bucketLocation = null;
		}

		return bucketLocation;

	}
}

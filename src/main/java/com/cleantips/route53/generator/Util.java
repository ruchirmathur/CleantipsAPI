package com.cleantips.route53.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.cleantips.route53.hostedzone.model.HostedZone;
import com.cleantips.route53.hostedzone.model.HostedZoneConfig;
import com.cleantips.route53.hostedzone.model.HostedZoneTag;
import com.cleantips.route53.hostedzone.model.Properties;
import com.cleantips.route53.recordset.model.AliasTarget;
import com.cleantips.route53.recordset.model.Geolocation;
import com.cleantips.route53.recordset.model.RecordSet;
import com.cleantips.route53.recordset.model.Ref;

public class Util {

	@SuppressWarnings("unused")
	public static HostedZone createHostedZone(HashMap map, String regionName) {

		HostedZone hostedZone = new HostedZone();

		//Properties properties = generateHostedZoneProperties(map,hostedZone, regionName);
		
		//hostedZone.setProperties(properties);

		return hostedZone;

	}
	/*public static HostedZone createRecordSet(HashMap map, String regionName) {

		RecordSet recordSet = new RecordSet();

		Properties properties = generateRecordSetProperties(map,hostedZone, regionName);
		
		recordSet.setProperties(properties);

		return recordSet;

	}*/

	/*private static Properties generateHostedZoneProperties(HashMap map,HostedZone hostedZone, String regionName) {

		Properties properties = new Properties();

		properties.setHostedZoneConfig(createHostedZoneConfig());
		
		properties.setHostedZoneTags(null);
		
		properties.setName(map.get("domainName").toString());	
	
		return properties;

	}
	/*private static com.cleantips.route53.recordset.model.Properties generateRecordSetProperties(HashMap map,RecordSet recordSet, String regionName) {

		com.cleantips.route53.recordset.model.Properties properties = new com.cleantips.route53.recordset.model.Properties();

		properties.setAliasTarget(createAliasTarget());	
		
		properties.setComment("Creating a record set");
		
		properties.setFailover(failover);
		
		properties.setGeoLocation(createGeolocation(map));
		
		properties.setHealthCheckId(healthCheckId);
		
		properties.setHostedZoneId(hostedZoneId);

		properties.setHostedZoneName(hostedZoneName);
		
		properties.setMultiValueAnswer(multiValueAnswer);
		
		properties.setName(name);
		
		properties.setRegion(region);
		
		properties.setResourceRecords(resourceRecords);
		
		properties.setSetIdentifier(setIdentifier);
		
		properties.setTTL(tTL);
		
		properties.setType(type);

		properties.setWeight(weight);
		return properties;

	}
	public static AliasTarget createAliasTarget() {

		AliasTarget aliasTarget = new AliasTarget();
		
		Ref ref= new Ref();
		
		ref.setRef("HostedZone");
		
		aliasTarget.setDNSName(dNSName);
		
		//aliasTarget.setEvaluateTargetHealth(null);

		aliasTarget.setHostedZoneId(ref);
		
		return hostedZoneConfig;

	}
	public static Geolocation createGeolocation(HashMap map) {

		Geolocation geolocation = new Geolocation();
		
		geolocation.setContinentCode(map.get("continent").toString());
		
		geolocation.setCountryCode(map.get("countryCode").toString());
		
		//geolocation.setSubdivisionCode(subdivisionCode);
		
		return geolocation;

	}           
	@SuppressWarnings("unused")
	public static HostedZoneConfig createHostedZoneConfig() {

		HostedZoneConfig hostedZoneConfig = new HostedZoneConfig();
		
		hostedZoneConfig.setComment("This is a public hosted zone");

		return hostedZoneConfig;

	}
	@SuppressWarnings("unused")
	public static ArrayList<HostedZoneTag> createHostedZoneTag() {
		
		ArrayList hostedZoneTags = new ArrayList();

		HostedZoneTag hostedZoneTag = new HostedZoneTag();
		
		hostedZoneTag.setKey("");
		
		hostedZoneTag.setValue("");
		
		hostedZoneTags.add(hostedZoneTag);

		return hostedZoneTags;

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

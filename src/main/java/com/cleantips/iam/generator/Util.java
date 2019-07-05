/*
 * 
 */
package com.cleantips.iam.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.amazonaws.services.appstream.model.DescribeImagesRequest;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.cleantips.iam.group.model.Group;
import com.cleantips.iam.group.model.Policy;
import com.cleantips.iam.group.model.PolicyDocument;
import com.cleantips.iam.group.model.Properties;
import com.cleantips.iam.group.model.Statement;

// TODO: Auto-generated Javadoc
/**
 * The Class Util.
 */
public class Util {

	/**
	 * Creates the group.
	 *
	 * @param map the map
	 * @return the group
	 */
	@SuppressWarnings("unused")
	public static Group createGroup(HashMap map) {

		Group group = new Group();

		Properties properties = generateGroupProperties(map);

		group.setProperties(properties);
		

		return group;

	}

	/**
	 * Generate group properties.
	 *
	 * @param map the map
	 * @return the properties
	 */
	private static Properties generateGroupProperties(HashMap map) {
		

		Properties properties = new Properties();

	//	Ref imageTypeRef = new Ref();

		//Ref instanceTypeRef = new Ref();

		//Ref keyNameRef = new Ref();

		properties.setGroupName(map.get("groupName").toString());
		
		properties.setPolicies(setUpPolicy(map));
		
		return null;
		
	}
	
	/**
	 * Sets the up policy.
	 *
	 * @param map the map
	 * @return the array list
	 */
	private static ArrayList<Policy> setUpPolicy(HashMap map) {
		

		ArrayList<Policy> policyList = new ArrayList();
		
		Policy policy = new Policy();
		
		policy.setPolicyDocument(setUpPolicyDocument(map));
		
		policy.setPolicyName(map.get("policyName").toString());
		
		policyList.add(policy);
		
		return policyList;
		
	}
	
	/**
	 * Sets the up policy document.
	 *
	 * @param map the map
	 * @return the policy document
	 */
	private static PolicyDocument setUpPolicyDocument(HashMap map) {
		
		PolicyDocument policyDocument = new PolicyDocument();
		
		ArrayList<Statement> statementList = new ArrayList();
		
		Statement statement = new Statement();
		
		//statement.setAction(action);
		
		//statement.setEffect(effect);

		statementList.add(statement);
		
		policyDocument.setStatement(statementList);
		
		return policyDocument;
		
	}

	/**
	 * Gets the bucket location where the template is stored.
	 *
	 * @param map    the map
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

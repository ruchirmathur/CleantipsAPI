/*
 * 
 */
package com.cleantips.iam.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.cleantips.iam.group.model.Group;
import com.cleantips.iam.policy.model.Policy;
import com.cleantips.iam.policy.model.PolicyDocument;
import com.cleantips.iam.group.model.Properties;
import com.cleantips.iam.policy.model.Statement;
import com.cleantips.iam.user.model.User;
import com.cleantips.iam.usertogroup.model.UserToGroupAddition;

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
	public static Group createGroup(HashMap<?, ?> propertyMap) {

		Group gr = null;

		Properties properties = null;

		HashMap<String, Object> groupMap = null;

		String name = null;

		ArrayList users = null;

		if (propertyMap != null && propertyMap.size() > 0) {

			for (Entry<?, ?> entry : propertyMap.entrySet()) {

				if (entry.getKey() != null) {

					if (entry.getKey().toString().equalsIgnoreCase("group")) {

						System.out.println("test:::" + entry.getValue());

						ArrayList group = (ArrayList) entry.getValue();

						groupMap = new HashMap();

						for (int i = 0; i < group.size(); i++) {

							System.out.println("test:::" + group.get(i));

							HashMap map = (HashMap) group.get(i);

							properties = new Properties();

							gr = new Group();

							if (map.get("name") != null) {

								properties.setGroupName(map.get("name").toString());

								gr.setProperties(properties);


							}

						}

					}
				}
			}
		}

		return gr;

	}

	@SuppressWarnings("unused")
	public static User createUser(HashMap<?, ?> propertyMap) {

		User user = null;

		com.cleantips.iam.user.model.Properties properties = null;

		HashMap<String, Object> userMap = null;

		String name = null;

		ArrayList users = null;
		
		ArrayList groups = new ArrayList() ;

		HashMap umap = null;

		if (propertyMap != null && propertyMap.size() > 0) {

			for (Entry<?, ?> entry : propertyMap.entrySet()) {

				if (entry.getKey() != null) {

					if (entry.getKey().toString().equalsIgnoreCase("group")) {

						System.out.println("test:::" + entry.getValue());

						ArrayList group = (ArrayList) entry.getValue();

						for (int i = 0; i < group.size(); i++) {

							System.out.println("test:::" + group.get(i));

							HashMap map = (HashMap) group.get(i);
							

							userMap = new HashMap();

							if (map.get("user") != null) {

								ArrayList userss = (ArrayList) map.get("user");
								

								for (int j = 0; j < userss.size(); j++) {
									
									properties = new com.cleantips.iam.user.model.Properties();

									user = new User();

									umap = (HashMap) userss.get(j);

									if (umap.get("user") != null) {

										System.out.println("test::user:" + umap.get("user").toString());
										
										groups.add(map.get("name").toString());
										
										properties.setGroups(groups);

										properties.setUserName(umap.get("user").toString());

										user.setProperties(properties);

									}

								}

							}

						}
					}
				}
			}
		}

		return user;

	}
	
	@SuppressWarnings("unused")
	public static UserToGroupAddition createUserToGroupAddition(HashMap<?, ?> propertyMap) {

		UserToGroupAddition user = null;

		com.cleantips.iam.usertogroup.model.Properties properties = null;

		HashMap<String, Object> userMap = null;

		String name = null;

		ArrayList users = null;
		
		ArrayList us = new ArrayList() ;

		HashMap umap = null;

		if (propertyMap != null && propertyMap.size() > 0) {

			for (Entry<?, ?> entry : propertyMap.entrySet()) {

				if (entry.getKey() != null) {

					if (entry.getKey().toString().equalsIgnoreCase("group")) {

						System.out.println("test:::" + entry.getValue());

						ArrayList group = (ArrayList) entry.getValue();

						for (int i = 0; i < group.size(); i++) {

							System.out.println("test:::" + group.get(i));

							HashMap map = (HashMap) group.get(i);
							

							userMap = new HashMap();

							if (map.get("user") != null) {

								ArrayList userss = (ArrayList) map.get("user");
								

								for (int j = 0; j < userss.size(); j++) {
									
									properties = new com.cleantips.iam.usertogroup.model.Properties();

									user = new UserToGroupAddition();

									umap = (HashMap) userss.get(j);

									if (umap.get("user") != null) {

										System.out.println("test::user:" + umap.get("user").toString());
									    
										us = new ArrayList();
										
										us.add(umap.get("user").toString());
										
										properties.setGroupName(map.get("name").toString());

										properties.setUsers(us);

										user.setProperties(properties);

									}

								}

							}

						}
					}
				}
			}
		}

		return user;

	}

	@SuppressWarnings("unused")
	public static Policy createPolicy(HashMap<?, ?> propertyMap) {

		Policy policy = new Policy();

		com.cleantips.iam.policy.model.Properties properties = null;

		HashMap<String, Object> userMap = null;

		String name = null;

		ArrayList users = null;
		
		ArrayList us = new ArrayList() ;
		
		ArrayList groups = new ArrayList() ;

		HashMap umap = null;
		
		PolicyDocument policyDocument= new PolicyDocument();
		
		Statement statement = new Statement();
		
		ArrayList statements = new ArrayList() ;

		if (propertyMap != null && propertyMap.size() > 0) {

			for (Entry<?, ?> entry : propertyMap.entrySet()) {

				if (entry.getKey() != null) {

					if (entry.getKey().toString().equalsIgnoreCase("group")) {

						System.out.println("test:::" + entry.getValue());

						ArrayList group = (ArrayList) entry.getValue();

						for (int i = 0; i < group.size(); i++) {

							System.out.println("test:::" + group.get(i));

							HashMap map = (HashMap) group.get(i);
							

							userMap = new HashMap();

							if (map.get("user") != null) {

								ArrayList userss = (ArrayList) map.get("user");
								

								for (int j = 0; j < userss.size(); j++) {
									
									properties = new com.cleantips.iam.policy.model.Properties();

									policy = new Policy();

									umap = (HashMap) userss.get(j);

									if (umap.get("user") != null) {

										System.out.println("test::user:" + umap.get("user").toString());
									    
										us = new ArrayList();
										
										us.add(umap.get("user").toString());
										
										groups.add(map.get("name").toString());
										
										properties.setGroupName(groups);

										properties.setUsers(us);
										
										//statement.setAction(action);
										
										//statement.setEffect(effect);
										
										//statement.setResource(resource);
										
										statements.add(statement);
										
										policyDocument.setStatement(statements);
										
										properties.setPolicyDocument(policyDocument);
										

										policy.setProperties(properties);

									}

								}

							}

						}
					}
				}
			}
		}

		return policy;

	}

	/**
	 * Sets the up policy.
	 *
	 * @param map the map
	 * @return the array list
	 */
	private static ArrayList<com.cleantips.iam.group.model.Policy> setUpPolicy(HashMap map) {

		ArrayList<com.cleantips.iam.group.model.Policy> policyList = new ArrayList();

		com.cleantips.iam.group.model.Policy policy = new com.cleantips.iam.group.model.Policy();

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
	private static com.cleantips.iam.group.model.PolicyDocument setUpPolicyDocument(HashMap map) {

		com.cleantips.iam.group.model.PolicyDocument policyDocument = new com.cleantips.iam.group.model.PolicyDocument();

		ArrayList<com.cleantips.iam.group.model.Statement> statementList = new ArrayList();

		com.cleantips.iam.group.model.Statement statement = new com.cleantips.iam.group.model.Statement();

		// statement.setAction(action);

		// statement.setEffect(effect);

		statementList.add(statement);

		policyDocument.setStatement(statementList);

		return policyDocument;

	}

	/**
	 * Gets the bucket location where the template is stored.
	 *
	 * @param map  the map
	 * @param file the file
	 * @param type the type
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

package com.cleantips.iam.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.amazonaws.services.appstream.model.DescribeImagesRequest;
import com.cleantips.iam.group.model.Group;
import com.cleantips.iam.group.model.Policy;
import com.cleantips.iam.group.model.PolicyDocument;
import com.cleantips.iam.group.model.Properties;
import com.cleantips.iam.group.model.Statement;

public class Util {

	@SuppressWarnings("unused")
	public static Group createGroup(HashMap map) {

		Group group = new Group();

		Properties properties = generateGroupProperties(map);

		group.setProperties(properties);
		

		return group;

	}

	private static Properties generateGroupProperties(HashMap map) {
		

		Properties properties = new Properties();

	//	Ref imageTypeRef = new Ref();

		//Ref instanceTypeRef = new Ref();

		//Ref keyNameRef = new Ref();

		properties.setGroupName(map.get("groupName").toString());
		
		properties.setPolicies(setUpPolicy(map));
		
		return null;
		
	}
	
	private static ArrayList<Policy> setUpPolicy(HashMap map) {
		

		ArrayList<Policy> policyList = new ArrayList();
		
		Policy policy = new Policy();
		
		policy.setPolicyDocument(setUpPolicyDocument(map));
		
		policy.setPolicyName(map.get("policyName").toString());
		
		policyList.add(policy);
		
		return policyList;
		
	}
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
}

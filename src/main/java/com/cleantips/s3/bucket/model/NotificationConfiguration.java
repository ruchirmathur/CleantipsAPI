package com.cleantips.s3.bucket.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class NotificationConfiguration {

private ArrayList<LambdaConfiguration> LambdaConfigurations;
private ArrayList<QueueConfiguration> QueueConfigurations;
private ArrayList<TopicConfiguration> TopicConfigurations;
public ArrayList<LambdaConfiguration> getLambdaConfigurations() {
	return LambdaConfigurations;
}
public void setLambdaConfigurations(ArrayList<LambdaConfiguration> lambdaConfigurations) {
	LambdaConfigurations = lambdaConfigurations;
}
public ArrayList<QueueConfiguration> getQueueConfigurations() {
	return QueueConfigurations;
}
public void setQueueConfigurations(ArrayList<QueueConfiguration> queueConfigurations) {
	QueueConfigurations = queueConfigurations;
}
public ArrayList<TopicConfiguration> getTopicConfigurations() {
	return TopicConfigurations;
}
public void setTopicConfigurations(ArrayList<TopicConfiguration> topicConfigurations) {
	TopicConfigurations = topicConfigurations;
}
}

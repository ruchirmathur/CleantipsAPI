package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class TopicConfiguration {
private String Event;
private NotificationFilter Filter;
public String getEvent() {
	return Event;
}
public void setEvent(String event) {
	Event = event;
}
public String getTopic() {
	return Topic;
}
public void setTopic(String topic) {
	Topic = topic;
}
private String Topic;
}

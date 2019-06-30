package com.cleantips.s3.bucket.model;

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

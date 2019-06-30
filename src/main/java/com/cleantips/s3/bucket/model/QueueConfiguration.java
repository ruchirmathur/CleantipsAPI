package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class QueueConfiguration {
private String Event;
private NotificationFilter Filter;
public String getEvent() {
	return Event;
}
public void setEvent(String event) {
	Event = event;
}
public NotificationFilter getFilter() {
	return Filter;
}
public void setFilter(NotificationFilter filter) {
	Filter = filter;
}
public String getQueue() {
	return Queue;
}
public void setQueue(String queue) {
	Queue = queue;
}
private String Queue;
}

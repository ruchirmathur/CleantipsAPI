package com.cleantips.s3.bucket.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class LambdaConfiguration {
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
public String getFunction() {
	return Function;
}
public void setFunction(String function) {
	Function = function;
}
private String Function;
}

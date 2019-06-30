package com.cleantips.s3.bucket.model;

import java.util.ArrayList;

public class WebsiteConfiguration {
private String ErrorDocument;
private String IndexDocument;
public String getErrorDocument() {
	return ErrorDocument;
}
public void setErrorDocument(String errorDocument) {
	ErrorDocument = errorDocument;
}
public String getIndexDocument() {
	return IndexDocument;
}
public void setIndexDocument(String indexDocument) {
	IndexDocument = indexDocument;
}
public RedirectAllRequestsTo getRedirectAllRequestsTo() {
	return RedirectAllRequestsTo;
}
public void setRedirectAllRequestsTo(RedirectAllRequestsTo redirectAllRequestsTo) {
	RedirectAllRequestsTo = redirectAllRequestsTo;
}
public ArrayList<RoutingRule> getRoutingRules() {
	return RoutingRules;
}
public void setRoutingRules(ArrayList<RoutingRule> routingRules) {
	RoutingRules = routingRules;
}
private RedirectAllRequestsTo RedirectAllRequestsTo;
private ArrayList<RoutingRule> RoutingRules;
}

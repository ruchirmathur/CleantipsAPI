package com.cleantips.s3.bucket.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Rule {
public ArrayList<Transition> getTransitions() {
		return Transitions;
	}
	public void setTransitions(ArrayList<Transition> transitions) {
		Transitions = transitions;
	}
private AbortIncompleteMultipartUpload AbortIncompleteMultipartUpload;
private String ExpirationDate;
private String ExpirationInDays;
private String Id;
private String NoncurrentVersionExpirationInDays;
private NoncurrentVersionTransition NoncurrentVersionTransition;
private ArrayList<NoncurrentVersionTransition> NoncurrentVersionTransitions;
private String Prefix;
private String Status;
private ArrayList<TagFilters> TagFilter;
private Transition Transition;
private ArrayList<Transition> Transitions;
public AbortIncompleteMultipartUpload getAbortIncompleteMultipartUpload() {
	return AbortIncompleteMultipartUpload;
}
public void setAbortIncompleteMultipartUpload(AbortIncompleteMultipartUpload abortIncompleteMultipartUpload) {
	AbortIncompleteMultipartUpload = abortIncompleteMultipartUpload;
}
public String getExpirationDate() {
	return ExpirationDate;
}
public void setExpirationDate(String expirationDate) {
	ExpirationDate = expirationDate;
}
public String getExpirationInDays() {
	return ExpirationInDays;
}
public void setExpirationInDays(String expirationInDays) {
	ExpirationInDays = expirationInDays;
}
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
public String getNoncurrentVersionExpirationInDays() {
	return NoncurrentVersionExpirationInDays;
}
public void setNoncurrentVersionExpirationInDays(String noncurrentVersionExpirationInDays) {
	NoncurrentVersionExpirationInDays = noncurrentVersionExpirationInDays;
}
public NoncurrentVersionTransition getNoncurrentVersionTransition() {
	return NoncurrentVersionTransition;
}
public void setNoncurrentVersionTransition(NoncurrentVersionTransition noncurrentVersionTransition) {
	NoncurrentVersionTransition = noncurrentVersionTransition;
}
public ArrayList<NoncurrentVersionTransition> getNoncurrentVersionTransitions() {
	return NoncurrentVersionTransitions;
}
public void setNoncurrentVersionTransitions(ArrayList<NoncurrentVersionTransition> noncurrentVersionTransitions) {
	NoncurrentVersionTransitions = noncurrentVersionTransitions;
}
public String getPrefix() {
	return Prefix;
}
public void setPrefix(String prefix) {
	Prefix = prefix;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
public ArrayList<TagFilters> getTagFilter() {
	return TagFilter;
}
public void setTagFilter(ArrayList<TagFilters> tagFilter) {
	TagFilter = tagFilter;
}
public Transition getTransition() {
	return Transition;
}
public void setTransition(Transition transition) {
	Transition = transition;
}
}

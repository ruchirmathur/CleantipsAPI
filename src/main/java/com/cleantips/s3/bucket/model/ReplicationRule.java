package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class ReplicationRule {
private ReplicationDestination Destination;
private String Id;
private String Prefix;
public ReplicationDestination getDestination() {
	return Destination;
}
public void setDestination(ReplicationDestination destination) {
	Destination = destination;
}
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
public String getPrefix() {
	return Prefix;
}
public void setPrefix(String prefix) {
	Prefix = prefix;
}
public SourceSelectionCriteria getSourceSelectionCriteria() {
	return SourceSelectionCriteria;
}
public void setSourceSelectionCriteria(SourceSelectionCriteria sourceSelectionCriteria) {
	SourceSelectionCriteria = sourceSelectionCriteria;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
private SourceSelectionCriteria SourceSelectionCriteria;
private String Status;
}

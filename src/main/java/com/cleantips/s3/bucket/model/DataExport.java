package com.cleantips.s3.bucket.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class DataExport {
private Destination Destination;
public Destination getDestination() {
	return Destination;
}
public void setDestination(Destination destination) {
	Destination = destination;
}
public String getOutputSchemaVersion() {
	return OutputSchemaVersion;
}
public void setOutputSchemaVersion(String outputSchemaVersion) {
	OutputSchemaVersion = outputSchemaVersion;
}
private String OutputSchemaVersion;

}

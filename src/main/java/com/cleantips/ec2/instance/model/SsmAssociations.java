package com.cleantips.ec2.instance.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class SsmAssociations {
private ArrayList<Parameters> AssociationParameters;
private String DocumentName;
public ArrayList<Parameters> getAssociationParameters() {
	return AssociationParameters;
}
public void setAssociationParameters(ArrayList<Parameters> associationParameters) {
	AssociationParameters = associationParameters;
}
public String getDocumentName() {
	return DocumentName;
}
public void setDocumentName(String documentName) {
	DocumentName = documentName;
}
}

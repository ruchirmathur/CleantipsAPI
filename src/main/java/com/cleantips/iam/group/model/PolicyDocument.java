package com.cleantips.iam.group.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class PolicyDocument {
public String getVersion() {
		return Version;
	}
	public void setVersion(String version) {
		Version = version;
	}
	public ArrayList<Statement> getStatement() {
		return Statement;
	}
	public void setStatement(ArrayList<Statement> statement) {
		Statement = statement;
	}
private String Version ="2012-10-17";
private ArrayList<Statement> Statement;
}

package com.cleantips.model;

import java.util.ArrayList;
import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Template {
	@JsonProperty("AWSTemplateFormatVersion")
	private String AWSTemplateFormatVersion;
	private String Description;
	private Metadata Metadata;
	public HashMap<String, Stack> getResources() {
		return Resources;
	}

	public void setResources(HashMap<String, Stack> resources) {
		Resources = resources;
	}

	private Parameters Parameters;
	private Mappings Mappings;
	private Conditions Conditions;
	private Transform Transform;
	private HashMap<String,Stack> Resources;
	private HashMap Outputs;
	@JsonProperty("AWSTemplateFormatVersion")
	public String getAWSTemplateFormatVersion() {
		return AWSTemplateFormatVersion;
	}

	public void setAWSTemplateFormatVersion(String aWSTemplateFormatVersion) {
		AWSTemplateFormatVersion = aWSTemplateFormatVersion;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Metadata getMetadata() {
		return Metadata;
	}

	public void setMetadata(Metadata metadata) {
		Metadata = metadata;
	}

	public Parameters getParameters() {
		return Parameters;
	}

	public void setParameters(Parameters parameters) {
		Parameters = parameters;
	}

	public Mappings getMappings() {
		return Mappings;
	}

	public void setMappings(Mappings mappings) {
		Mappings = mappings;
	}

	public Conditions getConditions() {
		return Conditions;
	}

	public void setConditions(Conditions conditions) {
		Conditions = conditions;
	}

	public Transform getTransform() {
		return Transform;
	}

	public void setTransform(Transform transform) {
		Transform = transform;
	}

	public HashMap getOutputs() {
		return Outputs;
	}

	public void setOutputs(HashMap outputs) {
		Outputs = outputs;
	}

}

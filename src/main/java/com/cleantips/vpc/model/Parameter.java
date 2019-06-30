package com.cleantips.vpc.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Parameter {
	private String AllowedPattern;
	private ArrayList AllowedValues;
	private String ConstraintDescription;
	private String Default;
	private String Description;
	public String getAllowedPattern() {
		return AllowedPattern;
	}
	public void setAllowedPattern(String allowedPattern) {
		AllowedPattern = allowedPattern;
	}
	public ArrayList getAllowedValues() {
		return AllowedValues;
	}
	public void setAllowedValues(ArrayList allowedValues) {
		AllowedValues = allowedValues;
	}
	public String getConstraintDescription() {
		return ConstraintDescription;
	}
	public void setConstraintDescription(String constraintDescription) {
		ConstraintDescription = constraintDescription;
	}
	public String getDefault() {
		return Default;
	}
	public void setDefault(String default1) {
		Default = default1;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Integer getMaxLength() {
		return MaxLength;
	}
	public void setMaxLength(Integer maxLength) {
		MaxLength = maxLength;
	}
	public Integer getMaxValue() {
		return MaxValue;
	}
	public void setMaxValue(Integer maxValue) {
		MaxValue = maxValue;
	}
	public Integer getMinLength() {
		return MinLength;
	}
	public void setMinLength(Integer minLength) {
		MinLength = minLength;
	}
	public Integer getMinValue() {
		return MinValue;
	}
	public void setMinValue(Integer minValue) {
		MinValue = minValue;
	}
	public String getNoEcho() {
		return NoEcho;
	}
	public void setNoEcho(String noEcho) {
		NoEcho = noEcho;
	}
	public Object getType() {
		return Type;
	}
	public void setType(Object type) {
		Type = type;
	}
	private Integer MaxLength;
	private Integer MaxValue;
	private Integer MinLength;
	private Integer MinValue;
	private String NoEcho;
	private Object Type;
}

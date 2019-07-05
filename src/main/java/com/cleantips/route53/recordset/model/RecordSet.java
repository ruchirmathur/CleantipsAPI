/*
 * 
 */
package com.cleantips.route53.recordset.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

// TODO: Auto-generated Javadoc
/**
 * The Class RecordSet.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class RecordSet {

/** The Type. */
private String Type="AWS::Route53::RecordSet";

/** The Properties. */
private Properties Properties;

/**
 * Gets the type.
 *
 * @return the type
 */
public String getType() {
	return Type;
}

/**
 * Sets the type.
 *
 * @param type the new type
 */
public void setType(String type) {
	Type = type;
}

/**
 * Gets the properties.
 *
 * @return the properties
 */
public Properties getProperties() {
	return Properties;
}

/**
 * Sets the properties.
 *
 * @param properties the new properties
 */
public void setProperties(Properties properties) {
	Properties = properties;
}
}

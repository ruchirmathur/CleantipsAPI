/*
 * 
 */
package com.cleantips.route53.hostedzone.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

// TODO: Auto-generated Javadoc
/**
 * The Class HostedZoneTag.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class HostedZoneTag {

/** The Key. */
private String Key;

/** The Value. */
private String Value;

/**
 * Gets the key.
 *
 * @return the key
 */
public String getKey() {
	return Key;
}

/**
 * Sets the key.
 *
 * @param key the new key
 */
public void setKey(String key) {
	Key = key;
}

/**
 * Gets the value.
 *
 * @return the value
 */
public String getValue() {
	return Value;
}

/**
 * Sets the value.
 *
 * @param value the new value
 */
public void setValue(String value) {
	Value = value;
}

}

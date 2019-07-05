/*
 * 
 */
package com.cleantips.route53.hostedzone.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

// TODO: Auto-generated Javadoc
/**
 * The Class Ref.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Ref {

/** The ref. */
@JsonProperty("Ref")
private String ref;

/**
 * Gets the ref.
 *
 * @return the ref
 */
public String getRef() {
	return ref;
}

/**
 * Sets the ref.
 *
 * @param ref the new ref
 */
public void setRef(String ref) {
	this.ref = ref;
}



}

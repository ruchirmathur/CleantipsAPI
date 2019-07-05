/*
 * 
 */
package com.cleantips.route53.hostedzone.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

// TODO: Auto-generated Javadoc
/**
 * The Class HostedZoneConfig.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class HostedZoneConfig {

/** The Comment. */
private String Comment;

/**
 * Gets the comment.
 *
 * @return the comment
 */
public String getComment() {
	return Comment;
}

/**
 * Sets the comment.
 *
 * @param comment the new comment
 */
public void setComment(String comment) {
	Comment = comment;
}

}

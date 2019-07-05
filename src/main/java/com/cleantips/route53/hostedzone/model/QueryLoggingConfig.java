/*
 * 
 */
package com.cleantips.route53.hostedzone.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

// TODO: Auto-generated Javadoc
/**
 * The Class QueryLoggingConfig.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class QueryLoggingConfig {

/** The Cloud watch logs log group arn. */
private String CloudWatchLogsLogGroupArn;

/**
 * Gets the cloud watch logs log group arn.
 *
 * @return the cloud watch logs log group arn
 */
public String getCloudWatchLogsLogGroupArn() {
	return CloudWatchLogsLogGroupArn;
}

/**
 * Sets the cloud watch logs log group arn.
 *
 * @param cloudWatchLogsLogGroupArn the new cloud watch logs log group arn
 */
public void setCloudWatchLogsLogGroupArn(String cloudWatchLogsLogGroupArn) {
	CloudWatchLogsLogGroupArn = cloudWatchLogsLogGroupArn;
}
}

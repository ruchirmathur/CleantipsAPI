package com.cleantips.route53.hostedzone.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class QueryLoggingConfig {
private String CloudWatchLogsLogGroupArn;

public String getCloudWatchLogsLogGroupArn() {
	return CloudWatchLogsLogGroupArn;
}

public void setCloudWatchLogsLogGroupArn(String cloudWatchLogsLogGroupArn) {
	CloudWatchLogsLogGroupArn = cloudWatchLogsLogGroupArn;
}
}

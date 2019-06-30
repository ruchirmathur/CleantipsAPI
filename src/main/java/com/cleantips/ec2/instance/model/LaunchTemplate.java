package com.cleantips.ec2.instance.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class LaunchTemplate {
private String LaunchTemplateId;

private String LaunchTemplateName;

private String Version;

public String getLaunchTemplateId() {
	return LaunchTemplateId;
}

public void setLaunchTemplateId(String launchTemplateId) {
	LaunchTemplateId = launchTemplateId;
}

public String getLaunchTemplateName() {
	return LaunchTemplateName;
}

public void setLaunchTemplateName(String launchTemplateName) {
	LaunchTemplateName = launchTemplateName;
}

public String getVersion() {
	return Version;
}

public void setVersion(String version) {
	Version = version;
}
}

package com.cleantips.cloudfront.distribution.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Properties {
	private DistributionConfig DistributionConfig;

	private ArrayList<Tags> Tag;

	public DistributionConfig getDistributionConfig() {
		return DistributionConfig;
	}

	public void setDistributionConfig(DistributionConfig distributionConfig) {
		DistributionConfig = distributionConfig;
	}

	public ArrayList<Tags> getTag() {
		return Tag;
	}

	public void setTag(ArrayList<Tags> tag) {
		Tag = tag;
	}
}

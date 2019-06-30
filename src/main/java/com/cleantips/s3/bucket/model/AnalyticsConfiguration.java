package com.cleantips.s3.bucket.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class AnalyticsConfiguration {
	private String Id;
	private String Prefix;
	private StorageClassAnalysis StorageClassAnalysis;
	public StorageClassAnalysis getStorageClassAnalysis() {
		return StorageClassAnalysis;
	}
	public void setStorageClassAnalysis(StorageClassAnalysis storageClassAnalysis) {
		StorageClassAnalysis = storageClassAnalysis;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPrefix() {
		return Prefix;
	}
	public void setPrefix(String prefix) {
		Prefix = prefix;
	}
	public ArrayList<com.cleantips.s3.bucket.model.TagFilters> getTagFilters() {
		return TagFilters;
	}
	public void setTagFilters(ArrayList<com.cleantips.s3.bucket.model.TagFilters> tagFilters) {
		TagFilters = tagFilters;
	}
	private ArrayList<com.cleantips.s3.bucket.model.TagFilters> TagFilters;
	
}

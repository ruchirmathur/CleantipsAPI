package com.cleantips.s3.bucket.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class InventoryConfiguration {
	private Destination Destination;
	private boolean Enabled;
	private String Id;
	private String IncludedObjectVersions;
	public Destination getDestination() {
		return Destination;
	}
	public void setDestination(Destination destination) {
		Destination = destination;
	}
	public boolean isEnabled() {
		return Enabled;
	}
	public void setEnabled(boolean enabled) {
		Enabled = enabled;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public ArrayList<String> getOptionalFields() {
		return OptionalFields;
	}
	public void setOptionalFields(ArrayList<String> optionalFields) {
		OptionalFields = optionalFields;
	}
	public String getPrefix() {
		return Prefix;
	}
	public void setPrefix(String prefix) {
		Prefix = prefix;
	}
	public String getScheduleFrequency() {
		return ScheduleFrequency;
	}
	public void setScheduleFrequency(String scheduleFrequency) {
		ScheduleFrequency = scheduleFrequency;
	}
	private ArrayList<String> OptionalFields;
	private String Prefix;
	private String ScheduleFrequency;
}

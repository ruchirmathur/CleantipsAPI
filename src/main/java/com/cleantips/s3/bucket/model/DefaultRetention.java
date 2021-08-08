package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class DefaultRetention {
private int Days;
private String Mode;
public int getDays() {
	return Days;
}
public void setDays(int days) {
	Days = days;
}
public String getMode() {
	return Mode;
}
public void setMode(String mode) {
	Mode = mode;
}
public int getYears() {
	return Years;
}
public void setYears(int years) {
	Years = years;
}
private int Years;
}

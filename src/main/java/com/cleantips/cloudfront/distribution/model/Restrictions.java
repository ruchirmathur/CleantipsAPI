package com.cleantips.cloudfront.distribution.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class Restrictions {
private GeoRestriction GeoRestriction;

public GeoRestriction getGeoRestriction() {
	return GeoRestriction;
}

public void setGeoRestriction(GeoRestriction geoRestriction) {
	GeoRestriction = geoRestriction;
}
}

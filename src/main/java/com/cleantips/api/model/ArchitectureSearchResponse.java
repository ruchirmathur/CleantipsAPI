package com.cleantips.api.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFormat(shape=JsonFormat.Shape.ARRAY)
public class ArchitectureSearchResponse {
private ArchitectureSearchResponse2 architecture;

public ArchitectureSearchResponse2 getArchitecture() {
	return architecture;
}

public void setArchitecture(ArchitectureSearchResponse2 architecture) {
	this.architecture = architecture;
}


}

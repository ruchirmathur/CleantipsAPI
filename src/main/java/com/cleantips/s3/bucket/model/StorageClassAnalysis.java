package com.cleantips.s3.bucket.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class StorageClassAnalysis {
private DataExport DataExport;

public DataExport getDataExport() {
	return DataExport;
}

public void setDataExport(DataExport dataExport) {
	DataExport = dataExport;
}
}

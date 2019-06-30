package com.cleantips.cloudfront.distribution.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class CustomOriginConfig {
	private int HTTPPort;
	public int getHTTPPort() {
		return HTTPPort;
	}
	public void setHTTPPort(int hTTPPort) {
		HTTPPort = hTTPPort;
	}
	public int getHTTPSPort() {
		return HTTPSPort;
	}
	public void setHTTPSPort(int hTTPSPort) {
		HTTPSPort = hTTPSPort;
	}
	public int getOriginKeepaliveTimeout() {
		return OriginKeepaliveTimeout;
	}
	public void setOriginKeepaliveTimeout(int originKeepaliveTimeout) {
		OriginKeepaliveTimeout = originKeepaliveTimeout;
	}
	public String getOriginProtocolPolicy() {
		return OriginProtocolPolicy;
	}
	public void setOriginProtocolPolicy(String originProtocolPolicy) {
		OriginProtocolPolicy = originProtocolPolicy;
	}
	public int getOriginReadTimeout() {
		return OriginReadTimeout;
	}
	public void setOriginReadTimeout(int originReadTimeout) {
		OriginReadTimeout = originReadTimeout;
	}
	public ArrayList<String> getOriginSSLProtocols() {
		return OriginSSLProtocols;
	}
	public void setOriginSSLProtocols(ArrayList<String> originSSLProtocols) {
		OriginSSLProtocols = originSSLProtocols;
	}
	private int HTTPSPort;
	private int OriginKeepaliveTimeout;
	private String OriginProtocolPolicy;
	private int OriginReadTimeout;
	private ArrayList<String> OriginSSLProtocols;
}

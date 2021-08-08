package com.cleantips.cloudfront.distribution.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.PascalCaseStrategy.class)
public class DistributionConfig {
	private ArrayList<String> Aliases;
	private ArrayList<CacheBehaviors> CacheBehaviors;
	private String Comment;
	private ArrayList<CustomErrorResponses> CustomErrorResponses;
	private DefaultCacheBehavior DefaultCacheBehavior;
	private String DefaultRootObject;

	public ArrayList<String> getAliases() {
		return Aliases;
	}

	public void setAliases(ArrayList<String> aliases) {
		Aliases = aliases;
	}

	public ArrayList<CacheBehaviors> getCacheBehaviors() {
		return CacheBehaviors;
	}

	public void setCacheBehaviors(ArrayList<CacheBehaviors> cacheBehaviors) {
		CacheBehaviors = cacheBehaviors;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public ArrayList<CustomErrorResponses> getCustomErrorResponses() {
		return CustomErrorResponses;
	}

	public void setCustomErrorResponses(ArrayList<CustomErrorResponses> customErrorResponses) {
		CustomErrorResponses = customErrorResponses;
	}

	public DefaultCacheBehavior getDefaultCacheBehavior() {
		return DefaultCacheBehavior;
	}

	public void setDefaultCacheBehavior(DefaultCacheBehavior defaultCacheBehavior) {
		DefaultCacheBehavior = defaultCacheBehavior;
	}

	public String getDefaultRootObject() {
		return DefaultRootObject;
	}

	public void setDefaultRootObject(String defaultRootObject) {
		DefaultRootObject = defaultRootObject;
	}

	public boolean isEnabled() {
		return Enabled;
	}

	public void setEnabled(boolean enabled) {
		Enabled = enabled;
	}

	public String getHttpVersion() {
		return HttpVersion;
	}

	public void setHttpVersion(String httpVersion) {
		HttpVersion = httpVersion;
	}

	public Logging getLogging() {
		return Logging;
	}

	public void setLogging(Logging logging) {
		Logging = logging;
	}


	public ArrayList<Origin> getOrigins() {
		return Origins;
	}

	public void setOrigins(ArrayList<Origin> origins) {
		Origins = origins;
	}

	public String getPriceClass() {
		return PriceClass;
	}

	public void setPriceClass(String priceClass) {
		PriceClass = priceClass;
	}

	public Restrictions getRestrictions() {
		return Restrictions;
	}

	public void setRestrictions(Restrictions restrictions) {
		Restrictions = restrictions;
	}

	public ViewerCertificate getViewerCertificate() {
		return ViewerCertificate;
	}

	public void setViewerCertificate(ViewerCertificate viewerCertificate) {
		ViewerCertificate = viewerCertificate;
	}

	public String getWebACLId() {
		return WebACLId;
	}

	public void setWebACLId(String webACLId) {
		WebACLId = webACLId;
	}

	private boolean Enabled;
	private String HttpVersion;
	private Logging Logging;
	private ArrayList<Origin> Origins;
	private String PriceClass;
	private Restrictions Restrictions;
	private ViewerCertificate ViewerCertificate;
	private String WebACLId;
}

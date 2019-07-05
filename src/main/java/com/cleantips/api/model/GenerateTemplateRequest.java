package com.cleantips.api.model;

import java.util.ArrayList;
/**
 * The Class GenerateTemplateRequest.
 *
 * @author Ruchir
 */
public class GenerateTemplateRequest {

	/** The app services. */
	private ArrayList<Services> appServices;
	
	/** The architecture image. */
	private String architectureImage;
	
	/** The architecture. */
	private String architecture;
	
	private String region;

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * Gets the app services.
	 *
	 * @return the app services
	 */
	public ArrayList<Services> getAppServices() {
		return appServices;
	}

	/**
	 * Sets the app services.
	 *
	 * @param appServices the new app services
	 */
	public void setAppServices(ArrayList<Services> appServices) {
		this.appServices = appServices;
	}

	/**
	 * Gets the architecture.
	 *
	 * @return the architecture
	 */
	public String getArchitecture() {
		return architecture;
	}

	/**
	 * Sets the architecture.
	 *
	 * @param architecture the new architecture
	 */
	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}

	/**
	 * Gets the architecture image.
	 *
	 * @return the architecture image
	 */
	public String getArchitectureImage() {
		return architectureImage;
	}

	/**
	 * Sets the architecture image.
	 *
	 * @param architectureImage the new architecture image
	 */
	public void setArchitectureImage(String architectureImage) {
		this.architectureImage = architectureImage;
	}
}

package com.application.busreservation.entity;

import org.springframework.stereotype.Component;

/**
 * @author Vignesh
 * SearchPojo is a pojo
 */
@Component
public class SearchPojo {
	public String sourceCity;
	public String destinationCity;
	public String travelDate;
	public String destinationDate;

	public String getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public String getDestinationDate() {
		return destinationDate;
	}

	public void setDestinationDate(String destinationDate) {
		this.destinationDate = destinationDate;
	}

}

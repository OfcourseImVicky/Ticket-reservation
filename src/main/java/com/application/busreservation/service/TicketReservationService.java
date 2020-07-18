package com.application.busreservation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.busreservation.dao.TicketReservationDao;
import com.application.busreservation.entity.SearchPojo;
import com.application.busreservation.entity.SearchResultDto;

/**
 * @author Vignesh
 * TicketReservationService provides service layer for Ticket Reservation
 */
@Service
public class TicketReservationService {

	@Autowired
	TicketReservationDao ticketReservationDao;

	/**
	 * fetchDetails retrieves resultant data
	 * 
	 * @param searchPojo
	 * @return resultList
	 */
	public List<SearchResultDto> fetchDetails(SearchPojo searchPojo) {
		List<SearchResultDto> resultList = ticketReservationDao.findByDestinationCity(searchPojo.getDestinationCity());
		resultList.sort((SearchResultDto s1, SearchResultDto s2) -> Integer.valueOf(s1.getPrice())
				.compareTo(Integer.valueOf(s2.getPrice())));
		return resultList;
	}

	/**
	 * insert method inserts data to DB
	 */
	public void insert() {
		List<SearchResultDto> insertList = new ArrayList<>();
		insertSampleDataForCoimbatore(insertList);
		insertSampleDataForTirunelveli(insertList);
	}

	/**
	 * insertSampleDataForTirunelveli inserts Dump Data
	 * 
	 * @param insertList
	 */
	private void insertSampleDataForTirunelveli(List<SearchResultDto> insertList) {
		SearchResultDto searchResultDto = new SearchResultDto();
		// 1st record
		searchResultDto.setArrivalTime("11 AM");
		searchResultDto.setBusNumber("TN 14 S206");
		searchResultDto.setDepartureTime("9 PM");
		searchResultDto.setDestinationCity("Tirunelveli");
		searchResultDto.setDuration("14 HRS");
		searchResultDto.setOperatorName("Vicky");
		searchResultDto.setPrice("1500");
		searchResultDto.setSourceCity("Chennai");
		ticketReservationDao.save(searchResultDto);
		// 2nd record
		searchResultDto.setArrivalTime("9 AM");
		searchResultDto.setBusNumber("TN 14 S207");
		searchResultDto.setDepartureTime("7 PM");
		searchResultDto.setDestinationCity("Tirunelveli");
		searchResultDto.setDuration("14 HRS");
		searchResultDto.setOperatorName("Siva");
		searchResultDto.setPrice("1200");
		searchResultDto.setSourceCity("Chennai");
		ticketReservationDao.save(searchResultDto);
		// 3rd record
		searchResultDto.setArrivalTime("7 AM");
		searchResultDto.setBusNumber("TN 14 S210");
		searchResultDto.setDepartureTime("5 PM");
		searchResultDto.setDestinationCity("Tirunelveli");
		searchResultDto.setDuration("14 HRS");
		searchResultDto.setOperatorName("Sanjay");
		searchResultDto.setPrice("900");
		searchResultDto.setSourceCity("Chennai");
		ticketReservationDao.save(searchResultDto);
	}

	/**
	 * insertSampleDataForCoimbatore inserts Dump Data
	 * 
	 * @param insertList
	 */
	private void insertSampleDataForCoimbatore(List<SearchResultDto> insertList) {
		SearchResultDto searchResultDto = new SearchResultDto();
		// 1st record
		searchResultDto.setArrivalTime("4 PM");
		searchResultDto.setBusNumber("TN 14 S208");
		searchResultDto.setDepartureTime("10 AM");
		searchResultDto.setDestinationCity("Coimbatore");
		searchResultDto.setDuration("6 HRS");
		searchResultDto.setOperatorName("Madhan");
		searchResultDto.setPrice("800");
		searchResultDto.setSourceCity("Chennai");
		ticketReservationDao.save(searchResultDto);
		// 2nd record
		searchResultDto.setArrivalTime("6 PM");
		searchResultDto.setBusNumber("TN 14 S209");
		searchResultDto.setDepartureTime("12 AM");
		searchResultDto.setDestinationCity("Coimbatore");
		searchResultDto.setDuration("6 HRS");
		searchResultDto.setOperatorName("Arun");
		searchResultDto.setPrice("900");
		searchResultDto.setSourceCity("Chennai");
		ticketReservationDao.save(searchResultDto);
	}
}

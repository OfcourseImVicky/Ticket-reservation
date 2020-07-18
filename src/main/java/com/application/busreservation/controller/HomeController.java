package com.application.busreservation.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.application.busreservation.entity.SearchPojo;
import com.application.busreservation.entity.SearchResultDto;
import com.application.busreservation.service.TicketReservationService;

/**
 * HomeController contains End Points for request mappings 
 * @author Vignesh
 * @version 1
 * @since 2020
 */
@Controller
public class HomeController {
	
	private static final int ONE = 1;
	private static final String LINE_BREAK = "\n";
	private static final String PROVIDES = "==>";
	private static final String BUS_NO = "Bus No : ";
	private static final String EMPTY_BUS_MESSAGE = "There are no buses available";
	private static final String BUSES_AVAILABLE = " Buses available";
	private static final String BUS_AVAILABLE = " Bus available";
	private static final String THERE_ARE = "There are ";
	private static final String THERE_IS_ONLY = "There is only ";
	private static final String DRIVER_NAME = "Driver Name : ";
	private static final String DEPARTURE_TIME = "Departure Time : ";
	private static final String ARRIVAL_TIME = "Arrival Time : ";
	private static final String TRAVEL_DURATION = "Travel Duration : ";
	private static final String TICKET_PRICE = "Ticket Price : ";
	private static final String INR = " INR";

	/**
	 * itemManagementService is for maintaining the items
	 */
	@Autowired
	private TicketReservationService ticketReservationService;

	/**
	 * start method provides the HomeScreen
	 * 
	 * @return view
	 */
	@RequestMapping("/home")
	public String start() {
		return "index.jsp";
	};

	/**
	 * submit method retrieves necessary data and decorates Detail Page
	 * 
	 * @param searchPojo
	 * @return ModelAndView
	 */
	@RequestMapping("/book")
	public ModelAndView submit(SearchPojo searchPojo) {
		List<SearchResultDto> resultList = ticketReservationService.fetchDetails(searchPojo);
		ModelAndView view = new ModelAndView();
		StringBuilder detailString = new StringBuilder();
		int totalBusCount = resultList.size();
		if (totalBusCount == 0) {
			detailString.append(EMPTY_BUS_MESSAGE);
			detailString.append(LINE_BREAK);
		} else if (totalBusCount > ONE) {
			detailString.append(THERE_ARE).append(totalBusCount).append(BUSES_AVAILABLE);
			detailString.append(LINE_BREAK);
			detailString.append(LINE_BREAK);
		} else if (totalBusCount == ONE) {
			detailString.append(THERE_IS_ONLY).append(totalBusCount).append(BUS_AVAILABLE);
			detailString.append(LINE_BREAK);
			detailString.append(LINE_BREAK);
		}
		AtomicInteger busNumeral = new AtomicInteger(1);
		resultList.stream().forEach(bus -> {
			detailString.append(busNumeral.getAndIncrement()).append(PROVIDES);
			detailString.append(LINE_BREAK);
			detailString.append(LINE_BREAK);
			detailString.append(BUS_NO).append(bus.getBusNumber());
			detailString.append(LINE_BREAK);
			detailString.append(DRIVER_NAME).append(bus.getOperatorName());
			detailString.append(LINE_BREAK);
			detailString.append(DEPARTURE_TIME).append(bus.getDepartureTime());
			detailString.append(LINE_BREAK);
			detailString.append(ARRIVAL_TIME).append(bus.getArrivalTime());
			detailString.append(LINE_BREAK);
			detailString.append(TRAVEL_DURATION).append(bus.getDuration());
			detailString.append(LINE_BREAK);
			detailString.append(TICKET_PRICE).append(bus.getPrice()).append(INR);
			detailString.append(LINE_BREAK);
			detailString.append(LINE_BREAK);
		});
		view.addObject("details", detailString);
		view.setViewName("detailPage.jsp");
		return view;
	};
}

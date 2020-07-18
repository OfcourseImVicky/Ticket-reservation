package com.application.busreservation.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.busreservation.entity.SearchResultDto;


/**
 * TicketReservationDao is for accessing Data Layer
 * @author Vignesh
 * @version 1
 * @since 2020
 */
@Repository
public interface TicketReservationDao extends CrudRepository<SearchResultDto, String>{

	List<SearchResultDto> findByDestinationCity(String destinationCity);

}

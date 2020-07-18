package com.application.busreservation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.application.busreservation.service.TicketReservationService;

@SpringBootApplication
public class BusReservationApplication1Application {

	public static void main(String[] args) {
		SpringApplication.run(BusReservationApplication1Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(TicketReservationService service) {
		return (args) -> {
			service.insert();
		};
	}
}

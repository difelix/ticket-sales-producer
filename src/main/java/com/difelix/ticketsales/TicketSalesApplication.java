package com.difelix.ticketsales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class TicketSalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketSalesApplication.class, args);
	}

}

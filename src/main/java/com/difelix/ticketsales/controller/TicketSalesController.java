package com.difelix.ticketsales.controller;

import com.difelix.ticketsales.kafka.producer.TicketSalesTopicProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket-sales/buy")
@RequiredArgsConstructor
public class TicketSalesController {

  private final TicketSalesTopicProducer ticketSalesTopicProducer;

  @PostMapping
  @ResponseStatus(HttpStatus.OK)
  public void buyTicket(@RequestParam(name = "message") String message) {
    ticketSalesTopicProducer.sendTicketSales(message);
  }

}

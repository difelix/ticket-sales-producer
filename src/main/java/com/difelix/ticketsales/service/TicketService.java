package com.difelix.ticketsales.service;

import com.difelix.ticketsales.domain.entity.Ticket;
import java.util.List;

public interface TicketService {
  Ticket save(Ticket ticket);

  List<Ticket> listAllTicketsAvailable();
}

package com.difelix.ticketsales.service.impl;

import com.difelix.ticketsales.domain.entity.Ticket;
import com.difelix.ticketsales.domain.enums.TicketStatusEnum;
import com.difelix.ticketsales.exceptions.BusinessException;
import com.difelix.ticketsales.exceptions.enums.ModuleExceptionEnum;
import com.difelix.ticketsales.repository.TicketRepository;
import com.difelix.ticketsales.service.TicketService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

  private final TicketRepository ticketRepository;

  @Override
  public Ticket save(Ticket ticket) {
    final boolean existTag = ticketRepository.existsByTag(ticket.getTag());

    if (existTag) throw new BusinessException("Tag já cadastrada!", ModuleExceptionEnum.TICKET);

    return ticketRepository.save(ticket);
  }

  @Override
  public List<Ticket> listAllTicketsAvailable() {
    return ticketRepository.findAllByStatus(TicketStatusEnum.AVAILABLE);
  }
}

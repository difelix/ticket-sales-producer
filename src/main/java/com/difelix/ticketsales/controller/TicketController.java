package com.difelix.ticketsales.controller;

import com.difelix.ticketsales.domain.dto.ticket.TicketRequestDto;
import com.difelix.ticketsales.domain.dto.ticket.TicketResponseDto;
import com.difelix.ticketsales.domain.entity.Ticket;
import com.difelix.ticketsales.domain.mappers.TicketMapper;
import com.difelix.ticketsales.service.TicketService;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {

  private final TicketService ticketService;

  @PostMapping
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED)
  public TicketResponseDto create(@Valid @RequestBody TicketRequestDto request) {
    final Ticket ticketSaved = ticketService.save(TicketMapper.toEntity(request));
    return TicketMapper.toResponse(ticketSaved);
  }

  @GetMapping
  @ResponseBody
  @ResponseStatus(HttpStatus.OK)
  public List<TicketResponseDto> listAllTicketsAvailable() {
    final List<Ticket> tickets = ticketService.listAllTicketsAvailable();
    return tickets.stream().map(TicketMapper::toResponse).toList();
  }
}

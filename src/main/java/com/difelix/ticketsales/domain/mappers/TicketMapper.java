package com.difelix.ticketsales.domain.mappers;

import com.difelix.ticketsales.domain.dto.ticket.TicketRequestDto;
import com.difelix.ticketsales.domain.dto.ticket.TicketResponseDto;
import com.difelix.ticketsales.domain.entity.Ticket;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {

  private TicketMapper() {}

  public static Ticket toEntity(TicketRequestDto request) {
    return Ticket.builder()
        .tag(request.getTag())
        .value(request.getValue())
        .description(request.getDescription())
        .quantityInStock(request.getQuantityInStock())
        .build();
  }

  public static TicketResponseDto toResponse(Ticket ticket) {
    return TicketResponseDto.builder()
        .id(ticket.getId())
        .createdAt(ticket.getCreatedAt().toString())
        .updatedAt( (ticket.getUpdatedAt() != null) ? ticket.getUpdatedAt().toString() : null )
        .description(ticket.getDescription())
        .quantityInStock(ticket.getQuantityInStock())
        .tag(ticket.getTag())
        .value(ticket.getValue())
        .status(ticket.getStatus().toString())
        .build();
  }
}

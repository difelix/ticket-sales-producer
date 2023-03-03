package com.difelix.ticketsales.repository;

import com.difelix.ticketsales.domain.entity.Ticket;
import com.difelix.ticketsales.domain.enums.TicketStatusEnum;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {
  boolean existsByTag(String tag);

  List<Ticket> findAllByStatus(TicketStatusEnum ticketStatusEnum);
}

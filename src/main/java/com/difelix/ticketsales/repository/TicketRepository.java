package com.difelix.ticketsales.repository;

import com.difelix.ticketsales.domain.entity.Ticket;
import com.difelix.ticketsales.domain.enums.TicketStatusEnum;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, Long> {
  boolean existsByTag(String tag);

  List<Ticket> findAllByStatus(TicketStatusEnum ticketStatusEnum);

  Optional<Ticket> findByTagAndStatus(String tag, TicketStatusEnum status);
}

package com.difelix.ticketsales.service.impl;

import com.difelix.ticketsales.domain.dto.purchase.PurchaseOrderRequest;
import com.difelix.ticketsales.domain.entity.Customer;
import com.difelix.ticketsales.domain.entity.Purchase;
import com.difelix.ticketsales.domain.entity.Ticket;
import com.difelix.ticketsales.domain.mappers.PurchaseMapper;
import com.difelix.ticketsales.kafka.producer.TicketSalesTopicProducer;
import com.difelix.ticketsales.repository.PurchaseRepository;
import com.difelix.ticketsales.service.CustomerService;
import com.difelix.ticketsales.service.PurchaseService;
import com.difelix.ticketsales.service.TicketService;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

  private final PurchaseRepository purchaseRepository;
  private final CustomerService customerService;
  private final TicketService ticketService;
  private final TicketSalesTopicProducer producer;

  @Override
  @Transactional
  public Purchase executePurchaseOrder(PurchaseOrderRequest purchaseOrder) {
    final Customer customer = customerService.findCustomerByEmail(purchaseOrder.getEmail());
    final Ticket ticket = ticketService.findTicketByTagAndAvailability(purchaseOrder.getTag());
    final BigDecimal totalAmountPayable = calculateTotalAmountPayable(ticket.getValue(),
        purchaseOrder.getAmount());

    Purchase purchase = PurchaseMapper.toEntity(purchaseOrder, customer, ticket, totalAmountPayable);

    purchase = purchaseRepository.save(purchase);

    producer.sendTicketSales(purchase);

    return purchase;
  }

  private BigDecimal calculateTotalAmountPayable(BigDecimal value, int amount) {
    return value.multiply(BigDecimal.valueOf(amount));
  }
}

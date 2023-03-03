package com.difelix.ticketsales.domain.mappers;

import com.difelix.ticketsales.domain.dto.purchase.PurchaseOrderRequest;
import com.difelix.ticketsales.domain.dto.purchase.PurchaseOrderResponse;
import com.difelix.ticketsales.domain.entity.Customer;
import com.difelix.ticketsales.domain.entity.Purchase;
import com.difelix.ticketsales.domain.entity.Ticket;
import java.math.BigDecimal;
import org.springframework.stereotype.Component;

@Component
public class PurchaseMapper {

  private PurchaseMapper() {}

  public static Purchase toEntity(
      PurchaseOrderRequest purchaseOrderRequest,
      Customer customer,
      Ticket ticket,
      BigDecimal totalAmountPayable
  ) {
    return Purchase.builder()
        .amount(purchaseOrderRequest.getAmount())
        .customer(customer)
        .ticket(ticket)
        .totalAmountPayable(totalAmountPayable)
        .build();
  }

  public static PurchaseOrderResponse toResponse(Purchase purchase) {
    return PurchaseOrderResponse.builder()
        .id(purchase.getId())
        .tag(purchase.getTicket().getTag())
        .email(purchase.getCustomer().getEmail())
        .purchaseDate(purchase.getPurchaseDate().toString())
        .amount(purchase.getAmount())
        .status(purchase.getStatus().toString())
        .totalAmountPayable(purchase.getTotalAmountPayable())
        .build();
  }
}

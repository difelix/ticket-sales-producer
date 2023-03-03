package com.difelix.ticketsales.domain.dto.purchase;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class PurchaseOrderResponse {
  private String id;
  private String email;
  private String tag;
  private int amount;
  private BigDecimal totalAmountPayable;
  private String status;
  private String purchaseDate;
}

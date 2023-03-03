package com.difelix.ticketsales.domain.dto.purchase;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
public class PurchaseOrderRequest {
  @NotBlank
  private String email;

  @NotBlank
  private String tag;

  @NotNull
  private int amount;
}

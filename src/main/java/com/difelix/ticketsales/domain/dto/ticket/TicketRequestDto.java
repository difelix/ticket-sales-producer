package com.difelix.ticketsales.domain.dto.ticket;

import java.math.BigDecimal;
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
public class TicketRequestDto {
  @NotNull
  private BigDecimal value;

  @NotBlank
  private String tag;

  private String description;

  @NotNull
  private int quantityInStock;
}

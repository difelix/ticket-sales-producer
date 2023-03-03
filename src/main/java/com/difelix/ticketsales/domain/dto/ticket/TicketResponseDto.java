package com.difelix.ticketsales.domain.dto.ticket;

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
public class TicketResponseDto {
  private Long id;
  private BigDecimal value;
  private String tag;
  private String description;
  private int quantityInStock;
  private String createdAt;
  private String updatedAt;
  private String status;
}

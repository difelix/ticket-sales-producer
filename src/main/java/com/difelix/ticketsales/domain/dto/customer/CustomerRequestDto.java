package com.difelix.ticketsales.domain.dto.customer;

import javax.validation.constraints.NotBlank;
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
public class CustomerRequestDto {
  @NotBlank
  private String name;

  @NotBlank
  private String cpf;

  @NotBlank
  private String email;
}

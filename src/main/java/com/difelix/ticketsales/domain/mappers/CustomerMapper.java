package com.difelix.ticketsales.domain.mappers;

import com.difelix.ticketsales.domain.dto.customer.CustomerRequestDto;
import com.difelix.ticketsales.domain.dto.customer.CustomerResponseDto;
import com.difelix.ticketsales.domain.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

  private CustomerMapper() {}

  public static Customer toEntity(CustomerRequestDto request) {
    return Customer.builder()
        .cpf(request.getCpf())
        .name(request.getName())
        .email(request.getEmail())
        .build();
  }

  public static CustomerResponseDto toResponse(Customer customer) {
    return CustomerResponseDto.builder()
        .id(customer.getId())
        .cpf(customer.getCpf())
        .createdAt(customer.getCreatedAt().toString())
        .email(customer.getEmail())
        .name(customer.getName())
        .build();
  }
}

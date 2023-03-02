package com.difelix.ticketsales.controller;

import com.difelix.ticketsales.domain.dto.customer.CustomerRequestDto;
import com.difelix.ticketsales.domain.dto.customer.CustomerResponseDto;
import com.difelix.ticketsales.domain.entity.Customer;
import com.difelix.ticketsales.domain.mappers.CustomerMapper;
import com.difelix.ticketsales.service.CustomerService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @ResponseBody
  public CustomerResponseDto save(@Valid @RequestBody CustomerRequestDto request) {
    final Customer customerSaved = customerService.save(CustomerMapper.toEntity(request));
    return CustomerMapper.toResponse(customerSaved);
  }
}

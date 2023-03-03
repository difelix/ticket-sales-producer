package com.difelix.ticketsales.service;

import com.difelix.ticketsales.domain.entity.Customer;

public interface CustomerService {
  Customer save(Customer customer);

  Customer findCustomerByEmail(String email);
}

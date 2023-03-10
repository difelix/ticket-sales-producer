package com.difelix.ticketsales.service.impl;

import com.difelix.ticketsales.domain.entity.Customer;
import com.difelix.ticketsales.exceptions.BusinessException;
import com.difelix.ticketsales.exceptions.NotFoundException;
import com.difelix.ticketsales.exceptions.enums.ModuleExceptionEnum;
import com.difelix.ticketsales.repository.CustomerRepository;
import com.difelix.ticketsales.service.CustomerService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;

  @Override
  public Customer save(Customer customer) {
    validateCustomerToSave(customer);
    return customerRepository.save(customer);
  }

  @Override
  public Customer findCustomerByEmail(String email) {
    Optional<Customer> customer = customerRepository.findByEmail(email);

    if (customer.isEmpty()) throw new NotFoundException(
        "Cliente com email [ " + email + " ] não encontrado!",
        ModuleExceptionEnum.CUSTOMER
    );

    return customer.get();
  }

  private void validateCustomerToSave(Customer customer) {
    final boolean existsEmail = customerRepository.existsByEmail(customer.getEmail());
    if (existsEmail) throw new BusinessException("Email já cadastrado!", ModuleExceptionEnum.CUSTOMER);

    final boolean existsCpf = customerRepository.existsByCpf(customer.getCpf());
    if (existsCpf) throw new BusinessException("CPF já cadastrado!", ModuleExceptionEnum.CUSTOMER);
  }
}

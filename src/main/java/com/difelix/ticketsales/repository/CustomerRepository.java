package com.difelix.ticketsales.repository;

import com.difelix.ticketsales.domain.entity.Customer;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
  boolean existsByEmail(String email);

  boolean existsByCpf(String cpf);

  Optional<Customer> findByEmail(String email);
}

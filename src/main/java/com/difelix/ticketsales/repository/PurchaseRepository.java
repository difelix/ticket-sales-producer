package com.difelix.ticketsales.repository;

import com.difelix.ticketsales.domain.entity.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, String> {
}

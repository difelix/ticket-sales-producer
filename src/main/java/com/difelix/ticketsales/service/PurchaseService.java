package com.difelix.ticketsales.service;

import com.difelix.ticketsales.domain.dto.purchase.PurchaseOrderRequest;
import com.difelix.ticketsales.domain.entity.Purchase;

public interface PurchaseService {
  Purchase executePurchaseOrder(PurchaseOrderRequest purchaseOrder);
}

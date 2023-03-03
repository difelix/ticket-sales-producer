package com.difelix.ticketsales.controller;

import com.difelix.ticketsales.domain.dto.purchase.PurchaseOrderRequest;
import com.difelix.ticketsales.domain.dto.purchase.PurchaseOrderResponse;
import com.difelix.ticketsales.domain.entity.Purchase;
import com.difelix.ticketsales.domain.mappers.PurchaseMapper;
import com.difelix.ticketsales.service.PurchaseService;
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
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class PurchaseController {

  private final PurchaseService purchaseService;

  @PostMapping
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED)
  public PurchaseOrderResponse createPurchaseOrder(@Valid @RequestBody PurchaseOrderRequest purchaseOrderRequest) {
    final Purchase purchaseCreated = purchaseService.executePurchaseOrder(purchaseOrderRequest);
    return PurchaseMapper.toResponse(purchaseCreated);
  }
}

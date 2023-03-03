package com.difelix.ticketsales.domain.entity;

import com.difelix.ticketsales.domain.enums.PurchaseStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;
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
@Entity
@Table(name = "purchase")
public class Purchase {

  @Id
  @Builder.Default
  private String id = UUID.randomUUID().toString();

  @OneToOne
  @JoinColumn(name = "customer_id")
  private Customer customer;

  @OneToOne
  @JoinColumn(name = "ticket_id")
  private Ticket ticket;

  @Column(name = "amount", nullable = false)
  private int amount;

  @Column(name = "total_amount_payable", nullable = false)
  private BigDecimal totalAmountPayable;

  @Builder.Default
  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private PurchaseStatusEnum status = PurchaseStatusEnum.PROCESSING;

  @Builder.Default
  @Column(name = "purchase_date", nullable = false)
  private Timestamp purchaseDate = Timestamp.from(Instant.now());
}

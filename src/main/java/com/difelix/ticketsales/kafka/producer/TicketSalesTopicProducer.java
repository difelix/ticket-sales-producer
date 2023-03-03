package com.difelix.ticketsales.kafka.producer;

import com.difelix.ticketsales.domain.entity.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketSalesTopicProducer {

  @Value("${topic.name.producer}")
  private String topicName;

  private final KafkaTemplate<String, Purchase> kafkaTemplate;

  public void sendTicketSales(Purchase purchase) {
    kafkaTemplate.send(topicName, purchase);
  }
}

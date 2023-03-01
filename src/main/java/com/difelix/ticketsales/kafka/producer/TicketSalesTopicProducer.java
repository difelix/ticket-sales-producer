package com.difelix.ticketsales.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TicketSalesTopicProducer {

  @Value("${topic.name.producer}")
  private String topicName;

  private final KafkaTemplate<String, String> kafkaTemplate;

  public void sendTicketSales(String ticketSalesMessage) {
    kafkaTemplate.send(topicName, ticketSalesMessage);
  }
}

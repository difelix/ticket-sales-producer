package com.difelix.ticketsales.exceptions.handler;

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
public class ExceptionModel {
  private String timestamp;
  private int status;
  private String path;
  private String message;
  private String module;
}

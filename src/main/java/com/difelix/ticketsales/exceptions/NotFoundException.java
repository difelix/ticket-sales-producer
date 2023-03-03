package com.difelix.ticketsales.exceptions;

import com.difelix.ticketsales.exceptions.enums.ModuleExceptionEnum;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotFoundException extends RuntimeException {

  public NotFoundException(String message, ModuleExceptionEnum module) {
    super();
    this.message = message;
    this.module = module;
  }

  private final String message;
  private final ModuleExceptionEnum module;
  private final LocalDateTime errorDateTime = LocalDateTime.now();
}

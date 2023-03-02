package com.difelix.ticketsales.exceptions.handler;

import com.difelix.ticketsales.exceptions.BusinessException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TicketSalesExceptionHandler {

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ExceptionModel> businessException(
      BusinessException exception,
      HttpServletRequest request)
  {
    final int httpStatusCode = HttpStatus.UNPROCESSABLE_ENTITY.value();

    final ExceptionModel exceptionModel = ExceptionModel.builder()
        .status(httpStatusCode)
        .path(request.getRequestURI())
        .message(exception.getMessage())
        .timestamp(exception.getErrorDateTime().toString())
        .module(exception.getModule().toString())
        .build();

    return ResponseEntity.status(httpStatusCode).body(exceptionModel);
  }
}

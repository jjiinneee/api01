package org.jjiinnee.api01.controller.advice;


import lombok.extern.log4j.Log4j2;
import org.jjiinnee.api01.controller.APIUserController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Log4j2
public class APIAdvice {
  
  @ExceptionHandler({APIUserController.APIUserNotFoundException.class})
  public ResponseEntity<Map<String, String>> findUserError(APIUserController.APIUserNotFoundException e) {
    
    log.error(e);
    Map<String, String> errorMap = new HashMap<>();
    
    errorMap.put("TIME", ""+System.currentTimeMillis());
    errorMap.put("RESULT",  "USER ACCOUNT NOT FOUND");
    
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
  }
}

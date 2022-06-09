package org.jjiinnee.api01.controller.filter.exception;

public class AccessTokenException extends RuntimeException{
  private String msg;
  
  public AccessTokenException(String msg){
    super(msg);
    this.msg = msg;
  }
}

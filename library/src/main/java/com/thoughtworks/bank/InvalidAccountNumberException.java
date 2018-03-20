package com.thoughtworks.bank;

public class InvalidAccountNumberException extends Exception {
  public InvalidAccountNumberException() {
    super("You have to give valid accountNumber!");
  }
}

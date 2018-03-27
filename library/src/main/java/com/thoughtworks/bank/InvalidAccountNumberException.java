package com.thoughtworks.bank;

public class InvalidAccountNumberException extends Exception {
  public InvalidAccountNumberException() {
    super("You have to give valid accountNumber! Should of format 1234-5678");
  }
}

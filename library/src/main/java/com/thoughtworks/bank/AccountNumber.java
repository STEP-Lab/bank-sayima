package com.thoughtworks.bank;

import java.util.regex.Pattern;

import static java.lang.String.valueOf;

public class AccountNumber {
  private String accountNumber;

  public AccountNumber(String accountNumber) throws InvalidAccountNumberException {

    if(isInValidAccountNo(accountNumber)){
      throw new InvalidAccountNumberException();
    }
    this.accountNumber = accountNumber;
  }
  private static boolean isInValidAccountNo(String accountNumber){
    return !Pattern.matches("[0-9]{4}[-][0-9]{4}",valueOf(accountNumber));
  }

}

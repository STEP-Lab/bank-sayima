package com.thoughtworks.bank;

import java.util.regex.Pattern;

import static java.lang.String.valueOf;

public class Account {

  private final String accountNumber;
  private final double balance;

  public Account(String accountNumber, double balance) throws MinimumBalanceException, InvalidAccountNumberException {
    if(isInValidAccountNo(accountNumber)){
      throw new InvalidAccountNumberException();
    }
    this.accountNumber = accountNumber;
    if(balance < 1000) throw new MinimumBalanceException();
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  public String getAccountNumber() {
    return accountNumber;
  }
  public static boolean isInValidAccountNo(String accountNumber){
    return !Pattern.matches("[0-9]{4}[-][0-9]{4}",valueOf(accountNumber));
  }
}

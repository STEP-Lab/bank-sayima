package com.thoughtworks.bank;

public class Account {

  private final String accountNumber;
  private final double balance;

  public Account(String accountNumber, double balance) throws MinimumBalanceException {
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
}

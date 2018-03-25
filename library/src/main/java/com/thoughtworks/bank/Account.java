package com.thoughtworks.bank;

public class Account {

  private final AccountNumber accountNumber;
  private double balance;
  private static final int MINIMUM_BALANCE = 1000;

  public Account(AccountNumber accountNumber, double balance) throws MinimumBalanceException {
    this.accountNumber = accountNumber;
    if(balance < MINIMUM_BALANCE) throw new MinimumBalanceException();
    this.balance = balance;
  }

  public double getBalance() {
    return balance;
  }

  public AccountNumber getAccountNumber() {
    return accountNumber;
  }


  public void debitAmount(int amount) throws MinimumBalanceException {
    if(balance-amount < MINIMUM_BALANCE){
      throw new MinimumBalanceException();
    }
    balance-=amount;

  }


}

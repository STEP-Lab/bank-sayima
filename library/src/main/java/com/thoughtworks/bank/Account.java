package com.thoughtworks.bank;

public class Account {

  private final AccountNumber accountNumber;
  private final Transactions transactions;
  private double balance;
  private static final int MINIMUM_BALANCE = 1000;

  public Account(AccountNumber accountNumber, double balance) throws MinimumBalanceException {
    this.accountNumber = accountNumber;
    if(balance < MINIMUM_BALANCE) throw new MinimumBalanceException();
    this.balance = balance;
    this.transactions = new Transactions();
  }

  public double getBalance() {
    return balance;
  }

  public AccountNumber getAccountNumber() {
    return accountNumber;
  }


  public void debitAmount(double amount, String to) throws MinimumBalanceException {
    if(balance-amount < MINIMUM_BALANCE){
      throw new MinimumBalanceException();
    }
    transactions.debit(amount,to);
    balance-=amount;

  }


  public Transactions getTransactions() {
    return transactions;
  }
}

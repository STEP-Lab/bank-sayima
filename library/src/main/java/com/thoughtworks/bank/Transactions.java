package com.thoughtworks.bank;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;

public class Transactions {
  public ArrayList<Transaction> list;

  public Transactions() {
    this.list = new ArrayList<>();
  }

  public void debit(double amount, String to) {
    this.list.add(new DebitTransaction(amount, to));
  }

  public void credit(double amount, String from) {
    this.list.add(new CreditTransaction(amount,from));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Transactions that = (Transactions) o;
    return Objects.equals(list, that.list);
  }

  @Override
  public int hashCode() {

    return Objects.hash(list);
  }

  public Transactions filterByAmountGreaterThan(double amount) {
    Transactions transactions = new Transactions();
    for (Transaction transaction:list) {
      if(transaction.getAmount() >= amount){
        transactions.list.add(transaction);
      }
    }
    return transactions;
  }

  public void print(PrintWriter printWriter) {
    for (Transaction transaction:list) {
      printWriter.println(transaction.toString());
    }
  }

  public Transactions filterCreditTransaction() {
    Transactions transactions = new Transactions();
    for (Transaction transaction :list) {
      if( transaction instanceof CreditTransaction){
        transactions.list.add(transaction);
      }
    }
    return transactions;
  }

  public Transactions filterDebitTransaction() {
    Transactions transactions = new Transactions();
    for (Transaction transaction :list) {
      if( transaction instanceof DebitTransaction){
        transactions.list.add(transaction);
      }
    }
    return transactions;
  }
}

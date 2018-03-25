package com.thoughtworks.bank;

import java.util.ArrayList;

public class Transactions {
  public ArrayList<Transaction> list;

  public Transactions() {
    this.list = new ArrayList<>();
  }

  public void debit(double amount, String to) {
    this.list.add(new DebitTransaction(amount, to));
  }
}

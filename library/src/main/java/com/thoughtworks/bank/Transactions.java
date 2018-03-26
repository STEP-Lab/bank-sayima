package com.thoughtworks.bank;

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
}

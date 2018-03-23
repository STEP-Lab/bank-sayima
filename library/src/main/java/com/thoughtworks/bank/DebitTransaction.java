package com.thoughtworks.bank;

import java.util.Date;

public class DebitTransaction extends Transaction {
  private Date date;
  private double amount;
  private  String to;

  public DebitTransaction(Date date, double amount, String to) {
    this.date = date;
    this.amount = amount;
    this.to = to;
  }

  public Date getDate() {
    return date;
  }
}

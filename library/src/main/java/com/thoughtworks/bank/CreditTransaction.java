package com.thoughtworks.bank;

import java.util.Date;

public class CreditTransaction extends Transaction {
  public CreditTransaction(Date date, double amount, String from) {
    super(date,amount,from);
  }
  CreditTransaction(double amount,String from) {
    super(new Date(),amount,from);
  }
}

package com.thoughtworks.bank;

import java.util.Date;

public class DebitTransaction extends Transaction {

  public DebitTransaction(Date date, double amount, String to) {
    super(date,amount,to);
  }
  DebitTransaction(double amount, String name){
    super(new Date(),amount,name);
  }

}

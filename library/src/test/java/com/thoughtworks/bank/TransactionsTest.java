package com.thoughtworks.bank;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class TransactionsTest {

  private Transactions transactions;

  @Before
  public void setUp() throws Exception {
    transactions = new Transactions();
  }

  @Test
  public void shouldRecordDebitTransaction() {
    transactions.debit(1000,"another");
    Transaction debitTransaction = new DebitTransaction(new Date(),1000,"another");
    assertThat(transactions.list,hasItem(debitTransaction));
    }

  @Test
  public void shouldRecordCreditTransaction() {
    transactions.credit(5000,"another");
    Transaction creditTransaction = new CreditTransaction(new Date(),5000,"another");
    assertThat(transactions.list,hasItem(creditTransaction));
  }

  @Test
  public void shouldAddDebitAndCreditTransaction() {
    transactions.credit(5000,"another");
    transactions.debit(1000,"another");
    Transaction debitTransaction = new DebitTransaction(new Date(),1000,"another");
    Transaction creditTransaction = new CreditTransaction(new Date(),5000,"another");
    assertThat(transactions.list,hasItems(creditTransaction,debitTransaction));
  }

  @Test
  public void shouldPrintTransaction() throws FileNotFoundException, UnsupportedEncodingException {
    Transactions transactions = new Transactions();
    ArrayList<String> result = new ArrayList<>();
    transactions.credit(300,"sudhin");
    transactions.credit(200,"sudhin");
    CreditTransaction creditTransaction1 = new CreditTransaction(300, "sudhin");
    CreditTransaction creditTransaction2 = new CreditTransaction(200, "sudhin");
    PrintWriter printWriter = new PrintWriter("statement.txt", "UTF-8"){
      @Override
      public void println(String x) {
        super.println(x);
        System.out.println(x);
        result.add(x);
      }
    };

    transactions.print(printWriter);
    printWriter.close();
    assertThat(result,hasItems(creditTransaction1.toString(),creditTransaction2.toString()));
  }

  @Test
  public void filterTransactionsByAmount() {
    transactions.credit(1000.0,"sudhin");
    transactions.credit(500.0,"sudhin");
    transactions.credit(1500.0,"sudhin");
   Transactions filteredTransaction = transactions.filterByAmountGreaterThan(1000);
   assertThat(filteredTransaction.list,hasItems(new CreditTransaction(1000,"sudhin"),new CreditTransaction(1500,"sudhin")));
  }

  @Test
  public void filterCreditTransactions() {
    Transactions transactions = new Transactions();
    transactions.credit(1000.0,"sudhin");
    transactions.credit(500.0,"sudhin");
    transactions.credit(1500.0,"sudhin");
    transactions.debit(1500.0,"sudhin");
    transactions.debit(500.0,"sudhin");
    Transactions creditTransactions = transactions.filterCreditTransaction();
    assertThat(creditTransactions.list,hasItems(new CreditTransaction(1000,"sudhin"),new CreditTransaction(500,"sudhin") ,new CreditTransaction(1500,"sudhin")));
  }

  @Test
  public void filterDebitTransaction() {
    Transactions transactions = new Transactions();
    transactions.credit(1000.0,"sudhin");
    transactions.credit(500.0,"sudhin");
    transactions.credit(1500.0,"sudhin");
    transactions.debit(1500.0,"sudhin");
    transactions.debit(500.0,"sudhin");
    Transactions debitTransactions = transactions.filterDebitTransaction();
    assertThat(debitTransactions.list,hasItems(new DebitTransaction(1500,"sudhin"),new DebitTransaction(500,"sudhin")));
  }
}

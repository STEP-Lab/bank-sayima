import com.thoughtworks.bank.CreditTransaction;
import com.thoughtworks.bank.DebitTransaction;
import com.thoughtworks.bank.Transaction;
import com.thoughtworks.bank.Transactions;
import org.junit.Test;

import java.util.Date;


import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;

public class TransactionsTest {
  @Test
  public void shouldRecordDebitTransaction() {
    Transactions transactions = new Transactions();
    transactions.debit(1000,"another");
    Transaction debitTransaction = new DebitTransaction(new Date(),1000,"another");
    assertThat(transactions.list,hasItem(debitTransaction));
    }

  @Test
  public void shouldRecordCreditTransaction() {
    Transactions transactions = new Transactions();
    transactions.credit(5000,"another");
    Transaction creditTransaction = new CreditTransaction(new Date(),5000,"another");
    assertThat(transactions.list,hasItem(creditTransaction));
  }
}

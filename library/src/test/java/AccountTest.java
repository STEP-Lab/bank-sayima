import com.thoughtworks.bank.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTest {

  private Account account;

  @Before
  public void setUp() throws Exception {
    account = new Account(new AccountNumber("1234-1234"),10000.00);
  }

  @Test
  public void checkBalance()  {
    assertThat(account.getBalance(), is(10000.00));
  }

  @Test
  public void checkAccountNumber() throws InvalidAccountNumberException {
    AccountNumber accountNumber = new AccountNumber("1234-1234");
    assertThat(account.getAccountNumber(),is(accountNumber));
  }


  @Test(expected = MinimumBalanceException.class)
  public void checkMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
    new Account(new AccountNumber("1235-1235"),200.00);
  }


  @Test
  public void checkDebitAmount() throws MinimumBalanceException {
    account.debitAmount(500,"another");
    assertThat(account.getBalance(),is(9500.0));
  }

  @Test
  public void checkTransactionsListAfterDebitMoney() throws MinimumBalanceException, InvalidAccountNumberException {
    Account account = new Account(new AccountNumber("1234-4567"), 10000.0);
    account.debitAmount(200,"atm");
    Transactions transactions = new Transactions();
    transactions.debit(200,"atm");
    assertThat(account.getTransactions(),is(transactions));
  }

  @Test(expected = MinimumBalanceException.class)
  public void checkDebitAmount_InvalidDebitAmount() throws MinimumBalanceException{
    account.debitAmount(9500, "another");
  }


}

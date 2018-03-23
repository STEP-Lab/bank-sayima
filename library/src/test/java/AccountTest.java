import com.thoughtworks.bank.Account;
import com.thoughtworks.bank.AccountNumber;
import com.thoughtworks.bank.InvalidAccountNumberException;
import com.thoughtworks.bank.MinimumBalanceException;
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
  public void checkAccountNumber() {
    assertThat(account.getAccountNumber(),is("1234-1234"));
  }

  @Test(expected = MinimumBalanceException.class)
  public void checkMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
    new Account(new AccountNumber("1235-1235"),200.00);
  }


  @Test
  public void checkDebitAmount() throws MinimumBalanceException {
    account.debitAmount(500);
    assertThat(account.getBalance(),is(9500.0));
  }

  @Test(expected = MinimumBalanceException.class)
  public void checkDebitAmount_InvalidDebitAmount() throws MinimumBalanceException{
    account.debitAmount(9500);
  }
}

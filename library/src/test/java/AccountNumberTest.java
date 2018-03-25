
import com.thoughtworks.bank.AccountNumber;
import com.thoughtworks.bank.InvalidAccountNumberException;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AccountNumberTest {

  @Test(expected = InvalidAccountNumberException.class)
  public void validateAccountNumber() throws InvalidAccountNumberException {
    new AccountNumber("1234-123");
  }

  @Test(expected = InvalidAccountNumberException.class)
  public void accountNumber_should_not_have_alphabets() throws InvalidAccountNumberException {
    new AccountNumber("12c4-ab12");
  }

  @Test
  public void should_not_throw_exception_for_valid_accountNumber() throws InvalidAccountNumberException {
    new AccountNumber("1234-1234");
  }

  @Test
  public void should_give_accountNumber() throws InvalidAccountNumberException {
    AccountNumber accountNumber = new AccountNumber("1234-1235");
    assertThat(accountNumber.getNumber(),is("1234-1235"));

  }
}

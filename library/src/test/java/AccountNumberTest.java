
import com.thoughtworks.bank.AccountNumber;
import com.thoughtworks.bank.InvalidAccountNumberException;
import org.junit.Test;

public class AccountNumberTest {

    @Test(expected = InvalidAccountNumberException.class)
    public void validateAccountNumber() throws InvalidAccountNumberException {
      new AccountNumber("1234-123");
    }

  @Test(expected = InvalidAccountNumberException.class)
  public void acountNumber_should_not_have_alphabets() throws InvalidAccountNumberException {
      new AccountNumber("12c4-ab12");
  }
}

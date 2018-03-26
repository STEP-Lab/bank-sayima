package com.thoughtworks.bank;

import java.util.Objects;
import java.util.regex.Pattern;

import static java.lang.String.valueOf;

public class AccountNumber {
  private String accountNumber;

  public AccountNumber(String accountNumber) throws InvalidAccountNumberException {

    if(isInValidAccountNo(accountNumber)){
      throw new InvalidAccountNumberException();
    }
    this.accountNumber = accountNumber;
  }
  private static boolean isInValidAccountNo(String accountNumber){
    return !Pattern.matches("[0-9]{4}[-][0-9]{4}",valueOf(accountNumber));
  }

  public String getNumber() {
    return accountNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AccountNumber that = (AccountNumber) o;
    return Objects.equals(accountNumber, that.accountNumber);
  }

  @Override
  public int hashCode() {

    return Objects.hash(accountNumber);
  }
}

import org.example.BankAccount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount("123ABC");
    }

    // Test Scenarios:

    // Test deposit of a positive amount
    @Test
    public void testDepositPositiveAmount() {
        account.deposit(500);
        assertEquals("Balance should be updated after deposit", 500, account.getBalance(), 0.01);
        System.out.println("Deposited 500. Current balance: " + account.getBalance());
    }

    // Test whether depositing a negative amount throws an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegativeAmount() {
        account.deposit(-100);
    }

    // Test withdrawal of a valid amount
    @Test
    public void testWithdrawValidAmount() {
        account.deposit(500);
        account.withdraw(200);
        assertEquals("Balance should be updated after withdrawal", 300, account.getBalance(), 0.01);
        System.out.println("Withdrawn 200. Current balance: " + account.getBalance());
    }

    // Test whether withdrawing more than the balance throws an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawMoreThanBalance() {
        account.withdraw(100);
    }

    // Test whether withdrawing a negative amount throws an IllegalArgumentException
    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNegativeAmountThrowsException() {
        account.withdraw(-50);
    }
}
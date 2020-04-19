package ddd.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnackMachineTest {

    @Test
    void insertMoney() {
        SnackMachine snackMachine = new SnackMachine();

        snackMachine.insertMoney(Money.CENT);
        snackMachine.insertMoney(Money.DOLLAR);

        assertEquals(snackMachine.getMoneyInTransaction().getAmount(),1.01,0.001,"Money in transaction must be $1.01");
    }

    @Test
    void returnMoney() {
        SnackMachine snackMachine = new SnackMachine();

        snackMachine.insertMoney(Money.DOLLAR);
        snackMachine.returnMoney();

        assertEquals(snackMachine.getMoneyInTransaction(), Money.NONE,"Money in transaction must be zero");
    }

    @Test
    void buySnack() {
        SnackMachine snackMachine = new SnackMachine();

        snackMachine.insertMoney(Money.DOLLAR);
        snackMachine.insertMoney(Money.DOLLAR);
        snackMachine.buySnack();

        assertEquals(snackMachine.getMoneyInTransaction(), Money.NONE,"There must be no money in transaction");
        assertEquals(snackMachine.getMoneyInside().getAmount(), 2.0, 0.001, "Money inside the machine must be $2.0");
    }

    @Test
    public void insertMoney_Multiple() {
        Exception e = assertThrows(IllegalStateException.class, () -> {
            SnackMachine snackMachine = new SnackMachine();

            Money twoCents = new Money(2, 0, 0, 0, 0, 0);
            snackMachine.insertMoney(twoCents);
        });

        assertTrue(e.getMessage().contains("Invalid insert money"), "Invalid exception message");
    }

}
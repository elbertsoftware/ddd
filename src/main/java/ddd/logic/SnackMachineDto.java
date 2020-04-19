package ddd.logic;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class SnackMachineDto {

    @Id
    @GeneratedValue
    private long id;

    // Money inside
    private int centCount;
    private int dimeCount;
    private int quarterCount;
    private int dollarCount;
    private int fiveDollarCount;
    private int twentyDollarCount;

    // Money in transaction
    private int transactionCentCount;
    private int transactionDimeCount;
    private int transactionQuarterCount;
    private int transactionDollarCount;
    private int transactionFiveDollarCount;
    private int transactionTwentyDollarCount;

    public SnackMachine convertToSnackMachine() {
        SnackMachine snackMachine = new SnackMachine();
        snackMachine.setId(id);

        Money moneyInside = new Money(centCount, dimeCount, quarterCount, dollarCount, fiveDollarCount, twentyDollarCount);
        snackMachine.setMoneyInside(moneyInside);

        Money moneyInTransaction = new Money(transactionCentCount, transactionDimeCount, transactionQuarterCount, transactionDollarCount, transactionFiveDollarCount, transactionTwentyDollarCount);
        snackMachine.setMoneyInTransaction(moneyInTransaction);

        return snackMachine;
    }

}

package ddd.logic;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
final public class SnackMachine extends Entity {

    private Money moneyInside = Money.NONE;
    private Money moneyInTransaction = Money.NONE;

    protected SnackMachine() {}

    public SnackMachine(Money moneyLoad) {
        moneyInside = moneyLoad;
    }

    public SnackMachineDto convertToSnackMachineDto() {
        SnackMachineDto snackMachineDto = new SnackMachineDto();
        snackMachineDto.setId(this.getId());

        snackMachineDto.setCentCount(moneyInside.getCentCount());
        snackMachineDto.setDimeCount(moneyInside.getDimeCount());
        snackMachineDto.setQuarterCount(moneyInside.getQuarterCount());
        snackMachineDto.setDollarCount(moneyInside.getDollarCount());
        snackMachineDto.setFiveDollarCount(moneyInside.getFiveDollarCount());
        snackMachineDto.setTwentyDollarCount(moneyInside.getTwentyDollarCount());

        snackMachineDto.setTransactionCentCount(moneyInTransaction.getCentCount());
        snackMachineDto.setTransactionDimeCount(moneyInTransaction.getDimeCount());
        snackMachineDto.setTransactionQuarterCount(moneyInTransaction.getQuarterCount());
        snackMachineDto.setTransactionDollarCount(moneyInTransaction.getDollarCount());
        snackMachineDto.setTransactionFiveDollarCount(moneyInTransaction.getFiveDollarCount());
        snackMachineDto.setTransactionTwentyDollarCount(moneyInTransaction.getTwentyDollarCount());

        return snackMachineDto;
    }

    public void insertMoney(Money money) {
        Money[] possibleInsert = {
                Money.CENT,
                Money.DIME,
                Money.QUARTER,
                Money.DOLLAR,
                Money.FIVE_DOLLAR,
                Money.TWENTY_DOLLAR,
        };

        if (!Arrays.asList(possibleInsert).contains(money)) {
            throw new IllegalStateException("Invalid insert money");
        }

        moneyInTransaction = moneyInTransaction.add(money);
    }

    public void returnMoney() {
        moneyInTransaction = Money.NONE;
    }

    public void buySnack() {
        moneyInside = moneyInside.add(moneyInTransaction);
        moneyInTransaction = Money.NONE;
    }

}
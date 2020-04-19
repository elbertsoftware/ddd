package ddd.logic;

import lombok.Getter;

@Getter
public class Money extends ValueObject<Money> {

    final static public Money NONE = new Money(0,0,0,0,0,0);
    final static public Money CENT = new Money(1,0,0,0,0,0);
    final static public Money DIME = new Money(0,1,0,0,0,0);
    final static public Money QUARTER = new Money(0,0,1,0,0,0);
    final static public Money DOLLAR = new Money(0,0,0,1,0,0);
    final static public Money FIVE_DOLLAR = new Money(0,0,0,0,1,0);
    final static public Money TWENTY_DOLLAR = new Money(0,0,0,0,0,1);

    private int centCount = 0;
    private int dimeCount = 0;
    private int quarterCount = 0;
    private int dollarCount = 0;
    private int fiveDollarCount = 0;
    private int twentyDollarCount = 0;

    private float amount = 0.0f;

    protected Money() {}

    public Money(int centCount, int dimeCount, int quarterCount, int dollarCount, int fiveDollarCount, int twentyDollarCount) {
        if (centCount < 0) {
            throw new IllegalStateException("centCount can not be negative");
        }

        if (dimeCount < 0) {
            throw new IllegalStateException("dimeCount can not be negative");
        }

        if (quarterCount < 0) {
            throw new IllegalStateException("quarterCount can not be negative");
        }

        if (dollarCount < 0) {
            throw new IllegalStateException("oneDollarCount can not be negative");
        }

        if (fiveDollarCount < 0) {
            throw new IllegalStateException("fiveDollarCount can not be negative");
        }

        if (twentyDollarCount < 0) {
            throw new IllegalStateException("twentyDollarCount can not be negative");
        }

        this.centCount = centCount;
        this.dimeCount = dimeCount;
        this.quarterCount = quarterCount;
        this.dollarCount = dollarCount;
        this.fiveDollarCount = fiveDollarCount;
        this.twentyDollarCount = twentyDollarCount;

        this.amount = calculateAmount();
    }

    // Per DDD value-object definition, Money should be immutable, create new Money instance when changing
    public Money add(Money other) {
        return new Money(
                centCount + other.centCount,
                dimeCount + other.dimeCount,
                quarterCount + other.quarterCount,
                dollarCount + other.dollarCount,
                fiveDollarCount + other.fiveDollarCount,
                twentyDollarCount + other.twentyDollarCount
        );
    }

    public Money substract(Money other) {
        return new Money(
                centCount - other.centCount,
                dimeCount - other.dimeCount,
                quarterCount - other.quarterCount,
                dollarCount - other.dollarCount,
                fiveDollarCount - other.fiveDollarCount,
                twentyDollarCount - other.twentyDollarCount
        );
    }

    @Override
    protected boolean equalsCore(Money other) {
        return centCount == other.centCount &&
                dimeCount == other.dimeCount &&
                quarterCount == other.quarterCount &&
                dollarCount == other.dollarCount &&
                fiveDollarCount == other.fiveDollarCount &&
                twentyDollarCount == other.twentyDollarCount;
    }

    @Override
    protected int hashCodeCore() {
        final int PRIME = 397;

        int hashCode = centCount;
        hashCode = (PRIME * hashCode) ^ dimeCount;
        hashCode = (PRIME * hashCode) ^ quarterCount;
        hashCode = (PRIME * hashCode) ^ dollarCount;
        hashCode = (PRIME * hashCode) ^ fiveDollarCount;
        hashCode = (PRIME * hashCode) ^ twentyDollarCount;

        return hashCode;
    }

    private float calculateAmount() {
        return centCount * 0.01f +
                dimeCount * 0.10f +
                quarterCount * 0.25f +
                dollarCount +
                fiveDollarCount * 5.f +
                twentyDollarCount * 20.f;
    }

}
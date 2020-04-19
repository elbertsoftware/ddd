package ddd.logic;

abstract public class ValueObject<T> {

    abstract protected boolean equalsCore(T other);
    abstract protected int hashCodeCore();

    @Override
    public boolean equals(Object obj) {
        T other = (T)obj;
        if (other == null) {
            return false;
        }

        return equalsCore(other);
    }

    @Override
    public int hashCode() {
        return hashCodeCore();
    }

}

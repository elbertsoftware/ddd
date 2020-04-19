package ddd.logic;

import lombok.Getter;
import lombok.Setter;

abstract public class Entity {

    @Getter
    @Setter
    protected long id;

    @Override
    public boolean equals(Object obj) {
        Entity other = null;
        if (obj instanceof Entity) {
            other = (Entity)obj;
        }

        if (other == null) {
            return false;
        }

        // Reference equality
        if (this == other) {
            return true;
        }

        // Identifier equality
        if (this.getClass() != other.getClass()) { // different classes
            return false;
        }

        if (id == 0 || other.getId() == 0) { // unassigned id
            return false;
        }

        return id == other.getId();
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result =  PRIME * result + (int)(id ^ (id >>> 32));

        return result;
    }

}

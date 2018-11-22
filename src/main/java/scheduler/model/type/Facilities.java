package scheduler.model.type;

import scheduler.model.enums.Facility;

public class Facilities {

    public int indexes;

    public Facilities(Facility... facilities) {
        this.indexes = 0;

        for(Facility facility : facilities) {
            this.indexes |= (1 << facility.index);
        }
    }

    public boolean hasAllOf(Facilities facilities) {
        return (this.indexes | ~facilities.indexes) == -1;
    }
}

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

    public boolean hasAllOf(Facility... facilities) {
        for(Facility facility : facilities) {
            if((this.indexes & (1 << facility.index)) == 0) return false;
        }

        return true;
    }
}

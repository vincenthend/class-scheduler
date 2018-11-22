package scheduler.model.enums;

public enum Facility {

    PROJECTOR(0),
    AUDIO(1),
    WHITEBOARD(2);

    private int bitmask;

    Facility(int index) {
        this.bitmask = 1 << index;
    }

    public int getBitmask() {
        return bitmask;
    }
}

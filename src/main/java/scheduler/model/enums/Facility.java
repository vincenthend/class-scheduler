package scheduler.model.enums;

public enum Facility {

    PROJECTOR(0),
    AUDIO(1),
    WHITEBOARD(2);

    public int index;

    Facility(int index) {
        this.index = index;
    }
}

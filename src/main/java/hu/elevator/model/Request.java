package hu.elevator.model;

/**
 * @author Peter_Fazekas on 2017.04.15..
 */
public class Request {

    private final Time time;
    private final int groupId;
    private final int from;
    private final int to;

    public Request(Time time, int groupId, int from, int to) {
        this.time = time;
        this.groupId = groupId;
        this.from = from;
        this.to = to;
    }

    public Time getTime() {
        return time;
    }

    public int getGroupId() {
        return groupId;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}

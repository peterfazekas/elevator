package hu.elevator.service;

import hu.elevator.model.Request;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;

/**
 * @author Peter_Fazekas on 2017.04.15..
 */
public class Elevator {

    private final List<Request> requests;
    private int initLevel;

    public Elevator(final List<Request> requests) {
        this.requests = requests;
    }

    public void setInitLevel(int initLevel) {
        this.initLevel = initLevel;
    }

    public int getFinalLevel() {
        int last = requests.size() - 1;
        return requests.get(last).getTo();
    }

    public int getMaxLevel() {
        int maxFrom = requests.stream().mapToInt(Request::getFrom).max().getAsInt();
        int maxTo = requests.stream().mapToInt(Request::getTo).max().getAsInt();
        List<Integer> maxLevel = Arrays.asList(maxFrom, maxTo, initLevel);
        return maxLevel.stream().mapToInt(i ->i).max().getAsInt();
    }

    public int getMinLevel() {
        int minFrom = requests.stream().mapToInt(Request::getFrom).min().getAsInt();
        int minTo = requests.stream().mapToInt(Request::getTo).min().getAsInt();
        List<Integer> minLevel = Arrays.asList(minFrom, minTo, initLevel);
        return minLevel.stream().mapToInt(i ->i).min().getAsInt();
    }

}

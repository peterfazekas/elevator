package hu.elevator.data.log;

import java.util.List;

/**
 * @author Peter_Fazekas on 2017.04.16..
 */
public interface DataLogger {

    void printAll(final List<String> lines);
}

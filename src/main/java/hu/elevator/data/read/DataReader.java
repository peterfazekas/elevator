package hu.elevator.data.read;

import java.util.List;

/**
 * @author Peter_Fazekas on 2017.04.15..
 */
public interface DataReader {

    List<String> read(final String fileName);

}

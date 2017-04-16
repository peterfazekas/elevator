package hu.elevator.data.read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Peter_Fazekas on 2017.04.15..
 */
public class FileDataReader implements DataReader {

    private static final String PATH = "src\\main\\resources\\";

    public List<String> read(final String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(PATH + fileName))) {
            lines = read.lines()
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}

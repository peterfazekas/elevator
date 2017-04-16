package hu.elevator.data.log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Peter_Fazekas on 2017.04.16..
 */
public class FileDataLogger implements DataLogger {

    private static final String PATH = "src\\main\\resources\\";

    private final String fileName;

    public FileDataLogger(String fileName) {
        this.fileName = PATH + fileName;
    }

    @Override
    public void printAll(List<String> lines) {
        try (PrintWriter log = new PrintWriter(new FileWriter(fileName))) {
            lines.forEach(log::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

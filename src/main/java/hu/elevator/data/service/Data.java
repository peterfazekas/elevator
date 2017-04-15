package hu.elevator.data.service;

import hu.elevator.data.parse.DataParser;
import hu.elevator.data.read.DataReader;
import hu.elevator.data.read.FileDataReader;
import hu.elevator.model.Request;

import java.util.List;

/**
 * @author Peter_Fazekas on 2017.04.15..
 */
public class Data {

    private final String fileName;

    public Data(final String fileName) {
        this.fileName = fileName;
    }

    public List<Request> getData() {
        DataReader file = new FileDataReader();
        DataParser data = new DataParser();
        return data.parse(file.read(fileName));
    }
}

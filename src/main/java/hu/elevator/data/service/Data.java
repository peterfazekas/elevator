package hu.elevator.data.service;

import hu.elevator.data.parse.DataParser;
import hu.elevator.data.read.DataReader;
import hu.elevator.data.read.FileDataReader;
import hu.elevator.model.Request;
import hu.elevator.service.Elevator;

import java.util.List;

/**
 * @author Peter_Fazekas on 2017.04.15..
 */
public class Data {

    private final DataReader file;
    private final DataParser data;

    public Data() {
        file = new FileDataReader();
        data = new DataParser();
    }

    public Elevator getElevator(final String fileName) {
        return new Elevator(getData(fileName), getNumberOfGroups());
    }

    private List<Request> getData(final String fileName) {
        return data.parse(file.read(fileName));
    }

    private int getNumberOfGroups() {
        return data.getNumberOfGroups();
    }

}

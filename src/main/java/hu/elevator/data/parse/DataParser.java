package hu.elevator.data.parse;

import hu.elevator.model.Request;
import hu.elevator.model.Time;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Peter_Fazekas on 2017.04.15..
 */
public class DataParser {

    private static final String SEPARATOR = " ";

    private List<String> trim(final List<String> lines) {
        return lines.subList(3, lines.size());
        //        List<String> trimmedList = new ArrayList<>();
//        for (int i = 3; i <lines.size() ; i++) {
//            trimmedList.add(lines.get(i));
//        }
//        return trimmedList;
    }

    public List<Request> parse(final List<String> lines) {
        List<String> trimmedList = trim(lines);
        return trimmedList.stream().map(this::createRequest).collect(Collectors.toList());
    }


    private Request createRequest(final String line) {
        String[] items = line.split(SEPARATOR);
        Time time = createTime(items);
        int groupId = parseInt(items[3]);
        int from = parseInt(items[4]);
        int to = parseInt(items[5]);
        return new Request(time, groupId, from, to);
    }

    private Time createTime(final String[] items) {
        int hour = parseInt(items[0]);
        int minute = parseInt(items[1]);
        int second = parseInt(items[2]);
        return new Time(hour, minute, second);
    }

    private int parseInt(final String item) {
        return Integer.parseInt(item);
    }
}

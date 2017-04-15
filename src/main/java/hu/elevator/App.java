package hu.elevator;

import hu.elevator.data.service.Data;
import hu.elevator.service.Console;
import hu.elevator.service.Elevator;

import java.util.Scanner;

/**
 * @author Peter_Fazekas on 2017.04.15..
 */
public class App {

    private final Elevator elevator;
    private final Data data;
    private final Console console;

    public App() {
        data = new Data("igeny.txt");
        elevator = new Elevator(data.getData());
        console = new Console(new Scanner(System.in));
    }

    public static void main(String[] args) {
        App app = new App();
        app.println();
    }

    private void println() {
        System.out.print("2. feladat: Kérem adja meg melyik szinten áll jelenleg a lift [1-100]: ");
        elevator.setInitLevel(console.readInt());
        System.out.println(String.format("3. feladat: A lift a %d. szinten áll az utolsó igény teljesítése után.",
                elevator.getFinalLevel()));
        System.out.println(String.format("4. feladat: A legalacsonyabb szint a(z) %d., a legmagasabb a(z) %d. volt.",
                elevator.getMinLevel(), elevator.getMaxLevel()));
    }
}

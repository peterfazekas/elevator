package hu.elevator;

import hu.elevator.data.log.DataLogger;
import hu.elevator.data.log.FileDataLogger;
import hu.elevator.data.service.Data;
import hu.elevator.service.Console;
import hu.elevator.service.Elevator;

import java.util.Scanner;

/**
 * @author Peter_Fazekas on 2017.04.15..
 */
class App {

    private static final String INPUT = "igeny.txt";
    private static final String OUTPUT = "blokkol.txt";
    private final Elevator elevator;
    private final Console console;
    private final DataLogger log;

    private App() {
        Data data = new Data();
        console = new Console(new Scanner(System.in));
        elevator = data.getElevator(INPUT);
        log = new FileDataLogger(OUTPUT);
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
        System.out.println(String.format("5. feladat: A lift %d alkalommal ment felfelé utassal és %d alkalommal utas nélkül.",
                elevator.getUpWithGroups(), elevator.getUpWithoutGroups()));
        System.out.println(String.format("6. feladat: A következő szerelőcsapatok nem vették igénybe a liftet: %s",
                elevator.getGroupDidNotUsedTheElevator()));
        System.out.print("7. feladat: " + elevator.getGroupFouls());
        log.printAll(elevator.blockingCard());
    }
}

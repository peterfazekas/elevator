package hu.elevator.service;

import java.util.Scanner;

/**
 * @author Peter_Fazekas on 2017.04.15..
 */
public class Console {

    private final Scanner sc;

    public Console(Scanner sc) {
        this.sc = sc;
    }

    public int readInt() {
        return sc.nextInt();
    }
}

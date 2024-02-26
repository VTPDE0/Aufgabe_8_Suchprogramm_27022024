package org.example;
import java.util.Scanner;

public class Benutzereingabe {
    private Scanner scanner;

    public Benutzereingabe() {
        scanner = new Scanner(System.in);
    }

    public String leseSuchbegriff() {
        System.out.println("Bitte geben Sie einen Suchbegriff ein:");
        return scanner.nextLine();
    }
}

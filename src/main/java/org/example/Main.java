package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gib einen Text ein:");
        String text = scanner.nextLine();

        System.out.println("Gib einen Suchbegriff ein:");
        String suchbegriff = scanner.nextLine();

        Suchfunktion suche = new Suchfunktion(text, suchbegriff);
        suche.suche();

        scanner.close();
    }
}

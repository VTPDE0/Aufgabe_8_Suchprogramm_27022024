package org.example;

import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class SucheMitRegex {
    private String dateipfad;
    public SucheMitRegex(String dateipfad) {
        this.dateipfad = dateipfad;
    }


    public boolean sucheMitRegex(String regex) throws FileNotFoundException {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Scanner scanner = new Scanner(new File(dateipfad));
        boolean istGefunden = false;

        int zeilenNummer = 0;
        while (scanner.hasNextLine()) {
            String zeile = scanner.nextLine();
            zeilenNummer++;
            Matcher matcher = pattern.matcher(zeile);
            while (matcher.find()) {
                istGefunden = true;
                System.out.println("Gefunden in Zeile " + zeilenNummer + ", Position " + matcher.start() + ": " + matcher.group());
            }

        }
        return istGefunden;
    }
}


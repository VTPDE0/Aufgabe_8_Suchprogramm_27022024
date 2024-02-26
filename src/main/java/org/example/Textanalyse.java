package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Textanalyse {
    private String dateipfad;

    public Textanalyse(String dateipfad) {
        this.dateipfad = dateipfad;
    }

    // Methode zum Zählen der Zeilen in der Datei
    public int zaehleZeilen() throws FileNotFoundException {
        Scanner dateiScanner = new Scanner(new File(dateipfad));
        int zeilenZahl = 0;
        while (dateiScanner.hasNextLine()) {
            zeilenZahl++;
            dateiScanner.nextLine();
        }
        return zeilenZahl;
    }

}

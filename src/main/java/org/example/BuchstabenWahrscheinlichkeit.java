package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class BuchstabenWahrscheinlichkeit {
    private String dateipfad;
    private HashMap<Character, Integer> buchstabenMap = new HashMap<>();
    public BuchstabenWahrscheinlichkeit(String dateipfad) {
        this.dateipfad = dateipfad;
    }


    public HashMap<Character, Integer> zaehleBuchstabenHaeufigkeit() throws FileNotFoundException {
        HashMap<Character, Integer> buchstabenHaeufigkeit = new HashMap<>();
        Scanner scanner = new Scanner(new File(dateipfad));
        while (scanner.hasNextLine()) {
            String zeile = scanner.nextLine().toLowerCase(); // Den Text zu Kleinbuchstaben konvertieren
            for (char zeichen : zeile.toCharArray()) {
                if (Character.isLetter(zeichen)) {
                    buchstabenHaeufigkeit.put(zeichen, buchstabenHaeufigkeit.getOrDefault(zeichen, 0) + 1);
                }
            }
        }
        return buchstabenHaeufigkeit;
    }
    public void berechneBuchstabenWahrscheinlichkeit() throws FileNotFoundException {
        HashMap<Character, Integer> haeufigkeit = zaehleBuchstabenHaeufigkeit();
        int gesamtBuchstaben = haeufigkeit.values().stream().mapToInt(Integer::intValue).sum();
        haeufigkeit.forEach((buchstabe, anzahl) -> {
            // DecimalFormat ist hier um Zahlenanzahl nach der Komma im Format #.### auszugeben
            DecimalFormat decimalFormat = new DecimalFormat( "#.###" );
            String wahrscheinlichkeit = decimalFormat.format(100.0 * anzahl / gesamtBuchstaben);

            System.out.println("Buchstabe '" + buchstabe + "' erscheint " + anzahl + " Mal im Dokument, Wahrscheinlichkeit: " + wahrscheinlichkeit + " %.");
        });
    }

}


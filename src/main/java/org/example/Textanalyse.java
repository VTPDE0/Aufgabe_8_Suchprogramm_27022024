package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Textanalyse {
    private String dateipfad;

    public Textanalyse(String dateipfad) {
        // Speichert den Pfad zur Datei, die analysiert werden soll.
        this.dateipfad = dateipfad;
    }


    public int zaehleZeilen() throws FileNotFoundException {
        Scanner zeilenScanner = new Scanner(new File(dateipfad));
        int zeilenZahl = 0;
        while (zeilenScanner.hasNextLine()) {
            zeilenZahl++;
            zeilenScanner.nextLine();
        }
        return zeilenZahl;
    }
    public int zaehleWoerter() throws FileNotFoundException {
        Scanner woerterScanner = new Scanner(new File(dateipfad));
        int wortAnzahl = 0;
        /*Solang Scanner hat Zeile zum Ablesen*/
        while (woerterScanner.hasNextLine()) {
            /*Wird dann jede neue Zeile in Variable zeile hinzugefügt*/
            String zeile = woerterScanner.nextLine();
            /*[] weil das Array ist!!!*/
            String[] worte = zeile.split(" ");
            wortAnzahl += worte.length;
        }
        return wortAnzahl;
    }
    public int zaehleBuchstaben() throws FileNotFoundException {
        Scanner buchstabenScanner = new Scanner(new File(dateipfad));
        int buchstabenAnzahl = 0;
        while (buchstabenScanner.hasNextLine()) {
            String zeile = buchstabenScanner.nextLine();
            for (int i = 0; i < zeile.length(); i++){
                char zeichen = zeile.charAt(i);
                if (Character.isLetter(zeichen)){
                    buchstabenAnzahl ++;
                }
            }
        }
        return buchstabenAnzahl;
    }
    public int zaehleSuchbegriffHaeufigkeit(String suchbegriff) throws FileNotFoundException {
        Scanner haefigkeitsScanner = new Scanner(new File(dateipfad));
        int haeufigkeit = 0;
        suchbegriff = suchbegriff.toLowerCase(); //wandelt jetzt Suchbegriff zu Kleinbuchstaben um
        while (haefigkeitsScanner.hasNextLine()) {
            String zeile = haefigkeitsScanner.nextLine().toLowerCase(); //wandelt jetzt Suchbegriff zu Kleinbuchstaben um
            // "indexOf" ist eine Methode der Klasse String, es sucht das erste Auftreten eines Suchbegriff in Zeile
            int index = zeile.indexOf(suchbegriff);
            //hier -1 representiert unmöglicher Wert von Methode indexOf, da erste Überstimmung 0 ist
            //und damit -1 ist festgelegt für signal "ich habe nichts gefunden"
            while (index != -1) {
                haeufigkeit++;
                //hier machen wir das gleiche wie zuvor, aber zählen nicht bereits gefundene Übereinstimmungen (dank index +1)
                index = zeile.indexOf(suchbegriff, index + 1);
            }
        }
        return haeufigkeit;
    }


}

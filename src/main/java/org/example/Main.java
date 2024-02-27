package org.example;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Benutzereingabe eingabe = new Benutzereingabe();
        //hier speichern wir in Variable suchbegriff alles was User eingibt mithilfe Methode aus Benutzereingabe Klasse "leseSuchbegriff"
        String suchbegriff = eingabe.leseSuchbegriff();

        Suchfunktion suche = new Suchfunktion("C:/Users/VolodymyrTeperyk/OneDrive - ORDIX AG/Desktop/Beispieltext.txt");
        try {
            boolean gefunden = suche.sucheNachBegriff(suchbegriff);
            if (gefunden) {
                System.out.println("Der Suchbegriff '" + suchbegriff + "' wurde gefunden.");
            } else {
                System.out.println("Der Suchbegriff '" + suchbegriff + "' wurde nicht in der Textdatei gefunden.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden.");
        }
        Textanalyse zeilenrechner = new Textanalyse("C:/Users/VolodymyrTeperyk/OneDrive - ORDIX AG/Desktop/Beispieltext.txt");
        try {
            int zeilenAnzahl = zeilenrechner.zaehleZeilen();
            System.out.println("Anzahl der Zeilen in der Datei: " + zeilenAnzahl);
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden.");
        }
        Textanalyse woerterZaehler = new Textanalyse("C:/Users/VolodymyrTeperyk/OneDrive - ORDIX AG/Desktop/Beispieltext.txt");
        try {
            int woerterAnzahl = woerterZaehler.zaehleWoerter();
            System.out.println("Anzahl der Wörter in der Datei: " + woerterAnzahl);
            //was ist eigentlich e?
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden.");
        }
        Textanalyse buchstabenZaehler = new Textanalyse("C:/Users/VolodymyrTeperyk/OneDrive - ORDIX AG/Desktop/Beispieltext.txt");
        try {
            int buchstabenAnzahl = buchstabenZaehler.zaehleBuchstaben();
            System.out.println("Anzahl der Buchstaben in der Datei: " + buchstabenAnzahl);
            //das ist Variable für Problemname?
        } catch (FileNotFoundException objektNichtgefunden) {
            System.out.println("Datei nicht gefunden.");
        }
        Textanalyse zaehleSuchbegriffHaeufigkeit = new Textanalyse("C:/Users/VolodymyrTeperyk/OneDrive - ORDIX AG/Desktop/Beispieltext.txt");
        try {
            int haefigkeitAnzahl = zaehleSuchbegriffHaeufigkeit.zaehleSuchbegriffHaeufigkeit(suchbegriff);
            System.out.println("Suchbegriff '" + suchbegriff + "' kommt " + haefigkeitAnzahl + " mal im Dokument vor");
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden.");
        }
    }


/*   am beste ich nutze doch Klassen, hier aufrufe ich die Methoden nur*/
}


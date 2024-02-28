package org.example;
import java.io.FileNotFoundException;
import java.lang.System;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        //_____________________________________________

        String currentDirectory = System.getProperty("user.dir");
        System.out.println("________________________________________________________");
        System.out.println("Das aktuelle Arbeitsverzeichnis ist: " + currentDirectory);

        //Pfad für Testzwecke C:/Users/VolodymyrTeperyk/OneDrive - ORDIX AG/Desktop/Beispieltext.txt

        //_____________________________________________

        Benutzereingabe pfad_zu_Datei_Eingabe = new Benutzereingabe();
        String pfad_zu_Datei = pfad_zu_Datei_Eingabe.leseDateipfad();

        //_____________________________________________

        Benutzereingabe eingabe = new Benutzereingabe();
        //hier speichern wir in Variable suchbegriff alles, was User eingibt mithilfe Methode aus Benutzereingabe Klasse "leseSuchbegriff"
        String suchbegriff = eingabe.leseSuchbegriff();

        //_____________________________________________


        Suchfunktion suche = new Suchfunktion(pfad_zu_Datei);
        //try catch verwendet man wenn man den Fall erwartet, wenn Fehler rauskommen kann. z.B. in meinem Fall Datei existiert nicht oder Pfad ist falsch = Fehler
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

        //_____________________________________________

        Textanalyse zeilenRechner = new Textanalyse(pfad_zu_Datei);
        try {
            int zeilenAnzahl = zeilenRechner.zaehleZeilen();
            System.out.println("Anzahl der Zeilen in der Datei: " + zeilenAnzahl);
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden.");
        }

        //_____________________________________________

        Textanalyse woerterZaehler = new Textanalyse(pfad_zu_Datei);
        try {
            int woerterAnzahl = woerterZaehler.zaehleWoerter();
            System.out.println("Anzahl der Wörter in der Datei: " + woerterAnzahl);
            //was ist eigentlich e?
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden.");
        }

        //_____________________________________________

        Textanalyse buchstabenZaehler = new Textanalyse(pfad_zu_Datei);
        try {
            int buchstabenAnzahl = buchstabenZaehler.zaehleBuchstaben();
            System.out.println("Anzahl der Buchstaben in der Datei: " + buchstabenAnzahl);
            //das ist Variable für Problemname?
        } catch (FileNotFoundException objektNichtgefunden) {
            System.out.println("Datei nicht gefunden.");
        }

        //_____________________________________________

        Textanalyse zaehleSuchbegriffHaeufigkeit = new Textanalyse(pfad_zu_Datei);
        try {
            int haefigkeitAnzahl = zaehleSuchbegriffHaeufigkeit.zaehleSuchbegriffHaeufigkeit(suchbegriff);
            System.out.println("___");
            System.out.println("Suchbegriff '" + suchbegriff + "' kommt " + haefigkeitAnzahl + " mal im Dokument vor");
            System.out.println("___");
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden.");
        }

        //_____________________________________________
        try {
        Suchfunktion_mit_Kontextanzeige methode_suchfunktion_mit_kontextanzeige = new Suchfunktion_mit_Kontextanzeige(pfad_zu_Datei);

            methode_suchfunktion_mit_kontextanzeige.suche_mit_Kontexanzeige(suchbegriff);
        } catch (FileNotFoundException e){
            System.out.println("Datei nicht gefunden.");
        }
    }


/*   am beste ich nutze doch die Klassen, hier aufrufe ich die Methoden nur*/
}


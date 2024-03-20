package org.example;
import java.io.FileNotFoundException;
import java.lang.System;
import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);



        //_____________________________________________
        //_____________________________________________
        //_____________________________________________

//        für Testzwecke auskommentiert und Dateipfad vordefiniert

        String currentDirectory = System.getProperty("user.dir");
        System.out.println("________________________________________________________");
        System.out.println("Das aktuelle Arbeitsverzeichnis ist: " + currentDirectory);
        //Pfad für Testzwecke C:/Users/VolodymyrTeperyk/OneDrive - ORDIX AG/Desktop/Beispieltext.txt
        //BeispieltextInDatei.txt

        //_____________________________________________
        //_____________________________________________
        //_____________________________________________

        Benutzereingabe pfad_zu_Datei_Eingabe = new Benutzereingabe(scanner);
        String pfad_zu_Datei = pfad_zu_Datei_Eingabe.leseDateipfad();



//        String pfad_zu_Datei = "C:/Users/VolodymyrTeperyk/OneDrive - ORDIX AG/Desktop/Beispieltext.txt";
//        String pfad_zu_Datei = "BeispieltextInDatei.txt";

        //_____________________________________________
        //_____________________________________________
        //_____________________________________________
        Benutzereingabe eingabe = new Benutzereingabe(scanner);
        //hier speichern wir in Variable suchbegriff alles, was User eingibt mithilfe Methode aus Benutzereingabe Klasse "leseSuchbegriff"
        String suchbegriff = eingabe.leseSuchbegriff();

        //_____________________________________________
        //_____________________________________________
        //_____________________________________________

        Suchfunktion suche = new Suchfunktion(pfad_zu_Datei);
        //try catch verwendet man, wenn man den Fall erwartet, wenn Fehler rauskommen kann. z.B. in meinem Fall Datei existiert nicht oder Pfad ist falsch = Fehler
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
        //_____________________________________________
        //_____________________________________________

        Textanalyse zeilenRechner = new Textanalyse(pfad_zu_Datei);
        try {
            int zeilenAnzahl = zeilenRechner.zaehleZeilen();
            System.out.println("Anzahl der Zeilen in der Datei: " + zeilenAnzahl);
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden.");
        }

        //_____________________________________________
        //_____________________________________________
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
        //_____________________________________________
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
        //_____________________________________________
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
        //_____________________________________________
        //_____________________________________________

        try {
        Suchfunktion_mit_Kontextanzeige methode_suchfunktionMitKontextanzeige = new Suchfunktion_mit_Kontextanzeige(pfad_zu_Datei);

            methode_suchfunktionMitKontextanzeige.suche_mit_Kontexanzeige(suchbegriff);
        } catch (FileNotFoundException e){
            System.out.println("Datei nicht gefunden.");
        }

        //_____________________________________________
        //_____________________________________________
        //_____________________________________________

        BuchstabenWahrscheinlichkeit buchstabenAnalyse = new BuchstabenWahrscheinlichkeit(pfad_zu_Datei);

        try {
            buchstabenAnalyse.berechneBuchstabenWahrscheinlichkeit();
        } catch (FileNotFoundException e) {
            System.out.println("Die Datei " + pfad_zu_Datei + " wurde nicht gefunden.");
        }

        //_____________________________________________
        //_____________________________________________
        //_____________________________________________
        Benutzereingabe regexEingabe = new Benutzereingabe(scanner);
        String regex = regexEingabe.leseSuchbegriffFuerRegexSuche(); // Nutzen Sie eine Methode, die den Benutzer auffordert, einen regulären Ausdruck einzugeben

        SucheMitRegex regexSuche = new SucheMitRegex(pfad_zu_Datei);
        try {
            boolean gefunden = regexSuche.sucheMitRegex(regex);
            if (!gefunden) {
                System.out.println("Keine Übereinstimmungen gefunden.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden.");
        }

            //_____________________________________________
            //_____________________________________________
            //_____________________________________________
//        while (true) {

        String[] dateipfade = {"BeispieltextInDatei.txt", "BeispieltextInDatei_2.txt", "BeispieltextInDatei_3.txt"};
        String suchbegriffFürParalleleSuche = suchbegriff;
        ExecutorService executor = Executors.newFixedThreadPool(dateipfade.length);
        List<Future<Boolean>> futures = new ArrayList<>();

        for (String dateipfad : dateipfade) {
            Callable<Boolean> task = new SuchfunktionTask_Parallelesuche(dateipfad, suchbegriff);
            Future<Boolean> future = executor.submit(task);
            futures.add(future);
        }

        executor.shutdown();
        boolean finished = false;
        try {
            finished = executor.awaitTermination(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (finished) {
            boolean atLeastOneFound = futures.stream().anyMatch(future -> {
                try {
                    return future.get();
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            });
            System.out.println("______________________________________________________");
            System.out.println("Parallele Suche:");
            System.out.println("Mindestens eine Datei enthält Suchbegriff: " + atLeastOneFound);
        } else {
            System.out.println("Die Suche war nicht schnellgenug erledigt.");
        }



        //_____________________________________________
        //_____________________________________________
        //_____________________________________________
        /*if (suchbegriff.equalsIgnoreCase("exit")) {
                System.out.println("Programm wird beendet...");
                break;
            }*/
    }

    //_____________________________________________
    //_____________________________________________
    //_____________________________________________

}



/*   am beste ich nutze doch die Klassen, hier aufrufe ich die Methoden nur*/
//}


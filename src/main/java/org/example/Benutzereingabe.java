package org.example;
import java.io.File;
import java.util.Scanner;

public class Benutzereingabe {
    private Scanner scanner;
    /* Konstruktor, der den Scanner als Parameter akzeptiert. */
    public Benutzereingabe(Scanner scanner) {
        this.scanner = scanner;
    }


    public String leseSuchbegriff() {
        System.out.println("______________________________________");
        System.out.println("Bitte geben Sie einen Suchbegriff ein:");
        System.out.println("\u001B[31m" + "(nach der Suche zum Programm beenden geben Sie 'exit' ein oder drücken Sie 'Enter' um nochmals zu suchen)" + "\u001B[0m");
        System.out.println("(z.B. ein Wort 'Ziel' oder Ausdruck 'Ich weiß'. Egal groß oder klein)");
        return scanner.nextLine();
    }

    public String leseSuchbegriffFuerRegexSuche() {
        System.out.println("______________________________________________________");
        System.out.println("Bitte geben Sie einen Suchbegriff für Regex Suche ein:");
        System.out.println("\u001B[31m" + "(nach der Suche zum Programm beenden geben Sie 'exit' ein oder drücken Sie 'Enter' um nochmals zu suchen)" + "\u001B[0m");
        System.out.println("______________________________________________________");
        System.out.println("Beispielanfragen für Testzwecke:");
        System.out.println("");
        System.out.println("Groß- und Kleinschreibung ignorieren:");
        System.out.println("[Aa]pfel");
        System.out.println("");
        System.out.println("Zahlen suchen:");
        System.out.println("\\d+");
        System.out.println("");
        System.out.println("Suche nach Preisen:");
        System.out.println("\\$[0-9]+");
        System.out.println("");
        System.out.println("Postleitzahlen finden:");
        System.out.println("\\d{5}");
        System.out.println("");
        System.out.println("E-Mail-Adressen finden");
        System.out.println("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        System.out.println("");
        System.out.println("Telefonnummern finden:");
        System.out.println("\\+\\d{1,2} \\d{3} \\d{6}");
        System.out.println("");
        return scanner.nextLine();
    }

    public String leseDateipfad() {
        System.out.println("______________________________________________________________________________________________________________________________");
        System.out.println("Bitte geben Sie Dateipfad für Ihre .txt Datei an");
        System.out.println("\u001B[31m" + "(nach der Suche zum Programm beenden geben Sie 'exit' ein oder drücken Sie 'Enter' um nochmals zu suchen)" + "\u001B[0m");
        System.out.println("(z.B. C:/Users/VolodymyrTeperyk/OneDrive - ORDIX AG/Desktop/Beispieltext.txt)");
        System.out.println();
        System.out.println("Falls .txt Datei bereits in Programmverzeichniss liegt- dürfen Sie mit der Eingabe des vollständigen Dateinamens fortfahren");
        System.out.println("(z.B. BeispieltextInDatei.txt)");

        String pfad_zu_Datei = scanner.nextLine();
        File datei = new File(pfad_zu_Datei);
        while (!datei.exists()) {
            System.out.println("Die angegebene Datei nicht gefunden. Versuchen Sie nochmals bitte.");
            pfad_zu_Datei = scanner.nextLine();
            datei = new File(pfad_zu_Datei);
        }
        return pfad_zu_Datei;
    }
}
package org.example;
import java.io.File;
import java.util.Scanner;

public class Benutzereingabe {
    private Scanner scanner;

    public Benutzereingabe() {
        scanner = new Scanner(System.in);
    }

    public String leseSuchbegriff() {
        System.out.println("______________________________________");
        System.out.println("Bitte geben Sie einen Suchbegriff ein:");
        return scanner.nextLine();
    }

    public String leseDateipfad() {
        System.out.println("______________________________________________________________________________________________________________________________");
        System.out.println("Bitte geben Sie Dateipfad für Ihre .txt Datei an");
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
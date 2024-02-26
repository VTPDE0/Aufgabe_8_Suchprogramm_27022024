package org.example;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Benutzereingabe eingabe = new Benutzereingabe();
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
        Textanalyse analyse = new Textanalyse("C:/Users/VolodymyrTeperyk/OneDrive - ORDIX AG/Desktop/Beispieltext.txt"); // Pfad zur Textdatei anpassen
        try {
            int zeilenAnzahl = analyse.zaehleZeilen();
            System.out.println("Anzahl der Zeilen in der Datei: " + zeilenAnzahl);
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden.");
        }
    }

        // Erstellung und Nutzung der Textanalyse-Klasse analog
    }


package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;
public class Suchfunktion_mit_Kontextanzeige {
    private String dateipfad;
    private HashMap<Integer, String> zeilenMap = new HashMap<>();
//Konstruktor
    public Suchfunktion_mit_Kontextanzeige(String dateipfad) throws FileNotFoundException{
        Scanner dateiScanner = new Scanner(new File(dateipfad)) ;
        int zeilenNummer = 1;
        // hier wird jede Zeile in zeilenMap gespeichert
        while (dateiScanner.hasNextLine()){
            zeilenMap.put(zeilenNummer, dateiScanner.nextLine());
            zeilenNummer ++;
        }

    }
// jetzt Methode
    public void suche_mit_Kontexanzeige (String suchbegriff){
        suchbegriff = suchbegriff.toLowerCase();
        for (int zeilenNummer : zeilenMap.keySet()){
            String zeile =zeilenMap.get(zeilenNummer).toLowerCase();
            if (zeile.contains(suchbegriff)){
                System.out.println("Zeile " + (zeilenNummer - 1) + ": " + zeilenMap.getOrDefault(zeilenNummer -1,"\u001B[31m" + "%%% Diese Zeile existiert nicht, die nächste Zeile ist die erste Zeile des Dokuments %%%" + "\u001B[0m"));
                System.out.println("Zeile " + zeilenNummer + ": " + zeilenMap.get(zeilenNummer));
                System.out.println("Zeile " + (zeilenNummer + 1) + ": " + zeilenMap.getOrDefault(zeilenNummer +1,"\u001B[31m" + "%%% Diese Zeile existiert nicht, die vorherige Zeile war die letzte Zeile des Dokuments %%%" + "\u001B[0m"));
                System.out.println("___");
            }
        }
    }
}


package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Suchfunktion {
        private String dateipfad;

        public Suchfunktion(String dateipfad) {
                this.dateipfad = dateipfad;
        }

//        Das hier war nur boolean, damit konnte man nicht die Zeilen ausgeben, also am besten neue Klasse schreiben wo es möglich ist
        boolean sucheNachBegriff(String suchbegriff) throws FileNotFoundException {
                Scanner dateiScanner = new Scanner(new File(dateipfad));
                while (dateiScanner.hasNextLine()) {
                        if (dateiScanner.nextLine().toLowerCase().contains(suchbegriff.toLowerCase())) { //wandelt jetzt Suchbegriff zu Kleinbuchstaben um
                                return true;
                        }
                }
                return false;
        }


}

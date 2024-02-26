package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Suchfunktion {
        private String dateipfad;

        public Suchfunktion(String dateipfad) {
                this.dateipfad = dateipfad;
        }

        public boolean sucheNachBegriff(String suchbegriff) throws FileNotFoundException {
                Scanner dateiScanner = new Scanner(new File(dateipfad));
                while (dateiScanner.hasNextLine()) {
                        if (dateiScanner.nextLine().contains(suchbegriff)) {
                                return true;
                        }
                }
                return false;
        }
}

package org.example;

import java.util.concurrent.Callable;
import java.io.File;
import java.util.Scanner;

public class SuchfunktionTask_Parallelesuche implements Callable<Boolean> {
    private String dateipfad;
    private String suchbegriff;

    public SuchfunktionTask_Parallelesuche(String dateipfad, String suchbegriff) {
        this.dateipfad = dateipfad;
        this.suchbegriff = suchbegriff;
    }

    @Override
    public Boolean call() throws Exception {
        Scanner dateiScanner = new Scanner(new File(dateipfad));
        while (dateiScanner.hasNextLine()) {
            if (dateiScanner.nextLine().toLowerCase().contains(suchbegriff.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}

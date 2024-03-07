package org.example;
import org.example.Suchfunktion;
import java.io.FileNotFoundException;

public class SuchfunktionTask implements Runnable {
    private Suchfunktion suchfunktion;
    private String suchbegriff;

    // Конструктор принимает путь к файлу и поисковый запрос
    public SuchfunktionTask(String dateipfad, String suchbegriff) {
        this.suchfunktion = new Suchfunktion(dateipfad);
        this.suchbegriff = suchbegriff;
    }

    // В методе run() вызываем метод sucheNachBegriff класса Suchfunktion
    @Override
    public void run() {
        try {
            boolean gefunden = suchfunktion.sucheNachBegriff(suchbegriff);
            if (gefunden) {
                System.out.println("Der Suchbegriff '" + suchbegriff + "' wurde gefunden.");
            } else {
                System.out.println("Der Suchbegriff '" + suchbegriff + "' wurde nicht gefunden.");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Datei wurde nicht gefunden: " + e.getMessage());
        }
    }
}

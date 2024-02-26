package org.example;

public class Suchfunktion {
    private String text;
    private String suchbegriff;

    public Suchfunktion (String text, String suchbegriff) {
        this.text = text;
        this.suchbegriff = suchbegriff;
    }

    public void suche() {
        if(text.contains(suchbegriff)) {
            System.out.println("Der Suchbegriff '" + suchbegriff + "' wurde im Text gefunden.");
        } else {
            System.out.println("Der Suchbegriff '" + suchbegriff + "' wurde im Text nicht gefunden.");
        }
    }
}

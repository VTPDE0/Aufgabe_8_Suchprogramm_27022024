package org.example;
import java.util.Scanner;


public class Benutzereingabe {
    private String suchbegriff;
    public void leseEingabe () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie einen Suchbegriff ein:");
        suchbegriff = scanner.nextLine();
    }
    public String getSuchbegriff(){
        return suchbegriff;
    }
}

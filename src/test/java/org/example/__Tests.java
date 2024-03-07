package org.example;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.*;

import org.mockito.Mockito;
import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;

class SuchfunktionTest {


    /*
    Test ist durch wenn: Der Suchbegriff ist im Dokument vorhanden und der Test true zurückgibt.
    Negativer Testfall: Der Suchbegriff ist nicht im Dokument vorhanden und der Test false zurückgibt.
    */
    @Test
    public void testSucheNachBegriff_Positive() throws FileNotFoundException {
        Suchfunktion suche = new Suchfunktion("BeispieltextInDatei.txt");
        //'Ziel' existiert
        boolean ergebnis = suche.sucheNachBegriff("Ziel");
        Assertions.assertTrue(ergebnis);
    }
    @Test
    public void testSucheNachBegriff_Negative() throws FileNotFoundException {
        Suchfunktion suche = new Suchfunktion("BeispieltextInDatei.txt");
        boolean ergebnis = suche.sucheNachBegriff("So ein Text existiert nicht in Datei");
        Assertions.assertFalse(ergebnis);
    }
    @Test
    public void testSucheNachBegriff_DateiNichtVorhanden() {
        FileNotFoundException thrown = assertThrows(FileNotFoundException.class, () -> {
            new Suchfunktion("nicht_existierender_pfad.txt").sucheNachBegriff("Java");
        });
    }

}
class BuchstabenWahrscheinlichkeitTest {

    @Test
    void testFrequencyAnalysisAccuracy() throws FileNotFoundException {
        // Angenommen, Datei hat 13 Buchstaben Z.
        BuchstabenWahrscheinlichkeit buchstabenWahrscheinlichkeit = new BuchstabenWahrscheinlichkeit("BeispieltextinDatei.txt");
        HashMap<Character, Integer> buchstabenHaeufigkeit = buchstabenWahrscheinlichkeit.zaehleBuchstabenHaeufigkeit();

        int erwarteteAnzahlVonZs = 13; // Ich habe genau 13 Buchstaben 'Z' in DAtei manuell gelassen, andere habe gelöscht.
        Assertions.assertTrue(buchstabenHaeufigkeit.containsKey('z'), "Das Dokument enthält keinen Buchstaben 'z'.");
        Assertions.assertEquals(erwarteteAnzahlVonZs, buchstabenHaeufigkeit.get('z').intValue(), "Die Häufigkeit des Buchstabens 'z' stimmt nicht mit der erwarteten Anzahl überein.");
    }
}
class BenutzereingabeTest {

    @Test
    void testLeseSuchbegriff() {
        Scanner mockScanner = Mockito.mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("Ziel");

        Benutzereingabe benutzereingabe = new Benutzereingabe(mockScanner);
        String suchbegriff = benutzereingabe.leseSuchbegriff();

        assertEquals("Ziel", suchbegriff);
    }
}
    class SucheMitRegexTest {

        @Test
        public void testRegexSearchFunctionality_Positive() throws FileNotFoundException {
            // Annahme: 'BeispieltextInDatei.txt' enthält "Katze"
            SucheMitRegex sucheMitRegex = new SucheMitRegex("BeispieltextInDatei.txt");
            boolean ergebnis = sucheMitRegex.sucheMitRegex("\\bKatze\\b");
            Assertions.assertTrue(ergebnis);
        }

        @Test
        public void testRegexSearchFunctionality_Negative() throws FileNotFoundException {
            // Annahme: 'BeispieltextInDatei.txt' enthält das Wort "Katze" nicht
            SucheMitRegex sucheMitRegex = new SucheMitRegex("BeispieltextInDatei.txt");
            boolean ergebnis = sucheMitRegex.sucheMitRegex("\\bHund\\b");
            Assertions.assertFalse(ergebnis);
        }

    }
class ParalleleSucheTest {

    @Test
    void testParallelSearchResults() {
        ParalleleSucheInDateien paralleleSuche = new ParalleleSucheInDateien();
        List<String> dateiPfade = Arrays.asList("BeispieltextInDatei_3.txt", "BeispieltextInDatei_2.txt", "BeispieltextInDatei.txt");
        String suchbegriff = "qwertz";
        Map<String, Boolean> ergebnisse = paralleleSuche.paralleleSucheInDateien(dateiPfade, suchbegriff);

        for (String pfad : dateiPfade) {
            assertTrue(ergebnisse.get(pfad), "Suchbegriff wurde nicht in " + pfad + " gefunden.");
        }
    }
}


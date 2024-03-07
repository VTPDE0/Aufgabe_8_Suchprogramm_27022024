package org.example;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.*;

import org.mockito.Mockito;
import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertTrue;

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
class ParallelSucheTestIstGefunden {

    @Before
    public void setUp() throws FileNotFoundException {
    }

    @Test
    public void testParallelSearch() throws InterruptedException, ExecutionException {
        //qwertz in 2 Dateien drin ist
        String[] dateipfade = {"BeispieltextInDatei.txt", "BeispieltextInDatei_2.txt", "BeispieltextInDatei_3.txt"};
        String suchbegriff = "qwertz";
        ExecutorService executor = Executors.newFixedThreadPool(dateipfade.length);
        List<Future<Boolean>> futures = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (String dateipfad : dateipfade) {
            SuchfunktionTask task = new SuchfunktionTask(dateipfad, suchbegriff);
            futures.add(executor.submit(task));
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        boolean atLeastOneFound = futures.stream().anyMatch(future -> {
            try {
                return future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return false;
            }
        });

        long endTime = System.currentTimeMillis();
        assertTrue("Mindestens eine Datei soll Suchbegriff enthalten", atLeastOneFound);
        assertTrue("Suche muss schnellgenug erledigt sein", (endTime - startTime) < 2000);
    }
}
class ParallelSucheTestIst404 {

    @Before
    public void setUp() throws FileNotFoundException {
        // Подготовка тестов не требуется
    }

    @Test
    public void testParallelSearch() throws InterruptedException, ExecutionException {
        String[] dateipfade = {"BeispieltextInDatei.txt", "BeispieltextInDatei_2.txt", "BeispieltextInDatei_3.txt"};
        // qwertzqwrsgh enthält keine Datei
        String suchbegriff = "qwertzqwrsgh";
        ExecutorService executor = Executors.newFixedThreadPool(dateipfade.length);
        List<Future<Boolean>> futures = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (String dateipfad : dateipfade) {
            SuchfunktionTask task = new SuchfunktionTask(dateipfad, suchbegriff);
            futures.add(executor.submit(task));
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);

        boolean noneFound = futures.stream().allMatch(future -> {
            try {
                return !future.get(); // Проверка что future.get() возвращает false
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return true; // В случае ошибки считаем что условие теста не выполнено
            }
        });

        long endTime = System.currentTimeMillis();

        assertTrue("Mindestens eine Datei enthält Suchbegriff", noneFound);
        assertTrue("Suche war nicht scnhellgenug", (endTime - startTime) < 2000);
    }
}
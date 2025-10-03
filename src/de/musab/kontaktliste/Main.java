package de.musab.kontaktliste;

import javax.swing.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Kontaktliste kontaktliste = laden();

        boolean ergebnis = true;
        while(ergebnis) {
            // Ein Dialogfenster erzeugen
            String input = nichtLeereEingabe("Bitte geben Sie einen Befehl ein: ERSTELLEN, ANZEIGEN, SUCHEN, BEENDEN");
            // Falls Benutzer Abbrechen/ drückt Programm beenden
            if (input == null) {
                speichern(kontaktliste.liste);   // Kontakte vor dem Beenden speichern
                break;
            }
            input = input.trim().toUpperCase();

            // Logik für die Befehle
            if (input.equals("ERSTELLEN")) {
                String vorname = nichtLeereEingabe("Welcher Vorname?");
                String nachname = nichtLeereEingabe("Welcher Nachname?");
                String nummer = nichtLeereEingabe("Welche Telefonnummer?");
                kontaktliste.hinzufuegen(new Kontakt(vorname, nachname, nummer));
                speichern(kontaktliste.liste);
            } else if (input.equals("ANZEIGEN")) {
                gibAus(kontaktliste.liste);
            } else if (input.equals("SUCHEN")) {
                String wort = nichtLeereEingabe("Giben Sie ein Suchwort ein");
                suchen(kontaktliste.liste, wort);
            } else if (input.equals("BEENDEN")) {
                speichern(kontaktliste.liste);
                ergebnis = false;

            }

        }

    }

    /**
     * Öffnet ein Eingabefenster und gibt die Eingabe zurück.
     * <p>
     * Hinweis: Wenn der Nutzer auf Abbrechen/❌ klickt, wird null zurückgegeben.
     *
     * @param eingabeAufforderung Text, der im Dialog angezeigt wird
     * @return die eingegebene Zeichenkette oder {@code null}, falls abgebrochen
     */
    public static String nichtLeereEingabe(String eingabeAufforderung)
    {
        String eingabe = "";
        if (eingabe.trim().equals(""))
        {
            eingabe = JOptionPane.showInputDialog(eingabeAufforderung);
        }

        return eingabe;
    }
    /**
     * Gibt alle nicht-null Kontakte sortiert auf der Konsole aus.
     *
     * @param kontakte Array von Kontakten
     */
    public static void gibAus(Kontakt[] kontakte)
    {
        Sortierung sortierung = new Sortierung();
        sortierung.sortieren(kontakte);
        System.out.println("==============================");
        for (int i = 0; i < kontakte.length; i++)
        {
            if (kontakte[i] != null)
            {
                System.out.println("Vorname: " + kontakte[i].getVorname() +
                        " Nachname: " + kontakte[i].getNachname() +
                        " Telefonnummer: " + kontakte[i].getTelefonnummer());
            }
        }
        System.out.println("==============================");
    }

    /**
     * Sucht im de.musab.kontaktliste.Kontakt-Array nach dem suchwort in Vorname, Nachname oder Telefonnummer
     * und gibt Treffer auf der Konsole aus.
     *
     * @param kontakte Array von Kontakten
     * @param suchwort Zeichenkette, nach der gesucht wird
     */
    public static void suchen(Kontakt[] kontakte, String suchwort)
    {
        Sortierung sortierung = new Sortierung();
        sortierung.sortieren(kontakte);
        System.out.println("==============================");
        for (int i = 0; i < kontakte.length; i++)
        {
            if (kontakte[i] != null)
            {
                if (kontakte[i].getVorname().contains(suchwort) ||
                kontakte[i].getNachname().contains(suchwort)||
                kontakte[i].getTelefonnummer().contains(suchwort))
                {
                    System.out.println("Vorname: " + kontakte[i].getVorname() +
                            " Nachname: " + kontakte[i].getNachname() +
                            " Telefonnummer: " + kontakte[i].getTelefonnummer());
                }
            }
        }
        System.out.println("==============================");

    }

    /**
     * Speichert alle nicht-null Kontakte in die Datei {@code kontakte.txt}.
     *
     * @param kontakte Array von Kontakten
     */
    public static void speichern(Kontakt[] kontakte)
    {

        try {

            //Datei erstellen
            File file = new File("kontakte.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            //in die Datei schreiben
            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < kontakte.length; i++) {
                if (kontakte[i] != null) {
                    writer.write("Vorname: " + kontakte[i].getVorname() +
                            " Nachname: " + kontakte[i].getNachname() +
                            " Telefonnummer: " + kontakte[i].getTelefonnummer() + "\n");
                }

            }
            writer.close();
        }
        catch(IOException e)
        {
            System.out.println("Der de.musab.kontaktliste.Kontakt konnte nicht gespeichert werden");
        }

    }

    /**
     * Lädt Kontakte aus {@code kontakte.txt} und gibt eine gefüllte de.musab.kontaktliste.Kontaktliste zurück.
     * @return die geladene de.musab.kontaktliste.Kontaktliste
     */
    public static Kontaktliste laden() {
        Kontaktliste kontaktListe = new Kontaktliste();
        try {
            File file = new File("kontakte.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileReader fileReader = new FileReader(file);
            String text = "";
            int temp = 0;
            while ((temp = fileReader.read()) != -1) {
                text += (char) temp;
            }
            fileReader.close();

            String[] zeilen = text.split("\n");
            for (int i = 0; i < zeilen.length; i++) {
                String aktuelleZeile = zeilen[i].trim();

                //  Leere Zeilen überspringen
                if (aktuelleZeile.isEmpty()) continue;

                String[] einzelnerKontakt = aktuelleZeile.split(" ");

                //  Sicherstellen, dass genug Teile vorhanden sind
                if (einzelnerKontakt.length < 6) continue;

                String vorname = einzelnerKontakt[1];
                String nachname = einzelnerKontakt[3];
                String telefon = einzelnerKontakt[5];
                kontaktListe.hinzufuegen(new Kontakt(vorname, nachname, telefon));
            }
        }
        catch(IOException e) {
            System.out.println("Die Datei konnte nicht gespeichert werden");
        }
        return kontaktListe;
    }



}
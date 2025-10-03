package de.musab.kontaktliste;

/**
 * Einfache, dynamisch wachsende Liste von de.musab.kontaktliste.Kontakt-Objekten
 * auf Basis eines Arrays.
 */

public class Kontaktliste {
  // Internes Array zur Speicherung der Kontakte
    Kontakt[] liste = new Kontakt[10];

    /**
     * Fügt einen de.musab.kontaktliste.Kontakt hinzu. Falls das interne Array voll ist,
     * wird es um 10 Elemente vergrößert.
     *
     * @param k der hinzuzufügende de.musab.kontaktliste.Kontakt
     */
    public void hinzufuegen(Kontakt k)
    {
        boolean wurdeEingefuegt = false;
        for (int i = 0; i < liste.length; i++)
        {
            //Eine leere Schublade finden
            if (liste[i] == null)
            {
                liste[i] = k;
                wurdeEingefuegt = true;
                break;
            }

        }
        // Array war voll → vergrößern
        while(!wurdeEingefuegt)
        {
            Kontakt[] neueListe = new Kontakt[liste.length + 10];
            arrayKopieren(liste, neueListe);
            neueListe[liste.length] = k;
            liste = neueListe;

        }
    }

    /**
     * Entfernt das erste Vorkommen eines Kontakts, der exakt dieselben Felder hat.
     *
     * @param k der zu entfernende de.musab.kontaktliste.Kontakt
     */
    public void elementeEntfernen(Kontakt k)
    {
        for (int i = 0; i < liste.length; i++)
        {
            if (liste[i].getVorname().equals(k.getVorname()) &&
            liste[i].getNachname().equals(k.getNachname())&&
            liste[i].getTelefonnummer().equals(k.getTelefonnummer()))
            {
                liste[i] = null;
                break;
            }
        }

    }

    /**
     * Kopiert alle nicht-null Einträge aus Array a in Array b
     * @param a Quellarray
     * @param b Zielarray (muss groß genug sein)
     */
    public void arrayKopieren(Kontakt[] a, Kontakt[] b)
    {
        int zaehlerB = 0;
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] != null)
            {
                b[zaehlerB] = a[i];
                zaehlerB++;
            }
        }
    }
}

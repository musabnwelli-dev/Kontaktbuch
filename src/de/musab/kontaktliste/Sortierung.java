package de.musab.kontaktliste;

import java.util.Arrays;

/**
 * Dienstklasse zum Sortieren eines de.musab.kontaktliste.Kontakt[] nach Vorname, dann Nachname, dann Telefonnummer.
 * null-Einträge werden ans Ende sortiert.
 */
public class Sortierung {
    /**
     * Sortiert das übergebene Array in-place.
     *
     * @param kontakte Array der zu sortierenden Kontakte
     */
    public static void sortieren(Kontakt[] kontakte) {
        Arrays.sort(kontakte, (kontakt1, kontakt2) -> {
            if (kontakt1 == null && kontakt2 == null) {
                return 0;
            } else if (kontakt1 == null) {
                return 1;
            } else if (kontakt2 == null) {
                return -1;
            } else {
                return vergleicheKontakte(kontakt1, kontakt2);
            }
        });
    }
    /**
     * Vergleich zweier Kontakte: zuerst Vorname
     * dann Nachname, dann Telefonnummer.
     *
     * @param a erster de.musab.kontaktliste.Kontakt
     * @param b zweiter de.musab.kontaktliste.Kontakt
     * @return negativer/0/positiver Wert
     */

    public static int vergleicheKontakte(Kontakt a, Kontakt b) {
        int cmp = a.getVorname().compareToIgnoreCase(b.getVorname());
        if (cmp != 0) {
            return cmp;
        }
        cmp = a.getNachname().compareToIgnoreCase(b.getNachname());
        if (cmp != 0) {
            return cmp;
        }
        return a.getTelefonnummer().compareToIgnoreCase(b.getTelefonnummer());
    }

}


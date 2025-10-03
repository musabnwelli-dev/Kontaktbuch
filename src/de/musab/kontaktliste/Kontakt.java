package de.musab.kontaktliste;

/**
 * Modellklasse für einen de.musab.kontaktliste.Kontakt mit Vorname, Nachname und Telefonnummer.
 */
public class Kontakt {
    private String vorname;
    private String nachname;
    private String telefonnummer;
    /**
     * Erzeugt einen neuen de.musab.kontaktliste.Kontakt.
     *
     * @param vorname  Vorname des Kontakts
     * @param nachname Nachname des Kontakts
     * @param telefonnummer Telefonnummer des Kontakts
     */
    public Kontakt(String vorname, String nachname, String telefonnummer)
    {
        this.vorname = vorname;
        this.nachname = nachname;
        this.telefonnummer = telefonnummer;
    }

    /**
     * gibt den Vornamen zurück
     * @return vorname
     */
    public String getVorname()
    {
        return vorname;
    }
    /**
     * gibt den Nachnamen zurück
     * @return nachname
     */
    public String getNachname()
    {
        return nachname;
    }
    /**
     * gibt die Telefonnummer zurück
     * @return telefonnummer
     */
    public String getTelefonnummer()
    {
        return telefonnummer;
    }

    /**
     * Setzt den Vornamen.
     * @param name neuer Vorname
     */
    public void setVorname(String name)
    {
        vorname = name;
    }
    /**
     * Setzt den Nachnamen.
     * @param name neuer Nachname
     */
    public void setNachname(String name)
    {
        nachname = name;
    }
    /**
     * Setzt die Telefonnummer.
     * @param nummer neue Telefonnummer
     */
    public void setTelefonnummer(String nummer)
    {
        telefonnummer = nummer;
    }
}

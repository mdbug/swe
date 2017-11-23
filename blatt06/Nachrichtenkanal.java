import java.util.HashMap;

public class Nachrichtenkanal {
    private HashMap<Kunde, Abo> abos = new HashMap<>();
    private String nachricht;
    private int nachrichten = 0;
    private int einnahmen = 0;
    private String name;

    public Nachrichtenkanal(String name) {
        this.name = name;
    }

    void abboniere(Kunde kunde, Zahlart zahlart) {
        abos.put(kunde, new Abo(kunde, zahlart));
    }

    void beendeAbo(Kunde kunde) {
        abos.remove(kunde);
    }

    public void setNachricht(String nachricht) {
        this.nachricht = nachricht;
        nachrichten++;
        for (Abo abo : abos.values())
        {
            Kunde kunde = abo.getKunde();
            Zahlart zahlart = abo.getZahlart();
            kunde.erhalteNachricht(nachricht);
            abo.erhoeheAusgelieferteNachrichten();
            einnahmen += kunde.abrechnung(zahlart, abo.getAusgelieferteNachrichten());
        }
    }

    public String getStatistik() {
        StringBuilder statistik = new StringBuilder();
        statistik.append("Nachrichten: ").append(nachrichten).append("\n");
        statistik.append("Abonnenten: ").append(abos.size()).append("\n");
        statistik.append("Einnahmen: ").append(einnahmen).append("\n");
        return statistik.toString();
    }

    public String toString() {
        return name;
    }
}

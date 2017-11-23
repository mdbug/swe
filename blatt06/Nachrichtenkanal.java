import java.util.HashSet;

public class Nachrichtenkanal {
    private HashSet<Kunde> abonnenten = new HashSet<>();
    private String nachricht;
    private int nachrichten = 0;
    private int einnahmen = 0;
    private String name;

    public Nachrichtenkanal(String name) {
        this.name = name;
    }

    void abboniere(Kunde kunde) {
        abonnenten.add(kunde);
    }

    void beendeAbo(Kunde kunde) {
        abonnenten.remove(kunde);
    }

    public void setNachricht(String nachricht) {
        this.nachricht = nachricht;
        nachrichten++;
        for (Kunde kunde : abonnenten)
        {
            kunde.erhalteNachricht(nachricht);
            einnahmen += kunde.abrechnung();
        }
    }

    public String getStatistik() {
        StringBuilder statistik = new StringBuilder();
        statistik.append("Nachrichten: ").append(nachrichten).append("\n");
        statistik.append("Abonnenten: ").append(abonnenten.size()).append("\n");
        statistik.append("Einnahmen: ").append(einnahmen).append("\n");
        return statistik.toString();
    }

    public String toString() {
        return name;
    }
}

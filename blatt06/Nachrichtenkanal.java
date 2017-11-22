import java.util.HashSet;

public class Nachrichtenkanal {
    private HashSet<Kunde> abonnenten = new HashSet<>();
    private String nachricht;

    void abboniere(Kunde kunde) {
        abonnenten.add(kunde);
    }

    void beendeAbo(Kunde kunde) {
        abonnenten.remove(kunde);
    }

    public void setNachricht(String nachricht) {
        this.nachricht = nachricht;
        for (Kunde kunde : abonnenten)
        {
            kunde.erhalteNachricht(nachricht);
        }
    }
}

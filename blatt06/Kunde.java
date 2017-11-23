import java.util.ArrayList;

public class Kunde {
    private ArrayList<String> nachrichten = new ArrayList<>();
    private Zahlart zahlart = null;
    private String name;

    public Kunde(String name) {
       this.name = name;
    }

    public void erhalteNachricht(String nachricht) {
        if (zahlart != null) {
            nachrichten.add(nachricht);
        }
    }

    public int abrechnung() {
        if (zahlart == null) {
            return 0;
        }

        return zahlart.getBetrag(nachrichten.size());
    }

    void setZahlart(Zahlart zahlart) {
        this.zahlart = zahlart;
    }

    public String toString() {
        return name;
    }
}

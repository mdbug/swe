import java.util.ArrayList;

public class Kunde {
    private ArrayList<String> nachrichten = new ArrayList<>();
    private String name;

    public Kunde(String name) {
       this.name = name;
    }

    public void erhalteNachricht(String nachricht) {
        nachrichten.add(nachricht);
    }

    public int abrechnung(Zahlart zahlart, int n) {
        return zahlart.getBetrag(n);
    }

    public String toString() {
        return name;
    }
}

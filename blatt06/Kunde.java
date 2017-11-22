public class Kunde {
    private String letzeNachricht;
    private Zahlart zahlart;

    public void erhalteNachricht(String nachricht) {
        letzeNachricht = nachricht;
    }

    void setZahlart(Zahlart zahlart) {
        this.zahlart = zahlart;
    }
}

public class Abo {
    private Kunde kunde;
    private Zahlart zahlart;
    private int ausgelieferteNachrichten;

    public Abo(Kunde kunde, Zahlart zahlart) {
        this.kunde = kunde;
        this.zahlart = zahlart;
        this.ausgelieferteNachrichten = 0;
    }

    public int getAusgelieferteNachrichten() {
        return ausgelieferteNachrichten;
    }

    public void setAusgelieferteNachrichten(int ausgelieferteNachrichten) {
        this.ausgelieferteNachrichten = ausgelieferteNachrichten;
    }

    public void erhoeheAusgelieferteNachrichten() {
        this.ausgelieferteNachrichten++;
    }

    public Zahlart getZahlart() {
        return zahlart;
    }

    public void setZahlart(Zahlart zahlart) {
        this.zahlart = zahlart;
    }

    public Kunde getKunde() {
        return kunde;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }
}

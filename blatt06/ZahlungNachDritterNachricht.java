public class ZahlungNachDritterNachricht implements Zahlart {
    private final int BETRAG = 1000;

    @Override
    public int getBetrag(int nachricht) {
        return nachricht % 3 == 0 ? BETRAG : 0;
    }
}

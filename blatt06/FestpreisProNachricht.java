public class FestpreisProNachricht implements Zahlart {
    private final int BETRAG = 300;

    @Override
    public int getBetrag(int nachricht) {
        return BETRAG;
    }
}

public class Neutral extends PolitischAktiv {
    private static Neutral INSTANCE = new Neutral();

    private Neutral() {}
    public static Neutral getInstance() {
        return Neutral.INSTANCE;
    }

    @Override
    public void wirtschaftslob(Politiker politiker) {
        politiker.addState(Rehabilitiert.getInstance());
    }
}

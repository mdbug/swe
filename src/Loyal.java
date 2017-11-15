public class Loyal extends PolitischAktiv {
    private static Loyal INSTANCE = new Loyal();

    private Loyal() {}

    public static Loyal getInstance() {
        return Loyal.INSTANCE;
    }

    @Override
    public void parteitadel(Politiker politiker)
    {
        politiker.addState(Rebellisch.getInstance());
        politiker.removeState(this);
    }

    @Override
    public void parteilob(Politiker politiker)
    {
        politiker.addState(Kriechend.getInstance());
        politiker.removeState(this);
    }
}

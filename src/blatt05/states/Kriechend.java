package blatt05.states;

import blatt05.Politiker;

public class Kriechend extends PolitischAktiv {
    private static Kriechend INSTANCE = new Kriechend();

    private Kriechend() {}
    public static Kriechend getInstance() {
        return Kriechend.INSTANCE;
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
        politiker.wirtschaftskritik();
    }
}

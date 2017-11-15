package blatt05.states;

import blatt05.Politiker;

public class Rebellisch extends PolitischAktiv {
    private static Rebellisch INSTANCE = new Rebellisch();

    private Rebellisch() {}
    public static Rebellisch getInstance() {
        return Rebellisch.INSTANCE;
    }

    @Override
    public void parteilob(Politiker politiker)
    {
        politiker.addState(Loyal.getInstance());
        politiker.removeState(this);
    }
}

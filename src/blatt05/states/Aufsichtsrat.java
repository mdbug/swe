package blatt05.states;

import blatt05.Politiker;

public class Aufsichtsrat extends AbstractState {
    private static Aufsichtsrat INSTANCE = new Aufsichtsrat();

    private Aufsichtsrat() {}
    public static State getInstance() {
        return Aufsichtsrat.INSTANCE;
    }

    @Override
    public void erwischt(Politiker politiker) {
        politiker.addState(EndZustand.getInstance());
        politiker.removeState(this);
    }
}

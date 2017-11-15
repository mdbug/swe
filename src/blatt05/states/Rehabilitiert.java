package blatt05.states;

import blatt05.Politiker;

public class Rehabilitiert extends Protegiert {
    private static Rehabilitiert INSTANCE = new Rehabilitiert();

    private Rehabilitiert() {}
    public static Rehabilitiert getInstance() {
        return Rehabilitiert.INSTANCE;
    }

    @Override
    public void wirtschaftslob(Politiker politiker) {
        politiker.addState(Ergeben.getInstance());
        politiker.removeState(this);
    }
}

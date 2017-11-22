public class Ergeben extends Protegiert {
    private static Ergeben INSTANCE = new Ergeben();

    private Ergeben() {}

    public static State getInstance() {
        return Ergeben.INSTANCE;
    }

    @Override
    public void wirtschaftslob(Politiker politiker) {
        politiker.addState(Hoerig.getInstance());
        politiker.removeState(this);
    }
}

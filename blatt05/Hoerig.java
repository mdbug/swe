public class Hoerig extends Protegiert {
    private static Hoerig INSTANCE = new Hoerig();

    private Hoerig() {}
    public static Hoerig getInstance() {
        return Hoerig.INSTANCE;
    }

    @Override
    public void wirtschaftslob(Politiker politiker)
    {
        politiker.addState(Aufsichtsrat.getInstance());
        politiker.removeState(this);
    }
}

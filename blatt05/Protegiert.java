public abstract class Protegiert extends PolitischAktiv {
    @Override
    public void wirtschaftskritik(Politiker politiker) {
        politiker.addState(Neutral.getInstance());
        politiker.removeState(this);
    }
}

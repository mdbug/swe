public abstract class PolitischAktiv extends AbstractState {
    public void erwischt(final Politiker politiker) {
        politiker.removeAllStates();
        politiker.addState(EndZustand.getInstance());
    }
}

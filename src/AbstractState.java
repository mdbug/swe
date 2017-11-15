abstract class AbstractState implements State {
    public void parteilob(final Politiker politiker) {}
    public void parteitadel(final Politiker politiker) {}
    public void wirtschaftslob(final Politiker politiker) {}
    public void wirtschaftskritik(final Politiker politiker) {}
    public void erwischt(final Politiker politiker) {}

    public String toString() {
        return getClass().getSimpleName();
    }
}

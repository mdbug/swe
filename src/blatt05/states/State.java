package blatt05.states;

import blatt05.Politiker;

public interface State {
    void parteilob(final Politiker politiker);
    void parteitadel(final Politiker politiker);
    void wirtschaftslob(final Politiker politiker);
    void wirtschaftskritik(final Politiker politiker);
    void erwischt(final Politiker politiker);
    String toString();
}

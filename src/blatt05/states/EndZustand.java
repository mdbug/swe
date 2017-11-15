package blatt05.states;

import blatt05.states.AbstractState;

public class EndZustand extends AbstractState {
    private static EndZustand INSTANCE = new EndZustand();

    private EndZustand() {}
    public static State getInstance() {
        return INSTANCE;
    }
}

public class EndZustand extends AbstractState {
    private static EndZustand INSTANCE = new EndZustand();

    private EndZustand() {}
    public static State getInstance() {
        return INSTANCE;
    }
}

import java.util.HashSet;

public class Politiker {

    private HashSet<State> states = new HashSet<>();
    private String name;

    public Politiker(String name) {
        this.name = name;
        states.add(Loyal.getInstance());
        states.add(Ergeben.getInstance());
    }

    public boolean aktiv() {
        return !states.contains(EndZustand.getInstance());
    }

    public void parteilob() {
        HashSet<State> currentStates = new HashSet<>(states);
        for(State state : currentStates)
        {
            state.parteilob(this);
        }
    }

    public void parteitadel() {
        HashSet<State> currentStates = new HashSet<>(states);
        for(State state : currentStates)
        {
            state.parteitadel(this);
        }
    }

    public void wirtschaftslob() {
        HashSet<State> currentStates = new HashSet<>(states);
        for(State state : currentStates)
        {
            state.wirtschaftslob(this);
        }
    }

    public void wirtschaftskritik() {
        HashSet<State> currentStates = new HashSet<>(states);
        for(State state : currentStates)
        {
            state.wirtschaftslob(this);
        }
    }

    public void erwischt() {
        HashSet<State> currentStates = new HashSet<>(states);
        for(State state : currentStates)
        {
            state.erwischt(this);
        }
    }

    public void addState(State state) {
        states.add(state);
    }

    public void removeState(State state) {
        states.remove(state);
    }

    public void removeAllStates() {
        states.clear();
    }

    public HashSet<State> getStates() {
        return states;
    }

    public String getName() {
        return name;
    }
}

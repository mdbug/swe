import java.util.HashMap;

public class Partei {
    private String name;
    private HashMap<String, Politiker> mitglieder = new HashMap<>();

    public Partei(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

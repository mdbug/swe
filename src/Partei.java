import java.util.ArrayList;

public class Partei {
    private String name;
    private ArrayList<Politiker> mitglieder = new ArrayList<>();

    public Partei(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPolitiker(Politiker politiker) {
        mitglieder.add(politiker);
    }

    public String politikerUebersicht() {
        if (mitglieder.isEmpty()) {
            return "Die Partei hat keine Mitglieder";
        }
        StringBuilder sb = new StringBuilder();
        for (Politiker politiker : mitglieder) {
            sb.append(politiker.getName());
            sb.append(" befindet sich in (Teil)-Zustaenden:\n");
            sb.append(politiker.getStates());
            sb.append("\n--------------------\n");
        }
        return sb.toString();
    }

    public ArrayList<Politiker> getPolitiker() {
        return new ArrayList<>(mitglieder);
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class Parteidialog {
    private Partei partei = new Partei("Die Partei");

    public Parteidialog() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Was wollen Sie?\n"
                    + " (0) Programm beenden\n"
                    + " (1) neuen Politiker hinzufuegen\n"
                    + " (2) Politiker steuern\n"
                    + " (3) Politikeruebersicht");

            int eingabe = scanner.nextInt();

            switch (eingabe) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.print("Name: ");
                    String name = scanner.next();
                    partei.addPolitiker(new Politiker(name));
                    break;
                case 2:
                    ArrayList<Politiker> politiker = partei.getPolitiker();
                    if (politiker.isEmpty()) {
                        System.out.println("Keine Politiker in der Partei");
                        break;
                    }
                    System.out.println("Welcher Politiker?");
                    for(int i = 0; i < politiker.size(); ++i) {
                        System.out.println("(" + i + ") " + politiker.get(i).getName());
                    }
                    int auswahl = scanner.nextInt();
                    while(auswahl < 0 || auswahl >= politiker.size()) {
                        System.out.println("Ungueltige Auswahl");
                        auswahl = scanner.nextInt();
                    }

                    Politiker ausgewaehlterPolitiker = politiker.get(auswahl);
                    new Steuerung(ausgewaehlterPolitiker);
                    break;
                case 3:
                    System.out.println(partei.politikerUebersicht());
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new Parteidialog();
    }
}

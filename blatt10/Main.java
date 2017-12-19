import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private Model model = new Model();
    private ArrayList<Controller> controllers = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.eingabeDialog();
    }

    private void eingabeDialog() {
        int eingabe = -1;
        Scanner scanner = new Scanner(System.in);
        while(eingabe != 0) {
            System.out.println("Was wollen Sie?");
            System.out.println("(0) Programm beenden");
            System.out.println("(1) Neuen View erstellen");
            System.out.println("(2) Neuen Controller erstellen");
            System.out.println("(3) Controller zum Ändern auswählen");
            eingabe = scanner.nextInt();

            switch(eingabe) {
                case 1:
                    createView();
                    break;
                case 2:
                    createController();
                    break;
                case 3:
                    selectController();
                    break;
            }
        }
    }

    private void createView() {
        System.out.print("Welches Ausgabezeichen? ");
        String eingabe = (new Scanner(System.in)).nextLine();
        char z = eingabe.charAt(0);
        model.addView(new ZeichenView(z));
    }

    private void createController() {
        System.out.print("Welche Eingabeaufforderung? ");
        String eingabeaufforderung = (new Scanner(System.in)).nextLine();
        controllers.add(new Controller(eingabeaufforderung, model));
    }

    private void selectController() {
        int n = controllers.size();
        int auswahl = -1;
        while (auswahl < 1 || auswahl > n) {
            System.out.print("Welcher der Controller (1 - " + n + ")?");
            auswahl = (new Scanner(System.in)).nextInt();
        }
        Controller controller = controllers.get(auswahl - 1);
        controller.input();
    }
}

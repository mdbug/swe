import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    private String eingabeaufforderung;
    private Model model;

    public Controller(String eingabeaufforderung, Model model) {
        this.eingabeaufforderung = eingabeaufforderung;
        this.model = model;
    }

    public void input() {
        System.out.print(eingabeaufforderung + " ");
        int w = (new Scanner(System.in)).nextInt();
        model.changeWert(w);
    }
}

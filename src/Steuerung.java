import java.util.Scanner;

public class Steuerung {
    private Politiker polli;

    public Steuerung(Politiker politiker) {
        polli = politiker;
        int eingabe = -1;
        System.out.println("Welches naechste Ereignis fuer " + polli.getName() + "?");
        System.out.println(" (0) Lob von der eigenen Partei");
        System.out.println(" (1) Tadel von der eigenen Partei");
        System.out.println(" (2) Lob von der Wirtschaft");
        System.out.println(" (3) Kritik von der Wirtschaft");
        System.out.println(" (4) Erwischt");
        eingabe = new Scanner(System.in).nextInt();
        switch (eingabe) {
            case 0:
                polli.parteilob();
                break;
            case 1:
                polli.parteitadel();
                break;
            case 2:
                polli.wirtschaftslob();
                break;
            case 3:
                polli.wirtschaftskritik();
                break;
            case 4:
                polli.erwischt();
                break;
        }
        System.out.println(polli.getName() + " befindet sich in (Teil)-Zustaenden:");
        System.out.println(polli.getStates());
        System.out.println("--------------------");
    }
}

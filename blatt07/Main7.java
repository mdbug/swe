import java.util.Scanner;

public class Main7 {

	/* Dieses Programm erlaubt den interaktiven Test eines
	 * Kundenbewertungsobjekts
	 */
	public static void main(String[] args) {
		Kundenbewertung k= new Kundenbewertung();
		int eingabe=-1;
		while (eingabe!=0){
			System.out.println("nächste Aktivität:\n"
					+"  (0) Programm beenden\n"
					+"  (1) letzte Rechnung pünklich\n"
					+"  (2) letzte Rechnung unpünktlich\n"
					+"  (3) letzte Rechnung nicht gezahlt\n"
					+"  (4) Kundenstatus anzeigen\n"
					+"  (5) Kundenkreditrahmen anzeigen");
			eingabe=new Scanner(System.in).nextInt();
			switch(eingabe){
			case 1:
				k.korrektGezahlt();
				break;
			case 2:
				k.verspaetetGezahlt();
				break;
			case 3:
				k.nichtGezahlt();
				break;
			case 4:
				System.out.println("Kunde "+k.auskunft()+".\n");
				break;
			case 5:
				System.out.println("maximaler Kredit: "+k.kredit()+".\n");
			}
		}
	}
}

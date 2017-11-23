import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	/* Diese Klasse ist an diversen TODO-Stellen unvollstndig
	 * und muss ergaenzt werden.
	 */
	
	private List<Kunde> kunden = new ArrayList<Kunde>();
	private List<Nachrichtenkanal> kanaele= 
				new ArrayList<Nachrichtenkanal>();
	
	public void dialog(){
		int eingabe=-1;
		while(eingabe !=0){
			System.out.println("Was wollen Sie?\n"
					+" (0) Programm beenden\n"
					+" (1) neuen Kunden erstellen\n"
					+" (2) neuen Nachrichtenkanal erstellen\n"
					+" (3) Kunde abonniert Nachrichtenkanal\n"
					+" (4) Nachrichtenkanalstatistik\n"
					+" (5) Nachricht eines Nachrichtenkanals veraendern");
			eingabe=new Scanner(System.in).nextInt();
			switch(eingabe){
			case 1: 
				neuerKunde();
				break;
			case 2:
				neuerNachrichtenkanal();
				break;
			case 3:
				neuesAbonnement();
				break;
			case 4:
				nachrichtenkanalstatistik();
				break;
			case 5:
				nachrichtVeraendern();
				break;
			}
		}
	}

	private String textEingeben(String aufforderung){
		Scanner sc= new Scanner(System.in);
		System.out.print(aufforderung);
		String text=sc.nextLine();
        return text;
	}
	
	private int nummerwaehlen(int size) {
		int eingabe=-1;
		while(eingabe<1 || eingabe>size)
			eingabe=new Scanner(System.in).nextInt();
		return eingabe;
	}
	
	private Nachrichtenkanal nachrichtenkanalWaehlen() {
		int i=1;
		System.out.println("Welcher Nachrichtenkanal? ");
		for(Nachrichtenkanal n:kanaele)
			System.out.println(" ("+(i++)+") "+n);
		return kanaele.get(nummerwaehlen(kanaele.size())-1);
	}
	
	private void nachrichtVeraendern() {
        if (kanaele.isEmpty()) {
            System.out.println("Es existiert noch kein Nachrichtenkanal.");
            return;
        }
		Nachrichtenkanal nk=nachrichtenkanalWaehlen();
        String nachricht = textEingeben("Nachricht eingeben: ");
        nk.setNachricht(nachricht);
	}

	private void nachrichtenkanalstatistik() {
        if (kanaele.isEmpty()) {
            System.out.println("Es existiert noch kein Nachrichtenkanal.");
            return;
        }
        Nachrichtenkanal nk=nachrichtenkanalWaehlen();
        System.out.println(nk.getStatistik());
	}

	private void neuesAbonnement() {
        if (kanaele.isEmpty()) {
            System.out.println("Es existiert noch kein Nachrichtenkanal.");
            return;
        }
        if (kunden.isEmpty()) {
            System.out.println("Es existiert noch kein Kunde.");
            return;
        }
		int i=1;
		System.out.println("Welcher Kunde? ");
		for(Kunde k:kunden)
			System.out.println(" ("+(i++)+") "+k);
		Kunde kunde=kunden.get(nummerwaehlen(kunden.size())-1);
		Nachrichtenkanal nk=nachrichtenkanalWaehlen();
        nk.abboniere(kunde);
	}

	private void neuerNachrichtenkanal() {
        String name = textEingeben("Name: ");
		kanaele.add(new Nachrichtenkanal(name));
	}

	private void neuerKunde() {
		String name = textEingeben("Name: ");
        System.out.println("Zahlart wählen: ");
        System.out.println(" (1) Festbetrag pro Nachricht");
        System.out.println(" (2) Abbrechnung nach der dritten Nachricht");
        int art = nummerwaehlen(2);
        Zahlart zahlart;
        switch(art) {
            case 1:
                zahlart = new FestpreisProNachricht();
                break;
            case 2:
                zahlart = new ZahlungNachDritterNachricht();
                break;
            default:
                zahlart = new FestpreisProNachricht();
                break;
        }
        Kunde kunde = new Kunde(name);
        kunde.setZahlart(zahlart);
        kunden.add(kunde);
	}

	public static void main(String[] args) {
		new Main().dialog();
	}

}

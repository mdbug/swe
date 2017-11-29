public class Kundenbewertung {
	private Zustand zustand;
	
	public Kundenbewertung(){
		zustand= new ZustandBeobachtung(this);
	}
	
	public void setZustand(Zustand z) {
		zustand = z;
	}
	
	public void korrektGezahlt(){
		zustand.puenktlich();
	}
	
	public void verspaetetGezahlt(){
		zustand.unpuenktlich();
	}
	
	public void nichtGezahlt(){
		zustand.nichtBezahlt();
}

	public void einzugErfolgreich() {
		zustand.einzugErfolgreich();
	}
	
	public int kredit(){
		return zustand.kredit();
	}
	
	public String auskunft(){
		return zustand.auskunft();
	}
	
}

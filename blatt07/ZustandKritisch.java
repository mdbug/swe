public class ZustandKritisch implements Zustand {


	private Kundenbewertung kb;

	public ZustandKritisch(Kundenbewertung k) {
		kb = k;
	}
	
	public String auskunft() {
		return "zeigt Verhaltensdefizite";
	}

	public int kredit() {
		return 100;
	}
	
	@Override
	public void puenktlich() {
		kb.setZustand(new ZustandBeobachtung(kb));
	}

	@Override
	public void unpuenktlich() {
		kb.setZustand(new ZustandVorkasse(kb));
	}

	@Override
	public void nichtBezahlt() {
		kb.setZustand(new ZustandVorkasse(kb));
	} 

}

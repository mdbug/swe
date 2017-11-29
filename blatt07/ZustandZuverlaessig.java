public class ZustandZuverlaessig implements Zustand {

	private Kundenbewertung kb;

	public ZustandZuverlaessig(Kundenbewertung k) {
		kb = k;
	}
	
	public String auskunft() {
		return "ist zuverlässig";
	}

	public int kredit() {
		return 500;
	}

	@Override
	public void puenktlich() {
	}

	@Override
	public void unpuenktlich() {
		kb.setZustand(new ZustandBeobachtung(kb));
	}

	@Override
	public void nichtBezahlt() {
		kb.setZustand(new ZustandVorkasse(kb));
	}

	@Override
	public void einzugErfolgreich() {
	}

}

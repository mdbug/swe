public class ZustandVorkasse implements Zustand {

	private Kundenbewertung kb;

	public ZustandVorkasse(Kundenbewertung k) {
		kb = k;
	}
	
	public String auskunft() {
		return "ist kreditunwürdig";
	}

	public int kredit() {
		return 0;
	}

	@Override
	public void puenktlich() {
	}

	@Override
	public void unpuenktlich() {
	}

	@Override
	public void nichtBezahlt() {
	}

	@Override
	public void einzugErfolgreich() {
		kb.setZustand(new ZustandKritisch(kb));
	}
}

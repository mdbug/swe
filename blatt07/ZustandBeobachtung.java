public class ZustandBeobachtung implements Zustand {
	
	private Kundenbewertung kb;
	private int anzahl=0;
	
	
	public ZustandBeobachtung(Kundenbewertung k) {
		kb = k;
	}
	
	public String auskunft() {
		return "wird noch bewertet";
	}

	public int kredit() {
		return 200;
	}

	@Override
	public void puenktlich() {
		anzahl++;
		if(anzahl>2){
			kb.setZustand(new ZustandZuverlaessig(kb));
		}		
	}

	@Override
	public void unpuenktlich() {
		kb.setZustand(new ZustandKritisch(kb));		
	}

	@Override
	public void nichtBezahlt() {
		kb.setZustand(new ZustandVorkasse(kb));		
	}

}

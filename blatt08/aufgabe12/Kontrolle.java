package aufgabe12;

public class Kontrolle {

	public boolean zugriffErlaubt(Einfach e, Daten d, int menge)
			throws IllegaleAnfrage {
		throw new IllegaleAnfrage();
	}

	public boolean zugriffErlaubt(Gehoben n, Frei d, int menge)
			throws IllegaleAnfrage {
		if (menge > 100) throw new IllegaleAnfrage();
		return menge < 60;
	}

	public boolean zugriffErlaubt(Gehoben n, Vertraulich d, int menge)
			throws IllegaleAnfrage {
		if (menge > 100) throw new IllegaleAnfrage();
		return menge < 40;
	}

	public boolean zugriffErlaubt(Gehoben n, Geheim d , int menge)
			throws IllegaleAnfrage {
		if (menge > 100)
			throw new IllegaleAnfrage();
		return false;
	}

	public boolean zugriffErlaubt(Bevorzugt n, Frei d, int menge)
			throws IllegaleAnfrage {
		boolean ergebnis;
		if (menge >= 100)
			throw new IllegaleAnfrage();
		if (menge < 80)
			ergebnis = true;
		else
			ergebnis = false;
		return ergebnis;
	}

	public boolean zugriffErlaubt(Bevorzugt n, Vertraulich d, int menge)
			throws IllegaleAnfrage {
		boolean ergebnis;
		if (menge > 100)
			throw new IllegaleAnfrage();
		if (menge < 80)
			ergebnis = true;
		else
			ergebnis = false;
		return ergebnis;
	}

	public boolean zugriffErlaubt(Bevorzugt n, Geheim d, int menge)
			throws IllegaleAnfrage {
		boolean ergebnis;
		if (menge < 60)
			ergebnis = true;
		else
			ergebnis = false;
		return ergebnis;
	}
}

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ErweiterungTest {
    private final String AUSKUNFT_BEOBACHTUNG = new ZustandBeobachtung(null).auskunft();
    private final String AUSKUNFT_ZUVERLAESSIG = new ZustandZuverlaessig(null).auskunft();
    private final String AUSKUNFT_KRITISCH = new ZustandKritisch(null).auskunft();
    private final String AUSKUNFT_VORKASSE = new ZustandVorkasse(null).auskunft();
    private final int KREDIT_BEOBACHTUNG = 200;
    private final int KREDIT_ZUVERLAESSIG = 500;
    private final int KREDIT_KRITISCH = 100;
    private final int KREDIT_VORKASSE = 0;

    private Kundenbewertung k;

    @Before
    public void setUp() {
        k = new Kundenbewertung();
    }

    @Test
    public void einzugErfolgreich() {
        k.setZustand(new ZustandBeobachtung(k));
        k.einzugErfolgreich();
        assertEquals(k.auskunft(), AUSKUNFT_ZUVERLAESSIG);
        assertEquals(k.kredit(), KREDIT_ZUVERLAESSIG);

        k.setZustand(new ZustandKritisch(k));
        k.einzugErfolgreich();
        assertEquals(k.auskunft(), AUSKUNFT_BEOBACHTUNG);
        assertEquals(k.kredit(), KREDIT_BEOBACHTUNG);

        k.setZustand(new ZustandZuverlaessig(k));
        k.einzugErfolgreich();
        assertEquals(k.auskunft(), AUSKUNFT_ZUVERLAESSIG);
        assertEquals(k.kredit(), KREDIT_ZUVERLAESSIG);

        k.setZustand(new ZustandVorkasse(k));
        k.einzugErfolgreich();
        assertEquals(k.auskunft(), AUSKUNFT_KRITISCH);
        assertEquals(k.kredit(), KREDIT_KRITISCH);
    }
}

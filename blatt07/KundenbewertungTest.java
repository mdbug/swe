import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KundenbewertungTest {
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
    public void korrektGezahlt() {
        k.setZustand(new ZustandBeobachtung(k));
        k.korrektGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_BEOBACHTUNG);
        assertEquals(k.kredit(), KREDIT_BEOBACHTUNG);

        k.korrektGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_BEOBACHTUNG);
        assertEquals(k.kredit(), KREDIT_BEOBACHTUNG);

        k.korrektGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_ZUVERLAESSIG);
        assertEquals(k.kredit(), KREDIT_ZUVERLAESSIG);

        k.korrektGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_ZUVERLAESSIG);
        assertEquals(k.kredit(), KREDIT_ZUVERLAESSIG);

        k.setZustand(new ZustandKritisch(k));
        k.korrektGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_BEOBACHTUNG);
        assertEquals(k.kredit(), KREDIT_BEOBACHTUNG);

        k.setZustand(new ZustandVorkasse(k));
        k.korrektGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_VORKASSE);
        assertEquals(k.kredit(), KREDIT_VORKASSE);
    }

    @Test
    public void verspaetetGezahlt() {
        k.setZustand(new ZustandBeobachtung(k));
        k.verspaetetGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_KRITISCH);
        assertEquals(k.kredit(), KREDIT_KRITISCH);

        k.setZustand(new ZustandKritisch(k));
        k.verspaetetGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_VORKASSE);
        assertEquals(k.kredit(), KREDIT_VORKASSE);

        k.setZustand(new ZustandZuverlaessig(k));
        k.verspaetetGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_BEOBACHTUNG);
        assertEquals(k.kredit(), KREDIT_BEOBACHTUNG);

        k.setZustand(new ZustandVorkasse(k));
        k.verspaetetGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_VORKASSE);
        assertEquals(k.kredit(), KREDIT_VORKASSE);
    }

    @Test
    public void nichtGezahlt() {
        k.setZustand(new ZustandBeobachtung(k));
        k.nichtGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_VORKASSE);
        assertEquals(k.kredit(), KREDIT_VORKASSE);

        k.setZustand(new ZustandKritisch(k));
        k.nichtGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_VORKASSE);
        assertEquals(k.kredit(), KREDIT_VORKASSE);

        k.setZustand(new ZustandZuverlaessig(k));
        k.nichtGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_VORKASSE);
        assertEquals(k.kredit(), KREDIT_VORKASSE);

        k.setZustand(new ZustandVorkasse(k));
        k.nichtGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_VORKASSE);
        assertEquals(k.kredit(), KREDIT_VORKASSE);
    }
}
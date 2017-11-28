import static org.junit.jupiter.api.Assertions.*;

class KundenbewertungTest {
    private Kundenbewertung k;
    private final String AUSKUNFT_BEOBACHTUNG = new ZustandBeobachtung(null).auskunft();
    private final String AUSKUNFT_ZUVERLAESSIG = new ZustandZuverlaessig(null).auskunft();
    private final String AUSKUNFT_KRITISCH = new ZustandKritisch(null).auskunft();
    private final String AUSKUNFT_VORKASSE = new ZustandVorkasse(null).auskunft();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        k = new Kundenbewertung();
    }

    @org.junit.jupiter.api.Test
    void korrektGezahlt() {
        k.setZustand(new ZustandBeobachtung(k));
        k.korrektGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_BEOBACHTUNG);

        k.korrektGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_BEOBACHTUNG);

        k.korrektGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_ZUVERLAESSIG);

        for (int i = 0; i < 100; ++i) {
            k.korrektGezahlt();
            assertEquals(k.auskunft(), AUSKUNFT_ZUVERLAESSIG);
        }

        k.setZustand(new ZustandKritisch(k));
        k.korrektGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_BEOBACHTUNG);

        k.setZustand(new ZustandVorkasse(k));
        for (int i = 0; i < 100; ++i) {
            k.korrektGezahlt();
            assertEquals(k.auskunft(), AUSKUNFT_VORKASSE);
        }
    }

    @org.junit.jupiter.api.Test
    void verspaetetGezahlt() {
        k.setZustand(new ZustandBeobachtung(k));
        k.verspaetetGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_KRITISCH);

        k.setZustand(new ZustandKritisch(k));
        k.verspaetetGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_VORKASSE);

        k.setZustand(new ZustandZuverlaessig(k));
        k.verspaetetGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_BEOBACHTUNG);

        k.setZustand(new ZustandVorkasse(k));
        k.verspaetetGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_VORKASSE);
    }

    @org.junit.jupiter.api.Test
    void nichtGezahlt() {
        k.setZustand(new ZustandBeobachtung(k));
        k.nichtGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_VORKASSE);

        k.setZustand(new ZustandKritisch(k));
        k.nichtGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_VORKASSE);

        k.setZustand(new ZustandZuverlaessig(k));
        k.nichtGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_VORKASSE);

        k.setZustand(new ZustandVorkasse(k));
        k.nichtGezahlt();
        assertEquals(k.auskunft(), AUSKUNFT_VORKASSE);
    }
}
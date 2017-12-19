package aufgabe12;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KontrolleTest {
    private Kontrolle kontrolle;

    @Before
    public void setUp() {
        kontrolle = new Kontrolle();
    }

    @Test
    public void zugriffErlaubtEinfach() {
        for (int menge : new int[]{39, 40, 59, 60, 79, 80, 100, 101}) {
            for (Daten daten : new Daten[]{new Frei(), new Vertraulich(), new Geheim()}) {
                try {
                    assertFalse(kontrolle.zugriffErlaubt(new Einfach(), daten, menge));
                    fail();
                } catch (IllegaleAnfrage ignored) {
                }
            }
        }
    }

    @Test
    public void zugriffErlaubtGehobenFrei() {
        try {
            assertTrue(kontrolle.zugriffErlaubt(new Gehoben(), new Frei(), 59));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }

        try {
            assertFalse(kontrolle.zugriffErlaubt(new Gehoben(), new Frei(), 60));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }

        try {
            assertFalse(kontrolle.zugriffErlaubt(new Gehoben(), new Frei(), 100));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }

        try {
            kontrolle.zugriffErlaubt(new Gehoben(), new Frei(), 101);
            fail();
        } catch (IllegaleAnfrage ignored) {
        }
    }

    @Test
    public void zugriffErlaubtGehobenVertaulich() {
        try {
            assertTrue(kontrolle.zugriffErlaubt(new Gehoben(), new Vertraulich(), 39));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }

        try {
            assertFalse(kontrolle.zugriffErlaubt(new Gehoben(), new Vertraulich(), 40));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }

        try {
            assertFalse(kontrolle.zugriffErlaubt(new Gehoben(), new Vertraulich(), 100));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }

        try {
            kontrolle.zugriffErlaubt(new Gehoben(), new Vertraulich(), 101);
            fail();
        } catch (IllegaleAnfrage ignored) {
        }
    }

    @Test
    public void zugriffErlaubtGehobenGeheim() {
        try {
            assertFalse(kontrolle.zugriffErlaubt(new Gehoben(), new Geheim(), 100));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }

        try {
            kontrolle.zugriffErlaubt(new Gehoben(), new Geheim(), 101);
            fail();
        } catch (IllegaleAnfrage ignored) {
        }
    }

    @Test
    public void zugriffErlaubtBevorzugtFrei() {
        try {
            assertTrue(kontrolle.zugriffErlaubt(new Bevorzugt(), new Frei(), 79));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }

        try {
            assertFalse(kontrolle.zugriffErlaubt(new Bevorzugt(), new Frei(), 80));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }

        try {
            assertFalse(kontrolle.zugriffErlaubt(new Bevorzugt(), new Frei(), 100));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }

        try {
            kontrolle.zugriffErlaubt(new Bevorzugt(), new Frei(), 101);
            fail();
        } catch (IllegaleAnfrage ignored) {
        }
    }

    @Test
    public void zugriffErlaubtBevorzugtVertraulich() {
        try {
            assertTrue(kontrolle.zugriffErlaubt(new Bevorzugt(), new Vertraulich(), 79));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }

        try {
            assertFalse(kontrolle.zugriffErlaubt(new Bevorzugt(), new Vertraulich(), 80));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }

        try {
            assertFalse(kontrolle.zugriffErlaubt(new Bevorzugt(), new Vertraulich(), 100));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }

        try {
            kontrolle.zugriffErlaubt(new Bevorzugt(), new Vertraulich(), 101);
            fail();
        } catch (IllegaleAnfrage ignored) {
        }
    }

    @Test
    public void zugriffErlaubtBevorzugtGeheim() {
        try {
            assertTrue(kontrolle.zugriffErlaubt(new Bevorzugt(), new Geheim(), 59));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }

        try {
            assertFalse(kontrolle.zugriffErlaubt(new Bevorzugt(), new Geheim(), 60));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }

        try {
            assertFalse(kontrolle.zugriffErlaubt(new Bevorzugt(), new Geheim(), 100));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }

        try {
            kontrolle.zugriffErlaubt(new Bevorzugt(), new Geheim(), 101);
            fail();
        } catch (IllegaleAnfrage ignored) {
        }
    }
}
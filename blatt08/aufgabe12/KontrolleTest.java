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
    public void zugriffErlaubt1() {
        try {
            assertFalse(kontrolle.zugriffErlaubt(new Einfach(), new Frei(), 39));
            fail();
        } catch (IllegaleAnfrage illegaleAnfrage) {
        }
    }

    @Test
    public void zugriffErlaubt2() {
        try {
            assertTrue(kontrolle.zugriffErlaubt(new Gehoben(), new Frei(), 59));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }
    }

    @Test
    public void zugriffErlaubt3() {
        try {
            assertFalse(kontrolle.zugriffErlaubt(new Gehoben(), new Frei(), 60));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }
    }

    @Test
    public void zugriffErlaubt4() {
        try {
            assertTrue(kontrolle.zugriffErlaubt(new Gehoben(), new Vertraulich(), 39));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }
    }

    @Test
    public void zugriffErlaubt5() {
        try {
            assertFalse(kontrolle.zugriffErlaubt(new Gehoben(), new Vertraulich(), 40));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }
    }

    @Test
    public void zugriffErlaubt6() {
        try {
            assertTrue(kontrolle.zugriffErlaubt(new Bevorzugt(), new Frei(), 79));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }
    }

    @Test
    public void zugriffErlaubt7() {
        try {
            assertFalse(kontrolle.zugriffErlaubt(new Bevorzugt(), new Frei(), 80));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }
    }

    @Test
    public void zugriffErlaubt8() {
        try {
            assertTrue(kontrolle.zugriffErlaubt(new Bevorzugt(), new Vertraulich(), 79));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }
    }

    @Test
    public void zugriffErlaubt9() {
        try {
            assertFalse(kontrolle.zugriffErlaubt(new Bevorzugt(), new Vertraulich(), 80));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }
    }

    @Test
    public void zugriffErlaubt10() {
        try {
            assertTrue(kontrolle.zugriffErlaubt(new Bevorzugt(), new Geheim(), 59));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }
    }

    @Test
    public void zugriffErlaubt11() {
        try {
            assertFalse(kontrolle.zugriffErlaubt(new Bevorzugt(), new Geheim(), 60));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }
    }

    @Test
    public void zugriffErlaubt12() {
        try {
            assertFalse(kontrolle.zugriffErlaubt(new Bevorzugt(), new Vertraulich(), 101));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }
    }

    @Test
    public void zugriffErlaubt13() {
        try {
            assertFalse(kontrolle.zugriffErlaubt(new Gehoben(), new Geheim(), 101));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }
    }

    @Test
    public void zugriffErlaubt14() {
        try {
            assertFalse(kontrolle.zugriffErlaubt(new Gehoben(), new Geheim(), 100));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }
    }

    @Test
    public void zugriffErlaubt15() {
        try {
            assertFalse(kontrolle.zugriffErlaubt(new Bevorzugt(), new Frei(), 101));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }
    }

    @Test
    public void zugriffErlaubt16() {
        try {
            assertFalse(kontrolle.zugriffErlaubt(new Gehoben(), new Frei(), 101));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }
    }

    @Test
    public void zugriffErlaubt17() {
        try {
            assertFalse(kontrolle.zugriffErlaubt(new Gehoben(), new Vertraulich(), 101));
        } catch (IllegaleAnfrage illegaleAnfrage) {
            fail();
        }
    }
}
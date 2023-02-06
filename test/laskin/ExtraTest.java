package laskin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.laskin.Laskin;

public class ExtraTest extends AbstractParent {
    private static Laskin laskin = new Laskin();
    private final double DELTA = 0.001;

    @BeforeAll
    public static void testVirtaON() {
        System.out.println("@BeforeAll Virta ON (ennen ensimm�ist� testi�)");
        laskin.virtaON();
    }

    @AfterAll
    public static void testVirtaOFF() {
        System.out.println("@AfterAll Virta OFF (kaikki testit ajettu).");
        laskin.virtaOFF();
        laskin = null;
    }

    @BeforeEach
    public void testNollaa() {
        System.out.println("  Nollaa laskin.");
        laskin.nollaa();
        assertEquals(0, laskin.annaTulos(), "Nollaus ei onnistunut");
    }

    @Test
    public void testNelio2() {
        laskin.nelio(2);
        assertEquals(4, laskin.annaTulos(), "Luvun 2 Neli��n korotus v��rin");
    }

    @Test
    public void testNelio4() {
        laskin.nelio(4);
        assertEquals(16, laskin.annaTulos(), "Luvun 4 neli��n korotus v��rin");
    }

    @Test
    public void testNelio5() {
        laskin.nelio(5);
        assertEquals(25, laskin.annaTulos(), DELTA, "Luvun 5 neli��n korotus v��rin");
    }

    @Test
    public void testNeliojuuri2() {
        laskin.neliojuuri(2);
        assertEquals(Math.sqrt(2), laskin.annaTulos(), DELTA, "Luvun 2 neliöjuuri v��rin");
    }

    @Test
    @DisplayName("Testaa negatiivinen neli�juuri")
    public void testNeliojuuriNegat() {
        IllegalArgumentException poikkeus = assertThrows(IllegalArgumentException.class, () -> laskin.neliojuuri(-2),
                "nega neliöjuuri ei tuottanut poikkeusta");
        assertEquals("Negatiivisella luvulla ei ole neliöjuurta", poikkeus.getMessage(), "Nollalla");

    }
}

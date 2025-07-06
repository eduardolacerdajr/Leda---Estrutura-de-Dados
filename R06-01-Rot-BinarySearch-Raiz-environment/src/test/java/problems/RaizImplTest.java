package problems;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;


public class RaizImplTest {
    @Test
    public void testRaizQuadradaDe9() {
        RaizImpl r = new RaizImpl();
        double resultado = r.raiz(9, 2, 0.0001);
        assertTrue(Math.abs(resultado - 3.0) <= 0.0001);
    }

    @Test
    public void testRaizCubicaDe27() {
        RaizImpl r = new RaizImpl();
        double resultado = r.raiz(27, 3, 0.0001);
        assertTrue(Math.abs(resultado - 3.0) <= 0.0001);
    }

}
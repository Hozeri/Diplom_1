package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTests {

    @Test
    public void getNameStringNameReturnBunNameTest() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988.00f);
        String actual = bun.getName();
        String expected = "Флюоресцентная булка R2-D3";
        assertEquals(expected, actual);
    }

    @Test
    public void getPriceFloatPriceReturnBunPriceTest() {
        Bun bun = new Bun("Флюоресцентная булка R2-D3", 988.00f);
        float actual = bun.getPrice();
        float expected = 988.00f;
        assertEquals(expected, actual, 0.0f);
    }
}
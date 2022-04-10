package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    Bun bun;

    @Before
    public void setUp() throws Exception {
        bun = new Bun("Флюоресцентная булка R2-D3", 988.00f);
    }

    @Test
    public void getNameStringNameReturnBunNameTest() {
        String actual = bun.getName();
        String expected = "Флюоресцентная булка R2-D3";
        assertEquals("Имя булки не соответствует ожидаемой", expected, actual);
    }

    @Test
    public void getPriceFloatPriceReturnBunPriceTest() {
        float actual = bun.getPrice();
        float expected = 988.00f;
        assertEquals("Цена булки не соответствует ожидаемой", expected, actual, 0.0f);
    }
}
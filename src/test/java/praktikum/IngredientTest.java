package praktikum;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static praktikum.IngredientType.*;

public class IngredientTest {

    Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(FILLING,"Говяжий метеорит (отбивная)", 3000f);
    }

    @Test
    public void getPriceFloatPriceReturnsPriceOfTheIngredientTest() {
        float expectedPrice = 3000f;
        float actualPrice = ingredient.getPrice();
        assertEquals("Стоимость ингредиента не соответствует ожидаемой", expectedPrice, actualPrice, 0.0f);
    }

    @Test
    public void getNameStringNameReturnsNameOfTheIngredientTest() {
        String expectedName = "Говяжий метеорит (отбивная)";
        String actualName = ingredient.getName();
        assertEquals("Имя ингредиента не соответствует ожидаемому", expectedName, actualName);
    }

}
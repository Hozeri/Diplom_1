package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient, ingredient1, ingredient2;

    @Test
    public void addIngredientOneIngredientIngredientIsAddedTest() {
        burger.addIngredient(ingredient);
        int expectedAmountOfIngredients = 1;
        int actualAmountOfIngredients = burger.ingredients.size();
        assertEquals("Ингредиент не добавлен", expectedAmountOfIngredients, actualAmountOfIngredients);
    }

    @Test
    public void removeIngredientTwoIngredientsIngredientIsRemovedTest() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        int expectedAmountOfIngredients = 0;
        int actualAmountOfIngredients = burger.ingredients.size();
        assertEquals("Ингредиент не удалён", expectedAmountOfIngredients, actualAmountOfIngredients);
    }

    @Test
    public void moveIngredientTwoIngredientsIndexOfTheFirstIngredientMovedTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        int expectedIndexOfIngredient = 1;
        int actualIndexOfIngredient = burger.ingredients.indexOf(ingredient1);
        assertEquals("Индексы ингредиентов не изменились", expectedIndexOfIngredient, actualIndexOfIngredient);
    }

    @Test
    public void getPriceOneIngredientAndTwoBunsReturnsPriceOfTheBurgerTest() {
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedBurgerPrice = 300f;
        float actualBurgerPrice = burger.getPrice();
        assertEquals("Цена бургера не соответствует ожидаемой", expectedBurgerPrice, actualBurgerPrice, 0.0f);
    }

    @Test
    public void getReceiptOneIngredientAndTwoBunsReturnsReceiptOfTheBurgerTest() {
        Mockito.when(bun.getName()).thenReturn("Флюоресцентная булка R2-D3");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getPrice()).thenReturn(100f);
        Mockito.when(ingredient.getName()).thenReturn("Мясо бессмертных моллюсков Protostomia");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String expectedReceipt = "(==== Флюоресцентная булка R2-D3 ====)\r\n" +
                "= filling Мясо бессмертных моллюсков Protostomia =\r\n" +
                "(==== Флюоресцентная булка R2-D3 ====)\r\n" +
                "\r\nPrice: 300,000000\r\n";
        String actualReceipt = burger.getReceipt();
        assertEquals("Полученный рецепт не соответствует ожидаемому", expectedReceipt, actualReceipt);
    }

}
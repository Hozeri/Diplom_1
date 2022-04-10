package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private final IngredientType ingredientType;
    private final Ingredient ingredient;

    public IngredientParameterizedTest(IngredientType ingredientType, Ingredient ingredient) {
        this.ingredientType = ingredientType;
        this.ingredient = ingredient;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getIngredientTypeData() {
        return new Object[][]{
                {FILLING, new Ingredient(FILLING, "Говяжий метеорит (отбивная)", 3000f)},
                {SAUCE, new Ingredient(SAUCE, "Соус фирменный Space Sauce", 80f)},
        };
    }

    @Test
    public void getTypeSauceAndFillingReturnsIngredientTypeTest() {
        IngredientType actualIngredientType = ingredient.getType();
        assertEquals(ingredientType, actualIngredientType);
    }

}

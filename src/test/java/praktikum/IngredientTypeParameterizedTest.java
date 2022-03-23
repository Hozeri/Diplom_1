package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class IngredientTypeParameterizedTest {

    private final String ingredientType;

    public IngredientTypeParameterizedTest(String ingredientType) {
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientTypeData() {
        return new Object[][]{
                {"FILLING"},
                {"SAUCE"},
        };
    }

    @Test
    public void valueOfEnumValuesNotNullTest() {
        assertThat(IngredientType.valueOf(ingredientType), notNullValue());
    }
}
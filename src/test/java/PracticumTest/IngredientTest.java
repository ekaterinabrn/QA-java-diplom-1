package PracticumTest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float price;
    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "данные: {0} {1}")
    public static Object[][] getTestData() {
        return new Object[][]{
                {SAUCE, "Buffalo Sauce", 5.67f},
                {SAUCE, "Ranch", 7.77f},
                {FILLING, "Honey Mustard", 3.11f},

        };
    }
@Test
public void ingredientGetPriceTest(){}
    @Test
    public void ingredientGetNameTest(){}
    @Test
    public void ingredientGetTypeTest(){}

}

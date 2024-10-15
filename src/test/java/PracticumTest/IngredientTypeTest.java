package PracticumTest;

import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    public static final String FILLING = "FILLING";

    @Test
    public void sauceTypeTest() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void fillingTypeTest() {
        assertEquals(FILLING, IngredientType.FILLING.toString());
    }
}

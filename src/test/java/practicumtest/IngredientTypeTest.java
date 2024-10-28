package practicumtest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class IngredientTypeTest {
    public static final String FILLING = "FILLING";
    public static final String SAUCE="SAUCE";
    private final String typeName;
    public IngredientTypeTest(String typeName) {
        this.typeName = typeName;}
        @Parameterized.Parameters(name = "тип ингредиента {0}")
        public static Object[][] paramsForTest() {
            return new Object[][] {
                    {SAUCE},
                    {FILLING}
            };
        }

        @Test
        public void ingredientTypeIsCorrect() {
          assertEquals(typeName, IngredientType.valueOf(typeName).toString());
        }
}

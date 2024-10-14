package PracticumTest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private Ingredient ingredient;
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
public void ingredientGetPriceTest(){
    ingredient = new Ingredient(type, name, price);
    float actualIngredientPrice = ingredient.getPrice();
//метод assertEquals с дельтой для допустимой разницы между значениями
    assertEquals("возвращена ошибочная цена ингредиентов", price, actualIngredientPrice, 0.1f);
}
  @Test
   public void ingredientGetNameTest(){
       ingredient = new Ingredient(type, name, price);
       String actualIngredientName =ingredient.getName();
      assertEquals("возвращено ошибочное имя соуса", name, actualIngredientName);
    }
   @Test
   public void ingredientGetTypeTest(){
       ingredient = new Ingredient(type, name, price);
       assertEquals("неверный тип соуса",type, ingredient.getType());
   }

}

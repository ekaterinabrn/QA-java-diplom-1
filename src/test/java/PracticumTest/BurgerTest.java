package PracticumTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient, ingredient1,ingredient2;
@Before
    public  void createBurger() { burger=new Burger();}
@Test

public void setBunBurgerTest() {
    // Установка булочки для бургера
    burger.setBuns(bun);
    // Проверка, что булочка установлена правильно с помощью assert
assertEquals("Нужная булочка не добавлена", bun.getName(), burger.bun.getName());

}
@Test
    public void ingredientAddInBurgerTest(){
    burger.addIngredient(ingredient);
    assertEquals("число ингредиентов должно быть увеличено на один",1, burger.ingredients.size());
}
@Test
    public void removeIngredientFromBurgerTest(){
    //добавили 2 ингредиента
    burger.addIngredient(ingredient);
    burger.addIngredient(ingredient1);
    //проверили что они добавлены
    assertEquals("должно быть 2 ингридиента",2,burger.ingredients.size());
    //удалили второй
    burger.removeIngredient(1);

    assertEquals("должен остаться один ингредиент",1,burger.ingredients.size());
}
@Test
    public void moveBurgerIngredientTest(){
    burger.addIngredient(ingredient);
    burger.addIngredient(ingredient1);
    burger.addIngredient(ingredient2);
burger.moveIngredient(1,2);
//проверяем, что ingredient1 теперь находится на позиции 2.
    assertEquals(ingredient1, burger.ingredients.get(2));
    //проверяем, что ingredient2 теперь находится на позиции 1.
    assertEquals(ingredient2, burger.ingredients.get(1));
}
@Test
public void burgerGetPriceTest(){
burger.setBuns(bun);
burger.addIngredient(ingredient);
burger.addIngredient(ingredient1);
//настоим саб
    when(bun.getPrice()).thenReturn(2.5F);
    when(ingredient.getPrice()).thenReturn(1.5f);
    when(ingredient1.getPrice()).thenReturn(1.1f);
//расчитаем цену по формуле
  float ex= (2.5f*2)+1.5f+1.1f;
   float actualPrice =burger.getPrice();
   assertEquals("Стоимость должна совпадать ",ex,actualPrice,0.1);
}
@Test
    public void getBurgerReceptTest(){
    //настроим саб
    when(bun.getName()).thenReturn("classic");
    when(bun.getPrice()).thenReturn(1.5F);
    when(ingredient.getName()).thenReturn("cheese cheddar");
    when(ingredient.getPrice()).thenReturn(3.5f);
    when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
    //добавим булочку и ингредиенты соберем бургер
    burger.setBuns(bun);
    burger.addIngredient(ingredient);
   //ожидаемый результат
    float totalPrice = 1.5f + 3.5f + 1.5f;
String exp= String.format( "(==== %s ====)%n" +
                "= %s %s =%n" +
                "(==== %s ====)%n" +
                "%nPrice: %.6f%n", //  %.1f для соответствия фактическому выводу(6знаков в ожидаемом)
        "classic",
        "sauce",
        "cheese cheddar",
        "classic",
    totalPrice);
    String actualRecept =burger.getReceipt();
assertEquals(exp, actualRecept);
}

}

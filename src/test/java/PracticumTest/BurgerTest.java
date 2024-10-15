package PracticumTest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.assertEquals;

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
//
//    public void removeIngredient(int index) {
//        ingredients.remove(index);
//    }
//
//    public void moveIngredient(int index, int newIndex) {
//        ingredients.add(newIndex, ingredients.remove(index));
//    }
}

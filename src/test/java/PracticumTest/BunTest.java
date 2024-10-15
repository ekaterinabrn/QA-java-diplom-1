package PracticumTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    // Конструктор
    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "данные: {0} {1} ")
    public static Object[][] getData() {
        return new Object[][]{{"brioche bun", 3.14f}, {"ciabatta", 0.001F}, {"sesame bun", 5.67f}};
    }

    @Test
    public void getBunNameTest() {
        Bun bun = new Bun(name, price);
        String actualBunName = bun.getName();
        assertEquals("возвращено не верное название  булочки  ", name, actualBunName);
    }

    @Test
    public void getBunPriceTest() {
        Bun bun = new Bun(name, price);
        float actualBunPrice = bun.getPrice();
//метод assertEquals с дельтой для допустимой разницы между значениями
        assertEquals("возвращена ошибочная цена булочки  ", price, actualBunPrice, 0.1f);
    }

}

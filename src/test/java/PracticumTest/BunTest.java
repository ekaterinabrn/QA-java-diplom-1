package PracticumTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

//public Bun(String name, float price) {
//    this.name = name;
//    this.price = price;
//}
//
//public String getName() {
//    return name;
//}
//
//public float getPrice() {
//    return price;
//}
@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    // Конструктор
    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getData() {
        return new Object[][]{{}};}
    @Test
    public void getBunNameTest(){
        Bun bun = new Bun(name, price);
        String actualBunName = bun.getName();
        assertEquals("названия булочек должны совпадать ", name,actualBunName);
    }
    @Test
    public void getBunPriceTest() {
        Bun bun = new Bun(name, price);
        float actualBunPrice = bun.getPrice();

        assertEquals("цена на булочки должна совпадать ", price, actualBunPrice);
    }

}

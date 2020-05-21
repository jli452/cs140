package assignment07;

import org.junit.*;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Assignment07Tests {

    @Test
    public void PizzaGetCostTest() throws Exception {
        Pizza pizza = new TestPizza();
        Assert.assertEquals(0.0, pizza.getCost(), 0.00001);
    }

    @Test
    public void MediumCheesePizzaGetDescrTest() throws Exception {
        Pizza pizza = new MediumCheesePizza();
        Assert.assertEquals("Medium cheese pizza", pizza.getDescription());
    }

    @Test
    public void MediumCheesePizzaGetCostTest() throws Exception {
        Pizza pizza = new MediumCheesePizza();
        Assert.assertEquals(10.0, pizza.getCost(), 0.000001);
    }

    @Test
    public void MediumCheesePizzaCompareToTest() throws Exception {
        Pizza pizza1 = new MediumCheesePizza();
        Pizza pizza2 = new MediumCheesePizza();
        Assert.assertEquals(1, pizza1.compareTo(pizza2));
    }

    @Test
    public void SortToppingsTest() throws Exception {
        Pizza pizza = new MediumCheesePizza();
        pizza = new MyTopping2(pizza);
        pizza = new MyTopping1(pizza);

        Driver.sortToppings(pizza);

        Assert.assertEquals("Mytopping1, mytopping2 on medium cheese pizza",
                            pizza.getDescription());
    }
}

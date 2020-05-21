package assignment07;

public class MyTopping1 extends PizzaTopping {
    public MyTopping1(Pizza p) {
        super(p);
    }

    public double getCost() {
        return 1.0 + getOn().getCost();
    }
}

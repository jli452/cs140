package assignment07;

public class MyTopping2 extends PizzaTopping {
    public MyTopping2(Pizza p) {
        super(p);
    }

    public double getCost() {
        return 2.0 + getOn().getCost();
    }
}

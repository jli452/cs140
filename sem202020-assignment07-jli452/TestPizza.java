package assignment07;

public class TestPizza implements Pizza {
    public String getDescription() {
        return "TestPizza";
    }

    public int compareTo(Pizza p) {
        if(getCost() < p.getCost()) {
            return -1;
        }
        else if(getCost() > p.getCost()) {
            return 1;
        }
        else {
            return 0;
        }
    }
}

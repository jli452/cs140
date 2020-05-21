package assignment04;
public class CarTester {
	public static void main(String[] args) {
		Car car = new Car(34, 10.0);
		car.addGas(5);
		car.drive(20);
		try {
			car.addGas(12);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		try {
			car.drive(700);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}

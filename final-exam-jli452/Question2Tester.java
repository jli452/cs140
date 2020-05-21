package finalexam;

public class Question2Tester {

	public static void main(String[] args) {
		GraphComponent test = new GraphComponent(100,50);
		System.out.println("TESTING MULTIPLY");
		test.multiply(0.25);
		System.out.println(test.getPtX() + " should be about 25");
		System.out.println(test.getPtY() + " should be about 12.5");
		System.out.println("TESTING ROTATE");
		double angle = 90.0; 
		if(test.getPtX() != 0)
			angle = Math.toDegrees(Math.atan(test.getPtY()/test.getPtX()));
		System.out.println("BEFORE");
		System.out.printf("start angle %.2f degrees\n", angle);
		test.rotate(50.5);
		double newAngle = 90.0; 
		if(test.getPtX() != 0)
			newAngle = Math.toDegrees(Math.atan(test.getPtY()/test.getPtX()));
		System.out.println("AFTER ROTATE 50.5");
		System.out.printf("start angle %.2f degrees should be about %.2f\n", newAngle, (angle + 50.5));
		
		System.out.println("BEFORE");
		System.out.printf("start angle %.2f degrees\n", angle);
		test.rotate(-130.5);
		newAngle = 90.0; 
		if(test.getPtX() != 0)
			newAngle = Math.toDegrees(Math.atan(test.getPtY()/test.getPtX()));
		System.out.println("AFTER ROTATE -130.5");
		System.out.printf("start angle %.2f degrees should be about %.2f\n", newAngle, (angle - 80));
	}

}

package assignment04;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Car
{
	private final int fuelEfficiency;
	private final double tankCapacity;
	private double gasInTank;
	private double milesDriven;
	private final Logger logObj = Logger.getLogger("Car");
	private Handler handler;

	public Car(int fuelEff, double tankCap)
	{
		fuelEfficiency = fuelEff;
		tankCapacity = tankCap;

		try {
			handler = new FileHandler("Car.log");
			//SimpleFormatter produces plain text(as opposed to XML)
			handler.setFormatter(new SimpleFormatter());
			logObj.addHandler(handler);
			logObj.setLevel(Level.ALL);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	public int getFuelEfficiency()
	{
		return fuelEfficiency;
	}

	public double getTankCapacity()
	{
		return tankCapacity;
	}

	public double getGasInTank()
	{
		return gasInTank;
	}

	public int getMilesDriven()
	{
		return (int)milesDriven;
	}

	public double maxMilesLeft()
	{
		return gasInTank * fuelEfficiency;
	}

	public void drive(double miles)
	{
		var gasUsed = miles/fuelEfficiency;
		if (gasUsed > gasInTank)
		{
			milesDriven += maxMilesLeft();
			logObj.info("Drove " + maxMilesLeft() + " miles.");
			logObj.info("Used " + gasInTank + " gallons of gasoline.");
			logObj.info("Warning: ran out of gas.");
			gasInTank = 0;
			throw new IllegalArgumentException("Ran out of gas");
		}
		else
		{
			milesDriven += miles;
			gasInTank -= gasUsed;
			logObj.info("Drove " + miles + " miles.");
			logObj.info("Used " + gasUsed + " gallons of gasoline.");
		}
	}

	public void addGas(double gallons)
	{
		if (gasInTank + gallons > tankCapacity)
		{
			double spilled = (gasInTank + gallons) - tankCapacity;
			logObj.info("Added " + (tankCapacity-gasInTank) + " gallons of gasoline.");
			logObj.info("Warning: spilled " + spilled + " gallons of gasoline.");
			gasInTank = tankCapacity;
			throw new IllegalArgumentException("Spilled " + spilled + " gallons of gasoline.");
		}
		else
		{
			gasInTank += gallons;
			logObj.info("Added " + gallons + " gallons of gasoline.");
		}
	}
}

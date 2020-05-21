package finalexam;

// corresponds to the ADD of our project with flags 2
// immediate addressing
public class ADDI extends Instruction {

	// write constructor (see NOT)
	public ADDI(CPU aCpu, Memory aMemory) {
		super(aCpu, aMemory);
	}

	@Override
	public void execute(int arg) throws DataAccessException {
		// use get and set of accum in cou to add arg to the accum.
		// see how NOT changes the pc in cpu
		cpu.setAccum(arg + cpu.getAccum());
		cpu.setPc(1+cpu.getPc());
	}

	@Override
	public boolean isImmediate() {
		//TODO
		return true;
	}
}

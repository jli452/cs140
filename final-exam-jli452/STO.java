package finalexam;

// corresponds to the STO of our project with flags 0
// direct addressing
public class STO extends Instruction{

	// write constructor (see NOT)
	public STO(CPU aCpu, Memory aMemory) {
		super(aCpu, aMemory);
	}

	@Override
	public void execute(int arg) {
		// set the data in memory at index arg to the value in the accum in cpu
		// add 1 to the pc in cpu as is done in NOT
		memory.setData(arg, cpu.getAccum());
		cpu.setPc(1+cpu.getPc());
	}
}
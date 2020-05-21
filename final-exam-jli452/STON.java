package finalexam;

// corresponds to the STO of our project with flags 4
// indirect addressing
public class STON extends STO{

	// write constructor (see NOT)
	public STON(CPU aCpu, Memory aMemory) {
		super(aCpu, aMemory);
	}

	@Override
	public void execute(int arg) {
		// just use the execute of the parent STO, 
		// changing the argument to memory.getData(arg)
		// See the "IMPORTANT" at the end of Question 3.
		super.execute(memory.getData(arg));
	}

	@Override
	public boolean isIndirect() {
		// TODO
		return true;
	}
}

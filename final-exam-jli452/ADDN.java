package finalexam;

// corresponds to the ADD of our project with flags 4
// indirect addressing
public class ADDN extends ADD {

	// write constructor (see NOT)
	public ADDN(CPU aCpu, Memory aMemory) {
		super(aCpu, aMemory);
	}

	@Override
	public void execute(int arg) {
		// just use the execute of the parent ADD, 
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

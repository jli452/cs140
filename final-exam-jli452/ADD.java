package finalexam;

// corresponds to the ADD of our project with flags 0
// direct addressing
public class ADD extends ADDI{

	// write constructor (see NOT)
	public ADD(CPU aCpu, Memory aMemory) {
		super(aCpu, aMemory);
	}

	@Override
	public void execute(int arg) {
		// just use the execute of the parent ADDI 
		// and changing the argument to memory.getData(arg)
		// See the "IMPORTANT" at the end of Question 3.
		super.execute(memory.getData(arg));
	}

}
package finalexam;

abstract public class Instruction {

	protected CPU cpu;
	protected Memory memory;
	
	public Instruction(CPU aCpu, Memory aMemory) {
		this.cpu = aCpu;
		this.memory = aMemory;
	}

	public boolean isImmediate() { 
		return false; // ONLY override this method for the classes that 
					  // return true 
	} 

	public boolean isIndirect() { 
		return false; // ONLY override this method for the classes that 
					  // return true 
	} 

	public boolean requiresArgument() { 
		return true; // ONLY override this method for the classes that 
					 // return false 
	} 
	
	public void execute() {
		throw new UnsupportedOperationException("Instruction takes an argument");
	}
	
	public void execute(int arg) {
		throw new UnsupportedOperationException("Instruction does not take an argument");		
	}
} 
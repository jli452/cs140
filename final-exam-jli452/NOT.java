package finalexam;

public class NOT extends Instruction {
	
	public NOT(CPU aCpu, Memory aMemory) {
		super(aCpu, aMemory);
	}
	
	@Override
	public void execute() {
		if(cpu.getAccum() == 0) {
			cpu.setAccum(1);        	
		} else {
			cpu.setAccum(0);        	
		}
		cpu.setPc(1+cpu.getPc());
	}
	
	@Override 
	public boolean requiresArgument( ) {    
		return false;
	}
}

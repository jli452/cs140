package finalexam;

public class MachineModel{

	// An array would be simpler here but arrays do not play well with generics
	// and we would be casting Object to Instruction in many places 
	public final Instruction[] INSTRUCTIONS = new Instruction[40];

	private CPU cpu = new CPU();
	private Memory memory = new Memory();
	
	public Instruction[] getINSTRUCTIONS() {
		return INSTRUCTIONS;
	}
	public CPU getCpu() {
		return cpu;
	}
	public Memory getMemory() {
		return memory;
	}
	public MachineModel() {
		INSTRUCTIONS[1] = new NOT(cpu, memory);
		INSTRUCTIONS[7] = new STO(cpu, memory);
		INSTRUCTIONS[8] = new STON(cpu, memory);
		INSTRUCTIONS[9] = new ADDI(cpu, memory);
		INSTRUCTIONS[10] = new ADD(cpu, memory);
		INSTRUCTIONS[11] = new ADDN(cpu, memory);
	}
}

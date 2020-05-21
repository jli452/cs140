package project;

public class Test {

	public static void main(String[] args) {
		byte a = 0020;
		Instruction instr1 = new Instruction(a, 2);
		byte b = 0010;
		Instruction instr2 = new Instruction(b, 2);
		byte c = 0001;
		Instruction instr3 = new Instruction(c, 2);
		
		Instruction.checkParity(instr1);
		Instruction.checkParity(instr2);
		Instruction.checkParity(instr3);
	}
}

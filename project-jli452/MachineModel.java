package project;
import static project.Instruction.*;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;

public class MachineModel {
	private class CPU {
		private int accum;
		private int pc;
	}

	public final Map<Integer, Consumer<Instruction>> ACTION = new TreeMap<>();
	private CPU cpu = new CPU();
	private Memory memory = new Memory();
	private HaltCallback callback;

	public int getData (int index) {
		return memory.getData(index);
	}

	public void setData(int i, int j) {
		memory.setData(i, j);
	}

	int[] getData() {
		return memory.getData();
	}

	public int[] getData(int min, int max) {
		return memory.getData(min, max);
	}

	public Instruction getCode(int index) {
		return memory.getCode(index);
	}
	
	public void setCode(int i, Instruction j) {
		memory.setCode(i, j);
	}
	
	public Instruction[] getCode() {
		return memory.getCode();
	}
	
	public Instruction[] getCode(int min, int max) {
		return memory.getCode(min, max);
	}
	
	public int getProgramSize() {
		return memory.getProgramSize();
	}
	
	public int getAccum() {
		return cpu.accum;
	}
	
	public void setAccum(int pc) {
		cpu.accum = pc;
	}

	public int getPC() {
		return cpu.pc;
	}

	public void setPC(int pc) {
		cpu.pc = pc;
	}
	
	public int getChangedDataIndex() {
		return memory.getChangedDataIndex();
	}
	
	public void setProgramSize(int i) {
		memory.setProgramSize(i);
	}

	void halt() {
		callback.halt();
	}
	
	public void clear() {
		memory.clearCode();
		memory.clearData();
		cpu.accum = 0;
		cpu.pc = 0;
	}
	
	public void step() {
		try {
			Instruction instr = getCode(cpu.pc);
			Instruction.checkParity(instr);
			ACTION.get(instr.opcode/8).accept(instr);
		} catch(Exception e) {
			halt();
			throw e;
		}
	}

	public MachineModel(HaltCallback aCallback) {
		callback = aCallback;

		//ACTION entry for "NOP"
		ACTION.put(OPCODES.get("NOP"),instr -> {
			int flags = instr.opcode & 6; // remove parity bit that will have been verified
			if(flags != 0) {
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " +fString);
			}
			cpu.pc++;
		});

		//ACTION entry for "NOT"
		ACTION.put(OPCODES.get("NOT"),instr -> {
			int flags = instr.opcode & 6; // remove parity bit that will have been verified
			if(flags != 0) {
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " +fString);
			}
			if (cpu.accum == 0)
				cpu.accum =1;
			else
				cpu.accum = 0;
			cpu.pc++;
		});

		//ACTION entry for "HALT"
		ACTION.put(OPCODES.get("HALT"),instr -> {
			int flags = instr.opcode & 6; // remove parity bit that will have been verified
			if(flags != 0) {
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " +fString);
			}
			halt();
		});

		//ACTION entry for "LOD"
		ACTION.put(OPCODES.get("LOD"), instr -> {
			int flags = instr.opcode & 6; // remove parity bit that will have been verified
			if(flags == 0) // direct addressing
				cpu.accum = memory.getData(instr.arg);
			else if(flags == 2) // immediate addressing
				cpu.accum = instr.arg;
			else if(flags == 4) // indirect addressing
				cpu.accum = memory.getData(memory.getData(instr.arg));
			else {
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " +fString);
			}
			cpu.pc++;
		});

		//ACTION entry for "STO"
		ACTION.put(OPCODES.get("STO"), instr -> {
			int flags = instr.opcode & 6; // remove parity bit that will have been verified
			if(flags == 0) // direct addressing
				memory.setData(instr.arg, cpu.accum);
			else if(flags == 4) // indirect addressing
				memory.setData(memory.getData(instr.arg), cpu.accum);
			else {
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " +fString);
			}
			cpu.pc++;
		});

		//ACTION entry for "ADD"
		ACTION.put(OPCODES.get("ADD"), instr -> {
			int flags = instr.opcode & 6; // remove parity bit that will have been verified
			if(flags == 0) // direct addressing
				cpu.accum += memory.getData(instr.arg);
			else if(flags == 2) // immediate addressing
				cpu.accum += instr.arg;
			else if(flags == 4) // indirect addressing
				cpu.accum += memory.getData(memory.getData(instr.arg));
			else {
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " +fString);
			}
			cpu.pc++;
		});

		//ACTION entry for "SUB"
		ACTION.put(OPCODES.get("SUB"), instr -> {
			int flags = instr.opcode & 6; // remove parity bit that will have been verified
			if(flags == 0) // direct addressing
				cpu.accum -= memory.getData(instr.arg);
			else if(flags == 2) // immediate addressing
				cpu.accum -= instr.arg;
			else if(flags == 4) // indirect addressing
				cpu.accum -= memory.getData(memory.getData(instr.arg));
			else {
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " +fString);
			}
			cpu.pc++;
		});

		//ACTION entry for "MUL"
		ACTION.put(OPCODES.get("MUL"), instr -> {
			int flags = instr.opcode & 6; // remove parity bit that will have been verified
			if(flags == 0) // direct addressing
				cpu.accum *= memory.getData(instr.arg);
			else if(flags == 2) // immediate addressing
				cpu.accum *= instr.arg;
			else if(flags == 4) // indirect addressing
				cpu.accum *= memory.getData(memory.getData(instr.arg));
			else {
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " +fString);
			}
			cpu.pc++;
		});

		//ACTION entry for "DIV"
		ACTION.put(OPCODES.get("DIV"), instr -> {
			int flags = instr.opcode & 6; // remove parity bit that will have been verified
			if(flags == 0) { // direct addressing
				if (memory.getData(instr.arg) == 0)
					throw new DivideByZeroException("Cannot divide by zero.");
				cpu.accum /= memory.getData(instr.arg);
			}
			else if(flags == 2) { // immediate addressing
				if (instr.arg == 0)
					throw new DivideByZeroException("Cannot divide by zero.");
				cpu.accum /= instr.arg;
			}
			else if(flags == 4) { // indirect addressing
				if (memory.getData(memory.getData(instr.arg)) == 0)
					throw new DivideByZeroException("Cannot divide by zero.");
				cpu.accum /= memory.getData(memory.getData(instr.arg));
			}
			else {
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " +fString);
			}
			cpu.pc++;
		});

		//ACTION entry for "AND"
		ACTION.put(OPCODES.get("AND"), instr -> {
			int flags = instr.opcode & 6; // remove parity bit that will have been verified
			if(flags == 0) {// direct addressing
				if (cpu.accum != 0 && memory.getData(instr.arg) != 0)
					cpu.accum = 1;
				else
					cpu.accum = 0;
			}
			else if(flags == 2) {// immediate addressing
				if (cpu.accum != 0 && instr.arg != 0)
					cpu.accum = 1;
				else
					cpu.accum = 0;
			}
			else {
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " +fString);
			}
			cpu.pc++;
		});

		//ACTION entry for "JUMP"
		ACTION.put(OPCODES.get("JUMP"), instr -> {
			int flags = instr.opcode & 6; // remove parity bit that will have been verified
			if(flags == 0) // direct addressing
				cpu.pc += instr.arg;
			else if(flags == 2) // immediate addressing
				cpu.pc = instr.arg;
			else if(flags == 4) // indirect addressing
				cpu.pc += memory.getData(instr.arg);
			else if(flags == 6)
				cpu.pc = memory.getData(instr.arg);
		});

		//ACTION entry for "JMPZ"
		ACTION.put(OPCODES.get("JMPZ"), instr -> {
			if(cpu.accum == 0) {
				int flags = instr.opcode & 6; // remove parity bit that will have been verified
				if(flags == 0) // direct addressing
					cpu.pc += instr.arg;
				else if(flags == 2) // immediate addressing
					cpu.pc = instr.arg;
				else if(flags == 4) // indirect addressing
					cpu.pc += memory.getData(instr.arg);
				else if(flags == 6)
					cpu.pc = memory.getData(instr.arg);
			}
			else
				cpu.pc++;
		});

		//ACTION entry for "CMPL"
		ACTION.put(OPCODES.get("CMPL"), instr -> {
			int flags = instr.opcode & 6; // remove parity bit that will have been verified
			if(flags != 0) {
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}
			if(memory.getData(instr.arg) < 0)
				cpu.accum = 1;
			else
				cpu.accum = 0;
			cpu.pc++;	
		});

		//ACTION entry for "CMPZ"
		ACTION.put(OPCODES.get("CMPZ"), instr -> {
			int flags = instr.opcode & 6; // remove parity bit that will have been verified
			if(flags != 0) {
				String fString = "(" + (flags%8 > 3?"1":"0") + (flags%4 > 1?"1":"0") + ")";
				throw new IllegalInstructionException("Illegal flags for this instruction: " + fString);
			}
			if(memory.getData(instr.arg) == 0)
				cpu.accum = 1;
			else
				cpu.accum = 0;
			cpu.pc++;
		});
	}
}

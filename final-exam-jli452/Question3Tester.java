package finalexam;

public class Question3Tester {
	public static void main(String[] args) {
		MachineModel model = new MachineModel();
		Memory memory = model.getMemory();
		CPU cpu = model.getCpu();
		cpu.setAccum(10);
		cpu.setPc(15);

		System.out.println("TESTING NOT");
		model.getINSTRUCTIONS()[1].execute();
		System.out.println(cpu.getAccum() + " accum should be 0");
		System.out.println(cpu.getPc() + " pc should be 16");
		
		System.out.println("TESTING NOT");
		model.getINSTRUCTIONS()[1].execute();
		System.out.println(cpu.getAccum() + " accum should be 1");
		System.out.println(cpu.getPc() + " pc should be 17");

		cpu.setAccum(10);

		System.out.println("TESTING STO");
		model.getINSTRUCTIONS()[7].execute(100);
		System.out.println(memory.getData(100) + " memory should be 10");
		System.out.println(cpu.getPc() + " pc should be 18");
		
		System.out.println("TESTING STON");
		memory.setData(100, 200);
		model.getINSTRUCTIONS()[8].execute(100);
		System.out.println(memory.getData(200) + " memory should be 10");
		System.out.println(cpu.getPc() + " pc should be 19");
		
		System.out.println("TESTING ADDI");
		model.getINSTRUCTIONS()[9].execute(20);
		System.out.println(cpu.getAccum() + " accum should be 30");
		System.out.println(cpu.getPc() + " pc should be 20");
		
		System.out.println("TESTING ADD");
		memory.setData(12, 50);
		model.getINSTRUCTIONS()[10].execute(12);
		System.out.println(cpu.getAccum() + " accum should be 80");
		System.out.println(cpu.getPc() + " pc should be 21");

		System.out.println("TESTING ADDN");
		memory.setData(50, -40);
		model.getINSTRUCTIONS()[11].execute(12);
		System.out.println(cpu.getAccum() + " accum should be 40");
		System.out.println(cpu.getPc() + " pc should be 22");	
	}
}

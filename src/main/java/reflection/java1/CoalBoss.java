package reflection.java1;

public class CoalBoss implements Boss{

	@Override
	public void meet() {
		System.out.println("与煤老板见面");
	}

	@Override
	public void consume() {
		System.out.println("让煤老板消费");
	}

}

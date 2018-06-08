package reflection.java1;

public class SteelBossProxy implements Boss {

	private SteelBoss sb;

	public SteelBossProxy() {
		sb = new SteelBoss();
	}

	@Override
	public void meet() {
		System.out.println("判断是否符合条件");
		
		sb.meet();
		
		System.out.println("代理结束");
	}

	@Override
	public void consume() {
		System.out.println("判断是否符合条件");
		
		sb.consume();

		System.out.println("代理结束");
	}

}

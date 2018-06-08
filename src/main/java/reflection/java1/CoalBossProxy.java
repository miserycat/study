package reflection.java1;

public class CoalBossProxy implements Boss{
	
	private CoalBoss cb;
	
	public CoalBossProxy(){
		cb = new CoalBoss();
	}
	

	@Override
	public void meet() {
		System.out.println("判断是否符合条件");
		
		cb.meet();
		
		System.out.println("代理结束");
		
	}

	@Override
	public void consume() {
		System.out.println("判断是否符合条件");
		
		cb.consume();

		System.out.println("代理结束");
	}

}

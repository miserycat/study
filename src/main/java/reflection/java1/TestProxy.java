package reflection.java1;

public class TestProxy {
	
	public static void main(String[] args) {
		
		/*CoalBossProxy cbp = new CoalBossProxy();
		cbp.meet();
		cbp.consume();
		
		System.out.println("-------------------------");
		
		SteelBossProxy sbp = new SteelBossProxy();
		sbp.meet();
		sbp.consume();*/
		
		
		DynaProxyHandler dph = new DynaProxyHandler();
		Boss boss = (Boss) dph.newProxyInstance(new CoalBoss());
		boss.meet();
		boss.consume();
		
		Boss boss1 = (Boss) dph.newProxyInstance(new SteelBoss());
		boss1.meet();
		boss1.consume();
		
	}

}

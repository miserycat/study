package threadCore.tc2;

public class Demo {
	
	private int a ;
	private int b;
	private int c;
	
	public void a () {
		
		// Ð´ºó¶Á
		// ¶ÁºóÐ´
		// Ð´ºóÐ´
		
		b = 2;
		
		a = 1; // Ð´²Ù×÷
		c = a; // ¶Á²Ù×÷
		b = c + a;
		
		System.out.println(b);
	}
	
	public static void main(String[] args) {
		new Demo().a();
	}

}

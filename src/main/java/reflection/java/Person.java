package reflection.java;

@MyAnnotation("atguigu")
public class Person extends Creature<String> implements MyInterface, Comparable {

	private String name;
	int age;

	public String nation;

	public Person() {
	}

	private Person(String name, int age, String nation) {
		this.name = name;
		this.age = age;
		this.nation = nation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName方法执行了……");
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public String setAge(int age, String name, double abc) {
		System.out.println("setAge方法执行了……" + age + "," + name + "," + abc);
		this.age = age;
		return "setAge方法返回值";
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}
	
	@MyAnnotation("atguigu")
	public void eat() throws Exception{
		System.out.println("吃饭");
	}
	
	@MyAnnotation("atguigu")
	private void sleep() {
		System.out.println("睡觉");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", nation=" + nation
				+ "]";
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}
	
	public class Computer{
		
	}
	
	private class Head{
		
	}

}

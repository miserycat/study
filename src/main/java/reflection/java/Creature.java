package reflection.java;

public class Creature<T> {

	private String color;
	public int legs;

	public Creature() {
	}

	public Creature(String color, int legs) {
		this.color = color;
		this.legs = legs;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}
	
	//
	public void show(){
		
	}
	
	private void get(){
		
	}

	@Override
	public String toString() {
		return "Creature [color=" + color + ", legs=" + legs + "]";
	}

}

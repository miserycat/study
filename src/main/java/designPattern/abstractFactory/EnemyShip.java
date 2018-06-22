package designPattern.abstractFactory;

/**
 * What is the abstract factory pattern?
 * It is like a factory, but everything is encapsulated
 * 	The method that orders the object
 * 	The factories that build the object
 * 	The final objects
 * 	The final objects contain objects that use the strategy pattern
 * 		Composition: Object class fields are objects
 *
 * What can you do with an abstract factory?
 * 	Allow you to create families of related objects without specifying a concrete class
 *	Use when you have many objects can be added, or changed dynamically during runtime
 *	you can model anything you can imagine and have those objects interact through common interfaces
 *
 * The bad: Things can get complicated
 *
 *
 */


public abstract class EnemyShip {

	private String name;
	
	// Newly defined objects that represent weapon & engine
	// These can be changed easily by assigning new parts 
	// in UFOEnemyShipFactory or UFOBossEnemyShipFactory
	
	ESWeapon weapon;
	ESEngine engine;
	
	public String getName() { return name; }
	public void setName(String newName) { name = newName; }
	
	abstract void makeShip();
	
	// Because I defined the toString method in engine
	// when it is printed the String defined in toString goes
	// on the screen
	
	public void followHeroShip(){
		
		System.out.println(getName() + " is following the hero at " + engine );
		
	}
	
	public void displayEnemyShip(){
		
		System.out.println(getName() + " is on the screen");
		
	}
	
	public void enemyShipShoots(){
		
		System.out.println(getName() + " attacks and does " + weapon);
		
	}
	
	// If any EnemyShip object is printed to screen this shows up
	
	public String toString(){
		
		String infoOnShip = "The " + name + " has a top speed of " + engine + 
				" and an attack power of " + weapon;
		
		return infoOnShip;
		
	}
	
}
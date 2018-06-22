package designPattern.factory;


/**
 * What is the factory pattern?
 * When method returns one of several possible classes that share a common super class
 * 	Create a new enemy in a game
 * 	Random number generator picks a number assigned to specific enemy
 * 	The factory returns the enemy associated with that number
 * The Class is chosen at run time
 *
 * When to use a factory pattern?
 * When you don't know ahead of time what class object you need
 * When all the potential classes are in the same subclass hierarchy
 * To centralize class selection code
 * When you don't want the user to know every subclass
 * To encapsulate object creation
 *
 *
 */

public class BigUFOEnemyShip extends UFOEnemyShip {

	public BigUFOEnemyShip(){
		
		setName("Big UFO Enemy Ship");
		
		setDamage(40.0);
		
	}
	
}
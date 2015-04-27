package jumpingalien.model;

import jumpingalien.util.Sprite;

/**
 * 
 * @author Afraz Salim & Niels van Belle
 * version 2.0
 *
 */
public abstract class Enemy extends WorldObjects {

	 /**
     * A constructor initializing the super class with given parameters.
     * @param x
     *        The x co-ordinate of enemy.
     * @param y
     *        The y co-ordinate of the enemy.
     * @param sprites
     *        A array consisting the sprites of the enemy.
     * @post. Super class will be initialized with the given 
     *        parameters.
     *        |super(x, y, sprites);
     */
	protected Enemy(int x, int y, Sprite[] sprites) {
		super(x, y, sprites);
	}
}

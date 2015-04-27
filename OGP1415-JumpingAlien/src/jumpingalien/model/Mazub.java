package jumpingalien.model;

import jumpingalien.util.Sprite;
import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Immutable;
import be.kuleuven.cs.som.annotate.Raw;

/**
 * A class of Mazub that represents an object so called alien, involving an
 * array of sprites the horizontal pixels and the vertical pixel.
 * 
 * 
 * @invar The left Pixel of the X co-ordinate of the mazub should be a valid
 *        pixel. |(isValidePixelLeftX(pixelLeftX)
 * @invar The bottom y pixel that represent the y-co-ordinate of the newly
 *        created alien and must be a valid Pixel.
 *        |isValidePixelBottomY(pixelBottomY)
 * 
 * @author Niels Van Belle & Afraz Salim
 * @version 2.0
 */
public class Mazub {
	/**
	 * 
	 * @param pixelLeftX
	 *            The given LeftPixel of the Mazub.
	 * @param pixelBottomY
	 *            The bottom y-co pixel of the mazub.
	 * @param sprites
	 *            An array consisting of mazub sprites.
	 * @pre... The given Left pixel of the mazub should be a valid pixel.it
	 *         should be between the bounds of the world.
	 *         |(isValidePixelLeftX(pixelLeftX)
	 * @pre... The given BottomY pixel of the mazub should be a valid pixel.it
	 *         should also between the vertical bounds of the world.
	 *         |(isValidePixelBottomY(pixelBottomY)
	 * @post... LeftpixelX of the mazub will be initialized with the given value
	 *          if and only if the precondition holds.
	 *          |this.setLeftPixelX(pixelLeftX);
	 * @post BottomYpixel of the mazub will be initialized with the given value
	 *       if and only if the precondition holds.
	 *       |this.setBottomPixelY(pixelBottomY);
	 * @post An array sprites will be initialized with given sprites.
	 *       |this.sprites = sprites;
	 * @post The initialVelocity for the X co-ordinate will be initialized with
	 *       the given value. |this.setInitialVelocityX(1.0);
	 * @post The max velocity of the x co-ordinates will be initialized with the
	 *       given value in parameter. |this.setMaxVelocityX(3.0);
	 * @post The initialAcceleration for the horizontal movement will be
	 *       initialized with the given value.
	 *       |this.setInitialAccelerationX(0.9);
	 * @throws MazubOutOfWorldException
	 *             Throws MazubOutOfWorldException if the pre-condition applied
	 *             on pixelleftx does not hold, it means whenever the left pixel
	 *             is out of the game world. |if
	 *             (!(isValidePixelLeftX(pixelLeftX))) |throw new
	 *             ModelException("Pixel X is out of world.");
	 * @throws MazubOutOfWorldException
	 *             Throws MazubOutOfWorldException if the pre-condition applied
	 *             on PixelBottomY does not hold, it means whenever the
	 *             pixelBottomy is out of the game world, it throws an
	 *             exception. |if (!(isValidePixelBottomY(pixelBottomY))) |throw
	 *             new ModelException("Pixel Y is out of world.");
	 */
	@Raw
	public Mazub(int pixelLeftX, int pixelBottomY, Sprite[] sprites) throws MazubOutOfWorldException {
		if (!(isValidePixelLeftX(pixelLeftX)))
			throw new MazubOutOfWorldException("Pixel X is out of world.");
		if (!(isValidePixelBottomY(pixelBottomY)))
			throw new MazubOutOfWorldException("Pixel Y is out of world.");
		this.sprites = sprites;
		this.setPixelLeftX(pixelLeftX);
		this.setPixelBottomY(pixelBottomY);
		this.setInitialVelocityX(1.0);
		this.setMaxVelocityX(3.0);
		this.setInitialAccelerationX(0.9);
		this.setNumberOfHitPoints(100);
	}

	/**
	 * Returns an array consisting of tow integers , respectively the x and y
	 * co-ordinate of the mazub.
	 * 
	 * @return Returns an array consisting of two integer , respectively the x
	 *         and y co-ordinates of the mazub.index zero represents the x while
	 *         index y represents the y co-ordinate. |array[0] =
	 *         this.getPixelLeftX(); |array[1] = this.getPixelBottomY(); |return
	 *         array;
	 */
	@Basic
	public int[] getLocation() {
		return makeArray(this.getPixelLeftX(), this.getPixelBottomY());
	}

	/**
	 * A setter to initialize the left pixel of the alien.
	 * 
	 * @param pixelLeftX
	 *            parameter pixelleftx to initialize the variable pixelleftx of
	 *            this class.
	 * @post The new value of the pixelleftx is initialized with the given vaue.
	 *       |new.pixelLeftX = pixelLeftX;
	 */
	protected void setPixelLeftX(int pixelLeftX) {
		this.pixelLeftX = pixelLeftX;
	}

	/**
	 * Returns the left pixel of the alien.
	 * 
	 * @return Returns the left pixel of the alien. result = (pixelLeftX).
	 *         |result == |(this.pixelLeftX)
	 */
	@Basic
	public int getPixelLeftX() {
		return this.pixelLeftX;
	}

	/**
	 * Checker to check whether the leftpixel representing the x-co of the alien
	 * is vaid pixel or not.
	 * 
	 * @param pixelLeftX
	 *            The given value to be checked.
	 * @return True if and only if the pixelleftx is not smaller than zero and
	 *         not greater than 1023. |result == |(pixelLeftX >= 0) |(pixelLeftX
	 *         < 1024)
	 */
	public boolean isValidePixelLeftX(int pixelLeftX) {
		if ((pixelLeftX < 0) || (pixelLeftX > 1024 * 70))
			return false;
		return true;
	}

	/**
	 * A private variable representing the left pixel x. |pixelLeftX
	 */
	private int pixelLeftX;

	/**
	 * To set/update the value if the alien,s y-coordinate.
	 * 
	 * @param pixelBottomY
	 *            Parameter representing the y-coordinate of the alien which
	 *            will be used to initialize the y-co of the alien.
	 * @post The new value of the y-coordinate of the alien will be equal to the
	 *       given. |new.pixelBottomY = pixelBottomY
	 */
	protected void setPixelBottomY(int pixelBottomY) {
		this.pixelBottomY = pixelBottomY;
	}

	/**
	 * Getter to get the value of the pixelBottomY.
	 * 
	 * @return Returns the the value of the leftpixel of the alien which
	 *         represent the alien,s y-coordinate. result = (pixelBottomY)
	 *         |this.pixelBottomY
	 */
	@Basic
	public int getPixelBottomY() {
		return this.pixelBottomY;
	}

	/**
	 * checks whether the given locations are valid or not.
	 * 
	 * @param pixelBottomY
	 *            Parameter holding the value of alien,s bottom y-coordinate.
	 *            |pixelBottomY
	 * @return Returns true if and only if the given values are greater than
	 *         zero and less than 768. |if(pixelBottomY >= 0) | return true;
	 *         |if(pixelBottomY < 768) |return true
	 */
	public boolean isValidePixelBottomY(int pixelBottomY) {
		if ((pixelBottomY < 0) || (pixelBottomY > 2800))
			return false;
		return true;
	}

	/**
	 * A private variable holding the value of alien,s location which represents
	 * the y-coordinate of the worm.
	 */
	private int pixelBottomY;

	/**
	 * Returns an index according to the action of the alien.
	 * 
	 * @post If the alien is ducking and is moving to the right side of the
	 *       world or it's last move was to the right side of the world and this
	 *       move was in the last second. Then the index 6 will be chosen. |if
	 *       (this.isDucking() && (this.isMovingRight() ||
	 *       (this.wasLastMoveRight() | && wasLastMoveXWithinLastSecond())))
	 *       |this.setCurrentIndex(6);
	 * @post If the alien is ducking and moving to the left side of the world or
	 *       it's last move was to the left side of the world and the last move
	 *       was in the last second. Then the index 7 will be chosen. |if
	 *       (this.isDucking && (this.IsMovingLeft() || (this.wasLastMoveLeft()
	 *       | && wasLastMoveXWithinLastSecond()))) |this.setCurrentIndex(7);
	 * @post If the alien is ducking, but not moving horizontal. Then the index
	 *       1 will be chosen. |if (this.isDucking() && !this.isMovingX())
	 *       |this.setCurrentIndex(1);
	 * @post If the alien is jumping and at the same time it's moving to the
	 *       right side of the world then the index 4 wil l be chosen. |if
	 *       (this.isMovingY() && this.isMovingRight())
	 *       |this.setCurrentIndex(4);
	 * @post if the alien is moving to the left side of the world and it's also
	 *       jumping then index 5 will be chosen. |if (this.isMovingY() &&
	 *       this.IsMovingLeft()) |this.setCurrentIndex(5);
	 * @post If the alien is not ducking and not moving horizontal and was not
	 *       moving horizontal in the last second, the index 0 will be chosen.
	 *       |if (!this.isMovingX() && !this.isDucking() &&
	 *       !wasLastMoveXWithinLastSecond()) |this.setCurrentIndex(0);
	 * @post If the last movement was to the right side of the world and in the
	 *       last second then the sprite from 2nd index will be chosen as
	 *       current sprite. |if (this.wasLastMoveRight() &&
	 *       wasLastMoveXWithinLastSecond()) | this.setCurrentIndex(2);
	 * @post if the last movement was to the left side of the world and in the
	 *       last second then the index 3 will be chosen as current index. |if
	 *       (this.wasLastMoveLeft() && wasLastMoveXWithinLastSecond())
	 *       |this.setCurrentIndex(3);
	 * @post If the alien is moving horizontal, the sprites of running cycle
	 *       will be used. |if(this.isMovingX()) |this.updateSpriteRunning();
	 */
	private void setCurrentSprite() {
		if (this.isDucking()) {
			if (this.isMovingRight() || (this.wasLastMoveRight() && wasLastMoveXWithinLastSecond()))
				this.setCurrentIndex(6);
			else if (this.isMovingLeft() || (this.wasLastMoveLeft() && wasLastMoveXWithinLastSecond()))
				this.setCurrentIndex(7);
			else
				this.setCurrentIndex(1);
		} else if (this.isMovingY()) {
			if (this.isMovingRight())
				this.setCurrentIndex(4);
			else if (this.isMovingLeft())
				this.setCurrentIndex(5);
			else
				this.setCurrentIndex(0);
		} else if (!this.isMovingX()) {
			if (!wasLastMoveXWithinLastSecond())
				this.setCurrentIndex(0);
			else if (this.wasLastMoveRight())
				this.setCurrentIndex(2);
			else if (this.wasLastMoveLeft())
				this.setCurrentIndex(3);
		} else {
			this.updateSpriteRunning();
		}
	}

	/**
	 * A method which returns the current sprite of the alien.
	 * 
	 * @pre.. The width of the to be returning alien should be valid width.
	 *        |assert
	 *        (this.isValidWidth(this.sprites[this.getCurrentIndex()].getWidth
	 *        ()));
	 * @pre... The height of to be returning alien should be a valid height.
	 *         |assert (this.isValidHeight(this.sprites[this.getCurrentIndex()].
	 *         getHeight()));
	 * @pre... The current index should be a valid index of the array sprite.
	 *         |assert ((this.getCurrentIndex() >= 0) && (this.getCurrentIndex()
	 *         < this.sprites.length));
	 * @return Returns an image of the alien according to the given index.
	 *         result = (sprite) |this.sprites[this.getCurrentIndex()];
	 */
	@Basic
	public Sprite getCurrentSprite() {
		assert (this.isValidWidth(this.sprites[this.getCurrentIndex()].getWidth()));
		assert (this.isValidHeight(this.sprites[this.getCurrentIndex()].getHeight()));
		assert ((this.getCurrentIndex() >= 0) && (this.getCurrentIndex() < this.sprites.length));
		return this.sprites[this.getCurrentIndex()];
	}

	public World getWorld() {
		return this.world;
	}

	/**
	 * Checks the height of the sprite.
	 * 
	 * @param height
	 *            Parameter height, holding the value the of alien,s sprite,s
	 *            height.
	 * @return Return true if and only if the height is greater than zero or
	 *         equal to zero. |if(height >= 0) |return true
	 */
	private boolean isValidHeight(int height) {
		if (height < 0)
			return false;
		return true;
	}

	/**
	 * Check whether the width of the alien,s sprite is valid width.
	 * 
	 * @param width
	 *            Parameter width, holding the value of the alien,s width,to be
	 *            checked.
	 * @return Returns true if and only if the alien,s width is greater than or
	 *         equal to zero. |if(width >= 0) |return true
	 */
	private boolean isValidWidth(int width) {
		if (width < 0)
			return false;
		return true;
	}

	/**
	 * A setter to set the current index of the sprite array.
	 * 
	 * @param index
	 *            Parameter index to initialize the variable index.
	 * @post... The value of the index will be equal to the parameter index.
	 *          |new.index = index
	 */
	private void setCurrentIndex(int index) {
		this.index = index;
	}

	/**
	 * An array consisting of sprites.
	 */
	private Sprite[] sprites;

	/**
	 * A getter that return the current index of the array sprite.
	 * 
	 * @return Returns the current index of the array(sprite) |return
	 *         this.index;
	 */
	private int getCurrentIndex() {
		return this.index;
	}

	/**
	 * A variable index to register the index of the array sprite.
	 */
	private int index;

	/**
	 * Returns an array consisting of the height and width of the alien.
	 * 
	 * @return Returns the height and width of the alien. result = (width,
	 *         height) |makeArray(this.getCurrentSprite().getWidth(),
	 *         this.getCurrentSprite().getHeight());
	 */
	@Basic
	public int[] getSize() {
		return makeArray(this.getCurrentSprite().getWidth(), this.getCurrentSprite().getHeight());
	}

	/**
	 * A method which puts the two integers in an array and gives it back.
	 * 
	 * @param first
	 *            The first parameter to be insert into the newly created array.
	 * @param second
	 *            The second parameter to be insert into the newly created
	 *            array.
	 * @return Returns a new array consisting of the two elements. |array[0] =
	 *         first; |array[1] = second; |return array;
	 */
	private int[] makeArray(int first, int second) {
		int[] array = new int[2];
		array[0] = first;
		array[1] = second;
		return array;
	}

	/**
	 * Returns a method which puts the horizontal and the vertical velocity of
	 * the alien and gives it back.
	 * 
	 * @return Returns a method which makes an array and puts the horizontal and
	 *         vertical velocities of the alien in that array. |result =
	 *         makeArray(this.getVelocityX(), this.getVelocityY());
	 */
	@Basic
	public double[] getVelocity() {
		return makeArray(this.getVelocityX(), this.getVelocityY());
	}

	/**
	 * Check whether the horizontal velocity of the alien is a valid velocity or
	 * not.
	 * 
	 * @param velocityX
	 *            The horizontal velocity of the alien.
	 * @return Returns true if the horizontal velocity of the alien is less than
	 *         the max velocity. |if((velocityX > this.getMaxVelocityX()))
	 *         |return false; Returns true if the velocity is not a NAN.
	 *         |if((Double.isNaN(velocityX))) |return false;
	 */
	private boolean isValidVelocityX(double velocityX) {
		if ((velocityX > this.getMaxVelocityX()))
			return false;
		if ((Double.isNaN(velocityX)))
			return false;
		return true;
	}

	/**
	 * A setter to initialize the the velocity of the alien.
	 * 
	 * @param velocityX
	 *            The parameter velocityx holding the new value of alien,s
	 *            velocity.
	 * @post... The new velocity of the alien will be equal to the given
	 *          velocity. |new.velocityX = velocityX
	 */
	private void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}

	/**
	 * A getter that returns the current velocity of the alien.
	 * 
	 * @return Returns the current velocity of the alien. |result =
	 *         (this.velocityX)
	 */
	@Basic
	public double getVelocityX() {
		return this.velocityX;
	}

	/**
	 * A private variable velocityX to register the value of velocityX.
	 */
	private double velocityX;

	/**
	 * A setter to initialize the variable.
	 * 
	 * @param initialVelocityX
	 *            A parameter that holds the new value with which the
	 *            initialVelocityX would be initialized.
	 * @post... The value of the variable initialvelocityX will be equal to the
	 *          given value. |new.initialVelocityX = initialVelocityX;
	 */
	private void setInitialVelocityX(double initialVelocityX) {
		this.initialVelocityX = initialVelocityX;
	}

	/**
	 * A getter that returns the initial horizontal velocity of the alien.
	 * 
	 * @return Returns the initial horizontal velocity of the alien. |result =
	 *         (this.initialVelocityX;)
	 */
	private double getInitialVelocityX() {
		return this.initialVelocityX;
	}

	/**
	 * A private variable to store the initial horizontal velocity of the alien.
	 */
	private double initialVelocityX;

	/**
	 * A setter to initialize the variable max velocity.
	 * 
	 * @param maxVelocityX
	 *            A parameter holding the new value of the alien,s horizontal
	 *            velocity.
	 * @post.. The new maxVelocity of the alien will be equal to the given
	 *         value. |new.maxVelocityX = maxVelocityX;
	 */
	private void setMaxVelocityX(double maxVelocityX) {
		this.maxVelocityX = maxVelocityX;
	}

	/**
	 * A getter to get the max velocity of the alien.
	 * 
	 * @return Returns the max velocity of the alien. |result =
	 *         (this.maxVelocityX)
	 */
	private double getMaxVelocityX() {
		return this.maxVelocityX;
	}

	/**
	 * A private variable holding the max velocity of the alien.
	 */
	private double maxVelocityX;

	/**
	 * A setter to set the vertical velocity of the alien.
	 * 
	 * @param velocityY
	 *            A parameter with which the vertical velocity of the alien will
	 *            be initialized.
	 * @post... The new velocity of the alien will equal to the given velocity.
	 *          |new.velocityY = velocityY
	 */
	private void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}

	/**
	 * A getter to get the vertical velocity of the alien.
	 * 
	 * @return Returns the vertical velocity of the alien. |result =
	 *         (this.velocityY)
	 */
	@Basic
	public double getVelocityY() {
		return this.velocityY;
	}

	/**
	 * A private variable to register the vertical velocity of the alien.
	 */
	private double velocityY;

	/**
	 * A getter to get the initial vertical velocity of the alien.
	 * 
	 * @return Returns the initial vertical velocity of the alien. |result =
	 *         (this.initialVelocityY)
	 */
	@Basic
	private double getInitialVelocityY() {
		return this.initialVelocityY;
	}

	/**
	 * A private variable to register the initialvertical velocity of of the
	 * alien.
	 */
	private final double initialVelocityY = 8.0;

	/**
	 * A getter to get the Acceleration of the mazub as an array.
	 * 
	 * @return Returns a method which returns an array consisting the two values
	 *         which are given as parameter respectively. |result =
	 *         (makeArray(this.getAccelerationX(), this.getAccelerationY())
	 */
	@Basic
	public double[] getAcceleration() {
		return makeArray(this.getAccelerationX(), this.getAccelerationY());
	}

	/**
	 * A setter to set the horizontal acceleration of the alien.
	 * 
	 * @param accelerationX
	 *            A parameter, which will be used to initialize the horizontal
	 *            acceleration of the alien.
	 * @post... If the given acceleration is NaN and the alien is moving
	 *          horizontal but not ducking, the new horizontal acceleration of
	 *          the alien will be equal to 0.9. |if (Double.isNaN(accelerationX)
	 *          && (this.isMovingX() &&(!(this.isDucking()))))
	 *          |new.accelerationX = 0.9;
	 * @post... If the given acceleration is NaN and the alien is ducking, the
	 *          new horizontal acceleration of the alien will be equal to 0.0.
	 *          |new.accelerationX = 0.0;
	 * @post... If the given acceleration is NaN and the alien is not moving
	 *          horizontal, the new horizontal acceleration of the alien will be
	 *          equal to 0.0. |new.accelerationX = 0.0;
	 * @post... The new horizontal acceleration of the alien will be equal to
	 *          the given value , given as parameter. |new.accelerationX =
	 *          accelerationX
	 */
	private void setAccelerationX(double accelerationX) {
		if (Double.isNaN(accelerationX) && (this.isMovingX() && (!(this.isDucking()))))
			this.accelerationX = 0.9;
		else if (Double.isNaN(accelerationX) && (this.isDucking()))
			this.accelerationX = 0.0;
		else if (Double.isNaN(accelerationX) && (!this.isMovingX()))
			this.accelerationX = 0.0;
		else
			this.accelerationX = accelerationX;
	}

	/***
	 * A getter to get the horizontal acceleration of the alien.
	 * 
	 * @return Returns the horizontal acceleration of the alien. result =
	 *         (this.accelerationX)
	 */
	@Basic
	public double getAccelerationX() {
		return this.accelerationX;
	}

	/**
	 * A private variable top store the horizontal acceleration of the alien.
	 */
	private double accelerationX;

	/**
	 * A setter to set the vertical acceleration of the alien.
	 * 
	 * @param accelerationY
	 *            A parameter which holds the new value of the alien,s vertical
	 *            acceleration.
	 * @post... The new vertical acceleration of the alien will be equal to the
	 *          given acceleration as parameter. |new.accelerationY =
	 *          accelerationY
	 */
	private void setAccelerationY(double accelerationY) {
		this.accelerationY = accelerationY;
	}

	/**
	 * A getter to get the vertical acceleration of the alien
	 * 
	 * @return Returns the vertical acceleration of the alien. |result =
	 *         (this.accelerationY)
	 */
	@Basic
	public double getAccelerationY() {
		return this.accelerationY;
	}

	/**
	 * A private variable to store the vertical acceleration of the alien.
	 */
	private double accelerationY;

	/**
	 * A setter to set the Initial horizontal acceleration of the alien.
	 * 
	 * @param initialAccelerationX
	 *            A parameter holding the initial acceleration of the alien.
	 * @post... The new acceleration of the alien will be equal to the given
	 *          horizontal acceleration given as parameter.
	 *          |new.initialAccelerationX = initialAccelerationX
	 */
	private void setInitialAccelerationX(double initialAccelerationX) {
		this.initialAccelerationX = initialAccelerationX;
	}

	/**
	 * A getter to get the initial horizontal acceleration of the alien.
	 * 
	 * @return Returns the initial horizontal acceleration of the alien. |result
	 *         = (this.initialAccelerationX)
	 */
	@Basic
	private double getInitialAccelerationX() {
		return this.initialAccelerationX;
	}

	/**
	 * A private variable to store the initial horizontal acceleration of the
	 * alien.
	 */
	private double initialAccelerationX;

	/**
	 * A getter to get the initial vertical acceleration of the alien.
	 * 
	 * @return Returns the vertical acceleration of the alien. |result =
	 *         (this.initialAccelerationY)
	 */
	@Basic
	@Immutable
	private double getInitialAccelerationY() {
		return this.initialAccelerationY;
	}

	/**
	 * A private final variable to register the initial vertical acceleration,
	 * default -10.0.
	 */
	private final double initialAccelerationY = -10.0;

	/**
	 * Makes an array of double consisting the values taken as parameter
	 * respectively.
	 * 
	 * @param first
	 *            The first argument to be inserted in the array.
	 * @param second
	 *            The second argument to be inserted into the array.
	 * @post puts the argument into the newly created array respectively.
	 *       |array[0] = first; |array[1] = second;
	 * @return... Returns an array consisting of two elements which it takes as
	 *            parameter. |result = (array)
	 * 
	 */
	private double[] makeArray(double first, double second) {
		double[] array = new double[2];
		array[0] = first;
		array[1] = second;
		return array;
	}

	/**
	 * A checker to check whether the alien is moving on horizontal plane.
	 * 
	 * @return Returns true if and only if the alien,s movement is to the right
	 *         side or to the left side. |(this.isMovingRight()) ||
	 *         (this.IsMovingLeft()
	 */
	private boolean isMovingX() {
		return (this.isMovingRight()) || (this.isMovingLeft());
	}

	/**
	 * Makes the alien to move on the horizontal plane to the right side.
	 * 
	 * @pre... In order to start to move to the right side the alien must not be
	 *         moving. |!(this.isMovingX())
	 * @effect... The new state of the alien will be changed to moving to right
	 *            state. |this.setIsMovingRight(true)
	 * @post... The new velocity of the alien will be it,s initial velocity so
	 *          that alien begins to move with it,s initial horizontal velocity.
	 *          |this.setVelocityX(this.getInitialVelocityX())
	 * @effect.. Sets the last movement to the right side at true.
	 *           |this.setLastMoveRight(true);
	 * @effect... Sets the last movement of the alien to left side at false.
	 *            |this.setLastMoveLeft(false);
	 * @post... Alien,s horizontal acceleration will be set with it,s initial
	 *          acceleration.
	 *          |this.setAccelerationX(this.getInitialAccelerationX());
	 * @post.. The alien,s direction will be changed to the positive x-axis. |
	 *         this.setDirection((int)Math.cos(0))
	 * @post The alien's image is changed to the first image of the running
	 *       cycle animation to right |
	 *       this.setCurrentIndex(this.startRunningCycleRight())
	 */
	public void startMoveRight() {
		if (!(this.isMovingX())) {
			this.setIsMovingRight(true);
			this.setVelocityX(this.getInitialVelocityX());
			this.setAccelerationX(this.getInitialAccelerationX());
			this.setDirection((int) Math.cos(0));
			this.setLastMoveRight(true);
			this.setLastMoveLeft(false);
			this.setCurrentIndex(this.startRunningCycleRight());
		}
	}

	/**
	 * Ends the movement of the alien to the right side.
	 * 
	 * @pre.. In order to end the alien,s movement to the right side, alien must
	 *        be moving to the right side. |if(this.isMovingRight())
	 * @post.. The alien state will be changed to not moving to the right side.
	 *         |this.setIsMovingRight(false)
	 * @post... Sets the alien,s horizontal velocity to to 0
	 *          |this.setVelocityX(0.0)
	 * @post... Sets the horizontal acceleration of the alien to 0
	 *          |this.setAccelerationX(0.0);
	 * @post... Time after the last movement will be set to zero.
	 *          |this.setTimeLastMoveX(0.0)
	 * 
	 */
	public void endMoveRight() {
		if (this.isMovingRight()) {
			this.setIsMovingRight(false);
			this.setVelocityX(0.0);
			this.setAccelerationX(0.0);
			this.setTimeLastMoveX(0.0);
		}
	}

	/**
	 * A setter to set the state of the alien to the right side.
	 * 
	 * @param isMovingRight
	 *            A parameter holding the boolean value.
	 * @post... The new value of the isMovingRight will be equal to the given
	 *          value as parameter. |new.isMovingRight = isMovingRight
	 */
	private void setIsMovingRight(boolean isMovingRight) {
		this.isMovingRight = isMovingRight;
	}

	/**
	 * A checker to check whether the alien is moving to right or not.
	 * 
	 * @return Returns true if and only if the alien is moving to right side.
	 *         |result = (this.isMovingRight)
	 */
	private boolean isMovingRight() {
		return this.isMovingRight;
	}

	/**
	 * A private variable to register the right movement of the alien.
	 */
	private boolean isMovingRight;

	/**
	 * A setter to set the set the last movement of the alien to the right side.
	 * 
	 * @param lastMoveRight
	 *            A boolean parameter holding the value of lastMovement was to
	 *            the right side or not.
	 * @post... The new value of the lastMoveRight will be equal to the given
	 *          value as parameter. |new.lastMoveRight = lastMoveRight
	 */
	private void setLastMoveRight(boolean lastMoveRight) {
		this.lastMoveRight = lastMoveRight;
	}

	/**
	 * Checks whether the last move was to the right side or not.
	 * 
	 * @return True if and only if the lastMovement was to the right side.
	 *         |result = (this.lastMoveRight)
	 */
	private boolean wasLastMoveRight() {
		return this.lastMoveRight;
	}

	/**
	 * A private variable to register the last movement of the alien to the
	 * right side.
	 */
	private boolean lastMoveRight;

	/**
	 * Alien starts moving to the right side of the world.
	 * 
	 * @pre... In order to start to move to the left side the alien must not be
	 *         moving. |!(this.isMovingX())
	 * @effect... Alien,s state will changed from not moving to the left side to
	 *            move to the left side. |this.setIsMovingLeft(true);
	 * @post... Alien,s horizontal velocity will be set equal to it,s initial
	 *          horizontal velocity.
	 *          |this.setVelocityX(this.getInitialVelocityX());
	 * @post... Alien,s direction will be changed to the negative x-axis.
	 *          |this.setDirection((int)Math.cos(Math.PI));
	 * @post... Alien,s horizontal acceleration will be set with it,s initial
	 *          acceleration.
	 *          |this.setAccelerationX(this.getInitialAccelerationX());
	 * @effect... Registers the last movement was to the left side of the world.
	 *            |this.setLastMoveLeft(true);
	 * @effect... Sets the last movement to the right at false.
	 *            |this.setLastMoveRight(false);
	 * @post The alien's image is changed to the first image of the running
	 *       cycle animation to left
	 *       |this.setCurrentIndex(this.startRunningCycleLeft());
	 */
	public void startMoveLeft() {
		if (!this.isMovingX()) {
			this.setIsMovingLeft(true);
			this.setVelocityX(this.getInitialVelocityX());
			this.setAccelerationX(this.getInitialAccelerationX());
			this.setDirection((int) Math.cos(Math.PI));
			this.setLastMoveLeft(true);
			this.setLastMoveRight(false);
			this.setCurrentIndex(this.startRunningCycleLeft());
		}
	}

	/**
	 * Alien stops moving to left.
	 * 
	 * @pre.. In order to end the alien,s movement to the left side, alien must
	 *        be moving to the left side. |if(this.isMovingLeft())
	 * @effects The alien,s state will be changed to false to move left.
	 *          |this.setIsMovingLeft(false);
	 * @post... The alien,s velocity will be set to zero.
	 *          |this.setVelocityX(0.0);
	 * @post... The alien,s acceleration will be set to zero.
	 *          |this.setAccelerationX(0.0);
	 * @post... Time after the last movement will be set to zero.
	 *          |this.setTimeLastMoveX(0.0);
	 */
	public void endMoveLeft() {
		if (this.isMovingLeft()) {
			this.setIsMovingLeft(false);
			this.setVelocityX(0.0);
			this.setAccelerationX(0.0);
			this.setTimeLastMoveX(0.0);
		}
	}

	/**
	 * A setter to change the moving to left state of the alien.
	 * 
	 * @param isMovingLeft
	 *            A parameter with which the value of isMovingLeft will be
	 *            updated or initialized.
	 * @post... The new boolean value of the variable (isMovingLeft) will be
	 *          equal to the given value. |new.isMovingLeft = isMovingLeft
	 */
	private void setIsMovingLeft(boolean isMovingLeft) {
		this.isMovingLeft = isMovingLeft;
	}

	/**
	 * A checker to check whether the alien is moving to the left side.
	 * 
	 * @return True if and only if the alien,s movement is to the left side.
	 *         |result = (this.isMovingLeft)
	 */
	private boolean isMovingLeft() {
		return this.isMovingLeft;
	}

	/**
	 * A private variable to register the leftMovement of the alien.
	 */
	private boolean isMovingLeft;

	/**
	 * A setter to set the last left movement of the alien.
	 * 
	 * @param lastMoveLeft
	 *            A parameter, holding the new value of lastMoveLeft with which
	 *            the variable will be initialized.
	 * @post... The new value of the lastMoveLeft will be equal to the given
	 *          value as parameter. |new.lastMoveLeft = lastMoveLeft
	 */
	private void setLastMoveLeft(boolean lastMoveLeft) {
		this.lastMoveLeft = lastMoveLeft;
	}

	/**
	 * A checker to check whether the last movement was to the left side.
	 * 
	 * @return True if and only if the last movement of the alien was to the
	 *         left side of the word. |result = (this.lastMoveLeft)
	 */
	private boolean wasLastMoveLeft() {
		return this.lastMoveLeft;
	}

	/**
	 * A private variable to store the left movement of the alien in the last
	 * second.
	 */
	private boolean lastMoveLeft;

	/**
	 * A checker to check whether the last movement within one second was to the
	 * left side.
	 * 
	 * @return True if and only if the last movement within the last second was
	 *         to the left side. |if (this.getTimeLastMoveX() <= 1.0) |return
	 *         true
	 */
	private boolean wasLastMoveXWithinLastSecond() {
		if (this.getTimeLastMoveX() > 1.0)
			return false;
		return true;
	}

	/**
	 * A setter to set the time after the last movement.
	 * 
	 * @param time
	 *            A parameter holding the value to initialize the the variable
	 *            timeLastMoveX.
	 * @post... The new value of the variable holding the last time movement
	 *          will be equal to the given value. |new.timeLastMoveX = time
	 */
	private void setTimeLastMoveX(double time) {
		this.timeLastMoveX = time;
	}

	/**
	 * A getter to get the time after making the last movement.
	 * 
	 * @return Returns the time after making the last movement of the alien.
	 *         |result = (this.timeLastMoveX)
	 */
	private double getTimeLastMoveX() {
		return this.timeLastMoveX;
	}

	/**
	 * A variable to register the time after making the last movement.
	 */
	private double timeLastMoveX;

	/**
	 * Updates the location of the alien.
	 * 
	 * @pre... The new location of the alien should be a valid location in order
	 *         to move.
	 *         |this.isValidePixelLeftX(this.getPixelLeftX()+this.getDirection
	 *         ()*this.getDistanceToMoveX())
	 * @post... Updates the location of the alien according to the given
	 *          direction. |this.setPixelLeftX(this.getPixelLeftX() | +
	 *          this.getDirection()*this.getDistanceToMoveX())
	 * @post... if the new location of the alien is not a valid location then
	 *          the alien will be placed at the old position if that is a valid
	 *          position. |this.setPixelLeftX(this.getPixelLeftX())
	 * @post.... if the pre-condition does hold and the new location is not a
	 *           valid location then the horizontal velocity of the alien will
	 *           be set at 0. |this.setVelocityX(0.0)
	 * @post... If the new position is not a valid position and the alien can,t
	 *          move then the acceleration of the alien will be set at 0.
	 *          |this.setAccelerationX(0.0)
	 * @throws InvalidPositionException
	 *             Throws InvalidPositionException if the new location on the
	 *             horizontal plane is not a valid location.
	 *             |if(!(this.isValidePixelLeftX
	 *             ((this.getPixelLeftX()+this.getDirection()*distance))))
	 *             |throw new InvalidPositionException("can,t move");
	 */
	private void updateLocationX(int distance) throws InvalidPositionException {
		try {
			int distanceToMove = this.getPixelLeftX() + this.getDirection() * distance;
			if (!(this.isValidePixelLeftX((this.getPixelLeftX() + this.getDirection() * distance))))
				throw new InvalidPositionException("can,t move");
			if(this.collideWithOtherObject(this.getPixelLeftX(), this.getPixelBottomY(),distanceToMove))
				throw new InvalidPositionException("can,t Move");
			  int dist = this.getDistanceToMoveX(this.getPixelLeftX(),this.getPixelBottomY(), distance);
			  if(this.isAtObject())
				  dist = distanceToMove;
			  this.setPixelLeftX(this.getPixelLeftX()+dist*this.getDirection());
			  doAction();
		} catch (InvalidPositionException exc) {
			if (this.isValidePixelLeftX(this.getPixelLeftX())) {
				this.setPixelLeftX(this.getPixelLeftX());
				this.setVelocityX(0.0);
				this.setAccelerationX(0.0);
			} else
				throw exc;
		}
	}

	/**
	 * Return the distance as the passable terrain.
	 * @param x
	 *        The x co-ordinate of the alien.
	 * @param y
	 *        The y co-ordinate of the alien.
	 * @param distance
	 *        The given maximum distance to move.
	 * @post. If the alien is moving to the right side of the world and the pixel next to the bottomright corner 
	 *        of alien or top right pixel of the alien represents a tile then it returns the calculated distance.
	 *        otherwise distance will be sum up.
	 *        |if(world.isImpassablePassAble(x+(width-2)+i, y+1) 
     *        | || (world.isImpassablePassAble(x+(width-2)+i, y+(height/2))))
     *        |return dist;
     *        |else
     *        |dist++;
     * @post. if the alien,s direction is to the left side of the world and top left corner of the alien or
     *        alien bottom left corner detects an impassable terrain then it returns distance.
     *        | if(world.isImpassablePassAble(x-1-i, y+1)) ||(world.isImpassablePassAble(x-1-i, y+this.getCurrentSprite().getHeight()))
     *        | return dist;
	 * @return
	 *       return the distance to move as passable terrain.
	 *       |result = (dist)
	 */
	private int getDistanceToMoveX(int x, int y, int distance) {
	  int dist = 0;
	  World world = this.getWorld();
	  int width = this.getCurrentSprite().getWidth();
	  int height = this.getCurrentSprite().getHeight();
      for(int i = 0;i < distance;i++){
    	  if(this.getDirection() >0){
    	  if(world.isImpassablePassAble(x+(width-2)+i, y+1) 
    			   || (world.isImpassablePassAble(x+(width-2)+i, y+(height/2))))
    		  return dist;
    	  if(world.isImpassablePassAble(x+(width-2)+i, y+this.getCurrentSprite().getHeight()-2))
    		  return dist;
    	    dist++;
    	  }
    	  else if(this.getDirection() < 0){
    	  if(world.isImpassablePassAble(x-1-i, y+1))
    		  return dist;
    	  if(world.isImpassablePassAble(x-1-i, y+this.getCurrentSprite().getHeight()))
    		  return dist;
    	  dist++;
    	  }
      }
	return distance;
 }

	
	/**
	 * Does the actions depending on the conditions.
	 * @effect.. if the alien collides with plants and plant is not and alien can eat plant
	 *           then alien,s hitpoints will be increased and plant will be destroyed.
	 *           |if (this.collideX(plants))
	 *           |if(this.canEat() && !plants.isDeath())
	 *           |this.setNumberOfHitPoints(this.getNumberOfHitPoints() + 50);
	 *           |plants.setIsDeath(true);
	 * @effect.. if the alien collides with slimes and the alien is not immune then alien will loose 
	 *           it,s hitpoints and will be set to immune.
	 *           |if (this.collideX(slimes))
	 *           |if(!(this.isImmune()))
	 *           |this.setNumberOfHitPoints(this.getNumberOfHitPoints() - 50);
	 *           |this.setImmune(true);
	 * @effect   if the alien collides with sharks and alien is not immune, then alien,s hitpoints
	 *           will be decreased and will be set to immune.
	 *           |if (this.collideX(sharks)
	 *           |if(!(this.isImmune())
	 *           |this.setNumberOfHitPoints(this.getNumberOfHitPoints() - 50);
	 *           |this.setImmune(true);
	 * @effect   If the alien undergoes the water  and it remains in water for more than 
	 *           0.2 seconds then alien will loose hitpoints after every 0.2 seconds.
	 *           |if(this.isInWaterWhileMoving())
	 *           |if(this.exceededMaxTime())
	 *           |this.setNumberOfHitPoints(this.getNumberOfHitPoints()-2);
	 *           |this.setIsInWater(false);
	 *           |this.setWaterTime(0);
	 * @effect   if the alien is in magma and it remains there for more then 0.2 seconds 
	 *           then alien will loose it,s hitpoints after every 0.2 seconds.
	 *           |if(this.inMagma())
	 *           |if(this.exceededMaxTime())
	 *           |this.setNumberOfHitPoints(this.getNumberOfHitPoints()-50)
	 *           |this.setInMagma(false);
	 *           |this.setWaterTime(0);
	 */
	private void doAction() {
		for (Plant plants : this.getWorld().getCollectionPlant()) {
				if (this.collideX(plants)) {
					if(this.canEat() && !plants.isDeath()){
						this.setNumberOfHitPoints(this.getNumberOfHitPoints() + 50);
						plants.setIsDeath(true);
					}
			}
		}
		for (Slime slimes : this.getWorld().getCollectionOfSlimes()) {
			if (this.collideX(slimes)) {
			if(!(this.isImmune())){
				this.setNumberOfHitPoints(this.getNumberOfHitPoints() - 50);
				this.setImmune(true);
				this.startTimeImmunity(this.getTime());
				}
			}
		}
		for (Shark sharks : this.getWorld().getCollectionOfSharks()) {
			if (this.collideX(sharks)) {
			if(!(this.isImmune())){
				this.setNumberOfHitPoints(this.getNumberOfHitPoints() - 50);
				this.setImmune(true);
				}
			}
		}
		if(this.isInWaterWhileMoving()){
			if(this.exceededMaxTime()){
				this.setNumberOfHitPoints(this.getNumberOfHitPoints()-2);
				this.setIsInWater(false);
				this.setWaterTime(0);
			}
		}
		if(this.inMagma()){
			if(this.exceededMaxTime()){
				this.setNumberOfHitPoints(this.getNumberOfHitPoints()-50);
				this.setInMagma(false);
				this.setWaterTime(0);
			}
		}
	}
	

	
	/**
	 * A private boolean variable holding the value of inMagma.
	 */
	private boolean inMagma;
	
	
	/**
	 * A setter to set the alien in to magma.
	 * @param b
	 *        The new value with which the old variable will eb initialized and update.
	 * @post. The new value of the inMagma will be equal to the given value.
	 *        |this.inMagma = b
	 */
	private void setInMagma(boolean b) {
		this.inMagma = b;
	}

	/**
	 * A boolean checker to check that if alien is in magma.
	 * @return
	 *        Return true if and only if the alien is in magma.
	 *        |return inMagma
	 */
	private boolean inMagma() {
		return inMagma;
	}

	/**
	 * A boolean checker whether the time in water is exceeded.
	 * @return
	 *       Returns true if and only if the start time is greater than 
	 *       0.2.
	 *       |return this.getBeginTime()  >= 0.2;
	 */
	private boolean exceededMaxTime() {
         return this.getBeginTime()  >= 0.2;
	}

	
	
	/**
	 * A private double variable holding the waterTime value.
	 */
	private double waterTime = 0;

	/**
	 * A setter to set the water time.
	 * @param time
	 *        A time variable holding the value of time.
	 * @post.. new value of the time will be equal to the given time.
	 *         |this.waterTime = time;
	 */
	private void setWaterTime(double time){
		this.waterTime = time;
	}
	
   
	/**
	 * A getter to get the beginning time of the alien.
	 * @return
	 *       Returns the begin time in water.
	 *       |result = (this.waterTime)
	 */
	public double getBeginTime(){
		return this.waterTime;
	}
	
	/**
	 * A private boolean variable to check if the alien is in water.
	 */
	@SuppressWarnings("unused")
	private boolean isInWat;
	

	/**
	 * A setter to set the alien in water.
	 * @param value
	 *        The value with which the old value will be initialized.
	 * @post.. 
	 *         Set the alien in water.
	 *         |new.isInWater = value
	 */
	private void setIsInWater(boolean value){
		this.isInWat = value;
	}
	
	
	
	
	

	
	
    /**
     * A private double variable storin the value of startTime.
     */
	private double startTime = 0;
	
	/**
	 * Set the start time of immunity.
	 * @param time
	 *        The given time with which time will be initialized.
	 * @post. 
	 *        new.startTime = time;
	 */
	private void startTimeImmunity(double time) {
      startTime = time;
	}
	
	/**
	 * Returns he immunity time of the alien.
	 * @return
	 *      Return the start time of the immunity.
	 *      |return this.startTime;
	 */
	@Basic
	private double getImmunityTime(){
		return this.startTime;
	}

	/**
	 * A private boolean variable holding the immunity value.
	 */
	private boolean isImmune;
	
	/**
	 * A boolean inspector to check if the alien is immune or not.
	 * @return
	 *       Returns true if and only if the alien is immune.
	 *       |return this.isImmune;
	 */
	public boolean isImmune() {
         return this.isImmune;
	}
    
	/**
	 * Sets the immunity of the alien.
	 * @param immune
	 *        A new value holding the value of immunity.
	 * @post. New immunity of alien will be equal to the given
	 *        value.
	 *        |this.isImmune = immune;
	 */
	private void setImmune(boolean immune){
		this.isImmune = immune;
	}
	
	
	
	
	
	/**
	 * Returns the distance to move the alien on the horizontal plane.
	 * 
	 * @param velocity
	 *            The current velocity of the alien.
	 * @param time
	 *            Time since last horizontal move.
	 * @return Returns the distance to move on horizontal plane if there is no
	 *         acceleration is involved. |int distanceToMove = (int)
	 *         (100.0*(velocity*time)); |result = (distanceToMove)
	 * @return Returns the distance to move on horizontal plane if there is
	 *         acceleration is involved. |if (velocity < this.getMaxVelocityX()
	 *         |int distanceToMove +=
	 *         0.5*(this.getAccelerationX()*Math.pow(this.getTime(),2)); |result
	 *         = (distanceToMove)
	 * @return Returns corrected (round off) distance to move on horizontal
	 *         plane if moving to left |if (isMovingLeft()) |result =
	 *         (distanceToMove + 1)
	 */
	private int getDistanceToMoveX(double velocity, double time) {
		int distanceToMove = (int) (100.0 * (velocity * time));
		if (velocity < this.getMaxVelocityX())
			distanceToMove += 0.5 * (this.getAccelerationX() * Math.pow(this.getTime(), 2));
		if (this.isMovingLeft())
			return (int) ((distanceToMove + 1));
		return distanceToMove;
	}

	/**
	 * A setter to set the direction of the alien.
	 * 
	 * @param direction
	 *            A parameter holding the new value for the variable direction.
	 * @post... The new direction will be equal to the given direction
	 *          |new.direction = direction
	 */
	private void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * A getter to get the current direction of the alien.
	 * 
	 * @return Returns the current direction of the alien. |result =
	 *         (this.direction)
	 */
	@Basic
	private int getDirection() {
		return this.direction;
	}

	/**
	 * A private variable to store the direction of the alien.
	 */
	private int direction;

	/**
	 * Checks whether alien is jumping or not.
	 * 
	 * @return True if and only if the alien is jumping or the alien is falling.
	 *         |result = (this.isJumping() || this.isFalling())
	 */
	private boolean isMovingY() {
		return (this.isJumping() || this.isFalling());
	}

	/**
	 * Alien jumps a vertical distance.
	 * 
	 * @effect... Changes the current state of alien from not jumping to
	 *            jumping. |this.setIsJumping(true);
	 * @post... Alien,s vertical velocity will be set equal to it,s initial
	 *          velocity. |this.setVelocityY(this.getInitialVelocityY());
	 * @post... Alien,s acceleration will be equal to to it,s initial vertical
	 *          acceleration. |this.setVelocityY(this.getInitialVelocityY());
	 * @throws InvalidActionException
	 *             Throws an InvalidActionException if the alien is already
	 *             jumping. |if(this.isJumping()) |throw new
	 *             InvalidActionException
	 *             ("Can,t jump cause the alien is already juming");
	 */
	public void jump() throws InvalidActionException {
		try {
			if (this.isJumping())
				throw new InvalidActionException("Can,t jump cause the alien is already juming");
			if (!(this.getWorld().isImpassablePassAble(this.getPixelLeftX()+2, this.getPixelBottomY() - 2))
					&& !(this.getWorld().isImpassablePassAble(this.getPixelLeftX() + this.getCurrentSprite().getWidth()
							- 3, pixelBottomY - 2)) &&!(this.isAtObject()))
				throw new InvalidActionException("Mazub is not located at solid ground");
			this.setIsJumping(true);
			this.setVelocityY(this.getInitialVelocityY());
			this.setAccelerationY(this.getInitialAccelerationY());
		} catch (InvalidActionException exc) {
			this.setIsJumping(true);
		}
	}

	/**
	 * Ends the jump of the alien.
	 * 
	 * @effect... Alien,s state will be changed to false.
	 *            |this.setIsJumping(false);
	 * @post... Alien,s velocity will be set at 0. |this.setVelocityY(0);
	 * @post... Alien will fall if the alien is not located at the the bottom of
	 *          the world. |this.fall();
	 * @throws InvalidActionException
	 *             Throws an InvalidActionException if the alien is not jumping.
	 *             |if(this.isJumping()) |throw new
	 *             InvalidActionException("Can,t end jump, cause alien is not jumping."
	 *             );
	 */
	public void endJump() throws InvalidActionException {
		this.setIsJumping(false);
		if (this.getVelocityY() > 0)
			this.setVelocityY(0);
		this.fall();
	}

	/**
	 * checks whether the alien is jumping or not.
	 * 
	 * @return True if and only if the alien is Jumping. |result =
	 *         (this.isJumping)
	 */
	private boolean isJumping() {
		return this.isJumping;
	}

	/**
	 * A setter to change the state of the alien to jumping.
	 * 
	 * @param isJumping
	 *            A parameter holding the new boolean value with which the
	 *            isJumping variable will be updated. |new.isJumping = isJumping
	 */
	private void setIsJumping(boolean isJumping) {
		this.isJumping = isJumping;
	}

	/**
	 * A private variable to register the current state of falling alien.
	 */
	private boolean isJumping;

	/**
	 * The begins to fall.
	 * 
	 * @post... if the vertical value of the alien is greater than zero then the
	 *          alien will start falling and it,s state will be changed to
	 *          falling. |if (this.getPixelBottomY() > 0)
	 *          |this.setIsFalling(true)
	 */
	private void fall() {
		if (this.getPixelBottomY() > 0)
			this.setIsFalling(true);
	}

	/**
	 * Checks whether the alien is falling or not.
	 * 
	 * @return True if and only if the alien is falling. |result =
	 *         (this.isFalling)
	 */
	private boolean isFalling() {
		return this.isFalling;
	}

	/**
	 * A setter to change or update the value of variable isFalling which will
	 * be used to check whether the alien is falling or not.
	 * 
	 * @param isFalling
	 *            A parameter with which the value of isFalling will be updated.
	 * @post... The new value of isFalling will be equal to the given value as
	 *          parameter. |new.isFalling = isFalling
	 */
	private void setIsFalling(boolean isFalling) {
		this.isFalling = isFalling;
	}

	/**
	 * A private variable to register the value of alien is falling or not.
	 */
	private boolean isFalling;
	private boolean endDucking;

	/**
	 * Updates the location of the alien.
	 * 
	 * @param distanceToJump
	 *            A given distance to jump.
	 * @pre In order to jump the new location of the alien should be a valid
	 *      location.
	 *      |(this.isValidePixelBottomY((this.getPixelBottomY()+distanceToJump))
	 * @post if the pre-condition holds then the new location of the alien will
	 *       be set according to it,s distance.
	 *       |this.setPixelBottomY((this.getPixelBottomY()+distanceToJump))
	 * @post if the pre-condition does not hold then the alien will be set to
	 *       it,s previous position.
	 *       |this.setPixelBottomY(this.getPixelBottomY()).
	 * @post if the alien is not at the bottom of the y-co then the alien,s
	 *       vertical position will be setted to 0. |if
	 *       ((this.getPixelBottomY()+distanceToJump) < 0)
	 *       |this.setPixelBottomY(this.getPixelBottomY())
	 * @throws InvalidPositionException
	 *             Throws InvalidPositionException if the new distance and
	 *             position is not valid. |if
	 *             (!(this.isValidePixelBottomY((this.
	 *             getPixelBottomY()+distanceToJump)))) |throw new
	 *             InvalidPositionException("Alien can't jump out of world.");
	 */
	private void updateLocationY(int distanceToJump) throws InvalidPositionException {
		try {
			if (!(this.isValidePixelBottomY((this.getPixelBottomY() + distanceToJump))))
				throw new InvalidPositionException("Alien can't jump out of world.");
			int positionToJump = this.getPositionToJump(this.getPixelLeftX(), this.getPixelBottomY(), distanceToJump,
					this.getWorld());
			if (positionToJump < distanceToJump) {
				this.setPixelBottomY((this.getPixelBottomY() + positionToJump));
				this.setAccelerationY(-10);
				this.endJump();
			} else
				this.setPixelBottomY((this.getPixelBottomY() + positionToJump));
		} catch (InvalidPositionException exc) {
			if (this.isValidePixelBottomY(this.getPixelBottomY()))
				this.setPixelBottomY(this.getPixelBottomY());
			else
				throw exc;
		}
		if ((this.getPixelBottomY() + distanceToJump) < 0)
			this.setPixelBottomY(0);
	}

	/**
	 * Returns the distance to move on the y-co-ordinate.
	 * 
	 * @param velocity
	 *            The current velocity of the alien.
	 * @param time
	 *            The current time of the alien.
	 * @param The
	 *            current acceleration of the alien.
	 * @return Computes and returns the distance which makes the alien to jump.
	 *         |result = ((int)100.0*(velocity*time |
	 *         +0.5*(accelerationY*Math.pow(time, 2))
	 */
	private int getDistanceToMoveY(double velocity, double time, double accelerationY) {
		return (int) (100.0 * (velocity * time + 0.5 * (accelerationY * Math.pow(time, 2))));
	}

	/**
	 * Alien starts ducking.
	 * 
	 * @effect... Alien,s state will be changed from not ducking to the ducking.
	 *            |this.setIsDucking(true);
	 * @post... Alien,s max velocity will set to 1.0 |this.setMaxVelocityX(1.0);
	 * @post... Alien,s current velocity will be set to 1.0
	 *          |this.setVelocityX(1.0);
	 * @throws InvalidActionException
	 *             Throws an invalidActionException if the alien is already
	 *             ducking. |if(this.isDucking()) |throw new
	 *             InvalidActionException("Already Ducking")
	 */
	public void startDuck() throws InvalidActionException {
		this.setIsDucking(true);
		this.setMaxVelocityX(1.0);
		if (this.getVelocityX() > 1.0)
			this.setVelocityX(1.0);
	}
	/**
	 * Alien ends Ducking.
	 * 
	 * @effect... Alien,s state will be changed to not ducking.
	 *            |this.setIsDucking(false)
	 * @post... Resets the alien,s max velocity to the initial max velocity.
	 *          |this.setMaxVelocityX(3.0)
	 * @throws InvalidActionException
	 *             Throws InvalidActionException when method is called while the
	 *             alien is not ducking. |if(!(this.isDucking())) |throw new
	 *             ModelException("Alien is not ducking");
	 */
	public void endDuck() throws InvalidActionException {
		int width = this.sprites[0].getWidth();
		int height = this.sprites[0].getHeight();
		World world = this.getWorld();
		try {
			// if(!(this.isDucking()))
			// throw new InvalidActionException("Alien is not ducking");
			if ((world.isImpassablePassAble(this.getPixelLeftX() + (width - 2), this.getPixelBottomY()
					+ (height- 2))))
				throw new InvalidActionException("Not a proper place to end duck");
			if ((world.isImpassablePassAble(this.getPixelLeftX() + 1, this.getPixelBottomY() + (height - 2))))
				throw new InvalidActionException("Not a proper place to end duck");
			this.setIsDucking(false);
			this.setMaxVelocityX(3.0);
			if (this.isMovingX())
				this.setAccelerationX(this.getInitialAccelerationX());
		} catch (InvalidActionException exc) {
			this.setIsDucking(true);
			this.endDuckingAtRightLocation(true);
		}
	}

	private void endDuckingAtRightLocation(boolean ducking) {
		this.endDucking = ducking;
	}

	public boolean getEndDucking() {
		return this.endDucking;
	}

	/**
	 * A boolean method to check whether the alien is ducking or not.
	 * 
	 * @return Returns true if and only if the alien is ducking. |result =
	 *         (this.isDucking)
	 */
	private boolean isDucking() {
		return this.isDucking;
	}

	/**
	 * A setter to set the current state of the alien as ducking.
	 * 
	 * @param isDucking
	 *            The parameter holding the new boolean value.
	 * @post... The new value of the variable isDucking will be equal to the
	 *          value, given as parameter. |new.isDucking = isDucking
	 */
	private void setIsDucking(boolean isDucking) {
		this.isDucking = isDucking;
	}

	/**
	 * A private boolean variable to register the Ducking state of the alien.
	 */
	private boolean isDucking;

	
	
	/**
	 * Checker to check whether the the alien,s immunity time can be canceled.
	 * @return
	 *         Returns true if and only if the immunity time is greater than 0.6
	 *         |result = (this.getImmunityTime() >= 0.6)
	 */
	private boolean canCancelImunity(){
		return this.getImmunityTime() >= 0.6;
	}
	
	
	
	
	
	/**
	 * Advance the time with the given time as parameter.
	 * 
	 * @param world
	 * @param time
	 *            A parameter time holding the new value of the time.
	 * @post Alien,s acceleration will be set to 0.0 if the alien is moving
	 *       horizontally and also ducking at the same time. |if
	 *       (this.isMovingX() && this.isDucking()) |this.setAccelerationX(0.0);
	 * @post... Alien,s horizontal velocity will be updated with the current
	 *          acceleration and the time given as parameter if the alien is
	 *          moving horizontally. |if (this.isMovingX())
	 *          |this.updateVelocityX(this.getAccelerationX(),time);
	 * @post... Alien,s horizontal position will be updated if the alien is
	 *          moving horizontally. |if (this.isMovingX())
	 *          |this.updateLocationX
	 *          (this.getDistanceToMoveX(this.getVelocityX(),this.getTime()));
	 * @post.. Time for running will be updated by adding the new time to the
	 *         current time if the alien is moving horizontally. |if
	 *         (this.isMovingX())
	 *         |this.setSpriteRunningTime(this.getSpriteRunningTime()+time);
	 * @post... if the alien is not moving horizontally then the time of it's
	 *          last movement will be updated by adding the new time to the
	 *          current time. |if (!this.isMovingX())
	 *          |this.setTimeLastMoveX(this.getTimeLastMoveX()+time);
	 * @post... Alien,s vertical location will be updated if the alien is moving
	 *          vertically. |if (this.isMovingY())
	 *          |this.updateLocationY(this.getDistanceToMoveY());
	 * @post.... Alien,s vertical velocity will be changed if the alien is
	 *           moving vertically. |if (this.isMovingY())
	 *           |this.updateVelocityY(this.getAccelerationY(),this.getTime());
	 * @post... if the alien is not located at the bottom of the world alien,s
	 *          acceleration will be set to 0.0 as it can fall.
	 *          |this.setAccelerationY(0.0);
	 * @post... if the alien is located at the bottom of the world, alien,s
	 *          vertical velocity will be set to 0.0. |if
	 *          |(this.getPixelBottomY() == 0) |this.setVelocityY(0.0);
	 * @post... if the alien is located at the bottom of the world, alien,s
	 *          vertical acceleration will be set to 0.0. | if
	 *          |(this.getPixelBottomY() == 0) |this.setAccelerationY(0.0)
	 * @effect... if the alien is located at the bottom of the world, aliens
	 *            state will be changed to not jumping. | if
	 *          | (this.getPixelBottomY() == 0) |this.setIsJumping(false);
	 * @effect   Alien will stop falling as it reaches the bottom of the world. |
	 *          |f (this.getPixelBottomY() == 0) |this.setIsFalling(false);
	 * @effect  Checks if the alien is immune then it starts it,s immunity time.
	 *          |if(this.isImmune())
	 *          |this.startTimeImmunity(this.getImmunityTime()+time);
	 * @effect  If the alien is in water then it,s water time will be started and it,s state will
	 *          be changed from not in water to in water.
	 *          |if(this.isInWaterWhileMoving())
	 *          |this.setIsInWater(true);
	 *          |this.setWaterTime(this.getBeginTime()+time);
	 * @effect  if the alien is in magma then it,s time will be started as it remain in 
	 *          magma.
	 *          |if(this.isInMagma())
	 *          |this.setInMagma(true);
	 *          |this.setWaterTime(this.getBeginTime()+time);
	 * @post..  If the alien is dead then it will be removed from the world.
	 *          |if(this.isDead())
	 *		    |this.getWorld().removeMazub(this);
	 */
	public void advanceTime(double timee, World world) {
		double time = timee;
		this.setWorld(world);
		this.updateTime(timee);
		if(this.canCancelImunity()){
			this.setImmune(false);
            this.startTimeImmunity(0);
		}
		if(this.isDucking())
			this.setCurrentSprite();
		if (this.isMovingX()) {
			this.updateVelocityX(this.getAccelerationX(), this.getTime());
			this.updateLocationX(this.getDistanceToMoveX(this.getVelocityX(), this.getTime()));
			this.doAction();
			if (this.isDucking()){
				this.setAccelerationX(0.0);
				this.setCurrentSprite();
			}
			if(this.isInWaterWhileMoving()){
				this.setIsInWater(true);
				this.setWaterTime(this.getBeginTime()+time);
			}
			
			this.setSpriteRunningTime(this.getSpriteRunningTime() + time);
			if (!(this.isMovingY())) {
				if (this.canFall()) {
					this.setVelocityY(0.0);
					this.setAccelerationY(-10);
					this.setIsFalling(true);
					doAction();
				}
			}
		} else {
			this.setTimeLastMoveX(this.getTimeLastMoveX() + time);
		}
		if (this.isMovingY()) {
			this.updateLocationY(this.getDistanceToMoveY(this.getVelocityY(), this.getTime(), this.getAccelerationY()));
			doAction();
			this.updateVelocityY(this.getAccelerationY(), this.getTime());
			if(this.isAtObject()){
				this.setVelocityY(0.0);
				this.setAccelerationY(0.0);
				this.setIsFalling(false);
			}
			if(this.isAtSolidterrain()){
				this.setVelocityY(0.0);
				this.setAccelerationY(0.0);
				this.setIsFalling(false);
				this.stopAtRightPixel(this.getPixelBottomY(), this.getPixelLeftX());
				if(this.isInWaterWhileMoving()){
					this.setIsInWater(true);
					this.setWaterTime(this.getBeginTime()+time);
				}
				doAction();
			}
		}
		if (this.getEndDucking()) {
			if (this.isRightPlaceToEndDucking()) {
				this.endDuckingAtRightLocation(false);
				this.endDuck();
			}
		}
		if(this.isInWaterWhileMoving()){
			this.setIsInWater(true);
			this.setWaterTime(this.getBeginTime()+time);
		}
		else if(this.isInMagma()){
			this.setInMagma(true);
			this.setWaterTime(this.getBeginTime()+time);
		}
		if(this.isImmune()){
			this.startTimeImmunity(this.getImmunityTime()+time);
		}
		if(!(this.isMovingX())){
		if(this.canFall() ){
			this.setIsFalling(true);
			this.setAccelerationY(-10);
		}
	}
		this.setCurrentSprite();
		doAction();
		if(this.isDead())
			this.getWorld().removeMazub(this);
	}

	
	
	/**
	 * A boolean checker to check if the alien stands on any game object.
	 * @return
	 *       Returns true if the alien,s  and sharks, x co-ordinate is same.
	 *       |if(this.hasSameXco(sharks))
	 *       |if(this.hasEqualyCo(sharks))
	 *       |return true;
	 * @return 
	 *       Returns true if and alien,s co-ordinates are equal to the slime,s co-ordinates.
	 *       |if(this.hasSameXco(slimes))
	 *       |if(this.hasEqualyCo(slimes))
	 *       |return true;
	 */
 	private boolean isAtObject() {
		for(Shark sharks:this.getWorld().getCollectionOfSharks()){
        if(this.hasSameXco(sharks)){
        	if(this.hasEqualyCo(sharks))
        		return true;
          }
		}
		for(Slime slimes:this.getWorld().getCollectionOfSlimes()){
			if(this.hasSameXco(slimes)){
				if(this.hasEqualyCo(slimes))
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks whether the alien stands o a solid terrain or not.
	 * @return
	 *       Returns true if the alien,s 2nd leftPixel and bottomY pixel represent a
	 *       a solid tile.
	 *       |if (world.isImpassablePassAble(this.getPixelLeftX()+2, this.getPixelBottomY())
	 *       |result = (true)
	 * @return
	 *        Return true if the alien,s 2nd last bottom right corner is located at a solid tile.
	 *       |if(world.isImpassablePassAble(this.getPixelLeftX() + this.getCurrentSprite().getWidth() - 2,
	 *		 |			this.getPixelBottomY() - 1))
	 *       |return true;
	 */
	private boolean isAtSolidterrain(){
		World world = this.getWorld();
		if (world.isImpassablePassAble(this.getPixelLeftX()+2, this.getPixelBottomY())
				|| world.isImpassablePassAble(this.getPixelLeftX() + this.getCurrentSprite().getWidth() - 3,
						this.getPixelBottomY() - 1) ||world.isImpassablePassAble(this.getPixelLeftX() + this.getCurrentSprite().getWidth() - 3,
								this.getPixelBottomY() - 1)
				&& !(world.isImpassablePassAble(this.getPixelLeftX() + 2, this.getPixelBottomY() + 1)))
			return true;
		else 
			return false;
	}
	

	
	
	
	
	
	
	
	
	
	/**
	 * A checker to check the alien stands in magma or not.
	 * @return 
	 *        Return true if and only if the alien,s bottom left Pixel x and bottom y pixel represents a tile 
	 *        containing water.
	 *        |if(world.isMagma(this.getPixelLeftX(), this.getPixelBottomY()+1))
	 *        |return true
	 */
	private boolean isInMagma(){
		World world = this.getWorld();
		if(world.isMagma(this.getPixelLeftX(), this.getPixelBottomY()+1)){
			return true;
		}
		return false;
	}
	
	
	/**
	 * A checker to check whether the alien stands in water.
	 * @return
	 *       Returns true if and only if the alien,s bottomLeftPixel and bottomY pixel represent a 
	 *       tile containing water.
	 *       |if(world.isWater(this.getPixelLeftX(),this.getPixelBottomY()+1))
	 *       |  return true;
	 */
	private boolean isInWaterWhileMoving() {
       World world = this.getWorld();
       if(world.isWater(this.getPixelLeftX(),this.getPixelBottomY()+1))
    	   return true;
		return false;
	}

	/**
     * A boolean checker to check whether alien can fall or not.
     * @return
     *       Return true if and only if alien,s bottom left Pixel is not located at solid terrain and alien,s bottom
     *       right pixel is not located at the solid terrain.
     *       |if(!(world.isImpassablePassAble(this.getPixelLeftX()+2, this.getPixelBottomY()) 
	 *       | && !(world.isImpassablePassAble(this.getPixelLeftX()+this.getCurrentSprite().getWidth()-2, this.getPixelBottomY())))
	 *       |return true
     */
	private boolean canFall() {
		World world = this.getWorld();
	if(!(world.isImpassablePassAble(this.getPixelLeftX()+2, this.getPixelBottomY()) 
	        && !(world.isImpassablePassAble(this.getPixelLeftX()+this.getCurrentSprite().getWidth()-3, this.getPixelBottomY()))) 
	        &&!(this.isAtObject())){
			return true;
		}
		return false;
	}

	
	
	/**
	 * A boolean checker to check whether the alien is dead or not.
	 * @return
	 *        Return true if and only if alien,s hit points are less or equal to zero.
	 *        | if(this.getNumberOfHitPoints() <= 0)
	 *        |return true;
	 */
	private boolean isDead() {
      if(this.getNumberOfHitPoints() <= 0)
    	  return true;
		return false;
	}

	/**
	 * A mutator to stop the alien at right and solid ground.
	 * @param pixelBottomY
	 *        The given y pixel of the alien.
	 * @param pixelLeftX
	 *        The given x pixel of the alien.
	 * @post. For each pixel of the tile if the alien,s bottom y pixel is located at a solid terrain
	 *        while the bottom y+1 pixel represents a pixel which does not represent a solid tile 
	 *        alien will be moved to that pixel, alien,s vertical acceleration will be zero.
	 *        |for (int i = pixelBottomY; i < pixelBottomY + world.getTileSize(); i++)
	 *        |if ((world.isImpassablePassAble(pixelLeftX + 2, i) 
	 *        |    && !(world.isImpassablePassAble(pixelLeftX + 2, i + 1)) && world.isImpassablePassAble(pixelLeftX + 2, i - 1))
	 *        |||(world.isImpassablePassAble(pixelLeftX + (width- 3), i) && !(world.isImpassablePassAble(
	 *		  |			pixelLeftX + (width - 3), i + 1))))
	 *        |this.setPixelBottomY(i)
	 *        |doAction();
	 *        |this.setAccelerationY(0);
	 */
	private void stopAtRightPixel(int pixelBottomY, int pixelLeftX) {
		World world = this.getWorld();
		int width = this.getCurrentSprite().getWidth();
		for (int i = pixelBottomY; i < pixelBottomY + world.getTileSize(); i++) {
			if ((world.isImpassablePassAble(pixelLeftX + 2, i) && !(world.isImpassablePassAble(pixelLeftX + 2, i + 1)) && world
					.isImpassablePassAble(pixelLeftX + 2, i - 1))
					|| (world.isImpassablePassAble(pixelLeftX + (width- 3), i) && !(world.isImpassablePassAble(
							pixelLeftX + (width - 3), i + 1)))) {
				this.setPixelBottomY(i);
				doAction();
				this.setAccelerationY(0);
				break;
			}
		}
	}

	/**
	 * A boolean checker to check whether alien is at right place to end duck.
	 * @return
	 *       Returns true if and only if the alien,s top rightCorner and alien,s top left Corner does 
	 *       not represent a solid tile.
	 *       |if ((world.isImpassablePassAble(this.getPixelLeftX() + (width - 2), this.getPixelBottomY() + (height - 2))))
	 *       |return true
	 *       |if ((world.isImpassablePassAble(this.getPixelLeftX(), this.getPixelBottomY() + (height - 1))))
	 *       |return true;
	 */
	private boolean isRightPlaceToEndDucking() {
		World world = this.getWorld();
		int width = this.sprites[0].getWidth();
		int height = this.sprites[0].getHeight();
		if ((world.isImpassablePassAble(this.getPixelLeftX() + (width - 2), this.getPixelBottomY() + (height - 2))))
			return false;
		if ((world.isImpassablePassAble(this.getPixelLeftX(), this.getPixelBottomY() + (height - 1))))
			return false;
		return true;
	}


	/**
	 * Updates the sprites according to the current state of the alien.
	 * 
	 * @pre... Time should be greater than the sprites time after which the
	 *         sprites should be updated. 
	 *         |this.spriteRunningNeedUpdate()
	 * @post... If the current index is less than the first value of the running
	 *          cycle or greater or equal to the first value of the running
	 *          cycle incremented with the number of sprites for the running
	 *          cycle incremented with one, the new index will be the first
	 *          value of the running cycle. |if ((this.getCurrentIndex() <
	 *          startRunningCycle) || | (this.getCurrentIndex() >=
	 *          (startRunningCycle + this.getRunningCycle() - 1)))
	 *          |this.setCurrentIndex(startRunningCycle)
	 * @post... If the current index is one of the indexes for the sprites of
	 *          the running cycle and not the last one, the new index will be
	 *          the current incremented with one. |if ((this.getCurrentIndex()
	 *          >= startRunningCycle) || (this.getCurrentIndex() <
	 *          (startRunningCycle + this.getRunningCycle() - 1)))
	 *          |this.setCurrentIndex(this.getCurrentIndex() + 1);
	 */
	private void updateSpriteRunning() {
		if (this.spriteRunningNeedUpdate()) {
			this.setSpriteRunningTime(0.0);
			int startRunningCycle = this.startRunningCycleRight();
			if (this.isMovingLeft()) {
				startRunningCycle = this.startRunningCycleLeft();
			}
			if ((this.getCurrentIndex() < startRunningCycle)
					|| (this.getCurrentIndex() >= (startRunningCycle + this.getRunningCycle() - 1))) {
				this.setCurrentIndex(startRunningCycle);
			} else {
				this.setCurrentIndex(this.getCurrentIndex() + 1);
			}
		}
	}

	/**
	 * Returns the number of sprites in the alien,s running cycle.
	 * 
	 * @return Returns the number of sprites in the alien,s running cycle
	 *         |result = (this.sprites.length-numberImagesNotRunning)/2)
	 */
	private int getRunningCycle() {
		return (this.sprites.length - numberImagesNotRunning) / 2;
	}

	/**
	 * Returns the number of the first sprite of the running cycle to right.
	 * 
	 * @return Returns the number of sprites while moving to the right side.
	 *         |result = (this.numberImagesNotRunning)
	 */
	private int startRunningCycleRight() {
		return this.numberImagesNotRunning;
	}

	/**
	 * Returns the number of the first sprite of the running cycle to left.
	 * 
	 * @return Returns the number of sprite while alien,s movement is to the
	 *         left side. |result =(this.numberImagesNotRunning +
	 *         getRunningCycle())
	 */
	private int startRunningCycleLeft() {
		return this.startRunningCycleRight() + getRunningCycle();
	}

	/**
	 * A private variable to store the number of sprite independent of the
	 * running cycles
	 */
	private final int numberImagesNotRunning = 8;

	/**
	 * A checker to check whether the sprite time is greater than the time to
	 * update the sprite.
	 * 
	 * @return Returns true if and only if the sprite time is greater than or
	 *         equal to 75 Mileseconds. |if (this.getSpriteRunningTime() >=
	 *         0.075) |return true;
	 */
	private boolean spriteRunningNeedUpdate() {
		if (this.getSpriteRunningTime() >= 0.075)
			return true;
		return false;
	}

	/**
	 * A setter to set the sprite running time.
	 * 
	 * @param time
	 *            The parameter time with which the variable spriteRuningTime
	 *            will be initialized.
	 * @post... The new running time of the sprites will be equal to the given
	 *          time. |new.spriteRunningTime = time
	 */
	private void setSpriteRunningTime(double time) {
		this.spriteRunningTime = time;
	}

	/**
	 * A getter to get the sprite time.
	 * 
	 * @return Returns the running time of the spriteS. |result
	 *         =(this.spriteRunningTime)
	 */
	@Basic
	private double getSpriteRunningTime() {
		return this.spriteRunningTime;
	}

	/**
	 * A private variable to store the running time of the sprites.
	 */
	private double spriteRunningTime;

	/**
	 * A setter to set the new vertical velocity of the alien.
	 * 
	 * @param acceleration
	 *            The given acceleration of the alien.
	 * @param time
	 *            Given time of the alien.
	 * @effect... The new vertical velocity of the alien will equal the new
	 *            velocity.
	 *            |this.setVelocityY(this.getVelocityY()+this.getAccelerationY
	 *            ()*this.getTime())
	 *
	 **/
	private void updateVelocityY(double acceleration, double time) {
		this.setVelocityY(this.getVelocityY() + this.getAccelerationY() * this.getTime());
	}

	/**
	 * A method to update the time by adding with the new time.
	 * 
	 * @param time
	 *            A variable time holding the value of the time.
	 * @pre.. The new time should be a valid time in order to update the old
	 *        time. |(isValidTime(this.getTime() + time)
	 * @post.. If the new time is a valid time and pre-condition is fulfilled
	 *         then the time will be equal to the new time. |this.setTime(time);
	 * @post... if the new time is not valid time but the old time is valid time
	 *          then old time will be equal to the new time. |new.time = time
	 * @throws InvalidActionException
	 *             Throws InvalidActionException if the new time is not a valid
	 *             time. |if (!(isValidTime(this.getTime() + time))) |throw new
	 *             InvalidActionException
	 *             ("Time is less than zero or time is greater than 0.2 second"
	 *             );
	 */
	private void updateTime(double time) throws InvalidActionException {
		try {
			if (!(isValidTime(this.getTime() + time)))
				throw new InvalidActionException("Time is less than zero or time is greater than 0.2 second");
			this.setTime(time);
		} catch (InvalidActionException exc) {
			if (isValidTime(this.getTime()))
				this.setTime(this.getTime());
			else
				throw exc;
		}
	}

	/**
	 * Updates the horizontal velocity of the alien.
	 * 
	 * @pre.. The new velocity of the alien should be a valid velocity in order
	 *        to update the current horizontal velocity of the alien.
	 *        |isValidVelocityX(this.getVelocityX() +
	 *        this.getAccelerationX()*this.getTime())
	 * @post.. if the pre condition is fulfilled and the new horizontal velocity
	 *         of the alien is a valid velocity then the velocity will be equal
	 *         to the new velocity. |setVelocityX(this.getVelocityX() +
	 *         this.getAccelerationX() * this.getTime())
	 * @post... if the horizontal velocity of the alien is less than the
	 *          maxvelocity-0.4 then the velocity will be equal to the max
	 *          velocity. |if(this.getVelocityX() > this.getMaxVelocityX()-0.4)
	 *          |this.setVelocityX(this.getMaxVelocityX())
	 * @throws InvalidActionException
	 *          Throws InvalidActionException if the new velocity of the
	 *          alien is not a valid velocity.
	 *           |if(!(isValidVelocityX(this.getVelocityX() +
	 *           |this.getAccelerationX()*this.getTime()))) |throw new
	 *           |InvalidActionException("Not a valid velocity");
	 */
	private void updateVelocityX(double acceleration, double time) throws InvalidActionException {
		try {
			if (!(isValidVelocityX(this.getVelocityX() + acceleration * time)))
				throw new InvalidActionException("Not a valid velocity");
			setVelocityX(this.getVelocityX() + acceleration * time);
		} catch (InvalidActionException exc) {
			if (this.getVelocityX() > this.getMaxVelocityX() - 0.4)
				this.setVelocityX(this.getMaxVelocityX());
			else
				throw exc;
		}
	}

	/**
	 * Check whether the given time is valid or not.
	 * 
	 * @param time
	 *            A time variable to be checked.
	 * @return returns true if and only if the time is greater or equal to zero
	 *         and less then 0.2 |if(time >= 0) | return true |if(time < 0.2) |
	 *         return true
	 */
	private boolean isValidTime(double time) {
		return ((time >= 0) && (time < 0.2));
	}

	/**
	 * A setter to initialize the variable time.
	 * 
	 * @param time
	 *            A variable holding the new value of the variable time.
	 * @post.. The new value of the variable time will be equal to the given
	 *         value. |new.time = time
	 */
	private void setTime(double time) {
		this.time = time;
	}

	/**
	 * A getter to get the current time.
	 * 
	 * @return Returns the current time. |result = (this.time)
	 */
	@Basic
	private double getTime() {
		return this.time;
	}

	/**
	 * A private variable to register the current time.
	 */
	private double time;
	
	
	
	/**
	 * A private variable to store the hitPoints of the alien.
	 */
	private int numberOfHitPoints;
	
	
	
	/**
	 * A private variable to store the value of the world.
	 */
	private World world;

	/**
	 * A setter to set and update the hitPoints of the alien.
	 * @param hitPoints
	 *        The given number of hitPoints.
	 * @pre.  In order to update the hitPoints , hitpoints should be valid hitPoints.
	 *        |if(isValidHitPoints(hitPoints))
	 * @post. New hitPoints of the alien will be equal to the current plus
	 *        new hitpoints.
	 *        |new.numberOfHitPoints += hitPoints
	 */
	private void setNumberOfHitPoints(int hitPoints) {
		if(isValidHitPoints(hitPoints))
		this.numberOfHitPoints = hitPoints;
	}

	/**
	 * A checker to check whether the given hitPoints are valid or not.
	 * @param hitPoints
	 *        The given hit points of the alien.
	 * @return True if and only the the total hitPoints are less than the maximumNumber Of
	 *         hit points.
	 *         |return (hitPoints <= this.getMaxHitPoints())
	 *        
	 */
	private boolean isValidHitPoints(int hitPoints){
	   return (hitPoints <= this.getMaxHitPoints());
	}

	/**
	 * A getter to get the number of hitpoints.
	 * @return
	 *       Return the number of hit points of the alien.
	 *       |result = (this.numberOfHitPoints)
	 */
	public int getNumberOfHitPoints() {
		return this.numberOfHitPoints;
	}

	/**
	 * A setter to set the world of the alien.
	 * @param world
	 *        The given world of the alien.
	 * @post. New refernce of the world will be equal to the given worlds reference.
	 *        |this.world = world
	 */
	public void setWorld(World world) {
		this.world = world;
	}

	

    /**
     * Checks whether alien,s parameters collide with other objects.
     * @param i
     *        The x pixel of the alien.
     * @param j
     *        The y pixel of the alien.
     * @param distanceToMove
     *        Total distance to move on x co.
     * @return
     *        Returns true if and only if the alien
     *        collides with sharks or slimes.
     *        | if(this.collideX(slimes)) ||(this.collideX(sharks))
     *        |return true;
     */
	private boolean collideWithOtherObject(int i, int j, int distanceToMove) {
      for(Slime slimes: this.getWorld().getCollectionOfSlimes()){
    	  if(this.collideX(slimes))
    		  return true;
      }
      for(Shark sharks: this.getWorld().getCollectionOfSharks()){
    	 if(this.collideX(sharks))
			  return true;
        }
		return false;
}

	/**
	 *  A boolean checker whether two objects have same y co-ordinate.
	 * @param object
	 *        The given object whose co-ordinates must be checked.
	 * @return
	 *        Returns true if for every pixel from the bottom to top, any pixel of given object
	 *        is equal to the alien,s pixel.
	 *        |for (int firstY = firstBottomY; firstY < firstTopY; firstY++)
	 *        |for (int secondY = secondBottomY; secondY < secondTopY; secondY++)
	 *        |if (firstY == secondY)
	 *        |return true;
	 */
	public boolean hasEqualyCo(WorldObjects object) {
		int firstBottomY = this.getPixelBottomY();
		int firstTopY = firstBottomY + this.getCurrentSprite().getHeight() - 1;
		int secondBottomY = object.getPixelBottomY();
		int secondTopY = secondBottomY + object.getCurrentSprite().getHeight() - 1;
		for (int firstY = firstBottomY; firstY < firstTopY; firstY++) {
			for (int secondY = secondBottomY; secondY < secondTopY; secondY++) {
				if (firstY == secondY)
					return true;
			}
		}
		return false;
  }

	
    /**
     * A boolean checker to check whether an alien can eat plant.
     * @return
     *        Returns true if and only if totalNumberOfHitPoints+newHitPoints are less than 
     *        maximumNumber of HitPoints.
     *        |if (this.getNumberOfHitPoints()+50 <= this.getMaxHitPoints())
     *        |return true
     */
	public boolean canEat() {
		if (this.getNumberOfHitPoints()+50 <= this.getMaxHitPoints())
			return true;
		return false;
	}

	

	
	
	
	
	
	
	
	
	
	


	/**
	 * A checker to check whether the objects have same x co-ordinates.
	 * @param object
	 *        The given object whose x co-ordinate will be compared with alien,s x co-ordinate.
	 * @return. if the alien is moving to the right and alien,s bottom right pixel is equal to the 
	 *           object,s leftpixel, it return true.
	 *          |if(this.getPixelLeftX()+this.getCurrentSprite().getWidth()-1 == object.getPixelLeftX())
	 *          |return true;
	 * @return. if the alien,s left pixel is equal to the object,s left pixel then it returns true
	 *          |else if(this.getPixelLeftX() == object.getPixelLeftX())
	 *          |return true
	 * @return  if the alien,s left pixel is smaller than then object,s left pixel and objects left pixel is less than
	 *          alien,s bottom right pixel then it returns true.
	 *          |else if(this.getPixelLeftX() < object.getPixelLeftX() && object.getPixelLeftX() < this.getPixelLeftX()+this.getCurrentSprite().getWidth())
	 *          |return true
	 * @return  if the alien is moving to the left and alien,s 2nd leftPixel is equal to the object,s right pixel then it
	 *          return true.
	 *          |if(this.getPixelLeftX()+1 == object.getPixelLeftX()+object.getCurrentSprite().getWidth()-1)
	 *          |return true;
	 * @return  if the alien,s 2nd leftPixel is equal to object,s left pixel then it returns true.
	 *          |else if(this.getPixelLeftX()+1 == object.getPixelLeftX())
	 *          |return true
	 * @return  if the object,s left pixel is less than the alien,s 2nd left pixel and object,s bottom right pixel is greater
	 *          than alien,s bottom right pixel than it return true.
	 *          |else if( object.getPixelLeftX() < this.getPixelLeftX()+1 && object.getPixelLeftX()+object.getCurrentSprite().getWidth()-1 > this.getPixelLeftX())
     *          |return true;
	 */
	protected boolean hasSameXco(WorldObjects object) {
		if(this.isMovingRight()){
			if(this.getPixelLeftX()+this.getCurrentSprite().getWidth()-1 == object.getPixelLeftX())
				return true;
			else if(this.getPixelLeftX() == object.getPixelLeftX())
				return true;
			else if(this.getPixelLeftX() < object.getPixelLeftX() && object.getPixelLeftX() < this.getPixelLeftX()+this.getCurrentSprite().getWidth())
		     return true;
		}
		else if(this.isMovingLeft()){
			if(this.getPixelLeftX()+1 == object.getPixelLeftX()+object.getCurrentSprite().getWidth()-1)
				return true;
			else if(this.getPixelLeftX()+1 == object.getPixelLeftX())
				return true;
			else if( object.getPixelLeftX() < this.getPixelLeftX()+1 && object.getPixelLeftX()+object.getCurrentSprite().getWidth()-1 > this.getPixelLeftX())
				return true;
		}
		else {
			if(this.getPixelLeftX()+this.getCurrentSprite().getWidth()-1 == object.getPixelLeftX())
				return true;
			else if(this.getPixelLeftX() == object.getPixelLeftX())
				return true;
			else if(this.getPixelLeftX() < object.getPixelLeftX() && object.getPixelLeftX() < this.getPixelLeftX()+this.getCurrentSprite().getWidth())
		     return true;
			else if( object.getPixelLeftX() < this.getPixelLeftX()+1 && object.getPixelLeftX()+object.getCurrentSprite().getWidth()-1 > this.getPixelLeftX())
				return true;
		}
			return false;
	}
	

	/**
	 * Checks whether an oject collides with this object.
	 * @param object
	 *        The given object with which this object will be compared.
	 * @post. Checks whether the objects have same x Co-ordinates.
	 *        |hasSameXco(object)
	 * @post. if two objects have same x co-ordinates then it checks whether two object have same 
	 *        y co-ordinate by running over all pixels.
	 *        |for (int firstY = firstBottomY; firstY < firstTopY; firstY++) 
	 *        |for (int secondY = secondBottomY; secondY < secondTopY; secondY++)
	 * @return
	 *        Returns true if and only if the both objects have same y co-ordinates.
	 *        |if (firstY == secondY)
	 *        |return true;
	 */
	protected boolean collideX(WorldObjects object) {
		if (hasSameXco(object)) {
			int firstBottomY = this.getPixelBottomY();
			int firstTopY = firstBottomY + this.getCurrentSprite().getHeight() - 1;
			int secondBottomY = object.getPixelBottomY();
			int secondTopY = secondBottomY + object.getCurrentSprite().getHeight() - 1;
			for (int firstY = firstBottomY; firstY < firstTopY; firstY++) {
				for (int secondY = secondBottomY; secondY < secondTopY; secondY++) {
					if (firstY == secondY)
						return true;
				}
			}
		}
		return false;
	}

	/**
	 * A private final variable to store the number of hitpoints.
	 */
	private final int maxNumberOfHitPoints = 500;

	/**
	 * A getter to get the max number of hit points of the alien.
	 * @return
	 *       Return the max Number of hitpoints of the alien.
	 *       |result = (this.maxNumberOfHitPoints)
	 */
	private int getMaxHitPoints() {
		return this.maxNumberOfHitPoints;
	}

	/**
	 * Returns a distance to jumpin in vertical direction.
	 * @param x
	 *        The x co-ordianate of the alien.
	 * @param y
	 *        The y co-ordinate of the alien.
	 * @param distanceToJump
	 *        The maximum distance to jump.
	 * @param world
	 *        The given world of the object alien.
	 * @post.. checks for all pixels next to the top left corner of the alien,s sprite and if it detects the 
	 *         impassablePlant then it returns the calculated distance wich in every case is equal or less than the max 
	 *         distance.
	 *         |if (world.isImpassablePassAble(x+2, i))
	 *		   |return dist;
	 * @post.. Checks for all pixel next to the top right corner of the alien,s sprite and it it detects an impassbale
	 *         plane it will return the calculated distance which is less or equal to the max distance.
	 *         |if (world.isImpassablePassAble(x + (width - 3), i))
	 *         |return dist
	 * @return
	 *        Returns the valid distance to jump for alien.
	 *        |result = (dist)
	 */
	@Basic
	private int getPositionToJump(int x, int y, int distanceToJump, World world) {
		int height = this.getCurrentSprite().getHeight();
		int width = this.getCurrentSprite().getWidth();
		int dist = 0;
		for (int i = ((y + 1) + (height - 2)); i < ((y + 1) + height + distanceToJump); i++) {
			if (world.isImpassablePassAble(x+2, i))
				return dist;
			if (world.isImpassablePassAble(x+2, i))
				break;
			if (world.isImpassablePassAble(x + (width - 3), i))
				return dist;
			if (world.isImpassablePassAble(x + (width - 3), i))
				break;
			dist++;
		}
		return distanceToJump;
	}

}

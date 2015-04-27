package jumpingalien.model;

import java.util.Random;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Model;
import jumpingalien.util.Sprite;

    /**
     * 
     * @author Niels van Belle & Afraz Salim
     * version 2.0
     *
     */
public class Shark extends Enemy {
	/**
	 * 
	 * @param x
	 * 		The left x co of the new shark
	 * @param y
	 * 		The bottom y co of the new shark
	 * @param sprites
	 * 		The array of sprites of the new shark
	 * @effect super(x, y, sprites)
	 * @post new.getInitialVelocityX() == 0
	 * @post new.getMaxVelocityX() == 4
	 * @post new.getInitialAccelerationX() == 1.5
	 * @post new.getNumberOfPossibleActionsX() == 4
	 * @post new.getMinimumActionTime() == 1
	 * @post new.getMaximumActionTime() == 4
	 * @post new.getHitPoints() == 100
	 * @post new.getNumberOfActionsAfterJump() == 4
	 */
	public Shark(int x, int y, Sprite[] sprites) {
		super(x, y, sprites);
		this.setInitialVelocityX(0.0);
		this.setMaxVelocityX(4.0);
		this.setInitialAccelerationX(1.5);
		this.setNumberOfPossibleActions(4);
		this.setMinimumActionTime(1.0);
		this.setMaximumActionTime(4.0);
		this.setHitPoints(100);
		this.setNumberOfActionsAfterJump(4);
	}
	
	/**
	 * 
	 * @param numberOfActions
	 * 			The current number of actions after the last jump of this shark
	 * @post new.getNumberOfActionsAfterJump() == numberOfActions
	 */
	private void setNumberOfActionsAfterJump(int numberOfActions) {
		this.numberOfActionsAfterJump = numberOfActions;
	}
	
	/**
	 * 
	 * Return the current number of actions after the last jump of this shark
	 */
	@Basic @Model
	private int getNumberOfActionsAfterJump() {
		return this.numberOfActionsAfterJump;
	}
	
	/**
	 * Variable registering the current number of actions after the last jump of this shark
	 */
	private int numberOfActionsAfterJump;
	
	private void updateAction() {
		if (this.actionNeedUpdate()) {
			this.setActionTime(0.0);
			this.setCurrentActionTime(this.getRandomCurrentActionTime());
			if (this.isJumping()) {
				this.stopJumping();
			}
			int geoBottom ;
			geoBottom = this.getBottomGeologicalfeature();
			if ( (geoBottom == AIR) || (geoBottom == MAGMA) ) {
				if (!(this.isFalling())) {
					this.startFall();
				}
			} 
			else {
				int geoMain ;
				geoMain = this.getMainGeologicalfeature();
				int action = this.getRandomAction();
				if (action < 2) {
					this.setVelocityY(0.0);
					if (geoMain == WATER) {
						Random rndAction = new Random();
						double accY = 0.4 * rndAction.nextDouble() - 0.2;
						this.setAccelerationY(accY);
					}
					else {
						this.setAccelerationY(0.0);					
					}
				}
				else {
					this.setInitialVelocityY(2.0);
					this.setInitialAccelerationY(0);
				}
				this.startAction(action);				
			}
			if (this.isJumping()) {
				this.setNumberOfPossibleActions(2);
				this.setNumberOfActionsAfterJump(0);
			}
			else {
				this.setNumberOfActionsAfterJump(this.getNumberOfActionsAfterJump() + 1);
				if (this.getNumberOfActionsAfterJump() > 4)
					this.setNumberOfPossibleActions(4);
			}
		}
	}

	private void advanceTime(double timee, World world) {
		double time = timee;
		double timePast = timee;
		double dt;
		int hitPoints = 0;
		
		this.updateTime(time);
		this.setWorld(world);
		while (timePast > 0.0) {
			if (!this.isDeath()) {
				hitPoints = 0;		
				int geoMain = this.getMainGeologicalfeature();
				this.setPassableDirections();
				
				if (!(this.isJumping()) && (this.getTopGeologicalfeature() != WATER)) {
					this.setAllowedUp(false);
				}			
				if (this.isFalling()) {
					if ( (this.getBottomGeologicalfeature() == GROUND) || (this.getTopGeologicalfeature() == WATER) ) {
						this.stopFall();
					}
				}
				// top air/magma and bottom water
				//				if ( (!this.isJumping()) && (!this.isFalling()) && ((this.getBottomGeologicalfeature() == AIR) || (this.getBottomGeologicalfeature() == MAGMA)) ) {
				if ( (!this.isFalling()) && ((this.getBottomGeologicalfeature() == AIR) || (this.getBottomGeologicalfeature() == MAGMA)) ) {
					this.startFall();
				}
				for (Shark shark: world.getCollectionOfSharks()) {
					hitPoints += this.checkCollision(shark,0);
				}
				dt = this.getMinimumDt(timePast);
				this.setImmuneTime(this.getImmuneTime() + dt);
				if (this.getImmuneTime() >= 0.2)
					this.setIsImmune(false);
				if ( ((geoMain == MAGMA) || (geoMain == AIR)) && !this.isImmune()) {
					// timer voor air ?
					hitPoints -= 6;
				}
				hitPoints += this.checkCollision(world.getMazub(),-50);
				for (Slime slime: world.getCollectionOfSlimes()) {
					hitPoints += this.checkCollision(slime,-50);
				}
				this.isHit(hitPoints);

				this.updateLocationAndVelocity(dt);
				this.setActionTime(this.getActionTime() + dt);
			}
			else {
				dt = timePast;
				this.setTimeDeath(this.getTimeDeath() + dt);
				if (this.getTimeDeath() >= 0.6)
					world.setInvisibleWorldObject(this);				
			}
			timePast = timePast - dt;
		}
	}

	/**
	 * 
	 * @param timee
	 * 			The time for the calculations and updates for this shark
	 * @param world
	 * 			The world for this shark
	 * @effect advanceTime(timee, world)
	 * @effect updateAction()
	 */
	public void advanceTimeShark(double timee, World world) {
		advanceTime(timee, world);
		updateAction();
	}
}



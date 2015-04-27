package jumpingalien.model;

import be.kuleuven.cs.som.annotate.Model;
import jumpingalien.util.Sprite;

public class Plant extends Food {
	
	/**
	 * 
	 * @param x
	 * 		The left x co for the new plant
	 * @param y
	 * 		The bottom y co for the new plant
	 * @param sprites
	 * 		The array of sprites for the new plant
	 * @effect super(x, y, sprites)
	 * @post new.getInitialVelocityX() == 0.5
	 * @post new.getMaxVelocityX() == 0.5
	 * @post new.getInitialAccelerationX() == 0
	 * @post new.getCurrentActionTime() == 0.5
	 * @post new.getNumberOfPossibleActions() == 2
	 * @effect startAction(1)
	 * @post new.getHitPoints() == 1 
	 */
	public Plant(int x, int y, Sprite[] sprites) {
		super(x, y, sprites);
		this.setInitialVelocityX(0.5);
		this.setMaxVelocityX(0.5);
		this.setInitialAccelerationX(0.0);
		this.setCurrentActionTime(0.5);
		this.setNumberOfPossibleActions(2);
		this.startAction(1);
		this.setHitPoints(1);
	}
	
	/**
	 * @post if this.actionNeedUpdate()
	 * 			then new.getActionTime() == 0
	 * 				if this.isMovingLeft()
	 * 					then new.isMovingRight()
	 * 				else
	 * 					then new.isMovingLeft()
	 */
	@Model
	private void updateAction() {
		if (this.actionNeedUpdate()){
			this.setActionTime(0.0);
			if (this.isMovingLeft()) {
				this.startMoveRight();
			}
			else {
				this.startMoveLeft();
			}
		}
	}
	
	/**
	 * 
	 * @param timee
	 * 			The time for the calculations and updates for this plant
	 * @param world
	 * 			The world for this plant
	 * @effect updateTime(time)
	 * @post new.getWorld() == world
	 * @effect while timee > 0
	 * 				if !this.isDeath()
	 * 					then setPassableDirections()
	 * 						isHit(checkCollision(world.getMazub(),-1))
	 * 						updateLocationAndVelocity(this.getMinimumDt(timee))
	 * 						setActionTime(this.getActionTime() + this.getMinimumDt(timee))
	 * 						timee -= this.getMinimumDt(timee)
	 * 				else
	 * 					then setTimeDeath(this.getTimeDeath() + timee)
	 * 						timee == 0
	 * 						if this.getTimeDeath() >= 0.6
	 * 							then world.setInvisibleWorldObject(this)
	 */
	@Model
	private void advanceTime(double timee, World world) {
		double time = timee;
		double timePast = timee;
		double dt;
		int hitPoints = 0;
		this.updateTime(time);
		this.setWorld(world);
		while (timePast > 0.0) {
			if (!this.isDeath()) {
				hitPoints = 0 ;
				this.setPassableDirections();
				dt = this.getMinimumDt(timePast);
				if (world.getMazub().canEat()) {
					hitPoints += this.checkCollision(world.getMazub(),-1);
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
	 * 			The time for the calculations and updates for this plant
	 * @param world
	 * 			The world for this plant
	 * @effect advanceTime(timee, world)
	 * @effect updateAction()
	 */
	public void advanceTimePlant(double timee, World world) {
		this.advanceTime(timee, world);
		this.updateAction();
	}
	
}
package jumpingalien.model;

import jumpingalien.util.Sprite;
import be.kuleuven.cs.som.annotate.Basic;

/**
 * 
 * @author Niels Van Belle & Afraz Salim
 * @version 2.0
 * 
 * @invar isValideSchool(school)
 */
public class Slime extends Enemy {

	/**
	 * 
	 * @param x
	 * 		The left x co of the new slime 
	 * @param y
	 * 		The bottom y co of the new slime
	 * @param sprites
	 * 		The array of sprites of the new slime
	 * @param school
	 * 		The school of the new slime
	 * @effect super(x, y, sprites)
	 * @post new.getInitialVelocityX() == 0
	 * @post new.getMaxVelocityX() 2.5
	 * @post new.getInitialAccelerartionX() == 0.7
	 * @post new.getSchool() == school
	 * @effect school.addToSchool(this)
	 * @post new.getNumberOfPossibleActions() == 2
	 * @post new.getMinimumActionTime() == 2
	 * @post new.getMaximumActionTime() == 6
	 * @post new.getHitPoints() == 100
	 */
	public Slime(int x, int y, Sprite[] sprites, School school) {
		super(x, y, sprites);
		this.setInitialVelocityX(0.0);
		this.setMaxVelocityX(2.5);
		this.setInitialAccelerationX(0.7);
		this.setSchool(school);
		school.addToSchool(this);
		this.setNumberOfPossibleActions(2);
		this.setMinimumActionTime(2.0);
		this.setMaximumActionTime(6.0);
		this.setHitPoints(100);
	}

	/**
	 * 
	 * Return the current school of this slime
	 */
	@Basic
	public School getSchool() {
		return school;
	}

	/**
	 * 
	 * @param school
	 * 			The new school of this slime
	 * @pre school.isValideNumberOfSchools()
	 * @post new.getSchool() == school
	 */
	public void setSchool(School school) {
		this.school = school;
	}
	
	/**
	 * Variable registering the current school of the slime
	 */
	private School school;
	
	private void updateHitPointsChangeSchool(Slime slime, int firstSize, int secondSize) {
		for(Slime slimes: slime.getSchool().getSlimesOutOfSchool()){
			slimes.setHitPoints(slimes.getHitPoints() + 1);
		}
		slime.setHitPoints(slime.getHitPoints() - secondSize);
		School school = slime.getSchool();
		slime.getSchool().removeFromSchool(slime);
		if (school.sizeOfSchool() <= 0) {
		    school = null;
		    School.setNumberOfschools(School.getNumberOfschools() - 1);
		}
		this.getSchool().addToSchool(slime);
		for (Slime slimes: slime.getSchool().getSlimesOutOfSchool()){
			slimes.setHitPoints(slimes.getHitPoints() - 1);
		}
		slime.setHitPoints(slime.getHitPoints() + firstSize);
	}
	/**
	 * @effect if (this.actionNeedUpdate())
	 * 			then setActionTime(0)
	 * 				setCurrentActionTime(this.getRandomCurrentActionTime())
	 * 				startAction(this.getRandomAction())
	 */
	private void updateAction() {
		if (this.actionNeedUpdate()) {
			this.setActionTime(0.0);
			this.setCurrentActionTime(this.getRandomCurrentActionTime());
			this.startAction(this.getRandomAction());
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
				if (this.isFalling()) {
					if ( this.getBottomGeologicalfeature() == GROUND ) {
						this.stopFall();
					}
				}
				if ( (!this.isFalling()) && (!(this.getBottomGeologicalfeature() == GROUND)) ) {
					this.startFall();
				}
				for (Slime slime: world.getCollectionOfSlimes()) {
					if (this.checkCollision(slime,1) == 1) {
						if (!this.getSchool().equals(slime.getSchool())) {
							int firstSize = this.getSchool().sizeOfSchool();
							int secondSize = slime.getSchool().sizeOfSchool();
							if (firstSize > secondSize) {
								this.updateHitPointsChangeSchool(slime, firstSize, secondSize);
							}
							else if (secondSize > firstSize) {
								slime.updateHitPointsChangeSchool(this, secondSize, firstSize);
							}	
						}	
					}
				}
				dt = this.getMinimumDt(timePast);
				this.setImmuneTime(this.getImmuneTime() + dt);
				if (this.getImmuneTime() >= 0.6)
					this.setIsImmune(false);
				if ( ((geoMain == MAGMA) || (geoMain == WATER)) && !this.isImmune()) {
					hitPoints -= 6;
				}
				hitPoints += this.checkCollision(world.getMazub(),-50);
				for (Shark shark: world.getCollectionOfSharks()) {
					hitPoints += this.checkCollision(shark,-50);
				}
				this.isHit(hitPoints+1);
				if (hitPoints < 0) {
					for (Slime slimes: this.getSchool().getSlimesOutOfSchool())
						slimes.setHitPoints(slimes.getHitPoints() - 1);
				}
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
	 * 			The time for the calculations and updates for this slime
	 * @param world
	 * 			The world for this slime
	 * @effect advanceTime(timee, world)
	 * @effect updateAction()
	 */
	public void advanceTimeSlime(double timee, World world) {
		this.advanceTime(timee, world);
		this.updateAction();
	}
	

	
}
	
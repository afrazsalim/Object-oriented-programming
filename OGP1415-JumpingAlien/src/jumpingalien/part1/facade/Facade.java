package jumpingalien.part1.facade;

import jumpingalien.model.Mazub;
import jumpingalien.util.ModelException;
import jumpingalien.util.Sprite;
import be.kuleuven.cs.som.annotate.Basic;

public class Facade implements IFacade {

	@Override
	public Mazub createMazub(int pixelLeftX, int pixelBottomY, Sprite[] sprites) {
		Mazub mazub = new Mazub(pixelLeftX, pixelBottomY, sprites);
		return mazub;
	}
	
	@Basic
	@Override
	public int[] getLocation(Mazub alien) {
		return alien.getLocation();
	}

	@Override
	public double[] getVelocity(Mazub alien) {
		return alien.getVelocity();
	}

	@Override
	public double[] getAcceleration(Mazub alien) {
		return alien.getAcceleration();
	}

	@Override
	public int[] getSize(Mazub alien) {
		return alien.getSize();
	}

	@Override
	public Sprite getCurrentSprite(Mazub alien) {
		return alien.getCurrentSprite();
	}

	@Override
	public void startJump(Mazub alien) {
		alien.jump();
	}

	@Override
	public void endJump(Mazub alien) {
		alien.endJump();
	}

	@Override
	public void startMoveLeft(Mazub alien) {
		alien.startMoveLeft();
		
	}

	@Override
	public void endMoveLeft(Mazub alien) {
		alien.endMoveLeft();
		
	}

	@Override
	public void startMoveRight(Mazub alien) throws ModelException{
		alien.startMoveRight();
	}

	@Override
	public void endMoveRight(Mazub alien) {
		alien.endMoveRight();
		
	}

	@Override
	public void startDuck(Mazub alien) {
		alien.startDuck();
	}

	@Override
	public void endDuck(Mazub alien) {
		alien.endDuck();
	}

	@Override
	public void advanceTime(Mazub alien, double dt) {
		// TODO Auto-generated method stub
		
	}
}

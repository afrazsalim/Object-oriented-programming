package jumpingalien.model;

import java.util.ArrayList;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Model;
  /**
   * 
   * @author Afraz Salim and Niels van Belle
   * version 2.0
   *
   */
public class School implements Cloneable {

	/**
	 * A constructor to create the school.
	 * @post new.getSlimesOutOfSchool() == {}
	 */
	public School() {
		school = new ArrayList<Slime>();
		setNumberOfschools(getNumberOfschools() + 1);
	}

	/**
	 * 
	 * @param numberOfSchools
	 * 			The new number of schools
	 * @post new.getNumberOfSchools() == numberOfSchools
	 */
	public static void setNumberOfschools(int numberOfSchools){
		School.numberOfschools= numberOfSchools;
	}
	
	/**
	 * 
	 * Return the current number of schools
	 */
	@Basic
	public static int getNumberOfschools(){
		return School.numberOfschools;
	}
	
	/**
	 * Variable registering the current number of schools 
	 */
	private static int numberOfschools;
	
	/**
	 * 
	 * @param slime
	 * 			The slime that need to be add to this school
	 * @post slime.getSchool() == this
	 * @effect school.add(slime)
	 */
	public void addToSchool(Slime slime) {
		slime.setSchool(this);
		this.school.add(slime);
	}
	
	/**
	 * 
	 * @param slime
	 * 			The slime that need to be removed from this school
	 * @post slime.getSchool() == null
	 * @effect school.remove(slime)
	 */
	public void removeFromSchool(Slime slime) {
		slime.setSchool(null);
		this.school.remove(slime);
	}
	
	/**
	 * 
	 * @return result == (this.school.size())
	 */
	public int sizeOfSchool(){
		return this.school.size();
	}
	
	/**
	 * Return a clone of this School.
	 * 
	 * @return The resulting School is the same as this School
	 *         if and only if this School is immutable.
	 *       | (result == this) == (! this.isMutable())
	 */
	@Override
	public School clone() {
		try {
				return (School) super.clone();
		} catch (CloneNotSupportedException exc) {
			assert false;
			return null;
		}
	}
	
	
	/**
	 * 
	 * @return result ==  (this.school.clone())
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Slime> getSlimesOutOfSchool(){
		return (ArrayList<Slime>) this.school.clone();
	}
	
	/**
	 * Variable registering an array of slimes in this school
	 */
	@Model
	private ArrayList<Slime> school;

}

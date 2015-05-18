package gna;
/**
 * 
 * @author Afraz Salim
 *
 */
public class Edge {

	/**
	 * A private variable to store the value of the vertex from which the edge is added.
	 */
	private int from;
	/**
	 * A private variable to store the value to which the edge is added.
	 */
	private int to;
	/**
	 * A private variable to hold the weight of the edge.
	 */
	private double weight;

	/**
	 * A constructor to initialize the Edge.
	 * @param i
	 *        The given vertex from which the vertex need to be added.
	 * @param j
	 *        The given vertex to which the vertex need to be added.
	 * @param weight
	 *        The weight of the new edge.
	 * @effect 
	 *        The new vertex of the new edge will be equal to the given vertex.
	 *        |new.getFrom() = i
	 * @effect
	 *        The new vertex to which the edge will be added, will be equal to the given vertex.
	 *        |new.getTo() = j
	 * @effetc 
	 *        The weight of the newly created edge will be equal to the given weight.
	 *        |new.getWeight() = weight.
	 */
	public Edge(int i, int j, double weight) {
     this.setFrom(i);
     this.setTo(j);
     this.setWeight(weight);
	}

	/**
	 * A getter to get the vertex from which te edge is added.
	 * @return
	 *       Returns the vertex from which the edge is added.
	 *       |result = (from)
	 */
	public int getFrom() {
		return from;
	}

	/**
	 * A setter to set the vertex from which the edge will be added.
	 * @param from
	 *        The given vertex from which the edge will be added.
	 * @post. 
	 *        The new vertex from which the edge is added will be equal to the given vertex.
	 *        |this.from = from;
	 */
	public void setFrom(int from) {
		this.from = from;
	}

	/**
	 * A getter to get the weight of the edge.
	 * @return
	 *        Returns the weight of the edge.
	 *        |result = (weight)
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * A setter to set the weight of the edge.
	 * @param weight
	 *        The given weight of the edge.
	 * @effect.
	 *        The new weight of the edge will be equal to the given weight.
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * A getter to get the vertex to which the edge is added.
	 * @return
	 *        Returns the vertex to which the vertex is added.
	 *        |result = (to)
	 */
	public int getTo() {
		return to;
	}

	/**
	 * A setter to set the vertex to which the edge will be added.
	 * @param to
	 *        The vertex to which the edge will be added.
	 * @post 
	 *        The new vertex to which the edge will be added is equal to the given vertex.
	 *        |this.to = to;
	 */
	public void setTo(int to) {
		this.to = to;
	}
	

}

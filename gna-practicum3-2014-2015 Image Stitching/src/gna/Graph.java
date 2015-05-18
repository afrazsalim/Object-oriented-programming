package gna;

import libpract.Position;

/**
 * 
 * @author Afraz Salim
 * @version 1.0
 *
 */
public class Graph {

	/**
	 * A private variable holding the values of first image.
	 */
	private int [][] image1;
	/**
	 * A priavet variable to hold the values of second image.
	 */
	private int [][] image2;
	/**
	 * An array to be initialized the all given positions.
	 */
	private Position[][] positions;
	/**
	 * Adjacency array holds all the adjacent edges with given index.
	 */
	private Bag<Edge> [] adj;
	
	/**
	 * Constructor to initialize the graph.
	 * @param image1
	 *        The given first image.
	 * @param image2
	 *        The given second image.
	 * @param positions
	 *        An array containing all the positions to be initialized.
	 * @post. 
	 *        Initializes the first image.
	 *        |this.image1 = image1;
	 * @post. Initializes the second image.
	 *        |this.image2 = image2;
	 * @post. For each position in the adjacency list, creates a new bag.
	 *        |adj[i*image1[0].length+j] = new Bag<Edge>();
	 */
	public Graph(int[][] image1, int[][] image2, Position[][] positions) {
		this.image1 = image1;
		this.image2 = image2;
		this.positions = positions;
		 adj = (Bag<Edge>[]) new Bag[image1.length*image1[0].length];
	        for (int i = 0; i < image1.length; i++) {
	        	for(int j = 0; j< image1[0].length;j++){
		            adj[i*image1[0].length+j] = new Bag<Edge>();
	        	}
	        }
		this.createGraph();
	}
	
	
	
	
	/**
	 * creates a new 8-way connected graph by adding all the possible edges between the vertices.
	 * |for each vertex(x.....endX-1)
	 * | for each vertex(y..... endY-1)
	 * |this.addEdges(x*image1[0].length+y,i,j);
	 */
	private void createGraph() {
		for(int i = 0; i < image1.length;i++){
			for(int j = 0; j< image1[0].length;j++){
				this.addEdges(i*image1[0].length+j,i,j);
			}
		}
		
	}
	
	/**
	 * Adds all the possible edge between the vertices.
	 * @param v
	 *        The given vertex.
	 * @param i
	 *        The given x co-ordinate of the vertex.
	 * @param j
	 *        The given y co-ordinate of the vertex.
	 * @post..
	 *        Checks for all possible vertices(bottom, up, left, right, topRight, topLeft,bottomRight, bottomLeft)
	 *        if they are adjacent to the given vertex , creates a new edge containing the previous vertex , the successor, 
	 *        and the weight as difference between pixels.
	 *        |positions[i][j].isAdjacentTo(successor) &&(withinBoundries(successor))
	 *        | adj[vertex].add(new Edge(vertex,successor,getWeight(vertex,successor)));
	 */
	 public void addEdges(int v, int i, int j) {
		   int width = image1[0].length;
	       if(i < image1.length-1 && positions[i][j].isAdjacentTo(positions[i+1][j]))
	    	   adj[i*width+j].add(new Edge(i*width+j,((i+1)*width+j),this.getWeight(i+1,j,i,j)));
	       
	       if(j < image1[0].length-1 && positions[i][j].isAdjacentTo(positions[i][j+1]))
	    	   adj[i*width+j].add(new Edge(i*width+j,(i*width+(j+1)),this.getWeight(i,j+1,i,j)));
	       
	       if(i < image1.length-1 &&j < image1[0].length-1 && positions[i][j].isAdjacentTo(positions[i+1][j+1]))
	    	   adj[i*width+j].add(new Edge(i*width+j,((i+1)*width+(j+1)),this.getWeight(i+1,j+1,i,j)));
	       
	       if(j > 0 && positions[i][j].isAdjacentTo(positions[i][j-1]))
	    	   adj[i*width+j].add(new Edge(i*width+j,(i*width+(j-1)),this.getWeight(i,j-1,i,j)));
	       
	       if(i < image1.length-1 &&j > 0 && positions[i][j].isAdjacentTo(positions[i+1][j-1]))
	    	   adj[i*width+j].add(new Edge(i*width+j,(i+1)*width+(j-1),this.getWeight(i+1,j-1,i,j)));    
	       
	       if(i > 0 && positions[i][j].isAdjacentTo(positions[i-1][j]))
	    	   adj[i*width+j].add(new Edge(i*width+j,(i-1)*width+j,this.getWeight(i-1,j,i,j)));
	       
	       if(i > 0 && j < width-1 && positions[i][j].isAdjacentTo(positions[i-1][j+1]))
	    	   adj[i*width+j].add(new Edge(i*width+j,(i-1)*width+(j+1),this.getWeight(i-1,j+1,i,j)));
	       
	       if(i > 0 && j > 0 && positions[i][j].isAdjacentTo(positions[i-1][j-1]))
	    	   adj[i*width+j].add(new Edge(i*width+j,(i-1)*width+(j-1),this.getWeight(i-1,j-1,i,j)));

	    }

	 /**
	  * Returns the edges adjacent to the given index.
	  * @param v
	  *        The given index to get the edges.
	  * @return
	  *        Returns the edges at the given index.
	  *        |return adj[v]
	  */
	   public Iterable<Edge> adj(int v) {
	        return adj[v];
	    }

	
	   /**
	    * A getter to get the weight of the edge.
	    * @param i
	    *        The given x co-ordinate of the first image.
	    * @param j
	    *        The given y co-ordinate of the first image.
	    * @param x
	    *        The given x co-ordinate of the second image.
	    * @param y
	    *        The given y co-ordinate of the second image.
	    * @return
	    *        Returns the weigh as difference between the pixels of the two images.
	    *        |result = (ImageCompositor.pixelSqDistance(image1[i][j], image2[i][j]));
	    */
	  private double getWeight(int i, int j,int x, int y) {
		return ImageCompositor.pixelSqDistance(image1[i][j], image2[i][j]);
	  }


	  /**
	   * A getter to get all the edges.
	   * @return
	   *        Returns all the edges in graph.
	   *        |for each adjacency(0......end-1)
	   *        |for (Edge edge : adj(i))
	   *        |list.add(edge);
	   */
	  public Iterable<Edge> getEdges() {
	        Bag<Edge> list = new Bag<Edge>();
	        for (int i = 0; i < adj.length; i++) {
	            for (Edge edge : adj(i)) {
	                list.add(edge);
	            }
	        }
	        return list;
	    } 
    }

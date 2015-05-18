package gna;

import java.util.ArrayList;
import java.util.Collection;

import libpract.Position;
import libpract.Stitch;

/**
 * 
 * @author Afarz Salim
 * @version 1.0
 *
 */
 //Alogrithm is taken from the book Alogorithm 4 edition
public class ShortestPath {

	/**
	 * A private variable graph, holding the reference the graph;
	 */
	private Graph graph;
	
	/**
	 * An array to save the distances from sources to a vertex.
	 */
	private double[] distTo;  
	/**
	 * An array to save all the edges.
	 */
    private Edge[] edgeTo;   
    /**
     * An Indexmin priority queue.
     */
    private IndexMinPQ<Double> pq;

    
    /**
     * Constructor to initialize the variables and arrays.
     * @param i
     *        The given source vertex.
     * @param graph
     *        The given graph to find shortes path.
     * @param image1
     *        The given first image.
     * @pre..
     *        if the weight of the edges are negative it will throw an exception.
     *        |throw new IllegalArgumentException("you are using Dijkstra be careful, no negative edges are supported ;-)");
     * @post..
     *        All vertices will be initialized with then infinity weight except the source.
     *        | for (each vertex)
     *        |distTo[vertex] = Double.POSITIVE_INFINITY;
     *        |distTo[0] = 0.0;
     * @post  The first vertex will be place on queue.
     *        |pq.insert(0, distTo[0]);
     * @post. Develops a path with given graph and source on priorityQueue.
     *        |this.developPath(pq,graph,distTo,edgeTo);
     */
	public ShortestPath(int i, Graph graph, int[][] image1) throws IllegalArgumentException {
     this.graph = graph;
     distTo = new double[image1.length*image1[0].length];
     edgeTo = new Edge[image1.length*image1[0].length];
     for (Edge edge : graph.getEdges()) {
         if (edge.getWeight() < 0)
             throw new IllegalArgumentException("you are using Dijkstra be careful, no negative edges are supported ;-)");
     }
     for (int vertex = 0; vertex < image1.length*image1[0].length; vertex++)
         distTo[vertex] = Double.POSITIVE_INFINITY;
     distTo[0] = 0.0;
     pq = new IndexMinPQ<Double>(image1.length*image1[0].length);
     pq.insert(0, distTo[0]);
     this.developPath(pq,graph,distTo,edgeTo);
	}


	
    /**
     * Develops path for all vertices in the graph.
     * @param pq
     *        The minor priority queue with only source index and initial distance.
     * @param graph
     *        The given graph to find path.
     * @param distTo
     *        An array consisting of all the distances.
     * @param edgeTo
     *        An array of edge to add all the edges.
     * @post. While the priority queue is not empty dequeue the minimum edge from the queue 
     *        and build path.
     *        |while(!(pq.isEmpty()))
     *        |int v = pq.delMin()
     *        |for(Edge e: graph.adj(v))
     *        | this.relax(e,distTo,edgeTo,pq);
     */
	private void developPath(IndexMinPQ<Double> pq, Graph graph, double[] distTo, Edge[] edgeTo) {
		while(!(pq.isEmpty())){
	    	 int v = pq.delMin();
	    	 for(Edge e: graph.adj(v)){
	    		 this.relax(e,distTo,edgeTo,pq);
	    	 }
	      }
	}


   /**
    * Relaxes an edge .
    * @param edge
    *        Recently picked edge as a neighbor of the edge whose weight was minimum.
    * @param distTo
    *        An array containing the distance for all vertices from source to that vertex.
    * @param edgeTo
    *        An array containing all the edges.
    * @param pq
    *        The given minimum index priority queue.
    * @post. if the distance from the first vertex plus the weigh of the edge is less than the other
    *        the distance of the second vertex will be equal to the distance of first vertex plus the weight of the 
    *        edge.
    *        | if (distTo[secondVertex] > distTo[firstVertex] + edge.getWeight())
    *        | distTo[secondVertex] = distTo[firstVertex] + edge.getWeight();
    *        |edgeTo[secondVertex] = edge;
    * @post. if priority queue does not contain the current vertex add this vertex to the queue, otherwise just update the information.
    *        | if (pq.contains(secondVertex))
    *        |pq.decreaseKey(secondVertex, distTo[secondVertex]);
    *        | else 
    *        |pq.insert(secondVertex, distTo[secondVertex]);
    */
	private void relax(Edge edge, double[] distTo, Edge[] edgeTo, IndexMinPQ<Double> pq) {
		int firstVertex = edge.getFrom();
		int secondVertex = edge.getTo();
        if (distTo[secondVertex] > distTo[firstVertex] + edge.getWeight()) {
            distTo[secondVertex] = distTo[firstVertex] + edge.getWeight();
            edgeTo[secondVertex] = edge;
            if (pq.contains(secondVertex))
            	pq.decreaseKey(secondVertex, distTo[secondVertex]);
            else              
            	pq.insert(secondVertex, distTo[secondVertex]);
        }		
	}
	
	
	/**
	 * A getter to get the path to a vertex.
	 * @param v
	 *        The vertex v for which the path to be found.
	 * @return
	 *        Returns null if the adjacency list contains null at given vertex(as index).
	 *        |if (!hasPathToVertex(v)) return null;
	 * @post. For each edge(v.....source),gets the previous edge and adds to the arralist.
	 *        |for each Edge(edgeTo(v)....edgeTo(source))
	 *        |path.add(e);
	 * @return
	 *        Returns an arraylist containing th path from the desired vertex to source.
	 *        |return path;
	 */
	 public Iterable<Edge> pathTo(int v) {
	        if (!hasPathToVertex(v)) return null;
	        Collection<Edge> path = new ArrayList<Edge>();
	        for (Edge e = edgeTo[v]; e != null; e = edgeTo[e.getFrom()]) {
	            path.add(e);
	        }
	        return path;
	    }
	 
	 
	
	 /**
	  * Checks whether there exist any path from the desired vertex to the source.
	  * @param v
	  *        The given desired vertex.
	  * @return
	  *        Returns true if and only if the distTo that place is not infinite.
	  *        |return distTo[v] < Double.POSITIVE_INFINITY;
	  */
	 public boolean hasPathToVertex(int v) {
		 System.out.println(distTo[v]);
	        return distTo[v] < Double.POSITIVE_INFINITY;
	    }
	
	 
	 
	 
	 
	 
		
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}

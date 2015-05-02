package gna;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Stack;

import libpract.PriorityFunc;

public class Solver
{
	
	private Collection<Board> b;


	/**
	 * Finds a solution to the initial board.
	 *
	 * @param priority is either PriorityFunc.HAMMING or PriorityFunc.MANHATTAN
	 */
	public Solver(Board initial, PriorityFunc priority){
		
		 b = new ArrayList<Board>();
		 ArrayList<Node> closedList = new ArrayList<Node>();
		 this.setCollecion(b);
		 MinPQ<Node> pq = new MinPQ<Node>();
		 Node node = new Node(initial,null,0);
		 pq.insert(node);
		int i = 0;
		if (priority == PriorityFunc.HAMMING){
			Node.setPriority("hamming");
		     this.solve(pq);
		}
		else if (priority == PriorityFunc.MANHATTAN){
			 Node.setPriority("manhattan");
		     this.solve(pq);
		}

	 else
		throw new IllegalArgumentException("Priority function not supported");
	}





	private void solve(MinPQ<Node> pq) {
		while(!(pq.min().getBoad().isGoal(pq.min().getBoad()))){
			Node e = pq.delMin();
			for(Board boards: e.getBoad().neighbors()){
				Node nextNode = new Node(boards,e,e.getMoves()+1);
				if(!equalToPreviousNode(nextNode,e.getPreviousNode()))
					  pq.insert(nextNode);
			   }
			e = null;
			}
		this.reconstructPath(pq);
	}

	

	
	
	

	private void reconstructPath(MinPQ<Node> pq) {
		Node collection = pq.delMin();
		while(!(collection.getPreviousNode() == null)){
			this.getB().add(collection.getBoad());
			collection =collection.getPreviousNode();
	}
		System.out.println(pq.size());
	}

	
	

	private boolean equalToPreviousNode(Node nextNode, Node previousNode) {
           if(nextNode.equals(previousNode))
        	   return true;
		return false;
	}




	private void setCollecion(Collection<Board> b) {
		this.b = b;
		
	}
	
	public Collection<Board> getB(){
		return this.b;
	}


	/**
	 * Returns a Collection of board positions as the solution. It should contain the initial
	 * Board as well as the solution (if these are equal only one Board is returned).
	 */
	public Collection<Board> solution()
	{
		return this.getB(); 
	}
}



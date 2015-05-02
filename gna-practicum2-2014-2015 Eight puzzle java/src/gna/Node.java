package gna;


public class Node implements Comparable {
	
	
	
	 private Board board;
     private Node previousNode;       
     public int moves;
	 private static String priority;
     
     public Node (Board bd, Node previousNode, int moves) {
         this.board = bd;
         this.previousNode = previousNode;
         this.moves = moves;
     }
   
     
     
     public int priorityDistance () {
    	 if(getPriority().equals("manhattan"))
         return this.getMoves() + this.getBoad().manhattan();
    	 else if(getPriority().equals("hamming"))
             return this.getMoves() + this.getBoad().hamming();
    	 else 
    		 throw new IllegalArgumentException("priority not supported");
     }
      
     
     public static void setPriority(String priority){
    	 Node.priority = priority;
     }
     
     protected String getPriority() {
    	 return Node.priority;
	}

	public int compareTo (Object other) {
         Node second = (Node) other;
         int distanceFirst = this.priorityDistance();
         int distanceSecond= second.priorityDistance();
         if (distanceFirst > distanceSecond) return 1;
         if ( distanceFirst == distanceSecond) return 0;
         else 
         return -1;
     }
     
     
     public Node getPreviousNode(){
    	 return this.previousNode;
     }
     
     
     
     public Board getBoad(){
 		return this.board;
 	}
     
    public int getMoves(){
    	return this.moves;
    }
     
     public boolean equals(Object other){
    	 if(other == null)
    		 return false;
    	 Node o = (Node)other;
    	 for(int i = 0; i< getBoad().getSize();i++){
 			for(int j = 0; j < getBoad().getSize();j++){
 				if(this.getBoad().board[i][j] != o.getBoad().board[i][j])
 					return false;
 			}
    	 }
       if(o.getBoad().manhattan() != this.getBoad().manhattan())
    			 return false;
		return true;
     }
   }



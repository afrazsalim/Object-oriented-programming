package gna;

import java.util.ArrayList;
import java.util.Collection;

public class Board
{

	protected int [][] board;
	private int N;
	private int hammingDistance;
	private int manhattanDistance;
	public Board( int[][] tiles )
	{
        this.board = tiles;
        this.N = tiles.length;
        this.hammingDistance = 0;
        this.manhattanDistance = 0;
	}
	
	
	
	
	
	public void setHammingDistance(int distance){
		this.hammingDistance = distance;
	}
	
	
	
	
	
	
	public int getHammingDistance(){
		return this.hammingDistance;
	}
	
	
	
	
	
	public int hamming()
	{
		this.setHammingDistance(0);
		for(int i = 0; i< this.getSize();i++){
			for(int j = 0; j < this.getSize();j++){
				if(this.board[i][j]> 0){
				if(this.board[i][j]  != i*this.getSize()+j+1)
					this.setHammingDistance(this.getHammingDistance()+1);
			   }
		    }
		 }
		return this.getHammingDistance();
	}
	
	
	
	
	
	
	protected int getSize() {
		return this.N;
	}


	
	
	
	// return sum of Manhattan distances between blocks and goal
	public int manhattan()
	{
		this.setManhattenDistance(0);
		for(int i = 0; i < this.getSize();i++){
			for(int j = 0; j< this.getSize();j++){
				if(this.board[i][j] > 0){
					int xCo = ((this.board[i][j]-1)/this.getSize());
					int yCo = ((this.board[i][j]-1)%this.getSize());
					this.setManhattenDistance(this.getManhattenDistance()+ Math.abs(xCo-i)+Math.abs(yCo-j));
				}
			}
		}
		return this.getManhattenDistance();
	}
	
	
	
	
	
	
	
	private void setManhattenDistance(int i) {
        this.manhattanDistance = i;		
	}


	public int getManhattenDistance() {
		return this.manhattanDistance;
	}


	
	
		public boolean equals(Object y)
	{
		int index = 0;
		if ((y == null) || (getClass() != y.getClass()))
			return false;
		Board otherBoard = (Board) y;
		for(int i = 0; i< this.getSize();i++){
			for(int j = 0; j < this.getSize();j++){
				if(this.board[i][j] != otherBoard.board[i][j]){
					index = j;
					return false;
				}
			}
			if(this.board[i][index] != otherBoard.board[i][index])
				break;
		}
		if(this.manhattan() != otherBoard.manhattan())
			return false;
		if(this.hamming() !=otherBoard.hamming())
			return false;
		return true;
	}
	
	
	
	
	
	// return a Collection of all neighboring board positions
	public Collection<Board> neighbors()
	{
	   int emptyTile = 0;
	   int [][] succesor;
	   Board newBoard;
	   Collection<Board> collection = new ArrayList<Board>();
       for(int i = 0; i< this.getSize();i++){
    	   for(int j = 0;j <this.getSize();j++){
    		   if(this.board[i][j] == emptyTile){
    			   if(i == 0 && j ==0){
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i][j+1];
    				   succesor[i][j+1] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i+1][j];
    				   succesor[i+1][j] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    			   }
    			   else if (j  > 0 && j < this.getSize()-1 && i == 0){
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i][j+1];
    				   succesor[i][j+1] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i+1][j];
    				   succesor[i+1][j] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i][j-1];
    				   succesor[i][j-1] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    			   }
    			   else if(i == 0 && j == this.getSize()-1){
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i+1][j];
    				   succesor[i+1][j] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i][j-1];
    				   succesor[i][j-1] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    			   }
    			   else if(i  > 0  && j ==0 && i < this.getSize()-1){
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i][j+1];
    				   succesor[i][j+1] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i+1][j];
    				   succesor[i+1][j] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i-1][j];
    				   succesor[i-1][j] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    			   }
    			   else if(i > 0 && j > 0 && i < this.getSize()-1 && j < this.getSize()-1){
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i][j+1];
    				   succesor[i][j+1] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i+1][j];
    				   succesor[i+1][j] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i-1][j];
    				   succesor[i-1][j] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i][j-1];
    				   succesor[i][j-1] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    			   }
    			   else if(i > 0 && j > 0 && j == this.getSize()-1 && i < this.getSize()-1){
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i+1][j];
    				   succesor[i+1][j] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i-1][j];
    				   succesor[i-1][j] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i][j-1];
    				   succesor[i][j-1] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    			   }
    			   else if( i == this.getSize()-1 && j == 0){
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i-1][j];
    				   succesor[i-1][j] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i][j+1];
    				   succesor[i][j+1] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    			   }
    			   else if(i == this.getSize()-1 && j < this.getSize()-1 && j > 0){
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i-1][j];
    				   succesor[i-1][j] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i][j+1];
    				   succesor[i][j+1] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i][j-1];
    				   succesor[i][j-1] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    			   }
    			   else if (i == this.getSize()-1 && j == this.getSize()-1){
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i][j-1];
    				   succesor[i][j-1] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    				   succesor = new int[this.getSize()][this.getSize()];
    				   this.makeCloneToTheNewObject(succesor);
    				   succesor[i][j] = succesor[i-1][j];
    				   succesor[i-1][j] = 0;
    				   newBoard = new Board(succesor);
    				   collection.add(newBoard);
    			   }
 
    		   }
    	   }
       }
	return collection;
	}
	
	
	
	
	
	private void makeCloneToTheNewObject(int[][] succesor) {
        for(int i = 0; i< this.getSize(); i ++){
        	for(int j =0 ; j< this.getSize();j++){
        		succesor[i][j] = this.board[i][j];
        	}
        }
	}
   
	public boolean isGoal(Board board){
		if (board.manhattan() == 0)
			return true;
		else
		return false;
	}




	// return a string representation of the board
	public String toString()
	{
		 StringBuilder s = new StringBuilder();
	        s.append(N + "\n");
	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                s.append(String.format("%2d ",board[i][j]));
	            }
	            s.append("\n");
	        }
	        return s.toString();
	}

	// is the initial board solvable?
	public boolean isSolvable()
	{
         int i = -1;
         if((int) Math.pow(i, this.getInversions(this.board)) >= 0)
        	 return true;
        	 else
         return false;
	}





public int getInversions(int[][] board) {
		int inversions = 0;
	 if(board[this.getSize()-1][this.getSize()-1] == 0){
		 int [] makeOneArray = this.getArrayElements(board);
		 inversions = this.countInversions(makeOneArray);
	   }
	 else
	 {
		 int [][] array = new int[this.getSize()][this.getSize()];
		 int [][] arr = this.getEmptyTileAtEnd(this.copyfromOriginal(array));
		 int [] makeOneArray = this.getArrayElements(arr);
		 inversions = this.countInversions(makeOneArray);

	 }
		 return inversions;
	 }





protected int countInversions(int[] makeOneArray) {
   int inversions = 0;
	 for(int i  = 0; i< this.getSize()*this.getSize()-1;i++){
		 for(int j = i+1; j< this.getSize()*this.getSize()-1;j++){
			 if(makeOneArray[j] < makeOneArray[i] )
				 inversions++;
		 }
	 }
	return inversions;
	}





private int[][] copyfromOriginal(int[][] array) {
   for(int i = 0; i< this.getSize();i++){
	   for(int j = 0; j < this.getSize();j++){
		   array[i][j] = this.board[i][j];
	   }
   }
	return array;
}





protected int[][] getEmptyTileAtEnd(int [][] bd) {
	this.moveTileLeft(bd);
	this.moveTileDown(bd);
	return bd;
   
}


private void moveTileLeft(int[][] bd) {
   for(int i = 0; i< this.getSize();i++){
	   for(int j = 0; j< this.getSize();j++){
	   if(bd[i][j] == 0 && j+1 < this.getSize()){
		   bd[i][j] = bd[i][j+1];
		   bd[i][j+1]= 0;

	   }
	  }
		   
   }
}





private void moveTileDown(int[][] bd) {
	  for(int i = 0; i< this.getSize();i++){
		   for(int j = 0; j< this.getSize();j++){
		   if(bd[i][j] == 0 && i+1 < this.getSize()){
			   bd[i][j] = bd[i+1][j];
			   bd[i+1][j]= 0;
		   }
		  }
	   }
}




	protected int[] getArrayElements(int[][] board) {
       int [] array = new int[this.getSize()*this.getSize()];
       for(int i = 0; i< this.getSize();i++){
    	   for(int j =0 ; j < this.getSize();j++){
    		   array[i*this.getSize()+j] = board[i][j];
    	   }
       }
		return array;
	}




}


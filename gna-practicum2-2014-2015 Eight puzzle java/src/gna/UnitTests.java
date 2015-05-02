package gna;

import java.util.Arrays;
import java.util.Collection;

import libpract.PriorityFunc;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * A number of JUnit tests for Solver.
 *
 * Feel free to modify these to automatically test puzzles or other functionality
 */
public class UnitTests {
  
  int [][] solvedArray = {{1,2,3},{4,5,6},{7,8,0}};
  int [][] distanceArray = {{1,2,3},{4,6,5},{7,8,0}};
  int [][] neighbourArray = {{1,2,3},{4,0,6},{7,8,5}};
  Board board;
  
 
  
  @Test
  public void test() {
  }
  
  
  @Test
  public void legalCase_neighboursBoards(){
	  board = new Board(neighbourArray);
	  int i = 1;
	  for(Board boards:board.neighbors()){
		  assertEquals(boards,(getBoards(i)));
		  i++;
	  }
	  
  }
  


  
  
  
private Board getBoards(int i) {
  int [][] firstArray = {{1,2,3},{4,6,0},{7,8,5}};
  int [][] secondArray = {{1,2,3},{4,8,6},{7,0,5}};
  int [][] thirdArray = {{1,0,3},{4,2,6},{7,8,5}};
  int [][] fourthArray = {{1,2,3},{0,4,6},{7,8,5}};
  if (i == 1)
	  return new Board(firstArray);
  else if (i == 2)
	  return new Board(secondArray);
  else if (i == 3)
	  return new Board(thirdArray);
  else if (i == 4)
	  return new Board(fourthArray);
	return null;
}

@Test
  public void legalCase_manhattanDistance(){
	  board = new Board(solvedArray); 
	  assertEquals(0,board.manhattan());
	  board = new Board(distanceArray); 
	  assertEquals(2,board.manhattan());
  }
  
@Test
  public void legalCase_hammingDistance(){
	  board = new Board(solvedArray); 
	  assertEquals(0,board.hamming());
	  board = new Board(distanceArray); 
	  assertEquals(2,board.hamming());
  }
  
  
  
 @Test
 public void illegalCase_NotSolveAblePuzzles(){
	 int [][] impossibleArray = {{3,2,4,8},{1,6,0,12},{5,10,7,11},{9,13,14,15}};
	 board = new Board(impossibleArray);
	 assertFalse(board.isSolvable());
 }
  
 @Test
 public void legalCase_NotSolveAblePuzzles(){
	 int [][] possibleArray = {{2,0,5,4},{10,3,6,7},{13,1,9,15},{8,11,12,14}};
	 board = new Board(possibleArray);
	 assertTrue(board.isSolvable());
 }
  
 @Test
 public void move_TileAtEnd(){
	 int [][] array = {{0,2,1},{3,4,5},{6,7,8}};
	 //expected array 
	 int [][] expectedArray = {{2,1,5},{3,4,8},{6,7,0}};
	 board = new Board(array);
	 array = board.getEmptyTileAtEnd(array);
    for(int i = 0; i< 3;i++){
    	for(int j = 0; j< 3;j++){
    		assertEquals(array[i][j],expectedArray[i][j]);
    	}
    }
 }
    
    
    @Test
    public void legalCase_Inversion(){
    	int [] array = {2,1,3,4,5,6,7,8,0};
        board = new Board(solvedArray);
        int value = board.countInversions(array);
        //expected one
        assertEquals(1,value);
        
    }
 
 
 
 
 
 
  
  
}

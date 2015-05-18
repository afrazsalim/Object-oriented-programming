package gna;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import libpract.Position;
import libpract.Stitch;

/**
 * 
 * @author Afraz Salim
 * @version 1.0
 */
public class Stitcher
{
	/**
	 * A private variable to store all the positions in two dimensional array.
	 */
	private Position[][] positions;
	
	
	/**
	 * A private variable to store all the positions in one dimensional array.
	 */
	private Position[] pos;
	
	
	
	/**
	 * An arraylist to save all the positions of the seam.
	 */
	private ArrayList<Position> seam;
	
	
	/**
	 * A getter to get the array list consisting all positions of the seam(from begin to end).
	 * @param image1
	 *        The given first image to be stitched.
	 *        
	 * @param image2
	 *        The given second image to be stitched.
	 *        
	 * @post. Creates a new two dimensional array to store all newly created positions.
	 *        |positions = new Position[image1.length][image1[0].length];
	 *        
	 * @post. For each position of the image from(0,0) to (endX-1,endY-1) creats a new positions 
	 *        object and will be saved in positions array.
	 *        |for each(i....endX-1)
	 *        | for each(j ..... endY-1)
	 *        |positions[i][j] = new Position(i, j);
	 *        
	 * @post. A new graph will be created with given images and the weight of the edges is 
	 *        defined as the difference between the color of the two pixels.
	 *        |Graph graph = new Graph(image1,image2,positions);
	 *        
	 * @post. The newly created graph will be used to find the shortest path from source
	 *        the end.
	 *        |ShortestPath p = new ShortestPath(0,graph,image1);
	 *      
	 * @post. Constructs a new path from the desired vertex by continuously adding 
	 *        the previous edge until it reaches source.
	 *        |for(Edge e: p.pathTo((image1.length)*(image1[0].length)-1))
     *        |Position position = pos[e.getFrom()];
     *        |seam.add(position);
     *        
	 * @post. Reverses the achieved result so the seam contains first value as (0,0).
	 *        |Collections.reverse(seam);
	 * @return
	 *        Returns an array so called seam which contains all the positions as shortest
	 *        path from desired vertex to source.
	 *        |result = (seam)
	 */
	public List<Position> seam(int[][] image1, int[][] image2) {
		positions = new Position[image1.length][image1[0].length];
		pos = new Position[image1.length*image1[0].length];
		seam = new ArrayList<Position>();
		for (int i = 0; i < image1.length; i++) {
            for (int j = 0; j < image1[0].length; j++) {
                positions[i][j] = new Position(i, j);
                pos[i*image1[0].length+j] = new Position(i,j);
            }
		}
		Graph graph = new Graph(image1,image2,positions);
		ShortestPath p = new ShortestPath(0,graph,image1);
		for(Edge e: p.pathTo((image1.length)*(image1[0].length)-1)){
            Position position = pos[e.getFrom()];
            seam.add(position);
		}
		Collections.reverse(seam);
		seam.add(positions[image1.length-1][image1[0].length-1]);
		return seam;
	}
	
	
	
	
	/**
	 * A getter to get the array of all positions in given image.
	 * @return
	 *       Returns an array consisting all the positions from (0,0) to (endX-1,endY-1)
	 *       |result = (this.positions)
	 */
	public Position [][] getPositions(){
		return this.positions;
	}
	

	/**
	 * A mutator to stitch the first image left to the seam  and Stitches the second image 
	 * right to the seam.
	 * @param    mask
	 *           The given which initially contains all the seam positions.
	 *           
	 * @effect..  Stitches the first image on all positions left to the seam.
	 *            |this.floodFillIterative(mask,2,0);
	 *            
	 * @effect..  Stitches the second image on all the positions left to the seam.
	 *            |this.floodFillIterativeRight(mask,mask.length-2,mask[0].length-1);
	 */
	public void floodfill(Stitch[][] mask) {
           Position [][] pos =this.getPosition(mask); //Because JUnit test failed so needed to initialize again, one common reason is may be
                                                    // that JUnit test directly call this method and array is not initialized so it,s giving 
                                                    //nullPonterException.(now resolved after this initialization) :-)
		   this.floodFillIterativeLeft(mask,mask.length-1,0,pos);
		   this.floodFillIterativeRight(mask,mask.length-2,mask[0].length-1,pos);
	   }

	

	




	

	/**
	 * A getter to get the one dimensional array containing all the positions.
	 * @param mask
	 *        The given mask, consisting the seam values.
	 * @return
	 *        Returns an initialized array.
	 *        |result = (array)
	 */
	private Position[][] getPosition(Stitch[][] mask) {
		Position [][] array = new Position[mask.length][mask[0].length];
		for (int i = 0; i < mask.length; i++) {
            for (int j = 0; j < mask[0].length; j++) {
            array[i][j] = new Position(i,j);
            }
		}
		return array;
	}




	/**
	 * Stitches the first image at all positions left to the seam.
	 * @param  mask
	 *         The given mask as parameter which contains seam.
	 * @param pos2 
	 * @param..  i
	 *         The start index as x co-ordinate for stitching the first image.
	 * @param .. j
	 *         The start index as y co-ordinate for stitching the first image.
	 * @post...
	 *         A queue will be initialized to check whether the current pixel is already marked
	 *         or not.
	 *         |boolean [][]mark  = new boolean[mask.length+10][mask[0].length+10];
	 * @post...  
	 *         A queue will be initialized to save pixels and their neighbours.
	 *         |Queue<Position>  q = new Queue<Position>(mask.length*mask[0].length+10);
	 * @post...  
	 *         A second queue will be initialized to check whether the pixel is already on 
	 *         queue.(To prevent heap space error)
	 *         | boolean [][] OnQueue = new boolean[mask.length+10][mask[0].length+10];
	 * @effect...  
	 *         Enqueues the first position on the queue.
	 *         | q.enqueue(pos);
	 * @effect...
	 *         While queue is not empty, dequeue the position from the queue. if the
	 *         current position is on seam then it only marks that positions.
	 *         |if(mask[x][y] == Stitch.SEAM)
	 *         |mark[x][y] = true;
	 *         if the current position is not marked the Stitch the first image on that positions.
	 *         | if(!(mark[x][y]))
	 *         |mask[x][y] = Stitch.IMAGE1
	 * @post... 
	 *         If the given position is not equal to the seam then generate all of it,s successors
	 *         if valid and enqueue them.
	 *         |if(mask[x][y] != Stitch.SEAM)
	 *         |for each successor if the successor is a valid successor add that successor to queue.
	 *         |isValid(successor) && (successor != Stitch.SEAM)){
     *   	   |q.enqueue(successor);
     *   	   |OnQueue[successor] = true;
	 */
	private void floodFillIterativeLeft(Stitch[][] mask, int i, int j, Position[][] pos2) {
	    boolean [][] mark = new boolean[mask.length+1][mask[0].length+1];
		Queue<Position>  q = new Queue<Position>(mask.length*mask[0].length+1);
	    boolean [][] OnQueue = new boolean[mask.length][mask[0].length+10];
        Position pos = pos2[i][j];
        q.enqueue(pos);
        while(!(q.isEmpty())){
        	Position pulled  = q.dequeue();
        	int x = pulled.getX();
        	int y = pulled.getY();
        	if(mask[x][y] == Stitch.SEAM)
            	mark[x][y] = true;
            if(mask[x][y] != Stitch.SEAM){
        	   mask[x][y] = Stitch.IMAGE1;
        	   mark[x][y] = true;
            }
        	if((x > 0)  && isValid(mask,x-1,y,mark,OnQueue) && (mask[x-1][y] != Stitch.SEAM)){
        		q.enqueue(pos2[(x-1)][y]);
        		OnQueue[x-1][y] = true;
        	}
        	if((y > 0) && isValid(mask,x,y-1,mark,OnQueue)&& (mask[x][y-1] != Stitch.SEAM)){
        		q.enqueue(pos2[x][(y-1)]);
        		OnQueue[x][y-1] = true;
          }
         if((y < mask[0].length-1) && isValid(mask,x,y+1,mark,OnQueue)&& (mask[x][y+1] != Stitch.SEAM)){
    		q.enqueue(pos2[x][(y+1)]);
    		 OnQueue[x][y+1] = true;
        }
	    if((x < mask.length-1) && isValid(mask,x+1,y,mark,OnQueue) && (mask[x+1][y] != Stitch.SEAM)){
    		   q.enqueue(pos2[(x+1)][y]);
	            OnQueue[x+1][y] = true;
          }
       }
}
	
	
	/**
	 * Stitches the second image at all positions right to the seam.
	 * @param  mask
	 *         The given mask as parameter which contains seam.
	 * @param pos2 
	 * @param..  i
	 *         The start index as x co-ordinate for stitching the second image.
	 * @param .. j
	 *         The start index as y co-ordinate for stitching the second image.
	 * @post...
	 *         A queue will be initialized to check whether the current pixel is already marked
	 *         or not.
	 *         |boolean [][]mark  = new boolean[mask.length+10][mask[0].length+10];
	 * @post...  
	 *         A queue will be initialized to save pixels and their neighbours.
	 *         |Queue<Position>  q = new Queue<Position>(mask.length*mask[0].length+10);
	 * @post...  
	 *         A second queue will be initialized to check whether the pixel is already on 
	 *         queue.(To prevent heap space error)
	 *         | boolean [][] OnQueue = new boolean[mask.length+10][mask[0].length+10];
	 * @effect...  
	 *         Enqueues the first position on the queue.
	 *         | q.enqueue(pos);
	 * @effect...
	 *         While queue is not empty, dequeue the position from the queue. if the
	 *         current position is on seam then it only marks that positions.
	 *         |if(mask[x][y] == Stitch.SEAM)
	 *         |mark[x][y] = true;
	 *         if the current position is not marked the Stitch the first image on that positions.
	 *         | if(!(mark[x][y]))
	 *         |mask[x][y] = Stitch.IMAGE1
	 * @post... 
	 *         If the given position is not equal to the seam then generate all of it,s successors
	 *         if valid.
	 *         |if(mask[x][y] != Stitch.SEAM)
	 * @post...
	 *         for each successor if the successor is a valid successor and the successor
	 *         is not equal to the first image, add that successor to queue.
	 *         |isValid(successor) && (successor != Stitch.SEAM) &&(successor != Stitch.IMAGE1)){
     *   	   |q.enqueue(successor);
     *   	   |OnQueue[successor] = true;
	 */
	private void floodFillIterativeRight(Stitch[][] mask, int i, int j, Position[][] position) {
		boolean [][]mark  = new boolean[mask.length+1][mask[0].length+1];
		Queue<Position>  q = new Queue<Position>(mask.length*mask[0].length+10);
	    boolean [][] OnQueue = new boolean[mask.length+10][mask[0].length+10];
        Position positions = position[i][j];
        q.enqueue(positions);
        while(!(q.isEmpty())){
        	Position p = q.dequeue();
        	int x = p.getX();
        	int y = p.getY();
        	if(mask[x][y] == Stitch.SEAM){
        	mark[x][y] = true;
          }
            if(!(mark[x][y])){
        	 mask[x][y] = Stitch.IMAGE2;
        	 mark[x][y] = true;
            }
           if(mask[x][y] != Stitch.SEAM && mask[x][y] != Stitch.IMAGE1){
        	if((x > 0)  && isValid(mask,x-1,y,mark,OnQueue) && (mask[x-1][y] != Stitch.SEAM)){
        		q.enqueue(position[x-1][y]);
        		OnQueue[x-1][y] = true;
        	}
        	if((y > 0) && isValid(mask,x,y-1,mark,OnQueue)&& (mask[x][y-1] != Stitch.SEAM)){
        		q.enqueue(position[x][y-1]);
        		OnQueue[x][y-1] = true;
          }
         if((y < mask[0].length-1) && isValid(mask,x,y+1,mark,OnQueue)&& (mask[x][y+1] != Stitch.SEAM)){
    		q.enqueue(position[x][y+1]);
    		OnQueue[x][y+1] = true;
        }
	    if((x < mask.length-1) && isValid(mask,x+1,y,mark,OnQueue) && (mask[x+1][y] != Stitch.SEAM)){
    		   q.enqueue(position[x+1][y]);
	       OnQueue[x+1][y] = true;
          }
       }
     }
   }
	


	

	/**
	 * A checker to check whether a pixel is valid or not.
	 * @param mask
	 *        The given mask which contains seam.
	 * @param i
	 *        The x co-ordinate of the pixel.
	 * @param j
	 *        The y co-ordinate of the pixel.
	 * @param marked
	 *        A given queue to check whether the pixel is marked(colored) or not.
	 * @param onQueue
	 *        A queue to check whether the pixel is already on queue or not.
	 * @return
	 *        Return true if the given pixel is not on the queue.
	 *        |if(onQueue[i][j] != true)
	 *		  |return true;
	 * @return
	 *        Returns true if the given pixel is not equal to the seam.
	 *        |if(mask[i][j] != Stitch.SEAM){
	 *		  |return true;
	 * @return
	 *        Returns true if the given pixel is not marked.
	 *        |if(marked[i][j] != true)
	 *        |return true;
	 */
	private boolean isValid(Stitch[][] mask, int i, int j, boolean[][] marked, boolean[][] onQueue) {
		if(onQueue[i][j] == true)
			return false;
		if(mask[i][j] == Stitch.SEAM)
			return false;
		if(marked[i][j] == true)
			return false;
	return true;
	}







	/**
	 * A stitcher to stitch two images together.
	 * @param image1
	 *        The first given image.
	 * @param image2
	 *        The second given image.
	 * @post. Gets the seam from the seam method.
	 *        |List<Position> seam = this.seam(image1, image2);
	 * @post. Marks all the positions on the seam with Stitch.SEAM
	 *        |for (Position position : seam)
	 *        |stitch[position.getX()][position.getY()] = Stitch.SEAM;
	 * @post. Fill the rest of the image left to the seam with first image and right to the 
	 *        image with second image, by calling the method floodfill()
	 *        |this.floodfill(stitch);
	 * @return
	 *        Returns an image which contains the first image left to the seam and second image 
	 *        right to the seam.
	 *        |result = (stitch)
	 */
	public Stitch[][] stitch(int[][] image1, int[][] image2) {
		List<Position> seam = this.seam(image1, image2);
		Stitch[][] stitch = new Stitch[image1.length][image1[0].length];
       for (Position position : seam)
            stitch[position.getX()][position.getY()] = Stitch.SEAM;
        this.floodfill(stitch);
        return stitch;
	}
}





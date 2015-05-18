package gna;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import libpract.Position;
import libpract.Stitch;

public class JunitTestSeam {

	Position[][] positions;
	int[][] arrayFirst;
	int [][] arraySecond;
	Stitch [][] position;

	Graph graph;
	
	
	@Test
	public void legalCase_GraphBuild(){
		arrayFirst = new int[2][2];
		arraySecond = new int[2][2];
		positions = new Position[2][2];
        ArrayList<Edge> list = new ArrayList<Edge>();
		list.add(new Edge(0,3,0.00));
		list.add(new Edge(0,1,0.00));
		list.add(new Edge(0,2,0.00));//Add all possible edges with the same order as in gaph class or reverse the list.
		list.add(new Edge(1,2,0.00));
		list.add(new Edge(1,0,0.00));
		list.add(new Edge(1,3,0.00));
		list.add(new Edge(2,1,0.00));
		list.add(new Edge(2,0,0.00));
		list.add(new Edge(2,3,0.00));
		list.add(new Edge(3,0,0.00));
		list.add(new Edge(3,1,0.00));
		list.add(new Edge(3,2,0.00));
		Collections.reverse(list);
		for(int i = 0; i < positions.length;i++){
			for(int j = 0 ; j< positions.length;j++){
				positions[i][j] = new Position(i,j);
			}
		}
		int i = 0;
		graph = new Graph(arrayFirst,arraySecond,positions);
		for(Edge e: graph.getEdges()){
			assertEquals(e.getFrom(),list.get(i).getFrom());
			assertEquals(e.getTo(),list.get(i++).getTo());
		}
	} 
	
	@Test
	public void legalCase_completeSeam(){
		Stitcher s = new Stitcher();
		arrayFirst = new int[10][10];
		arraySecond = new int[10][10];
		positions = new Position[10][10];
		List<Position> seam = s.seam(arrayFirst, arraySecond);
		for(int i = 0; i< seam.size();i++)
			assertTrue(seam.get(i) != null);
	}
	
	
	

}

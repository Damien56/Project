package foo;

import static org.junit.Assert.*;
import junit.framework.*;
import org.junit.Test;

import pieces.Dame;
import pieces.Fou;
import pieces.Position;

public class PieceTest {
	
	

	
	@Test
	public void testsetPostitionPossibleDame() {
		
		Dame dame = new Dame(new Position(3,3),"blanc");
		dame.setPositionPossible();
		int tab[][] = { {1,0,0,1,0,0,1,0},{0,1,0,1,0,1,0,0},
				{0,0,1,1,1,0,0,0},{1,1,1,0,1,1,1,1},
				{0,0,1,1,1,0,0,0},{0,1,0,1,0,1,0,0},
				{1,0,0,1,0,0,1,0},{0,0,0,1,0,0,0,1} };
		
		int tab2[][]=dame.getPositionPossible();
		assertEquals(tab,tab2);
		
		
		
		Dame dame2 = new Dame(new Position(0,0),"noire");
		dame2.setPositionPossible();
		int tab3[][] ={ {0,1,1,1,1,1,1,1}, {1,1,0,0,0,0,0,0},
				{1,0,1,0,0,0,0,0},{1,0,0,1,0,0,0,0},
				{1,0,0,0,1,0,0,0},{1,0,0,0,0,1,0,0},
				{1,0,0,0,0,0,1,0},{1,0,0,0,0,0,0,1}};
	
		int tab4[][]=dame2.getPositionPossible();
		assertEquals(tab3,tab4);
	}
		
		
	}



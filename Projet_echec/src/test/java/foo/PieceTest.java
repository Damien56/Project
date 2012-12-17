package foo;

import static org.junit.Assert.*;

import org.junit.Test;

import pieces.Dame;
import pieces.Piece;

public class PieceTest {

	@Test
	public void testsetPostitionPossibleDame() {
		
		Piece dame = new Dame(33,"blanc");
		dame.setPositionPossible();
		int tab[][] = { {1,0,0,1,0,0,1,0},{0,1,0,1,0,1,0,0},
				{0,0,1,1,1,0,0,0},{1,1,1,0,1,1,1,1},
				{0,0,1,1,1,0,0,0},{0,1,0,1,0,1,0,0},
				{1,0,0,1,0,0,1,0},{0,0,0,0,0,0,0,0} };
		assertEquals(tab,dame.getPositionPossible());
		
		
		
	}

}

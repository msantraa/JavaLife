package deliverable4;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class WorldTest {
	
	// Test that the column header for the first row contains 3 iterations
	//of the string "0123456789" for a World that has a board size of 30x30 
	@Test
	public void testColumnHeaders() {
		World myWorld = new World(50, 2000, 15);
		String expected = "012345678901234567890123456789";
		assertTrue(myWorld.toString().contains(expected));
	}
	

    //Test that the initial world (WorldA) is not equal to itself after iterate is called on it(WorldB)
	@Test
	public void testWorldAfterIterate() {
		
		World myWorld = new World(10, 1500, 15);
		String WorldA = myWorld.toString();
		String WorldB = myWorld.iterate().toString();
		assertNotEquals(WorldA, WorldB);
	}
	
	
	// Test to see if the board is displayed correctly(all X) when all cells are set to be alive 
	@Test
    public void testAliveWorld()
    {
        Cell[][] myCells = new Cell[10][10]; //board size 10x10s
        for (int i=0;i<myCells.length;++i){
        	for (int j=0;j<myCells[i].length;++j){
        		
        		myCells[i][j]=new Cell(State.ALIVE,j,i);
        	}
        }
        
        World newWorld = new World(myCells, new Random());
        String expected = "  0123456789\n"
                        + "0 XXXXXXXXXX\n"
                        + "1 XXXXXXXXXX\n"
                        + "2 XXXXXXXXXX\n"
                        + "3 XXXXXXXXXX\n"
                        + "4 XXXXXXXXXX\n"
                        + "5 XXXXXXXXXX\n"
                        + "6 XXXXXXXXXX\n"
                        + "7 XXXXXXXXXX\n"
                        + "8 XXXXXXXXXX\n"
                        + "9 XXXXXXXXXX\n";
        
        assertEquals(expected,newWorld.toString());
    }
	
	// Test to see if the board is displayed correctly(all .) when all cells are set to be dead
	@Test
    public void testDeadWorld()
    {
        Cell[][] myCells = new Cell[10][10]; //board size 10x10
        for (int i=0;i<myCells.length;++i){
        	for (int j=0;j<myCells[i].length;++j){
        		
        		myCells[i][j]=new Cell(State.DEAD,j,i);
        	}
        }
        
        World newWorld = new World(myCells, new Random());
        String expected = "  0123456789\n"
                        + "0 ..........\n"
                        + "1 ..........\n"
                        + "2 ..........\n"
                        + "3 ..........\n"
                        + "4 ..........\n"
                        + "5 ..........\n"
                        + "6 ..........\n"
                        + "7 ..........\n"
                        + "8 ..........\n"
                        + "9 ..........\n";
        
        assertEquals(expected,newWorld.toString());
    }
	
	//Test to see if two worlds with same arguments output the same board
	@Test 
	public void testSameBoard(){
		
		World WorldA = new World(5, 1500, 15);
		World WorldB = new World(5, 1500, 15);
		assertEquals(WorldA.toString(), WorldB.toString());
	}
	
	//Test to see if two worlds with different arguments output different boards
		@Test 
		public void testDifferentBoard(){
			
			World WorldA = new World(5, 1500, 15);
			World WorldB = new World(5, 4500, 15);
			assertNotEquals(WorldA.toString(), WorldB.toString());
	}
}

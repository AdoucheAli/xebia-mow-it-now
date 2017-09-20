package fr.xebia.mowitnow;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.xebia.mowitnow.motion.Code;
import fr.xebia.mowitnow.motion.Coordinate;
import fr.xebia.mowitnow.motion.Direction;
import fr.xebia.mowitnow.motion.Position;

public class MowerTest {

	private Mower mower;

	@Before
	public void inti() {
		mower = new Mower();
	}
	
	@Test
	public void shouldNotMoveInYUp() {
		
		int x = 0;
		int y = 1;
		
		//Actual
		mower.setPosition(new Position(x, y, Direction.NORD));
		mower.setSequence(Code.AVANCE);
		String actualPosition =mower.move(new Coordinate(1, 1));
		
		//Expected
		Position expectedPostion = new Position(x, 
				y, mower.getPosition().getDirection());

		assertEquals(expectedPostion.toString(), actualPosition);
	}
	
	@Test
	public void shouldNotMoveInYDown() {
		
		int x = 0;
		int y = 0;
		
		//Actual
		mower.setPosition(new Position(x, y, Direction.SUD));
		mower.setSequence(Code.AVANCE);
		String actualPosition =mower.move(new Coordinate(1, 1));
		
		//Expected
		Position expectedPostion = new Position(x, 
				y, mower.getPosition().getDirection());

		assertEquals(expectedPostion.toString(), actualPosition);
	}
	
	@Test
	public void shouldNotMoveInXRight() {
		
		int x = 1;
		int y = 0;
		
		//Actual
		mower.setPosition(new Position(x, y, Direction.EST));
		mower.setSequence(Code.AVANCE);
		String actualPosition =mower.move(new Coordinate(1, 1));
		
		//Expected
		Position expectedPostion = new Position(x, 
				y, mower.getPosition().getDirection());

		assertEquals(expectedPostion.toString(), actualPosition);
	}
	
	@Test
	public void shouldNotMoveInXLeft() {
		
		int x = 0;
		int y = 0;
		
		//Actual
		mower.setPosition(new Position(x, y, Direction.OUEST));
		mower.setSequence(Code.AVANCE);
		String actualPosition =mower.move(new Coordinate(1, 1));
		
		//Expected
		Position expectedPostion = new Position(x, 
				y, mower.getPosition().getDirection());

		assertEquals(expectedPostion.toString(), actualPosition);
	}
	
	@Test
	public void shouldIncreaseYByOne() {
		
		int x = 0;
		int y = 0;
		
		//Actual
		mower.setPosition(new Position(x, y, Direction.NORD));
		mower.setSequence(Code.AVANCE);
		String actualPosition =mower.move(new Coordinate(10, 10));
		
		//Expected
		Position expectedPostion = new Position(x, 
				y + 1, mower.getPosition().getDirection());

		assertEquals(expectedPostion.toString(), actualPosition);
	}
	
	@Test
	public void shouldIncreaseYByTwo() {
		
		
		int x = 0;
		int y = 0;
		
		//Actual
		mower.setPosition(new Position(x, y, Direction.NORD));
		mower.setSequence(Code.AVANCE + Code.AVANCE);
		String actualPosition = mower.move(new Coordinate(10, 10));
		
		//Expected
		Position expectedPostion = new Position(x, 
				y + 2, mower.getPosition().getDirection());

		assertEquals(expectedPostion.toString(), actualPosition);
	}
	
	@Test
	public void shouldDecreaseYByOne() {
		
		int x = 0;
		int y = 2;
		
		//Actual
		mower.setPosition(new Position(x, y, Direction.SUD));
		mower.setSequence(Code.AVANCE);
		String actualPosition =mower.move(new Coordinate(10, 10));
		
		//Expected
		Position expectedPostion = new Position(x, 
				y - 1, mower.getPosition().getDirection());

		assertEquals(expectedPostion.toString(), actualPosition);
	}
	
	@Test
	public void shouldDecreaseYByTwo() {
		
		
		int x = 0;
		int y = 2;
		
		//Actual
		mower.setPosition(new Position(x, y, Direction.SUD));
		mower.setSequence(Code.AVANCE + Code.AVANCE);
		String actualPosition = mower.move(new Coordinate(10, 10));
		
		//Expected
		Position expectedPostion = new Position(x, 
				y - 2, mower.getPosition().getDirection());

		assertEquals(expectedPostion.toString(), actualPosition);
	}
	
	@Test
	public void shouldIncreaseXByOne() {
		
		int x = 0;
		int y = 0;
		
		//Actual
		mower.setPosition(new Position(x, y, Direction.EST));
		mower.setSequence(Code.AVANCE);
		String actualPosition = mower.move(new Coordinate(10, 10));
		
		//Expected
		Position expectedPostion = new Position(x + 1, 
				y, mower.getPosition().getDirection());

		assertEquals(expectedPostion.toString(), actualPosition);
	}
	
	@Test
	public void shouldIncreaseXByTwo() {
		
		int x = 0;
		int y = 0;
		
		//Actual
		mower.setPosition(new Position(x, y, Direction.EST));
		mower.setSequence(Code.AVANCE + Code.AVANCE);
		String actualPosition = mower.move(new Coordinate(10, 10));
		
		//Expected
		Position expectedPostion = new Position(x + 2, 
				y, mower.getPosition().getDirection());

		assertEquals(expectedPostion.toString(), actualPosition);
	}
	
	@Test
	public void shouldDecreaseXByOne() {
		
		int x = 2;
		int y = 0;
		
		//Actual
		mower.setPosition(new Position(x, y, Direction.OUEST));
		mower.setSequence(Code.AVANCE);
		String actualPosition = mower.move(new Coordinate(10, 10));
		
		//Expected
		Position expectedPostion = new Position(x - 1, 
				y, mower.getPosition().getDirection());

		assertEquals(expectedPostion.toString(), actualPosition);
	}
	
	@Test
	public void shouldDecreaseXByTwo() {
		
		int x = 2;
		int y = 0;
		
		//Actual
		mower.setPosition(new Position(x, y, Direction.OUEST));
		mower.setSequence(Code.AVANCE + Code.AVANCE);
		String actualPosition = mower.move(new Coordinate(10, 10));
		
		//Expected
		Position expectedPostion = new Position(x - 2, 
				y, mower.getPosition().getDirection());

		assertEquals(expectedPostion.toString(), actualPosition);
	}
	
	@Test
	public void shouldTurnRightAndIncreaseXByOne() {
		
		int x = 0;
		int y = 0;
		
		//Actual
		mower.setPosition(new Position(x, y, Direction.NORD));
		mower.setSequence(Code.DROITE + Code.AVANCE);
		String actualPosition = mower.move(new Coordinate(10, 10));
		
		//Expected
		Position expectedPostion = new Position(x + 1, 
				y, Direction.EST);

		assertEquals(expectedPostion.toString(), actualPosition);
	}
	
	@Test
	public void shouldTurnLeftAndDecreaseXByOne() {
		
		int x = 5;
		int y = 0;
		
		//Actual
		mower.setPosition(new Position(x, y, Direction.NORD));
		mower.setSequence(Code.GAUCHE + Code.AVANCE);
		String actualPosition = mower.move(new Coordinate(10, 10));
		
		//Expected
		Position expectedPostion = new Position(x - 1, 
				y, Direction.OUEST);

		assertEquals(expectedPostion.toString(), actualPosition);
	}
	
	@Test
	public void shouldTurnRightAndDecreaseYByOne() {
		
		int x = 0;
		int y = 5;
		
		//Actual
		mower.setPosition(new Position(x, y, Direction.EST));
		mower.setSequence(Code.DROITE + Code.AVANCE);
		String actualPosition = mower.move(new Coordinate(10, 10));
		
		//Expected
		Position expectedPostion = new Position(x, 
				y - 1, Direction.SUD);

		assertEquals(expectedPostion.toString(), actualPosition);
	}
	
	@Test
	public void shouldTurnLeftAndIncreaseYByOne() {
		
		int x = 0;
		int y = 5;
		
		//Actual
		mower.setPosition(new Position(x, y, Direction.EST));
		mower.setSequence(Code.GAUCHE + Code.AVANCE);
		String actualPosition = mower.move(new Coordinate(10, 10));
		
		//Expected
		Position expectedPostion = new Position(x, 
				y + 1, Direction.NORD);

		assertEquals(expectedPostion.toString(), actualPosition);
	}
}

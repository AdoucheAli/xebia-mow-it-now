package fr.xebia.mowitnow;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.xebia.mowitnow.motion.Coordinate;
import fr.xebia.mowitnow.motion.Direction;
import fr.xebia.mowitnow.motion.Position;
import fr.xebia.mowitnow.motion.Rotation;

public class DirectionTest {
	
	private Position position;

	@Before
	public void inti() {
		position = new Position();
		position.setCoordinate(new Coordinate(0, 0));
	}
	
	@Test
	public void rotationNordVersEst() {
		
		position.setDirection(Direction.NORD);
		
		position.changeDirection(Rotation.DROITE);
		
		assertEquals(Direction.EST, position.getDirection());
	}
	
	@Test
	public void rotationNordVersOuest() {
		
		position.setDirection(Direction.NORD);
		
		position.changeDirection(Rotation.GAUCHE);
		
		assertEquals(Direction.OUEST, position.getDirection());
	}
	
	@Test
	public void rotationEstVersSud() {
		
		position.setDirection(Direction.EST);
		
		position.changeDirection(Rotation.DROITE);
		
		assertEquals(Direction.SUD, position.getDirection());
	}
	
	@Test
	public void rotationEstVersNord() {
		
		position.setDirection(Direction.EST);
		
		position.changeDirection(Rotation.GAUCHE);
		
		assertEquals(Direction.NORD, position.getDirection());
	}
	
	@Test
	public void rotationSudVersOuest() {
		
		position.setDirection(Direction.SUD);
		
		position.changeDirection(Rotation.DROITE);
		
		assertEquals(Direction.OUEST, position.getDirection());
	}
	
	@Test
	public void rotationSudVersEst() {
		
		position.setDirection(Direction.SUD);
		
		position.changeDirection(Rotation.GAUCHE);
		
		assertEquals(Direction.EST, position.getDirection());
	}
	
	@Test
	public void rotationOuestVersNord() {
		
		position.setDirection(Direction.OUEST);
		
		position.changeDirection(Rotation.DROITE);
		
		assertEquals(Direction.NORD, position.getDirection());
	}
	
	@Test
	public void rotationOuestVersSud() {
		
		position.setDirection(Direction.OUEST);
		
		position.changeDirection(Rotation.GAUCHE);
		
		assertEquals(Direction.SUD, position.getDirection());
	}
}

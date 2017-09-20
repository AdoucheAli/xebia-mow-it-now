package fr.xebia.mowitnow;

import java.util.HashMap;

import fr.xebia.mowitnow.motion.Code;
import fr.xebia.mowitnow.motion.Coordinate;
import fr.xebia.mowitnow.motion.Direction;
import fr.xebia.mowitnow.motion.Position;
import fr.xebia.mowitnow.motion.Rotation;

public class Mower {

	private Position position;
	private String sequence;
	public static final HashMap<Direction, Integer> mapDirectionMove = new HashMap<>();

	static {
		mapDirectionMove.put(Direction.NORD, 1);
		mapDirectionMove.put(Direction.EST, 1);
		mapDirectionMove.put(Direction.SUD, -1);
		mapDirectionMove.put(Direction.OUEST, -1);
	}

	public Mower() {
	}

	public Mower(Position position) {
		super();
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getSequence() {
		return sequence;
	}
	
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	
	public String move(Coordinate coordTopRightCorner) {
		String[] motions = null;

		if (sequence != null && !sequence.isEmpty()) {
			motions = sequence.split("");

			for (String motion : motions) {
				switch (motion) {

				case Code.DROITE:
				case Code.GAUCHE:
					position.changeDirection(Rotation.findByCode(motion));
					break;
				case Code.AVANCE:
					moveForward(coordTopRightCorner);
					break;
				}
			}
		}
		
		return position.toString();
	}

	private void moveForward(Coordinate coordTopRightCorner) {
		
		int mvt = mapDirectionMove.get(position.getDirection()).intValue();

		switch (position.getDirection().getAbbreviation()) {

		case Code.NORD:
		case Code.SUD:
			if( isOnTheGrassY(coordTopRightCorner, mvt)) {
				position.getCoordinate().setY(position.getCoordinateY() + mvt);
			}
			break;

		case Code.EST:
		case Code.OUEST:
			if( isOnTheGrassX(coordTopRightCorner, mvt)) {
				position.getCoordinate().setX(position.getCoordinateX() + mvt);
			}
			break;
		}
	}

	private boolean isOnTheGrassY(Coordinate coordTopRightCorner, int mvt) {
		return position.getCoordinateY() + mvt >= 0 && position.getCoordinateY() + mvt <= coordTopRightCorner.getY();
	}
	
	private boolean isOnTheGrassX(Coordinate coordTopRightCorner, int mvt) {
		return position.getCoordinateX() + mvt >= 0 && position.getCoordinateX() + mvt <= coordTopRightCorner.getX();
	}

}

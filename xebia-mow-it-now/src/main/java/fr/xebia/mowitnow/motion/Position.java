package fr.xebia.mowitnow.motion;


public class Position {
	
	private Coordinate coordinate;
	private Direction direction;
	
	public Position() {}

	public Position(Coordinate coordinate, Direction direction) {
		super();
		this.coordinate = coordinate;
		this.direction = direction;
	}
	
	public Position(int x, int y, Direction direction) {
		super();
		this.coordinate = new Coordinate(x, y);
		this.direction = direction;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public int getCoordinateX() {
		return coordinate.getX();
	}
	
	public int getCoordinateY() {
		return coordinate.getY();
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public void changeDirection(Rotation rotation) {
		
		if( rotation == null || this.getDirection() == null ) {
			throw new NullPointerException("La rotation, la position et la direction ne peuvent être null");
		}
		
		Direction newDirection = null;
		int newIndice = 0;
		int currentIndice = direction.ordinal();
		
		switch (rotation.getSense()) {
		case Code.DROITE:
			newIndice = (currentIndice + 1)%4;
			newDirection = Direction.values()[newIndice];
			break;
		default:
			newIndice = direction.equals(Direction.NORD) ?
					Direction.OUEST.ordinal() : (currentIndice - 1)%4;
			newDirection = Direction.values()[newIndice];
			break;
		}

		direction = newDirection;
	}
	
	@Override
	public String toString() {
		return String.format("%d %d %s", coordinate.getX(), coordinate.getY(), direction.getAbbreviation());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((coordinate == null) ? 0 : coordinate.hashCode());
		result = prime * result
				+ ((direction == null) ? 0 : direction.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (coordinate == null) {
			if (other.coordinate != null)
				return false;
		} else if (!coordinate.equals(other.coordinate))
			return false;
		if (direction != other.direction)
			return false;
		return true;
	}
}

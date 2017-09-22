package fr.xebia.mowitnow.motion;



public enum Direction {
	NORD(Code.NORD) { 
		@Override public Direction turnLeft()	{	return Direction.OUEST;	}
		@Override public Direction turnRight()	{	return Direction.EST;	}
	},
	EST(Code.EST){ 
		@Override public Direction turnLeft()	{	return Direction.NORD;	}
		@Override public Direction turnRight()	{	return Direction.SUD;	}
	},
	SUD(Code.SUD){ 
		@Override public Direction turnLeft()	{	return Direction.EST;	}
		@Override public Direction turnRight()	{	return Direction.OUEST;	}
	},
	OUEST(Code.OUEST){ 
		@Override public Direction turnLeft()	{	return Direction.SUD;	}
		@Override public Direction turnRight()	{	return Direction.NORD;	}
	};
	
	private String abbreviation;
	
	private Direction(final String direction) {
		this.abbreviation = direction;
	}
	
	public String getAbbreviation() {
		return abbreviation;
	}
	
	public static Direction findByCode(String code) {
		
		for (Direction direction : Direction.values()) {
			if(direction.getAbbreviation().equalsIgnoreCase(code)) {
				return direction;
			}
		}
		
		throw new IllegalArgumentException(" le code " + code + " n'existe pas.");
	}
	
	public abstract Direction turnLeft();
	public abstract Direction turnRight();
}

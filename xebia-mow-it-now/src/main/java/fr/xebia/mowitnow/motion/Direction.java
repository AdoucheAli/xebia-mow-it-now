package fr.xebia.mowitnow.motion;



public enum Direction {
	NORD(Code.NORD),
	EST(Code.EST),
	SUD(Code.SUD),
	OUEST(Code.OUEST);
	
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
}

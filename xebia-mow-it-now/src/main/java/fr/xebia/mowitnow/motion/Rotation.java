package fr.xebia.mowitnow.motion;


public enum Rotation {
	DROITE(Code.DROITE),
	GAUCHE(Code.GAUCHE);
	
	private String sense;
	
	private Rotation(final String sense) {
		this.sense = sense;
	}
	
	public String getSense() {
		return sense;
	}
	
	public static Rotation findByCode(String code) {
		
		for (Rotation rotation : Rotation.values()) {
			if(rotation.getSense().equalsIgnoreCase(code)) {
				return rotation;
			}
		}
		
		throw new IllegalArgumentException(" le code " + code + " n'existe pas.");
	}
}

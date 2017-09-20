package fr.xebia.mowitnow;


import java.util.ArrayList;
import java.util.List;

import fr.xebia.mowitnow.motion.Coordinate;

public class Grass {
	
	private Coordinate coordTopRightCorner;
	private List<Mower> mowers;
	
	public Grass() {
		mowers = new ArrayList<>();
	}

	public Coordinate getCoordTopRightCorner() {
		return coordTopRightCorner;
	}

	public void setCoordTopRightCorner(Coordinate coordTopRightCorner) {
		this.coordTopRightCorner = coordTopRightCorner;
	}

	public List<Mower> getMowers() {
		return mowers;
	}
	
	public void setMowers(List<Mower> mowers) {
		this.mowers = mowers;
	}
	
	public void add(Mower mower) {
		mowers.add(mower);
	}

	public String mow() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < mowers.size(); i++) {
			sb.append(mowers.get(i).move(coordTopRightCorner));
			if(i < mowers.size() -1 ) {
				sb.append("\n");
			}
		}
		return sb.toString();
	}
}

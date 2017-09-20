package fr.xebia.mowitnow;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import fr.xebia.mowitnow.motion.Coordinate;
import fr.xebia.mowitnow.motion.Direction;
import fr.xebia.mowitnow.motion.Position;

public class GrassFactory {
	
	public static Grass create(String fileName) throws IOException {
		
		List<String> lines = getFileLines(fileName);
		Grass grass = new Grass();
		
		if(lines != null && !lines.isEmpty() ) {
			setCoordTopRightCorner(lines, grass);
			setMowers(lines, grass);
		}
		
		return grass;
	}

	public static List<String> getFileLines(String fileName)
			throws IOException {
		return Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
	}

	private static void setMowers(List<String> lines, Grass grass) {

		for (int i = 1; i < lines.size(); i++) {
			String[] mowerLine = lines.get(i++).split(" ");
			String sequence = lines.get(i).trim();
			Mower mower = getMower(mowerLine, sequence);
			if(mower != null ) {
				grass.add(mower);
			}	
			
		}
		
	}

	private static Mower getMower(String[] mowerLine, String sequence) {
		Mower mower = null;
		
		if(mowerLine != null && mowerLine.length == 3 && sequence != null) {
			int x = 0;
			int y = 0;
			Direction direction;
			
			try {
				x = Integer.valueOf(mowerLine[0].trim());
				y = Integer.valueOf(mowerLine[1].trim());
			} catch (IllegalArgumentException ex) {
				System.out.println(" Veuillez entrer des chiffres.");
			}
			direction = Direction.findByCode(mowerLine[2].trim());
			
			mower = new Mower();
			mower.setPosition( new Position(new Coordinate(x, y), direction) );
			mower.setSequence(sequence);
		}
		
		return mower;
	}

	private static void setCoordTopRightCorner(List<String> lines, Grass grass) {
		String[] coordTopRightCornerLine = lines.get(0).split(" ");
		int x = 0;
		int y = 0;
		
		if(coordTopRightCornerLine != null && coordTopRightCornerLine.length == 2 ) {
			try {
				x = Integer.valueOf(coordTopRightCornerLine[0].trim());
				y = Integer.valueOf(coordTopRightCornerLine[1].trim());
			} catch (IllegalArgumentException ex) {
				System.out.println(" Veuillez entrer des chiffres.");
			}
			grass.setCoordTopRightCorner(new Coordinate(x, y));
		}
	}

}

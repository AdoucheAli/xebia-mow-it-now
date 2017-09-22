package fr.xebia.mowitnow;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

public class GrassTest {

	@Test
	public void shouldFindFile() {
		try {
			List<String> fileLines = GrassFactory
					.getFileLines("C:\\java\\KSLProject\\xebia-mow-it-now\\src\\test\\resources\\test.txt");
			assertNotNull(fileLines);
			assertNotEquals(0, fileLines.size());

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Test(expected = IOException.class)
	public void shouldReturnIOException() throws IOException {
		List<String> fileLines = GrassFactory
				.getFileLines("C:\\java\\KSLProject\\xebia-mow-it-now\\src\\test\\resources\\notExist.txt");
		assertNull(fileLines);
	}

	@Test
	public void shouldCreateGrassWith2Mows() throws IOException {
		Grass grass = GrassFactory
				.create("C:\\java\\KSLProject\\xebia-mow-it-now\\src\\test\\resources\\test.txt");
		assertEquals(2, grass.getMowers().size());
	}

	@Test
	public void shouldMow() throws IOException {

		// Actual
		Grass grass = GrassFactory
				.create("C:\\java\\KSLProject\\xebia-mow-it-now\\src\\test\\resources\\test.txt");
		String actualPosition = grass.mow();

		// expected
		String expectedPosition = "1 3 N" + "\n" + "5 1 E";

		assertEquals(expectedPosition, actualPosition);
	}
}

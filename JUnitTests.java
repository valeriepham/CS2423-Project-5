import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;

public class JUnitTests {
	
	@Test
	public void testMovieParser() {
		// Tests Movie parser with a movie that's been suspended
		String line = "Star Trek Adventure (1991)              1991 {{SUSPENDED}}";
		Movie movie = new Movie(line);
		String expected1 = "Star Trek Adventure"; // Expected title
		String expected2 = "1991 {{SUSPENDED}}"; // Expected release year
		String expected3 = "(1991)"; // Expected year (with potential Roman Numeral)
		String expected4 = "N/A"; // Expected venue (none)

		String actual1 = movie.getTitle();
		String actual2 = movie.getReleaseYear();
		String actual3 = movie.getYearWithNumeral();
		String actual4 = movie.getVenue();

		/*
		 * assertEquals(expected1, actual1);
		 * assertEquals(expected2, actual2);
		 * assertEquals(expected3, actual3);
		 * assertEquals(expected4, actual4);
		 */
		
		fail("Not yet implemented");
		
		// Tests Movie parser with no venue
		String line2 = "Beyond the Five Year Mission: The Evolution of Star Trek "
				+ "- The Next Generation  (2014)  2014";
		String expected5 = "Beyond the Five Year Mission: The Evolution of Star Trek "
				+ "- The Next Generation"; // Expected title
		String expected6 = "2014"; // Expected release year
		String expected7 = "(2014)"; // Expected year (with potential Roman Numeral)
		String expected8 = "N/A"; // Expected venue (none)

		Movie movie2 = new Movie(line2); // Constructs Movie object with line

		String actual5 = movie2.getTitle();
		String actual6 = movie2.getReleaseYear();
		String actual7 = movie2.getYearWithNumeral();
		String actual8 = movie2.getVenue();

		/*
		 * assertEquals(expected5, actual5);
		 * assertEquals(expected6, actual6);
		 * assertEquals(expected7, actual7);
		 * assertEquals(expected8, actual8);
		 */

		fail("Not yet implemented");

		// Tests Movie parser with unknown release year
		String line3 = "Star Trek Equinox: The Night of Time (????) (TV)    ????";
		Movie movie3 = new Movie(line3); // Constructs Movie object with line
		String expected9 = "Star Trek Equinox: The Night of Time"; // Expected title
		String expected10 = "UNSPECIFIED"; // Expected release year
		String expected11 = "(UNSPECIFIED)"; // Expected year (with potential Roman Numeral)
		String expected12 = "TV"; // Expected venue (none)

		String actual9 = movie3.getTitle();
		String actual10 = movie3.getReleaseYear();
		String actual11 = movie3.getYearWithNumeral();
		String actual12 = movie3.getVenue();

		assertEquals(expected9, actual9);
		assertEquals(expected10, actual10);
		assertEquals(expected11, actual11);
		assertEquals(expected12, actual12);
	} // end testMovieParser

	@Test
	public void testSeriesParser() throws IOException, FileNotFoundException {
		// Test constructors given concrete series and episode information
		String line = "Star Trek: The Next Generation (1987)			1987-1994";

		Series series = new Series(line); // Constructs Series object with line

		String expected1 = "Star Trek: The Next Generation"; // Expected series object series title
		String expected2 = "(1987)"; // Expected series start year
		String expected3 = "1987-1994"; // Expected series run years
		int expected4 = 0; // Expected size of the series episode list

		String actual1 = series.getTitle(); // Actual series object series title
		String actual2 = series.getReleaseYear(); // Actual series start year
		String actual3 = series.getRunningYears(); // Actual series run years
		int actual4 = series.getEpisodes().size(); // Actual length of the series episode list

		/*
		 * assertEquals(expected1, actual1);
		 * assertEquals(expected2, actual2);
		 * assertEquals(expected3, actual3);
		 * assertEquals(expected4, actual4);
		 */

		fail("Not yet implemented");

		// Test constructors given unspecified series information
		String line2 = "Star Trek: Constellation (2016)			2016-????";

		Series series2 = new Series(line); // Constructs Series object with line

		String expected5 = "Star Trek: Constellation"; // Expected series object series title
		String expected6 = "(2016)"; // Expected series start year
		String expected7 = "2016-UNSPECIFIED"; // Expected series run years
		int expected8 = 0; // Expected size of the series episode list

		String actual5 = series2.getTitle(); // Actual series object series title
		String actual6 = series2.getReleaseYear(); // Actual series start year
		String actual7 = series2.getRunningYears(); // Actual series run years
		int actual8 = series2.getEpisodes().size(); // Actual length of the series episode list

		/*
		 * assertEquals(expected5, actual5);
		 * assertEquals(expected6, actual6);
		 * assertEquals(expected7, actual7);
		 * assertEquals(expected8, actual8);
		 */

		fail("Not yet implemented");
	}

	@Test
	public void EpisodeParser() throws IOException {
		// Tests episode parser with season/episode give as YYYY-MM-DD
		String line = "Star Trek Cataja (2013) {Wie alles begann {(2015-04-15)} 2013";
		Episode episode = new Episode(line);
		String expected1 = "Star Trek: Renegades"; // Expected series title
		String expected2 = "Pilot"; // Expected episode title
		String expected3 = "{(2015-04-15)}"; // Expected season and number
		String expected4 = "2015"; // Expected episode air year

		String actual1 = episode.getSeriesTitle(); // Actual episode title
		String actual2 = episode.getTitle(); // Actual episode title
		String actual3 = episode.getSeasonAndEpisodeNum(); // Actual season and episode number
		String actual4 = episode.getReleaseYear(); // Actual episode air year

		/*
		 * assertEquals(expected5, actual5);
		 * assertEquals(expected6, actual6);
		 * assertEquals(expected7, actual7);
		 * assertEquals(expected8, actual8);
		 */

		fail("Not yet implemented");

		// Test constructors given a series with multiple episodes
		String line2 = "Star Trek: Renegades (2015) {Pilot  (#1.1)}		2015";
		Episode episode2 = new Episode(line2); // Constructs Series object with line

		String expected5 = "Star Trek: Renegades"; // Expected episode's series title
		String expected6 = "Pilot"; // Expected episode title
		String expected7 = " {(2015-04-15)}"; // Expected season and number
		String expected8 = "2015"; // Expected episode air year

		String actual5 = episode2.getSeriesTitle(); // Actual series title
		String actual6 = episode2.getTitle(); // Actual episode title
		String actual7 = episode2.getSeasonAndEpisodeNum(); // Actual season and episode number
		String actual8 = episode2.getReleaseYear(); // Actual episode air year

		/*
		 * assertEquals(expected5, actual5);
		 * assertEquals(expected6, actual6);
		 * assertEquals(expected7, actual7);
		 * assertEquals(expected8, actual8);
		 */

		fail("Not yet implemented");
	}

	@Test
	public void testMediaSearchExactTitle() throws FileNotFoundException, IOException {
		// Tests data for searching by exact title
		Movie movie1 = new Movie("Star Trek Beyond (2016)                 2016");
		Movie movie2 = new Movie("William Shatner's Memories (1995) (V)     1995");
		Movie movie3 = new Movie("Star Trek: Phoenix - Cloak & Dagger Part I (2010) (V)   2010");

		ArrayList<Media> test = new ArrayList<Media>();
		test.add(movie1);
		test.add(movie2);
		test.add(movie3);

		// ArrayList<Media> actual = Driver.searchMediaExactTitle("Star Trek Beyond", test);
		ArrayList<Media> expected = new ArrayList<Media>();
		expected.add(movie1);

		// assertEquals(expected, actual);

		fail("Not yet implemented");

		// Test to make sure database only grabs exact title - no partials
		ArrayList<Media> expected2 = new ArrayList<Media>();
		
		// ArrayList<Media> actual2 = Driver.searchMediaExactTitle("Star Trek", test);

		// assertEquals(expected2, actual2);

		fail("Not yet implemented");
	}
}
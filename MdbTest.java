import static org.junit.Assert.*;
import java.util.LinkedHashMap;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;

public class MdbTest {

	@Test
	public void testMovieParser() {
		// Tests Movie parser when a movie that's been suspended
		String line = "Star Trek Adventure (1991)              1991 {{SUSPENDED}}";
		Movie movie = new Movie(line);
		String expected1 = "Star Trek Adventure"; // Expected title
		String expected2 = "1991 {{SUSPENDED}}"; // Expected release year
		String expected3 = "(2014)"; // Expected year (with potential Roman Numeral)
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
		Movie movie2 = new Movie(line2); // Constructs Movie object with line

		String expected5 = "Beyond the Five Year Mission: The Evolution of Star Trek " + "- The Next Generation"; // Expected
																													// title
		String expected6 = "2014"; // Expected release year
		String expected7 = "(2014)"; // Expected year (with potential Roman Numeral)
		String expected8 = "N/A"; // Expected venue (none)

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

		/*
		 * assertEquals(expected9, actual9);
		 * assertEquals(expected10, actual10);
		 * assertEquals(expected11, actual11);
		 * assertEquals(expected12, actual12);
		 */

		fail("Not yet implemented");
	}

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
	public void testActorParser() {
		// Tests parsing a line into an Actor object
		Actor actor = new Actor("Watson, Emma (II) 'Harry Potter': Behind the Magic (2001) (TV) [Herself]");
		String expected1 = "Emma"; // Expected first name
		String expected2 = "Watson"; // Expected last name
		String expected3 = "(II)"; // Expected disambiguation number
		Credit expected4 = new Credit("'Harry Potter': Behind the Magic (2001) (TV) [Herself]");
		String expected5 = "Herself"; // Expected role
		ArrayList<String> expected6 = new ArrayList<String>(); // Expected parenthetical notes

		String actual1 = actor.getFirstName(); // Actual first name
		String actual2 = actor.getLastName(); // Actual last name
		String actual3 = actor.getDisambiguationNum(); // Actual disambiguation number
		ArrayList<Credit> actual4 = actor.getCredits(); // Actual credits
		String actual5 = actual4.get(0).getRole(); // Actual role
		ArrayList<String> actual6 = actual4.get(0).getNotes(); // Actual parenthetical notes
		

		/*
		 * assertEquals(expected1, actual1);
		 * assertEquals(expected2, actual2);
		 * assertEquals(expected3, actual3);
		 * assertEquals(expected4, actual4);
		 * assertEquals(expected5, actual5);
		 * assertEquals(expected6, actual6);
		 */

		fail("Not yet implemented");
	}

	@Test
	public void testDirectorParser() {
		// Tests parsing a line into a Director object
		Director director = new Director("Park, Chanyeol    EXO Showtime (2013) (TV)");
		String expected1 = "Chanyeol"; // Expected first name
		String expected2 = "Park"; // Expected last name
		String expected3 = "N/A"; // Expected disambiguation number
		Credit expected4 = new Credit("EXO Showtime (2013) (TV)");
		String expected5 = ""; // Expected role (directors have none)
		String expected6 = ""; // Expected billing order (directors have none)

		String actual1 = director.getFirstName(); // Actual first name
		String actual2 = director.getLastName(); // Actual last name
		String actual3 = director.getDisambiguationNum(); // Actual disambiguation number
		ArrayList<Credit> actual4 = director.getCredits(); // Actual credits

		String actual5 = actual4.get(0).getRole(); // Actual role (none)
		String actual6 = actual4.get(0).getBillingOrder(); // Actual billing order (none)

		/*
		 * assertEquals(expected1, actual1);
		 * assertEquals(expected2, actual2);
		 * assertEquals(expected3, actual3);
		 * assertEquals(expected4, actual4);
		 * assertEquals(expected5, actual5);
		 * assertEquals(expected6, actual6);
		 */

		fail("Not yet implemented");
	}

	@Test
	public void testProducerParser() {
		// Tests parsing a line into a Producer object
		Producer producer = new Producer("Oh, Sehun (I)   Mathematica (2016) (V)");
		String expected1 = "Sehun"; // Expected first name
		String expected2 = "Oh"; // Expected last name
		String expected3 = "(I)"; // Expected disambiguation number
		Credit expected4 = new Credit("Mathematica (2016) (V)"); // Expected
																	// credits
		String expected5 = ""; // Expected role (producers have none)
		String expected6 = ""; // Expected billing order (producers none)

		String actual1 = producer.getFirstName(); // Actual first name
		String actual2 = producer.getLastName(); // Actual last name
		String actual3 = producer.getDisambiguationNum(); // Actual disambiguation number
		ArrayList<Credit> actual4 = producer.getCredits(); // Actual credits
		String actual5 = actual4.get(0).getRole(); // Actual role (none)
		String actual6 = actual4.get(0).getBillingOrder(); // Actual billing order (none)

		/*
		 * assertEquals(expected1, actual1);
		 * assertEquals(expected2, actual2);
		 * assertEquals(expected3, actual3);
		 * assertEquals(expected4, actual4);
		 * assertEquals(expected5, actual5);
		 * assertEquals(expected6, actual6);
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

		ArrayList<Media> actual = MdbDriver.searchMediaExactTitle("Star Trek Beyond", test);
		ArrayList<Media> expected = new ArrayList<Media>();
		expected.add(movie1);

		// assertEquals(expected, actual);

		fail("Not yet implemented");

		// Test to make sure database only grabs exact title - no partials
		ArrayList<Media> expected2 = new ArrayList<Media>();

		ArrayList<Media> actual2 = MdbDriver.searchMediaExactTitle("Star Trek", test);

		// assertEquals(expected2, actual2);

		fail("Not yet implemented");
	}
	
	@Test
	public void testPersonExactSearch() {
		// Test to make sure database only grabs exact name - no partials
		LinkedHashMap<String, MediaMaker> mediaMakers = new LinkedHashMap<String, MediaMaker>();
		// Test media maker data
		Producer producer = new Producer("Oh, Sehun (I)   Mathematica (2016) (V)");
		Director director = new Director("Park, Chanyeol    EXO Showtime (2013) (TV)");
		Actor actor = new Actor("Watson, Emma (II) 'Harry Potter': Behind the Magic (2001) (TV) [Herself]");
		ArrayList<MediaMaker> expected = new ArrayList<MediaMaker>(); // Expecting empty AL
		
		// Media makers keyed by full name
		mediaMakers.put("Sehun Oh", producer);
		mediaMakers.put("Chanyeol Park", director);
		mediaMakers.put("Emma Watson", actor);
		
		Mdb mdb = new Mdb(mediaMakers); // Media makers inserted into database
		
		ArrayList<MediaMaker> actual = MdbDriver.searchPersonExactTitle("Chanyeol");
		
		// assertEquals(expected, actual);
		
		fail("Not yet implemented");
		
		// Tests search when a match(s) is found
		ArrayList<MediaMaker> expected2 = new ArrayList<MediaMaker>(); // Expecting a result
		
		expected2.add(producer);
		
		ArrayList<MediaMaker> actual2 = MdbDriver.searchPersonExactTitle("Sehun Oh");
	
		// assertEquals(expected2, actual2);
		
		fail("Not yet implemented");	
	}

	@Test
	public void testPersonPartialTitle() {
		// Test data for searching by partial title
		Producer producer = new Producer("Do, Kyungsoo   Self Righteous (2015) (TV)");
		Director director = new Director("Kim, Jongin    Don't (2014) (V)(archive footage) (uncredited)");
		Actor actor = new Actor("Murakami, Sai (I)		\"Juvenile God\" (1981) {(2015-04-15)} "
				+ "(archive footage) [Sehun Oh]");		
		LinkedHashMap<String, MediaMaker> test = new LinkedHashMap<String, MediaMaker>();
		test.put("Kyungsoo Do", producer);
		test.put("Jongin Kim", director);
		test.put("Sai Murakami", actor);
		
		// Expected results
		ArrayList<MediaMaker> expected = new ArrayList<MediaMaker>();
		expected.add(producer);
		
		ArrayList<MediaMaker> actual = MdbDriver.searchPersonPartialTitle("Kyungsoo");

		// assertEquals(expected, actual);

		fail("Not yet implemented");
	}

	@Test
	public void testMediaPartialTitle() {
		// Test data for searching by partial name
		Movie movie1 = new Movie("Star Trek Beyond (2016)                 2016");
		Movie movie2 = new Movie("Ultimate Trek (3012)                3012");
		Movie movie3 = new Movie("Star Trek: Of Gods and Men (2007) (V)           2007");
		ArrayList<Media> test = new ArrayList<Media>();

		test.add(movie1);
		test.add(movie2);
		test.add(movie3);

		ArrayList<Media> actual = MdbDriver.searchMediaPartialTitle("Star Trek", test);
		ArrayList<Media> expected = new ArrayList<Media>();
		expected.add(movie1);
		expected.add(movie3);

		// assertEquals(expected, actual);

		fail("Not yet implemented");
	}

	@Test
	public void testSearchByYear() {
		// Test data of movies for searching by year
		Movie movie1 = new Movie("Star Trek (2009)                    2009");
		Movie movie2 = new Movie("Star Trek: Captain Pike (2016)              2016");
		Movie movie3 = new Movie("Star Trek: Gene Rodenberry's Vision (2009) (V)      2009");
		Movie movie4 = new Movie("Star Trek Alpha Strike (2010)               2010");
		Movie movie5 = new Movie("Star Trek Beyond (2016)                 2016");
		Movie movie6 = new Movie("Star Trek III: The Search for Spock (1984)      1984");

		// Test Media ArrayList
		ArrayList<Media> test1 = new ArrayList<Media>();
		test1.add(movie1);
		test1.add(movie2);
		test1.add(movie3);

		ArrayList<Media> actual1 = MdbDriver.searchByYear(test1, "2009");
		ArrayList<Media> expected1 = new ArrayList<Media>();
		expected1.add(movie1);
		expected1.add(movie3);

		// assertEquals(expected1, actual1);

		fail("Not yet implemented");

		// If user searches a list of years (including a running year)
		ArrayList<Media> test2 = new ArrayList<Media>();
		test2.add(movie1);
		test2.add(movie2);
		test2.add(movie3);
		test2.add(movie4);
		test2.add(movie5);
		test2.add(movie6);

		ArrayList<Media> actual2 = MdbDriver.searchByYear(test2, "2009, 2010-2012, 2000");
		ArrayList<Media> expected2 = new ArrayList<Media>();
		expected2.add(movie1);
		expected2.add(movie3);
		expected2.add(movie4);

		// assertEquals(expected2, actual2);

		fail("Not yet implemented");

		// If user searches multiple years
		ArrayList<Media> test3 = new ArrayList<Media>();
		test3.add(movie1);
		test3.add(movie2);
		test3.add(movie3);
		test3.add(movie4);
		test3.add(movie5);
		test3.add(movie6);

		ArrayList<Media> actual3 = MdbDriver.searchByYear(test3, "2000-2016");
		ArrayList<Media> expected3 = new ArrayList<Media>();
		expected3.add(movie1);
		expected3.add(movie3);
		expected3.add(movie4);
		expected3.add(movie2);
		expected3.add(movie5);

		// assertEquals(expected3, actual3);

		fail("Not yet implemented");
	}

	@Test
	public void testRemoveEpisodes() {
		// Episodes to remove
		Episode episode1 = new Episode("EPISODE: Star Trek: New Voyages: Blood and Fire: Part One (2008)");
		Episode episode2 = new Episode("EPISODE: Star Trek: New Voyages: Blood and Fire: Part Two (2009)");
		Episode episode3 = new Episode("EPISODE: Star Trek: New Voyages: Bread and Savagery (UNSPECIFIED)");
		Episode episode4 = new Episode("EPISODE: Star Trek: New Voyages: Center Seat (2006)");
		Episode episode5 = new Episode("EPISODE: Star Trek: New Voyages: Come What May (2004)");
		Episode episode6 = new Episode("EPISODE: Star Trek: New Voyages: Enemy: Starfleet! (2011)");

		ArrayList<Media> test = new ArrayList<Media>(); // List of test episodes
		Mdb mdb = new Mdb(test); // Stores test episodes into database

		test.add(episode1);
		test.add(episode2);
		test.add(episode3);
		test.add(episode4);
		test.add(episode5);
		test.add(episode6);

		ArrayList<Media> actual = mdb.removeEpisodes(test);
		ArrayList<Media> expected = new ArrayList<Media>(); // Expecting empty ArrayList

		// assertEquals(expected, actual);

		fail("Not yet implemented");
	}
}

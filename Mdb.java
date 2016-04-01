import java.io.FileNotFoundException;
import java.io.EOFException;
import java.util.LinkedHashMap;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.util.regex.*;

/**
 * Project #3
 * CS 2334, Section 010
 * Mar 7, 2016
 * <P>
 * A class that acts as a abstract data type that stores data for movies, series
 * (with episodes included within series), and media makers. A file from user
 * keyboard will be opened and read in by line. Each line(s) represents a movie,
 * series, or media maker where the line is parsed to make up fields used to
 * construct Movie, Series, and objects of the MediaMaker superclass to be
 * stored in the database. User search will be looked through this array for
 * matches and results will be returned to the main method. If user requests to
 * take out episodes. The movie database will store results to either a text or
 * binary data file when requested by the user.
 * </P>
 * 
 * @version 1.0
 */
public class Mdb {
	/** A Media ArrayList that stores all Media objects into the database.*/
	private ArrayList<Media> media;
	
	/**
	 * A LinkedHashMap that stores all media makers with their
	 * names as keys.
	 */
	private LinkedHashMap<String, MediaMaker> mediaMakers;

	/**
	 * A default constructor for a media/media maker database that constructs an
	 * empty list of media within the media database.
	 */
	public Mdb() {
		// TODO
	} // end Mdb

	/**
	 * A constructor for a media/media maker database that stores a list of
	 * media to the variable media.
	 * 
	 * @param media	List of media desired to be stored.
	 */
	public Mdb(ArrayList<Media> media) {
		// TODO
	} // end Mdb
	
	/**
	 * A constructor for a media database that stores a list of media to the
	 * variable media.
	 * 
	 * @param mediaMakers	A LinkedHashMap storing keys and values of a list media
	 *                      makers.
	 */
	public Mdb(LinkedHashMap<String, MediaMaker> mediaMakers) {
		// TODO
	} // end Mdb
	
	/**
	 * A constructor for a media/media maker database that stores a list media to the
	 * and a list of media makers' keys with their values.
	 * 
	 * @param	media	List of media desired to be stored.
	 * @param	mediaMakers	A LinkedHashMap storing keys and values of a list media
	 *                      makers.
	 */
	public Mdb(ArrayList<Media> media, LinkedHashMap<String, MediaMaker> mediaMakers) {
		// TODO
	} // end Mdb

	/**
	 * Opens a file containing a list of either media or media makers list
	 * and reads it in line by line. These lines are parsed into objects
	 * of the type based on the int passed that dictates if the file being
	 * read is the movie, series, actor, producer, or director file.
	 * <P>
	 * Algorithm:<br>
	 * 1. Opening and reading in a data file line by line.<br>
	 * 2. Determines what type of object the file holds.<br>
	 * 3. Constructs objects of the type determined with each line.<br>
	 * </P>
	 * 
	 * @param	fileName	A string containing the name of the file
	 *                      that will be opened.
	 * @param	precedence	An int indicating which file is being read.
	 * @exception FileNotFoundException	Thrown when the file name cannot be found.
	 *            IOException	Thrown when the file name cannot be found.
	 */
	public void readTextFile(String fileName, int precedence) throws FileNotFoundException, IOException {
		// TODO
	} // end readFile

	/**
	 * Reads binary file and constructs objects by their serialization.
	 * Constructs a media or media maker object after reading it to add
	 * to the database/
	 * <P>
	 * Algorithm:<br>
	 * 1. Opening and reading in a data file line by line.<br>
	 * 2. Determines what type of object to construct based on serialization.<br>
	 * 3. Constructs objects of the type determined with each line until end of file.<br>
	 * </P>
	 * 
	 * @param	fileName	A string containing the name of the file
	 *                      that will be opened.
	 * @exception	FileNotFoundException	Thrown when the file name cannot be found.
	 * @exception	IOException	Thrown when the file name cannot be found.
	 * @exception	ClassNotFoundException	Thrown when class of a serialized object
	 *                                      cannot be found.
	 * @exception	EOFException	Thrown when data input stream hits end of stream.
	 */
	public void readBinaryFile(String fileName)
			throws FileNotFoundException, IOException, ClassNotFoundException, EOFException {
		// TODO
	}

	/**
	 * Called when user is asked what type of media to search for. Based on
	 * their desired type, inserts all media objects into a new list of that
	 * type and returns it.
	 * <P>
	 * Algorithm:<br>
	 * 1. Take out media of any type user doesn't want included in the search.
	 * <br>
	 * 2. Checks if user's desired search type is movie, series, or both.<br>
	 * 3. Takes out media of any undesired type - returns entire database if
	 * none removed.<br>
	 * </P>
	 * 
	 * @param searchTypeOfMedia
	 *            A string indicating type wanted to search for.
	 * @return A list of all the media of the type user wants to search for.
	 */
	public ArrayList<Media> getMediaSearchList(String searchTypeOfMedia) {
		// TODO
		// If user only wants to search for movies, finds all movies
		
		// If user only wants to search for series, finds all series
		
		// If user wants to search for both series and movies
		
		return null; // Returns list of all media that matched user's desired type
	}
	
	/**
	 * Removes episodes from list of matches as requested by user.
	 * 
	 * @param	list	A current list of media that match user's search.
	 * @return	A modified list after taking out episodes in user's search.
	 */
	public ArrayList<Media> removeEpisodes(ArrayList<Media> list) {
		// TODO
		return null;
	}

	/**
	 * Saves results of user's media search into a text or binary file when
	 * requested by user.
	 * 
	 * @param userFileName	A string storing user's saved results file.
	 * @param results	An ArrayList of user's search results
	 * @exception	IOException	Thrown when the file name cannot be found.
	 */
	public void saveMedia(String userFileName, ArrayList<Media> results) throws IOException {
		// TODO
	}
	
	/**
	 * Saves results of user's media maker search into a text or binary file
	 * when requested by user.
	 * 
	 * @param userFileName	A string storing user's saved results file.
	 * @param results	An ArrayList of user's search results
	 * @exception IOException	Thrown when the file name cannot be found.
	 */
	public void saveMediaMakers(String userFileName, ArrayList<MediaMaker> results) throws IOException {
		// TODO
	}

}
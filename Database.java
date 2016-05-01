import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Project #4 CS 2334, Section 010 April 1, 2016
 * <P>
 * A class that acts as an abstract data type that stores data for movies,
 * series (with episodes included within series), and media makers. A file from
 * user keyboard will be opened and read in by line. Each line(s) represents a
 * movie, series, or media maker where the line is parsed to make up fields used
 * to construct objects of MediaMaker and the Media subclasses to be stored in
 * the database. A binary file containing this data can also be read in and
 * stored to the database with serialization. User's search will be looked
 * within for matches and results will be returned to the main method. If user
 * requests to take out episodes. The movie database will store results to
 * either a text or binary data file when requested by the user.
 * </P>
 * 
 * @version 1.0
 */
public class Database implements Serializable {
	/** A serial version ID number for serialization with binary files. */
	private static final long serialVersionUID = 4118527205817727141L;

	/** A Media ArrayList that stores all Media objects into the database. */
	private ArrayList<Media> media;

	/**
	 * A LinkedHashMap that stores all media makers with their names as keys.
	 */
	private LinkedHashMap<String, MediaMaker> people;

	/**
	 * A default constructor for the media/media maker database that constructs
	 * an empty list of media and an empty map for media mmakers within the
	 * database.
	 */
	public Database() {
		media = new ArrayList<Media>();
		people = new LinkedHashMap<String, MediaMaker>();
	} // end Database constructor

	/**
	 * The constructor for a Database object.
	 * 
	 * @param	media	All media to be stored.
	 * @param	people	All media makers to be stored.
	 */
	public Database(ArrayList<Media> media, LinkedHashMap<String, MediaMaker> people) {
		this.media = media;
		this.people = people;
	}

	/**
	 * An accessor for the variable media.
	 *
	 * @return An ArrayList storing all media objects in the database.
	 */
	public ArrayList<Media> getAllMedia() {
		return media;
	} // end getMdbMedia

	/**
	 * A mutator for the variable media.
	 * 
	 * @param	media	An ArrayList containing media objects to be stored in the database.
	 */
	public void setAllMedia(ArrayList<Media> media) {
		this.media = media;
	} // end setAllMedia

	/**
	 * Based on user interaction, returns a list of all of a selected data type.
	 * 
	 * @param	type	Number determining the type of data to put in an AL and	return.
	 * @return	A list of all media of a single type of data as determined by
	 *          user interaction.
	 */
	public ArrayList<Media> getMedia(int type) {
		ArrayList<Media> list = new ArrayList<Media>();

		// If user selected the Movie radio button
		if (type == 1) {
			for (int i = 0; i < media.size(); ++i) {
				if (media.get(i).getClass().getName().equals("Movie")) {
					list.add(media.get(i));
				}
			}
		}

		// If user selected the Series radio button
		else if (type == 2) {
			for (int i = 0; i < media.size(); ++i) {
				if (media.get(i).getClass().getName().equals("Series")) {
					list.add(media.get(i));
				}
			}
		}

		// If user selected the Episode radio button
		else {
			for (int i = 0; i < media.size(); ++i) {
				if (media.get(i).getClass().getName().equals("Episode")) {
					list.add(media.get(i));
				}
			}
		}
		return list;
	} // end getMedia

	/**
	 * Adds a Media object to the database. If the Media object is NOT in the
	 * media AL, add it to the AL.
	 * 
	 * @param	media2	The media object to be added.
	 * @return	A boolean value determining if the media object was added.
	 */
	public boolean addMedia(Media media2) {
		// Checks if there's no media in the database. If not, goes ahead and adds
		if (media.size()==0){
			media.add(media2);
			return true;
		}
		
		// Checks if the database already contains the media object, if so, does not add
		for (Iterator<Media> it = media.iterator(); it.hasNext();) {
			if (!it.next().getTitle().contains(media2.getTitle())) {
				media.add(media2);
				return true;
			}
		}

		return false; // If object was not added
	} // end addMedia

/**
	 * Replaces a Media object in the database. If the Media object IS in the
	 * media AL, then remove the old object and replace with new.
	 * 
	 * @param	media2	The media object to be replaced.
	 * @param	toBeDeleted	The media object to be deleted
	 * @return	A boolean value determining if the media object was found and replaced.
	 */
	public boolean replaceMedia(Media media2, Media toBeDeleted) {
		
		for (Media m : media) {
			if (m.getTitle().equals(toBeDeleted.getTitle())) {
				int indexblah = media.indexOf(m);
				media.remove(m);
				media.add(indexblah, media2);
				return true;
			}
		}
		return false; // Returns false if media object is not within the database
	} // end replaceMedia

	/**
	 * Deletes a media object within the database if it is in there. If not,
	 * returns a boolean value of false.
	 * 
	 * @param	media2	The media object to be deleted.
	 * @return	A boolean value determining if the media object was found and deleted.
	 */
	public boolean deleteMedia(Media media2) {
		for (Iterator<Media> it = media.iterator(); it.hasNext();) {
			if (it.next() == media2) {
				System.out.println("Media found in media list, ready to delete.");
				media.remove(media2);
				return true;
			}
		}
		return false;
	} // end deleteMedia

	/**
	 * Deletes media of a specific type from the database.
	 * 
	 * @param type	the type of Media. 1 is Movie, 2 is Series, 3 is Episode
	 */
	public void clearMedia(int type) {
		if (type == 1) {
			for (Iterator<Media> it = media.iterator(); it.hasNext();) {
				if (it.next().getClass() == Movie.class) {
					it.remove();
				}
			}
		}

		else if (type == 2) {
			for (Iterator<Media> it = media.iterator(); it.hasNext();) {
				if (it.next().getClass() == Series.class) {
					it.remove();
				}
			}
		}
		
		else if (type == 3) {
			for (Iterator<Media> it = media.iterator(); it.hasNext();) {
				if (it.next().getClass() == Episode.class) {
					it.remove();
				}
			}
		}
		
		else if (type == 4) {
			media = new ArrayList<Media>();
		}
	} // end clearMedia

	/**
	 * An accessor for the variable people.
	 *
	 * @return An ArrayList storing all media maker objects in the database.
	 */
	public LinkedHashMap<String, MediaMaker> getAllPeople() {
		return people;
	} // end getAllPeople

	/**
	 * A mutator for the variable people.
	 * 
	 * @param	people	A LinkedHashMap of people to be stored in the database.
	 */
	public void setAllPeople(LinkedHashMap<String, MediaMaker> people) {
		this.people = people;
	} // end setAllPeople

	/**
	 * Based on user interaction, returns a list of all of a selected media maker type.
	 * 
	 * @param type	Number determining the type of media maker to put in an AL and return.
	 * @return	A list of all media makers of a single type of data as determined by
	 *          user interaction.
	 */
	public ArrayList<MediaMaker> getPeople(int type) {
		ArrayList<MediaMaker> dbPeopleList = new ArrayList<MediaMaker>(people.values());
		ArrayList<MediaMaker> list = new ArrayList<MediaMaker>();

		// If user selected Actors, adds all media makers only have acting credits to list
		if (type == 1) {
			for (int i = 0; i < dbPeopleList.size(); ++i) {
				if (dbPeopleList.get(i).getActingCredits().size() != 0) {
					list.add(dbPeopleList.get(i));
				}
			}
		}
		
		// If user selected Directors, adds all media makers that have directing credits to list
		else if (type == 2) {
			for (int i = 0; i < dbPeopleList.size(); ++ i) {
				if (dbPeopleList.get(i).getDirectingCredits().size() != 0) {
					list.add(dbPeopleList.get(i));
				}
			}
		}
		
		// If user selected Producers, adds all media makers that have producing credits to list
		else {
			for (int i = 0; i < dbPeopleList.size(); ++i) {
				if (dbPeopleList.get(i).getProducingCredits().size() != 0) {
					list.add(dbPeopleList.get(i));
				}
			}
		}

		return list;
	} // end getPeople

	/**
	 * Returns a MediaMaker object at a certain key from the database.
	 * 
	 * @param name
	 *            A string of the person's name that will locate the person in
	 *            the database.
	 * @return A Media object from the movie database at the key of the LHM.
	 */
	public MediaMaker getPerson(String name) {
		return people.get(name);
	} // end getPerson

	/**
	 * Adds a MediaMaker object to the LHM of people. If the person is NOT
	 * already in the LHM of people, it can be added.
	 * 
	 * @param	person	The person to be added to the database.
	 * @return	A boolean value determining if the media maker was added.
	 */
	public boolean addPerson(MediaMaker person) {
		if (!people.containsKey(person.getName())) {
			people.put(person.getName(), person);
			return true;
		} else {
			return false;
		}
	} // end addPerson

	/**
	 * Replaces a MediaMaker object in the LHM of people. If the person IS
	 * already in the LHM of people, then that person can be replaced.
	 * 
	 * @param	newPerson	Maker to replace the existing maker in the database.
	 * @return	A boolean value determining if the media maker was replaced.
	 */
	public boolean replacePerson(MediaMaker newPerson, MediaMaker toDelete) {
		
		ArrayList<MediaMaker> peopleList = new ArrayList<MediaMaker>(people.values());
		
		// Checks if media maker to be replaced exists within the database
		for (Iterator<MediaMaker> it = peopleList.iterator(); it.hasNext();) {
			if (it.next() == toDelete) {
				people.remove(toDelete.getName());
				people.put(newPerson.getName(), newPerson);
				return true;
			}
		}
		return false;
		
	} // end replacePerson
	/**
	 * Deletes a person from the LHM. If the person IS in the LHM, then he is
	 * deletable.
	 * 
	 * @param	person	The media maker to be deleted within the database.	
	 * @return	A boolean value determining if the media maker was deleted.
	 */
	public boolean deleteMediaMaker(MediaMaker person) {
		// Checks if media maker desired to be deleted exists within the database
		ArrayList<MediaMaker> peopleList = new ArrayList<MediaMaker>(people.values());
				
		for (Iterator<MediaMaker> it = peopleList.iterator(); it.hasNext();) {
			if (it.next() == person) {
				people.remove(person.getName());
				return true;
			}
		}
		return false;
		
	} // end deleteMediaMaker

	/**
	 * Deletes all people of a selected type from the database.
	 * 
	 * @param	type	Type determining which media makers to clear from database.
	 */
	public void clearPeople(int type) {
		ArrayList<MediaMaker> dbPeopleList = new ArrayList<MediaMaker>(people.values());

		// If user selected Actors, clears all media makers that have acting credits from db
		if (type == 1) {
			for (int i = 0; i < dbPeopleList.size(); ++i) {
				if (dbPeopleList.get(i).getActingCredits().size() != 0) {
					people.remove(dbPeopleList.get(i).getName());
				}
			}
		}
		// If user selected Directors, clears all media makers that have directing credits from db
		if (type == 2) {
			for (int i = 0; i < dbPeopleList.size(); ++i) {
				if (dbPeopleList.get(i).getDirectingCredits().size() != 0) {
					people.remove(dbPeopleList.get(i).getName());
				}
			}			
		}
		// If user selected Producers, clears all media makers that have producing credits from db
		if (type == 3) {
			for (int i = 0; i < dbPeopleList.size(); ++i) {
				if (dbPeopleList.get(i).getProducingCredits().size() != 0) {
					people.remove(dbPeopleList.get(i).getName());
				}
			}
		}
		// If user selected Makers, clears all media makers
		if (type == 4) {
			people = new LinkedHashMap<String, MediaMaker>();
		}
	} // end clearPeople

	/**
	 * 
	 */
	public void clearAll() {
		people = new LinkedHashMap<String, MediaMaker>();
		media = new ArrayList<Media>();
	} // end clearAll

	/**
	 * Opens a file containing a list of either media or media makers list and
	 * reads it in line by line. These lines are parsed into objects of the type
	 * based on the int passed that dictates if the file being read is the
	 * movie, series, actor, producer, or director file.
	 * <P>
	 * Algorithm:<br>
	 * 1. Opening and reading in a data file line by line.<br>
	 * 2. Determines what type of object the file holds.<br>
	 * 3. Constructs objects of the type determined with each line.<br>
	 * </P>
	 * 
	 * @param	fileName	A string containing the name of the file that will be opened.
	 * @param	fileType	An int determining which file is being read in.
	 * @exception FileNotFoundException
	 *                Thrown when the file name cannot be found. IOException
	 *                Thrown when the file name cannot be found.
	 */
	public void readTextFile(String fileName, int fileType) throws FileNotFoundException, IOException {
		FileReader fr = new FileReader(fileName); // Opens file
		BufferedReader br = new BufferedReader(fr); // Reads in file

		String nextLine; // String that stores a line from the file

		// File is read line by line until the end of the file
		if (fileType == 1) {
			while ((nextLine = br.readLine()) != null) {
				// Constructs and parses method line to an Movie
				Movie movie = new Movie(nextLine);
				media.add(movie); // Adds movie to media database
			}
		} else if (fileType == 2) {
			// Regex to determine if the series file line is a Series line or an
			// Episode line
			Pattern typeCh1 = Pattern.compile("\\-\\?\\?\\?\\?");
			Pattern typeCh2 = Pattern.compile("\\-[0-9]{4}");
			while ((nextLine = br.readLine()) != null) {

				// boolean lastOfLine = nextLine.endsWith("-????");
				Matcher mTC1 = typeCh1.matcher(nextLine);
				Matcher mTC2 = typeCh2.matcher(nextLine);
				boolean TC1 = mTC1.find();
				boolean TC2 = mTC2.find();

				// If Series line, constructs Series object
				if (TC1 == true | TC2 == true) {
					Series temp = new Series(nextLine);
					media.add(temp);
				}

				// If Episode line, constructs Episode object
				if (TC1 == false && TC2 == false) {
					Episode temp = new Episode(nextLine);
					media.add(temp);
				}
			}
		} else if (fileType == 3) { // A file of actors is read in

			// File is read line by line until the end of the file
			while ((nextLine = br.readLine()) != null) {

				// If the next line has a name use the constructor for MediaMaker
				if (Pattern.compile("([A-Za-z]+),\\s+([A-Za-z]+)").matcher(nextLine).find()) {
					MediaMaker person = new MediaMaker(nextLine, 3, br);
					String name = person.getName();
					people.put(name, person);
				}
			}
		} else if (fileType == 4) { // A file of directors is read in

			// File is read line by line untile the end of the file
			while ((nextLine = br.readLine()) != null) {
				if (Pattern.compile("([A-Za-z]+),\\s+([A-Za-z]+)").matcher(nextLine).find()) {
					// Separate the components of the read-in line into elements of a String array.
					String[] componentsArray = nextLine.split("\\t| ");

					// Cut white space left over from the previous split method.
					for (int i = 0; i <= componentsArray.length - 1; i++) {
						componentsArray[i].trim();
					}

					// Delete empty strings by resorting the string array into a
					// string ArrayList.
					ArrayList<String> components = new ArrayList<String>();
					for (int i = 0; i <= componentsArray.length - 1; i++) {
						if (!(componentsArray[i].isEmpty()))
							components.add(componentsArray[i]);
					}

					// Store name data
					String name = components.get(1) + " " + components.get(0).replaceAll(",", "");
					// Determine if there is a disambiguation number
					String disambigNumber = "";
					for (int i = 0; i < 3; i++) {
						if (components.get(i).matches("\\(\\D{1,4}\\)")) {
							disambigNumber = components.get(i);
							name += " " + disambigNumber;
						}
					}

					if (people.containsKey(name)) {// person with this name in
						// the LHM was found

						people.get(name).getDirectingCredits().add(MediaMaker.parseLine(nextLine, components));
						while ((nextLine = br.readLine()) != null) {
							// Separate the components of the read-in line into
							// elements of a String array.
							String[] componentsArray2 = nextLine.split("\\t| ");

							// Cut white space left over from the previous split
							// method.
							for (int i = 0; i <= componentsArray2.length - 1; i++) {
								componentsArray2[i].trim();
							}

							// Delete empty strings by resorting the string
							// array into a string ArrayList.
							ArrayList<String> components2 = new ArrayList<String>();
							for (int i = 0; i <= componentsArray2.length - 1; i++) {
								if (!(componentsArray2[i].isEmpty()))
									components2.add(componentsArray2[i]);
							}

							if (!nextLine.isEmpty())
								people.get(name).getDirectingCredits().add(MediaMaker.parseLine(nextLine, components2));
							else {
								break;
							}
						}
					} else {// no person in the LHM with this name
						MediaMaker person = new MediaMaker(nextLine, 4, br);
						name = person.getName();
						people.put(name, person);
					}
				}
			}
		} else if (fileType == 5) { // A file of producers is read in

			// File is read in line by line until the end of the file
			while ((nextLine = br.readLine()) != null) {
				if (Pattern.compile("([A-Za-z]+),\\s+([A-Za-z]+)").matcher(nextLine).find()) {

					// Separate the components of the read-in line into elements
					// of a String array.
					String[] componentsArray = nextLine.split("\\t| ");

					// Cut white space left over from the previous split method.
					for (int i = 0; i <= componentsArray.length - 1; i++) {
						componentsArray[i].trim();
					}

					// Delete empty strings by resorting the string array into a
					// string ArrayList.
					ArrayList<String> components = new ArrayList<String>();

					for (int i = 0; i <= componentsArray.length - 1; i++) {
						if (!(componentsArray[i].isEmpty()))
							components.add(componentsArray[i]);
					}

					// Store name data
					String name = components.get(1) + " " + components.get(0).replaceAll(",", "");
					// Determine if there is a disambiguation number
					String disambigNumber = "";
					for (int i = 0; i < 3; i++) {
						if (components.get(i).matches("\\(\\D{1,4}\\)")) {
							disambigNumber = components.get(i);
							name += " " + disambigNumber;
						}
					}

					if (people.containsKey(name)) {// person with this name in
						// the LHM was found

						// Add the first Media object to the already existing person
						people.get(name).getProducingCredits().add(MediaMaker.parseLine(nextLine, components));

						// Continue adding code
						while ((nextLine = br.readLine()) != null) {
							// Separate the components of the read-in line into
							// elements of a String array.
							String[] componentsArray2 = nextLine.split("\\t| ");

							// Cut white space left over from the previous split
							// method.
							for (int i = 0; i <= componentsArray2.length - 1; i++) {
								componentsArray2[i].trim();
							}

							// Delete empty strings by resorting the string
							// array into a string ArrayList.
							ArrayList<String> components2 = new ArrayList<String>();
							for (int i = 0; i <= componentsArray2.length - 1; i++) {
								if (!(componentsArray2[i].isEmpty()))
									components2.add(componentsArray2[i]);
							}
							if (!nextLine.isEmpty())
								people.get(name).getProducingCredits().add(MediaMaker.parseLine(nextLine, components2));
							else {
								break;
							}
						}
					} else {// no person in the LHM with this name
						MediaMaker person = new MediaMaker(nextLine, 5, br);
						name = person.getName();
						people.put(name, person);
					}
				}

			}
		}
		br.close();
	} // end readTextFile

	/**
	 * Reads binary file where the data will be assigned to a casted Mdb and
	 * assigned after serialization to store all media/media maker data.
	 * <P>
	 * Algorithm:<br>
	 * 1. Opening and reading in a data file by input/output stream.<br>
	 * 2. Determines objects to construct and store based on serialization.<br>
	 * 3. Assigns read in object to an Mdb object which is used as the database.
	 * <br>
	 * </P>
	 * 
	 * @param fileName
	 *            A string containing the name of the file that will be opened.
	 * @return An Mdb object that stores all data from the binary file and acts
	 *         as the database.
	 * @exception FileNotFoundException
	 *                Thrown when the file name cannot be found.
	 * @exception IOException
	 *                Thrown when the file name cannot be found.
	 * @exception ClassNotFoundException
	 *                Thrown when class of a serialized object cannot be found.
	 * @exception EOFException
	 *                Thrown when data input stream hits end of stream.
	 */
	public Database readBinaryFile(String fileName)
			throws FileNotFoundException, IOException, ClassNotFoundException, EOFException {
		FileInputStream fileInputStream = new FileInputStream(fileName);
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Database db = (Database) objectInputStream.readObject();
		objectInputStream.close();
		
		// TODO: CAN MORE THAN ONE BINARY FILES BE LOADED? IF SO, NEED TO HANDLE THAT
		return db;
	} // end readBinaryFile

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
		// Stores list of type user searches for
		ArrayList<Media> list = new ArrayList<Media>();

		// If user only wants to search for movies, finds all movies
		if (searchTypeOfMedia.equalsIgnoreCase("m")) {
			for (int i = 0; i < media.size(); ++i) {
				if (media.get(i).getClass().getName().equals("Movie")) {
					list.add(media.get(i)); // Inserts Movie into new list
				}
			}
		}
		// If user only wants to search for series, finds all series
		else if (searchTypeOfMedia.equalsIgnoreCase("s")) {
			for (int i = 0; i < media.size(); ++i) {
				if (media.get(i).getClass().getName().equals("Series")
						| media.get(i).getClass().getName().equals("Episode")) {
					list.add(media.get(i)); // Inserts Series and Episodes into
											// new list
				}
			}
		}
		// If user wants to search for both series and movies
		else {
			list = media;
			; // Inserts the whole database
		}
		return list; // Returns list of all media that matched user's desired type
	}

	/**
	 * Removes episodes from list of matches as requested by user.
	 * 
	 * @param list
	 *            A current list of media that match user's search.
	 * @return A modified list after taking out episodes in user's search.
	 */
	public ArrayList<Media> removeEpisodes(ArrayList<Media> list) {
		// Searches through list of type user searched for and takes out
		// episodes
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i).getClass().getName().equals("Episode")) {
				list.remove(i);
			}
		}
		return list;
	}

	/**
	 * A method to add media from read=in actor, director, and producer files.
	 * 
	 * @param people
	 *            the LHM of priorly constructed MediaMaker objects
	 * @param media
	 *            the AL that contains the media objects
	 */
	public void addNewMediaMakerMedia(LinkedHashMap<String, MediaMaker> people, ArrayList<Media> media) {
		for (MediaMaker person : people.values()) {
			for (Media m : person.getActingCredits()) {
				for (int i = 0; i < media.size(); i++) {
					if (!media.get(i).getTitle().contains(m.getTitle()))
						media.add(m);
				}
			}
			for (Media m : person.getDirectingCredits()) {
				for (int i = 0; i < media.size(); i++) {
					if (!media.get(i).getTitle().contains(m.getTitle()))
						media.add(m);
				}
			}
			for (Media m : person.getProducingCredits()) {
				for (int i = 0; i < media.size(); i++) {
					if (!media.get(i).getTitle().contains(m.getTitle()))
						media.add(m);
				}
			}
		}
	}

	/**
	 * Saves results of user's search into a text file when requested by user.
	 * 
	 * @param	<T>	Represents that the method will take any type of ArrayList to save to a text file.
	 * @param	userFileName	A string storing user's saved results file.
	 * @param	results	An ArrayList of user's search results
	 * @exception	IOException	Thrown when the file name cannot be found.
	 */
	public <T> void saveText(String userFileName,  ArrayList<T> results) throws IOException {
		// creates a FileWriter Object
		FileWriter outfile = new FileWriter(userFileName);
		// creates BufferedWriter to write content to the file
		BufferedWriter bw = new BufferedWriter(outfile);
		
		// Writes results from all media to text file
		for (int i = 0; i < media.size(); ++i) {
			String result = media.get(i).toString();
			bw.write(result);
			bw.newLine();
		}
		
		ArrayList<MediaMaker> makers = (ArrayList<MediaMaker>) people.values();
		
		// Writes results from all of the people to text file
		for (int i = 0; i < people.values().size(); ++i) {
			String result = makers.get(i).toString();
			bw.write(result);
			bw.newLine();
		}
		
		bw.close(); // Close file to save it
	} // end saveText

	/**
	 * Saves results of user's media search into a text or binary file when
	 * requested by user.
	 * 
	 * @param	fileName	A string storing user's saved results file.
	 * @exception IOException	Thrown when the file name cannot be found.
	 */
	public void saveBinary(String fileName) throws IOException {
		// File I/O streams to save to file in binary
		FileOutputStream fos = new FileOutputStream(fileName);
		ObjectOutputStream oos = new ObjectOutputStream(fos); 
		
		oos.writeObject(this); // Writes whole database to file
		oos.close(); // Saves the binary file
	} // end saveBinary
} // end Database Class
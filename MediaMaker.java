import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project #3
 * CS 2334, Section 010
 * 28 March 2016
 * <P>
 * A class used to store information on the people (actors, directors, and producers) 
 * who work on a Media object. 
 * </P>
 * @version 1.0
 */
public class MediaMaker implements Comparable<MediaMaker>, Serializable {
	/** MediaMaker serial version number used during serialization. */
	private static final long serialVersionUID = -7389943293251334299L;

	/** The full name of the person. */
	private String fullName;

	/** The disambiguation number (multiple people of same number) of a person. */
	private String disambigNumber;

	/** The Media objects associated with the person with ACTING credits; will be used for text output
	 * as well as graphical input.
	 */
	private ArrayList<Media> actingCredits;

	/** The Media objects associated with the person with PRODUCING credits; will be used for text output
	 * as well as graphical input.
	 */
	private ArrayList<Media> producingCredits;

	/** The Media objects associated with the person with DIRECTING credits; will be used for text output
	 * as well as graphical input.
	 */
	private ArrayList<Media> directingCredits;	

	/**
	 * A default constructor for MediaMaker that sets all the fields to empty.
	 */
	public MediaMaker()
	{
		fullName = "";
		disambigNumber = "";
		actingCredits = new ArrayList<Media>();
		producingCredits = new ArrayList<Media>();
		directingCredits = new ArrayList<Media>();
	} // end MediaMaker constructor

	/**
	 * Media maker constructor to be used when user adds/edits a media maker through
	 * GUI interaction.
	 * 
	 * @param	firstName	A string storing the media maker's first name.
	 * @param	lastName	A string storing the media maker's last name.
	 * @param	disambigNum	A string storing a Roman Numeral representing a disambiguation number.
	 */
	public MediaMaker(String firstName, String lastName, String disambigNum, ArrayList<Media> acting
			, ArrayList<Media> directing, ArrayList<Media> producing) {
		// Checks if media maker has a disambiguation number for formatting full name
		if (disambigNum.equals("")) {
			fullName = firstName + " " + lastName;
		}
		else {
			fullName = firstName + " " + lastName + "(" + disambigNum + ")";
		}

		disambigNumber = disambigNum;
		actingCredits = acting;
		producingCredits = producing;
		directingCredits = directing;
	} // end MediaMaker constructor

	/**
	 * A constructor for MediaMaker, filling its fields with information from a parsed read line.
	 * 
	 * @param readLine the line to be parsed for actor data
	 * @param	type	A value determining what type of data the file contains.
	 * @param	br	A BufferedReader to read in the file.
	 * @throws	IOException	Thrown when file cannot be found.
	 */
	public MediaMaker(String readLine, int type, BufferedReader br) throws IOException{

		// Code logic:
		// 1. Get a line that HAS lastname, firstname, indicating a new MediaMaker
		// 2. Parse through the first line for name and disambigNumber
		// 3. Use the passed in buffered reader to check the *next* line
		//		a. If the line does NOT have a name, parse it for media type and 
		//		   construct a media type to be added to the appropriate credit AL.
		// 		b. If the line DOES have a name, end the constructor.

		this.fullName = "";
		this.disambigNumber = "";
		this.actingCredits = new ArrayList<Media>();
		this.producingCredits = new ArrayList<Media>();
		this.directingCredits = new ArrayList<Media>();

		//Separate the components of the read-in line into elements of a String array.
		String[] componentsArray = readLine.split("\\t| ");

		//Cut white space left over from the previous split method.
		for (int i = 0; i <= componentsArray.length - 1; i++){ 			
			componentsArray[i].trim();
		}

		//Delete empty strings by resorting the string array into a string ArrayList.
		ArrayList<String> components = new ArrayList<String>();
		for (int i = 0; i <= componentsArray.length - 1; i++){
			if (!(componentsArray[i].isEmpty()))
				components.add(componentsArray[i]);
		}

		if (Pattern.compile("([A-Za-z]+),\\s+([A-Za-z]+)").matcher(readLine).find()){ //if there's a name, fill in name data    	
			//Store name data
			this.fullName = components.get(1) + " " + components.get(0).replaceAll(",", "");

			//Determine if there is a disambiguation number       	
			String disambigNumber = "";
			for (int i = 0; i < 3; i++)
			{
				if(components.get(i).matches("\\(\\D{1,4}\\)"))
				{
					disambigNumber = components.get(i); 
					fullName += " " + disambigNumber;
				}
			}
		}

		Media media = parseLine(readLine, components);
		if (type == 3){ actingCredits.add(media);}
		else if (type == 4) { directingCredits.add(media);}
		else if (type == 5){ producingCredits.add(media);}

		String nextLine;
		while ((nextLine = br.readLine()) != null) { //File is read line by line until the end of the file   	   	

			if (!nextLine.isEmpty()) //if the nextLine isn't a new person (no new line)
			{//Use modified parse methods to store data into an AL.													

				//Separate the components of the NEW line into elements of a String array.
				componentsArray = nextLine.split("\\t| ");

				//Cut white space left over from the previous split method.
				for (int i = 0; i <= componentsArray.length - 1; i++){ 			
					componentsArray[i].trim();
				}

				//Delete empty strings by resorting the string array into a string ArrayList.
				components = new ArrayList<String>();
				for (int i = 0; i <= componentsArray.length - 1; i++){
					if (!(componentsArray[i].isEmpty()))
						components.add(componentsArray[i]);
				}        		

				media = parseLine(nextLine, components); //change this to a parseMovie object

				if (type == 3){ actingCredits.add(media);}
				else if (type == 4){ directingCredits.add(media);}
				else if (type == 5) { producingCredits.add(media);}
			}

			else {//next line had a name, construct a new MediaMaker object
				break;
			}
		}    	
	} // end MediaMaker Constructor

	/**
	 * Determines the type of a line, parses it, and sorts the data into a Media object
	 * @param readLine		the next line of the data, only exists 
	 * @param components	the AL of the first line that belongs to a MediaMaker, contains name and a 
	 * 						Media object to be parsed
	 * @return a Media object to be added to the AL
	 */
	public static Media parseLine(String readLine, ArrayList<String> components)
	{
		// 1. Determine the Media type of the line using regex.
		// 2. Construct a Media object to be returned to add to MediaMaker's AL.

		if (!readLine.contains("\"") && !(Pattern.compile("\\(#\\d+\\.\\d+\\)").matcher(readLine).find()
				|| Pattern.compile("\\d{4}-\\d{2}-\\d{2}").matcher(readLine).find())) //if the line is a movie type
		{	
			Movie movie = new Movie();
			for (String s: components)
			{
				if (s.matches("\\([\\w]{1,2}\\)"))
				{
					StringBuilder sb = new StringBuilder(s);
					sb.deleteCharAt(0); sb.deleteCharAt(sb.length() - 1);
					s = sb.toString();
					movie.setVenue(s);
					break;
				}

			}  		
			for (String s: components)
			{
				if (s.matches("\\(.{4,}\\)"))
				{
					movie.setYearAndNumeral(s);

					//trim unnecessary characters
					Pattern pattern = Pattern.compile("//d{4}"); 
					Matcher matcher = pattern.matcher(s);
					if (matcher.find()) s = matcher.group(0);
					movie.setReleaseYear(s);
					break;
				}
			}

			// Parse for MovieTitle in the line
			String title = "";
			
			 // If the line has a name
			if (Pattern.compile("([A-Za-z]+),\\s*([A-Za-z]+)\\s").matcher(readLine).find())
			{
				boolean containsDisambig = false;
				for (int i = 0; i < 3; i++)
				{
					 // If line has a disambiguation number
					if (components.get(i).matches("\\([\\w]{1,2}\\)"))
					{
						containsDisambig = true;
					}
				}
				if (containsDisambig) //if line has a disambiguation number
				{
					int yearPos = 0;
					for (int a = 0; a < components.size(); a++){
						if (components.get(a).matches("\\(.{4,7}\\)"))
							yearPos = a;
					}   						
					for (int i = 3; i < yearPos; i++){
						title += components.get(i) + " ";
					}

					movie.setTitle(title);
				}  				
				else 
				{//line doesn't contain disambig number
					int yearPos = 0;
					for (int a = 0; a < components.size(); a++){
						if (components.get(a).matches("\\(.{4,}\\)"))
							yearPos = a;
					}	
					for (int i = 2; i < yearPos; i++){
						title += components.get(i) + " ";
					}

					movie.setTitle(title);
				}   

			}
			else { // The line does not have a name

				int yearPos = 0;
				for (int a = 0; a < components.size(); a++){
					if (components.get(a).matches("\\(.{4,7}\\)"))
						yearPos = a;
				}	
				for (int i = 0; i < yearPos ; i++){ // One word titles

					title += components.get(i) + " ";
				}

				movie.setTitle(title);	
			}   

			return movie;
		}
		else  //the line contains data for an Episode
		{    		
			Episode episode = new Episode();

			String epNumber = "";
			//Parse for episode number
			for (String s: components)
			{
				if (Pattern.compile("\\(#\\d+\\.\\d+\\)").matcher(s).find() || 
						Pattern.compile("\\d{4}-\\d{2}-\\d{2}").matcher(s).find())
				{
					//trim unnecessary characters
					Pattern pattern = Pattern.compile("\\(#\\d+\\.\\d+\\)"); 
					Matcher matcher = pattern.matcher(s);
					if (matcher.find()) s = matcher.group(0);
					else {
						pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
						matcher = pattern.matcher(s);
						if (matcher.find()) s = matcher.group(0);
					}

					epNumber = s;
					episode.setNumber(s);
					break;
				}
			} 

			//Parse for episode title
			int titleStart = readLine.indexOf("{");
			int titleEnd = readLine.indexOf("}");
			StringBuilder titleBuilder = new StringBuilder();
			for (int i = titleStart + 1; i < titleEnd; i++)
			{
				if (readLine.charAt(i) != '('){
					titleBuilder.append(readLine.charAt(i));
				}
				else {   				
					break;
				}
			}
			String epTitle = "no title given";
			if (!titleBuilder.toString().isEmpty()){
				epTitle = titleBuilder.toString();
				episode.setTitle(epTitle);
			}
			else {
				epTitle = epNumber;
				episode.setTitle(epNumber);
			}

			//set Year of the series
			String releaseYear = "error";
			for (String s: components)
			{
				if (s.matches("\\(.{4,}\\)"))
				{
					releaseYear = s;
					episode.setYear(s);
					break;
				}
			}

			//Parse for SeriesTitle in the line
			String title = "no series title";
			Pattern typeTitle = Pattern.compile("\"(.*?)\"");
			Matcher titleMatch = typeTitle.matcher(readLine);
			if (titleMatch.find()) title = titleMatch.group(0);   		
			episode.setSeriesTitle(title);

			return episode;
		}    	   
	} // end parseLine

	/**
	 * A method that returns an AL of acting credits attributed to a person (MediaMaker).
	 * @return the AL of Media objects associated with acting credits
	 */
	public ArrayList<Media> getActingCredits(){
		return this.actingCredits;
	} // end getActingCredits

	/**
	 * A method that returns an AL of producing credits attributed to a person (MediaMaker).
	 * 
	 * @return the AL of Media objects associated with producing credits
	 */
	public ArrayList<Media> getProducingCredits(){
		return this.producingCredits;
	} // end getProducingCredits

	/**
	 * A method that returns an AL of directing credits attributed to a person (MediaMaker).
	 * @return the AL of Media objects associated with directing credits
	 */
	public ArrayList<Media> getDirectingCredits(){
		return this.directingCredits;
	} // end getDirectingCredits

	/**
	 * A method that returns the name of the person (MediaMaker).
	 * @return a String that is the name of the person
	 */
	public String getName(){
		return fullName;
	} // end getName
	
	/**
     * A method that returns the first name of the person
     * @return a String that is the first name of the person
     */
    public String getFirstName(){
    	String[] parts = fullName.split("[^\\s]+");
    	return parts[0];
    }
    
    /**
     * A method that returns the last name of the person
     * @return A String of the person's last name
     */
    public String getLastName(){
    	String[] parts = fullName.split("[^\\s]+");
    	return parts[1];
    }
    
    public String getDisambigNum(){
    	return disambigNumber;
    }


	/**
	 * Returns a string representing a media maker and all of its data.
	 * 
	 * @return	A string representation of a media maker.
	 */
	@Override
	public String toString() {
		String maker = ""; // String to store the media maker
		
		// Checks if maker's dismabig number (if it has one) is included within the name or not
		if (this.disambigNumber.equals("")) {
			maker = fullName;
		}
		else {
			maker = fullName + "(" + disambigNumber + ")";
		}
		
		return maker;
	} // end toString

	/**
	 * Compares the name of a MediaMaker to another to determine order.
	 * A positive number returned indicates the name comes before the
	 * one it's being compared to. A negative number returned indicates
	 * the name comes after the one it's being compared to. An int of
	 * zero indicates that the names are the same.
	 * 
	 * @param	o	A person that is being compared to.
	 * @return	An int that determines precedence between two people.
	 */
	@Override
	public int compareTo(MediaMaker o) {
		int personNameDiff = this.fullName.compareTo(o.getName());

		if (personNameDiff != 0){
			return personNameDiff;
		}	
		return 0;
	} // end compareTo
} // ENDS MEDIAMAKER CLASS
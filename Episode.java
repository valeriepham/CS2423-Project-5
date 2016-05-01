import java.io.Serializable;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;

/**
 * Project #4
 * CS 2334, Section 010
 * 1 April 2016
 * <P>
 * A class that acts as a abstract data type that stores episode
 * data - such as title, release year, season and episode number.
 * </P>
 * @version 1.0
 */
public class Episode extends Media implements Comparable<Media>, Serializable{
	/** Episode serial version number used during serialization. */
	private static final long serialVersionUID = -34148101014531226L;

	/** Stores the title of an episode as a string. */
	private String title;
	
	/** Stores the title of an episode's series as a string. */
	private String seriesTitle;
	
	/** Stores the release year of an episode as a string. */
	private String releaseYear;
	
	/** Stores the season and episode number of an episode as a string. */
	private String seasonAndEpisodeNum;
	
	/**
	 * A default constructor for an Episode object that sets all fields to 
	 * empty strings.
	 */
	public Episode() {
		title = "";
		seriesTitle = "";
		releaseYear = "";
		seasonAndEpisodeNum = "";
	} // end Episode
	
	/**
	 * Episode constructor to be used when user adds/edits an episode through
	 * GUI interaction.
	 * 
	 * @param	title	A string storing the title of the episode.
	 * @param	seasonNum	A string storing the season number of the episode.
	 * @param	episodeNum	A string storing the episode number of the episode.
	 * @param	year	A string storing the release year of the episode.
	 */
	public Episode(String title, String seasonNum, String episodeNum, String year) {
		this.title = title;
		releaseYear = year;
		seasonAndEpisodeNum = "(#" + seasonNum + "." + episodeNum + ")";
	} // end Movie Constructor
	
	/**
	 * A constructor to create a Episode object, filling its fields from a parsed String line
	 * read from a file. 
	 * <P>
	 * Algorithm: <br>
	 * 1. Read in String ArrayList given by the Series constructor.<br>
	 * 2. Step through the String ArrayList, finding necessary information <br>
	 * 3. Assign data from the String ArrayList to the corresponding Episode object field <br>
	 * <P>
	 * @param	inputLine The string containing all of the episode information
	 */
	public Episode (String inputLine) {

		//Create string array to hold the split-by-whitespace inputLine
		String[] parsedLine = inputLine.split("\t\t\t|\t\t|\t| ");

		//Trim the whitespace from each of the index components, deals with the tab characters
		for (int i = parsedLine.length -1; i >= 0; i--) {					
			parsedLine[i].trim();
		}

		//Converts String[] to AL<String> to remove the empty strings from trimming
		ArrayList<String> cleanParsedLine = new ArrayList<String>();
		for(int j = 0; j <= parsedLine.length-1; j++){
			if(parsedLine[j].isEmpty() != true) {
				cleanParsedLine.add(parsedLine[j]);
			}
		}


		//Finds the end of the series information using regular expressions
		Pattern serStYr = Pattern.compile("\\([0-9]{4}\\)");
		int seriesTitleLength = 0;
		for (int i = 0; i < cleanParsedLine.size(); i++) 
		{
			String current = cleanParsedLine.get(i);
			Matcher mSSY = serStYr.matcher(current);
			if (mSSY.find() == true)
			{
				seriesTitleLength = i;
			}

		}

			//Set last component to the airYear, Remove last comp
			this.releaseYear = cleanParsedLine.get((cleanParsedLine.size()-1));
			cleanParsedLine.remove(cleanParsedLine.size()-1);

			//Comp currently being checked
			String currentComp = cleanParsedLine.get(cleanParsedLine.size() -1);

			//Regex to find Season & Num
			Pattern seaNumParB = Pattern.compile("(\\#[0-9]+[.][0-9]+\\)\\})");
			//String for Title
			String titleBuilder = "";
			//See if next comp is Season & Num
			Matcher sNPB = seaNumParB.matcher(currentComp);
			boolean foundSeaNum = sNPB.find();

			if(foundSeaNum == true) {
				this.seasonAndEpisodeNum = currentComp;
				seasonAndEpisodeNum = seasonAndEpisodeNum.substring(0, (seasonAndEpisodeNum.length()-1));
			}
			else if (currentComp == "{{SUSPENDED}}") {
				this.seasonAndEpisodeNum = currentComp.toString();
			}
			else {
				this.seasonAndEpisodeNum = "No Season or Episode Number Information Available";
	
				
				//Sets Title here because it wouldn't work later
				for (int start = seriesTitleLength+1; start <= cleanParsedLine.size()-1; start++)
				{	
					titleBuilder = titleBuilder.concat(cleanParsedLine.get(start)).concat(" ");
				}
				title = titleBuilder;		
			}

			//Checks if there is an episode title by checking first index of {, Sets title field when ready
			if (cleanParsedLine.get(seriesTitleLength +1) == seasonAndEpisodeNum)
			{
				this.title = "No Episode Title Available";
			}
		
			else if(this.title == null){
				
				for (int start = seriesTitleLength+1; start <= cleanParsedLine.size()-2; start++)
				{	
					titleBuilder = titleBuilder.concat(cleanParsedLine.get(start)).concat(" ");
				}
			}
			this.title = titleBuilder;
			title = title.replaceAll("\\{|\\}", "");

			//Sets the seriesTitle field
			String builder = "";
			for (int p = 0; p < seriesTitleLength; p++)
			{
				builder = builder.concat(cleanParsedLine.get(p)).concat(" ");
			}

			this.seriesTitle = builder;	
	} //end Episode constructor
	
	
	/**
	 * An accessor for the variable title of an episode.
	 * 
	 * @return	A String storing the title of an episode.
	 */
	@Override
	public String getTitle() {
		return title;
	} // end getTitle

	/**
	 * A mutator for the episode title
	 * @param s	the title to input
	 */
	public void setTitle(String s) {
		this.title = s;	
	}
	
	/**
	 * An accessor for the variable seriesTitle of an episode.
	 * 
	 * @return	A String storing the series title for an episode.
	 */
	public String getSeriesTitle() {
		return seriesTitle;
	} // end getSeriesTitle
	
	/**
	 * A mutator for the variable seriesTitle of an episode.
	 * 
	 * @param	title2	A string storing the series title for an episode.
	 */
	public void setSeriesTitle(String title2) {
		this.seriesTitle = title2;
	} // end setSeriesTitle

	/**
	 * An accessor for the variable releaseYear.
	 * 
	 * @return	A string storing the release year of an episode.
	 */
	@Override
	public String getReleaseYear() {
		return releaseYear;
	} // end getReleaseYear
	
	/**
	 * A mutator for the year of the episode
	 * 
	 * @param	s	The year to input.
	 */
	public void setYear(String s) {
		this.releaseYear = s;
	} // end setYear

	/**
	 * An accessor that returns the season and episode numbers of an episode.
	 * 
	 * @return	A string storing the season and episode number for an episode.
	 */
	public String getSeasonAndEpisodeNum() {
		return seasonAndEpisodeNum;
	} // end getSeasonAndEpisodeNum
	
	/**
	 * An accessor that returns just the season number of the episode
	 * 
	 * @return A string representation of the season number only
	 */
	public String getSeasonNumberOnly() {
		String SeasAndNum = this.seasonAndEpisodeNum;
		String SeasNum = SeasAndNum.substring(2 ,SeasAndNum.indexOf('.'));
		return SeasNum;
	}
	
	/**
	 * An accessor that returns just the episode number of the episode
	 * 
	 * @return A string representation of the episode number only
	 */
	public String getEpisodeNumberOnly() {
		String SeasAndNum = this.seasonAndEpisodeNum;
		String EpNum = SeasAndNum.substring(SeasAndNum.indexOf(".")+1, SeasAndNum.length()-1);
		return EpNum;
	}
	
	/**
	 * A mutator for the episode number 
	 * 
	 * @param	s	The episode number to input.
	 */
	public void setNumber(String s) {
		this.seasonAndEpisodeNum = s;
	} // end setNumber
	
	/**
	 * Returns a string representing an episode and all of its data.
	 * 
	 * @param title	An episode title
	 * @return	A string representation of a Episode object.
	 */
	public String toString(String title){
		String episode = ""; // episode as a string representation

		// If episode has a title, episode and season number are omitted
		if (!title.equals("No Episode Title Available")) {		
			episode = "EPISODE: " + seriesTitle + ": " + title + " (" + releaseYear + ")";
		}

		// If episode has no title, episode and season numbers are printed
		else {
			episode = "EPISODE: " + seriesTitle + ": " + seasonAndEpisodeNum + " (" + releaseYear + ")";
		}
		return episode;
	} // end toString

	/**
	 * Compares an Episode to another to determine order.
	 * A positive number returned indicates the episode comes before the
	 * one it's being compared to. A negative number returned indicates
	 * the episode comes after the one it's being compared to. An int of
	 * zero indicates that the episodes are the same.
	 * 
	 * @param	otherEpisode	An episode that is being compared to.
	 * @return	An int that determines precedence between two episodes.
	 */
	@Override
	public int compareTo(Media otherEpisode) {
		
		//Compare based on title
		if(otherEpisode.getClass().getName().toString() == "Series" | otherEpisode.getClass().getName().toString() == "Movie"){
			// Comparing episodes' series titles
			int seriesTitleDiff = this.seriesTitle.compareTo(otherEpisode.getTitle());
			if (seriesTitleDiff != 0) {
				return seriesTitleDiff;
			}
		}
		
		if(otherEpisode.getClass().getName().toString() == "Episode"){
			Episode other = (Episode) otherEpisode;
			// Comparing episodes' series titles
					int seriesTitleDiff = this.seriesTitle.compareTo(other.getSeriesTitle());
					if (seriesTitleDiff != 0) {
						return seriesTitleDiff;
					}
		}
		
		// Comparing episode titles
		int titleDiff = this.title.compareTo(otherEpisode.getTitle());

		if (titleDiff != 0) {
			return titleDiff;
		}
		
		// Comparing release years
		int episodeYearDiff = this.releaseYear.compareTo(otherEpisode.getReleaseYear());
		
		if (episodeYearDiff != 0) {
			return episodeYearDiff;
		}
		
		// Comparing season and episode numbers
		if(otherEpisode.getClass().getName().toString() == "Episode"){
			Episode other = (Episode) otherEpisode;
			int seasonAndEpDiff = this.seasonAndEpisodeNum.compareTo(other.getSeasonAndEpisodeNum());
			
			if (seasonAndEpDiff != 0) {
				return seasonAndEpDiff;
			}
		}
		return 0; // Returns zero if all fields are the same because the episodes are the same
	} // end compareTo	
} // END EPISODE CLASS
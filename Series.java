import java.util.ArrayList;
import java.io.IOException;
import java.io.Serializable;

/**
 * Project #4
 * CS 2334, Section 010
 * 1 April 2016
 * <P>
 * A class that acts as a abstract data type that stores data for a series -
 * such as title, starting year, and episodes.
 * </P>
 * 
 * @version 1.0
 */
public class Series extends Media implements Comparable<Media>, Serializable {
	/** Series serial version number used during serialization. */
	private static final long serialVersionUID = 5235468890018485654L;

	/** Stores the name of a series in a string. */
	private String title;

	/** Stores the starting year of a series in a string. */
	private String releaseYear;

	/** Stores the running years of a series in a string. */
	private String runningYears;

	/** Stores episodes into an Episode ArrayList. */
	private ArrayList<Episode> episodes;

	/**
	 * A default constructor for a series that sets all string fields to empty
	 * strings. Also sets episodes field to an empty Episode ArrayList.
	 */
	public Series() {
		title = "";
		releaseYear = "";
		runningYears = "";
		episodes = new ArrayList<Episode>();
	} // end Series
	
	/**
	 * Series constructor to be used when user adds/edits a series through
	 * GUI interaction.
	 * 
	 * @param	title	A string storing the title of the series.
	 * @param	year	A string storing the release year of the series.
	 * @param	runningYears	A string storing the years the series ran.
	 */
	public Series(String title, String year, String runningYears) {
		this.title = title;
		releaseYear = year;
		this.runningYears = runningYears;
		episodes = new ArrayList<Episode>();
	} // end Series Constructor

	/**
	 * A constructor to create a Series object, filling all fields except episodeList from a parsed String line
	 * read from a file. 
	 * <P>
	 * Algorithm: <br>
	 * 1. Read in line from Series information file. Parse into string array <br>
	 * 2. Step through the string array of the inputLine and find pertinent information <br>
	 * 3. Assign  data from the file line to the corresponding Series object field <br>
	 * <P>
	 * @param	inputLine	The String generated from a file line containing Series information.
	 */
	public Series (String inputLine){
		
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
			
			//Check to see if the input line is a Series line, Sets fields if so
			String lastComp = cleanParsedLine.get(cleanParsedLine.size() - 1);
			if (lastComp.length() > 4) 
			{
				this.runningYears = lastComp.toString();
				runningYears = runningYears.replaceAll("\\?\\?\\?\\?", "UNSPECIFIED");
				this.releaseYear = cleanParsedLine.get(cleanParsedLine.size() - 2).toString();
				
				//Concatenates the rest of the cleanParsedLine to the Series title
				int end = (cleanParsedLine.size() - 3);
				String titleBuilder = "";
				int start;
				for (start = 0; start <= end; start ++) {
					titleBuilder = titleBuilder.concat(cleanParsedLine.get(start)).concat(" ");
				}
				
				this.title = titleBuilder;
			}	

		} //End Series constructor	
	

	/**
	 * An accessor for the variable title.
	 * 
	 * @return A String of the title of a series.
	 */
	@Override
	public String getTitle() {
		return title;
	} // end getTitle

	/**
	 * An accessor for the variable releaseYear.
	 * 
	 * @return A String storing the starting year of a series.
	 */
	@Override
	public String getReleaseYear() {
		return releaseYear;
	} // end getReleaseYear

	/**
	 * An accessor for the variable runningYears.
	 * 
	 * @return A String storing the starting year of a series.
	 */
	public String getRunningYears() {
		return runningYears;
	} // get RunningYears

	/**
	 * An accessor that returns an episode from a series
	 * 
	 * @param index
	 *            an index from the episodes ArrayList
	 * @return An episode within a series.
	 */
	public Episode getEpisode(int index) {
		return episodes.get(index);
	} // end getEpisode

	/**
	 * An accessor that returns a list of episodes within a series.
	 * 
	 * @return An ArrayList of episodes within a series.
	 */
	public ArrayList<Episode> getEpisodes() {
		return episodes;
	} // end getEpisodes

	/**
	 * Returns a string representation of a series and all of its data.
	 * 
	 * @return A string representation of a Series object.
	 */
	public String toString() {
		String series = "SERIES: " + title + " (" + runningYears + ")";
		return series;
	} // end toString

	/**
	 * Compares a series to another to determine order. A positive number
	 * returned indicates the series comes before the one it's being compared
	 * to. A negative number returned indicates the series comes after the one
	 * it's being compared to. An int of zero indicates that the series are the
	 * same.
	 * 
	 * @param otherSeries	A series that is being compared to.
	 * @return An int that determines precedence between two series.
	 */
	@Override
	public int compareTo(Media otherSeries) {
		// Comparing titles
		int seriesTitleDiff = this.title.compareTo(otherSeries.getTitle());
		if (seriesTitleDiff != 0) {
			return seriesTitleDiff;
		}
		
		// Comparing release years
		int seriesYearDiff = this.releaseYear.compareTo(otherSeries.getReleaseYear());

		if (seriesYearDiff != 0) {
			return seriesYearDiff;
		}
		
		Series other = (Series) otherSeries; // Type cast from Media to Series to compare other fields
		
		// Comparing running years
		int runningYearsDiff = this.runningYears.compareTo(other.getRunningYears());
		if (runningYearsDiff != 0) {
			return runningYearsDiff;
		}

		return 0; // returns zero if all fields are the same because the series are the same
	} // end compareTo
} // ENDS SERIES CLASS
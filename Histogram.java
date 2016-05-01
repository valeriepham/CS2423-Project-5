import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * Project #4 CS 2334, Section 010 April 21, 2016
 * <P>
 * A class that stores data for a media maker's credits and constructs a
 * representative histogram of their credits over years to display to user.
 * </P>
 * 
 * @version 1.0
 */
public class Histogram extends Application {
	/** The media maker whose credits are displayed over time on the histogram. */
	private MediaMaker mediaMaker;

	/** The number of a media maker's acting movie credits. */
	private int actingMovieCred;

	/** The number of a media maker's acting series credits. */
	private int actingSeriesCred;

	/** The number of a media maker's producing movie credits. */
	private int producingMovieCred;

	/** The number of a media maker's producing series credits. */
	private int producingSeriesCred;

	/** The number of a media maker's directing movie credits. */
	private int directingMovieCred;

	/** The number of a media maker's directing series credits. */
	private int directingSeriesCred;

	/** A list storing the years in which the media maker had credits in. */
	private ArrayList<String> years;
	
	public Histogram() {
		//intentionally empty
	}
	
	/**
	 * A mutator for the variable mediaMaker.
	 * 
	 * @param	maker	Maker whose credits are to be displayed.
	 */
	public void setMaker(MediaMaker maker) {
		mediaMaker = maker;
	} // end setMaker

	/**
	 * An accessor for the variable actingMovieCred.
	 * <P>
	 * Algorithm:<br>
	 * 1. Finds number of acting movie credits within a list of credits from the same year.<br>
	 * 2. Step through Media ArrayList and match all objects that of the Movie Class.<br>
	 * 3. Check that credit is also within acting credits. If so, add it to count.<br>
	 * </P> 
	 * @param	list	A Media list containing all credits from a single year.
	 * @param	mediaMaker	The media maker whose credits are being graphically displayed.
	 * @return	The number of media maker's acting movie credits within a single year.
	 */
	public int getActingMovieCred(ArrayList<Media> list, MediaMaker mediaMaker) {
		actingMovieCred = 0; // Sets initial amount of credits before looping

		// Loops through credits from a single year and adds up only the credits for movie acting
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i).getClass().getName().equals("Movie") && 
					(mediaMaker.getActingCredits().contains(list.get(i)))) {
				++actingMovieCred;
			}
		}
		return actingMovieCred;
	} // end getActingMovieCred

	/**
	 * An accessor for the variable actingSeriesCred.
	 * <P>
	 * Algorithm:<br>
	 * 1. Finds number of acting series credits within a list of credits from the same year.<br>
	 * 2. Step through Media ArrayList and match all objects that of the Series Class.<br>
	 * 3. Check that credit is also within directing credits. If so, add it to count.<br>
	 * </P>
	 * @param	list	A Media list containing all credits from a single year.
	 * @param mediaMaker	The media maker whose credits are being graphically displayed.
	 * @return	The number of media maker's acting series credits.
	 */
	public int getActingSeriesCred(ArrayList<Media> list, MediaMaker mediaMaker) {
		actingSeriesCred = 0; // Sets initial amount of credits before looping

		// Loops through credits from a single year and adds up only the credits for series acting
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i).getClass().getName().equals("Series") && 
					(mediaMaker.getActingCredits().contains(list.get(i)))) {
				++actingSeriesCred;
			}
		}
		return actingSeriesCred;
	} // end getActingSeriesCred

	/**
	 * An accessor for the variable producingMovieCred.
	 * <P>
	 * Algorithm:<br>
	 * 1. Finds number of producing movie credits within a list of credits from the same year.<br>
	 * 2. Step through Media ArrayList and match all objects that of the Movie Class.<br>
	 * 3. Check that credit is also within producing credits. If so, add it to count.<br>
	 * </P> 
	 * @param	list	A Media list containing all credits from a single year.
	 * @param mediaMaker	The media maker whose credits are being graphically displayed.
	 * @return	The number of media maker's producing movie credits.
	 */
	public int getProducingMovieCred(ArrayList<Media> list, MediaMaker mediaMaker) {
		producingMovieCred = 0; // Sets initial amount of credits before looping

		// Loops through credits from a single year and adds up only the credits for movie producing
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i).getClass().getName().equals("Movie") && 
					(mediaMaker.getProducingCredits().contains(list.get(i)))) {
				++producingMovieCred;
			}
		}
		return producingMovieCred;
	} // end getProducingMovieCred

	/**
	 * An accessor for the variable producingSeriesCred.
	 * <P>
	 * Algorithm:<br>
	 * 1. Finds number of producing series credits within a list of credits from the same year.<br>
	 * 2. Step through Media ArrayList and match all objects that of the Series Class.<br>
	 * 3. Check that credit is also within producing credits. If so, add it to count.<br>
	 * </P> 
	 * @param	list	A Media list containing all credits from a single year.
	 * @param mediaMaker	The media maker whose credits are being graphically displayed.
	 * @return	The number of media maker's producing series credits.
	 */
	public int getProducingSeriesCred(ArrayList<Media> list, MediaMaker mediaMaker) {
		producingSeriesCred = 0; // Sets initial amount of credits before looping

		// Loops through credits from a single year and adds up only the credits for series producing
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i).getClass().getName().equals("Series")&& 
					(mediaMaker.getProducingCredits().contains(list.get(i)))) {
				++producingSeriesCred;
			}
		}
		return producingSeriesCred;
	} // end getProducingSeriesCred

	/**
	 * An accessor for the variable directingMovieCred.
	 * <P>
	 * Algorithm:<br>
	 * 1. Finds number of directing movie credits within a list of credits from the same year.<br>
	 * 2. Step through Media ArrayList and match all objects that of the Movie Class.<br>
	 * 3. Check that credit is also within directing credits. If so, add it to count.<br>
	 * </P>
	 * @param	list	A Media list containing all credits from a single year.
	 * @param mediaMaker	The media maker whose credits are being graphically displayed.
	 * @return	The number of media maker's directing movie credits.
	 */
	public int getDirectingMovieCred(ArrayList<Media> list, MediaMaker mediaMaker) {
		directingMovieCred = 0; // Sets initial amount of credits before looping

		// Loops through credits from a single year and adds up only the credits for movie directing
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i).getClass().getName().equals("Movie") && 
					(mediaMaker.getDirectingCredits().contains(list.get(i)))) {
				++directingMovieCred;
			}
		}
		return directingMovieCred;
	} // getDirectingMovieCred

	/**
	 * An accessor for the variable directingSeriesCred.
	 * <P>
	 * Algorithm:<br>
	 * 1. Finds number of directing series credits within a list of credits from the same year.<br>
	 * 2. Step through Media ArrayList and match all objects that of the Series Class.<br>
	 * 3. Check that credit is also within directing credits. If so, add it to count.<br>
	 * </P> 
	 * @param	list	A Media list containing all credits from a single year.
	 * @param mediaMaker	The media maker whose credits are being graphically displayed.
	 * @return	The number of media maker's directing series credits.
	 */
	public int getDirectingSeriesCred(ArrayList<Media> list, MediaMaker mediaMaker) {
		directingSeriesCred = 0; // Sets initial amount of credits before looping

		// Loops through credits from a single year and adds up only the credits for series directing
		for (int i = 0; i < list.size(); ++i) {
			if (list.get(i).getClass().getName().equals("Series") && 
					(mediaMaker.getDirectingCredits().contains(list.get(i)))) {
				++directingSeriesCred;
			}
		}
		return directingSeriesCred;
	} // getDirectingSeriesCred

	/**
	 * Creates a Linked Hash Map where the years media maker had credits in are keys
	 * and Media ArrayLists containing all credits from a certain year are values to
	 * use when painting the Histogram.
	 * 
	 * @param mediaMaker	The media maker whose credits are being displayed.
	 * @return	A LinkedHashMap Linked Hash Map where the years media maker had credits in are keys
	 *                          and Media ArrayLists containing all credits from a certain year are values
	 */
	public LinkedHashMap<Integer, ArrayList<Media>> getCredYearsMap(MediaMaker mediaMaker) {
		LinkedHashMap<Integer, ArrayList<Media>> credits = new LinkedHashMap<Integer, ArrayList<Media>>();

		// Get first and last year to create the range of years for the histogram
		if (getYears(mediaMaker).length != 0 && getYears(mediaMaker) != null) {

			for (int i = Integer.parseInt(getYears(mediaMaker)[0]); i <= Integer.parseInt(getYears(mediaMaker)[getYears(mediaMaker).length - 1]); ++i) {
				// Constructs a Media AL for all credits within a single year
				ArrayList<Media> sameYearCredits = new ArrayList<Media>();

				// Finds all acting credits from the same year and adds to a Media ArrayList
				for (int j = 0; j < mediaMaker.getActingCredits().size(); ++j) {
					StringBuilder year = new StringBuilder(mediaMaker.getActingCredits().get(j).getReleaseYear());

					year.deleteCharAt(0); // Trims off beginning parentheses
					year.deleteCharAt(year.length() - 1); // Trims off ending parentheses

					if (Integer.toString(i).equalsIgnoreCase(year.toString()) == true) {
						sameYearCredits.add(mediaMaker.getActingCredits().get(j));
					}
				}

				// Finds all producing credits from the same year and adds to a Media ArrayList
				for (int k = 0; k < mediaMaker.getProducingCredits().size(); ++k) {
					StringBuilder year = new StringBuilder(mediaMaker.getProducingCredits().get(k).getReleaseYear());

					year.deleteCharAt(0); // Trims off beginning parentheses
					year.deleteCharAt(year.length() - 1); // Trims off ending parentheses

					if (Integer.toString(i).equalsIgnoreCase(year.toString()) == true) {
						sameYearCredits.add(mediaMaker.getProducingCredits().get(k));
					}
				}

				// Finds all directing credits from the same year and adds to a Media ArrayList
				for (int l = 0; l < mediaMaker.getDirectingCredits().size(); ++l) {
					StringBuilder year = new StringBuilder(mediaMaker.getDirectingCredits().get(l).getReleaseYear());
					year.deleteCharAt(0); // Trims off beginning parentheses
					year.deleteCharAt(year.length() - 1); // Trims off ending parentheses

					if (Integer.toString(i).equalsIgnoreCase(year.toString()) == true) {
						sameYearCredits.add(mediaMaker.getActingCredits().get(l));
					}
				}	
				credits.put(i, sameYearCredits);
			}		
		}
		return credits;
	} // end getCredYearsMap

	/**
	 * An accessor for the variable years.
	 * 
	 * @param	mediaMaker	The media maker whose credits are being graphically displayed.
	 * @return	A String array storing years from all of media maker's credits.
	 */
	public String[] getYears(MediaMaker mediaMaker) {
		years = new ArrayList<String>(); // Initially empty to store credit years

		// Adds years from media maker's acting credits to years String AL
		for (int i = 0; i < mediaMaker.getActingCredits().size(); ++i) {
			String year = mediaMaker.getActingCredits().get(i).getReleaseYear();
			if (years.contains(year) == false && !year.equals("(????)")) {
				years.add(year);
			}
		}

		// Adds years from media maker's producing credits to years String AL
		for (int i = 0; i < mediaMaker.getProducingCredits().size(); ++i) {
			String year = mediaMaker.getProducingCredits().get(i).getReleaseYear();
			if (years.contains(year) == false && !year.equals("(????)")) {
				years.add(year);
			}
		}

		// Adds years from media maker's directing credits to years String AL years
		for (int i = 0; i < mediaMaker.getDirectingCredits().size(); ++i) {
			String year = mediaMaker.getDirectingCredits().get(i).getReleaseYear();
			if (years.contains(year) == false && !year.equals("(????)")) {
				years.add(year);
			}
		}

		Collections.sort(years); // Sorts years numerically
		String start = years.get(0); // First year is the start year of the graph
		String end = years.get(years.size()-1); // End year is the last year of the graph

		// Trim off parentheses of the at the beginning and end of the start year
		StringBuilder temp = new StringBuilder(start);
		temp.deleteCharAt(0);
		temp.deleteCharAt(temp.length() - 1);

		// Convert the string into a year
		int startNum = Integer.parseInt(temp.toString());

		// Trim off parentheses of the at the beginning and end of the end year
		temp = new StringBuilder(end);
		temp.deleteCharAt(0);
		temp.deleteCharAt(temp.length() - 1);

		// Convert the string into a year
		int endNum = Integer.parseInt(temp.toString());
		int index = 0;

		// Creates int array containing strings of range of media maker's credit years
		String[] list = new String[endNum-startNum + 1];
		for (int i = startNum; i <= endNum; ++i) {
			list[index] = Integer.toString(i);
			++index;
		}

		return list;
	} // end getYears

	/** X (years) and Y (number of credits) axes and the stacked bar chart.*/
	final CategoryAxis xAxis = new CategoryAxis();
	final NumberAxis yAxis = new NumberAxis();
	final StackedBarChart<String, Number> sbc = new StackedBarChart<String, Number>(xAxis, yAxis);

	/** The six different types of credits as represented as bars. */
	final XYChart.Series<String, Number> movieActing = new XYChart.Series<String, Number>();
	final XYChart.Series<String, Number> seriesActing = new XYChart.Series<String, Number>();
	final XYChart.Series<String, Number> movieDirecting = new XYChart.Series<String, Number>();
	final XYChart.Series<String, Number> seriesDirecting = new XYChart.Series<String, Number>();
	final XYChart.Series<String, Number> movieProducing = new XYChart.Series<String, Number>();
	final XYChart.Series<String, Number> seriesProducing = new XYChart.Series<String, Number>();

	@Override
	public void start(Stage stage) throws IOException {
		
		/*
		 * TODO: Because data was not being passed to the Histogram from the database/controller
		 * along with instantiating the graphs within the MVC, the graphing results in errors.
		 * Running this class by itself shows that our graphs work at least with hard coded values
		 * from the text file (aside from Angelina Abdullaeva's 2015 acting credit that seems to be
		 * inserted in all media makers -- appears to be a global variable problem we could not discern.
		 */		
		FileReader fr = new FileReader("SomeActors.txt");
		BufferedReader br = new BufferedReader(fr);
		MediaMaker mediaMaker = new MediaMaker("Lee, Bruce (I)		Ai (1955)", 3, br);

		String[] years = getYears(mediaMaker); // String array for years X axis
		int yearIndex = 0; // Index position to iterate through years for constructing bars
		
		// Map with years as keys and credit array lists for each year as values
		LinkedHashMap<Integer, ArrayList<Media>> credMap = getCredYearsMap(mediaMaker);

		stage.setTitle("Media Maker Credits Histogram"); // Sets title of window
		sbc.setTitle("Media Maker Credits Histogram"); // Sets title of graph
		
		// Creates X and Y axes with years and labels
		xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(years)));
		yAxis.setLabel("Credits");

		for (int i = Integer.parseInt(years[yearIndex]); i <= Integer.parseInt(years[years.length -1]); ++i) {
			// Acting Movie credits bar
			movieActing.setName("Acting Movie");
			movieActing.getData().add(new XYChart.Data<String, Number>(years[yearIndex], getActingMovieCred(credMap.get(i), mediaMaker)));

			// Acting Series credits bar
			seriesActing.setName("Acting Series");
			seriesActing.getData().add(new XYChart.Data<String, Number>(years[yearIndex], getActingSeriesCred(credMap.get(i), mediaMaker)));

			// Directing Movie credits bar
			movieDirecting.setName("Directing Movie");
			movieDirecting.getData().add(new XYChart.Data<String, Number>(years[yearIndex], getDirectingMovieCred(credMap.get(i), mediaMaker)));

			// Directing Series credits bar
			seriesDirecting.setName("Directing Series");
			seriesDirecting.getData().add(new XYChart.Data<String, Number>(years[yearIndex], getDirectingSeriesCred(credMap.get(i), mediaMaker)));			

			// Producing Movie credits bar
			movieProducing.setName("Producing Movie");
			movieProducing.getData().add(new XYChart.Data<String, Number>(years[yearIndex], getProducingMovieCred(credMap.get(i), mediaMaker)));

			// Producing Series credits bar
			seriesProducing.setName("Producing Series");
			seriesProducing.getData().add(new XYChart.Data<String, Number>(years[yearIndex], getProducingSeriesCred(credMap.get(i), mediaMaker)));

			++yearIndex; // Increments the index position of the year array
		}
		
		Scene scene = new Scene(sbc, 800, 700); // Sets size of window
		
		// Adds categories within legend and chart
		sbc.getData().addAll(movieActing, seriesActing, movieDirecting, seriesDirecting, movieProducing, seriesProducing);

		stage.setScene(scene);
		stage.show(); // Displays histogram
	} // end start

	// Temporary main method for displaying sample histograms
	public static void main(String[] args) throws IOException {
		launch(args);
	}
} // end Histogram Class
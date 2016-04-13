import java.awt.Color;
import java.util.LinkedHashMap;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JComponent;

/**
 * Project #3
 * CS 2334, Section 010
 * Mar 28, 2016
 * <P>
 * A class that stores data for a media maker's credits and constructs a
 * representative histogram of their credits over years to display to user.
 * </P>
 * 
 * @version 1.0
 */
public class Histogram extends JComponent {
	/** The media maker whose credits are displayed over time on the histogram.*/
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
	private ArrayList<String> creditYears;
	
	/**
	 * Histogram constructor that set the variable mediaMaker and will
	 * automatically call paintComponent to display the histogram.
	 * 
	 * @param	mediaMaker	Media maker whose credits will be graphically displayed.
	 */
	public Histogram (MediaMaker mediaMaker) {
		// TODO
		// this.mediaMaker = mediaMaker;
	} // end Histogram costructor

	/**
	 * An accessor for the variable actingMovieCred.
	 * <P>
	 * Algorithm:<br>
	 * 1. Finds number of acting movie credits within a list of credits from the same year.<br>
	 * 2. Do NOT include a step by step description of the algorithm here.<br>
	 * 3. Be sure to put an html <br> tag after each line.<br>
	 * </P>
	 * @param	list	A Media list containing all credits from a single year.
	 * @param	mediaMaker	The media maker whose credits are being graphically displayed.
	 * @return	The number of media maker's acting movie credits within a single year.
	 */
	public int getActingMovieCred(ArrayList<Media> list, MediaMaker mediaMaker) {
		// TODO
		return 0;
	} // end getActingMovieCred

	/**
	 * An accessor for the variable actingSeriesCred.
	 * Algorithm:<br>
	 * 1. Finds number of acting series credits within a list of credits from the same year.<br>
	 * 2. Do NOT include a step by step description of the algorithm here.<br>
	 * 3. Be sure to put an html <br> tag after each line.<br>
	 * </P>
	 * @param mediaMaker	The media maker whose credits are being graphically displayed.
	 * @return	The number of media maker's acting series credits.
	 */
	public int getActingSeriesCred(ArrayList<Media> list, MediaMaker mediaMaker) {
		// TODO
		return 0;
	} // end getActingSeriesCred

	/**
	 * An accessor for the variable producingMovieCred.
	 * Algorithm:<br>
	 * 1. Finds number of producing movie credits within a list of credits from the same year.<br>
	 * 2. Do NOT include a step by step description of the algorithm here.<br>
	 * 3. Be sure to put an html <br> tag after each line.<br>
	 * </P> 
	 * @param mediaMaker	The media maker whose credits are being graphically displayed.
	 * @return	The number of media maker's producing movie credits.
	 */
	public int getProducingMovieCred(ArrayList<Media> list, MediaMaker mediaMaker) {
		// TODO
		return 0;
	} // end getProducingMovieCred

	/**
	 * An accessor for the variable producingSeriesCred.
	 * Algorithm:<br>
	 * 1. Finds number of producing series credits within a list of credits from the same year.<br>
	 * 2. Do NOT include a step by step description of the algorithm here.<br>
	 * 3. Be sure to put an html <br> tag after each line.<br>
	 * </P> 
	 * @param mediaMaker	The media maker whose credits are being graphically displayed.
	 * @return	The number of media maker's producing series credits.
	 */
	public int getProducingSeriesCred(ArrayList<Media> list, MediaMaker mediaMaker) {
		// TODO
		return 0;
	} // end producingSeriesCred

	/**
	 * An accessor for the variable directingMovieCred.
	 * Algorithm:<br>
	 * 1. Finds number of directing movie credits within a list of credits from the same year.<br>
	 * 2. Do NOT include a step by step description of the algorithm here.<br>
	 * 3. Be sure to put an html <br> tag after each line.<br>
	 * </P> 
	 * @param mediaMaker	The media maker whose credits are being graphically displayed.
	 * @return	The number of media maker's directing movie credits.
	 */
	public int getDirectingMovieCred(ArrayList<Media> list, MediaMaker mediaMaker) {
		// TODO
		return 0;
	} // end getDirectingMovieCred

	/**
	 * An accessor for the variable directingSeriesCred.
	 * Algorithm:<br>
	 * 1. Finds number of directing series credits within a list of credits from the same year.<br>
	 * 2. Do NOT include a step by step description of the algorithm here.<br>
	 * 3. Be sure to put an html <br> tag after each line.<br>
	 * </P> 
	 * @param mediaMaker	The media maker whose credits are being graphically displayed.
	 * @return	The number of media maker's directing series credits.
	 */
	public int getDirectingSeriesCred(ArrayList<Media> list, MediaMaker mediaMaker) {
		// TODO
		return 0;
	} // end getDirectingSeriesCred
	
	/**
	 * An accessor for the variable creditYears.
	 * 
	 * @param mediaMaker	The media maker whose credits are being graphically displayed.
	 * @return	A String ArrayList storing years from all of media maker's credits.
	 */
	public ArrayList<String> getCreditYears(MediaMaker mediaMaker) {
		// TODO
		return null;
	} // end getCreditYears
	
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
		// TODO
		return null;
	} // end getCredYearsMap

	/**
	 * Paints a histogram of a media maker's credits over the years where
	 * every bar is subdivided among the 6 different types of credits.
	 * 
	 * @param	g	Graphics object used to draw shapes within the graph.
	 */
	public void paintComponent(Graphics g) {
		// TODO
	} // end paintComponent
} // end Histogram Class
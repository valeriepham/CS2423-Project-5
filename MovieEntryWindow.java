import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Project 4
 * CS 2334, Section 10
 * April 1 2016
 * <p>
 * The movie data entry view of the MVC program in which allows
 * user to add a movie to the database by providing input text fields
 * for information on the movie to be added. Note: Will not accept any
 * duplicate movie already within the database or any errors in input,
 * and thus, notify user when it occurs.
 * </p>
 * @version 1.0
 */
public class MovieEntryWindow {
	/**
	 * Button to click to add new movie to the database based on filled text
	 * fields.
	 */
	JButton jbtAddMovie = new JButton("Add Movie");

	/** TextField to input new movie title. */
	JTextField jtfTitle = new JTextField(20);
	JLabel lblTitle = new JLabel("Movie Title", JLabel.RIGHT);

	/**
	 * TextField to input movie's release year (with, if any, a disambiguation
	 * number).
	 */
	JTextField jtfYearAndDisambigNum = new JTextField(20);
	JLabel lblYearAndDisambigNum = new JLabel("Year and Disambiguation Number", JLabel.RIGHT);

	/** TextField to input movie's venue. */
	JTextField jtfVenue = new JTextField(20);
	JLabel lblVenue = new JLabel("Venue", JLabel.RIGHT);

	/** TextField to input movie's release year. */
	JTextField jtfYear = new JTextField(20);
	JLabel lblYear = new JLabel("Year", JLabel.RIGHT);
	
	/**
	 * Constructor for the movie entry view in which adds all of the objects
	 * and variables as GUI components to be displayed to user and allow them
	 * to add movies to the database
	 */
	public MovieEntryWindow() {
		// TODO
	} // end MovieEntryView
	
	/**
	 * 
	 * @param addMovieListener
	 */
	public void addAddMovieButtonListener(ActionListener addMovieListener) {
		// TODO
	} // end addAddMovieButtonListener
} // end MovieEntryView
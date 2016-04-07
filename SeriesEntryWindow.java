import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Project 4
 * CS 2334, Section 10
 * April 1 2016
 * <p>
 * The series data entry view of the MVC program in which allows
 * user to add a series to the database by providing input text fields
 * for information on the series to be added. Note: Will not accept any
 * series already within the database and thus, notify user of this.
 * Note: Will not accept any duplicate series already within the database
 * or any errors in input, and thus, notify user when it occurs.
 * </p>
 * @version 1.0
 */
public class SeriesEntryWindow extends JFrame {
	/** Serial version ID to be used during serialization. */
	private static final long serialVersionUID = 377430440137124170L;

	/**
	 * Button to click to add new series to the database based on filled text
	 * fields.
	 */
	JButton jbtAddSeries = new JButton("Add Series");

	/** TextField to input new series title. */
	JTextField jtfTitle = new JTextField(20);
	JLabel lblTitle = new JLabel("Series Title", JLabel.RIGHT);

	/**
	 * TextField to input series's release year (with, if any, a disambiguation
	 * number).
	 */
	JTextField jtfReleaseYear = new JTextField(20);
	JLabel lblReleaseYear = new JLabel("Release Year", JLabel.RIGHT);

	/** TextField to input series's running years. */
	JTextField jtfRunningYears = new JTextField(20);
	JLabel lblRunningYears = new JLabel("Running Years", JLabel.RIGHT);

	/**
	 * Constructor for the series entry view in which adds all of the objects
	 * and variables as GUI components to be displayed to user and allow them
	 * to add series to the database
	 */
	SeriesEntryWindow() {
		// TODO
	} // end SeriesEntryView
	
	/**
	 * 
	 * @param addSeriesListener
	 */
	public void addAddSeriesButtonListener(ActionListener addSeriesListener) {
		// TODO
	} // end addAddSeriesButtonListener
} // end SeriesEntryView Class
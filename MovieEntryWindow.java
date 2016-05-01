import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**
 * Project 4
 * CS 2334, Section 010
 * 21 April 2016
 * <p>
 * Each object of this class represents a GUI movie entry window (MVC view).
 * </p> 
 */
public class MovieEntryWindow extends JFrame {
	
	/** Button to click to create new movie entry */
	JButton jbtCreateEntry = new JButton("Create");
	
	/** Button to click to clear input fields */
	JButton jbtClearInput = new JButton("Clear");
	
	/** Button to click to cancel the entry creation */
	JButton jbtCancel = new JButton("Cancel");
	
	/** Button to update entries when editing */
	JButton jbtUpdate = new JButton("Update");
	
	/** TextField to enter movie title */
	JTextField jtfTitle = new JTextField(20);
	JLabel lblTitle = new JLabel("Title", JLabel.RIGHT);
	
	/** TextField to enter release year */
	JTextField jtfYear = new JTextField(20);
	JLabel lblYear = new JLabel("Year", JLabel.RIGHT);
	
	/** TextField to enter disambiguation numeral */
	JTextField jtfNumeral = new JTextField(20);
	JLabel lblNumeral = new JLabel("Numeral", JLabel.RIGHT);
	
	/** TextField to enter the venue */
	JTextField jtfVenue = new JTextField(20);
	JLabel lblVenue = new JLabel("Venue", JLabel.RIGHT);
	
	/**
	 * Method to clear all input fields for the movie entry
	 */
	public void clearInputFields() {
		jtfTitle.setText("");
		jtfYear.setText("");
		jtfNumeral.setText("");
		jtfVenue.setText("");
	} // end clearInputFields
	
	/**
	 * Constructor for a Movie Entry Window
	 */
	MovieEntryWindow () {
		setTitle("Add Movie Entry");
		
		// Create Panels for all of the input fields and buttons
		JPanel jplTitle= new JPanel(new GridLayout(1, 0, 5, 5));
		jplTitle.add(lblTitle);
		jplTitle.add(jtfTitle); // Panel for Title JTF and LBL
		
		JPanel jplYear = new JPanel(new GridLayout(1, 0, 5, 5));
		jplYear.add(lblYear);
		jplYear.add(jtfYear); // Panel for Year JTF and LBL
		
		JPanel jplNumeral = new JPanel(new GridLayout(1, 0, 5, 5));
		jplNumeral.add(lblNumeral);
		jplNumeral.add(jtfNumeral); // Panel for Numeral JTF and LBL
		
		JPanel jplVenue= new JPanel(new GridLayout(1, 0, 5, 5));
		jplVenue.add(lblVenue);
		jplVenue.add(jtfVenue); // Panel for Venue JTF and LBL
		
		JPanel jplButton = new JPanel(new GridLayout(1, 0, 5, 5));
		jplButton.add(jbtCreateEntry);
		jplButton.add(jbtClearInput);
		jplButton.add(jbtCancel); 
		// Panel for buttons

		// Set up the content pane and add all the panels to it.
		setLayout(new GridLayout(0, 1, 5, 5));
		add(jplTitle);
		add(jplYear);
		add(jplNumeral);
		add(jplVenue);
		add(jplButton);
		pack();
	} // end MovieEntryWindow
	
	/**
	 * Constructor for a Movie Edit Window.
	 * 
	 * @param	m	Movie to be edited. Existing data will prepopulate the text fields
	 * 				of the edit view.
	 */
	MovieEntryWindow (Movie m) {
		setTitle("Edit Movie Entry");
		
		//Set the movies JTextFields with data
		jtfTitle.setText(m.getTitle());
		jtfYear.setText(m.getReleaseYear());
		jtfNumeral.setText(m.getYearWithNumeral());
		jtfVenue.setText(m.getVenue());
		
		// Create Panels for all of the input fields and buttons
		JPanel jplTitle= new JPanel(new GridLayout(1, 0, 5, 5));
		jplTitle.add(lblTitle);
		jplTitle.add(jtfTitle); // Panel for Title JTF and LBL
		
		JPanel jplYear = new JPanel(new GridLayout(1, 0, 5, 5));
		jplYear.add(lblYear);
		jplYear.add(jtfYear); // Panel for Year JTF and LBL
		
		JPanel jplNumeral = new JPanel(new GridLayout(1, 0, 5, 5));
		jplNumeral.add(lblNumeral);
		jplNumeral.add(jtfNumeral); // Panel for Numeral JTF and LBL
		
		JPanel jplVenue= new JPanel(new GridLayout(1, 0, 5, 5));
		jplVenue.add(lblVenue);
		jplVenue.add(jtfVenue); // Panel for Venue JTF and LBL
		
		JPanel jplButton = new JPanel(new GridLayout(1, 0, 5, 5));
		jplButton.add(jbtUpdate);
		jplButton.add(jbtClearInput);
		jplButton.add(jbtCancel); 
		// Panel for buttons

		// Set up the content pane and add all the panels to it.
		setLayout(new GridLayout(0, 1, 5, 5));
		add(jplTitle);
		add(jplYear);
		add(jplNumeral);
		add(jplVenue);
		add(jplButton);
		pack();
	} // end MovieEntryWindow
	
	/**
	 * Method to add listener to Create Entry button.
	 * 
	 * @param	createEntryListener	Listener to be registered to a create entry button.
	 */
	public void addCreateEntryButtonListener(ActionListener createEntryListener) {
		jbtCreateEntry.addActionListener(createEntryListener);
	} // end addCreateEntryButtonListener
	
	/**
	 * Method to add listener to Clear Input Fields button.
	 * 
	 * @param	clearInputFieldsListener	Listener to be registered to a clear input
	 *                                      fields button.
	 */
	public void addClearInputFieldsListener(ActionListener clearInputFieldsListener) {
		jbtClearInput.addActionListener(clearInputFieldsListener);
	} // end addClearInputFieldsListener
	
	/**
	 * Method to add listener to Cancel button.
	 * 
	 * @param	cancelListener	Listener to be registered to a cancel button.
	 */
	public void addCancelButtonListener(ActionListener cancelListener) {
		jbtCancel.addActionListener(cancelListener);
	} // end addCancelButtonListener
	
	/**
	 * Method to add listener to Update Entry Button.
	 * 
	 * @param	updateEntryListener	Listener to be registered to an update button.
	 */
	public void addUpdateEntryButtonListener(ActionListener updateEntryListener) {
		jbtUpdate.addActionListener(updateEntryListener);
	} // end addUpdateEntryButtonListener
} // ENDS MOVIE ENTRY WINDOW CLASS
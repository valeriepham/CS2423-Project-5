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
 * Each object of this class represents a GUI series entry window (MVC view).
 * </p> 
 */
public class SeriesEntryWindow extends JFrame {
	/** Button to click to create new series entry */
	JButton jbtCreateEntry = new JButton("Create");
	
	/** Button to click to clear input fields */
	JButton jbtClearInput = new JButton("Clear");
	
	/** Button to click to cancel the entry creation */
	JButton jbtCancel = new JButton("Cancel");
	
	/** Button to update entries when editing */
	JButton jbtUpdate = new JButton("Update");
	
	/** TextField to enter series title */
	JTextField jtfTitle = new JTextField(20);
	JLabel lblTitle = new JLabel("Title", JLabel.RIGHT);
	
	/** TextField to enter release year */
	JTextField jtfYear = new JTextField(20);
	JLabel lblYear = new JLabel("Year", JLabel.RIGHT);
	
	/** TextField to enter running years */
	JTextField jtfRunYears = new JTextField(20);
	JLabel lblRunYears = new JLabel("Run Years", JLabel.RIGHT);

	/**
	 * Method to clear all input fields for the movie entry.
	 */
	public void clearInputFields() {
		jtfTitle.setText("");
		jtfYear.setText("");
		jtfRunYears.setText("");
	} // end clearInputFields
	
	/**
	 * Constructor for a Series Entry Window.
	 */
	public SeriesEntryWindow () {
		setTitle("Add Series Entry");

        // Create Panels for all of the input fields and buttons
        JPanel jplTitle = new JPanel(new GridLayout(1, 0, 5, 5));
        jplTitle.add(lblTitle);
        jplTitle.add(jtfTitle); // Panel for Title JTF and LBL

        JPanel jplYear = new JPanel(new GridLayout(1, 0, 5, 5));
        jplYear.add(lblYear);
        jplYear.add(jtfYear); // Panel for Year JTF and LBL

        JPanel jplRunYears = new JPanel(new GridLayout(1, 0, 5, 5)); 
        jplRunYears.add(lblRunYears);
        jplRunYears.add(jtfRunYears);// Panel for RunYears JTF and LBL

        JPanel jplButton = new JPanel(new GridLayout(1, 0, 5, 5)); 
        jplButton.add(jbtCreateEntry);
        jplButton.add(jbtClearInput);
        jplButton.add(jbtCancel);
        // Panel for buttons

        // Set up the content pane and add all the panels to it.
        setLayout(new GridLayout(0, 1, 5, 5));
        add(jplTitle);
        add(jplYear);
        add(jplRunYears);
        add(jplButton);
        pack();
	} // end SeriesEntryWindow constructor

	/**
	 * Constructor for series edit view.
	 * 
	 * @param	s	Series to be edited. Existing data will prepopulate the text fields
	 * 				of the edit view.
	 */
	SeriesEntryWindow (Series s) {
		setTitle("Edit Series Entry");
		
		// Fill in the JTextFields with the Series' data
		jtfTitle.setText(s.getTitle());
		jtfYear.setText(s.getReleaseYear());
		jtfRunYears.setText(s.getRunningYears());

		// Create Panels for all of the input fields and buttons
		JPanel jplTitle= new JPanel(new GridLayout(1, 0, 5, 5));
		jplTitle.add(lblTitle);
		jplTitle.add(jtfTitle); // Panel for Title JTF and LBL

		JPanel jplYear = new JPanel(new GridLayout(1, 0, 5, 5));
		jplYear.add(lblYear);
		jplYear.add(jtfYear); // Panel for Year JTF and LBL

		JPanel jplRunYears = new JPanel(new GridLayout(1, 0, 5, 5)); 
		jplRunYears.add(lblRunYears);
		jplRunYears.add(jtfRunYears); // Panel for Numeral JTF and LBL


		JPanel jplButton = new JPanel(new GridLayout(1, 0, 5, 5));
		jplButton.add(jbtUpdate);
		jplButton.add(jbtClearInput);
		jplButton.add(jbtCancel); 
		// Panel for buttons

		// Set up the content pane and add all the panels to it.
		setLayout(new GridLayout(0, 1, 5, 5));
		add(jplTitle);
		add(jplYear);
		add(jplRunYears);
		add(jplButton);
		pack();
	} // end SeriesEntryWindow constructor

	/**
	 * Method to add listener to Create Entry button.
	 * 
	 * @param	createEntryListener	Listener to be registered to a create entry button.
	 */
	public void addCreateEntryButtonListener (ActionListener createEntryListener) {
		jbtCreateEntry.addActionListener(createEntryListener);
	} // end addCreateEntryButtonListener 

	/**
	 * Method to add listener to Clear Input Fields button.
	 * 
	 * @param	clearInputFieldsListener	Listener to be registered to a clear input
	 *                                      fields button.
	 */
	public void addClearInputFieldsListener (ActionListener clearInputFieldsListener) {
		jbtClearInput.addActionListener(clearInputFieldsListener);
	} // end addClearInputFieldsListener

	/**
	 * Method to add listener to Cancel button.
	 * 
	 * @param	cancelListener	Listener to be registered to a cancel button.
	 */
	public void addCancelButtonListener (ActionListener cancelListener) {
		jbtCancel.addActionListener(cancelListener);
	} // end addCancelButtonListener

	/**
	 * Method to add listener to Update Entry Button.
	 * 
	 * @param	updateEntryListener	Listener to be registered to an update button.
	 */
	public void addUpdateEntryButtonListener (ActionListener updateEntryListener) {
		jbtUpdate.addActionListener(updateEntryListener);
	} // end addUpdateEntryButtonListener	
} // ENDS SERIES ENTRY WINDOW CLASS
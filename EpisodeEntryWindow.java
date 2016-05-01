import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

/**
 * Project 4
 * CS 2334, Section 010
 * 1 April 2016
 * <p>
 * Each object of this class represents a GUI episode entry window (MVC view).
 * </p> 
 */
public class EpisodeEntryWindow extends JFrame {
	/** Serial number to be used during serialization. */
	private static final long serialVersionUID = 3117945649420343865L;

	/** Reference to the model from the episode entry view window. */
	private DatabaseModel databaseModel;

	/** Button to click to create new series entry */
	JButton jbtCreateEntry = new JButton("Create");
	
	/** Button to click to clear input fields */
	JButton jbtClearInput = new JButton("Clear");
	
	/** Button to click to cancel the entry creation */
	JButton jbtCancel = new JButton("Cancel");
	
	/** Button to update entries when editing */
	JButton jbtUpdate = new JButton("Update");

	/** Drop Down options for series selection */
	JComboBox<Media> jcbSeries = new JComboBox<Media>();
	JLabel lblSeries = new JLabel("Series", JLabel.RIGHT);
	ArrayList<Media> series = new ArrayList<Media>();
	
	/** TextField to input new episode title. */
	JTextField jtfTitle  = new JTextField(20);
	JLabel lblTitle = new JLabel("Title", JLabel.RIGHT);

	/** TextField to input episode's season number. */
	JTextField jtfSeasonNumber = new JTextField(20);
	JLabel lblSeasonNumber = new JLabel("Season Number", JLabel.RIGHT);

	/** TextField to input episode's episode number. */
	JTextField jtfEpisodeNumber  = new JTextField(20);
	JLabel lblEpisodeNumber = new JLabel("Episode Number", JLabel.RIGHT);
	
	/** TextField to input episode's year. */
	JTextField jtfYear  = new JTextField(20);
	JLabel lblYear = new JLabel("Year", JLabel.RIGHT);
	
	/**
	 * Constructor for a Episode Entry Window.
	 */
	EpisodeEntryWindow () {
		setTitle("Add Episode Entry");

		// First checks if database contains any series to add to drop list
		if (databaseModel != null && databaseModel.getMedia(2).size() != 0) {
			for (int i = 0; i < series.size(); ++i) {
				jcbSeries.addItem(series.get(i));
			}
		}

		// Create Panels for all of the input fields and buttons
		JPanel jplSeriesDropdown = new JPanel(new GridLayout(1, 0, 5, 5)); 
		jplSeriesDropdown.add(lblSeries);
		jplSeriesDropdown.add(jcbSeries);// Panel for Series JCB and LBL
		
		JPanel jplTitle = new JPanel(new GridLayout(1, 0, 5, 5));
		jplTitle.add(lblTitle);
		jplTitle.add(jtfTitle); // Panel for Title JTF and LBL

		JPanel jplSeasonNumber = new JPanel(new GridLayout(1, 0, 5, 5));
		jplSeasonNumber.add(lblSeasonNumber);
		jplSeasonNumber.add(jtfSeasonNumber); // Panel for SeasonNumber JTF and LBL

		JPanel jplEpisodeNumber = new JPanel(new GridLayout(1, 0, 5, 5));
		jplEpisodeNumber.add(lblEpisodeNumber);
		jplEpisodeNumber.add(jtfEpisodeNumber); // Panel for EpisodeNumber JTF and LBL

		JPanel jplYear = new JPanel(new GridLayout(1, 0, 5, 5));
		jplYear.add(lblYear);
		jplYear.add(jtfYear);  // Panel for Year JTF and LBL

		JPanel jplButton = new JPanel(new GridLayout(1, 0, 5, 5));
		jplButton.add(jbtCreateEntry);
		jplButton.add(jbtClearInput);
		jplButton.add(jbtCancel); 

		// Set up the content pane and add all the panels to it.
		setLayout(new GridLayout(0, 1, 5, 5));
		add(jplSeriesDropdown);
		add(jplTitle);
		add(jplSeasonNumber);
		add(jplEpisodeNumber);
		add(jplYear);
		add(jplButton);
		pack();
	} // end EpisodeEntryWindow
	
	/**
	 * Constructor for Episode Edit View.
	 * 
	 * @param	e	Episode to be edited. Existing data will prepopulate the text fields
	 * 				of the edit view.
	 */
	EpisodeEntryWindow (Episode e) {
		setTitle("Edit Episode Entry");
		
		// First checks if database contains any series to add to drop list
		if (databaseModel != null && databaseModel.getMedia(2).size() != 0) {
			for (int i = 0; i < series.size(); ++i) {
				jcbSeries.addItem(series.get(i));
			}
		}

		//Set the episode's information to the JTextFields
		jtfTitle.setText(e.getTitle());
		jtfYear.setText(e.getReleaseYear());
		jtfSeasonNumber.setText(e.getSeasonNumberOnly());
		jtfEpisodeNumber.setText(e.getEpisodeNumberOnly());

		// Create Panels for all of the input fields and buttons
		JPanel jplSeriesDropdown = new JPanel(new GridLayout(1, 0, 5, 5)); 
		jplSeriesDropdown.add(lblSeries);
		jplSeriesDropdown.add(jcbSeries);// Panel for Series JCB and LBL
		
		JPanel jplTitle= new JPanel(new GridLayout(1, 0, 5, 5));
		jplTitle.add(lblTitle);
		jplTitle.add(jtfTitle); // Panel for Title JTF and LBL
		
		JPanel jplSeasonNumber = new JPanel(new GridLayout(1, 0, 5, 5));
		jplSeasonNumber.add(lblSeasonNumber);
		jplSeasonNumber.add(jtfSeasonNumber); // Panel for Year JTF and LBL
		
		JPanel jplEpisodeNumber = new JPanel(new GridLayout(1, 0, 5, 5));
		jplEpisodeNumber.add(lblEpisodeNumber);
		jplEpisodeNumber.add(jtfEpisodeNumber); // Panel for Numeral JTF and LBL
		
		JPanel jplYear = new JPanel(new GridLayout(1, 0, 5, 5));
		jplYear.add(lblYear);
		jplYear.add(jtfYear);  // Panel for Year JTF and LBL
		
		JPanel jplButton = new JPanel(new GridLayout(1, 0, 5, 5));
		jplButton.add(jbtUpdate);
		jplButton.add(jbtClearInput);
		jplButton.add(jbtCancel); 
		// Panel for buttons

		// Set up the content pane and add all the panels to it.
		setLayout(new GridLayout(0, 1, 5, 5));
		add(jplSeriesDropdown);
		add(jplTitle);
		add(jplSeasonNumber);
		add(jplEpisodeNumber);
		add(jplYear);
		add(jplButton);
		pack();
	} // end EpisodeEntryWindow
	
	public void update() {
		setTitle("Add Episode Entry");
		
		// First checks if database contains any series to add to drop list
		if (databaseModel != null && databaseModel.getMedia(2).size() != 0) {
			for (int i = 0; i < series.size(); ++i) {
				jcbSeries.addItem(series.get(i));
			}
		}

		// Create Panels for all of the input fields and buttons
		JPanel jplSeriesDropdown = new JPanel(new GridLayout(1, 0, 5, 5)); 
		jplSeriesDropdown.add(lblSeries);
		jplSeriesDropdown.add(jcbSeries);// Panel for Series JCB and LBL
		
		JPanel jplTitle = new JPanel(new GridLayout(1, 0, 5, 5));
		jplTitle.add(lblTitle);
		jplTitle.add(jtfTitle); // Panel for Title JTF and LBL

		JPanel jplSeasonNumber = new JPanel(new GridLayout(1, 0, 5, 5));
		jplSeasonNumber.add(lblSeasonNumber);
		jplSeasonNumber.add(jtfSeasonNumber); // Panel for SeasonNumber JTF and LBL

		JPanel jplEpisodeNumber = new JPanel(new GridLayout(1, 0, 5, 5));
		jplEpisodeNumber.add(lblEpisodeNumber);
		jplEpisodeNumber.add(jtfEpisodeNumber); // Panel for EpisodeNumber JTF and LBL

		JPanel jplYear = new JPanel(new GridLayout(1, 0, 5, 5));
		jplYear.add(lblYear);
		jplYear.add(jtfYear);  // Panel for Year JTF and LBL

		JPanel jplButton = new JPanel(new GridLayout(1, 0, 5, 5));
		jplButton.add(jbtCreateEntry);
		jplButton.add(jbtClearInput);
		jplButton.add(jbtCancel); 

		// Set up the content pane and add all the panels to it.
		setLayout(new GridLayout(0, 1, 5, 5));
		add(jplSeriesDropdown);
		add(jplTitle);
		add(jplSeasonNumber);
		add(jplEpisodeNumber);
		add(jplYear);
		add(jplButton);
		pack();
	} // end update

	/**
	 * A mutator for the variable databaseModel.
	 * 
	 * @param	databaseModel	Database model to set to the episode entry view.
	 */
	public void setDatabaseModel(DatabaseModel databaseModel) {
		this.databaseModel = databaseModel;
	} // end setDatabaseModel
	
	/**
	 * Method to clear all input fields for the movie entry
	 */
	public void clearInputFields() {
		jtfTitle.setText("");
		jtfSeasonNumber.setText("");
		jtfEpisodeNumber.setText("");
		jtfYear.setText("");
	} // end clearInputFields
	
	/**
	 * A mutator for the variable series.
	 * 
	 * @param	series	A JList of all media within the database.
	 */
	public void setSeriesDropDown(ArrayList<Media> series) {
		this.series = series;
	} // end setSeriesDrop
	
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
} // ENDS EPISODE ENTRY WINDOW CLASS
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

/**
 * Project 4
 * CS 2334, Section 10
 * April 1 2016
 * <p>
 * The selection view of the MVC program in which displays the file,
 * edit, and display menus. Along with buttons of all media and
 * media maker data types in which user can select to edit and
 * view data stored from the database.
 * </p>
 * @version 1.0
 */
public class SelectionViewWindow extends JFrame implements Serializable {

	private static final long serialVersionUID = 4661929217038902389L;
	
	private DatabaseModel databaseModel;

	// Variable to hold the data type displayed as chosen by user
	String dataTypeChosen = "Just Checking";
	
	// Radio Button / Button Group declarations
	/** Button Group to hold all of the RadioButtons */
	private ButtonGroup buttonGroup = new ButtonGroup();
	
	/** Radio Button to display Media content in scroll pane */
	JRadioButton jbtRadioMedia = new JRadioButton("Media");
	
	/** Radio Button to display Movie content in scroll pane */
	JRadioButton jbtRadioMovies = new JRadioButton("Movies");
	
	/** Radio Button to display Series content in scroll pane */
	JRadioButton jbtRadioSeries = new JRadioButton("Series");
	
	/** Radio Button to display Episode content in scroll pane */
	JRadioButton jbtRadioEpisodes = new JRadioButton("Episodes");
	
	/** Radio Button to display Maker content in scroll pane */
	JRadioButton jbtRadioMakers = new JRadioButton("Makers");
		
	/** Radio Button to display Actor content in scroll pane */
	JRadioButton jbtRadioActors = new JRadioButton("Actors");
	
	/** Radio Button to display Director content in scroll pane */
	JRadioButton jbtRadioDirectors = new JRadioButton("Directors");
	
	/** Radio Button to display Producer content in scroll pane */
	JRadioButton jbtRadioProducers = new JRadioButton("Producers");
	
	// File Menu declarations
	JMenu jmFile = new JMenu("File"); // File Menu
	JMenuItem jmiLoad = new JMenuItem("Load"); // File Menu item to choose to load a file
	JMenuItem jmiSave = new JMenuItem("Save"); // File Menu item to choose to save to a file
	JMenuItem jmiImport = new JMenuItem("Import"); // File Menu item to choose to import a text file
	JMenuItem jmiExport =  new JMenuItem("Export"); // File Menu item to choose to export to a text file
	
	// Edit Menu declarations
	JMenu jmEdit = new JMenu("Edit"); // Edit Menu
	JMenuItem jmiAdd = new JMenuItem("Add"); // Edit Menu item to add an entry
	JMenuItem jmiEdit = new JMenuItem("Edit"); // Edit Menu item to edit an entry
	JMenuItem jmiDelete = new JMenuItem("Delete"); // Edit Menu item to delete an entry
	JMenuItem jmiClear = new JMenuItem("Clear"); // Edit Menu item to clear all of an entry type
	JMenuItem jmiClearAll = new JMenuItem("Clear All"); // Edit Menu item to clear all entries
	
	// Display Menu declarations
	JMenu jmDisplay = new JMenu("Display"); // Display Menu
	JMenuItem jmiPieChart = new JMenuItem("Pie Chart"); // Display Menu item to display selected entry's information as a pie chart
	JMenuItem jmiHistogram = new JMenuItem("Histogram"); // Display Menu item to display selected entry's information as a histogram

	// Menu Bar for menu buttons
	JMenuBar jmbMenu = new JMenuBar();
	
	// JLabels for SelectionViewWindow
	JLabel leftButtonSelection = new JLabel("Selection"); // Label for the Radio Buttons on the LHS of SVW
	JLabel rightSelectionType = new JLabel(dataTypeChosen); // Label for the content type in the scroll pane of SVW
		// TODO fix this RHS SVW selection type label with the variable name that will contain which radio button is chosen
	
	// Scroll Pane Printout declarations
	JList<String> jlDisplay = new JList<String>(); // List for the media entries to show in scroll pane
	JList<Media> jlMediaEntries = new JList<Media>(); // List for the media entries for searching purposes
	JList<MediaMaker> jlMakerEntries = new JList<MediaMaker>(); // List for the media maker entries to show in scroll pane
	
	// Panel declarations
	JPanel jplRadioButtons = new JPanel(); // Panel to hold all of the radio buttons on LHS
	JScrollPane jplScrollPane = new JScrollPane(); // Scroll to hold the database printout of SVW
	JPanel jplScrollAndLabel = new JPanel(); // Panel to hold the scroll pane and the selection type label
	
	JSplitPane jspAppWindow;;
	
	/** 
	 * Constructor for a Selection View Window
	 */
	SelectionViewWindow() {
		setTitle("MDb");
		
		// Set ALL of the DAMN Tool Tip Help Text
		jbtRadioMedia.setToolTipText("Click this button to display all of the Media entries in the database in the pane to the left.");
		jbtRadioMovies.setToolTipText("Click this button to display all of the Movie entries in the database in the pane to the left.");
		jbtRadioSeries.setToolTipText("Click this button to display all of the Series entries in the database in the pane to the left.");
		jbtRadioEpisodes.setToolTipText("Click this button to display all of the Episode entries in the database in the pane to the left.");
		jbtRadioMakers.setToolTipText("Click this button to display all of the Maker entries in the database in the pane to the left.");
		jbtRadioActors.setToolTipText("Click this button to display all of the Actor entries in the database in the pane to the left.");
		jbtRadioDirectors.setToolTipText("Click this button to display all of the Director entries in the database in the pane to the left.");
		jbtRadioProducers.setToolTipText("Click this button to display all of the Producer entries in the database in the pane to the left.");
		
		jplScrollPane.setToolTipText("Database entries of the type chosen at the left will be displayed in this pane.");
		jplRadioButtons.setToolTipText("Clicking these buttons determines the type of data entries to be displayed in the pane to the left."); 
		
		jmFile.setToolTipText("Menu containing File options");
		jmEdit.setToolTipText("Menu containing Edit options");
		jmDisplay.setToolTipText("Menu containing Display options");
		
		jmbMenu.setToolTipText("I spent 2.5 hours trying to constrain the resizing of this menu bar manually. Gave up." 
				+ "Turns out you can set it in 2.5 seconds using the setJMenuBar() method of JFrame. I have never been so frustrated.");
		
		jmiLoad.setToolTipText("Load database information from a binary file");
		jmiSave.setToolTipText("Save displayed database information to a binary file");
		jmiImport.setToolTipText("Import database information from a text file");
		jmiExport.setToolTipText("Export displayed database information to a text file");
		
		jmiAdd.setToolTipText("Add a data entry of the chosen data type to the database");
		jmiEdit.setToolTipText("Edit the selected data entry");
		jmiDelete.setToolTipText("Delete the selected data entry");
		jmiClear.setToolTipText("Clear all the data entries of the chosen type from the database");
		jmiClearAll.setToolTipText("Clear of the data entries, regardless of type, from the database");
		
		jmiPieChart.setToolTipText("Display the selected Maker entry's information as a pie chart");
		jmiHistogram.setToolTipText("Display the selected Maker entry's information as a histogram");
	
		// Add RadioButtons to ButtonGroup
		buttonGroup.add(jbtRadioMedia);
		buttonGroup.add(jbtRadioMovies);
		buttonGroup.add(jbtRadioSeries);
		buttonGroup.add(jbtRadioEpisodes);
		buttonGroup.add(jbtRadioMakers);
		buttonGroup.add(jbtRadioActors);
		buttonGroup.add(jbtRadioDirectors);
		buttonGroup.add(jbtRadioProducers);
		
		// Add button contents to File Menu & Grey out 
		jmFile.add(jmiLoad);
		jmFile.add(jmiSave);
			jmiSave.setEnabled(false); // Initially greys out the menu option. Will be enabled upon database initialization
		jmFile.add(jmiImport);
		jmFile.add(jmiExport);
			jmiExport.setEnabled(false); // Initially greys out the menu option. Will be enabled upon database initialization
		
		// Add button contents to Edit Menu & Grey out
		jmEdit.add(jmiAdd);
			jmiAdd.setEnabled(false); // Initially greys out the menu option. Will be enabled after radio button is selected
		jmEdit.add(jmiEdit);
			jmiEdit.setEnabled(false); // Initially greys out the menu option. Will be enabled upon database initialization
		jmEdit.add(jmiDelete);
			jmiDelete.setEnabled(false); // Initially greys out the menu option. Will be enabled upon database initialization
		jmEdit.add(jmiClear);
			jmiClear.setEnabled(false); // Initially greys out the menu option. Will be enabled upon database initialization
		jmEdit.add(jmiClearAll);
			jmiClearAll.setEnabled(false); // Initially greys out the menu option. Will be enabled upon database initialization
		
		// Add button contents to Display Menu
		jmDisplay.add(jmiPieChart);
			jmiPieChart.setEnabled(false); // Initially greys out the menu option. Will be enabled upon database initialization
		jmDisplay.add(jmiHistogram);
			jmiHistogram.setEnabled(false); // Initially greys out the menu option. Will be enabled upon database initialization
		
		// Add Menus to MenuBar
		jmbMenu.add(jmFile);
		jmbMenu.add(jmEdit);
		jmbMenu.add(jmDisplay);
		
		// Add Buttons and label vertically to the buttons panel 
		jplRadioButtons.setLayout(new GridBagLayout()); // Set up GridBagLayout
		GridBagConstraints layoutConst = new GridBagConstraints();
		
		leftButtonSelection.setFont(new Font("Lucida Grande", Font.BOLD, 16)); // Modify appearance of label
		
		layoutConst.gridx = 0;
		layoutConst.gridy = 0;
		layoutConst.insets = new Insets(10,10,10,10);
		jplRadioButtons.add(leftButtonSelection, layoutConst);
		layoutConst.gridy = 1;
		layoutConst.insets = new Insets(2,2,2,2);
		jplRadioButtons.add(jbtRadioMedia, layoutConst);
		layoutConst.gridy = 2;
		jplRadioButtons.add(jbtRadioMovies,layoutConst);
		layoutConst.gridy = 3;
		jplRadioButtons.add(jbtRadioSeries, layoutConst);
		layoutConst.gridy = 4;
		jplRadioButtons.add(jbtRadioEpisodes, layoutConst);
		layoutConst.gridy = 5;
		jplRadioButtons.add(jbtRadioMakers, layoutConst);
		layoutConst.gridy = 6;
		jplRadioButtons.add(jbtRadioActors, layoutConst);
		layoutConst.gridy = 7;
		jplRadioButtons.add(jbtRadioDirectors, layoutConst);
		layoutConst.gridy = 8;
		jplRadioButtons.add(jbtRadioProducers, layoutConst);
		
		// Split Pane window for the application window
		jplScrollAndLabel.setLayout(new BorderLayout());
		jplScrollAndLabel.add(rightSelectionType, BorderLayout.NORTH);
		jplScrollAndLabel.add(jplScrollPane, BorderLayout.CENTER);
		
		jspAppWindow = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
			jplRadioButtons, jplScrollAndLabel);
		// Sets the scroll area gets on default all of the extra resize area
		jspAppWindow.setResizeWeight(0);
		
		// Set up the content pane and add all of the everything to it
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(0,1,5,5));
		setJMenuBar(jmbMenu);
		add(jspAppWindow);
		pack();
	}
	
	/**
	 * A mutator for the variable databaseModel.
	 * 
	 * @param	databaseModel	The database model to be set.
	 */
	public void setDatabaseModel(DatabaseModel databaseModel) {
		this.databaseModel = databaseModel;
	} // end setDatabaseModel
	
	/**
	 * Method to add listener to Media Radio Button.
	 * 
	 * @param	radioMediaListener	Listener to be registered to the radio media button.
	 */
	public void addRadioMediaButtonListener (ActionListener radioMediaListener) {
		jbtRadioMedia.addActionListener(radioMediaListener);
	} // end addRadioMediaButtonListener
	
	/**
	 * Method to add listener to Movies Radio Button.
	 * 
	 * @param	radioMovieListener	Listener to be registered to the radio movie button,
	 */
	public void addRadioMovieButtonListener (ActionListener radioMovieListener) {
		jbtRadioMovies.addActionListener(radioMovieListener);
	} // end addRadioMovieButtonListener
	
	/**
	 * Method to add listener to Series Radio Button.
	 * 
	 * @param	radioSeriesListener	Listener to be registered to the radio series button.
	 */
	public void addRadioSeriesButtonListener (ActionListener radioSeriesListener) {
		jbtRadioSeries.addActionListener(radioSeriesListener);
	} // end addRadioSeriesButtonListener

	/**
	 * Method to add listener to Episodes Radio Button.
	 * 
	 * @param	radioEpisodesListener	Listener to be registered to the radio episode button.
	 */
	public void addRadioEpisodesButtonListener (ActionListener radioEpisodesListener) {
		jbtRadioEpisodes.addActionListener(radioEpisodesListener);
	} // end addRadioEpisodesButtonListener
	
	/**
	 * Method to add listener to Makers Radio Button.
	 * 
	 * @param	radioMakersListener	Listener to be registered to the radio makers button.
	 */
	public void addRadioMakersButtonListener (ActionListener radioMakersListener) {
		jbtRadioMakers.addActionListener(radioMakersListener);
	} // end addRadioMakersButtonListener
	
	/**
	 * Method to add listener to Actors Radio Button.
	 * 
	 * @param	radioActorsListener	Listener to be registered to the radio actors button.
	 */
	public void addRadioActorsButtonListener (ActionListener radioActorsListener) {
		jbtRadioActors.addActionListener(radioActorsListener);
	} // end addRadioActorsButtonListener
	
	/**
	 * Method to add listener to Directors Radio Button.
	 * 
	 * @param	radioDirectorsListener	Listener to be registered to the radio directors button.
	 */
	public void addRadioDirectorsButtonListener (ActionListener radioDirectorsListener) {
		jbtRadioDirectors.addActionListener(radioDirectorsListener);
	} // end addRadioDirectorsButtonListener
	
	/**
	 * Method to add listener to Producers Radio Button.
	 * 
	 * @param	radioProducersListener	Listener to be registered to the radio producers button.
	 */
	public void addRadioProducersButtonListener (ActionListener radioProducersListener) {
		jbtRadioProducers.addActionListener(radioProducersListener);
	} // end addRadioProducersButtonListener
	
	/**
	 * Method to add listener to File/Load option.
	 * 
	 * @param	loadListener	Listener to be registered to the selection view's load button.
	 */
	public void addLoadListener (ActionListener loadListener) {
		jmiLoad.addActionListener(loadListener);
	} // end addLoadListener
	
	/**
	 * Method to add listener to File/Save option.
	 * 
	 * @param	saveListener	Listener to be registered to the selection view's save button.
	 */
	public void addSaveListener (ActionListener saveListener) {
		jmiSave.addActionListener(saveListener);
	} // end addSaveListener
	
	/**
	 * Method to add listener to File/Import option.
	 * 
	 * @param	importListener	Listener to be registered to the selection view's import button.
	 */
	public void addImportListener (ActionListener importListener) {
		jmiImport.addActionListener(importListener);
	} // end addImportListener 
	
	/**
	 * Method to add listener to File/Export option.
	 * 
	 * @param	exportListener	Listener to be registered to the selection view's export button.
	 */
	public void addExportListener (ActionListener exportListener) {
		jmiExport.addActionListener(exportListener);
	} // end addExportListener
	
	/**
	 * Method to add listener to Edit/Add option.
	 * 
	 * @param	editAddListener	Listener to be registered to the selection view's add button.
	 */
	public void addAddListener (ActionListener editAddListener) {
		jmiAdd.addActionListener(editAddListener);
	} // end addAddListener 

	/**
	 * Method to add listener to Edit/Edit option.
	 * 
	 * @param	editEditListener	Listener to be registered to the selection view's edit button.
	 */
	public void addEditListener (ActionListener editEditListener) {
		jmiEdit.addActionListener(editEditListener);
	} // end addEditListener
	
	/**
	 * Method to add listener to Edit/Delete option.
	 * 
	 * @param	editDeleteListener	Listener to be registered to the selection view's delete button.
	 */
	public void addDeleteListener (ActionListener editDeleteListener) {
		jmiDelete.addActionListener(editDeleteListener);
	} // end addDeleteListener
	
	/**
	 * Method to add listener to Edit/Clear option.
	 * 
	 * @param	editClearListener	Listener to be registered to the selection view's clear button.
	 */
	public void addClearListener (ActionListener editClearListener) {
		jmiClear.addActionListener(editClearListener);
	} // end addClearListener
	
	/**
	 * Method to add listener to Edit/Clear All option.
	 * 
	 * @param	editClearAllListener	Listener to be registered to the selection view's
	 *                                  clear all button.
	 */
	public void addClearAllListener (ActionListener editClearAllListener) {
		jmiClearAll.addActionListener(editClearAllListener);
	} // end addClearAllListener
	
	/**
	 * Method to add listener to Display/Pie Chart option.
	 * 
	 * @param	displayPieChartListener	Listener to be registered to the selection view's
	 *                                  Pie Chart button.
	 */
	public void addPieChartListener (ActionListener displayPieChartListener) {
		jmiPieChart.addActionListener(displayPieChartListener);
	} // end addPieChartListener

	/**
	 * Method to add listener to Display/Histogram option.
	 * 
	 * @param	displayHistogramListener	Listener to be registered to the selection view's
	 * 										Histogram button.
	 */
	public void addHistogramListener (ActionListener displayHistogramListener) {
		jmiHistogram.addActionListener(displayHistogramListener);
	} // end addHistogramListener
} // ENDS SELECTION VIEW WINDOW CLASS
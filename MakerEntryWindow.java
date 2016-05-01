import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * Project 4
 * CS 2334, Section 010
 * 1 April 2016
 * <p>
 * Each object of this class represents a GUI maker entry window (MVC view).
 * </p> 
 *
 */
public class MakerEntryWindow extends JFrame {
	/** Serial version number to be used during serialization. */
	private static final long serialVersionUID = -3971606497475586171L;
	
	DatabaseModel dbmodel = new DatabaseModel();

	/** Media */
	JList<String> stringMedia1 = new JList<String>();
	JList<String> stringMedia2 = new JList<String>();
	JList<String> stringMedia3 = new JList<String>();
	JList<Media> mediaMedia = new JList<Media>();
	
	ArrayList<Media> tempAC = new ArrayList<Media>();
	ArrayList<Media> tempDC = new ArrayList<Media>();
	ArrayList<Media> tempPC = new ArrayList<Media>();
	
	/** Button to click to create new episode entry */
	JButton jbtCreateEntry = new JButton("Add Media Maker");

	/** Button to clear text fields of episode info. */
	JButton jbtClearInput = new JButton("Clear Fields");

	/** Button to cancel entry */
	JButton jbtCancel = new JButton("Cancel");
	
	/** Button to update entries when editing */
	JButton jbtUpdate = new JButton("Update");
	
	/** Button to make new media entry for acting credits */
	JButton jbtAddMedia1 = new JButton("Add New Media");
	JButton jbtAddMedia2 = new JButton("Add New Media");
	JButton jbtAddMedia3 = new JButton("Add New Media");
	
	/** TextFields to input maker name and disambiguation number */
	JTextField jtfFirstName = new JTextField(20);
	JLabel lblFirstName = new JLabel("First Name", JLabel.RIGHT);
	JTextField jtfLastName = new JTextField(20);
	JLabel lblLastName = new JLabel("Last Name", JLabel.RIGHT);
	JTextField jtfDisambigNumber = new JTextField(20);
	JLabel lblDisambigNumber = new JLabel("Disambiguation Number", JLabel.RIGHT);
	
	/** Drop down menus for maker's credits */
	// Acting Credits
	JScrollPane jspActingCredits = new JScrollPane(stringMedia1);
	JLabel lblActingCredits = new JLabel("Acting Credits", JLabel.RIGHT);
	JButton jbtAddToAC = new JButton("Add to Acting Credits");
	
	// Directing Credits
	JScrollPane jspDirectingCredits = new JScrollPane(stringMedia2);
	JLabel lblDirectingCredits = new JLabel("Directing Credits", JLabel.RIGHT);
	JButton jbtAddToDC = new JButton("Add to Directing Credits");
	
	// Producing Credits
	JScrollPane jspProducingCredits = new JScrollPane(stringMedia3);
	JLabel lblProducingCredits = new JLabel("Producing Credits", JLabel.RIGHT);
	JButton jbtAddToPC = new JButton("Add to Producing Credits");
	
	//initialize the panesl with jscrollpanes
	JPanel jplActingCredits = new JPanel(new GridLayout(1, 0, 5, 5));
	JPanel jplDirectingCredits = new JPanel(new GridLayout(1, 0, 5, 5));
	JPanel jplProducingCredits = new JPanel(new GridLayout(1, 0, 5, 5));
	JPanel jplButton = new JPanel();
		
	/**
	 * Constructor for a Maker Entry Window
	 */
	MakerEntryWindow() {
		setTitle("Add New Media Maker");
		
		// Create panels for name, disambig number
		JPanel jplFirstName = new JPanel(new GridLayout(1, 0, 5, 5));
		jplFirstName.add(lblFirstName);
		jplFirstName.add(jtfFirstName);
		
		JPanel jplLastName = new JPanel(new GridLayout(1, 0, 5, 5));
		jplLastName.add(lblLastName);
		jplLastName.add(jtfLastName);
		
		JPanel jplDisambigNum = new JPanel(new GridLayout(1, 0, 5, 5));
		jplDisambigNum.add(lblDisambigNumber);
		jplDisambigNum.add(jtfDisambigNumber);
		
		// Create a panel for acting credits 
		
		jplActingCredits.setLayout(new BorderLayout());
		
		//Panel for buttons for the panel of acting credits
		JPanel jplACButtons = new JPanel(new GridLayout(1,0,5,5));
		jplACButtons.add(jbtAddMedia1);
		jplACButtons.add(jbtAddToAC);
		
		jplActingCredits.add(lblActingCredits,BorderLayout.NORTH);
		jplActingCredits.add(jspActingCredits,BorderLayout.CENTER);
		jplActingCredits.add(jplACButtons, BorderLayout.SOUTH);
		
		// Create a panel for directing credits 
		jplDirectingCredits.setLayout(new BorderLayout());
		
		//Panel for buttons for the panel of Directing credits
		JPanel jplDCButtons = new JPanel(new GridLayout(1,0,5,5));
		jplDCButtons.add(jbtAddMedia2);
		jplDCButtons.add(jbtAddToDC);
		
		jplDirectingCredits.add(lblDirectingCredits,BorderLayout.NORTH);
		jplDirectingCredits.add(jspDirectingCredits,BorderLayout.CENTER);
		jplDirectingCredits.add(jplDCButtons, BorderLayout.SOUTH);
		
		// Create a panel for Producing credits 

		jplProducingCredits.setLayout(new BorderLayout());
		
		//Panel for buttons for the panel of Producing credits
		JPanel jplPCButtons = new JPanel(new GridLayout(1,0,5,5));
		jplPCButtons.add(jbtAddMedia3);
		jplPCButtons.add(jbtAddToPC);
		
		jplProducingCredits.add(lblProducingCredits,BorderLayout.NORTH);
		jplProducingCredits.add(jspProducingCredits,BorderLayout.CENTER);
		jplProducingCredits.add(jplPCButtons, BorderLayout.SOUTH);
			
		// Create panels for command buttons
		
		jplButton.setLayout(new GridLayout(1, 0, 5, 5));
		jplButton.add(jbtCreateEntry);
		jplButton.add(jbtClearInput);
		jplButton.add(jbtCancel);	
				
		//Set up the content pane and all panels and buttons to it
		setLayout(new GridLayout(0, 1, 5, 5));
		add(jplFirstName);
		add(jplLastName);
		add(jplDisambigNum);
		add(jplActingCredits);
		add(jplDirectingCredits);
		add(jplProducingCredits);
		add(jplButton);
		pack();
	}
	
	/**
	 * Constructor for a Maker Edit Window.
	 * 
	 * @param	m	Maker to be edited. Existing data will prepopulate the text fields
	 * 				of the edit view.
	 */
	MakerEntryWindow(MediaMaker m) {
		setTitle("Edit Media Maker");

		// Create panels for name, disambig number
		JPanel jplFirstName = new JPanel(new GridLayout(1, 0, 5, 5));
		jtfFirstName.setText(m.getFirstName());
		jplFirstName.add(lblFirstName);
		jplFirstName.add(jtfFirstName);
		
		JPanel jplLastName = new JPanel(new GridLayout(1, 0, 5, 5));
		jtfLastName.setText(m.getLastName());
		jplLastName.add(lblLastName);
		jplLastName.add(jtfLastName);
		
		JPanel jplDisambigNum = new JPanel(new GridLayout(1, 0, 5, 5));
		jtfDisambigNumber.setText(m.getDisambigNum());
		jplDisambigNum.add(lblDisambigNumber);
		jplDisambigNum.add(jtfDisambigNumber);
		
		// Create a panel for acting credits 
		JPanel jplActingCredits = new JPanel(new GridLayout(1, 0, 5, 5));
		jplActingCredits.setLayout(new BorderLayout());
		
		//Panel for buttons for the panel of acting credits
		JPanel jplACButtons = new JPanel(new GridLayout(1,0,5,5));
		jplACButtons.add(jbtAddMedia1);
		jplACButtons.add(jbtAddToAC);
		
		jplActingCredits.add(lblActingCredits,BorderLayout.NORTH);
		jplActingCredits.add(jspActingCredits,BorderLayout.CENTER);
		jplActingCredits.add(jplACButtons, BorderLayout.SOUTH);
		
		// Create a panel for directing credits 
		JPanel jplDirectingCredits = new JPanel(new GridLayout(1, 0, 5, 5));
		jplDirectingCredits.setLayout(new BorderLayout());
		
		//Panel for buttons for the panel of Directing credits
		JPanel jplDCButtons = new JPanel(new GridLayout(1,0,5,5));
		jplDCButtons.add(jbtAddMedia2);
		jplDCButtons.add(jbtAddToDC);
		
		jplDirectingCredits.add(lblDirectingCredits,BorderLayout.NORTH);
		jplDirectingCredits.add(jspDirectingCredits,BorderLayout.CENTER);
		jplDirectingCredits.add(jplDCButtons, BorderLayout.SOUTH);
		
		// Create a panel for Producing credits 
		JPanel jplProducingCredits = new JPanel(new GridLayout(1, 0, 5, 5));
		jplProducingCredits.setLayout(new BorderLayout());
		
		//Panel for buttons for the panel of Producing credits
		JPanel jplPCButtons = new JPanel(new GridLayout(1,0,5,5));
		jplPCButtons.add(jbtAddMedia3);
		jplPCButtons.add(jbtAddToPC);
		
		jplProducingCredits.add(lblProducingCredits,BorderLayout.NORTH);
		jplProducingCredits.add(jspProducingCredits,BorderLayout.CENTER);
		jplProducingCredits.add(jplPCButtons, BorderLayout.SOUTH);
			
		// Create panels for command buttons
		JPanel jplButton = new JPanel();
		jplButton.setLayout(new GridLayout(1, 0, 5, 5));
		jplButton.add(jbtCreateEntry);
		jplButton.add(jbtClearInput);
		jplButton.add(jbtCancel);	
				
		//Set up the content pane and all panels and buttons to it
		setLayout(new GridLayout(0, 1, 5, 5));
		add(jplFirstName);
		add(jplLastName);
		add(jplDisambigNum);
		add(jplActingCredits);
		add(jplDirectingCredits);
		add(jplProducingCredits);
		add(jplButton);	
		pack();
	}
	
	public void updateView(){
		
		//Remove the old panels from teh view
		this.remove(jplActingCredits);
		this.remove(jplDirectingCredits);
		this.remove(jplProducingCredits);
		this.remove(jplButton);
		
		//update jlists
		Media[] media = dbmodel.getAllMedia().toArray(new Media[dbmodel.getAllMedia().size()]);
		String [] mediaList = new String[media.length];
		
		// Adds movies to string array for displaying in pane
		for (int i = 0; i < media.length; ++i) {
			if (media[i].getClass() == Episode.class) {
				Episode episode = (Episode) media[i];
				mediaList[i] = episode.toString(episode.getTitle());
			}
			else {
				mediaList[i] = media[i].toString();
			}
		}
		
		// Adds movies to media array for grabbing data within controller
		stringMedia1.setListData(mediaList);
		stringMedia2.setListData(mediaList);
		stringMedia3.setListData(mediaList);
		mediaMedia.setListData(media);
		
		//Update the JScrollPanes
		jplActingCredits.remove(jspActingCredits);
		
		jspActingCredits = new JScrollPane(stringMedia1);
		jplDirectingCredits.remove(jspDirectingCredits);
		jspDirectingCredits = new JScrollPane(stringMedia2);
		jplProducingCredits.remove(jspProducingCredits);
		jspProducingCredits = new JScrollPane(stringMedia3);
		
		//Add the JScrollPanes back to the JPanels
		jplActingCredits.add(jspActingCredits, BorderLayout.CENTER);
		jplDirectingCredits.add(jspDirectingCredits, BorderLayout.CENTER);
		jplProducingCredits.add(jspProducingCredits, BorderLayout.CENTER);
		
		//Add the updated panesl back to the view
		this.add(jplActingCredits);
		this.add(jplDirectingCredits);
		this.add(jplProducingCredits);
		this.add(jplButton);	
	}
	
	public void setDatabaseModel(DatabaseModel dbmodel){
		this.dbmodel = dbmodel;
	}

	/**
	 * Method to clear all input fields for the mediamaker entry.
	 */
	public void clearInputFields() {
		jtfFirstName.setText("");
		jtfLastName.setText("");
		jtfDisambigNumber.setText("");	
	} // end clearInputFields
	
	/**
	 * Method to add listener to Create Entry button.
	 * 
	 * @param	createEntryListener	Listener to be registered to a create entry button.
	 */
	public void addCreateEntryButtonListener (ActionListener createEntryListener) {
		jbtCreateEntry.addActionListener(createEntryListener);
	} // end addCreateEntryButtonListener
	
	/**
	 * Method to add listener to Clear Input Fields button
	 * 
	 * @param	clearInputListener	Listener to be registered to a clear input fields button.
	 */
	public void addClearInputListener (ActionListener clearInputListener) {
		jbtClearInput.addActionListener(clearInputListener);
	} // end addClearInputListener
	
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
	
	/**
	 * Method to add listener to Create Entry button.
	 * 
	 * @param	createEntryListener	Listener to be registered to a create entry button.
	 */
	public void addAddNewMediaEntryButtonListener (ActionListener addMediaEntryListener) {
		jbtAddMedia1.addActionListener(addMediaEntryListener);
		jbtAddMedia2.addActionListener(addMediaEntryListener);
		jbtAddMedia3.addActionListener(addMediaEntryListener);
	} // end addAddMediaEntryButtonListener
	
	/**
	 * Method to add listener to Create Entry button.
	 * 
	 * @param	createEntryListener	Listener to be registered to a create entry button.
	 */
	public void addAddToACEntryButtonListener (ActionListener addAddToACListener) {
		jbtAddToAC.addActionListener(addAddToACListener);
	} // end addAddMediaEntryButtonListener
	
	/**
	 * Method to add listener to Create Entry button.
	 * 
	 * @param	createEntryListener	Listener to be registered to a create entry button.
	 */
	public void addAddToDCButtonListener (ActionListener addAddToDCListener) {
		jbtAddToDC.addActionListener(addAddToDCListener);
	} // end addAddMediaEntryButtonListener
	
	/**
	 * Method to add listener to Create Entry button.
	 * 
	 * @param	createEntryListener	Listener to be registered to a create entry button.
	 */
	public void addAddToPCListener (ActionListener addAddToPCListener) {
		jbtAddToPC.addActionListener(addAddToPCListener);
	} // end addAddMediaEntryButtonListener
	
} // ENDS MAKER ENTRY WINDOW CLASS

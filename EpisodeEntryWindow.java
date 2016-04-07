import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;

/**
 * Project 4
 * CS 2334, Section 10
 * April 1 2016
 * <p>
 * The episode data entry view of the MVC program in which allows
 * user to add an episode to the database by providing input text fields
 * for information on the movie to be added. Note: Will not accept episodes
 * with years outside the range of years for the series of which it is a part.
 * Also there may not be two episodes with the same season and episode number
 * pair or any errors with input, and thus, notify user when it occurs.
 * </p>
 * @version 1.0
 */
public class EpisodeEntryWindow extends JFrame {
	/** Serial version ID to be used during serialization. */
	private static final long serialVersionUID = -7212870393643685878L;

	/**
	 * Button to click to add new episode to the database based on filled text
	 * fields.
	 */
	JButton jbtAddEpisode = new JButton("Add Episode");

	/** TextField to input new episode's title. */
	JTextField jtfTitle = new JTextField(20);
	JLabel lblTitle = new JLabel("Episode Title", JLabel.RIGHT);

	/** TextField to input episode's release year. */
	JTextField jtfYear = new JTextField(20);
	JLabel lblYear = new JLabel("Release Year", JLabel.RIGHT);

	/** TextField to input episode's season and episode number. */
	JTextField jtfSeasonAndEpNum = new JTextField(20);
	JLabel lblSeasonAndEpNum = new JLabel("Season and Episode Number", JLabel.RIGHT);
	/* TODO: Either Tell user to input season/episode number in correct format:
	 * Ex. #1.16 for season one, episode 16. Or create separate buttons for
	 * season/ep and concatenate strings within episode constructor later. Or
	 * just 2 create separate fields. 
	 */
	
	/**
	 * Constructor for the episode entry view in which adds all of the objects
	 * and variables as GUI components to be displayed to user and allow them
	 * to add episodes to the database
	 */
	public EpisodeEntryWindow() {
		// TODO
	} // end EpisodeEntryView constructor
	
	/**
	 * 
	 * @param addEpisodeListener
	 */
	public void addAddEpisodeButtonListener(ActionListener addEpisodeListener) {
		// TODO
	} // end addAddEpisodeButtonListener
} // end EpisodeEntryView Class
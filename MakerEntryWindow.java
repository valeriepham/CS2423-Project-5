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
 * The people data entry view of the MVC program in which allows
 * user to add a person to the database by providing input text fields
 * for information on the person to be added. Note: Will not accept any
 * duplicate names for people already within the database or any errors in input,
 * and thus, notify user when it occurs.
 * </p>
 * @version 1.0
 */
public class MakerEntryWindow extends JFrame{
	/** Serial version ID to be used during serialization. */
	private static final long serialVersionUID = -2559450291389576744L;

	/**
	 * Button to click to add new person to the database based on filled text
	 * fields.
	 */
	JButton jbtAddPerson = new JButton("Add");

	/** TextField to input new person's name. */
	JTextField jtfFullName = new JTextField(20);
	JLabel lblFullName = new JLabel("Full Name", JLabel.RIGHT);
	// TODO: Notify user if person already exists in database and
	// give option to insert a disambiguation number.
	
	/**
	 * Constructor for the people entry view in which adds all of the objects
	 * and variables as GUI components to be displayed to user and allow them
	 * to add people to the database
	 * 
	 * @param	personType	An int determining if user selected Makers, Actors, Directors,
	 *                      or Producers, which will determine which dialogs to display
	 *                      and which additions user is allowed to make relatie to their selection.
	 */
	public MakerEntryWindow(int personType) {
		// TODO
	} // endPeopleEntryView
	
	// TODO: pull up list of movies and episodes to add to person's credits
	
	/**
	 * 
	 * @param addPeopleListener
	 */
	public void addAddPersonButtonListener(ActionListener addPersonListener) {
		// TODO
	} // end addAddPersonButtonListener
} // end PeopleEntryView Class
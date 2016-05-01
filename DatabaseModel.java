import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class DatabaseModel extends Database {
	/** Serial number to be used during serialization. */
	private static final long serialVersionUID = -1652280872930357027L;

	/** List to keep track of who is registered to listen for events from the DatabaseModel. */
	private ArrayList<ActionListener> actionListenerList;
	
	/**
	 * Default constructor for the database model when declaring it in the Driver.
	 */
	public DatabaseModel() {
		// intentionally empty
	} // end DatabaseModel constructor
	
	public DatabaseModel(ArrayList<Media> media, LinkedHashMap<String, MediaMaker> people){
		super(media, people);
	} // end DatabaseModel constructor
	
	/**
	 * Adds person to the database in the model.
	 * @param person	Media maker to be added to the database,
	 * @return	Results for if addition was successful.
	 */
	public boolean addPerson(MediaMaker person) {
		boolean success = super.addPerson(person);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "add person"));
		return success;
	} // end addPerson
	
	/**
	 * Replaces a media maker in the database.
	 * @param person	Person to be replaced.
	 * @return	Results for if addition was successful.
	 */
	public boolean replacePerson(MediaMaker person, MediaMaker person2){
		boolean success = super.replacePerson(person, person2);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "replace person"));
		return success;
	} // end replacePerson
	
	/**
	 * Deletes the given MediaMaker object from the database.
	 * @param person the the object to be deleted
	 */
	public boolean deleteMediaMaker(MediaMaker person) {
		boolean success =super.deleteMediaMaker(person);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "delete media maker"));
		return success;
	}

	/**
	 * Clears a list of people according to user selection in the database.
	 * @param	type	Type of media makers to be removed.
	 */
	public void clearPeople(int type) {
		super.clearPeople(type);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "clear people"));
	} // end clearPeople
	
	/**
	 * Adds media to the database in the model.
	 * @param media	Media to be added to the database.
	 * @return Results for if addition was successful.
	 */
	public boolean addMedia(Media media) {
		boolean success = super.addMedia(media);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "add media"));
		return success;
	} // end addMedia
	
	/**
	 * Deletes the given Media object from the database.
	 * @param media the object to be deleted
	 */
	public boolean deleteMedia(Media media) {
		boolean success = super.deleteMedia(media);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "delete media"));
		return success;
	}

	/**
	 * Replaces a media object in the database.
	 * @param	media	Media to be replaced.
	 * @param toBeDeleted Media to be deleted
	 * @return	result for if addition was successful.
	 */
	public boolean replaceMedia(Media media, Media toBeDeleted){
		boolean success = super.replaceMedia(media, toBeDeleted);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "replace media"));
		return success;
	} // end replaceMedia
	
	/**
	 * Clears all Media of certain type from the database.
	 * @param type the type of the media: 1 for Movie, 2 for Series, 3 for Episode
	 */
	public void clearMedia(int type) {
		super.clearMedia(type);
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "clear media"));
	} // end clearMedia
	
	/**
	 * Clears all Media and MediaMaker objects from the database.
	 */
	public void clearAll() {
		super.clearAll();
		processEvent(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "clear all"));
	}
	
	/**
	 * Register an action event listener.
	 * @param	l	ActionLister to be added.
	 */
	public synchronized void addActionListener(ActionListener l) {
		if (actionListenerList == null)
			actionListenerList = new ArrayList<ActionListener>();
		actionListenerList.add(l);
	} // end addActionListener
	
	/**
	 * Remove an action event listener.
	 * @param	l	ActionListener to be removed.
	 */
	public synchronized void removeActionListener(ActionListener l) {
		if (actionListenerList != null && actionListenerList.contains(l))
			actionListenerList.remove(l);
	} // end removeActionListener
	
	/**
	 * Fire event.
	 * @param	e	ActionEvent to notify listener when GUI is interacted with.
	 */
	private void processEvent(ActionEvent e) {
		ArrayList<ActionListener> list;
		
		synchronized (this) {
			if (actionListenerList == null) return;
			list = (ArrayList<ActionListener>)actionListenerList.clone();
		}
		
		for (int i = 0; i < list.size(); i++) {
			ActionListener listener = list.get(i);
			listener.actionPerformed(e);
		}
	} //end processEvent
} // end DatabaseModel Class
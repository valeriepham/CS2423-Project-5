import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * Project 4
 * CS 2334, Section 10
 * April 1 2016
 * <p>
 * The histogram display view of the MVC program in which presents to the
 * user histogram(s) graphical displays of credit data based on user's
 * selections. Note: The data displayed will be based on the type of data shown in
 * the content pane. Example: If the user has selected the radio button for Actors,
 * so that only actors are shown in the scrolling list in the content pane,
 * then any charts will be limited to acting credits – they will not contain directing
 * or producing. Also, if the data in the model is updated, the graphical output
 * should change to match the new model data.
 * </p>
 * @version 1.0
 */
public class HistogramDisplayView extends JFrame {
	/** Serial version ID to be used during serialization. */
	private static final long serialVersionUID = -7121677445075652962L;
	
	/**
	 * When requested by user, creates a histogram(s) graphical display
	 * representing the searched media maker(s)' credits over time by years.
	 * 
	 * @param list	List containing solely the searched media maker whose credits
	 *              are to be displayed.
	 */
	public HistogramDisplayView(ArrayList<MediaMaker> list) {
		// TODO: Determine if view should be kept because Histogram itself acts as a view
		// -- albeit needs to check if it can be live updated		
	} // end HistgramDisplayView constructor
} // end HistogramDisplayView Class
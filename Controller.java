import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Project 4
 * CS 2334, Section 10
 * April 1 2016
 * <p>
 * The MVC controller for the Mdb program.
 * </p>
 * @version 1.0
 */
public class Controller {
	/** The media model to be represented within the MVC through the controller. */
	private DatabaseModel model;
	private SelectionView selectionView;
	private MovieEntryView movieEntryView;
	private MovieEditView movieEditView;
	private SeriesEntryView seriesEntryView;
	private SeriesEditView seriesEditView;
	private EpisodeEntryView episodeEntryView;
	private EpisodeEditView episodeEditView;
	private PeopleEntryView peopleEntryView;
	// private PeopleEditView peopleEditView;
	
	/**
	 * Constructs a new MediaController.
	 * */
	public Controller() {
		// TODO
	} // end MediaController
	
	/**
	 * MediaListener provides a method to store and present media objects.
	 * If the model is null when the method is called, it returns without
	 * taking any action.
	 */
	private class MediaListener {
		// TODO
		public void actionPerformed(ActionEvent arg0) {
			// TODO
		} // end actionPerformed
	} // end MediaListener
	
	/**
	 * MovieListener provides a method to store and present movie objects.
	 * If the model is null when the method is called, it returns without
	 * taking any action.
	 */
	private class MovieListener {
		// TODO
		public void actionPerformed(ActionEvent arg0) {
			// TODO
		} // end actionPerformed
	} // end MovieListener
	
	/**
	 * MediaListener provides a method to store and present series objects.
	 * If the model is null when the method is called, it returns without
	 * taking any action.
	 */
	private class SeriesListener {
		// TODO
		public void actionPerformed(ActionEvent arg0) {
			// TODO
		} // end actionPerformed
	} // end SeriesListener
	
	
	/**
	 * EpisodeListener provides a method to store and present episode objects.
	 * If the model is null when the method is called, it returns without
	 * taking any action.
	 */
	private class EpisodeListener {
		// TODO
		public void actionPerformed(ActionEvent arg0) {
			// TODO
		} // end actionPerformed
	} // end EpisodeListener
	
	
	/**
	 * MakersListener provides a method to store and present media maker objects.
	 * If the model is null when the method is called, it returns without
	 * taking any action.
	 */
	private class MakersListener {
		// TODO
		public void actionPerformed(ActionEvent arg0) {
			// TODO
		} // end actionPerformed
	} // end MakersListener
	
	
	/**
	 * ActorListener provides a method to store and present media maker objects
	 * with only acting credits. If the model is null when the method is called,
	 * it returns without taking any action.
	 */
	private class ActorListener {
		// TODO
		public void actionPerformed(ActionEvent arg0) {
			// TODO
		} // end actionPerformed
	} // end ActorListener
	
	/**
	 * DirectorListener provides a method to store and present media maker objects
	 * with only directing credits. If the model is null when the method is called,
	 * it returns without taking any action.
	 */
	private class DirectorListener {
		// TODO
		public void actionPerformed(ActionEvent arg0) {
			// TODO
		} // end actionPerformed
	} // end DirectorListener
	
	/**
	 * ProducerListener provides a method to store and present media maker objects
	 * with only producing credits. If the model is null when the method is called,
	 * it returns without taking any action.
	 */
	private class ProducerListener {
		// TODO
		public void actionPerformed(ActionEvent arg0) {
			// TODO
		} // end actionPerformed
	} // end ProducerListener
	
	/**
	 * AddListener provides a method to create a object. The object should then
	 * be added to the media list of the model. The values for the new movie
	 * come from the fields of the inputView. If the model is null when the
	 * method is called, it returns without taking any action.
	 */
	private class AddListener implements ActionListener {
		// TODO
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO
		} // end actionPerformed
	} // end AddMovieListener
	
	/**
	 * EditListener provides a method to edit ab object. The values for the
	 * object come from the fields of the inputView. If the model is null
	 * when the method is called, it returns without taking any action.
	 */
	private class EditListener implements ActionListener {
		// TODO
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO
		} // end actionPerformed
	} // end EditMovieListener

	/**
	 * ClearListener provides a method to clear data of the selected type from the
	 * model. If the model is null when the method is called, it returns without
	 * taking any action.
	 */
	private class ClearListener implements ActionListener {
		@Override
		// TODO
		public void actionPerformed(ActionEvent e) {
			// TODO
		} // end actionPerformed
	} // end ClearListener
	
	/**
	 * ClearAllListener provides a method to clear all data from the model. If
	 * the model is null when the method is called, it returns without taking
	 * any action.
	 */
	private class ClearAllListener implements ActionListener {
		@Override
		// TODO
		public void actionPerformed(ActionEvent e) {
			// TODO
		} // end actionPerformed
	} // end ClearAllListener	
	
	/**
	 * SaveListener provides a method to save data from the model. If
	 * the model is null when the method is called, it returns without taking
	 * any action.
	 */
	private class SaveListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO
			} // end actionPerformed
		} // end SaveListener
	
	/**
	 * displayHistogramListener provides a method to construct a histogram with
	 * data from the model. If the model is null when the method is called, it
	 * returns without taking any action.
	 */
	private class DisplayHistogramListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO
			} // end actionPerformed
		} // end displayHistogramListener
	
	/**
	 * displayPieChartListener provides a method to construct a pie chart with
	 * data from the model. If the model is null when the method is called, it
	 * returns without taking any action.
	 */
	private class DisplayPieChartListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO
			} // end actionPerformed
		} // end displayPieChartListener

	/**
	 * A mutator for the variable model.
	 * 
	 * @param model	A media model to set as the model for the MVC.
	 */
	public void setModel(DatabaseModel model) {
		this.model = model;
	} // end setModel

	/**
	 * An accessor for the variable model.
	 * 
	 * @return SeriesModel A media model of the MVC.
	 */
	public DatabaseModel getModel() { // future use
		return model;
	} // end getModel
	
	public SelectionView getSelectionView() {
		// TODO
		return null;
	} // end getSelectionView
	
	public void setSelectionView(SelectionView selectionView) {
		// TODO
	} // end setSelectionView
	
	public SeriesEntryView getSeriesEntryView() {
		// TODO
		return null;
	} // end getSeriesEntryView
	
	public void setSeriesEntryView(SeriesEntryView seriesEntryView) {
		// TODO
	} // setSeriesEntryView
	
	public EpisodeEntryView getEpisodeEntryView() {
		// TODO
		return null;
	} // end getEpisodeEntryView
	
	public void setEpisodeEntryView(EpisodeEntryView episodeEntryView) {
		// TODO
	} // end setEpisodeEntryView
	
	public PeopleEntryView getPeopleEntryView() {
		// TODO
		return null;
	} // end getPeopleEntryView
	
	public void setPeopleEntryView(PeopleEntryView peopleEntryView) {
		// TODO
	} // end setPeopleEntryView
} // end MediaController

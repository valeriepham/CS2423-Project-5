/**
 * Project 4
 * CS 2334, Section 10
 * April 1 2016
 * <p>
 * This program allows data on movies, series, episodes and media makers
 * (actors, producers, directors) to be entered and modified through a MVC
 * GUI program.
 * </p>
 * @version 1.0
 */
public class Driver {
	static DatabaseModel databaseModel;
	static SelectionViewWindow selectionView;
	static MovieEntryWindow movieEntryView;
	static SeriesEntryWindow seriesEntryView;
	static EpisodeEntryWindow episodeEntryView;
	static MakerEntryWindow makerEntryView;
	static Controller controller;

	/**
	 * The driver of the program that constructs and declares the components
	 * of an MVC program in which data for media (movies, series, episodes)
	 * and media makers (actors, producers, and directors) are read in and stored.
	 * Once the data has been stored, the user is able to view and make modifications
	 * to the data through GUI windows. The program ends once the user exits from
	 * the Selection View.
	 * 
	 * @param	args	A string array in which program arguments may be passed in.
	 */
	public static void main(String[] args) {
		// TODO
		databaseModel = new DatabaseModel();
		selectionView = new SelectionViewWindow();
		movieEntryView = new MovieEntryWindow();
		seriesEntryView = new SeriesEntryWindow();
		episodeEntryView = new EpisodeEntryWindow();
		makerEntryView = new MakerEntryWindow();
		controller = new Controller();

		/* Setting all MVC components to each other */
		selectionView.setDatabaseModel(databaseModel);
		makerEntryView.setDatabaseModel(databaseModel);
		episodeEntryView.setDatabaseModel(databaseModel);
		
		controller.setDatabaseModel(databaseModel);
		controller.setSelectionContentWindow(selectionView);
		controller.setMovieEntryView(movieEntryView);
		controller.setSeriesEntryView(seriesEntryView);
		controller.setEpisodeEntryView(episodeEntryView);
		controller.setMakerEntryView(makerEntryView);

		/* Starts the program by making the selection view centered and visible. */
		selectionView.setLocationRelativeTo(null);
		selectionView.setVisible(true);
	} // end main
} // end Driver Class
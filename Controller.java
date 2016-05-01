import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 * Project 4 CS 2334 Section 10 18 April 2016
 * <P>
 * The MVC controller for the program
 * </P>
 */
public class Controller {
	/** Database model of the MVC program holding the application data. */
	private DatabaseModel databaseModel;

	/** Selection view of the MVC. */
	private SelectionViewWindow selectionView;

	/** Movie entry/edit view of the MVC. */
	private MovieEntryWindow movieEntryView;

	/** Series entry/edit view of the MVC. */
	private SeriesEntryWindow seriesEntryView;

	/** Episode entry/edit view of the MVC. */
	private EpisodeEntryWindow episodeEntryView;

	/** Maker entry/edit view of the MVC. */
	private MakerEntryWindow makerEntryView;

	/** Histogram view of the MVC. */
	private HistogramDisplayView histogramDisplayView;

	/**
	 * Creates new Controller
	 */
	Controller() {
		// Intentionally left empty
	}

	/**
	 * Registers the database model.
	 * 
	 * @param model
	 *            to set as the model
	 */
	public void setDatabaseModel(DatabaseModel model) {
		this.databaseModel = model;
	} // end setDatabaseModel

	/**
	 * Accessor for the variable databaseModel.
	 * 
	 * @return DatabaseModel The database model.
	 */
	public DatabaseModel getDatabaseModel() {
		return databaseModel;
	} // end getDatabaseModel

	/**
	 * Mutator for the variable selectionView.
	 * 
	 * @param theView
	 *            On which the listeners should be set.
	 */
	public void setSelectionContentWindow(SelectionViewWindow theView) {
		this.selectionView = theView;

		// Register listeners for all buttons
		selectionView.addRadioMediaButtonListener(new RadioMediaListener());
		selectionView.addRadioMovieButtonListener(new RadioMovieListener());
		selectionView.addRadioSeriesButtonListener(new RadioSeriesListener());
		selectionView.addRadioEpisodesButtonListener(new RadioEpisodesListener());
		selectionView.addRadioMakersButtonListener(new RadioMakersListener());
		selectionView.addRadioActorsButtonListener(new RadioActorsListener());
		selectionView.addRadioDirectorsButtonListener(new RadioDirectorsListener());
		selectionView.addRadioProducersButtonListener(new RadioProducersListener());

		selectionView.addLoadListener(new LoadListener());
		selectionView.addSaveListener(new SaveListener());
		selectionView.addImportListener(new ImportListener());
		selectionView.addExportListener(new ExportListener());

		selectionView.addAddListener(new editAddListener());
		selectionView.addEditListener(new editEditListener());
		selectionView.addDeleteListener(new editDeleteListener());
		selectionView.addClearListener(new editClearListener());
		selectionView.addClearAllListener(new editClearAllListener());

		selectionView.addPieChartListener(new displayPieChartListener());
		selectionView.addHistogramListener(new displayHistogramListener());

		System.out.println("SelectionViewWindow listeners registered in the controller.");
	} // end setSelectionContentWindow

	/**
	 * Accessor for the variable selectionView.
	 * 
	 * @param theView
	 *            On which the listeners should be set.
	 * @return A selection view window registered to the controller.
	 */
	public SelectionViewWindow getSelectionContentWindow(SelectionViewWindow theView) {
		return selectionView;
	} // end getSelectionContentWindow

	/**
	 * Accessor for the variable movieEntryVew.
	 * 
	 * @return The movie movie entry view.
	 */
	public MovieEntryWindow getMovieEntryView() {
		return movieEntryView;
	} // end getMovieEntryView

	/**
	 * Mutator for the variable movieEntryView.
	 * 
	 * @param movieEntryView
	 *            The movie entry view to set.
	 */
	public void setMovieEntryView(MovieEntryWindow movieEntryView) {
		this.movieEntryView = movieEntryView;

		// Registers listeners for all movie entry view buttons
		this.movieEntryView.addCreateEntryButtonListener(new CreateEntryListener());
		this.movieEntryView.addClearInputFieldsListener(new ClearInputFieldsListener());
		this.movieEntryView.addCancelButtonListener(new CancelListener());
		this.movieEntryView.addUpdateEntryButtonListener(new UpdateEntryListener());

		System.out.println("MovieEntryView listeners registered in the controller.");
	} // end setMovieEntryView

	/**
	 * Accessor for the variable seriesEntryView.
	 * 
	 * @return the seriesEntryView The series entry view to be set.
	 */
	public SeriesEntryWindow getSeriesEntryView() {
		return seriesEntryView;
	} // end getSeriesEntryView

	/**
	 * Mutator for the variable seriesEntryView.
	 * 
	 * @param seriesEntryView
	 *            The series entry view to set
	 */
	public void setSeriesEntryView(SeriesEntryWindow seriesEntryView) {
		this.seriesEntryView = seriesEntryView;

		// Registers listeners for all series entry view buttons
		this.seriesEntryView.addCreateEntryButtonListener(new CreateEntryListener());
		this.seriesEntryView.addClearInputFieldsListener(new ClearInputFieldsListener());
		this.seriesEntryView.addCancelButtonListener(new CancelListener());
		this.seriesEntryView.addUpdateEntryButtonListener(new UpdateEntryListener());

		System.out.println("SeriesEntryView listeners registered in the controller.");
	} // end setSeriesEntryView

	/**
	 * Accessor for the variable episodeEntryView.
	 * 
	 * @return The episode entry view.
	 */
	public EpisodeEntryWindow getEpisodeEntryView() {
		return episodeEntryView;
	} // end getEpisodeEntyView

	/**
	 * Mutator for the variable episodeEntryView,
	 * 
	 * @param episodeEntryView
	 *            The episode entry view to set.
	 */
	public void setEpisodeEntryView(EpisodeEntryWindow episodeEntryView) {
		this.episodeEntryView = episodeEntryView;

		// Registers listeners for all episode entry view buttons
		this.episodeEntryView.addCreateEntryButtonListener(new CreateEntryListener());
		this.episodeEntryView.addClearInputFieldsListener(new ClearInputFieldsListener());
		this.episodeEntryView.addCancelButtonListener(new CancelListener());
		this.episodeEntryView.addUpdateEntryButtonListener(new UpdateEntryListener());

		System.out.println("EpisodeEntryView listeners registered in the controller.");
	} // end setEpisodeEntryView

	/**
	 * Accessor for the variable makerEntryView,
	 * 
	 * @return The maker entry view.
	 */
	public MakerEntryWindow getMakerEntryView() {
		return makerEntryView;
	} // end getMakerEntryView

	/**
	 * Mutator for the variable makerEntryView.
	 * 
	 * @param makerEntryView
	 *            The makerEntryView to be set.
	 */
	public void setMakerEntryView(MakerEntryWindow makerEntryView) {
		this.makerEntryView = makerEntryView;

		// Registers listeners for all maker entry view buttons
		this.makerEntryView.addCreateEntryButtonListener(new CreateEntryListener());
		this.makerEntryView.addClearInputListener(new ClearInputFieldsListener());
		this.makerEntryView.addCancelButtonListener(new CancelListener());
		this.makerEntryView.addUpdateEntryButtonListener(new UpdateEntryListener());
		this.makerEntryView.addAddToACEntryButtonListener(new AddToCreditsListener());
		this.makerEntryView.addAddToDCButtonListener(new AddToCreditsListener());
		this.makerEntryView.addAddToPCListener(new AddToCreditsListener());
		this.makerEntryView.addAddNewMediaEntryButtonListener(new AddNewMediaListener());

		System.out.println("MakerEntryView listeners registered in the controller.");
	} // end setMakerEntryView

	/**
	 * RadioMediaListener provides a method for the user to choose the types of
	 * data they would like to be displayed within the content pane of the main
	 * program window. If the model is null when the method is called, it
	 * returns without taking any action.
	 */
	private class RadioMediaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (databaseModel == null)
				return; // No model associated. Can't do anything.

			selectionView.jmiAdd.setEnabled(false);
			selectionView.jplScrollAndLabel.remove(selectionView.jplScrollPane);

			Media[] media = databaseModel.getAllMedia().toArray(new Media[databaseModel.getAllMedia().size()]);
			String[] mediaList = new String[media.length];

			selectionView.jlDisplay = new JList<String>();
			selectionView.jlMediaEntries = new JList<Media>();
			selectionView.rightSelectionType.setText("Media");

			// Adds movies to string array for displaying in pane
			for (int i = 0; i < media.length; ++i) {
				if (media[i].getClass() == Episode.class) {
					Episode episode = (Episode) media[i];
					mediaList[i] = episode.toString(episode.getTitle());
				} else {
					mediaList[i] = media[i].toString();
				}
			}

			// Adds movies to media array for grabbing data within controller
			selectionView.jlDisplay.setListData(mediaList);
			selectionView.jlMediaEntries.setListData(media);

			selectionView.jplScrollPane = new JScrollPane(selectionView.jlDisplay);
			selectionView.jplScrollAndLabel.add(selectionView.jplScrollPane);

			selectionView.pack();
			selectionView.setLocationRelativeTo(null);
			selectionView.setVisible(true);
		}
	} // Ends RadioMediaListener

	/**
	 * RadioMovieListener provides a method for the user to choose the types of
	 * data they would like to b displayed within the content pane of the main
	 * program window. If the model is null when the method is called, it
	 * returns without taking any action.
	 */
	private class RadioMovieListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (databaseModel == null)
				return; // No model associated. Can't do anything.

			selectionView.jmiAdd.setEnabled(true); // Ungreys the add menu button
			
			// Clears old panel to display list
			selectionView.jplScrollAndLabel.remove(selectionView.jplScrollPane);

			// Sets up new JLists to display and hold movie data up to date
			selectionView.jlDisplay = new JList<String>();
			selectionView.jlMediaEntries = new JList<Media>();
			selectionView.rightSelectionType.setText("Movies");

			// Create Media array of movies from database to insert into Media
			// and String JLists
			Media[] movies = databaseModel.getMedia(1).toArray(new Media[databaseModel.getMedia(1).size()]);
			String[] movieList = new String[movies.length];

			// Adds all movies to a string array for displaying movies in
			// selection pane
			for (int i = 0; i < movies.length; ++i) {
				Movie m = (Movie) movies[i];
				movieList[i] = m.toString();
			}

			selectionView.jlDisplay.setListData(movieList);
			selectionView.jlMediaEntries.setListData(movies);

			// Updates the display by adding updated JList to scroll pane and panel
			selectionView.jplScrollPane = new JScrollPane(selectionView.jlDisplay);
			selectionView.jplScrollAndLabel.add(selectionView.jplScrollPane);

			selectionView.pack();
			selectionView.setLocationRelativeTo(null);
			selectionView.setVisible(true);
		}
	} // Ends RadioMovieListener

	/**
	 * RadioSeriesListener provides a method for the user to choose the types of
	 * data they would like to b displayed within the content pane of the main
	 * program window. If the model is null when the method is called, it
	 * returns without taking any action.
	 */
	private class RadioSeriesListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (databaseModel == null)
				return; // No model associated. Can't do anything.

			selectionView.jmiAdd.setEnabled(true); // Ungreys the add menu
													// button
			selectionView.jplScrollAndLabel.remove(selectionView.jplScrollPane);

			// Sets up new JLists to display and hold series data up to date
			selectionView.jlDisplay = new JList<String>();
			selectionView.jlMediaEntries = new JList<Media>();
			selectionView.rightSelectionType.setText("Series");

			// Creates media and string arrays to insert into JLists
			Media[] series = databaseModel.getMedia(2).toArray(new Media[databaseModel.getMedia(2).size()]);
			String[] seriesList = new String[series.length];

			// Adds all series to a string array for displaying series in
			// selection pane
			for (int i = 0; i < series.length; ++i) {
				Series s = (Series) series[i];
				seriesList[i] = s.toString();
			}

			selectionView.jlDisplay.setListData(seriesList);
			selectionView.jlMediaEntries.setListData(series);

			// Updates the display by adding updated JList to scroll pane and
			// panel
			selectionView.jplScrollPane = new JScrollPane(selectionView.jlDisplay);
			selectionView.jplScrollAndLabel.add(selectionView.jplScrollPane);

			selectionView.pack();
			selectionView.setLocationRelativeTo(null);
			selectionView.setVisible(true);
		}
	} // Ends RadioSeriesListener

	/**
	 * RadioEpisodesListener provides a method for the user to choose the types
	 * of data they would like to b displayed within the content pane of the
	 * main program window. If the model is null when the method is called, it
	 * returns without taking any action.
	 */
	private class RadioEpisodesListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (databaseModel == null)
				return; // No model associated. Can't do anything.

			selectionView.jmiAdd.setEnabled(true); // Ungreys the add menu button
			
			// Clears old panel to display list
			selectionView.jplScrollAndLabel.remove(selectionView.jplScrollPane);

			// Sets up new JLists to display and hold episode data up to date
			selectionView.jlDisplay = new JList<String>();
			selectionView.jlMediaEntries = new JList<Media>();
			selectionView.rightSelectionType.setText("Episodes");

			// Creates media and string arrays to insert into JLists
			Media[] episodes = databaseModel.getMedia(3).toArray(new Media[databaseModel.getMedia(3).size()]);
			String[] episodeList = new String[episodes.length];

			// Adds all episodes to a string array for displaying episodes in
			// selection pane
			for (int i = 0; i < episodes.length; ++i) {
				Episode episode = (Episode) episodes[i];
				episodeList[i] = episode.toString(episode.getTitle());
			}

			selectionView.jlDisplay.setListData(episodeList);
			selectionView.jlMediaEntries.setListData(episodes);

			// Updates the display by adding updated JList to scroll pane and
			// panel
			selectionView.jplScrollPane = new JScrollPane(selectionView.jlDisplay);
			selectionView.jplScrollAndLabel.add(selectionView.jplScrollPane);

			selectionView.pack();
			selectionView.setLocationRelativeTo(null);
			selectionView.setVisible(true);
		}
	} // Ends RadioEpisodesListener

	/**
	 * RadioMakersListener provides a method for the user to choose the types of
	 * data they would like to b displayed within the content pane of the main
	 * program window. If the model is null when the method is called, it
	 * returns without taking any action.
	 */
	private class RadioMakersListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (databaseModel == null)
				return; // No model associated. Can't do anything.

			selectionView.jmiAdd.setEnabled(true); // Ungreys the add menu button
			
			// TODO: I know histogram/piechart should be greyed out UNTIL media maker
			//  exists within the database AND at least one media maker has been selected
			selectionView.jmiHistogram.setEnabled(true);
			selectionView.jmiPieChart.setEnabled(true);

			// Clears old panel to display list
			selectionView.jplScrollAndLabel.remove(selectionView.jplScrollPane);

			// Sets up new JLists to display and hold episode data up to date
			selectionView.jlDisplay = new JList<String>();
			selectionView.jlMakerEntries = new JList<MediaMaker>();
			selectionView.rightSelectionType.setText("Makers");

			// Creates media and string arrays to insert into JLists
			MediaMaker[] makers = databaseModel.getAllPeople().values()
					.toArray(new MediaMaker[databaseModel.getAllPeople().values().size()]);
			String[] makerList = new String[makers.length];

			// Adds all makers to a string array for displaying makers in
			// selection pane
			for (int i = 0; i < makers.length; ++i) {
				makerList[i] = makers[i].toString();
			}

			selectionView.jlDisplay.setListData(makerList);
			selectionView.jlMakerEntries.setListData(makers);

			// Updates the display by adding updated JList to scroll pane and
			// panel
			selectionView.jplScrollPane = new JScrollPane(selectionView.jlDisplay);
			selectionView.jplScrollAndLabel.add(selectionView.jplScrollPane);

			selectionView.pack();
			selectionView.setLocationRelativeTo(null);
			selectionView.setVisible(true);
		}
	} // Ends RadioMakersListener

	/**
	 * RadioActorsListener provides a method for the user to choose the types of
	 * data they would like to b displayed within the content pane of the main
	 * program window. If the model is null when the method is called, it
	 * returns without taking any action.
	 */
	private class RadioActorsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (databaseModel == null)
				return; // No model associated. Can't do anything.

			selectionView.jmiAdd.setEnabled(true); // Ungreys the add menu button
			
			// TODO: I know histogram/piechart should be greyed out UNTIL media maker
			//  exists within the database AND at least one media maker has been selected
			selectionView.jmiHistogram.setEnabled(true);
			selectionView.jmiPieChart.setEnabled(true);

			// Clears old panel to display list
			selectionView.jplScrollAndLabel.remove(selectionView.jplScrollPane);

			// Sets up new JLists to display and hold actor data up to date
			selectionView.jlDisplay = new JList<String>();
			selectionView.jlMakerEntries = new JList<MediaMaker>();
			selectionView.rightSelectionType.setText("Actors");

			// Creates media maker and string arrays to insert into JLists
			MediaMaker[] actors = databaseModel.getPeople(1).toArray(new MediaMaker[databaseModel.getPeople(1).size()]);
			String[] actorList = new String[actors.length];

			// Adds all actors to a string array for displaying actors in
			// selection pane
			for (int i = 0; i < actors.length; ++i) {
				actorList[i] = actors[i].toString();
			}

			selectionView.jlDisplay.setListData(actorList);
			selectionView.jlMakerEntries.setListData(actors);

			// Updates the display by adding updated JList to scroll pane and
			// panel
			selectionView.jplScrollPane = new JScrollPane(selectionView.jlDisplay);
			selectionView.jplScrollAndLabel.add(selectionView.jplScrollPane);

			selectionView.pack();
			selectionView.setLocationRelativeTo(null);
			selectionView.setVisible(true);
		}
	} // Ends RadioActorsListener

	/**
	 * RadioDirectorsListener provides a method for the user to choose the types
	 * of data they would like to be displayed within the content pane of the
	 * main program window. If the model is null when the method is called, it
	 * returns without taking any action.
	 */
	private class RadioDirectorsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (databaseModel == null)
				return; // No model associated. Can't do anything.

			selectionView.jmiAdd.setEnabled(true); // Ungreys the add menu button
			// TODO: I know histogram/piechart should be greyed out UNTIL media maker
			//  exists within the database AND at least one media maker has been selected
			selectionView.jmiHistogram.setEnabled(true);
			selectionView.jmiPieChart.setEnabled(true);
			
			// Clears panel to display list
			selectionView.jplScrollAndLabel.remove(selectionView.jplScrollPane);

			// Sets up new JLists to display and hold director data up to date
			selectionView.jlDisplay = new JList<String>();
			selectionView.jlMakerEntries = new JList<MediaMaker>();
			selectionView.rightSelectionType.setText("Directors");

			// Creates media and string arrays to insert into JLists
			MediaMaker[] directors = databaseModel.getPeople(2)
					.toArray(new MediaMaker[databaseModel.getPeople(2).size()]);
			String[] directorList = new String[directors.length];

			// Adds all directors to a string array for displaying directors in
			// selection pane
			for (int i = 0; i < directors.length; ++i) {
				directorList[i] = directors[i].toString();
			}

			selectionView.jlDisplay.setListData(directorList);
			selectionView.jlMakerEntries.setListData(directors);

			// Updates the display by adding updated JList to scroll pane and
			// panel
			selectionView.jplScrollPane = new JScrollPane(selectionView.jlDisplay);
			selectionView.jplScrollAndLabel.add(selectionView.jplScrollPane);

			selectionView.pack();
			selectionView.setLocationRelativeTo(null);
			selectionView.setVisible(true);
		}
	} // Ends RadioDirectorsListener

	/**
	 * RadioProducersListener provides a method for the user to choose the types
	 * of data they would like to be displayed within the content pane of the
	 * main program window. If the model is null when the method is called, it
	 * returns without taking any action.
	 */
	private class RadioProducersListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (databaseModel == null)
				return; // No model associated. Can't do anything.

			selectionView.jmiAdd.setEnabled(true); // Ungreys the add menu button
			
			// TODO: I know histogram/piechart should be greyed out UNTIL media maker
			//  exists within the database AND at least one media maker has been selected
			selectionView.jmiHistogram.setEnabled(true);
			selectionView.jmiPieChart.setEnabled(true);
			
			// Clears old panel to display list
			selectionView.jplScrollAndLabel.remove(selectionView.jplScrollPane);

			// Sets up new JLists to display and hold producer data up to date
			selectionView.jlDisplay = new JList<String>();
			selectionView.jlMakerEntries = new JList<MediaMaker>();
			selectionView.rightSelectionType.setText("Producers");

			// Creates media and string arrays to insert into JLists
			MediaMaker[] producers = databaseModel.getPeople(3)
					.toArray(new MediaMaker[databaseModel.getPeople(3).size()]);
			String[] producerList = new String[producers.length];

			// Adds all producers to a string array for displaying producers in
			// selection pane
			for (int i = 0; i < producers.length; ++i) {
				producerList[i] = producers[i].toString();
			}

			selectionView.jlDisplay.setListData(producerList);
			selectionView.jlMakerEntries.setListData(producers);

			// Updates the display by adding updated JList to scroll pane and panel
			selectionView.jplScrollPane = new JScrollPane(selectionView.jlDisplay);
			selectionView.jplScrollAndLabel.add(selectionView.jplScrollPane);

			selectionView.pack();
			selectionView.setLocationRelativeTo(null);
			selectionView.setVisible(true);
		}
	} // Ends RadioProducersListener

	/**
	 * LoadListener provides a method for the user to load Object information
	 * from console I/O.
	 */
	private class LoadListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser jfc = new JFileChooser(); // Creates file picker

			// Sets the JFileChooser to allow the user to just select files
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			jfc.setDialogTitle("Choose File(s)"); // Sets title of file picker
			jfc.setMultiSelectionEnabled(true); // Allows multiple files to be selected

			// Checks and returns for if user clicks Cancel
			if (jfc.showOpenDialog(selectionView.jmiLoad) == JFileChooser.CANCEL_OPTION) {
				return;
			} else {
				// Retrieve the selected files
				File[] files = jfc.getSelectedFiles(); // All binary files
														// selected by user
				for (int i = 0; i < files.length; ++i) {
					try {
						databaseModel = (DatabaseModel) databaseModel.readBinaryFile(files[i].getName());
					} catch (ClassNotFoundException | IOException e1) {
						JOptionPane.showMessageDialog(null, "File could not be found.", "Load Confirmation",
								JOptionPane.INFORMATION_MESSAGE);
						return; // TODO: SHOULD WE RETURN IF FIRST FILE CANNOT
								// BE FOUND
					}
				}

				// Message to display to user when loading has been completed
				JOptionPane.showMessageDialog(null, "Loading Complete.", "Load Confirmation",
						JOptionPane.INFORMATION_MESSAGE);
			}

			// TODO Check logic of enable placement and finish
			// Enables the Save, Export, Edit, Delete, Clear, and Clear All menu
			// options
			// (which were previously disabled due to no information) and
			// changes the tool tips
			if (databaseModel.getAllMedia().size() != 0 || databaseModel.getAllPeople().isEmpty() == false) {
				selectionView.jmiSave.setEnabled(true);
				selectionView.jmiSave.setToolTipText("Save displayed database information to a binary file");
				selectionView.jmiExport.setEnabled(true);
				selectionView.jmiExport.setToolTipText("Export displayed database information to a text file");
				selectionView.jmiEdit.setEnabled(true);
				selectionView.jmiEdit.setToolTipText("Edit the selected data entry");
				selectionView.jmiDelete.setEnabled(true);
				selectionView.jmiDelete.setToolTipText("Delete the selected data entry from the database");
				selectionView.jmiClear.setEnabled(true);
				selectionView.jmiClear
						.setToolTipText("Clear all the data entries of the chosen type from the database");
				selectionView.jmiClearAll.setEnabled(true);
				selectionView.jmiClearAll
						.setToolTipText("Clear all of the data entries, regardless of type, from the database");
			}
		}
	} // Ends LoadListener

	/**
	 * SaveListener provides a method for the user to save the existing data
	 * list to a file.
	 */
	private class SaveListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (databaseModel == null) {
				return;
			} // No model associated. Can't do anything.

			// Creates file picker for user to select file to save to
			JFileChooser jfc = new JFileChooser();
			jfc.setDialogTitle("Choose File(s)"); // Sets title of file picker

			// Sets the JFileChooser to allow the user to just select files
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			jfc.setMultiSelectionEnabled(true); // Allows multiple files to be selected

			// Checks and returns for if user clicks Cancel
			if (jfc.showOpenDialog(selectionView.jmiLoad) == JFileChooser.CANCEL_OPTION) {
				return;
			}

			File[] files = jfc.getSelectedFiles(); // All binary files selected
													// by user
			for (int i = 0; i < files.length; ++i) {

				try {
					databaseModel.saveBinary(files[i].getName());

					// Message to display to user when loading for a single file
					// has been completed
					JOptionPane.showMessageDialog(null, "Loading : " + files[i].getName() + " complete.",
							"Load Confirmation", JOptionPane.INFORMATION_MESSAGE);
				}

				// Throw exception for if file cannot be found
				catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error: IOException for " + files[i].getName() + ".",
							"Import Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	} // Ends SaveListener

	/**
	 * ImportListener provides a method for the user to import existing database
	 * information from an existing file.
	 */
	private class ImportListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser jfc = new JFileChooser(); // Creates file picker

			// Sets the JFileChooser to allow the user to just select files
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			jfc.setMultiSelectionEnabled(true); // Allows multiple files to be
												// selected

			// Checks and returns if user clicked Cancel
			if (jfc.showOpenDialog(selectionView.jmiImport) == JFileChooser.CANCEL_OPTION) {
				return;
			}

			// Retrieve the selected files
			File[] files = jfc.getSelectedFiles(); // All text files selected by
													// user

			for (int i = 0; i < files.length; ++i) {

				// Ask user, What data does nth file contain? 1. movie, 2.
				// series/episode, 3. actor, 4. director, or 5. producer
				String question = "What type of data does " + files[i].getName() + " contain?"
						+ " \nEnter 1 for Movies, 2 for Series/Episodes, 3 for Actors, 4 for Directors"
						+ " or 5 for Producers";

				// User's type of data file
				String response = JOptionPane.showInputDialog(null, question);

				// If user presses cancel, closes dialog box
				if (response == null) {
					return;
				}

				// If user answers input prompt, check to make sure it's an
				// acceptable data type
				else {
					while (!response.equals("1") && !response.equals("2") && !response.equals("3")
							&& !response.equals("4") && !response.equals("5")) {

						response = JOptionPane.showInputDialog(null,
								"Inapplicable input. Please enter again! " + question);

						// If user presses cancel, closes dialog box and returns
						// to selection view
						if (response == null) {
							return;
						}
					}

					// If user inputs acceptable file, reads and inserts data
					// into the database model
					try {
						databaseModel.readTextFile(files[i].getName(), Integer.parseInt(response));

						// Message to display to user if data was loaded when
						// loading has been completed
						if (databaseModel.getAllMedia().size() != 0
								|| databaseModel.getAllPeople().isEmpty() == false) {

							JOptionPane.showMessageDialog(null, "Importing " + files[i].getName() + " complete.",
									"Import Confirmation", JOptionPane.INFORMATION_MESSAGE);
						}
					}

					// Exception for when file cannot be found
					catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error: IOException for " + files[i].getName() + ".",
								"Import Error", JOptionPane.ERROR_MESSAGE);
					}

					// Exception for when file cannot be found
					catch (NumberFormatException efe) {
						JOptionPane.showMessageDialog(null,
								"Error: Number Format Exception for " + files[i].getName() + ".", "Import Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}

			// TODO Check logic of enable placement and finish
			// Enables the Save, Export, Edit, Delete, Clear, and Clear All menu
			// options
			// (which were previously disabled due to no information) and
			// changes the tool tips
			if (databaseModel.getAllMedia().size() != 0 || databaseModel.getAllPeople().isEmpty() == false) {
				selectionView.jmiSave.setEnabled(true);
				selectionView.jmiSave.setToolTipText("Save displayed database information to a binary file");
				selectionView.jmiExport.setEnabled(true);
				selectionView.jmiExport.setToolTipText("Export displayed database information to a text file");
				selectionView.jmiEdit.setEnabled(true);
				selectionView.jmiEdit.setToolTipText("Edit the selected data entry");
				selectionView.jmiDelete.setEnabled(true);
				selectionView.jmiDelete.setToolTipText("Delete the selected data entry from the database");
				selectionView.jmiClear.setEnabled(true);
				selectionView.jmiClear
						.setToolTipText("Clear all the data entries of the chosen type from the database");
				selectionView.jmiClearAll.setEnabled(true);
				selectionView.jmiClearAll
						.setToolTipText("Clear all of the data entries, regardless of type, from the database");
			}

			// If user is on the media radio button, updates the media pane
			if (selectionView.jbtRadioMedia.isSelected()) {
				selectionView.jbtRadioMedia.doClick();
			}
			// If user is on the movies radio button, updates the movie pane
			else if (selectionView.jbtRadioMovies.isSelected()) {
				selectionView.jbtRadioMovies.doClick();
			}
			// If user is on the series radio button, updates the series pane
			else if (selectionView.jbtRadioSeries.isSelected()) {
				selectionView.jbtRadioSeries.doClick();
			}
			// If user is on the episodes radio button, updates the episode pane
			else if (selectionView.jbtRadioEpisodes.isSelected()) {
				selectionView.jbtRadioEpisodes.doClick();
			}
			// If user is on the makers radio button, updates the makers pane
			else if (selectionView.jbtRadioMakers.isSelected()) {
				selectionView.jbtRadioMakers.doClick();
			}
			// If user is on the actors radio button, updates the actors pane
			else if (selectionView.jbtRadioActors.isSelected()) {
				selectionView.jbtRadioActors.doClick();
			}
			// If user is on the directors radio button, updates the directors
			// pane
			else if (selectionView.jbtRadioDirectors.isSelected()) {
				selectionView.jbtRadioDirectors.doClick();
			}
			// If user is on the producers radio button, updates the producers
			// pane
			else if (selectionView.jbtRadioProducers.isSelected()) {
				selectionView.jbtRadioProducers.doClick();
			}
		}
	} // Ends ImportListener

	/**
	 * ExportListener provides a method for the user to export a particular data
	 * type to a file.
	 */
	private class ExportListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO write method
			if (databaseModel == null)
				return; // No model associated. Can't do anything.

			// First present user wil file picker to choose file to write and
			// save to
			JFileChooser jfc = new JFileChooser(); // Creates file picker
			jfc.setDialogTitle("Choose File(s)"); // Sets title of file picker

			// Sets the JFileChooser to allow the user to just select files
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			jfc.setMultiSelectionEnabled(true); // Allows multiple files to be
												// selected

			// Checks and returns if user clicked Cancel
			if (jfc.showOpenDialog(selectionView.jmiExport) == JFileChooser.CANCEL_OPTION) {
				return;
			}

			File[] files = jfc.getSelectedFiles(); // All text files selected by
													// user
			for (int i = 0; i < files.length; ++i) {

				// Ask user, What type of file does each contain?
				String question = "What type of data will " + files[i].getName() + " contain?"
						+ " \nEnter 1 for Movies, 2 for Series/Episodes, 3 for Actors, 4 for Directors"
						+ " or 5 for Producers";

				// User's type of data file
				String response = JOptionPane.showInputDialog(null, question);

				// If user presses cancel, closes dialog box
				if (response == null) {
					return;
				}

				// If user answers input prompt, check to make sure it's an
				// acceptable data type
				else {
					while (!response.equals("1") && !response.equals("2") && !response.equals("3")
							&& !response.equals("4") && !response.equals("5")) {

						response = JOptionPane.showInputDialog(null,
								"Inapplicable input. Please enter again! " + question);

						// If user presses cancel, closes dialog box and returns
						// to selection view
						if (response == null) {
							return;
						}
					}
				}

				// Match response to designated data type that will be saved
				if (Integer.parseInt(response) == 1) { // Movie text file
					try {
						databaseModel.saveText(files[i].getName(), databaseModel.getMedia(1));
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error: IOException for " + files[i].getName() + ".",
								"Import Error", JOptionPane.ERROR_MESSAGE);
					}
				} else if (Integer.parseInt(response) == 2) { // Series text
																// file
					try {
						databaseModel.saveText(files[i].getName(), databaseModel.getMedia(2));
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error: IOException for " + files[i].getName() + ".",
								"Import Error", JOptionPane.ERROR_MESSAGE);
					}
				} else if (Integer.parseInt(response) == 3) { // Actors text
																// file
					try {
						databaseModel.saveText(files[i].getName(), databaseModel.getPeople(1));
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error: IOException for " + files[i].getName() + ".",
								"Import Error", JOptionPane.ERROR_MESSAGE);
					}
				} else if (Integer.parseInt(response) == 4) { // Directors text
																// file
					try {
						databaseModel.saveText(files[i].getName(), databaseModel.getPeople(2));
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error: IOException for " + files[i].getName() + ".",
								"Import Error", JOptionPane.ERROR_MESSAGE);
					}
				} else if (Integer.parseInt(response) == 5) { // Producers text
																// file
					try {
						databaseModel.saveText(files[i].getName(), databaseModel.getPeople(3));
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Error: IOException for " + files[i].getName() + ".",
								"Import Error", JOptionPane.ERROR_MESSAGE);
					}
				}

				// Message to display to user when loading has been completed
				JOptionPane.showMessageDialog(null, "Exporting " + files[i].getName() + " complete.",
						"Export Confirmation", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	} // Ends ExportListener

	/**
	 * editAddListener provides a method for the user to add a new data entry of
	 * the type previously determined by the radio buttons in the
	 * SelectionViewWindow.
	 */
	private class editAddListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// User selects to add a movie
			if (selectionView.jbtRadioMovies.isSelected()) {
				MovieEntryWindow addMev = new MovieEntryWindow();
				setMovieEntryView(addMev);
				movieEntryView.setLocationRelativeTo(null);
				movieEntryView.setVisible(true);
			}
			// User selects to add a series
			else if (selectionView.jbtRadioSeries.isSelected()) {
				SeriesEntryWindow addSer = new SeriesEntryWindow();
				setSeriesEntryView(addSer);
				seriesEntryView.setLocationRelativeTo(null);
				seriesEntryView.setVisible(true);
			}
			// User selects to add an episode
			else if (selectionView.jbtRadioEpisodes.isSelected()) {
				EpisodeEntryWindow addEp = new EpisodeEntryWindow();
				setEpisodeEntryView(addEp);
				episodeEntryView.setSeriesDropDown(databaseModel.getMedia(2));
				episodeEntryView.update();
				episodeEntryView.setLocationRelativeTo(null);
				episodeEntryView.setVisible(true);
			}
			// User selects to add any type of media maker
			else if (selectionView.jbtRadioMakers.isSelected() || selectionView.jbtRadioActors.isSelected()
					|| selectionView.jbtRadioDirectors.isSelected() || selectionView.jbtRadioProducers.isSelected()) {
				MakerEntryWindow addMM = new MakerEntryWindow();
				setMakerEntryView(addMM);
				makerEntryView.setDatabaseModel(databaseModel);				
				makerEntryView.updateView();
				makerEntryView.setLocationRelativeTo(null);
				makerEntryView.setVisible(true);
			}
		}
	} // Ends editAddListener

	/**
	 * editEditListener provides a method for the user to edit an existing
	 * data entry. An edit pane will display the current information
	 * belonging to that particular entry, which the user will be able to
	 * change.
	 */
	private class editEditListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Inserts user's selections in STRING edit lists to pull up appropriate edit views 
			int [] selection = selectionView.jlDisplay.getSelectedIndices();
			List<Media> editMediaList = null;
			List<MediaMaker> editMakerList = null;

			if (selectionView.jbtRadioMedia.isSelected() || selectionView.jbtRadioMovies.isSelected() || 
					selectionView.jbtRadioSeries.isSelected() || selectionView.jbtRadioEpisodes.isSelected()){
				selectionView.jlMediaEntries.setSelectedIndices(selection);	
				editMediaList = selectionView.jlMediaEntries.getSelectedValuesList();
			}

			if (selectionView.jbtRadioMakers.isSelected() || selectionView.jbtRadioActors.isSelected() ||
					selectionView.jbtRadioDirectors.isSelected() || selectionView.jbtRadioProducers.isSelected()) {
				selectionView.jlMakerEntries.setSelectedIndices(selection);
				selectionView.jlMakerEntries.setSelectedIndices(selection);
				editMakerList = selectionView.jlMakerEntries.getSelectedValuesList();
			}

			if (editMediaList != null) {
				for (int i = 0; i < editMediaList.size(); ++i) {
					// If selected object from list is a movie, pulls up movie edit view
					if (editMediaList.get(i).getClass() == Movie.class) {
						Movie movie = (Movie) editMediaList.get(i);
						MovieEntryWindow mev = new MovieEntryWindow(movie);
						setMovieEntryView(mev);
						mev.setLocationRelativeTo(null);
						mev.setVisible(true);
					}
					// If selected object from list is a series, pulls up series edit view
					else if (editMediaList.get(i).getClass() == Series.class) {
						Series series = (Series) editMediaList.get(i);
						SeriesEntryWindow sev = new SeriesEntryWindow(series);
						setSeriesEntryView(sev);
						sev.setLocationRelativeTo(null);
						sev.setVisible(true);
					}
					// If selected object from list is an episode, pulls up episode edit view
					else if (editMediaList.get(i).getClass() == Episode.class) {
						Episode episode = (Episode) editMediaList.get(i);
						EpisodeEntryWindow eev = new EpisodeEntryWindow(episode);
						setEpisodeEntryView(eev);
						eev.setLocationRelativeTo(null);
						eev.setVisible(true);
					}
				}
			}

			if (editMakerList != null) {
				// Displays a pre-populated entry view for every media maker user wants to edit
				for (int i = 0; i < editMakerList.size(); ++i) {
					MediaMaker mm = (MediaMaker) editMakerList.get(i);
					MakerEntryWindow mew = new MakerEntryWindow(mm);
					setMakerEntryView(mew);
					mew.setLocationRelativeTo(null);
					mew.setVisible(true);
				}
			}
		}
	} // Ends editEditListener

	/**
	 * editDeleteListener provides a method for the user to delete the selected
	 * data entry from the database.
	 */
	private class editDeleteListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			// Ask user to confirm if they want to delete their selection(s)
			JFrame frame = new JFrame();
			String[] options = { "Cancel", "Delete" };
			int response = JOptionPane.showOptionDialog(frame, "Are you sure you want to delete your selections?",
					"Delete Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
					options[0]);

			if (response == 0) {
				// option 0 is cancel so do nothing
			} else if (response == 1) { // Deletes selections
				// If user is on the media radio button, updates the media pane

				// If user selects to delete objects of any of the media types
				if (selectionView.jbtRadioMovies.isSelected() || selectionView.jbtRadioSeries.isSelected()
						|| selectionView.jbtRadioEpisodes.isSelected()) {

					int[] selection = selectionView.jlDisplay.getSelectedIndices();
					ArrayList<Media> editList = new ArrayList<Media>();
					for (int i = 0; i < selection.length; i++) {
						editList.add(databaseModel.getAllMedia().get(selection[i]));
					}

					for (int i = 0; i < editList.size(); i++) {
						// If user is on the media radio button, updates the
						// media pane
						databaseModel.deleteMedia(editList.get(i));
					}

					// If user is on the media radio button, updates the media
					// pane
					if (selectionView.jbtRadioMedia.isSelected()) {
						selectionView.jbtRadioMedia.doClick();
					}
					// If user is on the movies radio button, updates the movie
					// pane
					else if (selectionView.jbtRadioMovies.isSelected()) {
						selectionView.jbtRadioMovies.doClick();
					}
					// If user is on the series radio button, updates the series
					// pane
					else if (selectionView.jbtRadioSeries.isSelected()) {
						selectionView.jbtRadioSeries.doClick();
					}
					// If user is on the episodes radio button, updates the
					// episode pane
					else if (selectionView.jbtRadioEpisodes.isSelected()) {
						selectionView.jbtRadioEpisodes.doClick();
					}
				}

				// If user selects to delete any of the type of media maker(s)
				else if (selectionView.jbtRadioMakers.isSelected() || selectionView.jbtRadioActors.isSelected()
						|| selectionView.jbtRadioDirectors.isSelected()
						|| selectionView.jbtRadioProducers.isSelected()) {

					int[] selection = selectionView.jlDisplay.getSelectedIndices();
					ArrayList<MediaMaker> editList = new ArrayList<MediaMaker>();

					for (int i = 0; i < selection.length; i++) {
						ArrayList<MediaMaker> peopleList = new ArrayList<MediaMaker>(
								databaseModel.getAllPeople().values());
						editList.add(peopleList.get(selection[i]));
					}

					for (int i = 0; i < editList.size(); i++) {
						databaseModel.deleteMediaMaker(editList.get(i));
					}

					// If user is on the makers radio button, updates the makers
					// pane
					if (selectionView.jbtRadioMakers.isSelected()) {
						selectionView.jbtRadioMakers.doClick();
					}
					// If user is on the actors radio button, updates the actors
					// pane
					else if (selectionView.jbtRadioActors.isSelected()) {
						selectionView.jbtRadioActors.doClick();
					}
					// If user is on the directors radio button, updates the
					// directors pane
					else if (selectionView.jbtRadioDirectors.isSelected()) {
						selectionView.jbtRadioDirectors.doClick();
					}
					// If user is on the producers radio button, updates the
					// producers pane
					else if (selectionView.jbtRadioProducers.isSelected()) {
						selectionView.jbtRadioProducers.doClick();
					}

				}
			}
		}
	} // Ends editDeleteListener

	/**
	 * editClearListener provides a method for the user to delete all data
	 * entries of the type selected by the radio buttons in the
	 * SelectionViewWindow.
	 */
	private class editClearListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame frame = new JFrame();
			String[] options = { "Cancel", "Clear" };
			int response = JOptionPane.showOptionDialog(frame,
					"Are you sure you want to clear all data in main scrolling list?", "Clear Confirmation",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
			if (response == 0) {
				// option 0 is cancel so do nothing
			} else if (response == 1) {
				// User selects to clear all media
				if (selectionView.jbtRadioMedia.isSelected()) {
					databaseModel.clearMedia(4);
					selectionView.jbtRadioMedia.doClick();
				}
				// User selects to clear all movies
				else if (selectionView.jbtRadioMovies.isSelected()) {
					databaseModel.clearMedia(1);
					selectionView.jbtRadioMovies.doClick();
				}
				// User selects to clear all series
				else if (selectionView.jbtRadioSeries.isSelected()) {
					databaseModel.clearMedia(2);
					selectionView.jbtRadioSeries.doClick();
				}
				// User selects to clear all episodes
				else if (selectionView.jbtRadioEpisodes.isSelected()) {
					databaseModel.clearMedia(3);
					selectionView.jbtRadioEpisodes.doClick();
				}
				// User selects to clear all media makers
				else if (selectionView.jbtRadioMakers.isSelected()) {
					databaseModel.clearPeople(4);
					selectionView.jbtRadioMakers.doClick();
				}
				// User selects to clear all actors
				else if (selectionView.jbtRadioActors.isSelected()) {
					databaseModel.clearPeople(1);
					selectionView.jbtRadioActors.doClick();
				}
				// User selects to clear all directors
				else if (selectionView.jbtRadioDirectors.isSelected()) {
					databaseModel.clearPeople(2);
					selectionView.jbtRadioDirectors.doClick();
				}
				// User selects to clear all producers
				else if (selectionView.jbtRadioProducers.isSelected()) {
					databaseModel.clearPeople(3);
					selectionView.jbtRadioProducers.doClick();
				}
			} else {
				// Should handle error case here (we won't for this lab).
				// TODO
			}
		}
	} // Ends editClearListener

	/**
	 * editClearAllListener provides a method for the user to delete all of the
	 * data entries within the database.
	 */
	private class editClearAllListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFrame frame = new JFrame();
			String[] options = { "Cancel", "Clear All" };
			int response = JOptionPane.showOptionDialog(frame, "Are you sure you want to clear all data?",
					"Clear All Confirmation", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
					options, options[0]);
			if (response == 0) {
				// option 0 is cancel so do nothing
			} else if (response == 1) {
				databaseModel.clearAll(); // Clears all data in the database

				// If user clears all and is on the media radio button
				if (selectionView.jbtRadioMedia.isSelected()) {
					selectionView.jbtRadioMedia.doClick();
				}
				// If user clears all and is on the movies radio button
				else if (selectionView.jbtRadioMovies.isSelected()) {
					selectionView.jbtRadioMovies.doClick();
				}
				// User selects to clear all series
				else if (selectionView.jbtRadioSeries.isSelected()) {
					selectionView.jbtRadioSeries.doClick();
				}
				// User selects to clear all episodes
				else if (selectionView.jbtRadioEpisodes.isSelected()) {
					selectionView.jbtRadioEpisodes.doClick();
				}
				// User selects to clear all media makers
				else if (selectionView.jbtRadioMakers.isSelected()) {
					selectionView.jbtRadioMakers.doClick();
				}
				// User selects to clear all actors
				else if (selectionView.jbtRadioActors.isSelected()) {
					selectionView.jbtRadioActors.doClick();
				}
				// User selects to clear all directors
				else if (selectionView.jbtRadioDirectors.isSelected()) {
					selectionView.jbtRadioDirectors.doClick();
				}
				// User selects to clear all producers
				else if (selectionView.jbtRadioProducers.isSelected()) {
					selectionView.jbtRadioProducers.doClick();
				}
			} else {
				// Should handle error case here (we won't for this lab).
				// TODO
			}
		}
	} // Ends editClearAllListener

	/**
	 * displayPieChartListener provides a method for the user to display the
	 * information of the selected Maker/Actor/Director/Producer entry as a pie
	 * chart, which will be displayed in its own window.
	 */
	private class displayPieChartListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (databaseModel == null)
				return; // No model associated. Can't do anything.
			/*
			 * TODO: If the user has selected the radio button for Actors, so
			 * that only actors are shown in the scrolling list in the content
			 * pane, and selects Histogram, then any histograms created in
			 * response to this request will be limited to acting credits – they
			 * will not contain directing or producing credits.
			 */
			int[] selectedMakers = selectionView.jlDisplay.getSelectedIndices();

			if (selectionView.jbtRadioMakers.isSelected()) {
				ArrayList<MediaMaker> makers = new ArrayList<MediaMaker>(databaseModel.getAllPeople().values());

				for (int i = 0; i < selectedMakers.length; ++i) {
					Piechart piechart = new Piechart();
					piechart.setMaker(makers.get(i));
					piechart.launch();
				}
			}

			if (selectionView.jbtRadioActors.isSelected()) {
				ArrayList<MediaMaker> makers = new ArrayList<MediaMaker>(databaseModel.getPeople(1));

				for (int i = 0; i < selectedMakers.length; ++i) {
					Piechart piechart = new Piechart();
					piechart.setMaker(makers.get(i));
					piechart.launch();
				}
			}

			if (selectionView.jbtRadioDirectors.isSelected()) {
				ArrayList<MediaMaker> makers = new ArrayList<MediaMaker>(databaseModel.getPeople(2));

				for (int i = 0; i < selectedMakers.length; ++i) {
					Piechart piechart = new Piechart();
					piechart.setMaker(makers.get(i));
					piechart.launch();
				}
			}

			if (selectionView.jbtRadioProducers.isSelected()) {
				ArrayList<MediaMaker> makers = new ArrayList<MediaMaker>(databaseModel.getPeople(3));

				for (int i = 0; i < selectedMakers.length; ++i) {
					Piechart piechart = new Piechart();
					piechart.setMaker(makers.get(i));
					piechart.launch();
				}
			}	
		}
	} // Ends displayPieChartListener

	/**
	 * displayHistogramListener provides a method for the user to display the
	 * information of the selected Maker/Actor/Director/Producer entry as a
	 * histogram, which will be displayed in its own window.
	 */
	private class displayHistogramListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (databaseModel == null)
				return; // No model associated. Can't do anything.

			/*
			 * TODO: If the user has selected the radio button for Actors, so
			 * that only actors are shown in the scrolling list in the content
			 * pane, and selects Histogram, then any histograms created in
			 * response to this request will be limited to acting credits – they
			 * will not contain directing or producing credits.
			 */
			int[] selectedMakers = selectionView.jlDisplay.getSelectedIndices();

			if (selectionView.jbtRadioMakers.isSelected()) {
				ArrayList<MediaMaker> makers = new ArrayList<MediaMaker>(databaseModel.getAllPeople().values());

				for (int i = 0; i < selectedMakers.length; ++i) {
					Histogram histogram = new Histogram();
					histogram.setMaker(makers.get(i));
					histogram.launch();
				}
			}

			if (selectionView.jbtRadioActors.isSelected()) {
				ArrayList<MediaMaker> makers = new ArrayList<MediaMaker>(databaseModel.getPeople(1));

				for (int i = 0; i < selectedMakers.length; ++i) {
					Histogram histogram = new Histogram();
					histogram.setMaker(makers.get(i));
					histogram.launch();
				}
			}

			if (selectionView.jbtRadioDirectors.isSelected()) {
				ArrayList<MediaMaker> makers = new ArrayList<MediaMaker>(databaseModel.getPeople(2));

				for (int i = 0; i < selectedMakers.length; ++i) {
					Histogram histogram = new Histogram();
					histogram.setMaker(makers.get(i));
					histogram.launch();
				}
			}

			if (selectionView.jbtRadioProducers.isSelected()) {
				ArrayList<MediaMaker> makers = new ArrayList<MediaMaker>(databaseModel.getPeople(3));

				for (int i = 0; i < selectedMakers.length; ++i) {
					Histogram histogram = new Histogram();
					histogram.setMaker(makers.get(i));
					histogram.launch();
				}
			}
		}
	} // Ends displayHistogramListener

	/**
	 * MakeNewEntryListener provides a method for the user to concurrently
	 * create new media entries during the production of a new Maker entry,
	 * which will then be added to the appropriate credits list within that new
	 * Maker entry.
	 */
	private class MakeNewEntryListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == movieEntryView.jbtCreateEntry) {
				movieEntryView.jbtCreateEntry.doClick();
			} else if (e.getSource() == seriesEntryView.jbtCreateEntry) {
				seriesEntryView.jbtCreateEntry.doClick();
			} else if (e.getSource() == episodeEntryView.jbtCreateEntry) {
				episodeEntryView.jbtCreateEntry.doClick();
			} else if (e.getSource() == makerEntryView.jbtCreateEntry) {
				makerEntryView.jbtCreateEntry.doClick();
			}
		}
	} // Ends MakeNewEntryListener

	/**
	 * UpdateEntryListener provides a method for the user to update the data
	 * contents of the selected entry.
	 */
	private class UpdateEntryListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			// If user clicked Update Entry for movies
			if (e.getSource() == movieEntryView.jbtUpdate) {

				// Creates new movie based on updated values and replaces it in db
				String title = movieEntryView.jtfTitle.getText();
				String year = movieEntryView.jtfYear.getText();
				String disambigNum = movieEntryView.jtfNumeral.getText();
				String venue = movieEntryView.jtfVenue.getText();
				Movie movie = new Movie(title, year, disambigNum, venue);

				int selection1 = selectionView.jlDisplay.getSelectedIndex();
				Media toBeDeleted = databaseModel.getMedia(1).get(selection1);
				databaseModel.replaceMedia(movie, toBeDeleted);
				selectionView.jbtRadioMovies.doClick();
				movieEntryView.dispose();
			}

			// If user clicked Update Entry for series
			else if (e.getSource() == seriesEntryView.jbtUpdate) {
				String title = seriesEntryView.jtfTitle.getText();
				String year = seriesEntryView.jtfYear.getText();
				String runningYears = seriesEntryView.jtfRunYears.getText();
				Series series = new Series(title, year, runningYears);

				int selection1 = selectionView.jlDisplay.getSelectedIndex();
				Media toBeDeleted = databaseModel.getMedia(2).get(selection1);
				databaseModel.replaceMedia(series, toBeDeleted);
				selectionView.jbtRadioSeries.doClick();
				seriesEntryView.dispose();
			}

			// If user clicked Update Entry for episodes
			else if (e.getSource() == episodeEntryView.jbtUpdate) {
				String title = episodeEntryView.jtfTitle.getText();
				String seasonNum = episodeEntryView.jtfSeasonNumber.getText();
				String episodeNum = episodeEntryView.jtfEpisodeNumber.getText();
				String year = episodeEntryView.jtfYear.getText();
				Episode episode = new Episode(title, seasonNum, episodeNum, year);

				int selection1 = selectionView.jlDisplay.getSelectedIndex();
				Media toBeDeleted = databaseModel.getMedia(3).get(selection1);
				databaseModel.replaceMedia(episode, toBeDeleted);
				selectionView.jbtRadioEpisodes.doClick();
				episodeEntryView.dispose();
			}

			// If user clicked Update Entry for makers
			else if (e.getSource() == makerEntryView.jbtUpdate) {
				String firstName = makerEntryView.jtfFirstName.getText();
				String lastName = makerEntryView.jtfLastName.getText();
				String disambigNum = makerEntryView.jtfDisambigNumber.getText();
				MediaMaker maker = new MediaMaker(firstName, lastName, disambigNum, makerEntryView.tempAC,
						makerEntryView.tempDC, makerEntryView.tempPC);

				String selection1 = selectionView.jlDisplay.getSelectedValue();
				MediaMaker toBeDeleted = databaseModel.getPerson(selection1);
				databaseModel.replacePerson(maker, toBeDeleted);
				selectionView.jbtRadioMakers.doClick();
				makerEntryView.dispose();
			}
		}
	} // Ends UpdateEntryListener

	/**
	 * CreateEntryListener provides a method for the user to create a new entry
	 * of the selected type and add it to the appropriate model and database.
	 */
	private class CreateEntryListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			// If user clicked Create Entry for movies
			if (e.getSource() == movieEntryView.jbtCreateEntry) {
				String title = movieEntryView.jtfTitle.getText();
				String year = movieEntryView.jtfYear.getText();
				String disambigNum = movieEntryView.jtfNumeral.getText();
				String venue = movieEntryView.jtfVenue.getText();

				Movie movie = new Movie(title, year, disambigNum, venue);

				// Movie is already in collection so ask what to do
				if (databaseModel.getAllMedia().contains(title)) {
					int indexblah = 0;
					for (Media m : databaseModel.getAllMedia()) {
						if (m.getTitle().equals(title)) {
							indexblah = databaseModel.getAllMedia().indexOf(m);
						}
					}

					JFrame frame = new JFrame();
					String[] options = { "Cancel", "Replace Movie" };
					int response = JOptionPane.showOptionDialog(frame, "A movie titled " + title + " already exists",
							"Would you like to replace the existing movie data?", JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

					if (response == 0) {
						// option 0 is cancel so do nothing
					} else if (response == 1) { // Replaces movie
						databaseModel.replaceMedia(movie, databaseModel.getAllMedia().get(indexblah));
					} else {
						// Should handle error case here (we won't for this
						// lab).
						// TODO
					}
				}

				else { // Movie not in collection, so add
					databaseModel.addMedia(movie);
					selectionView.jbtRadioMovies.doClick();
					movieEntryView.dispose();
				}
			}

			// If user clicked Create Entry for series
			else if (e.getSource() == seriesEntryView.jbtCreateEntry) {
				String title = seriesEntryView.jtfTitle.getText();
				String year = seriesEntryView.jtfYear.getText();
				String runningYears = seriesEntryView.jtfRunYears.getText();
				Series series = new Series(title, year, runningYears);

				// Series is already in collection so ask what to do
				if (databaseModel.getAllMedia().contains(title)) {

					int indexblah2 = 0;
					for (Media s1 : databaseModel.getAllMedia()) {
						if (s1.getTitle().equals(title)) {
							indexblah2 = databaseModel.getAllMedia().indexOf(s1);
						}
					}

					JFrame frame = new JFrame();
					String[] options = { "Cancel", "Replace Series" };
					int response = JOptionPane.showOptionDialog(frame, "A series titled " + title + " already exists",
							"Would you like to replace the existing series data?", JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

					if (response == 0) {
						// option 0 is cancel so do nothing
					} else if (response == 1) { // Replaces movie
						databaseModel.replaceMedia(series, databaseModel.getAllMedia().get(indexblah2));
					} else {
						// Should handle error case here (we won't for this
						// lab).
						// TODO
					}
				} else { // Maker not in collection, so add
					databaseModel.addMedia(series);
					selectionView.jbtRadioSeries.doClick();
					seriesEntryView.dispose();
				}
			}

			// If user clicked Create Entry for episodes
			else if (e.getSource() == episodeEntryView.jbtCreateEntry) {
				String title = episodeEntryView.jtfTitle.getText();
				String seasonNum = episodeEntryView.jtfSeasonNumber.getText();
				String episodeNum = episodeEntryView.jtfEpisodeNumber.getText();
				String year = episodeEntryView.jtfYear.getText();
				Episode episode = new Episode(title, seasonNum, episodeNum, year);

				// Series is already in collection so ask what to do
				if (databaseModel.getAllMedia().contains(title)) {
					int indexblah3 = 0;
					for (Media e1 : databaseModel.getAllMedia()) {
						if (e1.getTitle().equals(title)) {
							indexblah3 = databaseModel.getAllMedia().indexOf(e1);
						}
					}

					JFrame frame = new JFrame();
					String[] options = { "Cancel", "Replace Episode" };
					int response = JOptionPane.showOptionDialog(frame, "An episode named " + title + " already exists",
							"Would you like to replace the existing episode data?", JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

					if (response == 0) {
						// option 0 is cancel so do nothing
					} else if (response == 1) { // Replaces episode
						databaseModel.replaceMedia(episode, databaseModel.getAllMedia().get(indexblah3));
					} else {
						// Should handle error case here (we won't for this
						// lab).
						// TODO
					}
				} else { // Episode not in collection, so add
					databaseModel.addMedia(episode);
					selectionView.jbtRadioEpisodes.doClick();
					episodeEntryView.dispose();
				}
			}

			// If user clicked Create Entry for makers
			else if (e.getSource() == makerEntryView.jbtCreateEntry) {
				String firstName = makerEntryView.jtfFirstName.getText();
				String lastName = makerEntryView.jtfLastName.getText();
				String disambigNum = makerEntryView.jtfDisambigNumber.getText();

				MediaMaker maker = new MediaMaker(firstName, lastName, disambigNum, makerEntryView.tempAC,
						makerEntryView.tempDC, makerEntryView.tempPC);

				String selection1 = selectionView.jlDisplay.getSelectedValue();
				MediaMaker toBeDeleted = databaseModel.getPerson(selection1);
				databaseModel.replacePerson(maker, toBeDeleted);
				selectionView.jbtRadioMakers.doClick();
				makerEntryView.dispose();

				// Maker is already in collection so ask what to do
				if (databaseModel.getAllPeople().containsKey(firstName + " " + lastName)) {

					JFrame frame = new JFrame();
					String[] options = { "Cancel", "Replace Maker" };
					int response = JOptionPane.showOptionDialog(frame,
							"A maker named " + firstName + " " + lastName + " already exists",
							"Would you like to replace the existing maker data?", JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

					if (response == 0) {
						// option 0 is cancel so do nothing
					} else if (response == 1) { // Replaces maker
						databaseModel.getAllPeople().remove(firstName + " " + lastName);
						databaseModel.addPerson(maker);
					} else {
						// Should handle error case here (we won't for this
						// lab).
						// TODO
					}
				} else { // Maker not in collection, so add
					databaseModel.addPerson(maker);
					selectionView.jbtRadioMakers.doClick();
					makerEntryView.dispose();
				}
			}
		}
	} // Ends CreateEntryListener

	/**
	 * ClearInputFieldsListener provides a method for the user to clear all
	 * input fields during the creation of a new entry of the selected type.
	 */
	private class ClearInputFieldsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (databaseModel == null)
				return;

			// If user clicked Clear Input Fields for movies
			if (e.getSource() == movieEntryView.jbtClearInput) {
				movieEntryView.clearInputFields();
			}

			// If user clicked Clear Input Fields for series
			else if (e.getSource() == seriesEntryView.jbtClearInput) {
				seriesEntryView.clearInputFields();
			}

			// If user clicked Clear Input Fields for episodes
			else if (e.getSource() == episodeEntryView.jbtClearInput) {
				episodeEntryView.clearInputFields();
			}

			// If user clicked Clear Input Fields for maker
			else if (e.getSource() == makerEntryView.jbtClearInput) {
				makerEntryView.clearInputFields();
			}
		}
	} // Ends ClearInputFieldsListener

	/**
	 * CancelListener provides a method for the user to create a new entry of
	 * the selected type and add it to the appropriate model and database.
	 */
	private class CancelListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("hello");
			if (e.getSource() == movieEntryView.jbtCancel) {
				movieEntryView.dispose();
			} else if (e.getSource() == seriesEntryView.jbtCancel) {
				seriesEntryView.dispose();
			} else if (e.getSource() == episodeEntryView.jbtCancel) {
				episodeEntryView.dispose();
			} else if (e.getSource() == makerEntryView.jbtCancel) {
				makerEntryView.dispose();
			}
		}
	} // Ends CancelListener

	private class AddNewMediaListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == makerEntryView.jbtAddMedia1 || e.getSource() == makerEntryView.jbtAddMedia2
					|| e.getSource() == makerEntryView.jbtAddMedia3) {
				String[] options = new String[] { "Movie", "Series", "Episode" };

				int response = JOptionPane.showOptionDialog(null, "Which type of media would you like to create?",
						"Add New Media", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
						options[0]);
				// User wants to make movie
				if (response == 0) {
					movieEntryView.setLocationRelativeTo(null);
					movieEntryView.setVisible(true);
				}
				// User wants to make series
				else if (response == 1) {
					seriesEntryView.setLocationRelativeTo(null);
					seriesEntryView.setVisible(true);
				}
				// User wants to make episodes
				else if (response == 2) {
					episodeEntryView.setSeriesDropDown(databaseModel.getMedia(2));
					episodeEntryView.update();
					episodeEntryView.setLocationRelativeTo(null);
					episodeEntryView.setVisible(true);
				}
			}
		}
	}

	private class AddToCreditsListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == makerEntryView.jbtAddToAC) {
				int[] selection = makerEntryView.stringMedia1.getSelectedIndices();

				for (int i = 0; i < selection.length; ++i) {
					makerEntryView.tempAC.add(databaseModel.getAllMedia().get(selection[i]));
					System.out.println(makerEntryView.tempAC);
				}
			} else if (e.getSource() == makerEntryView.jbtAddToDC) {
				int[] selection = makerEntryView.stringMedia2.getSelectedIndices();

				for (int i = 0; i < selection.length; ++i) {
					makerEntryView.tempDC.add(databaseModel.getAllMedia().get(selection[i]));
				}
			} else if (e.getSource() == makerEntryView.jbtAddToPC) {
				int[] selection = makerEntryView.stringMedia3.getSelectedIndices();

				for (int i = 0; i < selection.length; ++i) {
					makerEntryView.tempPC.add(databaseModel.getAllMedia().get(selection[i]));
				}
			}
		}
	}
}// ENDS MEDIACONTROLLER CLASS
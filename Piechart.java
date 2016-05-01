import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.chart.*;
import javafx.scene.Group;

/**
 * Project #4 CS 2334, Section 010 April 1, 2016
 * <P>
 * A class that stores data for a media maker's credits and constructs a
 * representative pie chart to display to the user.
 * </P>
 * 
 * @version 1.0
 */
public class Piechart extends Application {
	/** The media maker whose credits are displayed over time on the histogram. */
	private MediaMaker mediaMaker;

	/** The number of acting movie credits a media maker has.*/
	private int actingMovieCred;

	/** The number of acting series credits a media maker has.*/
	private int actingSeriesCred;

	/** The number of producing movie credits a media maker has.*/
	private int producingMovieCred;

	/** The number of producing series credits a media maker has.*/
	private int producingSeriesCred;

	/** The number of directing movie credits a media maker has.*/
	private int directingMovieCred;

	/** The number of directing series credits a media maker has.*/
	private int directingSeriesCred;
	
	/**
	 * A mutator for the variable mediaMaker.
	 * 
	 * @param	maker	Maker whose credits are to be displayed.
	 */
	public void setMaker(MediaMaker maker) {
		mediaMaker = maker;
	} // end setMaker
	
	/**
	 * Returns number of media maker's acting movie credits.
	 * 
	 * @param mediaMaker	The media maker whose credits are being graphically displayed.
	 * @return	An int value of acting movie credits a media maker has.
	 */
	public int getActingMovieCred(MediaMaker mediaMaker) {
		actingMovieCred = 0; // Sets initial amount of credits before looping

		for (int i = 0; i < mediaMaker.getActingCredits().size(); ++i) {
			if (mediaMaker.getActingCredits().get(i).getClass().getName().equals("Movie")) {
				++actingMovieCred;
			}
		}
		return actingMovieCred;
	} // end getActingMovieCred

	/**
	 * Returns number of media maker's acting series credits.
	 * 
	 * @param mediaMaker	The media maker whose credits are being graphically displayed.
	 * @return	An int value of acting series credits a media maker has.
	 */
	public int getActingSeriesCred(MediaMaker mediaMaker) {
		actingSeriesCred = 0; // Sets initial amount of credits before looping

		for (int i = 0; i < mediaMaker.getActingCredits().size(); ++i) {
			if (mediaMaker.getActingCredits().get(i).getClass().getName().equals("Series")
					|| mediaMaker.getActingCredits().get(i).getClass().getName().equals("Episode")) {
				++actingSeriesCred;
			}
		}
		return actingSeriesCred;
	} // end getActingSeriesCred

	/**
	 * Returns number of media maker's producing movie credits.
	 * 
	 * @param mediaMaker	The media maker whose credits are being graphically displayed.
	 * @return An int value of producing movie credits a media maker has.
	 */
	public int getProducingMovieCred(MediaMaker mediaMaker) {
		producingMovieCred = 0; // Sets initial amount of credits before looping

		for (int i = 0; i < mediaMaker.getProducingCredits().size(); ++i) {
			if (mediaMaker.getProducingCredits().get(i).getClass().getName().equals("Movie")) {
				++producingMovieCred;
			}
		}
		return producingMovieCred;
	} // end getProducingMovieCred

	/**
	 * Returns number of media maker's producing series credits.
	 * 
	 * @param mediaMaker	The media maker whose credits are being graphically displayed.
	 * @return An int value of producing series credits a media maker has.
	 */
	public int getProducingSeriesCred(MediaMaker mediaMaker) {
		producingSeriesCred = 0; // Sets initial amount of credits before looping

		for (int i = 0; i < mediaMaker.getProducingCredits().size(); ++i) {
			if (mediaMaker.getProducingCredits().get(i).getClass().getName().equals("Series")
					|| mediaMaker.getProducingCredits().get(i).getClass().getName().equals("Episode")) {
				++producingSeriesCred;
			}
		}
		return producingSeriesCred;
	} // end getProducingSeriesCred

	/**
	 * Returns number of media maker's directing movie credits.
	 * 
	 * @param mediaMaker	The media maker whose credits are being graphically displayed.
	 * @return An int value of directing movie credits a media maker has.
	 */
	public int getDirectingMovieCred(MediaMaker mediaMaker) {
		directingMovieCred = 0; // Sets initial amount of credits before looping

		for (int i = 0; i < mediaMaker.getDirectingCredits().size(); ++i) {
			if (mediaMaker.getDirectingCredits().get(i).getClass().getName().equals("Movie")) {
				++directingMovieCred;
			}
		}
		return directingMovieCred;
	} // end getDirectingMovieCred

	/**
	 * Returns number of media maker's directing series credits.
	 * 
	 * @param mediaMaker	The media maker whose credits are being graphically displayed.
	 * @return An int value of directing series credits a media maker has.
	 */
	public int getDirectingSeriesCred(MediaMaker mediaMaker) {
		directingSeriesCred = 0; // Sets initial amount of credits before looping

		for (int i = 0; i < mediaMaker.getDirectingCredits().size(); ++i) {
			if (mediaMaker.getDirectingCredits().get(i).getClass().getName().equals("Series")
					|| mediaMaker.getDirectingCredits().get(i).getClass().getName().equals("Episode")) {
				++directingSeriesCred;
			}
		}
		return directingSeriesCred;
	} // end getDirectingSeriesCred
 
    @Override
    public void start(Stage stage) throws IOException {
    	
    	/*
		 * TODO: Because data was not being passed to the Piechart from the database/controller
		 * along with instantiating the graphs within the MVC, the graphing results in errors.
		 * Running this class by itself shows that our graphs work at least with hard coded values
		 * from the text file (aside from Angelina Abdullaeva's 2015 acting credit that seems to be
		 * inserted in all media makers -- appears to be a global variable problem we could not discern.
		 */	
    	FileReader fr = new FileReader("SomeActors.txt");
		BufferedReader br = new BufferedReader(fr);
		MediaMaker mediaMaker = new MediaMaker("Jolie, Angelina		10 Years of Tomb Raider: A GameTap Retrospective (2008) (TV)  (archive footage)  [Herself]" //, 1, br);
				+ "\n\"1002 Momentos de la tele\" (2012) {(#1.6)}  (archive footage)  [Herself]", 3, br);
		
        Scene scene = new Scene(new Group());
        stage.setTitle("Media Maker Credits");
        stage.setWidth(500);
        stage.setHeight(500);
 
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("Acting Movie", getActingMovieCred(mediaMaker)),
                new PieChart.Data("Acting Series", getActingSeriesCred(mediaMaker)),
                new PieChart.Data("Directing Movie", getDirectingMovieCred(mediaMaker)),
                new PieChart.Data("Directing Series", getDirectingSeriesCred(mediaMaker)),
                new PieChart.Data("Producing Movie", getProducingMovieCred(mediaMaker)),
        		new PieChart.Data("Producing Series", getProducingSeriesCred(mediaMaker)));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Media Maker Credits");

        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}
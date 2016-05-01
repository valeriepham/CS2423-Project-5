import java.io.Serializable;

/**
 * Project #4
 * CS 2334, Section 010
 * April 1, 2016
 * <P>
 * An abstract class that is the parent class for movies, series
 * and episodes.
 * </P>
 * @version 1.0
 */
public abstract class Media implements Comparable<Media>, Serializable{
	/** A serial version ID number for serialization with binary files. */
	private static final long serialVersionUID = 2201181127586058129L;

	/** Stores the title of a Media object as a string. */
	protected String title;

	/** Stores release year of a Media object as a string. */
	protected String releaseYear;

	public abstract String getTitle(); // Requires subclasses to contain an accessor for title
	public abstract String getReleaseYear(); // Requires subclasses to contain an accessor for year
}
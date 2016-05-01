import java.util.Comparator;

/**
 * Project #4
 * CS 2334, Section 010
 * April 1, 2016
 * <P>
 * A Comparator class used when sorting Media search results by release year.
 * </P>
 * @version 1.0
 */
public class YearComparator implements Comparator<Media> {
	/**
	 * Compares a media to another to determine order. A positive number
	 * returned indicates the media comes before the one it's being compared to.
	 * A negative number returned indicates the media comes after the one it's
	 * being compared to. An int of zero indicates that the series are the same.
	 * 
	 * @param media	A media object that is being compare to the second media.
	 * @param otherMedia	A media object that is being compared to the first media.
	 * @return An int that determines precedence between two media by year.
	 */
	@Override
	public int compare(Media media, Media otherMedia) {
		// TODO
		return 0;
	}
}
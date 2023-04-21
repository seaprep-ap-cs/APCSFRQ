import java.util.*;

public class ReviewAnalysis {
    /** All user reviews to be included in this analysis */ private Review[] allReviews;
    /** Initializes allReviews to contain all the Review objects to be analyzed */ public ReviewAnalysis()
    { /* implementation not shown */ }
    /** Returns a double representing the average rating of all the Review objects to be
     * analyzed, as described in part (a)
     * Precondition: allReviews contains at least one Review.
     * No element of allReviews is null.
     */

    public ReviewAnalysis(Review[] allReviews) {
        this.allReviews = allReviews;
    }

    public double getAverageRating() {
        int reviewsCount = this.allReviews.length;
        int ratingsSum = 0;

        for (Review review: this.allReviews) {
            ratingsSum += review.getRating();
        }

        return ratingsSum * 1.0 / reviewsCount;
    }
    /** Returns an ArrayList of String objects containing formatted versions of
     * selected user comments, as described in part (b)
     * Precondition: allReviews contains at least one Review.
     * No element of allReviews is null.
     }
     * Postcondition: allReviews is unchanged.
     */
    public ArrayList<String> collectComments() {
        ArrayList<String> result = new ArrayList<String>();

        for(int index = 0; index < this.allReviews.length; index++) {
            String comment = this.allReviews[index].getComment();

            if (comment.indexOf("!") != -1) {
                String text =  "" + index + "-" + comment;
                String lastCharacter = comment.substring(comment.length() - 1);

                if (!lastCharacter.equals(".") && !lastCharacter.equals("!")) {
                    text = text + ".";
                }

                result.add(text);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // test setup
        Review rev0 = new Review(4, "Good! Thnx");
        Review rev1 = new Review(3, "OK site");
        Review rev2 = new Review(5, "Great!");
        Review rev3 = new Review(2, "Poor! Bad.");
        Review rev4 = new Review(3, "");
        Review[] arr = {rev0, rev1, rev2, rev3, rev4};
        ReviewAnalysis reviewAnalysis = new ReviewAnalysis(arr);

        // test getAverageRating
        double actualAverage = reviewAnalysis.getAverageRating();
        double expectedAverage = 3.4;

        if (actualAverage != expectedAverage) {
            System.out.println("Test failed. Expected: " + expectedAverage + ", but received: " + actualAverage);
        }

        System.out.println("Expected average: " + expectedAverage);
        System.out.println("Actual average:   " + actualAverage);

        // test collectComments

        // act
        ArrayList<String> actual = reviewAnalysis.collectComments();

        // assert(ish)
        String[] expected = {"0-Good! Thnx.", "2-Great!", "3-Poor! Bad."};
        for(int i = 0; i < expected.length; i++) {
            if (actual.get(i).compareTo(expected[i]) != 0) {
                System.out.println("Test Failed. Expected: " + expected[i] + " but got: " + actual.get(i));
                break;
            }
        }
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Actual:   " + actual);
    }
}

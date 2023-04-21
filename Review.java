import java.util.ArrayList;

public class Review {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(0);
        numbers.add(-1);
        numbers.add(1);
        numbers.add(-2);
        numbers.add(-3);

        for (int i = 0; i < numbers.size(); i++) {
            int x = numbers.get(i);
            if (x < 0) {
                numbers.remove(i);
            }
        }
        System.out.println(numbers);
    }
    private int rating;
    private String comment;
    /** Precondition: r >= 0 * c is not null.
     */
    public Review(int r, String c)
    {
        rating = r;
        comment = c; }
    public int getRating()
    {
        return rating;
    }
    public String getComment()
    {
        return comment;
    }

}

package practiceexam.one.question4;


public class MovieTheater {
    public static void main(String[] args) {
        boolean[][] seats = {
                {false, true, true, false, false, true},
                {true, true, true, false, true, false},
                {false, false, true, false, true, true},
                {true, true, true, false, true, false},
                {true, true, true, false, false, false}
        };

        // Case 1: width starts at index 1
        System.out.println("vacantGoodSeats(seats, 4, 3) should return 5. Actual: " +  vacantGoodSeats(seats, 4, 3));

        // Case 2: Edge case where width is the entire width of the row
        System.out.println("vacantGoodSeats(seats, 6, 3) should return 8. Actual: " +  vacantGoodSeats(seats, 6, 3));

        // Case 2: Edge case where width is the entire width of the row and height is just one row
        System.out.println("vacantGoodSeats(seats, 6, 1) should return 3. Actual: " +  vacantGoodSeats(seats, 6, 1));


        // Case 1: bestTwoSeats
        System.out.println("bestTwoSeats(seats) should return (2, 0). Actual: " + bestTwoSeats(seats));
    }

    /********************* Part (a) *********************/

    /** Returns the number of vacant seats in the "desirable"
     *  area of the seats array: the h rows starting from row 2
     *  and the w contiguous seats in the center of each row.
     *  Precondition: The entire "desirable" area fits within
     *                the seats array; w and the number of seats
     *                in each row are even numbers.
     */
    public static int vacantGoodSeats(boolean[][] seats, int w, int h) {
        int count = 0;

        for (int rowStart = 2; rowStart <= 1 + h; rowStart++) {

            int colStop =  (seats[0].length + w) / 2;
            for (int colStart = (seats[0].length - w) / 2; colStart < colStop; colStart++) {
                if (seats[rowStart][colStart] == false) {
                    count++;
                }
            }
        }

        return count;
    }

    /********************* Part (b) *********************/

    /** Returns the location of a pair of vacant seats closest
     *  to the central pair of seats. The central pair is
     *  in the middle of the center row; if the number of rows
     *  is even, the "center" row is the one closer to the
     *  screen. The location of a pair of seats is defined
     *  as the row and column of the left seat in the pair
     *  (the seat with the smaller column index). Returns
     *  null if a pair of adjacent vacant seats is not found.
     */
    public static Location bestTwoSeats(boolean[][] seats)
    {
        // location of the left seat of the center seats
        Location center = new Location((seats.length - 1)/2, seats[0].length/2 - 1);
        Location bestLocation = null;

        for (int r = 0; r < seats.length; r++)
        {
            for (int c = 0; c < seats[0].length - 1; c++)
            {

                // question logic
                // if both seats are vacant (i.e. false), then check the current pair of seats with the center pair
                if (!(seats[r][c] || seats[r][c+1]))
                {
                    // create an instance of Location using the left seat
                    Location currentLocation = new Location(r, c);

                    // check if the bestLocation is null or currentLocation is closer to center than bestLocation
                    if (bestLocation == null || currentLocation.distanceFrom(center) < bestLocation.distanceFrom(center)) {
                        bestLocation = currentLocation;
                    }

                }
            }
        }

        return bestLocation;
    }
}


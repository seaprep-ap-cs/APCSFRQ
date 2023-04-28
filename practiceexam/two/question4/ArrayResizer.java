package practiceexam.two.question4;

public class ArrayResizer {

    public static boolean isNonZeroRow(int[][] array2D, int r) {
        // assume that we have an array of all zeros
        boolean res = true;

        // this solution is not the most efficient because it keeps searching even though we found a non-zero
        // however, this is the simplest and easiest to write given test constraints and time
        // for extra credit, rewrite using a while loop
        for (int ele : array2D[r]) {

            // change res only if we find a non-zero
            if (ele != 0) {
                res = false;
            }

        }

        return res;
    }

    public static int numNonZeroRows(int[][] array2D) {return 42;}

    public static int[][] resize(int[][] array2D) {
        int nonZeroRows = numNonZeroRows(array2D);

        // assumes non-jagged array
        // initial values are 0
        int totalCols = array2D[0].length;

        // create result 2Darray using following pattern
        // data_type[][] array_Name = new data_type[no_of_rows][no_of_columns];

        int[][] res = new int[nonZeroRows][totalCols];

        int resRow = 0;
        int totalRows = array2D.length;

        for (int row = 0; row < array2D.length; row++) {
            if (isNonZeroRow(array2D, row)) {
                for (int col = 0; col < totalCols; col++) {
                    res[resRow][col] = array2D[row][col];
                }
                resRow++;
            }
        }

        return res;
    }

}

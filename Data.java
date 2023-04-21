public class Data {
    public static void main(String[] args) {
        System.out.println("Testing repopulate...");
        Data data1 = new Data(new int[3][3]);
        data1.repopulate();
        data1.displayGrid();

        System.out.println();
        System.out.println("Testing countIncreasingCols...");
        int[][] test = {{10, 540, 440, 440}, {220, 450, 440, 190}};
        Data data = new Data(test);
        data.displayGrid();
        int monotonicColsCount = data.countIncreasingCols();
        System.out.println("Count of monotonic columns: " + monotonicColsCount);
    }
    public static final int MAX = 10000;
    private int[][] grid;

    public Data(int[][] grid) {
        this.grid = grid;
    }

    public void repopulate() {
        for (int row = 0; row < this.grid.length; row++) {
            for (int col = 0; col < this.grid[row].length; col++) {

                // Generate a random number
                int randomNumber = 0;
                boolean foundRandomNumber = false;
                while (!foundRandomNumber) {
                    int temp = (int) (Math.random() * MAX + 1);
                    // unnecessary; implied in generating the random number
                    if (temp >= 1 && temp <= MAX) {
                        if (temp % 10 == 0) {
                            if (temp % 100 != 0) {
                                randomNumber = temp;
                                foundRandomNumber = true;
                            }
                        }
                    }
                }

                // set the cell to the random number
                this.grid[row][col] = randomNumber;
            }
        }
    }

    public int countIncreasingCols() {
        int res = 0;
        int rowSize = this.grid[0].length;
        for (int col = 0; col < rowSize; col++) {
            boolean isMonotonic = true;
            int row = 0;

//            // for loop version
//            for (int row = 0; row < this.grid.length - 1; row++) {
//                // get the current value
//                int curr = this.grid[row][col];
//                /// get the value ahead
//                int next = this.grid[row + 1 ][col];
//                // compare and update
//
//                if (curr > next) {
//                    isMonotonic = false;
//                }
//            }
//
//            // upodate the counter
//            if (isMonotonic) {
//                res++;
//            }

            while (isMonotonic && row < this.grid.length - 1) {
                int curr = this.grid[row][col];
                int next = this.grid[row + 1][col];

                if (curr > next) {
                    isMonotonic = false;
                }

                row++;
            }

            //
            if (isMonotonic) {
                res++;
            }
        }

        return res;
    }


    public void displayGrid() {
        for (int[] arr : this.grid) {
            for (int ele : arr) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}

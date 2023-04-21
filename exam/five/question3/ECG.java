package exam.five.question3;

// Exam #5 Question 3

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ECG
{
    /** ECG sampling rate in samples taken per second. */
    private static final int SAMPLING_RATE = 300;

    /** Minimum possible distance between R-peaks. */
    private static final int DELTA = SAMPLING_RATE / 10;

    /*********************  Extra  *********************/

    /** Returns true if an R-peak is detected at index k;
     *  otherwise returns false.
     */
    private static boolean isRpeak(double[] v, int k)
    {
        return v[k] > 1.0 &&
                v[k] == max(v, k - DELTA, k + DELTA) &&
                min(v, k - DELTA, k) < 0 &&
                min(v, k, k + DELTA) < 0;
    }

    /********************* Part (a) *********************/

    /** Returns an ArrayList of indices of all consecutive
     *  R-peaks in v between v[DELTA] and v[v.length-1-DELTA].
     *  An R-peak is determined by a call to the method isRpeak.
     *  R-peaks must be at least DELTA apart.
     */
    public static ArrayList<Integer> findRpeaks(double[] v)
    {
        ArrayList<Integer> rPeakPositions = new ArrayList<Integer>();

        int k = DELTA;

        while (k < v.length - DELTA)
        {
            if (isRpeak(v, k))
            {
                rPeakPositions.add(k);
                k += DELTA;
            }
            else
                k++;
        }
        return rPeakPositions;
    }

    /********************* Part (b) *********************/

    /** Returns the heart rate in beats per minute obtained from
     *  rPeakPositions, the list of the indices of R-peaks.
     *  Precondition: rPeakPositions.size() >= 2
     */
    public static int heartRate(ArrayList<Integer> rPeakPositions)
    {
        int first = rPeakPositions.get(0);
        int last = rPeakPositions.get(rPeakPositions.size() - 1);
        double avgDistance = (double)(last - first) /  (rPeakPositions.size()); // using double to maintain accuracy

        double avgLength = avgDistance / SAMPLING_RATE; // in seconds

        return (int)(60 * SAMPLING_RATE / avgDistance + 0.5); // convert to minutes and round up since we are truncating
    }

    /*********************  Extra  *********************/

    /** Returns the largest value among v[i], v[i+1], ..., v[j]
     *  Precondition: 0 <= i <= j < v.length;
     */
    private static double max(double[] v, int i, int j)
    {
        double m = v[i];
        for (int k = i+1; k <= j; k++)
            if (v[k] > m)
                m = v[k];
        return m;
    }

    /** Returns the smallest value among v[i], v[i+1], ..., v[j]
     *  Precondition: 0 <= i <= j < v.length;
     */
    private static double min(double[] v, int i, int j)
    {
        double m = v[i];
        for (int k = i+1; k <= j; k++)
            if (v[k] < m)
                m = v[k];
        return m;
    }

    public static void main(String[] args)
    {
        String pathname = "./exam/five/question3/ecg.dat";
        File file = new File(pathname);
        Scanner input = null;
        try
        {
            input = new Scanner(file);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("*** Cannot open " + pathname + " ***");
            System.exit(1);  // quit the program
        }

        double[] v = new double[2000];
        int k = 0;

        while (input.hasNextDouble() && k < 2000)
            v[k++] = input.nextDouble();

        input.close();

        ArrayList<Integer> rPeakPositions = ECG.findRpeaks(v);
        System.out.println(rPeakPositions);
        System.out.println(ECG.heartRate(rPeakPositions));
    }
}


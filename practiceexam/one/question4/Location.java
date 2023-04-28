package practiceexam.one.question4;// Exam #5 Question 4

public class Location
{
    private int row, col;

    public Location (int r, int c)
    {
        row = r;
        col = c;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    public double distanceFrom(Location other)
    {
        return Math.abs(getRow() - other.getRow()) + Math.abs(getCol() - other.getCol());
    }

    public String toString()
    {
        return "(" + row + ", " + col +")";
    }
}
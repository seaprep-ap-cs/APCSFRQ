package practiceexam.two.question2;

public class CombinedTable {
    private SingleTable t1;
    private SingleTable t2;

    public CombinedTable(SingleTable t1, SingleTable t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public boolean canSeat(int people) {
        return people <= t1.getNumSeats() + t2.getNumSeats() - 2;
    }

    public double getDesirability() {
        double avg = t1.getViewQuality() + t2.getViewQuality() / 2;

        if (t1.getHeight() == t2.getHeight()) {
            return avg;
        }
        // not same height
        return avg - 10;
    }
}

package practiceexam.one.question2;

// Exam #5 Question 2

public class APStudent
{
    private static final int MIN_GRADE = 3;

    private int totalExams;
    private int goodExams;  // grade of 3 or higher
    private int sumOfGrades;

    public void addExam(int grade)
    {
        totalExams++;
        sumOfGrades += grade;
        if (grade >= MIN_GRADE)
            goodExams++;
    }

    public int awardLevel()
    {
        if (totalExams == 0)
            return 0;

        double averageGrade = (double)sumOfGrades / totalExams;

        if (goodExams >= 5 && averageGrade >= 3.5)
            return 3;
        else if (goodExams >= 4 && averageGrade >= 3.25)
            return 2;
        else if (goodExams >= 3)
            return 1;
        else
            return 0;
    }

    public static void main(String[] args)
    {
        APStudent student = new APStudent();
        student.addExam(2);
        System.out.print(student.awardLevel() + " ");
        student.addExam(4);
        student.addExam(5);
        System.out.print(student.awardLevel() + " ");
        student.addExam(3);
        System.out.print(student.awardLevel() + " ");
        student.addExam(4);
        System.out.print(student.awardLevel() + " ");
        student.addExam(3);
        System.out.print(student.awardLevel() + " ");
        student.addExam(1);
        System.out.print(student.awardLevel() + " ");
        System.out.println();
    }
}

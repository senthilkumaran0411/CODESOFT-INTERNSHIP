import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of students:");
        int numStudents = scanner.nextInt();

        List<Student> students = new ArrayList<>();

        for (int i = 1; i <= numStudents; i++) {
            System.out.println(String.format("Enter the details for student %d:", i));
            Student student = new Student();

            System.out.print("Enter the student's name: ");
            student.setName(scanner.next());

            System.out.print("Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();

            List<Subject> subjects = new ArrayList<>();

            for (int j = 1; j <= numSubjects; j++) {
                System.out.println(String.format("Enter the details for subject %d:", j));
                Subject subject = new Subject();

                System.out.print("Enter the subject name: ");
                subject.setName(scanner.next());

                System.out.print("Enter the marks obtained (out of 100): ");
                subject.setMarks(scanner.nextInt());

                subjects.add(subject);
            }

            student.setSubjects(subjects);

            students.add(student);
        }

        for (Student student : students) {
            int totalMarks = 0;
            for (Subject subject : student.getSubjects()) {
                totalMarks += subject.getMarks();
            }

            double averagePercentage = (double) totalMarks / (student.getSubjects().size() * 100) * 100;
            char grade = calculateGrade(averagePercentage);

            System.out.println(String.format("Student: %s", student.getName()));
            System.out.println("Subjects:");
            for (Subject subject : student.getSubjects()) {
                System.out.println(String.format("  %s: %d", subject.getName(), subject.getMarks()));
            }
            System.out.printf("Total marks: %d%n", totalMarks);
            System.out.printf("Average percentage: %.2f%%%n", averagePercentage);
            System.out.printf("Grade: %c%n%n", grade);
        }
    }

    public static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}

class Student {
    private String name;
    private List<Subject> subjects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}

class Subject {
    private String name;
    private int marks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
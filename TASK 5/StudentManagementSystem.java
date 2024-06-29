import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public void saveToFile(String filename) {
        try (java.io.FileWriter writer = new java.io.FileWriter(filename)) {
            for (Student student : students) {
                writer.write(student.toString() + "\n");
            }
        } catch (java.io.IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        try (java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Student student = new Student(parts[0], Integer.parseInt(parts[1]), parts[2]);
                addStudent(student);
            }
        } catch (java.io.IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StudentGradeCalculator {

    
    public static double calculateAverageGrade(String filename) {
        double total = 0;
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty() || line.toLowerCase().startsWith("average")) {
                    continue; 
                }

                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    try {
                        double grade = Double.parseDouble(parts[1]);
                        total += grade;
                        count++;
                    } catch (NumberFormatException e) {
                       
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        if (count == 0) return 0.0;

        return Math.round((total / count) * 100.0) / 100.0; 
    }

    
    public static void printStudentGrades(String filename) {
        System.out.println("Student Grades:");

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty() || line.toLowerCase().startsWith("average")) {
                    continue;
                }

                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    try {
                        int grade = Integer.parseInt(parts[1]);
                        System.out.println(parts[0] + ": " + grade);
                    } catch (NumberFormatException e) {
                        
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        double average = calculateAverageGrade(filename);
        System.out.println("Average Grade: " + average);
    }

        public static void main(String[] args) {
        String filename = "grades.txt"; 
        printStudentGrades(filename);
    }
}

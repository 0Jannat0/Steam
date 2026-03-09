import java.util.*;
import java.util.stream.*;

//Classwork

class Student {
    String name;
    String group;
    double gpa;

    public Student(String name, String group, double gpa) {
        this.name = name;
        this.group = group;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public double getGpa() {
        return gpa;
    }

    public String toString() {
        return name + " (" + group + ", GPA: " + gpa + ")";
    }
}

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(5, 8, 2, 9, 8, 3, 10, 2);
        List<String> words = Arrays.asList("apple", "banana", "avocado", "pear", "apricot");

        List<Student> students = Arrays.asList(
                new Student("Anna", "A1", 3.8),
                new Student("John", "A1", 3.2),
                new Student("Mike", "B1", 3.9),
                new Student("Sara", "B1", 2.9),
                new Student("Tom", "A1", 3.6)
        );


        // 1. Filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("Even numbers: " + evenNumbers);


        // 2. Convert strings to uppercase
        List<String> upperWords = words.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println("Uppercase: " + upperWords);


        // 3. Count strings starting with specific letter
        long countA = words.stream()
                .filter(w -> w.startsWith("a"))
                .count();
        System.out.println("Words starting with 'a': " + countA);


        // 4. Sort numbers in descending order
        List<Integer> sortedDesc = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("Sorted descending: " + sortedDesc);


        // 5. Find max and min number
        int max = numbers.stream().max(Integer::compare).get();
        int min = numbers.stream().min(Integer::compare).get();
        System.out.println("Max: " + max + " Min: " + min);


        // 6. Remove duplicates
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .toList();
        System.out.println("Without duplicates: " + uniqueNumbers);


        // 7. Concatenate strings into comma-separated string
        String joined = words.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Joined: " + joined);


        // 8. Group students by group
        Map<String, List<Student>> grouped = students.stream()
                .collect(Collectors.groupingBy(Student::getGroup));
        System.out.println("Grouped by group: " + grouped);


        // 9. Average GPA of all students
        double avgGpa = students.stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0);
        System.out.println("Average GPA: " + avgGpa);


        // 10. First 3 students with GPA > 3.5
        List<Student> firstThree = students.stream()
                .filter(s -> s.getGpa() > 3.5)
                .limit(3)
                .toList();
        System.out.println("First 3 with GPA > 3.5: " + firstThree);


        // 11. Count students with GPA > 3.5
        long countHighGpa = students.stream()
                .filter(s -> s.getGpa() > 3.5)
                .count();
        System.out.println("Students with GPA > 3.5: " + countHighGpa);
    }
}
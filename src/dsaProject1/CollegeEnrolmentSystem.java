package dsaProject1;

import java.util.Scanner;

public class CollegeEnrolmentSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CourseTree courseTree = new CourseTree();
        Waitlist waitlist = new Waitlist(100);

        System.out.println("==============================================");
        System.out.println("      COLLEGE ENROLLMENT SYSTEM");
        System.out.println("==============================================");

        // Add Courses
        System.out.print("Enter Number of Courses: ");
        int numCourses = scanner.nextInt();

        for (int i = 0; i < numCourses; i++) {

            System.out.println("\nCourse " + (i + 1));

            System.out.print("Course ID: ");
            int id = scanner.nextInt();

            System.out.print("Course Name: ");
            String name = scanner.next();

            System.out.print("Available Seats: ");
            int seats = scanner.nextInt();

            courseTree.addCourse(id, name, seats);
        }

        // Add Students
        System.out.print("\nEnter Number of Students: ");
        int numStudents = scanner.nextInt();

        Student[] students = new Student[numStudents];

        for (int i = 0; i < numStudents; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Student ID: ");
            int id = scanner.nextInt();

            System.out.print("Student Name: ");
            String name = scanner.next();

            students[i] = new Student(id, name);
        }

        int choice;

        do {

            System.out.println("\n==============================================");
            System.out.println("                MAIN MENU");
            System.out.println("==============================================");
            System.out.println("1. Display Courses");
            System.out.println("2. Enroll Student");
            System.out.println("3. Display Students");
            System.out.println("4. Display Waitlist");
            System.out.println("5. Search Course");
            System.out.println("6. Exit");
            System.out.println("==============================================");
            System.out.print("Enter Choice: ");

            choice = scanner.nextInt();

            switch (choice) {

            case 1:
                courseTree.displayCourses();
                break;

            case 2:

                System.out.print("Enter Student ID: ");
                int studentId = scanner.nextInt();

                System.out.print("Enter Course ID: ");
                int courseId = scanner.nextInt();

                Student student = findStudent(students, studentId);

                if (student == null) {

                    System.out.println("Student Not Found!");

                } else {

                    CourseNode course = courseTree.searchCourse(courseId);

                    if (course == null) {

                        System.out.println("Course Not Found!");

                    } else if (course.seatsAvailable > 0) {

                        student.enroll(course);
                        course.seatsAvailable--;

                        System.out.println("Enrollment Successful!");

                    } else {

                        waitlist.enqueue(student);
                        System.out.println("No Seats Available!");
                        System.out.println("Student Added to Waitlist.");

                    }

                }

                break;

            case 3:

                for (Student s : students) {
                    s.displayDetails();
                }

                break;

            case 4:

                waitlist.display();
                break;

            case 5:

                System.out.print("Enter Course ID to Search: ");
                int searchId = scanner.nextInt();

                CourseNode c = courseTree.searchCourse(searchId);

                if (c == null) {

                    System.out.println("Course Not Found!");

                } else {

                    System.out.println("\nCourse Found");
                    System.out.println("----------------------------");
                    System.out.println("Course ID : " + c.courseId);
                    System.out.println("Course Name : " + c.courseName);
                    System.out.println("Available Seats : " + c.seatsAvailable);

                }

                break;

            case 6:

                System.out.println("\nThank You for Using the System!");

                break;

            default:

                System.out.println("Invalid Choice!");

            }

        } while (choice != 6);

        scanner.close();
    }

    // Find Student by ID
    public static Student findStudent(Student[] students, int id) {

        for (Student s : students) {

            if (s.id == id)
                return s;

        }

        return null;
    }
}
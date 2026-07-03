package dsaProject1;

/*
 * ---------------------------------------------------------
 * College Enrollment System
 * Student Class
 *
 * Stores student information and enrolled courses.
 * Maximum courses per student: 10
 * ---------------------------------------------------------
 */

public class Student {

    int id;
    String name;

    CourseNode[] enrolledCourses;
    int courseCount;

    // Constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        enrolledCourses = new CourseNode[10];
        courseCount = 0;
    }

    // Enroll student in a course
    public void enroll(CourseNode course) {

        // Check duplicate enrollment
        for (int i = 0; i < courseCount; i++) {
            if (enrolledCourses[i].courseId == course.courseId) {
                System.out.println("\nStudent is already enrolled in this course.");
                return;
            }
        }

        if (courseCount < enrolledCourses.length) {
            enrolledCourses[courseCount] = course;
            courseCount++;

            System.out.println("\nEnrollment Successful!");
        } else {
            System.out.println("\nMaximum course limit reached.");
        }
    }

    // Display student information
    public void displayDetails() {

        System.out.println("\n=================================================");
        System.out.println("               STUDENT DETAILS");
        System.out.println("=================================================");
        System.out.println("Student ID   : " + id);
        System.out.println("Student Name : " + name);

        System.out.print("Courses      : ");

        if (courseCount == 0) {
            System.out.println("None");
        } else {
            for (int i = 0; i < courseCount; i++) {
                System.out.print(enrolledCourses[i].courseName);

                if (i != courseCount - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        System.out.println("=================================================");
    }
}
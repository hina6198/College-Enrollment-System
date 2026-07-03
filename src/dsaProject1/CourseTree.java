package dsaProject1;

/*
 * ---------------------------------------------------------
 * College Enrollment System
 * CourseTree Class
 *
 * Stores all courses using a Binary Search Tree (BST).
 *
 * Operations:
 * - Add Course
 * - Search Course
 * - Display Courses (In-order Traversal)
 * ---------------------------------------------------------
 */

public class CourseTree {

    CourseNode root;

    // Add a new course
    public void addCourse(int courseId, String courseName, int seatsAvailable) {
        root = addCourseRec(root, courseId, courseName, seatsAvailable);
    }

    // Recursive method to insert a course
    private CourseNode addCourseRec(CourseNode root, int courseId, String courseName, int seatsAvailable) {

        if (root == null) {
            return new CourseNode(courseId, courseName, seatsAvailable);
        }

        if (courseId < root.courseId) {
            root.left = addCourseRec(root.left, courseId, courseName, seatsAvailable);
        } 
        else if (courseId > root.courseId) {
            root.right = addCourseRec(root.right, courseId, courseName, seatsAvailable);
        } 
        else {
            System.out.println("\nCourse ID already exists!");
        }

        return root;
    }

    // Search course by ID
    public CourseNode searchCourse(int courseId) {
        return searchCourseRec(root, courseId);
    }

    private CourseNode searchCourseRec(CourseNode root, int courseId) {

        if (root == null || root.courseId == courseId) {
            return root;
        }

        if (courseId < root.courseId) {
            return searchCourseRec(root.left, courseId);
        }

        return searchCourseRec(root.right, courseId);
    }

    // Display all courses
    public void displayCourses() {

        if (root == null) {
            System.out.println("\nNo courses available.");
            return;
        }

        System.out.println("\n==============================================================");
        System.out.println("                    AVAILABLE COURSES");
        System.out.println("==============================================================");
        System.out.printf("%-12s %-25s %-10s%n", "Course ID", "Course Name", "Seats");
        System.out.println("--------------------------------------------------------------");

        displayCoursesRec(root);

        System.out.println("==============================================================");
    }

    // In-order Traversal
    private void displayCoursesRec(CourseNode root) {

        if (root != null) {

            displayCoursesRec(root.left);

            System.out.printf("%-12d %-25s %-10d%n",
                    root.courseId,
                    root.courseName,
                    root.seatsAvailable);

            displayCoursesRec(root.right);
        }
    }
}
package dsaProject1;

public class CourseNode {

    int courseId;
    String courseName;
    int seatsAvailable;

    CourseNode left;
    CourseNode right;

    // Constructor
    public CourseNode(int courseId, String courseName, int seatsAvailable) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.seatsAvailable = seatsAvailable;

        left = null;
        right = null;
    }
}
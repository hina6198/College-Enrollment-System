package dsaProject1;

/*
 * ---------------------------------------------------------
 * College Enrollment System
 * Waitlist Class
 *
 * Implements a Circular Queue to manage students waiting
 * for course enrollment when no seats are available.
 * ---------------------------------------------------------
 */

public class Waitlist {

    Student[] queue;
    int front;
    int rear;
    int size;

    // Constructor
    public Waitlist(int capacity) {
        queue = new Student[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    // Add student to waitlist
    public void enqueue(Student student) {

        if (size == queue.length) {
            System.out.println("\nWaitlist is full.");
            return;
        }

        queue[rear] = student;
        rear = (rear + 1) % queue.length;
        size++;

        System.out.println("\nStudent added to the waitlist successfully.");
    }

    // Remove student from waitlist
    public Student dequeue() {

        if (size == 0) {
            return null;
        }

        Student student = queue[front];
        front = (front + 1) % queue.length;
        size--;

        return student;
    }

    // Display waitlist
    public void display() {

        if (size == 0) {
            System.out.println("\n=================================================");
            System.out.println("               WAITLIST");
            System.out.println("=================================================");
            System.out.println("No students in the waitlist.");
            System.out.println("=================================================");
            return;
        }

        System.out.println("\n=================================================");
        System.out.println("                 WAITLIST");
        System.out.println("=================================================");
        System.out.printf("%-12s %-20s%n", "Student ID", "Student Name");
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < size; i++) {

            int index = (front + i) % queue.length;

            System.out.printf("%-12d %-20s%n",
                    queue[index].id,
                    queue[index].name);
        }

        System.out.println("=================================================");
    }
}
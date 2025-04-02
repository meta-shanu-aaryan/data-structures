package StackQueueHashing.assignment3;

public class Course {
    String courseName;

    public Course(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
    }

    public String getCourseName() {
        return courseName;
    }

    int capacity;

    public int getCapacity() {
        return capacity;
    }
}

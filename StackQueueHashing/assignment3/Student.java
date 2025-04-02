package StackQueueHashing.assignment3;

import StackQueueHashing.assignment2.Squeue;

public class Student {
    String studentName;
    Squeue<Course> coursePreference = new Squeue<>(5);

    public Student(String studentName, Course[] coursePreference) {
        this.studentName = studentName;
        for (int i = 0; i < coursePreference.length; i++) {
            this.coursePreference.add(coursePreference[i]);
        }
    }

    public String getStudentName() {
        return studentName;
    }

    public Squeue<Course> getCoursePreference() {
        return coursePreference;
    }

}

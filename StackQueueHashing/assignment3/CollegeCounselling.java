package StackQueueHashing.assignment3;

import java.util.HashMap;

import StackQueueHashing.assignment2.Squeue;

public class CollegeCounselling {
    HashMap<Course, Integer> courseAvailability = new HashMap<>();
    Squeue<Student> studentList;

    public CollegeCounselling(
            int studentListSize, Course[] courseList) {
        studentList = new Squeue<>(studentListSize);
        for (int i = 0; i < courseList.length; i++) {
            courseAvailability.put(courseList[i], courseList[i].getCapacity());
            // System.out.println(courseAvailability.get(c));
        }
    }

    public boolean addStudent(Student s) {
        if (!this.studentList.isFilled()) {
            // System.out.println("Student added");
            // System.out.println(this.studentList.add(s));
            return this.studentList.add(s);
        } else {
            return false;
        }
    }

    public HashMap<Student, Course> getResult() {
        HashMap<Student, Course> result = new HashMap<>();

        while (!studentList.isEmpty()) {
            Student s = studentList.pop();
            // System.out.println(s.studentName);
            // boolean flag = false;
            while (!s.getCoursePreference().isEmpty()) {
                Course c = s.coursePreference.pop();
                if (courseAvailability.get(c) > 0) {
                    result.put(s, c);
                    courseAvailability.replace(c, (courseAvailability.get(c) - 1));
                    // flag = true;
                    break;
                }
            }
        }

        return result;
    }
}

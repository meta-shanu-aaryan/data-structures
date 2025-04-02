package StackQueueHashing.assignment3;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Course c1 = new Course("Java", 2);
        Course c2 = new Course("Python", 3);
        Course c3 = new Course("Javascript", 1);
        Course c4 = new Course("C++", 2);
        Course c5 = new Course("DSA", 3);
        Course c6 = new Course("DBMS", 1);
        Course c7 = new Course("Software Testing", 1);
        Course c8 = new Course("Fullstack Development", 4);
        CollegeCounselling cc = new CollegeCounselling(7, new Course[] { c1, c2, c3, c4, c5, c6, c7, c8 });

        Student s1 = new Student("Shanu", new Course[] { c3, c4, c1, c8, c2 });
        Student s2 = new Student("Swayam", new Course[] { c4, c1, c2, c3, c6 });
        Student s3 = new Student("Dablu", new Course[] { c7, c6, c4, c3, c8 });
        Student s4 = new Student("Soumen", new Course[] { c1, c3, c7, c4, c5 });
        Student s5 = new Student("Golu", new Course[] { c5, c7, c4, c2, c3 });
        Student s6 = new Student("Arya", new Course[] { c2, c8, c5, c6, c7 });
        Student s7 = new Student("Raj", new Course[] { c7, c4, c2, c6, c3 });
        Student s8 = new Student("Preet", new Course[] { c8, c1, c6, c3, c7 });
        Student s9 = new Student("Harsh", new Course[] { c3, c8, c1, c5, c2 });

        cc.addStudent(s1);
        cc.addStudent(s2);
        cc.addStudent(s3);
        cc.addStudent(s4);
        cc.addStudent(s5);
        cc.addStudent(s6);
        cc.addStudent(s7);
        cc.addStudent(s8);
        cc.addStudent(s9);

        for (Map.Entry<Student, Course> mp : cc.getResult().entrySet()) {
            System.out.println(mp.getKey().getStudentName() + "\t" + mp.getValue().getCourseName());
        }

    }
}

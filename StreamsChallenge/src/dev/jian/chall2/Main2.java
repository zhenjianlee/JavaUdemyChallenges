package dev.jian.chall2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass",50);
        Course jmc = new Course("JMC", "Java Masterclass",100);
        Course cgj = new Course("CGJ", "Creating Games in Java");

        int size=5000;
        List<Student> largeStudentList =Stream.generate(()-> Student.getRandomStudent(pymc,jmc,cgj))
                .limit(size)
                .toList();

        double percentPYMC =largeStudentList.stream()
                .mapToDouble((s)->s.getPercentComplete("PYMC"))
                .reduce( 0, (a,b)-> (a+b))/size*1.25;
        System.out.println("Percent PYMC="+ percentPYMC);

        List<Student> addGamingCourse = largeStudentList.stream()
                .filter(s-> s.getPercentComplete("PYMC")>=percentPYMC)
                .sorted(Comparator.comparing(Student::getYearEnrolled)) // method reference
                //.sorted(Comparator.comparing(s-> s.getYearEnrolled()))  // lambda expresssion
                .limit(10)
                .toList();

        addGamingCourse.stream()
                .forEach(s-> s.addCourse(cgj));
        addGamingCourse.forEach(s-> System.out.println(s));

    }
}

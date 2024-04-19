package dev.jian.chall2;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public class Main1 {
    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");
        //        Student tim = new Student("AU", 2019, 30, "M",
        //                true, jmc, pymc);
        //        System.out.println(tim);
        //
        //        tim.watchLecture("JMC", 10, 5, 2019);
        //        tim.watchLecture("PYMC", 7, 7, 2020);
        //        System.out.println(tim);

        List<Student> studentList= Stream.generate(() -> Student.getRandomStudent(pymc, jmc))
                .limit(50)
                .distinct()
                .toList();

        long countMale =studentList.stream()
                .filter((s)->s.getGender()=="M")
                //.peek(s-> System.out.println(s))
                .count();
        long countFemale =studentList.stream()
                .filter((s)->s.getGender()=="F")
                //.peek(s-> System.out.println(s))
                .count();
        long countless30 =studentList.stream()
                .filter((s)->s.getAge()<30)
                //.peek(s-> System.out.println(s))
                .count();
        long count30plus =studentList.stream()
                .filter((s)->s.getAge()>=30 && s.getAge()<60)
                //.peek(s-> System.out.println(s))
                .count();

        long count60plus =studentList.stream()
                .filter((s)->s.getAge()>=60)
                //.peek(s-> System.out.println(s))
                .count();

        System.out.println(String.format("Male=%s, Female=%s , Age<30=%s , Age>30=%s, Age>=60=%s",
            countMale,countFemale,countless30,count30plus,count60plus));
        var ageSummary = studentList.stream()
                .mapToDouble(s->s.getAge())
                .summaryStatistics();
        System.out.println("ageSummary"+ ageSummary);

        System.out.print("Country codes: ");
        studentList.stream()
                .map(s->s.getCountryCode())
                .distinct()
                .forEach(s-> System.out.print(s+" "));
        System.out.println();

        boolean isoldStudents=studentList.stream()
                .anyMatch((s)-> {
                    if (LocalDate.now().getYear() - s.getYearEnrolled() > 7 && s.getPercentComplete("JMC") < 100.00) {
                        return true;
                    }
                    return false;
                });
        List<Student> oldStudents =studentList.stream()
                .filter(s-> LocalDate.now().getYear() -s.getYearEnrolled()>7)

                .filter(s->s.getPercentComplete("JMC")< 100.00)
                .limit(5)
                .peek(s-> System.out.println(s.getYearEnrolled()+" "+s.getPercentComplete("JMC")))
                .toList();
        System.out.println(String.format("isOldStudent=%s", isoldStudents));
//        for(Student s : oldStudents){
//            System.out.println(s);
//        }




    }
}

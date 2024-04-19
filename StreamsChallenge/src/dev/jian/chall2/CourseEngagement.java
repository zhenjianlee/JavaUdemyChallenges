package dev.jian.chall2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CourseEngagement {
    private Course course;
    private LocalDate enrollmentDate;
    private String engagementType;
    private int lastLecture;
    private LocalDate lastActivityDate;

    public CourseEngagement(Course course, LocalDate enrollmentDate, String engagementType) {
        this.course = course;
        this.enrollmentDate = this.lastActivityDate= enrollmentDate;
        this.engagementType = engagementType;

    }
    public String getCourseCode(){
        return this.course.getCourseCode();
    }

    public int getEnrollmentYear(){
        return this.enrollmentDate.getYear();
    }

    public int getLastActivityYear(){
        return this.lastActivityDate.getYear();
    }

    public int getLastActivityMonth(){
        return this.lastActivityDate.getMonthValue();
    }

    // December 24 --> June 25
    public int getMonthsSinceActive(){
        int nowVal = LocalDate.now().getYear()*12 + LocalDate.now().getMonthValue();
        int startVal = this.getLastActivityYear()*12 + this.getLastActivityMonth();

        return nowVal-startVal;

        /*
        //Tim's solution
        LocalDate now= LocalDate.now();
        var months : long = Period.between(lastActivityDate,now).toTotalMonths;
        return (int) months;
        */
    }
    public double getPercentComplete(){
        return lastLecture*100.0/course.getLectureCount();
    }

    void watchLecture(int lectureNumber , LocalDate currentDate){
        lastLecture = Math.max(lectureNumber,lastLecture);
        lastActivityDate = currentDate;
        engagementType = "Lecture "+ lastLecture;
    }
    @Override
    public String toString() {
        return "CourseEngagement{" +
                "course=" + course.getCourseCode() +
                ", enrollmentDate=" + enrollmentDate +
                ", engagementType='" + engagementType + '\'' +
                ", lastLecture=" + lastLecture +
                ", lastActivityDate=" + lastActivityDate +
                '}';
    }
}

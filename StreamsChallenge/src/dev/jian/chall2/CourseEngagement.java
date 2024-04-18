package dev.jian.chall2;

import java.time.LocalDate;

public class CourseEngagement {

    private Course course;
    private LocalDate enrollmentDate;
    private String engagementType;
    private int lastLecture;
    private LocalDate lastActivityDate;

    public CourseEngagement(Course course, LocalDate enrollmentDate, String engagementType, int lastLecture, LocalDate lastActivityDate) {
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.engagementType = engagementType;
        this.lastLecture = lastLecture;
        this.lastActivityDate = lastActivityDate;
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

    public int getMonthsSinceActive(){
        return -1;
    }


}

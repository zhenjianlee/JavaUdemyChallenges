package dev.jian.chall2;

public class Course {

    private String courseCode;
    private String title;
    private int lectureCount;


    public Course(){
        if (this.lectureCount <=0) lectureCount=1;
    }
    public Course(String courseCode, String title) {
        super();
        this.courseCode = courseCode;
        this.title = title;
        this.lectureCount=40;
    }

    public Course(String courseCode, String title, int lectureCount) {
        super();
        this.courseCode = courseCode;
        this.title = title;
        this.lectureCount=lectureCount;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLectureCount() {
        return lectureCount;
    }

    public void setLectureCount(int lectureCount) {
        this.lectureCount = lectureCount;
    }
}

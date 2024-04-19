package dev.jian.chall2;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Student {

    private static Random random= new Random();
    private static int lastStudentId =1;
    private long studentId;
    private String countryCode;
    private int yearEnrolled;
    private int age;
    private String gender;
    private boolean programmingExperience;
    private Map<String,CourseEngagement> engagementMap = new HashMap<>();

    public Student(String countryCode, int yearEnrolled,
                   int age, String gender, boolean programmingExperience, Course ... courses){
        this.studentId = lastStudentId++;
        this.countryCode = countryCode;
        this.yearEnrolled = yearEnrolled;
        this.age = age;
        this.gender = gender;
        this.programmingExperience = programmingExperience;
        for (Course course:courses){
            addCourse(course, LocalDate.of(yearEnrolled,1,1));
        }
    }

    public void addCourse(Course course){
        addCourse(course,LocalDate.now());
    }
    public void addCourse(Course course, LocalDate ld){
        engagementMap.put(course.getCourseCode(), new CourseEngagement(course,
                ld,"Enrollment"));
    }

    public static int getLastStudentId() {
        return lastStudentId;
    }

    public static void setLastStudentId(int lastStudentId) {
        Student.lastStudentId = lastStudentId;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public int getYearEnrolled() {
        return yearEnrolled;
    }

    public void setYearEnrolled(int yearEnrolled) {
        this.yearEnrolled = yearEnrolled;
    }

    public int getAge() {
        return age + getYearsSinceEnrolled();
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isProgrammingExperience() {
        return programmingExperience;
    }

    public void setProgrammingExperience(boolean programmingExperience) {
        this.programmingExperience = programmingExperience;
    }

    public  Map<String,CourseEngagement> getEngagementMap(){
        return Map.copyOf(engagementMap);
    }

    public int getYearsSinceEnrolled(){
        return LocalDate.now().getYear()-this.yearEnrolled;
    }

    public int getMonthsSinceActive(String courseCode){
        CourseEngagement res = engagementMap.getOrDefault(courseCode,null);
        return res==null? 0:res.getMonthsSinceActive();
    }

    public double getPercentComplete(String courseCode) {

        var info = engagementMap.get(courseCode);
        return (info == null) ? 0 : info.getPercentComplete();
    }

    public void watchLecture(String courseCode, int lectureNumber, int month, int year) {

        var activity = engagementMap.get(courseCode);
        if (activity != null) {
            activity.watchLecture(lectureNumber, LocalDate.of(year, month, 1));
        }
    }

    private static String getRandomVal(String... data) {
        return data[random.nextInt(data.length)];
    }

    public static Student getRandomStudent(Course... courses) {

        int maxYear = LocalDate.now().getYear() + 1;

        Student student = new Student(
                getRandomVal("AU", "CA", "CN", "GB", "IN", "UA", "US"),
                random.nextInt(2015, maxYear),
                random.nextInt(18, 90),
                getRandomVal("M", "F", "U"),
                random.nextBoolean(),
                courses);

        for (Course c : courses) {
            int lecture = random.nextInt(1, c.getLectureCount());
            int year = random.nextInt(student.getYearEnrolled(), maxYear);
            int month = random.nextInt(1, 13);
            if (year == (maxYear - 1)) {
                if (month > LocalDate.now().getMonthValue()) {
                    month = LocalDate.now().getMonthValue();
                }
            }
            student.watchLecture(c.getCourseCode(), lecture, month, year);
        }
        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", countryCode='" + countryCode + '\'' +
                ", yearEnrolled=" + yearEnrolled +
                ", ageEnrolled=" + getAge() +
                ", gender='" + gender + '\'' +
                ", programmingExperience=" + programmingExperience +
                ", engagementMap=" + engagementMap +
                '}';
    }
}

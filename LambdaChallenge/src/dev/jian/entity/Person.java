package dev.jian.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Person {
    public static int lastID =0;
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dob;

    public Person(){
        lastID++;
        //System.out.println("called no args constructor!");
    }
    public Person(String firstName, String lastName, LocalDate dob){
        this();
        this.id=lastID;
        this.firstName=firstName;
        this.lastName=lastName;
        this.dob = dob;
    }

    public int getID(){
        return this.id;
    }

    public void setID(int newID){
        this.id = newID;
    }

    public String getFirstName(){
        return this.firstName;
    }
    public void setFirstName(String newFirstName){
        this.firstName=newFirstName;
    }

    public String getLastName(){
        return this.lastName;
    }
    public void setLastName(String newLastName){
        this.lastName=newLastName;
    }

    public LocalDate getdob(){
        return this.dob;
    }

    public void setdob(LocalDate newdob){
        this.dob =newdob;
    }

    public static List<Person> generateRandomPerson(int size){
        List<Person> randomPersons = new ArrayList<>();

        String[] firstNameArr = new String[]{"John", "Bob", "Harry", "Oswald", "Richard ","Emmet", "Aragorn", "Lawrence", "Leo" , "Humpty"};
        String[] lastNameArr = new String[]{"Lee", "Enfield", "Biden", "Obama", "Kensington", "Dumpty", "Odinson", "DiCaprio", "Leong", "Davis"};
        Random random = new Random();
        for (int i=0 ; i<size;i++){
            randomPersons.add(new Person(firstNameArr[random.nextInt(0,10)], lastNameArr[random.nextInt(0,10)],LocalDate.of(random.nextInt(1950,2023), random.nextInt(1,12), random.nextInt(1,28)) ));
        }
        return randomPersons;

    }

    @Override
    public String toString() {
        return "Person{ ID=" + this.getID() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                '}';
    }
}
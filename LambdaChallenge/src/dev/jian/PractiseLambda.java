package dev.jian;

import dev.jian.entity.Person;

import java.util.Comparator;
import java.util.List;

public class PractiseLambda {

    public static void main(String[] args) {

        List<Person> personsList = Person.generateRandomPerson(30);
        printDivider("Unsorted");
        personsList.forEach(System.out::println);
        printDivider("Sorted by DOB using Method Reference");
        personsList.sort(Comparator.comparing(Person::getdob));
        personsList.forEach(PractiseLambda::printPersons);
        printDivider("Sorted by Last Name");
        personsList.sort(Comparator.comparing(Person::getLastName));
        personsList.forEach(PractiseLambda::printPersons);
        printDivider("Sorted by ID Using Lambda Expression");
        personsList.sort((a,b)-> a.getID() -b.getID());
        personsList.forEach(PractiseLambda::printPersons);
        printDivider("Sorted by LastName Using new Comparator");

        var compareLastName = new Comparator<Person>(){
            @Override
            public int compare(Person p1, Person p2){

                if (p1.getLastName().equals(p2.getLastName())){
                    return p1.getFirstName().compareTo(p2.getFirstName());
                }
                return p1.getLastName().compareTo(p2.getLastName());
            }
        };

        personsList.sort(compareLastName);
        personsList.forEach(PractiseLambda::printPersons);


    }

    public static void printPersons(Person p){
        System.out.println(p);
    }

    public static void printDivider(String msg){
        System.out.println("====================================");
        System.out.println("       "+msg);
        System.out.println("====================================");
    }
}

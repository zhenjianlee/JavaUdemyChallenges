package dev.jian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main2 {

    public static void main(String[] args) {

        //0 - Set up Array and ArrayList
        String[] firstNamesArr = new String[]{"Anna", "Jian", "Emilia", "Tho", "Doge", "Emma", "Bob", "Catnip"};
        //List<String> firstNamesList = new ArrayList<>(Arrays.asList(firstNamesArr));
        List<String> firstNamesList = new ArrayList<>();
        firstNamesList.addAll(List.of("Anna", "Jian", "Emilia", "Tho", "Doge", "Emma", "Bob", "Catnip"));

        //1 - transform all names to uppercase
        //array
        Arrays.setAll(firstNamesArr, (i) -> firstNamesArr[i] = firstNamesArr[i].toUpperCase() + " "
                + (char) (new Random().nextInt(65, 90)) + ". " + new StringBuilder(firstNamesArr[i]).reverse().toString().toUpperCase());

        //arraylist
        firstNamesList.replaceAll((n) -> n.toUpperCase() + " " +
                (char) (new Random().nextInt(65, 90)) + ". " + new StringBuilder(n).reverse().toString().toUpperCase());
        firstNamesList.forEach(s-> System.out.println(s));

        System.out.println("--------Remove If FirstName == LastName");
        firstNamesList.removeIf(s->{
            String[] strArr = s.split(" ");
            return strArr[0].equals(strArr[2]);
        });
        firstNamesList.forEach(s-> System.out.println(s));


    }
}

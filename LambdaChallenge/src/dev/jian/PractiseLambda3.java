package dev.jian;

import java.time.temporal.ChronoField;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class PractiseLambda3 {

    public static void main(String[] args) {

        String[] nameArray = new String[] {"Anna", "Bob", "Lucas", "Angelina", "Brad", "Howard", "John", "Dave","Joe","Kate","Wesley","Gina","Julia", "Brendan"};


        // NOT SURE HOW TO USE THIS FUNCTIONAL INTERFACE? ---?
        /*
        Function<String,String> transform =(name)->{
            name=name.toUpperCase();
            StringBuilder lastName = new StringBuilder(name).reverse();
            name+= " "+ Character.toString((char)(new Random().nextInt(65,90))) +".";
            return name+" "+lastName.toString();

        };
        */

        // ====================== USE SETALL and LAMBDA FUNCTION=============
        Arrays.setAll(nameArray,i->{
            String name = nameArray[i].toUpperCase();
            StringBuilder lastName = new StringBuilder(name).reverse();
            name+= " "+(char)(new Random().nextInt(65,90))+".";
            return name+" "+lastName.toString();
        });

        System.out.println("=========Transformed firstname!=========");
        Arrays.asList(nameArray).forEach(System.out::println);


        //===================USE REMOVE IF ===================
        List<String> nameList = new ArrayList<>(Arrays.asList(nameArray));
        nameList.removeIf(name->{
           String[] array = name.split(" ");
           if(array[0].equals(array[2])) {
               System.out.println("Found match!!");
               return true;
           }
           return false;
        });
        System.out.println("=========Removed firstname == lastname!=========");
        nameList.forEach(System.out::println);


        // ======================PRACTISE STREAMING===========================

        System.out.println("============ Practise Stream on the Array =================");
        List<String> newList=Arrays.stream(nameArray)
                .sorted((a,b)->a.compareTo(b))
                .toList();

        newList.forEach(System.out::println);

        System.out.println("============ Practise Stream on the List =================");

       String str= nameList.stream()
                .filter(s-> s.charAt(0)!='A')
                .reduce("", (a,b)->a+" "+b);
        System.out.println(str);

    }

}

package dev.jian;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Main {
    //https://www.udemy.com/course/java-the-complete-java-developer-course/learn/lecture/37021412#notes
    public static void main(String[] args) {

        //1 CONSUMER- print the parts -- cosumer only takes parameter but returns nothing
        Consumer <String> printTheParts =(str)->{
            Arrays.asList(str.split(" ")).forEach(s-> System.out.println(s));
        };
        printTheParts.accept("Hello there how are you doing?");

        //2 FUNCTION - every second char -- function takes parameter and returns something
        Function<String,String> everySecondChar =(str)->{
            String res = "";
            for (int i=0;i<str.length();i++){
                if (i%2 == 1){
                    res+=str.charAt(i);
                }
            }
            return res;
        };
        //3 print the result out
        System.out.println(everySecondChar.apply("1234567890"));

        //5- use challenge 4
        System.out.println(everySecondCharacter(everySecondChar,"1234567890"));

        //6 SUPPLIER - write a supplier interface
        Supplier<String> mySupplier=()->{
            return "Supplier function:I love Java";
        };

        //7 - use challenge 6
        String supplierLambda = mySupplier.get();
        System.out.println(supplierLambda);

    }

    //4 -Method that accepts a function as a parameter and a string to perform secondCharacter
    public static String everySecondCharacter(Function<String,String> func ,String source){
        return func.apply(source);
    }

}


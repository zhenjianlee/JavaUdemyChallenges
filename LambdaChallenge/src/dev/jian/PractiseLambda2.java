package dev.jian;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class PractiseLambda2 {
    public static void main(String[] args) {
        //=============CHALLENGE 1============ Change Anon function to Lambda using !Consumer - accept()
        //Anonymous Function
        Consumer<String> printTheParts = new Consumer<String>(){
            @Override
            public void accept(String sentence){
                String[] parts = sentence.split(" ");
                for(String s : parts){
                    System.out.println(s);
                }
            }
        };
        String theSentence = "Java is extremely difficult especially Lambda Expressions and functional interface!";

        //Lambda Equivalent - LONG VERSION Need to use accept for consumer
        Consumer<String> printThePartsLambda =(sentence)->{
            String[] parts = sentence.split(" ");
            for(String s : parts){
                System.out.println(s);
            }
        };

        //Lambda Shorter Equivalent
        Consumer<String> printThePartsLambdaShort=(sentence)->{
            Arrays.asList(sentence.split(" ")).forEach(s-> System.out.println(s)); // lambda
            Arrays.asList(sentence.split(" ")).forEach(System.out::println); // method reference
        };

        printThePartsLambda.accept(theSentence);
        printThePartsLambdaShort.accept("I am doing it again, but this time with shorter lambda!");

        //============= CHALLENGE 2 & 3 ============ Change funcitonal interface to lambda - !Function -apply()
        //can use Function or Unary functional interface
        Function<String,String> everySecondCharLambda=(sentence)->{
           char[] array= sentence.toCharArray();
           String res="";
           for (int i=0 ; i<array.length;i++){
               if(i%2==1)res+=array[i];
           }
           return res;
        };

        System.out.println(everySecondCharLambda.apply("1234567890"));

        //============= CHALLENGE 4 & 5 ================= Create a lambda that accepts another lambda - !BiFunction -apply()
       BiFunction<Function<String,String>,String,String> everySecondCharLambdaMethod =(Function<String,String> func,String source)->{
           return func.apply(source);
        };

       String res = everySecondCharLambdaMethod.apply(everySecondCharLambda,"1234567890");
        System.out.println("BiFunction method call! "+ res);


        //============= CHALLENGE 6 & 7 ================= write a lambda expression - !supplier -get()

        // supplier with block
        Supplier<String> lambdaSupplierBlock =()->{
            return "I love Java";
        };

        //supplier without block
        Supplier<String> lambdaSupplierNoBlock=()->"You see, I have no blocks in this lambda!";
        System.out.println(lambdaSupplierBlock.get());
        System.out.println(lambdaSupplierNoBlock.get());

        //practise function interface
        Supplier<String> functionInterfaceSupplier = new Supplier<String>(){
            @Override
            public String get(){
                return "I am a function interface supplier!";
            }

        };

        System.out.println(functionInterfaceSupplier.get());

    }


    public static String everySecondChar(String source){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<source.length(); i++){
            if(i%2 ==1)sb.append(source.charAt(i));
        }
        return sb.toString();

    }
}

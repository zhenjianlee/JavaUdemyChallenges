package dev.jian.chall1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        //B1-15 , I16-30 , N31-45, G45-60 , O61-75

        //1 Using Collections
        List<String> list = new ArrayList<>();
        for(int i=1;i<=15;i++){
            list.add("B"+String.valueOf(i));
        }
        var firstStream = list.stream();

        //2 Using arrays
        String[] arr = new String[15];
        for(int i=15;i<30;i++){
            arr[i-15]="I" +(i+1);
        }
        //Arrays.asList(arr).forEach(s-> System.out.print(s+" "));
        var secondStream= Arrays.stream(arr);

        //3 Stream.iterate
        var thirdStream= Stream.iterate(31, n-> 1+n).map(i-> "N"+i).limit(15);

        //4  intstream
        var fourthStream= IntStream.range(45,61).mapToObj(i->"G"+ i);

        //5 generate
//        AtomicInteger i= new AtomicInteger(0);
//        var fifthStream = Stream.generate(()->{
//            i.getAndIncrement();
//            return "O"+i;
//        });
//        var fifthStream= IntStream.rangeClosed(61,75).mapToObj(i->"O"+i);
         var fifthStream = Stream.generate(()-> new Random().nextInt(61,76))
                 .distinct()
                 .limit(15)
                 .map((i)->"O"+i)
                 .sorted();

//        firstStream.forEach(s-> System.out.println(s));
//        secondStream.forEach(s-> System.out.println(s));
//        thirdStream.forEach(s-> System.out.println(s));
//        fourthStream.forEach(s-> System.out.println(s));
//        fifthStream.forEach(s-> System.out.println(s));

        var bi = Stream.concat(firstStream,secondStream);
        var ng = Stream.concat(thirdStream,fourthStream);
        var bing = Stream.concat(bi,ng);
        Stream.concat(bing,fifthStream).forEach(s-> System.out.print(s+" "));




    }



}

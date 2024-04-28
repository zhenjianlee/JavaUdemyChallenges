package dev.jian;

import java.beans.IntrospectionException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Multithreading {

    public static Random random = new Random();

    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            for(int i=0 ; i< 100 ;i++){
                System.out.println(Thread.currentThread().getName()+" "+ i+" "+ Fibonacci(i));
            }
        });

        Thread thread2 = new Thread(()->{
            for(int i=0;i< 100;i++){
                System.out.println(Thread.currentThread().getName()+" "+ i+" "+Tribonacci(i));
            }
        });

        thread1.start();
        thread2.start();
    }


    public static long Fibonacci(long num){
        if (num < 2)return num;

        return Fibonacci(num-1)+ Fibonacci(num-2);

    }

    public static long Tribonacci(long num){
        if (num <3)return num;

        return Tribonacci(num-3)+Tribonacci(num-2)+Tribonacci(num-1);
    }
}

package dev.jian;

public class Fibonacci {

    public static void main(String[] args) {

        printFibonacci(10);

    }

    public static void printFibonacci(int num){
        int a=0;
        int b=1;
        int c=1;

        for (int i=0; i<num; i++){
            a=b;
            b=c;
            c=a+b;
            System.out.print(c+" ");
        }

    }
}

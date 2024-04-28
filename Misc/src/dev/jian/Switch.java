package dev.jian;

import java.util.Scanner;

public class Switch {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("Input a number to check. Enter 404 to exit :");
            int input = scanner.nextInt();
            if (input == 404)break;
            check(input);
        }

    }

    public static void check(int num){

        switch(num){
            case 1,2,3,4-> System.out.println("You still have to work, its a working day");
            case 5 -> System.out.println("TGIF!");
            case 6-> System.out.println("Take a break!");
            case 7 -> System.out.println("Rest today, monday blues tomorrow");
            default -> System.out.println("Hello, there are only 7 days in a week!");

        }
    }
}

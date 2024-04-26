package dev.jian;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String filename = "testing.csv";
        Path path = Paths.get(filename);
    /*
        There are two ways to handle checked exception
        a) EAFP -Wrap with try catch block
        b) EAFP -Adjust method signature with throws and put in type of exception it throws
        c) LBYL -Check the status before executing code
     */

        // A - try catch -EAFP - Easier to Ask for Forgiveness than Permission
//        try{
//            List<String> lines = Files.readAllLines(path);
//        }catch(IOException e){
//            throw new RuntimeException(e);
//        }

        // C-LBYL -Look Before You Leap
//        File file = new File(filename);
//        if (!file.exists()){
//            System.out.println("File does not exist. Quitting application.");
//            return ;
//        }
//
//        System.out.println("Good to go!");

        //D
        testFile(filename);

//        try{testFile2(filename);}
//        catch (IOException e){
//            System.out.println(e +" Cannot read file!");
//        }
    }

    // added finally block
    private static void testFile(String filename){
        Path path = Paths.get(filename);
        try {
            List<String> lines= Files.readAllLines(path);
        }catch (IOException e){
            throw new RuntimeException(e);
        }finally {
            System.out.println("Finally block operated!");
        }
        System.out.println("Read the file successfully! 1");
    }

    // add throws to method signature, call need to implement try catch or add throws to method sig
    private static void testFile2 (String filename) throws IOException{
        Path path= Paths.get(filename);
        List<String> lines = Files.readAllLines(path);
        System.out.println("Read the files successfully! 2");
    }

}

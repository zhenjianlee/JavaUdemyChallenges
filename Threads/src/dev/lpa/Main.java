package dev.lpa;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args){
        var currentThread = Thread.currentThread();
        System.out.println("currentThread="+currentThread);
        printInfo(currentThread);
        currentThread.setName("MainGuy");
        currentThread.setPriority(Thread.MAX_PRIORITY);
        printInfo(currentThread);

        CustomThread customThread = new CustomThread();
        customThread.start();
        // run() = start synchronously, running the thread its invoked from
        // start() = start asynchronously
        Runnable myRunnable=()->{
            for (int i=0; i< 8 ; i++){
                System.out.print("2 ");
                    try{
                        TimeUnit.MILLISECONDS.sleep(250);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            };

        Thread myThread= new Thread(myRunnable);
        myThread.start();
        for (int i=0; i< 3 ; i++){
            System.out.print("0 ");
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void printInfo(Thread thread){
        System.out.println("-----------Start---------------");
        System.out.println("ID="+thread.getId());
        System.out.println("Name="+thread.getName());
        System.out.println("Priority="+thread.getPriority());
        System.out.println("State="+thread.getState());
        System.out.println("Group="+thread.getThreadGroup());
        System.out.println("isAlive="+thread.isAlive());
        System.out.println("------------End--------------");
    }
}

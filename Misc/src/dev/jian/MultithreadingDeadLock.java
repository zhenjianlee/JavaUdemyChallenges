package dev.jian;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class MultithreadingDeadLock {

    public static Random random = new Random();

    public static void main(String[] args) {

        Deque<Integer> d = new LinkedList<>();
        Random random = new Random();
        Integer count =100;

        MultithreadingDeadLock m = new MultithreadingDeadLock();

        Thread thread3 = new Thread(()->{
            for (int i =0 ;i<count; i++){
                m.fillList(d ,i);
            }
        });

        Thread thread4 = new Thread(()->{
            for (int i=0 ; i< count;i++){
                m.pollList(d,i);
            }
        });
        thread3.start();
        thread4.start();

        System.out.println("Deque="+ d.toString());
    }

    public void  fillList(Deque<Integer> d, int i){
        while (d.size() >=30){
            try{
                System.out.println(Thread.currentThread().getName()+ " is sleeping, deque size="+d.size());
                wait();
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
        int randomInt = random.nextInt(1,5000);
        System.out.println(String.format("Thread: %s, i=%s , adding num:%s", Thread.currentThread().getName(), i, randomInt));
        d.offerLast(randomInt);

    }
    public void pollList(Deque<Integer>d, int i){
        while (d.isEmpty()){
            try{
                System.out.println(Thread.currentThread().getName()+ " is sleeping, deque size="+d.size());
                //Thread.currentThread().wait(5000);
                wait();
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
        int removed = d.pollFirst();
        System.out.println(String.format("Thread: %s, i=%s , removed num:%s", Thread.currentThread().getName(), i, removed));
    }

}

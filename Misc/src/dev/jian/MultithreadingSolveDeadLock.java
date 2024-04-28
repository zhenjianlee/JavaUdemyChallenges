package dev.jian;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class MultithreadingSolveDeadLock {
    public static Random random = new Random();

    public static void main(String[] args) {

        Deque<Integer> d = new LinkedList<>();
        Random random = new Random();
        Integer count =500;

        MultithreadingSolveDeadLock m = new MultithreadingSolveDeadLock();

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

    public synchronized void  fillList(Deque<Integer> d, int i){
        while (d.size() >=30){
            try{
                System.out.println("---> "+Thread.currentThread().getName()+ " (fillList) is sleeping, deque size="+d.size() +" d="+ d.toString());
                //Thread.currentThread().wait(5000); //-> cannot use this, will cause deadlock. must use wait() and notifyAll()
                wait();
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
        int randomInt = random.nextInt(1,5000);
        System.out.println(String.format("Thread: %s, i=%s , adding num:%s", Thread.currentThread().getName(), i, randomInt));
        d.offerLast(randomInt);
        notifyAll();
    }
    public synchronized void pollList(Deque<Integer>d, int i){
        while (d.isEmpty()){
            try{
                System.out.println("---> "+Thread.currentThread().getName()+ " (pollList) is sleeping, deque size="+d.size()+" d="+d.toString());
                //Thread.currentThread().wait(5000); //-> cannot use this, will cause deadlock. must use wait() and notifyAll()
                wait();
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
        int removed = d.pollFirst();
        System.out.println(String.format("Thread: %s, i=%s , removed num:%s", Thread.currentThread().getName(), i, removed));
        notifyAll();
    }

}

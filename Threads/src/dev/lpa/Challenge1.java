package dev.lpa;

public class Challenge1 {

    public static void main(String[] args) {
        Thread thread1 = new JianThread();
        Thread thread2 = new Thread(()->{
            int num=1;
            for (int i=0; i<5; i++){
                System.out.print(num+" ");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    System.out.println("Odd thread was interrupted!");
                    e.printStackTrace();
                    break;
                }finally {
                    num+=2;
                }
            }
        });

        long now = System.currentTimeMillis();
        System.out.println("Starting thread1 and thread 2! at "+ now);
        thread1.start();
        thread2.start();

        while(true){
            if (System.currentTimeMillis()-3000 > now){
                System.out.println("\nInterrupting now! " + System.currentTimeMillis());
                thread1.interrupt();
                break;
            }
        }



    }


}

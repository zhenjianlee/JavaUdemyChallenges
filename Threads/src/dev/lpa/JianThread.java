package dev.lpa;

public class JianThread extends Thread{

    @Override
    public void run() {
        int num=0;
        for (int i=0; i<5;i++){
            num+=2;
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("Even thread was interrupted!");
                e.printStackTrace();
                break;
            }finally {
                System.out.print(num+" ");
            }
        }
    }
}

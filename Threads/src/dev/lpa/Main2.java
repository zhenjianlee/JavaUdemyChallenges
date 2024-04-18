package dev.lpa;

public class Main2 {

    public static void main(String[] args) {
        //Thread 1
        Thread thread = new Thread(()->{
            String tname = Thread.currentThread().getName();
            System.out.println(tname+" should take 10 dots to run");
            for (int i=0; i<10;i++){
                System.out.print(". ");
                try{
                    Thread.sleep(500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                    System.out.println("\nTHREAD "+tname+" WAS INTERRUPTED!");
                    System.out.println("A1. State="+Thread.currentThread().getState());
                    return;
                }
            }
            System.out.println(String.format("\n %s completed successfully",tname));
        });
        System.out.println(thread.getName()+" is starting!");
        thread.start();


        // dev.lpa.Main thread
        System.out.println("dev.lpa.Main thread running!");
        try{
            System.out.println("dev.lpa.Main thread paused for one second");
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("dev.lpa.Main thread would continue here");
        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        //Thread 2
        Thread installThread = new Thread(()->{
            for (int i=0; i<3 ; i++){
                try{
                    Thread.sleep(250);
                    System.out.println("Installation step + "+i+" is completed!");
                }catch (InterruptedException e){
                    e.printStackTrace();
                    System.out.println("Installtion was interrupted!");
                }

            }
        } , "InstallThread");

        installThread.start();
        // Interrupt thread after 2 seconds
//        long now = System.currentTimeMillis();
//        while (thread.isAlive()){
//            System.out.println("Waiting for thread to complete!");
//            try{
//                Thread.sleep(1000);
//                if (System.currentTimeMillis() - now > 2000){
//                    thread.interrupt();
//                }
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }


    }
}

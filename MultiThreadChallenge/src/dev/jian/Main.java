package dev.jian;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        ShoeWarehouse myWarehouse = new ShoeWarehouse();
        List<Order> generatedOrders= generateOrders(30);
        Thread t1 = new Thread(()->{
            for (int i=0; i<30;i++){
                myWarehouse.receiveOrder(generatedOrders.get(i));
            }
        });

        Thread t2= new Thread(()->{
            for (int i=0; i<15;i++){
                myWarehouse.fulfillOrder();
            }
        });

        Thread t3= new Thread(()->{
            for (int i=0; i<15;i++){
                myWarehouse.fulfillOrder();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }

    public static ArrayList<Order>generateOrders(int num){
        ArrayList<Order> generate=new ArrayList<>();
        Random random= new Random();
        for (int i=0;i<num;i++){
            int randomQuan = random.nextInt(100);
            String randomType = ShoeWarehouse.prodList.get(random.nextInt(5));
            generate.add(new Order(i,randomType,randomQuan,false));
        }
        return generate;
    }
}

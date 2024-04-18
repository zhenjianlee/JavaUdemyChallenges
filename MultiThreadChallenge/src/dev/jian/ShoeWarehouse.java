package dev.jian;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShoeWarehouse  {
    public static List<String> prodList;
    private Queue<Order> orders;
    private List<Order>fulfilledOrders;

    public ShoeWarehouse(){
        this.prodList = new ArrayList<>();
        prodList.add("Nike");
        prodList.add("Asics");
        prodList.add("Catterpillar");
        prodList.add("UnderArmour");
        prodList.add("RedWing");
        prodList.add("Bata");
        this.orders = new LinkedList<>();
        this.fulfilledOrders = new ArrayList<>();
    }
    public synchronized void receiveOrder(Order order){
        while(this.orders.size() >= 10){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        this.orders.offer(order);
        System.out.println(Thread.currentThread().getName()+" Received! "+ order.toString());
        notifyAll();
    }
    public synchronized void fulfillOrder(){
        while(this.orders.isEmpty()){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        Order curOrder = orders.poll();
        curOrder.setFullfilled(true);
        fulfilledOrders.add(curOrder);
        System.out.println(Thread.currentThread().getName()+" Fullfilled! "+ curOrder.toString());
        notifyAll();
    }
}

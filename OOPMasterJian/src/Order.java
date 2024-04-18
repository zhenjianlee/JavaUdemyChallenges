import java.util.Date;

public class Order {

    private String customer;
    private double total;
    private Burger burger;
    private Drink drink;
    private Item side;

    public Order(String customer, Burger burger, Drink drink, Item side){
        this.customer=customer;
        this.burger=burger;
        this.drink=drink;
        this.side=side;
        this.total=calculateTotal();
    }

    private double calculateTotal(){
        double burgPrice = burger.getTotalPrice();
        double drinkPrice = drink.getTotalPrice();
        double sidePrice = side.getPrice();
        return burgPrice+drinkPrice+sidePrice;
    }

    public void printReceipt(){
        System.out.printf(String.format("Customer:%s , Date=%s \n",this.customer,new Date()));
        System.out.println("----------------");
        burger.printItem();
        drink.printItem();
        side.printItem();
        System.out.println("----------------");
        System.out.println("Total price is: SGD"+ this.total);
        System.out.println("Thank you!");
    }


}

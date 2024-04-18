import java.nio.BufferOverflowException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Item side1 = new Item("Fries",5.45);
        Item side2 = new Item("Potato Wedges", 7.50);
        Item top1 = new Item("Avocado",3.50);
        Item top2 = new Item("Cheese",2.50);
        Item top3 = new Item("Bacon", 4.55);
        Item top4 = new Item("Pickles", 1.8);
        Item top5 = new Item("Good stuff", 15.00);
        Item top6 = new Item("Catnip",18.99);
        Drink cokeSmall = new Drink("Coca Cola",8.00,"small");
        Drink cokeLarge = new Drink("Coca Cola", 8.00, "large");
        Burger burger1 = new Burger("NormBurg",15.00,false,top1,top2,top3,null,null);
        Burger burger2 = new Burger("DeluxeBurg",15,true,null,null,null,null,null);
//        ArrayList<Item> curItems = new ArrayList<>();
//        curItems.add(side1);
//        curItems.add(side2);
//        curItems.add(top1);
//        curItems.add(top2);
//        curItems.add(top3);
//        curItems.add(top4);
//        curItems.add(top5);
//        curItems.add(top6);
//        curItems.add(cokeSmall);
//        curItems.add(cokeLarge);
//        curItems.add(burger1);
//        curItems.add(burger2);

//        for (Item i : curItems){
//            i.printItem();
//        }

        Order order1 = new Order("Jian",burger1,cokeLarge,side2);
        order1.printReceipt();

    }
}

public class Item {

    private String name;
    private double price;


    public Item(String name,double price){
        this.name=name;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printItem(){
        System.out.println(String.format("Item=%s , Price=SGD%s",this.name,this.price));
    }
}

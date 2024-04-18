public class Drink extends Item {
    private String size;
    private double priceAdj;
    public Drink(String name, double price, String size){
        super(name, price);
        size = size.toUpperCase();
        this.size = size;
        adjustPrice(size);
    }

    public double getTotalPrice(){
        return this.getPrice()+this.priceAdj;
    }

    private void adjustPrice(String input){
        switch (input){
            case ("SMALL") -> this.priceAdj=-1.5;
            case ("LARGE") -> this.priceAdj= 1.5;
            default -> this.priceAdj=0.00;
        }
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
        adjustPrice(size);
    }

    @Override
    public void printItem() {
        System.out.println(String.format("Item=%s, Base Price=SGD%s, Adj Price=SGD%s"
                , this.getName(), this.getPrice(), this.getPrice() + this.priceAdj));
    }
}

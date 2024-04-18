public class Burger extends Item {
    private Item top1;
    private Item top2;
    private Item top3;
    private Item top4;
    private Item top5;
    double priceAdj;
    boolean isDeluxe;

    public Burger(String name, double price,boolean isDeluxe, Item top1, Item top2, Item top3, Item top4, Item top5){
        super(name, price);
        this.isDeluxe= isDeluxe;
        this.top1=top1;
        this.top2=top2;
        this.top3=top3;
        this.top4=top4;
        this.top5=top5;
        adjustPrice();
    }

    public double getTotalPrice(){
        return this.getPrice()+this.priceAdj;
    }

    private void adjustPrice(){
        double top1price = top1 == null? 0: top1.getPrice();
        double top2price = top2 == null? 0: top2.getPrice();
        double top3price = top3 == null? 0: top3.getPrice();
        double top4price = top4 == null? 0: top4.getPrice();
        double top5price = top5 == null? 0: top5.getPrice();

        this.priceAdj = isDeluxe == true? 20.00 : top1price+top2price+top3price+top4price+top5price;
    }

    @Override
    public void printItem() {
        System.out.println(String.format("Item=%s, Base Price=SGD%s, Adj Price=SGD%s"
                , this.getName(), this.getPrice(), this.getPrice() + this.priceAdj));
        if(top1!=null)top1.printItem();
        if(top2!=null)top2.printItem();
        if(top3!=null)top3.printItem();
        if(top4!=null)top4.printItem();
        if(top5!=null)top5.printItem();

    }

    public Item getTop1() {
        return top1;
    }

    public void setTop1(Item top1) {
        this.top1 = top1;
    }

    public Item getTop2() {
        return top2;
    }

    public void setTop2(Item top2) {
        this.top2 = top2;
    }

    public Item getTop3() {
        return top3;
    }

    public void setTop3(Item top3) {
        this.top3 = top3;
    }

    public Item getTop4() {
        return top4;
    }

    public void setTop4(Item top4) {
        this.top4 = top4;
    }

    public Item getTop5() {
        return top5;
    }

    public void setTop5(Item top5) {
        this.top5 = top5;
    }

    public boolean isDeluxe() {
        return isDeluxe;
    }

    public void setDeluxe(boolean deluxe) {
        isDeluxe = deluxe;
    }
}

package dev.jian;

public class Order {
    private int id;
    private String type;
    private int quantity;

    private boolean isFullFilled;

    public Order(int id, String type, int quantity,boolean isFullFilled){
        this.id=id;
        this.type=type;
        this.quantity=quantity;
        this.isFullFilled=isFullFilled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ID="+this.id+", TYPE="+this.type+", QUANTITY="+this.quantity+", FULLFILLED="+this.isFullFilled;
    }

    public boolean isFullFilled() {
        return isFullFilled;
    }

    public void setFullfilled(boolean isFullFilled) {
        this.isFullFilled = isFullFilled;
    }
}

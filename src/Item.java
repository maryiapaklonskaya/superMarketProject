abstract class Item {
    private float price;
    static int count;

    public Item(float price){
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public static int getCount() {
        return count;
    }

    public void setCount() {
        Item.count = this.count + 1;
    }
}

abstract class Item {
    private float price;
    static int count;
    private Producer producer;
    private static String category;

    public Item(float price, Producer producer){
        this.price = price;
        this.producer = producer;
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

    public static String getCategory() {
        return category;
    }

    public void setCount() {
        Item.count = this.count + 1;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}

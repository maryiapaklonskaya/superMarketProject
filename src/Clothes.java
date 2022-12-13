import ENUMs.Type;

public class Clothes extends Item {
    private static String category = "Clothing";
    private Type type;
    private float size;
    private int id;
//    private static int count = 0;

    public Clothes(float price, Type type, float size) {
        super(price);
        this.size = size;
        this.type = type;
        id = super.getCount();
        super.setCount();
    }

    @Override
    public float getPrice() {
        return super.getPrice();
    }

    public Type getType() {
        return type;
    }

    public static String getCategory() {
        return category;
    }

    public float getSize() {
        return size;
    }

//    public int getId() {
//        return id;
//    }


    @Override
    public void setPrice(float price) {
        super.setPrice(price);
    }

    public void setSize(float size) {
        this.size = size;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return "\nid: " + id + " type: " + type + " size: " + size + " price: " + getPrice();
    }
}

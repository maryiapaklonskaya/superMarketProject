import ENUMs.Type;

public class Clothes extends Item {
    private static String category = "Clothing";
    private Type type;
    private float size;
    private int id;
//    private static int count = 0;

    public Clothes(float price, Type type, float size, Producer producer) {
        super(price, producer);
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

    public int getId() {
        return id;
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
        return "\nid: " + id + " type: " + type + " size: " + size + " price: " + getPrice() + " producer: " + getProducer().getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clothes clothes = (Clothes) o;
        return (type.equals(clothes.getType()) && (size == clothes.getSize()) && (id == clothes.getId()));
    }

    @Override
    public int hashCode(){
        int result = 17 * (type.hashCode() + ((Float) size).hashCode() + ((Integer) id).hashCode());
        return result;
    }
}

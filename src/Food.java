import ENUMs.FoodType;

public class Food extends Item{
    private static String category = "Food";
    private String name;
    private int calories;
    private FoodType foodType;
    private boolean containsAllergens;
    private int id;

    public Food(float price, String name, int calories, FoodType foodType, boolean containsAllergens){
        super(price);
        this.name = name;
        this.calories = calories;
        this.foodType = foodType;
        this.containsAllergens = containsAllergens;
        id = super.getCount();
        super.setCount();
    }

    @Override
    public float getPrice() {
        return super.getPrice();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public int getCalories() {
        return calories;
    }

    public static String getCategory() {
        return category;
    }

    @Override
    public void setPrice(float price) {
        super.setPrice(price);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setContainsAllergens(boolean containsAllergens) {
        this.containsAllergens = containsAllergens;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    @Override
    public String toString(){
        return "\nid: " + id + " name: " + name + "\ncalories: " + calories + " FoodType: " + foodType + "\ncontains allergens: " + containsAllergens + "\nprice: " + getPrice();

    }
}

/*
        "clothing": [ { id: 1, type: DEMO(enum), producer: "John Doe", price: "$500"}, { id: 2, type: DEMO(enum), producer: "John Doe", price: "$500"}]

        Create interface for categories. clothing => "shoe", "pants", "shirts".
        Item (Clothing, dairy, toys) { type, category }

        // public static Map<String, List<Item>> map = new HashMap();

        "clothing": [Item {type: "shoe",}]
     */

import ENUMs.FoodType;
import ENUMs.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuperMarket {


    public static void main(String[] args) {
        Clothes clothes1 = new Clothes(29.99f, Type.SHOES, 36.0f);
        Clothes clothes2 = new Clothes(45.55f, Type.SHIRT, 42.0f);
        Clothes clothes3 = new Clothes(33.33f, Type.PANTS, 94.0f);

        Food food1 = new Food(5.99f, "sandwich with tuna", 250, FoodType.GROCERIES, true);
        Food food2 = new Food(1.99f, "black tea", 50, FoodType.DRINKS, false);
        Food food3 = new Food(15.99f, "beef stake", 750, FoodType.MEAT, false);



        List<Item> clothesList = new ArrayList<>();
        clothesList.add(clothes1);
        clothesList.add(clothes2);
        clothesList.add(clothes3);

        List<Item> foodList = new ArrayList<>();
        foodList.add(food1);
        foodList.add(food2);
        foodList.add(food3);


        Map<String, List<Item>> map = new HashMap();
        map.put(Clothes.getCategory(), clothesList);
        map.put(Food.getCategory(), foodList);

//        for(Item cloth: clothesList){
//            System.out.println(cloth.toString());
//        }

        System.out.println(map.get("Clothing"));
        System.out.println(map.get("Food"));

    }

}

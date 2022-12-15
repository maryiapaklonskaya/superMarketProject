/*
        "clothing": [ { id: 1, type: DEMO(enum), producer: "John Doe", price: "$500"}, { id: 2, type: DEMO(enum), producer: "John Doe", price: "$500"}]

        Create interface for categories. clothing => "shoe", "pants", "shirts".
        Item (Clothing, dairy, toys) { type, category }

        // public static Map<String, List<Item>> map = new HashMap();

        "clothing": [Item {type: "shoe",}]
     */

import ENUMs.FoodType;
import ENUMs.Type;

import java.util.*;

public class SuperMarket {
    public static Map<String, List<Item>> map = new HashMap();
    public static List<Producer> producersList = new ArrayList<>();
    public static List<Customer> customersList = new ArrayList<>();
    // add collection of producers  ( name, totalRevenue )
    // add collection of customers ( name, balance, email, phone )


    public static void main(String[] args) {
        Producer producer1 = new Producer("nike", 111d);
        Producer producer2 = new Producer("adidas", 222d);
        Producer producer3 = new Producer("reebok", 333d);

        Clothes clothes1 = new Clothes(29.99f, Type.SHOES, 36.0f, producer1);
        Clothes clothes2 = new Clothes(45.55f, Type.SHIRT, 42.0f, producer1);
        Clothes clothes3 = new Clothes(33.33f, Type.PANTS, 94.0f, producer1);

        Food food1 = new Food(5.99f, "sandwich with tuna", 250, FoodType.GROCERIES, true, producer1);
        Food food2 = new Food(1.99f, "black tea", 50, FoodType.DRINKS, false, producer1);
        Food food3 = new Food(15.99f, "beef stake", 750, FoodType.MEAT, false, producer1);

        Customer customer1 = new Customer("Maryia", 123d);
        Customer customer2 = new Customer("Crowley", 0d);
        Customer customer3 = new Customer("Vlad", 456d);

        clothes3.setProducer(producer3);


        List<Item> clothesList = new ArrayList<>();
        clothesList.add(clothes1);
        clothesList.add(clothes2);
        clothesList.add(clothes3);

        List<Item> foodList = new ArrayList<>();
        foodList.add(food1);
        foodList.add(food2);
        foodList.add(food3);

        //List<Producer> producersList = new ArrayList<>();
        producersList.add(producer1);
        producersList.add(producer2);
        producersList.add(producer3);

        //List<Customer> customersList = new ArrayList<>();
        customersList.add(customer1);
        customersList.add(customer2);
        customersList.add(customer3);


        //Map<String, List<Item>> map = new HashMap();
        map.put(Clothes.getCategory(), clothesList);
        map.put(Food.getCategory(), foodList);

//

        System.out.println(map.get("Clothing"));
        System.out.println(map.get("Food"));

        //printCatalogue();
        //printCategories();
        //printProducers();
        //printCustomers();

        System.out.println(clothes1.equals(clothes2));

        comparingItems("Clothing");

    }

    public static void printCatalogue(){
        for(Map.Entry<String, List<Item>> entry: map.entrySet()) {
            String key = entry.getKey();
            List<Item> itemList = entry.getValue();
            System.out.println(key + "===>");
            for(Item item: itemList){
                System.out.println(item.toString() + "|");
            }
        }
    }

    public static void printCategories(){
        for(String key: map.keySet()){
            for(Item item: map.get(key)){
                System.out.println(item.toString());
            }
        }
    }

    public static void printProducers(){
        for(Producer p: producersList){
            System.out.println(p);
        }
    }

    public static void printCustomers(){
        for(Customer c: customersList){
            System.out.println(c);
        }
    }

    public static void comparingItems(String category) {
        List<Item> items = map.get(category);
        Map<String, List<Item>> temp = new HashMap<>();

        for (Item item : items) {
            if (temp.containsKey(item.getCategory())) {
                temp.get(item.getName()).add(item);
            } else {
                List<Item> itemsSorted = new ArrayList<>();
                itemsSorted.add(item);
                temp.put(item.getName(), itemsSorted);
            }
        }

        map.forEach((key, value) -> System.out.println(key + ":" + value));
    }



}

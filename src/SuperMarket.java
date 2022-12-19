/*
        "clothing": [ { id: 1, type: DEMO(enum), producer: "John Doe", price: "$500"}, { id: 2, type: DEMO(enum), producer: "John Doe", price: "$500"}]

        Create interface for categories. clothing => "shoe", "pants", "shirts".
        Item (Clothing, dairy, toys) { type, category }

        // public static Map<String, List<Item>> map = new HashMap();

        "clothing": [Item {type: "shoe",}]
     */

import ENUMs.FoodType;
import ENUMs.Type;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class SuperMarket {
    public static Map<String, List<Item>> map = new HashMap();
    public static List<Producer> producersList = new ArrayList<>();
    public static List<Customer> customersList = new ArrayList<>();
    // add collection of producers  ( name, totalRevenue )
    // add collection of customers ( name, balance, email, phone )


    public static void main(String[] args) {
        Producer producer1 = new Producer("mike", 111d);
        Producer producer2 = new Producer("nike", 222d);
        Producer producer3 = new Producer("nikes", 333d);
        Producer producer4 = new Producer("nikez", 333d);
        Producer producer5 = new Producer("nike prod", 333d);



        Clothes clothes1 = new Clothes(29.99f, Type.SHOES, 36.0f, producer1);
        Clothes clothes2 = new Clothes(45.55f, Type.SHIRT, 42.0f, producer2);
        Clothes clothes3 = new Clothes(33.33f, Type.PANTS, 94.0f, producer3);

        Food food1 = new Food(5.99f, "sandwich with tuna", 250, FoodType.GROCERIES, true, producer1);
        Food food2 = new Food(1.99f, "black tea", 50, FoodType.DRINKS, false, producer5);
        Food food3 = new Food(15.99f, "beef stake", 750, FoodType.MEAT, false, producer2);
        Food food4 = new Food(15.99f, "beef stake1", 750, FoodType.MEAT, false, producer4);
        Food food5 = new Food(15.99f, "beef stake", 750, FoodType.MEAT, false, producer3);
        Food food6 = new Food(15.99f, "beef stake", 750, FoodType.MEAT, false, producer4);

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
        foodList.add(food4);
        foodList.add(food5);
        foodList.add(food6);

        

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

//        System.out.println(map.get("Clothing"));
//        System.out.println(map.get("Food"));

        //printCatalogue();
        //printCategories();
        //printProducers();
        //printCustomers();

        //System.out.println(clothes1.equals(clothes2));

        //comparingItems("Food");
        sortByProducer();


        FileInputStream in = null;
        FileOutputStream out = null;

        try{
            in = new FileInputStream("src/files/customers.txt");
            out = new FileOutputStream("src/files/sorted-customers.txt");
            List<String> namesList = new ArrayList<>();

            int c = in.read();
            namesList.add(String.valueOf(c));

            while(c != -1){
                c = in.read();
                namesList.add(String.valueOf(c));
            }

            namesList.stream().sorted(Comparator.naturalOrder());
            for(String item: namesList){
                out.write(c);
            }

        }catch(Exception ex){
            ex.printStackTrace();

        }

        //customersSort();

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

        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
                if(i1.getPrice() == i2.getPrice()){
                    return ((int) i1.getProducer().getName().charAt(0) - (int) i2.getProducer().getName().charAt(0));
                }else{
                    return ((int) i1.getPrice() - (int) i2.getPrice());
                }
            }

        });

        for (Item item : items) {
            System.out.println("price: " + item.getPrice() + " producer: " + item.getProducer().getName());
        }
    }

    public static void sortByProducer() {
        List<Item> temp;
        List<Item> allItems = new ArrayList<>();

        for (Map.Entry<String, List<Item>> entry : map.entrySet()) {
            temp = entry.getValue();
            for (Item item : temp) {
                allItems.add(item);
            }
        }

        System.out.println("======================================================");
        for (Item item : allItems) {
            System.out.println(item);
        }
        System.out.println("======================================================");


        Collections.sort(allItems, new Comparator<Item>() {
            @Override
            public int compare(Item i1, Item i2) {
                //
                int length;
                int result;

                if (i1.getProducer().getName().length() > i2.getProducer().getName().length()) {
                    length = i2.getProducer().getName().length();
                } else {
                    length = i1.getProducer().getName().length();
                }

                for (int i = 0; i <= length; i++) {
                    //maybe we should simply check if all characters were checked
                    if(i >= i2.getProducer().getName().length()){
                        return 1;
                    }else if(i >= i1.getProducer().getName().length()){
                        return -1;
                    }else {
                        result = (int) i1.getProducer().getName().charAt(i) - (int) i2.getProducer().getName().charAt(i);
                        if (result != 0) {
                            return result;
                        }
                    }
                }
                return 0;
            }
        });

        for (Item item : allItems) {
            System.out.println(item);
        }

    }

//    public static void customersSort(){
//        Collections.sort(customersList);
//
//
//        FileOutputStream out = null;
//
//        try{
//            out = new FileOutputStream("src/files/sorted-customers.txt");
//            for(Customer c: customersList){
//                out.write(c);
//            }
//
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//    }






}

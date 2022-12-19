import java.io.*;
import java.util.*;

public class InOut {

    public static void main(String[] args) {
        customersFromFile();
        for (Customer c : SuperMarket.customersList) {
            System.out.println(c);
        }
    }

    public static void customersFromFile() {
        BufferedReader in = null;
        BufferedWriter out = null;
        String[] strings;
        StringBuilder str = new StringBuilder("");
        String line;

        try {
            in = new BufferedReader(new FileReader("src/files/customers.txt"));
            out = new BufferedWriter(new FileWriter("src/files/sorted-customers.txt"));

            line = in.readLine();

            while (line != null) {
                strings = line.split(" ");
                String name = strings[0];
                Double balance = Double.parseDouble(strings[1]);

                Customer newCustomer = new Customer(name, balance);
                SuperMarket.customersList.add(newCustomer);

                line = in.readLine();

            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


//        public static void sortedCustomers(){
//            BufferedReader in = null;
//            String[] strings;
//            StringBuilder str = new StringBuilder("");
//            String line;
//
//            try {
//                in = new BufferedReader(new FileReader("src/files/customers.txt"));
//                out = new BufferedWriter(new FileWriter("src/files/sorted-customers.txt"));
//
//                line = in.readLine();
//
//                List<String> strList = new ArrayList<>();
//
//                while ((line = in.readLine()) != null) {
//                    strings = line.split("\\$");
//                    String name = strings[0];
//                    Double balance = (Double) strings[1];
//                    Customer newCustomer = new Customer(name, balance);
//                    SuperMarket.customersList.add(newCustomer);
//
//                }
//
//                Collections.sort(strList);
//                strList.sort(Comparator.naturalOrder());
//                System.out.println(Arrays.toString(strList.toArray()));
//                for (String s : strList) {
//                    out.write(s);
//                }
//            } catch (IOException e){
//                e.printStackTrace();
//            } finally{
//                if(in != null){
//                    try{
//                        in.close();
//                    } catch(IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//
//
//        }


    }
}


package duke.choice;

import duke.choice.clothes.LongSleeve;
import duke.choice.clothes.Size;
import duke.choice.Clothing;
import duke.choice.C;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.NumberFormat;
import java.util.Arrays;

public class ShopApp {
    public static void main(String[] args){
        /*Size s = new Size();
        int x = 123_456;
        s.setSize();

        System.out.println(s.getSize());
        System.out.println(1.2>3);
        System.out.println(x);*/

        //welcome message
        System.out.println("Welcome to Duke Choice Shop");

        //minimum price as static class variable
        System.out.println("Min Price " + Clothing.MIN_PRICE);

        //set customer parameters using constructor args
        Customer c1 = new Customer("Max", 3);
        System.out.println("Customer is: " + c1.getName() + " | " + c1.getSize());

        double tax = 0.2; //20% tax rate
        double total = 0; //customer needs to pay this amount
        //create an array of clothing items
        Clothing item1 = new Clothing("Blue Jacket", 20.9, "M");
        Clothing item2 = new Clothing("Orange T-Shirt", 10.5, "S");
        Clothing[] items = {item1, item2, new Clothing("Green Scarf", 5.0, "S"), new Clothing("Blue T-Shirt", 10.5, "S")};
        //associate items with customer
        c1.addItems(items);

        System.out.println("\nItem List:");
        for (Clothing item: c1.getItems()){
            if(item.getSize().equals(c1.getSize())) {
                total = total + item.getPrice();
                System.out.println(item.getDescription() + ", " + item.getPrice() + ", " + item.getSize());
            }
        }
        System.out.println("WITHOUT TAX: " + NumberFormat.getCurrencyInstance().format(total));
        System.out.printf("WITH TAX: %s\n",c1.getTotalClothingCost());

        int average = 0;
        int count =0;

        for (Clothing item: c1.getItems()){
            if(item.getSize().equals("L")) {
                count++;
                average += item.getPrice();
            }
        }
        //solve division by 0 with a try/catch
        try {
            average = average / count;
        } catch(ArithmeticException e){
            System.out.println("Division by 0");
        }
        //or fix programming mistake/code better
        average = (count == 0) ? 0 : average / count;

        System.out.println("Average price is: "+average);
        LongSleeve red = new LongSleeve();
        red.setDescription("WOOF");
        red.setPrice(5);
        red.wow();
        red.test();

        C testClass = new C();
        testClass.grandChildMethod();
        System.out.println(item1); //test override toString

        System.out.println("\n***\nUNORDERED:");
        for (Clothing item: c1.getItems()){
            System.out.println(item);
        }
        System.out.println("\n***\nORDERED:");
        Arrays.sort(c1.getItems());
        for (Clothing item: c1.getItems()){
            System.out.println(item);
        }

        /*
        ORACLE CLOUD DEPLOYMENT
         */

        try {
            ItemList list = new ItemList(c1.getItems());

            Routing routing = Routing.builder().get("/items", list).build();

            ServerConfiguration config = ServerConfiguration.builder().bindAddress(InetAddress.getLocalHost()).port(8888).build();

            WebServer ws = WebServer.create(config,routing);
            ws.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
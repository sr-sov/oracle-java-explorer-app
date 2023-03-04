package duke.choice;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Customer {

    private String name;
    private String size;

    private Clothing[] items;

    public Customer() {
    }

    public Customer(String name, int measurement) {
        this.name = name;
        setSize(measurement);
    }

    public void addItems(Clothing[] someItems) {
        items = someItems;
    }

    public Clothing[] getItems() {
        return items;
    }

    public String getTotalClothingCost() {

        double total = 0.0;
        for (Clothing item : this.getItems()) {
            if(item.getSize().equals(this.getSize())) {
                total = total + item.getTaxedPrice();
            }
        }
        BigDecimal biggie = new BigDecimal(total);
        return currencyFormat(biggie);
    }
    public static String currencyFormat(BigDecimal n) {
        return NumberFormat.getCurrencyInstance().format(n);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setSize(int measurement) {
        switch (measurement) {
            case 1:
            case 2:
            case 3:
                setSize("S");
                break;
            case 4:
            case 5:
            case 6:
                setSize("M");
                break;
            case 7:
            case 8:
            case 9:
                setSize("L");
                break;
            default:
                setSize("XL");
        }
    }

    public double getAverage(){
        double average;
        int aveInt=0;
        int total = 0;
        int count=0;
        for (Clothing item : this.getItems()) {
            if(item.getSize().equals("L")) {
                total = (int) item.getPrice();
                count++;
            }
        }
        aveInt = total/count;
        average = aveInt;
        return average;
    }

}

package duke.choice;

public class Clothing implements Comparable<Clothing>{
    private String description = "";
    private double price;
    private String size = "M";
    public static final double MIN_PRICE = 10;
    public static final double TAX = 0.2;

    public Clothing() {
    }

    public Clothing(String description, double price, String aSize) {
        this.description = description;
        this.price = price;
        size = aSize;
    }

    @Override
    public int compareTo(Clothing anItem) {
        return description.compareTo(anItem.getDescription());
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public double getTaxedPrice() {
        double taxedPrice = price+(price*TAX);
        return taxedPrice;
    }

    public void setPrice(double price) {
        this.price = ( price > MIN_PRICE ? price : MIN_PRICE);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString(){
        return getDescription() + ", " + getPrice() + ", " + getSize();
    }

}

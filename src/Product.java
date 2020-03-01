import java.util.Date;

public class Product {

    private String productName;
    private Manufacturer brand;//acc_no
    private double price;
    private int quantity;



    public Product(String name, Manufacturer brand, int quantity, double price ) {
        this.productName = name;
        this.brand = brand;
        this.quantity = quantity;
        this.price = price;

    }


    public String getName() {

        return productName;
    }

    public Manufacturer getBrand() {
        return brand;
    }


    public int getQuantity() {

        return quantity;
    }

    public void addQuantity(int qua) {

        this.quantity = quantity +qua;
    }

    public void withDrawQuantity (int que){
        this.quantity = quantity-que;
    }

    public double getPrice() {

        return price;
    }

    public void increasePrice(double p) {

        this.price += p;
    }
    public void decreasePrice(double e) {

        this.price -= e;
    }

}

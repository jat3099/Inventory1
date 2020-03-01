import java.text.DateFormat;
import java.util.Date;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {


        DataBase db = new DataBase();  // Creating database for active accounts
        DataBase close = new DataBase();   // Creating database for inactive accounts
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
        Date now = new Date();
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        boolean done = false;

        while (!done) {
            int menu = GetData.getInt("\tUnited Bank of Java\n"
                    + "\nPlease Choose From the Following:" + "\n1. Add a new product \n2. Update Existing item "
                    + "\n3. change the price of an item \n4. View Account Information\n5. Exit");
            switch (menu) {
                    case 1: //Creating a item object and storing it in the database



                    String st = GetData.getString("enter the Company's State");
                    Address addr = new Address( st);

                    String pn = GetData.getString("Enter name of the manufacturer");
                    Manufacturer manufacturer = new Manufacturer(pn, addr);


                    String name = GetData.getString("Enter name of the item (ex. tv or cellphone) ");

                    int quantity = GetData.getInt("enter the quantity ");

                    double price = GetData.getDouble("enter the price ");

                    Product product = new Product(name,manufacturer,quantity,price);

                    db.addProduct(product);
                    break;

                    case 2://update product

                        name = GetData.getString("enter the company the item you want to update ");
                        int index = db.search(name);

                        if(!db.inList()){
                            JOptionPane.showInputDialog(null,"item not found");

                        }else{

                            int option=GetData.getInt("press 1 for ordering 2 for selling and 3 for delete");
                            switch (option){

                                case 1://increasin quantity

                                    int amount = GetData.getInt("enter number of items to order");
                                    Product p = db.getAccount(index);
                                    p.addQuantity(amount);
                                    break;
                                case 2://deacreasing number of items in inventory
                                    int amt = GetData.getInt("enter the number you need to substract");
                                    Product a = db.getAccount(index);
                                    a.withDrawQuantity(amt);
                                    break;
                                case 3://deleting an item from inventory
                                    name = GetData.getString("enter the item to be deleted");
                                    index = db.search(name);
                                   if(!db.inList()) {
                                       JOptionPane.showMessageDialog(null, "item not found");
                                   }else{
                                       Product s = db.getAccount(index);
                                       db.delete(index);
                                       close.addProduct(s);
                                       JOptionPane.showMessageDialog(null,"the iteam "+ name +" has been taken out");

                                   }break;

                            }break;
                        }
                    case 3://modifiying quantity and price and delete item
                        name = GetData.getString("enter the item name which price needs to be modified ");
                        db.search(name);

                        if(!db.inList()){
                            JOptionPane.showInputDialog(null,"item not found");

                        }else{
                            int opt = GetData.getInt("press 1 to encrease or 2 to decrease quantity");

                                    switch (opt){

                                        case 1:
                                            double pri = GetData.getDouble("Enter the to amount to increase price  ");
                                            index = db.search(name);
                                            Product q = db.getAccount(index);
                                            q.increasePrice(pri);
                                            break;
                                        case 2:
                                            double pric = GetData.getDouble("enter the amount to decrease price ");
                                            index = db.search(name);
                                            Product w = db.getAccount(index);
                                            w.decreasePrice(pric);
                                            break;
                                    }
                        } break;

                    case 4://view item
                        int view = GetData.getInt("to view a single item press 1 and to view whole inventory press 2 and 3 to view deleted items");

                        switch (view){

                            case 1://viewing a single item
                                name = GetData.getString("enter the name of item like samsung ");
                                int ind = db.search(name);

                                if(!db.inList()){
                                    JOptionPane.showMessageDialog(null,"Item not found in database ");

                                }else {
                                    Product bb = db.getAccount(ind);
                                    String q = "Acc# " + bb.getName() + "\nPrice " + bb.getPrice() + "\nQuantity " +
                                            bb.getQuantity();
                                    System.out.println(q);


                                }
                                break;
                            case 2://view the whole inventory
                                if(db.isEmpty()){
                                    JOptionPane.showMessageDialog(null," the list is empty");
                                }else
                                {
                                    int i=0, length = db.size();
                                    String s = "Product\tPurchase Date\tQuantity\tPrice\tManufacturer\tState\n\n";
                                    while( i<length)
                                    {
                                        Product t = db.getAccount(i);
                                        s = s + t.getName() + "\t" + "\t" + t.getQuantity() + "\t" + t.getPrice() + "\t" +
                                                t.getBrand().getCompanyName() + "\t" +
                                                t.getBrand().getCompanyAddress().getState() + "\n";
                                        i++;
                                    }
                                    GetData.display("Inventory", s, 20, 50);

                                }
                                break;
                            case 3://delete item form inventory
                                if(close.isEmpty()){
                                    JOptionPane.showMessageDialog(null," the list is empty");
                                }else
                                {
                                    int i=0, length = close.size();
                                    String w = "Product\tPurchase Date\tQuantity\tPrice\tManufacturer\tState\n\n";
                                while (i<length){
                                    Product t = close.getAccount(i);

                                    w = w + t.getName() + "\t" + "\t" + t.getQuantity() + "\t" + t.getPrice() + "\t" +
                                            t.getBrand().getCompanyName() + "\t" +
                                            t.getBrand().getCompanyAddress().getState() + "\n";
                                    i++;

                                    }
                                    GetData.display("Inventory of deleted items", w, 20, 50);
                                }


                        }

                        break;
                case 5:
                    done = true;
                    break;
            }
            }


        }
    }
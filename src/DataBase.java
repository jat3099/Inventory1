import java.util.ArrayList;

public class DataBase {

    private ArrayList <Product> list;
    Product ma;
    boolean found;
    int index;

    DataBase(){

        list = new ArrayList<Product>();
    }

    int search(String key){

        found = false;
        int i=0;
        int index = -1;

        while (!found && i < list.size()){

            Product m = list.get(i);
            if(m.getName().equalsIgnoreCase(key))
            {
                found = true;
                index = i;

            } else i++;
        }

        return index;
    }

    void addProduct(Product m){
        list.add(m);
    }

    Product delete(int i){
         return list.remove(i);
    }
    int getIndex(){
        return index;
    }


    boolean inList(){
        return found;
    }

    Product getAccount(int index){//bransName
        ma = list.get(index);
        return ma;
    }
    int size(){

        return list.size();
    }

    boolean isEmpty(){
        return list.isEmpty();
    }

    ArrayList getList(){
        return list;
    }

}

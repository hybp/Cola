import java.util.ArrayList;
import java.util.Objects;
import java.util.Collections;

public class VendingMachine {
    public ArrayList<Integer> getInsertedCoins() {
        Collections.sort(insertedCoins);
        return insertedCoins;
    }

    // ArrayList of Integers represents inserted coins in Coin Slot private ArrayList<Integer> insertedCoins;
    private ArrayList<Integer> insertedCoins;
    private ArrayList<Product> products;
    public final int[] coinUnits = {1,2,5,10};

    // ArrayList of Product represents inventories of products

    public VendingMachine() {
        insertedCoins = new ArrayList<Integer>();
        products = new ArrayList<Product>();
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void insertCoin(Integer c) {
        insertedCoins.add(c);
        /* You may add other properties and methods */
    }
    public void dropProduct(Product p) {
        for (Product product : products) {
            if (Objects.equals(product, p)) {
                product.dropQuantity();
            }
        }
    }

    public Product getProduct(String pName) {
        for (Product product : products) {
            if (Objects.equals(product.getName(), pName)) {
                return product;
            }
        }
        return null;
    }
    public int[] coinChanger(int changeAmount) {
        // returns 'changes' which stores [how many coins] following the same order as coinUnits array

        int[] changes = new int[4];
        // Since there are 4 currency units (fixed), use normal array

        for (int i = coinUnits.length - 1; i >= 0; --i) {
            // from the biggest coin, iterate down the change amount
            int noOfCoins = changeAmount / coinUnits[i];

            if (noOfCoins > 0) {
                changes[i] = noOfCoins;
                changeAmount -= coinUnits[i] * noOfCoins;
            }
        }
        return changes;
    }
    public void clearCoins(){
        insertedCoins.clear();
    }
    public int getTotalCoin() {
        int sum = 0;
        for (int i :insertedCoins) {
            sum += i;}
        return sum;
    }

}
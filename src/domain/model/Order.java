package domain.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Order {
    private Person person;
    private List<Product>products;
    private int id;
    private List<Integer> productId;
    private int personId;

    public Order(Person person, List<Product> products){
        setPerson(person);
        setProducts(products);
    }

    public Order(){
        this(null, new ArrayList<>());
    }

    public void setPerson(Person person){
        this.person = person;
    }

    public void setProducts(List<Product> products){
        this.products = products;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public String getPerson(){
        return this.person.getName();
    }

    public String getAdress(){
        return person.getAdres();
    }

    public String getPostalcode(){
        return person.getPostalCode();
    }

    public List<Product> getProducts() {
        return products;
    }

    public HashMap<Product, Integer> getProductAmounts() {
        HashMap<Product, Integer> ret = new HashMap<>();
        for(Product p : products) {
            if(!ret.containsKey(p) || ret.get(p) == 0) {
                ret.put(p, 1);
            }
            else {
                ret.put(p, ret.get(p) + 1);
            }
        }
        return ret;
    }

    public void setOrderId(int id){
        this.id = id;
    }

    public void setProductId(List<Integer> id){
        this.productId = id;
    }

    public void setPersonId(int id){
        this.personId = id;
    }

    public List<Integer> getProductId(){
        List<Integer>productIds = new ArrayList<>();
        for (Product product : products) {
            productIds.add(product.getProductId());
        }
        return productIds;
    }

    public int getOrderId(){
        return this.id;
    }

    public int getPersonId(){
        return this.personId;
    }

    public int getTotal() {
        int total = 0;
        for(Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

}

package domain.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Person person;
    private List<Product>products;
    private int id;
    private int productId;
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

    public void setOrderId(int id){
        this.id = id;
    }

    public void setProductId(int id){
        this.productId = id;
    }

    public void setPersonId(int id){
        this.personId = id;
    }

    public int getProductId(){
        return productId;
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

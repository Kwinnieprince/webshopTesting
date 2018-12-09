package domain.model;

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
        this(null, null);
    }

    public void setPerson(Person person){
        if(person != null){
            this.person = person;
        }
    }

    public void setProducts(List<Product> products){
        if(products != null || products.size() != 0 ){
            this.products = products;
        }
    }

    public Person getPerson(){
        return this.person;
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

}

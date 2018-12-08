package domain.model;

import java.util.List;

public class Order {
    private Person person;
    private List<Product>products;

    public Order(Person person, List<Product> products){
        setPerson(person);
        setProducts(products);
    }

    private void setPerson(Person person){
        if(person != null){
            this.person = person;
        }
    }

    private void setProducts(List<Product> products){
        if(products != null || products.size() != 0 ){
            this.products = products;
        }
    }
}

package domain.db;

import domain.model.Order;
import domain.model.Person;
import domain.model.Product;
import java.util.List;
import java.util.Properties;

public class ShopService {
    private Properties properties;
    ProductDb productDb;
    PersonDb personDb;
    OrderDb orderDb;

    public ShopService(Properties properties){
        this.properties = properties;
        productDb = new ProductDBPostgres(properties);
        personDb = new PersonDbPostgres(properties);
        orderDb = new OrderDBPostgres(properties);
    }

    public Product getProduct(int id){
        return productDb.get(id);
    }

    public List<Product>getAll(){
        return productDb.getAll();
    }

    public void updateProduct(Product product){
        productDb.update(product);
    }

    public void addProduct(Product product){
        productDb.add(product);
    }

    public void deleteProduct(int id) {
        productDb.delete(id);
    }

    public int getNumberOfProducts(){
        return productDb.getNumbeOfProducts();
    }

    public Person getPerson(int id){
        return personDb.get(id);
    }

    public List<Person>getAllPersons(){
        return personDb.getAll();
    }

    public void updatePerson(Person person){
        personDb.update(person);
    }

    public void addPerson(Person person){
        personDb.add(person);
    }

    public void deletePerson(int id) {
        personDb.delete(id);
    }

    public int getNumberOfPersons(){
        return personDb.getNumberOfPersons();
    }

    public List<Order>getAllOrders(){
        return orderDb.getAll();
    }

    public int generatePersonId(){
        return personDb.generateId();
    }

    public void addOrder(Order order){
        orderDb.add(order);
    }

    public int generateOrderId(){
        return productDb.generateId();
    }
}

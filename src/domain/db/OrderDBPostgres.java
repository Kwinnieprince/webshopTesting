package domain.db;

import domain.model.Order;
import domain.model.Person;
import domain.model.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class OrderDBPostgres implements OrderDb {
    private Properties properties;
    private String url; // = "jdbc:postgresql://databanken.ucll.be:61819/2TX38";

    public OrderDBPostgres(Properties properties) {
        this.properties = properties;
        this.url = properties.getProperty("url");
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new DbException(e.getMessage(), e);
        }
    }

    @Override
    public Order get(int id) {
        List<Order> orders = new ArrayList<>();
        System.out.println(id);
        String sql = "SELECT * from testing.products where id=" + id;
        Order order = new Order();
        try(Connection connection = DriverManager.getConnection(url, properties);
            Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery(sql);
            while (result.next()){
                order.setOrderId(result.getInt("id"));
                //order.setPersonId(result.getInt("person_id"));
                //order.setProductId(result.getInt("product_id"));
                //orders.add(order);
            }
        }catch (SQLException e) {
            throw new DbException(e);
        }
        return order;
    }

    @Override
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<Order>();
        try(Connection connection = DriverManager.getConnection(url,properties);
            Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery("SELECT * FROM testing.orders");
            Order order = new Order();
            int orderId = 0;
            while (result.next()){
                int id = result.getInt("id");
                if(orderId == id){
                    order.addProduct(getProduct(result.getInt("product_id")));
                }else{
                    order = new Order();
                    order.addProduct(getProduct(result.getInt("product_id")));
                }
                order.setPerson(getPerson(result.getInt("person_id")));
                orderId = id;
                orders.add(order);
            }
        }catch (SQLException e){
            throw new DbException(e);
        }
        return orders;
    }

    private Person getPerson(int id){
        Person person = new Person();
        try(Connection connection = DriverManager.getConnection(url,properties);
            Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery("SELECT * FROM testing.persons where id="+id);
            while (result.next()){
                person.setId(result.getInt("id"));
                person.setName(result.getString("name"));
                person.setAdres(result.getString("adres"));
                person.setPostalCode(result.getString("postal_code"));
                return person;
            }
        }catch (SQLException e){
            throw new DbException(e);
        }
        return person;
    }

    private Product getProduct(int id){
        Product product = new Product();
        try(Connection connection = DriverManager.getConnection(url,properties);
            Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery("SELECT * FROM testing.products where id="+id);
            while (result.next()){
                product.setPrice(result.getDouble("price"));
                product.setDescription(result.getString("description"));
                product.setName(result.getString("name"));
                return product;
            }
        }catch (SQLException e){
            throw new DbException(e);
        }
        return product;
    }

    @Override
    public void add(Order order){
        if(order == null){
            throw new DbException("Nothing to add");
        }
        String sql = "INSERT INTO testing.orders (id, person_id, product_id) VALUES(?,?,?);";
        //String sql = "INSERT INTO r0712411web.products VALUES(" + product.getProductId() + ",'" + product.getName() + "','" + product.getDescription() +"'," + product.getPrice() +")";
        try(Connection connection = DriverManager.getConnection(url, properties);
            //Statement statement = connection.createStatement()){
            PreparedStatement statement = connection.prepareStatement(sql)){
//            statement.setInt(1, product.getProductId());
            statement.setInt(1, order.getOrderId());
            statement.setInt(2, order.getPersonId());
            statement.setInt(3, order.getProductId());
            statement.execute();
        }catch (SQLException e){
            throw new DbException(e);
        }
    }

    @Override
    public void update(Order order) {
        if (order == null){
            throw new DbException("No order to update");
        }
        int orderId = order.getOrderId();
        //String sql = "UPDATE r0712411.products SET name= '" + product.getName() + ", description = \"" +product.getDescription() +"\", price= " + product.getPrice() + " WHERE productid=" + productid;
        String sql = "UPDATE testing.products SET product_id= ?, WHERE product_id=?;";
        try(Connection connection = DriverManager.getConnection(url, properties);
            //Statement statement = connection.createStatement()) {
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, order.getProductId());
            statement.setInt(2, order.getProductId());
            statement.execute();
        }catch (SQLException e){
            throw new DbException(e);
        }
    }

    @Override
    public void delete(int productId) {
        String sql = "DELETE FROM testing.orders WHERE product_id = ?;";
        try(Connection connection = DriverManager.getConnection(url, properties);
            //Statement statement = connection.createStatement()) {
            PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setInt(1, productId);
            statement.execute();
        }catch (SQLException e){
            throw new DbException(e);
        }
    }

    public double getTotalPriceOrder(int orderId){
        List<Order> orders = new ArrayList<>();
        System.out.println(orderId);
        double price = 0;
        String sql = "SELECT price from testing.orders inner join testing.products on orders.product_id = products.id where orders.id=" + orderId;
        try(Connection connection = DriverManager.getConnection(url, properties);
            Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery(sql);

            while (result.next()){
                price += result.getInt("id");
            }
        }catch (SQLException e) {
            throw new DbException(e);
        }
        return price;
    }

    @Override
    public int getNumberOfOrders() {
        return getAll().size();
    }
}
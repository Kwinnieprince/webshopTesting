package domain.db;

import domain.model.Order;
import java.util.List;
import java.util.Properties;

public class OrderDBPostgres implements OrderDb {
    private Properties properties;
    private String url;

    public OrderDBPostgres(Properties properties){
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
        return null;
    }

    @Override
    public List<Order> getAll() {
        return null;
    }

    @Override
    public void add(Order order) {

    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public int getNumberOfOrders() {
        return 0;
    }
}

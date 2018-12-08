package domain.db;

import domain.model.Order;
import java.util.List;

public interface OrderDb {

    Order get(int id);

    List<Order> getAll();

    void add(Order order);

    void update(Order order);

    void delete(int id);

    int getNumberOfOrders();
}

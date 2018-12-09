package ui.controller.actions;

import domain.model.Order;
import domain.model.Product;
import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Overview extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HashMap<Order, List<Product>> ret = new HashMap<>();
        for(Order o : getService().getAllOrders()) {
            if(ret.get(o) == null) {
                ret.put(o, new ArrayList<>());
            }
            ret.get(o).addAll(o.getProducts());
        }

        request.setAttribute("orders", ret);
        //request.setAttribute("products", getService().getAllOrders());
        return "orders.jsp";
    }
}

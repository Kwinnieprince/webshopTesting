package ui.controller.actions;

import domain.model.Product;
import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

public class Cart extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (session.getAttribute("productscart") == null){
            request.setAttribute("emp", "The cart is empty");
        } else {
            ArrayList<Product> products = (ArrayList<Product>) session.getAttribute("productscart");
            HashMap<Product, Integer> ret = new HashMap<>();
            for(Product p : products) {
                if(!ret.containsKey(p) || ret.get(p) == 0) {
                    ret.put(p, 1);
                }
                else {
                    ret.put(p, ret.get(p) + 1);
                }
            }
            request.setAttribute("productscart", ret);
        }
        return "cart.jsp";
    }
}

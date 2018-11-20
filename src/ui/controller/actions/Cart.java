package ui.controller.actions;

import domain.model.Product;
import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class Cart extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (session.getAttribute("productscart") == null){
            request.setAttribute("emp", "The cart is empty");
        }else {
            ArrayList<Product> products = (ArrayList<Product>)session.getAttribute("productscart");
            request.setAttribute("productscart", products);
        }
        return "cart.jsp";
    }
}

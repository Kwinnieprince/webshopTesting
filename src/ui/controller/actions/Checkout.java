package ui.controller.actions;

import domain.model.Product;
import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class Checkout extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String name = request.getParameter("username");
        String adress = request.getParameter("adress");
        String postalcode = request.getParameter("postalcode");
        if (session.getAttribute("productscart") != null){
            ArrayList<Product>products = (ArrayList<Product>)session.getAttribute("productscart");
            double price = 0;
            for (Product product : products){
                price += product.getPrice();
            }
            request.setAttribute("name", name);
            request.setAttribute("adress", adress);
            request.setAttribute("postalcode", postalcode);
            request.setAttribute("totalprice", price);
            request.setAttribute("productscart", products);
            return "payment.jsp";
        }else {
            return "index.jsp";
        }

    }
}

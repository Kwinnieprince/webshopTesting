package ui.controller.actions;

import domain.model.Product;
import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class AddToCart extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        ArrayList<Product> products;
        if (session.getAttribute("productscart") != null){
            products = (ArrayList<Product>)session.getAttribute("productscart");
        }else {
            products = new ArrayList<>();
        }
        String sessionId = session.getId();
        int productid = Integer.parseInt(request.getParameter("id"));
        Product product = getService().getProduct(productid);
        products.add(product);
        session.setAttribute("productscart", products);
        request.setAttribute("products", getService().getAll());
        return "products.jsp";
    }
}

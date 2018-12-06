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
        int nrofproducts;
        Product product;
        try{
            int productid = Integer.parseInt(request.getParameter("id"));
            product = getService().getProduct(productid);
            nrofproducts = Integer.parseInt(request.getParameter("nrofproducts"));
        }catch (Exception e){
            request.setAttribute("much", "you exceeded the maximum amount if 100 products that you can buy");
            return "Controller?action=Products";
        }
        if (nrofproducts > 100){
            request.setAttribute("much", "you exceeded the maximum amount if 100 products that you can buy");
            return "Controller?action=Products";
        }
        if(nrofproducts <= 0){
            return "Controller?action=Products";
        }
        for(int i = 0; i < nrofproducts; i++){
            products.add(product);
        }
        session.setAttribute("productscart", products);
        request.setAttribute("products", getService().getAll());
        return "products.jsp";
    }
}

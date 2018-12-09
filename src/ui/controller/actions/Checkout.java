package ui.controller.actions;

import domain.model.Order;
import domain.model.Person;
import domain.model.Product;
import ui.controller.RequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class Checkout extends RequestHandler {
    private boolean nameerror = false;
    private boolean adresserror = false;
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String name = request.getParameter("username");
        String adress = request.getParameter("adress");
        String postalcode = request.getParameter("postalcode");
        if (name.trim().isEmpty()){
            request.setAttribute("nameerror", true);
            nameerror = true;
        }
        if (adress.trim().isEmpty()){
            request.setAttribute("adresserror", true);
            adresserror = true;
        }
        try{
            Integer.parseInt(postalcode);
        }catch (NumberFormatException e){
            request.setAttribute("name", name);
            request.setAttribute("adress", adress);
            request.setAttribute("postalerror", true);
            return "userinfo.jsp";
        }
        if (nameerror || adresserror){
            return "userinfo.jsp";
        }
        if (session.getAttribute("productscart") != null){
            ArrayList<Product>products = (ArrayList<Product>)session.getAttribute("productscart");
            double price = 0;
            for (Product product : products){
                price += product.getPrice();
            }
            Person person = new Person(getService().generatePersonId(),name, adress, postalcode);
            getService().addPerson(person);
            Order order = new Order(person, products);
            order.setPersonId(person.getId());
            order.setOrderId(getService().generateOrderId());
            getService().addOrder(order);
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

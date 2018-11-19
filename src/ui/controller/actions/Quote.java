package ui.controller.actions;

import ui.controller.RequestHandler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Quote extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String quote = request.getParameter("quote");
        Cookie cookie;
        if(quote.equals("yes")){
            cookie = new Cookie("quote", "yes");
        }else{
            cookie = new Cookie("quote", "no");
        }
        request.setAttribute("cookiecheck", cookie.getValue());
        response.addCookie(cookie);
        return "index.jsp";
    }
}

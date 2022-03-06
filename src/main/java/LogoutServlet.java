///logout servlet from our page

import jakarta.servlet.http.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie [] cookies = req.getCookies();
        Cookie currentUserCookie = null ;
        if(cookies!=null){
            for(Cookie cookie: cookies){
                if(cookie.getName().equals("CurrentUser")){
                    currentUserCookie = cookie;
                }
            }
        }
        if (currentUserCookie != null){
            currentUserCookie.setMaxAge(0);
            resp.addCookie(currentUserCookie);
        }
        resp.sendRedirect("Login.html");
    }
}

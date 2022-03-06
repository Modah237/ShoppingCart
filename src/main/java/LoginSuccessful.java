import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginSuccessful extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String user=null;

        if(cookies == null){
            response.sendRedirect("Login.html");
        }
        else{
            for (Cookie cookie:cookies){
                if(cookie.getName().equals("CurrentUser")){
                    user = cookie.getValue();
                }
            }
        }
        PrintWriter out = response.getWriter();
        response.sendRedirect("ShoppingCart.jsp");
    }
}

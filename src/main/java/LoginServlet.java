import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    private final String name = "modah";
    private final String password = "modah123";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username-field");
        String pw = request.getParameter("password-field");

        if(username.equals(name) && pw.equals(password)){
            Cookie usernameCookie = new Cookie("currentUser", username);
            usernameCookie.setMaxAge(30*60);
            response.addCookie(usernameCookie);

            RequestDispatcher rd = request.getRequestDispatcher("LoginSuccessful");
            rd.forward(request,response);
        }
        else{
            response.sendRedirect("Login.html");
        }
    }
}

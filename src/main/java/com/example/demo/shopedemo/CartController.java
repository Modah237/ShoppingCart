/// Servlet where we can update,add,delete from the cart(after the selection of articles)

package com.example.demo.shopedemo;
import com.example.demo.Bean.CartBean;
import com.example.demo.Bean.CartItemBean;
import com.example.demo.DbConnection;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


public class CartController extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 System.out.println("wsss");
        String strAction  = request.getParameter("action");

        if (strAction != null && !strAction.equals("")) {
            if (strAction.equals("add")) {
                try {
                    addToCart(request);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } else if (strAction.equals("Update")) {
                updateCart(request);
            } else if (strAction.equals("Delete")) {
                deleteCart(request);
            }
        }
        response.sendRedirect("../CheckoutCart.jsp");
    }

    protected void deleteCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String strItemIndex = request.getParameter("itemIndex");
        CartBean cartBean = null;

        Object objCartBean = session.getAttribute("cart");
        if (objCartBean != null) {
            cartBean = (CartBean) objCartBean;
        } else {
            cartBean = new CartBean();
        }
        cartBean.deleteCartItem(strItemIndex);
    }

    protected void updateCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String strQuantity = request.getParameter("quantity");
        String strItemIndex = request.getParameter("itemIndex");

        CartBean cartBean = null;

        Object objCartBean = session.getAttribute("cart");
        if (objCartBean != null) {
            cartBean = (CartBean) objCartBean;
        } else {
            cartBean = new CartBean();
        }
        cartBean.updateCartItem(strItemIndex, strQuantity);
    }

    public void addToCart(HttpServletRequest request) throws SQLException {
        System.out.println("sd");
        HttpSession session = request.getSession();
        String strModelNo = request.getParameter("modelNo");
        String strDescription = request.getParameter("description");
        String strPrice = request.getParameter("price");
        String strQuantity = request.getParameter("quantity");
        String path = request.getParameter("Id");
        CartBean cartBean = null;
        System.out.println(strQuantity);
        Object objCartBean = session.getAttribute("cart");

        if (objCartBean != null) {
            cartBean = (CartBean) objCartBean;
        } else {
            cartBean = new CartBean();
            session.setAttribute("cart", cartBean);
        }
        cartBean.addCartItem(path,strModelNo, strDescription, strPrice, strQuantity);
        //cartBean.addCartItem(cartBean);

    }
}
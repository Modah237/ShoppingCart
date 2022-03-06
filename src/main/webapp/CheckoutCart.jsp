<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13-Jan-22
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Checkout Cart</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>

<body>
<p>
    <strong>CHECKOUT CART</strong>
</p>
<p>
    <a href="${pageContext.request.contextPath }"
       mce_href="${pageContext.request.contextPath }/ShoppingCart.jsp">Shopping Page</a>
</p>

<table width="75%" border="1">
    <tr>
        <td>
            <strong>
                Model Description
            </strong>
        </td>
        <td>
            <strong>
                Quantity
            </strong>
        </td>
        <td>
            <strong>
                Unit Price
            </strong>
        </td>
        <td>
            <strong>
                Total
            </strong>
        </td>
    </tr>

    <jsp:useBean id="cart" scope="session" class="com.example.demo.Bean.CartBean"/>
    <c:if test="${cart.lineItemCount == 0}">
        <tr>
            <td colspan="4">- Cart is currently empty<br/>
        </tr>
    </c:if>

    <c:forEach var="cartItem" items="${cart.cartItems}" varStatus="counter">
        <form name="item" method="POST" action="CartController">
            <tr>
                <td>
                    <b><c:out value="${cartItem.partNumber}"/></b><br/>
                    <c:out value="${cartItem.modelDescription}"/>
                </td>
                <td>
                    <input type='hidden' name='itemIndex' value='<c:out value="${counter.count}"/> '>
                    <input type='number' name="quantity"  value='<c:out value="${cartItem.quantity}"/> '>
                    <input type="submit" name="action"    value="Update" >
                    <input type="submit" name="action"    value="Delete" >
                </td>
                <td>
                    $<c:out  value="${cartItem.unitCost}"/>
                </td>
                <td>
                    $<c:out value="${cartItem.totalCost}"/>
                </td>
            </tr>
        </form>
    </c:forEach>

    <!--Total-->
    <tr>
        <td colspan="3"></td>
        <td>Subtotal: $<c:out
                value="${cart.orderTotal}"/></td>
    </tr>
</table>

</body>
</html>
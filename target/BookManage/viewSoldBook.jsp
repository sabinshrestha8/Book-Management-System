<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ include file="/templates/header.jsp"%>
<h2 class="text-center mt-4 mx-auto">Sold Book List</h2>
<div class="container w-50 my-4">
    <div class="btn-wrap d-flex flex-row-reverse">
        <a href="./" class="btn btn-secondary btn-sm mx-2">View Books</a>
        <a href="customer" class="btn btn-primary btn-sm">View Customer</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th class="text-center">Book_Id</th>
            <th class="text-center">Customer_Id</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${soldBooks}" var="soldBook">
            <tr>
                <td class="text-center">${soldBook.book_id}</td>
                <td class="text-center">${soldBook.customer_id}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/templates/footer.jsp"%>

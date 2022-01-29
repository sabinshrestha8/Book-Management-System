<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<%@ include file="/templates/header.jsp"%>
<h2 class="text-center mt-4 mx-auto ">Customer List</h2>
<div class="container w-50 my-4">
    <div class="btn-wrap d-flex flex-row-reverse">
        <a href="addCustomer" class="btn btn-primary btn-sm">Add a Customer</a>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th class="text-center">Id</th>
            <th class="text-center">Name</th>
            <th class="text-center">Contact</th>
            <th class="text-center">Action</th>
        </tr>
        </thead>
        <tbody>

        <%
            System.out.println(request.getAttribute("customers"));
        %>

        <c:forEach items="${customers}" var="customer" >
            <tr>
                <td class="text-center">${customer.id}</td>
                <td class="text-center">${customer.name}</td>
                <td class="text-center">${customer.contact}</td>
                <td align="center">
                    <a href="update?id=${customer.id}" class="btn btn-success btn-sm">Edit</a>
                    <a href="delete?id=${customer.id}" class="btn btn-danger btn-sm">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/templates/footer.jsp"%>

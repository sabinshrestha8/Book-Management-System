<%@ page isELIgnored="false" %>
<%@ include file="/templates/header.jsp"%>
<div class="container my-4 mx-auto">
    <h2>Update Customer</h2>
    <form action="update" method="post">
        <div class="form-row">
            <div class="form-group col-md-6 mb-3">
                <label>Name</label>
                <input type="text" name="name" class="form-control" value="${customer.name}">
            </div>
            <div class="form-group col-md-6 mb-3">
                <label>Contact</label>
                <input type="text" name="author" class="form-control" value="${customer.contact}">
            </div>

            <input type="hidden" name="id" value="${customer.id}">

        </div>
        <button type="submit" class="btn btn-dark mb-3">Submit</button>
    </form>
</div>
<%@ include file="/templates/footer.jsp"%>

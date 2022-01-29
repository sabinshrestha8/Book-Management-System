<%@ page isELIgnored="false" %>
<%@ include file="/templates/header.jsp"%>
<div class="container my-4 mx-auto">
    <h2>Add Customer</h2>
    <form action="addCustomer" method="post">
        <div class="form-row">
            <div class="form-group col-md-6 mb-3">
                <label>Name</label>
                <input type="text" name="name" class="form-control" placeholder="Ramesh Verma">
            </div>
            <div class="form-group col-md-6 mb-3">
                <label>Contact</label>
                <input type="text" name="contact" class="form-control" placeholder="9859782434">
            </div>
        </div>
        <button type="submit" class="btn btn-dark mb-3">Submit</button>
    </form>
</div>
<%@ include file="/templates/footer.jsp"%>
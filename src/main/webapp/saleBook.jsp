<%@ page isELIgnored="false" %>
<%@ include file="/templates/header.jsp"%>
<div class="container my-4 mx-auto">
    <h2>Sold BookList</h2>
    <form action="saleBook" method="post">
        <div class="form-row">
            <div class="form-group col-md-6 mb-3">
                <label>Book_ID</label>
                <input type="text" name="book_id" class="form-control" value="${bookId}" readonly>
            </div>
            <div class="form-group col-md-6 mb-3">
                <label>Customer_id</label>
                <input type="text" name="customer_id" class="form-control" placeholder="1">
            </div>
        </div>
        <button type="submit" class="btn btn-dark mb-3">Submit</button>
    </form>
</div>
<%@ include file="/templates/footer.jsp"%>

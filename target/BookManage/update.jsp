<%@ page isELIgnored="false" %>
<%@ include file="/templates/header.jsp"%>
<div class="container my-4 mx-auto">
    <h2>Update Book</h2>
    <form action="update" method="post">
        <div class="form-row">
            <div class="form-group col-md-6 mb-3">
                <label>Name</label>
                <input type="text" name="name" class="form-control" value="${book.name}">
            </div>
            <div class="form-group col-md-6 mb-3">
                <label>Author</label>
                <input type="text" name="author" class="form-control" value="${book.author}">
            </div>
            <div class="form-group col-md-6 mb-3">
                <label>Stock</label>
                <input type="number" name="stock" class="form-control" value="${book.stock}">
            </div>

            <input type="hidden" name="id" value="${book.id}">

        </div>
        <button type="submit" class="btn btn-dark mb-3">Submit</button>
    </form>
</div>
<%@ include file="/templates/footer.jsp"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="/js/adminPage.js"></script>

<style type="text/css">
	img{
		width: 150px;
		height: 150px
	}
	
	.proId > td{
		width: 200px
	}
</style>
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">Admin Dashboard</h1>
    <div class="text-right mb-4">
    	<form action="${pageContext.request.contextPath}/profile/logout" method="post">
        	<button class="btn btn-danger" id = "logout" >Logout</button>
       	</form>
    </div>
    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" href="#products" data-toggle="tab">Products</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#board" data-toggle="tab">Board</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#board_comment" data-toggle="tab">Board_Comment</a>
        </li>
    </ul>

    <div class="tab-content">
        <!-- Product Tab -->
        <div id="products" class="container tab-pane active">
            <h2 class="mt-2">Manage Products</h2>
            <button class="btn btn-success mb-2" data-toggle="modal" data-target="#addProductModal">Add Product</button>
            <!-- Product Modal -->
            <div class="modal fade" id="addProductModal" tabindex="-1" role="dialog" aria-labelledby="addProductModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="addProductModalLabel">Add New Product</h5>
                            <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form enctype="multipart/form-data" id = "productform">
                                <div class="mb-3">
                                    <label for="productKind" id="productKind" class="form-label">Product Kind</label>
                                    <input name="productKind" type="text" class="form-control" id="productKind">
                                </div>
                                <div class="mb-3">
                                    <label for="productName" id="productName" class="form-label">Product Name</label>
                                    <input name="productName" type="text" class="form-control" id="productName">
                                </div>
                                <div class="mb-3">
                                    <label for="productcomment" id = "productcomment" class="form-label">Description</label>
                                    <textarea name="productComment" class="form-control" id="productDescription"></textarea>
                                </div>
                                <div class="mb-3">
                                    <label for="productPrice"id = "productPrice" class="form-label">Price</label>
                                    <input name="productPrice" type="number" class="form-control" id="productPrice">
                                </div>
                                <div class="mb-3">
                                    <label for="productImg" id = "productImg" class="form-label">Product Image</label>
                                    <input name="productImg" type="file" class="form-control" id="productImage" accept="image/*">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id = "productbtn">Save changes</button>
                        </div>
                    </div>
                </div>
            </div>
            
            <!-- Product Table -->
            <div class="table-responsive">
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>Image</th>
                            <th>Product ID</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
               		<c:choose>
                		<c:when test="${not empty products}">
                   			<tbody >
		                        <c:forEach var="product" items="${products}">
		                            <tr class = "proId">
		                                <td>
		                                <%-- Assuming product is an instance of ProductDTO --%>
											<img src="/images/${product.productId}" alt="Product Image">
		                                </td>
		                                <td>${product.productId}</td>
		                                <td>${product.name}</td>
		                                <td>${product.comment}</td>
		                                <td>${product.price}</td>
		                                <td>
		                                   	<button class="btn btn-danger btn-sm delete-product-btn" data-id="${product.productId}">Delete</button>
		                                </td>
		                            </tr>
		                        </c:forEach>
	                   		</tbody>
	                    </c:when>
	    	        	<c:otherwise>
	                            <tbody>
	                                <tr>
	                                    <td colspan="6" class="text-center">No products available.</td>
	                                </tr>
	                            </tbody>
						</c:otherwise>
    	        	</c:choose>
                </table>
            </div>
        </div>
        
        <!-- Board Tab -->
        <div class="tab-pane fade" id = "board">
            <h2 class="mt-2">Manage Board</h2>
            <!-- Board Modal -->
            <div class="modal fade" id="addBoardModal" tabindex="-1" role="dialog" aria-labelledby="addBoardModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="addBoardModalLabel">Add New Board</h5>
                        </div>
                        <div class="modal-body">
                            <form id = "boardform">
                                <div class="mb-3">
                                    <label for="boardTitle" class="form-label">Title</label>
                                    <input type="text" class="form-control" id="boardTitle">
                                </div>
                                <div class="mb-3">
                                    <label for="boardContent" class="form-label">Content</label>
                                    <textarea class="form-control" id="boardContent"></textarea>
                                </div>
                                <div class="mb-3">
                                    <label for="boardAuthor" class="form-label">Author</label>
                                    <input type="text" class="form-control" id="boardAuthor">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="boardbtn">Save Board</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Board Table -->
            <div class="table-responsive">
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Content</th>
                            <th>Author</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <c:choose>
                    	<c:when test="${not empty boards}">
	                    	<tbody>
	                    	<c:forEach var="board" items="${boards}">
	                            <tr>
	                                <td>${board.idx}</td>
	                                <td>${board.title}</td>
	                                <td>${board.content}</td>
	                                <td>${board.name}</td>
	                                <td>
	                                    <button class="btn btn-danger btn-sm" id ="deletbtn" data-id="${board.idx}" >Delete</button>
	                                </td>
	                            </tr>
	                   		</c:forEach>
		               		</tbody>
                   		</c:when>
	    	        	<c:otherwise>
	                            <tbody>
	                                <tr>
	                                    <td colspan="6" class="text-center">No products available.</td>
	                                </tr>
	                            </tbody>
						</c:otherwise>
    	        	</c:choose>
                </table>
            </div>
        </div>
        
        <!-- Board Comment Tab -->
        <div id="board_comment" class="tab-pane fade">
            <h2 class="mt-2">Manage Board Comments</h2>
            <!-- Board Comment Table -->
            <div class="table-responsive">
                <table class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>Comment ID</th>
                            <th>Board ID</th>
                            <th>Comment</th>
                            <th>Author</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <c:choose>
                    	<c:when test="${not empty boards}">
	                    <tbody>
	                   		<c:forEach var="comment" items="${comments}">
	                            <tr>
	                                <td>${comment.idx}</td>
	                                <td>${comment.boardIdx}</td>
	                                <td>${comment.content}</td>
	                                <td>${comment.name}</td>
	                                <td>
	                                    <button class="btn btn-danger btn-sm" id = "commentbtn" data-id="${comment.idx}">Delete</button>
	                                </td>
	                            </tr>
	                    	</c:forEach>
	                    </tbody>
						</c:when>
	    	        	<c:otherwise>
	                            <tbody>
	                                <tr>
	                                    <td colspan="6" class="text-center">No products available.</td>
	                                </tr>
	                            </tbody>
						</c:otherwise>
    	        	</c:choose>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>

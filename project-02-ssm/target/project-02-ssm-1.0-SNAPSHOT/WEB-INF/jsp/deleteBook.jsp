<%--
  Created by IntelliJ IDEA.
  User: 所谓
  Date: 2022/8/9
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>新增书籍</title>
    <meta name="viewport" content="width=device-width,inital-scale=1.0">
    <%--    引入Bootstrap--%>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>删除书籍</small>
                </h1>
            </div>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/deleteBook" method="post">
        书籍编号: <input type="text" name="bookID" value="${book.bookID}" class="form-control"> <br>
        书籍名称: <input type="text" name="bookName" value="${book.bookName}" class="form-control"> <br>
        书籍数量: <input type="text" name="bookCounts" value="${book.bookCounts}" class="form-control"> <br>
        书籍详情: <input type="text" name="details" value="${book.details}" class="form-control"> <br>
        <input type="submit" value="确认删除">
    </form>

</div>



</body>
</html>

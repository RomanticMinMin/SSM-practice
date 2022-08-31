<%--
  Created by IntelliJ IDEA.
  User: 所谓
  Date: 2022/7/20
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示界面</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0">

<%--    BootStrap美化页面--%>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small style="font-weight: bold">书籍列表 ---------- 显示所有书籍</small>
                    </h1>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 column">
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toIndexBook">首页</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增书籍</a>
                <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/allBook">显示全部书籍</a>
            </div>

            <div class="col-md-4 column">
                <form class="form-inline" style="float: right" action="${pageContext.request.contextPath}/book/queryBook" method="post">
                    <span style="color: red;font-weight:bold">${error}</span>
                    <input type="text" name="queryBookName" placeholder="要检索的书籍名称">
                    <input type="submit" value="检索" class="btn btn-primary">
                </form>

            </div>

            <div class="col-md-4 column">

            </div>
        </div>

        <div class="row clearfix">
            <div class="col-md-12 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>
                    <th>书籍编号</th>
                    <th>书籍名称</th>
                    <th>书籍数量</th>
                    <th>书籍详情</th>
                    <th>操作</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="book" items="${requestScope.get('list')}">
                    <tr>
                        <td>${book.getBookID()}</td>
                        <td>${book.getBookName()}</td>
                        <td>${book.getBookCounts()}</td>
                        <td>${book.getDetails()}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/book/toUpdateBook?id=${book.getBookID()}">更改</a>
                            |
                            <a href="${pageContext.request.contextPath}/book/toDeleteBook?id=${book.getBookID()}">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
      </div>
    </div>


    <br>

    <div class="bg-info clearfix">
        <button type="button" class="btn btn-secondary float-left">向左浮动（float）的示例按钮</button>
        <button type="button" class="btn btn-secondary float-right">向右浮动（float）的示例按钮</button>
    </div>


</body>
</html>

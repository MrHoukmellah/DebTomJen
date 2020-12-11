<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.TPJEE.JDBCORMSingleton.WEB.model.ProductModel" %>
<jsp:include page = "header.jsp"/>

<body>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <div class="page-header">
                <h1>jQuery Searchable Plugin</h1>
            </div>
            <p>You can find the source of this plugin at <a href="http://github.com/stidges/jquery-searchable" target="_blank">Github</a> (http://github.com/stidges/jquery-searchable)!</p>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <h3>Table / Fuzzy search example</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-4 col-lg-offset-4">
            <input type="search" id="search" value="${ allProducts.getKeyword() }" class="form-control" placeholder="Search using Fuzzy searching">
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <table class="table" id="table">
                <thead>
                    <tr>
                        <th>Designation</th>
                        <th>Price</th>
                        <th>Quantity</th>
                    </tr>
                </thead>
                <tbody>
                	<c:forEach items="${allProducts.getProducts()}" var="products">
	                    <tr>
	                        <td>${ products.getDesignation() }</td>
	                        <td>${ products.getPrice() }</td>
	                        <td>${ products.getQuantity() }</td>
	                    </tr>
 					</c:forEach>
                </tbody>
            </table>
            <hr>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <h3>Non-table example</h3>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-4 col-lg-offset-4">
            <input type="search" id="container-search" value="" class="form-control" placeholder="Search...">
        </div>
    </div>
</div>
<div class="container" id="searchable-container">
    <div class="row row-padding">
        <div class="col-xs-4">Col 1</div>
        <div class="col-xs-4">Col 2</div>
        <div class="col-xs-4">Col 3</div>
    </div>
    <div class="row row-padding">
        <div class="col-xs-4">Another row</div>
        <div class="col-xs-4">With some</div>
        <div class="col-xs-4">Other data</div>
    </div>
    <div class="row row-padding">
        <div class="col-xs-4">Lorem</div>
        <div class="col-xs-4">Ipsum</div>
        <div class="col-xs-4">Dolor</div>
    </div>
    <div class="row row-padding">
        <div class="col-xs-4">Foo</div>
        <div class="col-xs-4">Bar</div>
        <div class="col-xs-4">Baz</div>
    </div>
</div>
<script src="//rawgithub.com/stidges/jquery-searchable/master/dist/jquery.searchable-1.0.0.min.js"></script>
</body>

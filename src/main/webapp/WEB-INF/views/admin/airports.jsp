<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>


<!DOCTYPE html>
<%@ include file="template/sidebar.html" %>
<html class="sidebar sidebar-collapse">

<head>
    <%@ include file="template/header.html" %>
    <%@ include file="template/styles.html" %>
    <%@ include file="template/meta.html" %>
    <%@ include file="template/scripts.html" %>
</head>
<body class="">
<!-- Main Container Fluid -->
<div class="container-fluid menu-hidden">
    <!-- Sidebar Menu -->
    <%@ include file="template/sidebarmenu.html" %>
    <!-- // Sidebar Menu END -->
    <!-- Content -->
    <div id="content">
        <%@ include file="template/navbar.html" %>
        <!-- // END navbar -->
        <div class="innerLR">
            <h2 class="margin-none pull-left">Aiports</h2>

            <div class="btn-group btn-group-sm pull-right">
                <a href="#modal-addproduct" data-toggle="modal" class="btn btn-primary"><i
                        class="fa fa-fw fa-plus-circle"></i>
                    Add Aiport</a>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="modal-addproduct">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- Modal heading -->
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"
                                    aria-hidden="true">&times;</button>
                            <h3 class="modal-title">Add Airport</h3>
                        </div>
                        <!-- // Modal heading END -->
                        <!-- Modal body -->
                        <div class="modal-body">
                            <div class="innerAll">
                                <div class="row innerLR">
                                    <form:form class="form-horizontal margin-none" action="/admin/airports/addPage/add"
                                               method="post"
                                               commandName="airport" autocomplete="off">
                                        <!-- Column -->
                                        <div class="col-md-4">
                                            <!-- Group -->
                                            <div class="form-group">
                                                <div class="col-md-8">
                                                    <form:label class="control-label" path="name"
                                                                for="name">Name: </form:label></div>
                                                <br/>

                                                <div class="col-md-8">
                                                    <form:input class="form-control" path="name" id="name"
                                                                name="name" type="text"/>
                                                </div>
                                            </div>
                                            <!-- // Group END -->
                                            <!-- Group -->
                                            <div class="form-group">
                                                <div class="col-md-8">
                                                    <form:label class="control-label" path="address"
                                                                for="address">Address: </form:label></div>
                                                <br/>

                                                <div class="col-md-8">
                                                    <form:textarea cols="6" rows="4" class="form-control" path="address"
                                                                   id="address"
                                                                   name="address" type="text"/>
                                                </div>
                                            </div>
                                            <!-- // Group END -->

                                        </div>
                                        <!-- // Column END -->
                                        <!-- Column -->
                                        <div class="col-md-4">
                                            <!-- Group -->
                                            <div class="form-group">
                                                <div class="col-md-8">
                                                    <form:label class="control-label" path="name"
                                                                for="postcode">Postcode: </form:label></div>
                                                <br/>

                                                <div class="col-md-8">
                                                    <form:input class="form-control" path="postcode" id="postcode"
                                                                name="postcode" type="text"/>
                                                </div>
                                            </div>
                                            <!-- // Group END -->

                                        </div>
                                        <!-- // Column END -->
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button type="submit" class="btn btn-primary">Add Carpark</button>
                                            </div>
                                        </div>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                        <!-- // Modal body END -->
                    </div>
                </div>
            </div>
            <!-- // Modal END -->


            <div class="clearfix"></div>

            <div class="separator-h"></div>
            <!-- Widget -->
            <div class="widget widget-body-white">
                <!-- Widget heading -->
                <div class="widget-head">
                    <h4 class="heading glyphicons list"><i></i> Manage Airpors</h4>
                </div>
                <!-- // Widget heading END -->
                <div class="widget-body">
                    <div class="innerLR innerT">
                        <!-- Total products & Sort by options -->
                        <div class="form-inline">
                            <div class="innerAll half strong pull-left">
                                Total Manage Airports: ${numAirports}
                            </div>
                            <div class="clearfix"></div>
                        </div>
                        <!-- // Total products & Sort by options END -->
                        <div class="separator bottom"></div>
                    </div>
                    <!-- Products table -->
                    <table class="table table-condensed table-striped table-primary table-vertical-center checkboxs js-table-sortable">
                        <thead>
                        <tr>
                            <th style="width: 1%;" class="center">ID</th>
                            <th class="center">Name</th>
                            <th class="center">Carparks</th>
                            <th class="center">Postcode</th>
                            <th class="center">Address</th>
                            <th class="center" style="width: 100px;">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${airportx}" var="airport">
                            <tr>
                                </td>
                                <td class="center">${airportx.indexOf(airport)+1}</td>
                                <td class="important">${airport.name}</td>
                                <td>
                                    <c:if test="${airport.carpark.size() >= 6}">
                                        <c:forEach items="${airport.carpark.subList(0,5)}" var="carpark">
                                            <ul>
                                                <small>
                                                    <li>${carpark.codename}</li>
                                                </small>
                                            </ul>

                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${airport.carpark.size() <= 5}">
                                        <c:forEach items="${airport.carpark}" var="carpark">
                                            <ul>
                                                <small>
                                                    <li>${carpark.codename}</li>
                                                </small>
                                            </ul>

                                        </c:forEach>
                                    </c:if>

                                </td>
                                <td>${airport.postcode}</td>
                                <td>${airport.address}</td>

                                <td class="center">
                                    <a href="/admin/airports/editPage/${airport.id}" data-toggle="modal"
                                       class="btn btn-sm btn-success"><i
                                            class="fa fa-pencil"></i></a>
                                    <a href="/admin/airports/delete/${airport.id}" class="btn btn-sm btn-danger"><i
                                            class="fa fa-times"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- // Products table END -->
                    <!-- Options -->

                    <!-- // Options END -->
                </div>
            </div>
            <!-- // Widget END -->
        </div>
    </div>
    <!-- // Content END -->
    <div class="clearfix"></div>
    <!-- // Sidebar menu & content wrapper END -->
    <%@ include file="template/footer.html" %>
</div>
<%@ include file="template/footerscripts.html" %>
</body>
</html>
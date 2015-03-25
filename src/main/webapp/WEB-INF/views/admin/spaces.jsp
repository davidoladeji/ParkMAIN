<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="true" %>

<!DOCTYPE html>
<%@ include file="template/sidebar.html" %>
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
            <h2 class="margin-none pull-left">Spaces</h2>

            <div class="btn-group btn-group-sm pull-right">
                <a href="#modal-addproduct" data-toggle="modal" class="btn btn-primary"><i
                        class="fa fa-fw fa-plus-circle"></i>
                    Add Space</a>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="modal-addproduct">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- Modal heading -->
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"
                                    aria-hidden="true">&times;</button>
                            <h3 class="modal-title">Add Space</h3>
                        </div>
                        <!-- // Modal heading END -->
                        <!-- Modal body -->
                        <div class="modal-body">
                            <div class="innerAll">
                                <div class="innerLR">
                                    <form:form class="form-horizontal margin-none" action="/admin/spaces/addPage/add"
                                               method="post"
                                               commandName="space" autocomplete="off">

                                        <div class="form-group">
                                            <form:label path="carpark.id" for="carparkId"
                                                        class="col-sm-2 control-label">Choose Carpark</form:label>
                                            <div class="col-md-8">
                                                <form:select data-style="btn-primary" class="selectpicker"
                                                             path="carpark.id" id="carparkId" autocomplete="false">
                                                    <c:forEach items="${carparkx}" var="carpark">
                                                        <form:option label="${carpark.codename}" value="${carpark.id}"/>
                                                    </c:forEach>
                                                </form:select>
                                                <form:label path="carpark.airport"
                                                            class="col-sm-2 control-label">${carpark.airport.name}</form:label>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <form:label path="spaceType.id" for="spaceTypeId"
                                                        class="col-sm-2 control-label">Choose Space Type</form:label>
                                            <div class="col-md-8">
                                                <form:select data-style="btn-primary" class="selectpicker"
                                                             path="spaceType.id" id="spaceTypeId" autocomplete="false">
                                                    <c:forEach items="${spaceTypex}" var="spaceType">
                                                        <form:option label="${spaceType.name}" value="${spaceType.id}"/>

                                                    </c:forEach>
                                                </form:select>
                                            </div>
                                        </div>

                                        <%--

                                                                                <div class="form-group">
                                                                                    <form:label path="price" for="price"
                                                                                                class="col-sm-2 control-label">Price: </form:label>
                                                                                    <div class="col-md-8">
                                                                                        <form:input path="price" class="form-control" id="price"
                                                                                                    autocomplete="false"/>
                                                                                    </div>
                                                                                </div>
                                        --%>


                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button type="submit" class="btn btn-primary">Add Space</button>
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
            <!-- Widget -->
            <div class="widget widget-body-white">
                <!-- Widget heading -->
                <div class="widget-head">
                    <h4 class="heading glyphicons list"><i></i> Manage Spaces</h4>
                </div>
                <!-- // Widget heading END -->
                <div class="widget-body">
                    <div class="innerLR innerT">
                        <!-- Total products & Sort by options -->
                        <div class="form-inline">
                                <span class="pull-right">
                                    <label class="strong innerLR">Sort by:</label>
                                    <select class="selectpicker margin-none" data-style="btn-default btn-sm">
                                        <option>Option</option>
                                    </select>
                                </span>

                            <div class="innerAll half strong pull-left">
                                Total Manage Spaces: ${spacex.size()}
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
                            <th class="center">Airport</th>
                            <th class="center">Carpark</th>
                            <th class="center">Address</th>
                            <th class="center">Regular Price</th>
                            <th class="center">Space Type</th>
                            <th class="center">Status</th>
                            <th class="center" style="width: 100px;">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${spacex}" var="space">
                            <tr>
                                </td>
                                <td class="center">${spacex.indexOf(space)+1}</td>
                                <td class="important">${space.carpark.airport.name}</td>
                                <td class="important">${space.carpark.codename}</td>
                                <td class="important">${space.carpark.airport.address}</td>
                                <td>${space.carpark.regularprice}</td>
                                <td>${space.spaceType.name}</td>
                                <td>
                                    <c:if test="${space.booked == true}">
                                        Booked
                                    </c:if>
                                    <c:if test="${space.booked == false}">
                                        Not booked
                                    </c:if>

                                </td>
                                <td class="center">
                                    <a href="/admin/spaces/editPage/${space.id}" data-toggle="modal"
                                       class="btn btn-sm btn-success"><i
                                            class="fa fa-pencil"></i></a>
                                    <a href="/admin/spaces/delete/${space.id}" class="btn btn-sm btn-danger"><i
                                            class="fa fa-times"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- // Products table END -->
                    <!-- Options -->
                    <div class="">
                        <!-- With selected actions -->
                        <div class="pull-left checkboxs_actions" style="display: none;">
                            <label>With selected:
                                <select class="selectpicker margin-none dropup" data-style="btn-default btn-xs">
                                    <option>Action</option>
                                    <option>Action</option>
                                    <option>Action</option>
                                </select>
                            </label>
                        </div>
                        <!-- // With selected actions END -->
                        <div class="pull-right">
                            <ul class="pagination margin-none">
                                <li class="disabled"><a href="#">&laquo;</a>
                                </li>
                                <li class="active"><a href="#">1</a>
                                </li>
                                <li><a href="#">2</a>
                                </li>
                                <li><a href="#">3</a>
                                </li>
                                <li><a href="#">&raquo;</a>
                                </li>
                            </ul>
                        </div>
                        <div class="clearfix"></div>
                        <!-- // Pagination END -->
                    </div>
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
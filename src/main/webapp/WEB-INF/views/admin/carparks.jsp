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
            <h2 class="margin-none pull-left">Carparks</h2>

            <div class="btn-group btn-group-sm pull-right">
                <a href="#modal-addproduct" data-toggle="modal" class="btn btn-primary"><i
                        class="fa fa-fw fa-plus-circle"></i>
                    Add Carpark</a>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="modal-addproduct">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <!-- Modal heading -->
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal"
                                    aria-hidden="true">&times;</button>
                            <h3 class="modal-title">Add Carpark</h3>
                        </div>
                        <!-- // Modal heading END -->
                        <!-- Modal body -->
                        <div class="modal-body">
                            <div class="innerAll">
                                <div class="innerLR">
                                    <form:form class="form-horizontal margin-none" action="/admin/carparks/addPage/add"
                                               method="post"
                                               commandName="carpark" autocomplete="off">
                                        <form:errors path="codename" cssClass="error"/><br/>

                                        <div class="form-group">
                                            <form:label path="airport.id" for="airportId"
                                                        class="col-sm-2 control-label">Choose Airport</form:label>
                                            <div class="col-md-8">
                                                <form:select data-style="btn-primary" class="selectpicker"
                                                             path="airport.id" id="airportId" autocomplete="false">
                                                    <c:forEach items="${airportx}" var="airportx">
                                                        <form:option label="${airportx.name}" value="${airportx.id}"/>
                                                    </c:forEach>
                                                </form:select>
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <form:label path="codename" for="codename"
                                                        class="col-sm-2 control-label">Code name</form:label>
                                            <div class="col-md-8">
                                                <form:input path="codename" class="form-control" id="codename"
                                                            autocomplete="false"></form:input>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <form:label path="mobile" for="mobile"
                                                        class="col-sm-2 control-label">Mobile</form:label>
                                            <div class="col-md-8">
                                                <form:input path="mobile" class="form-control" id="mobile"
                                                            autocomplete="false"></form:input>
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <form:label path="capacity" for="capacity"
                                                        class="col-sm-2 control-label">Capacity</form:label>
                                            <div class="col-md-8">
                                                <form:input path="capacity" class="form-control" id="capacity"
                                                            autocomplete="false"></form:input>
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <form:label path="capacitydisabled" for="capacitydisabled"
                                                        class="col-sm-2 control-label">Disabled</form:label>
                                            <div class="col-md-8">
                                                <form:input path="capacitydisabled" class="form-control"
                                                            id="capacitydisabled" autocomplete="false"></form:input>
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <form:label path="capacityfamily" for="capacityfamily"
                                                        class="col-sm-2 control-label">Family</form:label>
                                            <div class="col-md-8">
                                                <form:input path="capacityfamily" class="form-control"
                                                            id="capacityfamily" autocomplete="false"></form:input>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <form:label path="regularprice" for="regularprice"
                                                        class="col-sm-2 control-label">Regular Price</form:label>
                                            <div class="col-md-8">
                                                <form:input path="regularprice" class="form-control" id="regularprice"
                                                            autocomplete="false"></form:input>
                                            </div>
                                        </div>

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
                    <h4 class="heading glyphicons list"><i></i> Manage Carparks</h4>
                </div>
                <!-- // Widget heading END -->
                <div class="widget-body">
                    <div class="innerLR innerT">
                        <!-- Total products & Sort by options -->
                        <div class="form-inline">
                            <%--<span class="pull-right">
                                <label class="strong innerLR">Sort by:</label>
                                <select class="selectpicker margin-none" data-style="btn-default btn-sm">
                                    <option>Option</option>
                                </select>
                            </span>--%>

                            <div class="innerAll half strong pull-left">
                                ${errormessage}<br/>
                                Total Manage Carparks: ${numCarparks}
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
                            <th>Code Name</th>
                            <th class="center">Airport</th>
                            <th class="">Address</th>
                            <th class="center">Capacity</th>
                            <th class="center">Available</th>
                            <th style="width: 4%;">Price(avg)</th>
                            <th style="width: 4%;" class="center">Disabled</th>
                            <th style="width: 4%;" class="center">Family</th>
                            <th class="center" style="width: 100px;">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${carparkx}" var="carpark" varStatus="loopStatus">
                            <tr class="${loopStatus.index % 2 == 0 ? 'odd' : 'even'}">
                                <td class="center">${loopStatus.index+1}</td>
                                <td class="important">${carpark.codename}</td>
                                <td class="important">${carpark.airport.name}</td>
                                <td class="important">${carpark.airport.address}</td>
                                <td class="center">${carpark.capacity}</td>
                                <td class="text-center">
                                    <input type="text" class="form-control" style="width: 50px; margin: 0 auto;"
                                           value="${carpark.spacesavailable}"
                                            />
                                </td>
                                <td class="center">${carpark.regularprice}</td>
                                <td class="center">${carpark.capacitydisabled}</td>
                                <td class="center">${carpark.capacityfamily}</td>
                                <td class="center">
                                    <a href="/admin/carparks/editPage/${carpark.id}" data-toggle="modal"
                                       class="btn btn-sm btn-success"><i
                                            class="fa fa-pencil"></i></a>
                                    <a href="/admin/carparks/delete/${carpark.id}" class="btn btn-sm btn-danger"><i
                                            class="fa fa-times"></i></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <!-- // Products table END -->
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
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

            <div class="innerLR">
                <!-- Form -->
                <form:form class="form-horizontal margin-none" action="/admin/carparks/addPage/add" method="post"
                           commandName="carpark" autocomplete="off">
                    <!-- Widget -->
                    <div class="widget">
                        <!-- Widget heading -->
                        <div class="widget-head">
                            <h4 class="heading">Add Carpark</h4>
                        </div>
                        <!-- // Widget heading END -->
                        <div class="widget-body innerAll inner-2x">
                            <!-- Row -->
                            <div class="row innerLR">
                                <div class="col-md-4">
                                    <div class="form-group">

                                        <form:label class="col-md-4 control-label" path="airport.id"
                                                    for="airport">Choose Airport</form:label>
                                        <form:select class="selectpicker col-md-6" path="airport.id"
                                                     data-style="btn-primary">
                                            <c:forEach items="${airportx}" var="airportx">

                                                <form:option label="${airportx.name}" value="${airportx.id}"/>
                                            </c:forEach>
                                        </form:select>
                                    </div>
                                </div>
                            </div>
                            <div class="row innerLR">
                                <!-- Column -->
                                <div class="col-md-4">
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="codename"
                                                    for="codename">Code name</form:label>
                                        <form:errors path="codename" cssClass="error"></form:errors>
                                        <div class="col-md-8">
                                            <form:input path="codename" class="form-control" id="codename"
                                                        name="codename" type="text"/>
                                        </div>
                                    </div>
                                    <!-- // Group END -->
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="capacity"
                                                    for="capacity">Capacity</form:label>
                                        <div class="col-md-8">
                                            <form:input class="form-control" path="capacity" id="capacity"
                                                        name="capacity" type="text"/>
                                        </div>
                                    </div>
                                    <!-- // Group END -->
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="capacitydisabled"
                                                    for="capacitydisabled">Capacity (disabled)</form:label>
                                        <div class="col-md-8">
                                            <form:input class="form-control" path="capacitydisabled"
                                                        id="capacitydisabled"
                                                        name="capacitydisabled" type="text"/>
                                        </div>
                                    </div>
                                    <!-- // Group END -->
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="capacityfamily"
                                                    for="capacityfamily">Capacity (family)</form:label>
                                        <div class="col-md-8">
                                            <form:input class="form-control" path="capacityfamily" id="capacityfamily"
                                                        name="capacityfamily" type="text"/>
                                        </div>
                                    </div>
                                    <!-- // Group END -->

                                </div>
                                <!-- // Column END -->
                                <!-- Column -->
                                <div class="col-md-8">
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="mobile"
                                                    for="mobile">Mobile</form:label>
                                        <div class="col-md-8">
                                            <form:input path="mobile" class="form-control" id="mobile"
                                                        name="mobile" type="text"/>
                                        </div>
                                    </div>
                                    <!-- // Group END -->
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="regularprice"
                                                    for="regularprice">Regular Price</form:label>
                                        <div class="col-md-8">
                                            <form:input path="regularprice" class="form-control" id="mobile"
                                                        name="regularprice" type="text"/>
                                        </div>
                                    </div>
                                    <!-- // Group END -->

                                </div>
                                <!-- // Column END -->
                            </div>
                            <!-- // Row END -->
                            <!-- Row -->

                            <div class="separator"></div>
                            <!-- Form actions -->
                            <div class="form-actions">
                                <button type="submit" class="btn btn-primary"><i class="fa fa-check-circle"></i> Save
                                </button>
                                <button type="button" class="btn btn-default"><i class="fa fa-times"></i> Cancel
                                </button>
                            </div>
                            <!-- // Form actions END -->
                        </div>
                    </div>
                    <!-- // Widget END -->
                </form:form>
                <!-- // Form END -->
            </div>

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
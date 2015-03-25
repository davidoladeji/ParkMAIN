<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                <!-- Form -->
                <form:form class="form-horizontal margin-none" action="/admin/bookings/addPage/add/" method="post"
                           commandName="booking" autocomplete="off">
                    <!-- Widget -->
                    <div class="widget">
                        <!-- Widget heading -->
                        <div class="widget-head">
                            <h4 class="heading">Add Booking</h4>
                        </div>
                        <!-- // Widget heading END -->
                        <div class="widget-body innerAll inner-2x">
                            <!-- Row -->
                            <div class="row innerLR">
                                <!-- Column -->
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="spaceType.id"
                                                    for="userRoleId">Space Type</form:label>
                                        <form:select id="userRoleId" class="selectpicker col-md-6" path="spaceType.id"
                                                     data-style="btn-primary">

                                            <form:option value="NONE" label="--- Select ---"/>
                                            <c:forEach items="${spaceTypex}" var="spaceType">
                                                <form:option label="${spaceType.name}" value="${spaceType.id}"/>
                                            </c:forEach>
                                        </form:select>
                                        <form:errors path="spaceType.id" cssClass="error"/>
                                    </div>
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="carparkSpace.id"
                                                    for="carparkspaceId">Carpark Space</form:label>
                                        <form:select id="userRoleId" class="selectpicker col-md-6"
                                                     path="carparkSpace.id"
                                                     data-style="btn-primary">

                                            <form:option value="NONE" label="--- Select ---"/>
                                            <c:forEach items="${spacex}" var="space">
                                                <form:option label="${space.carpark.codename}, ${space.id}"
                                                             value="${space.id}"/>
                                            </c:forEach>
                                        </form:select>
                                        <form:errors path="carparkSpace.id" cssClass="error"/>
                                    </div>
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="base_price"
                                                    for="base_price">Base Price</form:label>

                                        <div class="col-md-8">
                                            <form:input class="form-control" path="base_price" id="base_price"
                                                        name="base_price" type="text"/>
                                            <form:errors path="carparkSpace.id" cssClass="error"/>
                                        </div>
                                    </div>
                                    <!-- // Group END -->
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="destinationPrice"
                                                    for="base_price">Destination Price</form:label>

                                        <div class="col-md-8">
                                            <form:input class="form-control" path="destinationPrice" id="base_price"
                                                        name="destinationPrice" type="text"/>
                                            <form:errors path="destinationPrice" cssClass="error"/>
                                        </div>
                                    </div>
                                    <!-- // Group END -->
                                    <!-- Group -->

                                    <div class="form-group">

                                        <form:label class="col-md-4 control-label" path="arrivalDate"
                                                    for="departureDate">Arrival Date.</form:label>

                                        <div class="col-md-8">
                                            <form:input class="date form-control" path="arrivalDate" id="arrivalDate"
                                                        name="start" type="text"/>
                                            <form:errors path="arrivalDate" cssClass="error"/>
                                        </div>
                                    </div>
                                    <!-- // Group END -->
                                    <!-- Group -->
                                    <div class="form-group">

                                        <form:label class="col-md-4 control-label" path="departureDate"
                                                    for="departureDate">Departure Date.</form:label>

                                        <div class="col-md-8">
                                            <form:input class="date form-control" path="departureDate"
                                                        id="departureDate"
                                                        name="end" type="text"/>
                                            <form:errors path="departureDate" cssClass="error"/>
                                        </div>
                                    </div>

                                </div>
                                <!-- // Column END -->
                                <!-- Column -->
                                <div class="col-md-6">
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="flightNumber"
                                                    for="base_price">Flight Number</form:label>
                                        <div class="col-md-8">
                                            <form:input class="form-control" path="flightNumber" id="base_price"
                                                        name="flightNumber" type="text"/>
                                            <form:errors path="flightNumber" cssClass="error"/>
                                        </div>
                                    </div>
                                    <!-- // Group END -->
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="carModel"
                                                    for="carModel">Car Model</form:label>

                                        <div class="col-md-8">
                                            <form:input class="form-control" path="carModel" id="carModel"
                                                        name="carModel" type="text"/>
                                            <form:errors path="carModel" cssClass="error"/>
                                        </div>
                                    </div>
                                    <!-- // Group END -->
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="carRegistration"
                                                    for="carModel">Car Registration</form:label>

                                        <div class="col-md-8">
                                            <form:input class="form-control" path="carRegistration" id="carModel"
                                                        name="carRegistration" type="text"/>
                                            <form:errors path="carRegistration" cssClass="error"/>
                                        </div>
                                    </div>
                                    <!-- // Group END -->
                                    <!-- Group -->
                                    <div class="form-group">
                                        <form:label class="col-md-4 control-label" path="receiptno"
                                                    for="receiptno">Receipt No.</form:label>

                                        <div class="col-md-8">
                                            <form:input class="form-control" path="receiptno" id="receiptno"
                                                        name="receiptno" type="text"/>
                                            <form:errors path="receiptno" cssClass="error"/>
                                        </div>
                                    </div>
                                    <!-- // Group END -->
                                    <!-- Group -->
                                    <div class="form-group">

                                        <form:label class="col-md-4 control-label" path="arrivalTime"
                                                    for="arrivalTime">Arrival Time</form:label>

                                        <div class="col-md-8">
                                            <form:input class="form-control" path="arrivalTime" id="arrivalTime"
                                                        name="arrivalTime" type="text"/>
                                            <form:errors path="arrivalTime" cssClass="error"/>
                                        </div>
                                    </div>
                                    <!-- // Group END -->
                                    <!-- Group -->
                                    <div class="form-group">

                                        <form:label class="col-md-4 control-label" path="departureTime"
                                                    for="departureTime">Departure Time</form:label>

                                        <div class="col-md-8">
                                            <form:input class="time form-control" path="departureTime"
                                                        id="departureTime"
                                                        name="departureTime" type="text"/>
                                            <form:errors path="departureTime" cssClass="error"/>
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
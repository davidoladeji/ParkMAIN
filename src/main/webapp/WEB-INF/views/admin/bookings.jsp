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
            <h2 class="margin-none pull-left">Bookings</h2>

            <div class="btn-group btn-group-sm pull-right">
                <a href="/admin/bookings/addPage" class="btn btn-primary">Add booking</a>
            </div>
            <div class="clearfix"></div>
            <!-- Widget -->
            <div class="widget widget-body-white">
                <!-- Widget heading -->
                <div class="widget-head">
                    <h4 class="heading glyphicons calendar"><i></i> ${timex}</h4>
                </div>
                <!-- // Widget heading END -->
                <div class="widget-body">

                    <div class="separator bottom">
                        Total bookings: ${numBookings}
                        <div class="clearfix"></div>
                    </div>
                    <!-- Table -->
                    <table class="table table-condensed table-striped table-primary table-vertical-center checkboxs">
                        <thead>
                        <tr>
                            <th style="width: 1%;" class="uniformjs">
                                <input type="checkbox"/>
                            </th>

                            <th style="width: 2%;" class="center">ID</th>
                            <th class="center">Receipt No.</th>
                            <th>Customer</th>
                            <th class="center">Arrival</th>
                            <th class="center">Departure</th>
                            <th class="center">Price (&euro;)</th>
                            <th class="center">Price</th>
                            <th class="center">Flight No.</th>
                            <th class="center" style="width: 150px;">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <!-- Item -->
                        <c:if test="${bookingx.size() != 0}">
                            <c:forEach items="${bookingx}" var="booking">

                                <tr class="selectable">
                                    <td class="center uniformjs">
                                        <input type="checkbox"/>
                                    </td>
                                    <td class="center">${bookingx.indexOf(booking)+1}</td>
                                    <td class="important">${booking.receiptno}</td>
                                    <td>
                                        <strong>${booking.account.firstName}, ${booking.account.lastName}</strong>
                                        <br/>
                                        <small>${booking.account.mobile}</small>
                                    </td>
                                    <td class="center">
                                            ${booking.arrivalDate}
                                        <br/>
                                            ${booking.arrivalTime}
                                    </td>
                                    <td class="center">
                                            ${booking.departureDate}
                                        <br/>
                                            ${booking.departureTime}
                                    </td>
                                    <td class="center">&pound; ${booking.base_price}</td>
                                    <td class="center">&euro; ${booking.destinationPrice}</td>
                                    <td class="center">${booking.flightNumber}</td>
                                    <td class="center">
                                        <div class="btn-group btn-group-sm">
                                            <a href="#" class="btn btn-default"><i class="fa fa-eye"></i></a>
                                            <a href="#" class="btn btn-success"><i class="fa fa-pencil"></i></a>
                                            <a href="#" class="btn btn-danger"><i class="fa fa-times"></i></a>
                                        </div>
                                    </td>
                                </tr>

                            </c:forEach>

                        </c:if>

                        <!-- // Item END -->
                        </tbody>
                    </table>
                    <!-- // Table END -->
                    <!-- With selected actions -->
                    <!-- // With selected actions END -->
                    <!-- Pagination -->
                    <ul class="pagination pull-right margin-none">
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
                    <div class="clearfix"></div>
                    <!-- // Pagination END -->
                </div>
            </div>
            <!-- // Widget -->
            <!-- Row -->
            <div class="row">
                <!-- Column -->
                <div class="col-md-4">
                    <!-- Widget -->
                    <div class="widget widget-3">
                        <!-- Widget heading -->
                        <div class="widget-head">
                            <h4 class="heading">
                                    <span class="glyphicons coins"><i></i>
                                    </span>Total amount(active)</h4>
                        </div>
                        <!-- // Widget heading END -->
                        <div class="widget-body large">
                            &pound;${totalActiveBookings}
                        </div>
                        <!-- Widget footer -->
                        <div class="widget-footer align-right">
                            <a href="#" class="glyphicons print"><i></i> Print</a>
                            <a href="#" class="glyphicons list"><i></i> View</a>
                        </div>
                        <!-- // Widget footer END -->
                    </div>
                    <!-- // Widget END -->
                </div>
                <!-- // Column END -->
                <!-- Column -->
                <div class="col-md-4">
                    <!-- Widget -->
                    <div class="widget widget-3">
                        <!-- Widget heading -->
                        <div class="widget-head">
                            <h4 class="heading">
                                    <span class="glyphicons coins"><i></i>
                                    </span>Total amount</h4>
                        </div>
                        <!-- // Widget heading END -->
                        <div class="widget-body large">
                            &pound;${totalSoldBookings}
                        </div>
                        <!-- Widget footer -->
                        <div class="widget-footer">
                            <a href="#" class="glyphicons print"><i></i> Print</a>
                            <a href="#" class="glyphicons list"><i></i> View</a>
                        </div>
                        <!-- // Widget footer END -->
                    </div>
                    <!-- // Widget END -->
                </div>
                <!-- // Column -->
                <!-- Column -->
                <div class="col-md-4">
                    <!-- Widget -->
                    <div class="widget widget-3">
                        <!-- Widget heading -->
                        <div class="widget-head">
                            <h4 class="heading">
                                    <span class="glyphicons user_remove"><i></i>
                                    </span>Cancellations</h4>
                        </div>
                        <!-- // Widget heading END -->
                        <div class="widget-body large cancellations">
                            4
                                <span>
                                    <span>Lost</span>
                                    <span>&euro;89.00</span>
                                </span>
                        </div>
                        <!-- Widget footer -->
                        <div class="widget-footer align-center">
                            <a href="#" class="glyphicons print"><i></i> Print</a>
                            <a href="#" class="glyphicons list"><i></i> View</a>
                        </div>
                        <!-- // Widget footer END -->
                    </div>
                    <!-- // Widget END -->
                </div>
                <!-- // Column -->
            </div>
            <!-- // Row END -->
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
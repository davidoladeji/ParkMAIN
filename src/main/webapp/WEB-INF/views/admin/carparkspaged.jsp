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

            <div class="clearfix"></div>
            <%--<div class="row">
                <!-- Column -->
                <div class="col-md-4">
                    <!-- Widget -->
                    <div class="widget margin-none">
                        <!-- Widget heading -->
                        <div class="widget-head">
                            <h4 class="heading">Last order</h4>
                            <a href="" class="details pull-right">view all</a>
                        </div>
                        <!-- // Widget heading END -->
                        <div class="widget-body">
                            <ul class="unstyled">
                                <li>
                                    <div class="media">
                                        <a class="pull-left">
                                            <img data-src="holder.js/50x50/dark"
                                                 class="media-object img-responsive"
                                                 alt="50x50">
                                        </a>

                                        <div class="media-body">
                                            <p class="margin-none text-uppercase">10 items</p>

                                            <p>
                                                <strong>&pound;5,900</strong>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <!-- // Widget END -->
                </div>
                <!-- // Column END -->
                <!-- Column -->
                <div class="col-md-4">
                    <!-- Widget -->
                    <div class="widget margin-none">
                        <!-- Widget heading -->
                        <div class="widget-head">
                            <h4 class="heading">Best seller</h4>
                            <a href="" class="details pull-right">view all</a>
                        </div>
                        <!-- // Widget heading END -->
                        <div class="widget-body">
                            <ul class="unstyled">
                                <li>
                                    <div class="media">
                                        <a class="pull-left">
                                            <img data-src="holder.js/50x50/dark"
                                                 class="media-object img-responsive"
                                                 alt="50x50">
                                        </a>

                                        <div class="media-body">
                                            <p class="margin-none">Product name</p>

                                            <p>
                                                <strong>&pound;2,900</strong>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <!-- // Widget END -->
                </div>
                <!-- // Column END -->
                <!-- Column -->
                <div class="col-md-4">
                    <!-- Widget -->
                    <div class="widget margin-none">
                        <!-- Widget heading -->
                        <div class="widget-head">
                            <h4 class="heading">Promotion</h4>
                            <a href="" class="details pull-right">view all</a>
                        </div>
                        <!-- // Widget heading END -->
                        <div class="widget-body">
                            <ul class="unstyled">
                                <li>
                                    <div class="media">
                                        <a class="pull-left">
                                            <img data-src="holder.js/50x50/dark"
                                                 class="media-object img-responsive"
                                                 alt="50x50">
                                        </a>

                                        <div class="media-body">
                                            <p class="margin-none">Product name</p>

                                            <p>
                                                <strong>&pound;1,800</strong>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <!-- // Widget END -->
                </div>
                <!-- // Column END -->
            </div>--%>
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
                        <!-- Filters -->
                        <%--<div class="filter-bar">
                            <form class="margin-none form-inline">
                                <!-- From -->
                                <div class="form-group col-md-2 padding-none">
                                    <label>From:</label>

                                    <div class="input-group">
                                        <input type="text" name="from" id="dateRangeFrom" class="form-control"
                                               value="08/05/13"
                                                />
                                            <span class="input-group-addon"><i class="fa fa-calendar"></i>
                                            </span>
                                    </div>
                                </div>
                                <!-- // From END -->
                                <!-- To -->
                                <div class="form-group col-md-2 padding-none">
                                    <label>To:</label>

                                    <div class="input-group">
                                        <input type="text" name="to" id="dateRangeTo" class="form-control"
                                               value="08/18/13"
                                                />
                                            <span class="input-group-addon"><i class="fa fa-calendar"></i>
                                            </span>
                                    </div>
                                </div>
                                <!-- // To END -->
                                <!-- Min -->
                                <div class="form-group col-md-2 padding-none">
                                    <label>Min:</label>

                                    <div class="input-group">
                                        <input type="text" name="from" class="form-control" value="100"/>
                                            <span class="input-group-addon"><i class="fa fa-euro"></i>
                                            </span>
                                    </div>
                                </div>
                                <!-- // Min END -->
                                <!-- Max -->
                                <div class="form-group col-md-2 padding-none">
                                    <label>Max:</label>

                                    <div class="input-group">
                                        <input type="text" name="from" class="form-control" value="500"/>
                                            <span class="input-group-addon"><i class="fa fa-euro"></i>
                                            </span>
                                    </div>
                                </div>
                                <!-- // Max END -->
                                <!-- Select -->
                                <div class="form-group col-md-3 padding-none">
                                    <label class="label-control">Select:</label>

                                    <div class="col-md-8 padding-none">
                                        <select name="from" class="form-control">
                                            <option>Some option</option>
                                        </select>
                                    </div>
                                </div>
                                <!-- // Select END -->
                                <div class="clearfix"></div>
                            </form>
                        </div>--%>
                        <!-- // Filters END -->
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
                        <c:forEach items="${carparkPage}" var="carpark" varStatus="loopStatus">
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
                                <td class="center">${carpark.averageprice}</td>
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
                            <div class="pagination">
                                <ul>
                                    <c:choose>
                                        <c:when test="${currentIndex == 1}">
                                            <li class="disabled"><a href="#">&lt;&lt;</a></li>
                                            <li class="disabled"><a href="#">&lt;</a></li>
                                        </c:when>
                                        <c:otherwise>
                                            <li><a href="${firstUrl}">&lt;&lt;</a></li>
                                            <li><a href="${prevUrl}">&lt;</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
                                        <c:url var="pageUrl" value="/admin/carparkspaged/${i}"/>
                                        <c:choose>
                                            <c:when test="${i == currentIndex}">
                                                <li class="active"><a href="${pageUrl}"><c:out value="${i}"/></a></li>
                                            </c:when>
                                            <c:otherwise>
                                                <li><a href="${pageUrl}"><c:out value="${i}"/></a></li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    <c:choose>
                                        <c:when test="${currentIndex == carparkPage.totalPages}">
                                            <li class="disabled"><a href="#">&gt;</a></li>
                                            <li class="disabled"><a href="#">&gt;&gt;</a></li>
                                        </c:when>
                                        <c:otherwise>
                                            <li><a href="${nextUrl}">&gt;</a></li>
                                            <li><a href="${lastUrl}">&gt;&gt;</a></li>
                                        </c:otherwise>
                                    </c:choose>
                                </ul>
                            </div>
                            <%--
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
                             </ul>--%>
                            <br/>
                            <util:pagination thispage="${carparkPage}"></util:pagination>

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
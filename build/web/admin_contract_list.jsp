<!DOCTYPE html>
<html lang="en">

    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <meta charset="UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no" name="viewport">
        <title>Bootstrap Components &rsaquo; Alert &mdash; Stisla</title>

        <!-- General CSS Files -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
              integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

        <!-- CSS Libraries -->

        <!-- Template CSS -->
        <link href="assets/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/components.css">
        <%@page import="java.util.List"%>
        <%@page import="sample.contracts.ContractDTO"%>
        <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    </head>

    <body>


        <div id="app">
            <div class="main-wrapper">
                <div class="navbar-bg" style=" background-color: #6777ef"></div>
                <nav class="navbar navbar-expand-lg main-navbar">
                    <form class="form-inline mr-auto">
                        <ul class="navbar-nav mr-3">
                            <li><a href="#" data-toggle="sidebar" class="nav-link nav-link-lg"><i
                                        class="fas fa-bars"></i></a></li>
                            <li><a href="#" data-toggle="search" class="nav-link nav-link-lg d-sm-none"><i
                                        class="fas fa-search"></i></a></li>
                        </ul>
                        <div class="search-element">
                            <input class="form-control" type="search" placeholder="Search" aria-label="Search"
                                   data-width="250">
                            <button class="btn" type="submit"><i class="fas fa-search"></i></button>
                            <div class="search-backdrop"></div>
                            <div class="search-result">
                                <div class="search-header">
                                    Histories
                                </div>

                                <div class="search-header">
                                    Contract
                                </div>
                                <div class="search-item">
                                    <a href="#">
                                        0123
                                    </a>
                                </div>
                                <div class="search-item">
                                    <a href="#">
                                        45674
                                    </a>
                                </div>
                            </div>
                        </div>
                    </form>

                    <%

                        String search = request.getParameter("search");
                        if (search == null) {
                            search = "";
                        }

                    %>

                    <div class="searchBar">
                        <form action="MainController">
                            <input type="hidden" name="search" placeholder="Search" required="" value="${param.search}"/> 
                            <input type="hidden" name="action" value="Search"/>
                        </form>

                        </br>
                    </div>



                    <ul class="navbar-nav navbar-right">
                        <li class="dropdown dropdown-list-toggle"><a href="#" data-toggle="dropdown"
                                                                     class="nav-link nav-link-lg message-toggle beep"><i class="far fa-envelope"></i></a>
                            <div class="dropdown-menu dropdown-list dropdown-menu-right">
                                <div class="dropdown-header">Messages
                                    <div class="float-right">
                                        <a href="#">Mark All As Read</a>
                                    </div>
                                </div>
                                <div class="dropdown-list-content dropdown-list-message">

                                </div>
                                <div class="dropdown-footer text-center">
                                    <a href="#">View All <i class="fas fa-chevron-right"></i></a>
                                </div>
                            </div>
                        </li>
                        <li class="dropdown dropdown-list-toggle"><a href="#" data-toggle="dropdown"
                                                                     class="nav-link notification-toggle nav-link-lg beep"><i class="far fa-bell"></i></a>
                            <div class="dropdown-menu dropdown-list dropdown-menu-right">
                                <div class="dropdown-header">Notifications
                                    <div class="float-right">
                                        <a href="#">Mark All As Read</a>
                                    </div>
                                </div>

                                <div class="dropdown-footer text-center">
                                    <a href="#">View All <i class="fas fa-chevron-right"></i></a>
                                </div>
                            </div>
                        </li>
                        <li class="dropdown"><a href="#" data-toggle="dropdown"
                                                class="nav-link dropdown-toggle nav-link-lg nav-link-user">
                                <img alt="image" src="assets/img/avatar/avatar-1.png" class="rounded-circle mr-1">
                                <div class="d-sm-none d-lg-inline-block">Hi, Employee</div>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right">
                                <div class="dropdown-title">Logged in 5 year ago</div>
                                <a href="features-profile.html" class="dropdown-item has-icon">
                                    <i style="padding-right: 30px" class="far fa-user"></i>    Profile
                                </a>

                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item has-icon text-danger">
                                    <form action="MainController" method="POST">
                                        <i style="padding-top: 10%" class="fas fa-sign-out-alt"></i><input class=" input-group-text" style="border-color: white; color: red;" type="submit" name="action" value="Logout"/>
                                    </form>
                                </a>
                            </div>
                        </li>
                    </ul>
                </nav>
                <div class="main-sidebar">
                    <aside id="sidebar-wrapper">
                        <div class="sidebar-brand">
                            <a href="employee_dashboard.html">DIPBRO</a>
                        </div>

                        <ul class="sidebar-menu">

                            <li class="nav-item dropdown ">
                                <a href="admin_dashboard.jsp" class="nav-link "><i
                                        class="fas fa-chart-bar"></i><span>Dashboard</span></a>
                            </li>

                            <li class="nav-item dropdown active">
                                <a href="MainController?action=Search&search=" class="nav-link "><i class="fas fa-newspaper" style="margin-left:5px;"></i> <span>Contract</span></a>

                            </li>
                            <li class="nav-item dropdown "><a class="nav-link " href="admin_guest_list.jsp"><i class="fas fa-user" style="margin-left:5px ;"></i> <span>Guest</span></a>
                            </li>
                            <li class="nav-item dropdown ">
                                <a href="admin_resident_list.jsp" class="nav-link "><i class="fas fa-user-friends" style="margin-left:5px ;"></i>
                                    <span>Resident</span></a>
                            </li>
                            <li class="nav-item dropdown ">
                                <a href="admin_employee_list.jsp" class="nav-link "><i class="fas fas fa-user-tie" style="margin-left:5px ;"></i>
                                    <span>Employee</span></a>
                            </li>
                    </aside>
                </div>

                <!-- Main Content -->
                <div class="main-content">
                    <section class="section">
                        <div class="section-header">
                            <h1>Contract List</h1>
                            <div class="section-header-breadcrumb">
                                <!-- <div class="breadcrumb-item active"><a href="#">Dashboard</a></div>
                  <div class="breadcrumb-item"><a href="#">Bootstrap Components</a></div>
                  <div class="breadcrumb-item">Alert</div> -->
                            </div>
                        </div>

                    </section>
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">List Contract</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <c:if test="${requestScope.CONTRACT_LIST_SEARCH !=null}">
                                    <c:if test="${not empty requestScope.CONTRACT_LIST_SEARCH }">
                                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                            <thead>
                                                <tr>
                                                    <th>Contract ID</th>
                                                    <th>Title</th>
                                                    <th>Fee</th>
                                                    <th>Username</th>
                                                    <th>Approve</th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <c:forEach var="contract" items="${requestScope.CONTRACT_LIST_SEARCH}">

                                                    <tr>
                                                <form action="MainController" method="POST"> 
                                                    <td>
                                                        <input type="hidden" name="contractID" value="${contract.contractID}"/>
                                                        ${contract.contractID}</td>
                                                    <td>${contract.contrTitle}
                                                        <div class="table-links">
                                                            in 
                                                            <div class="bullet"></div>
                                                            <button style="background-color: white ; border: none; "  type="submit" name="action" value="View">
                                                                View
                                                            </button>
                                                        </div>
                                                    </td>
                                                    <td>${contract.contrFee}</td>
                                                    <td>${contract.userName}</td>

                                                    <td>
                                                        <!--                                                        <input type="submit" name="action" value="Approve"/>-->
                                                        <input type="hidden" name="search" value="${param.search}"/>
                                                        <input class="btn btn-primary btn-action mr-1" type="submit" name="action" value="Edit"/>
                                                        <input class="btn btn-danger btn-action mr-1" type="submit" name="action" value="Remove"/>
                                                    </td>

                                                </form>  
                                                </tr>



                                            </c:forEach>


                                            </tbody>
                                        </table>
                                    </c:if>
                                </c:if>

                            </div>
                        </div>
                    </div>

                    <footer class="main-footer">
                        <div class="footer-left">
                            DIPBRO
                        </div>

                    </footer>
                </div>
            </div>

            <script src="assets/vendor/jquery/jquery.min.js"></script>
            <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

            <!-- Core plugin JavaScript-->
            <script src="assets/vendor/jquery-easing/jquery.easing.min.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="assets/js/sb-admin-2.min.js"></script>

            <!-- Page level plugins -->
            <script src="assets/vendor/datatables/jquery.dataTables.min.js"></script>
            <script src="assets/vendor/datatables/dataTables.bootstrap4.min.js"></script>

            <!-- Page level custom scripts -->
            <script src="assets/js/demo/datatables-demo.js"></script>
            <!-- General JS Scripts -->

            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.nicescroll/3.7.6/jquery.nicescroll.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
            <script src="assets/js/stisla.js"></script>

            <!-- JS Libraies -->
            <script src="node_modules/jquery-ui-dist/jquery-ui.min.js"></script>

            <!-- Template JS File -->
            <script src="assets/js/scripts.js"></script>
            <script src="assets/js/custom.js"></script>

            <!-- Page Specific JS File -->
            <script src="assets/js/page/components-table.js"></script>
    </body>

</html>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no" name="viewport">
        <title>Guest Detail</title>

        <!-- General CSS Files -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
              integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

        <!-- CSS Libraries -->

        <!-- Template CSS -->
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/components.css">
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
                                <a href="employee_dashboard.jsp" class="nav-link "><i
                                        class="fas fa-chart-bar"></i><span>Dashboard</span></a>
                            </li>

                            <li class="nav-item dropdown ">
                                <a href="MainController?action=Search&search=" class="nav-link "><i class="fas fa-newspaper"
                                                                                          style="margin-left:5px;"></i> <span>Contract</span></a>

                            </li>
                            <li class="nav-item dropdown "><a class="nav-link " href="employee_guest_list.jsp"><i class="fas fa-user" style="margin-left:5px ;"></i> <span>Guest</span></a>
                        </li>
                            <li class="nav-item dropdown active">
                                <a href="employee_resident_list.jsp" class="nav-link "><i class="fas fa-user-friends" style="margin-left:5px ;"></i>
                                    <span>Resident</span></a>
                            </li>
                        </ul>
                    </aside>
                </div>

                <!-- Main Content -->
                <div class="main-content">
                    <section class="section">
                        <div class="section-header">
                            <h1>Resident Detail</h1>
                            <div class="section-header-breadcrumb">
                                <div class="breadcrumb-item active"><a href="guest.jsp">Resident List</a></div>
                                <div class="breadcrumb-item"><a href="#">Resident Detail</a></div>
                            </div>
                        </div>
                        <div class="row mt-sm-4">
                            <div class="col-12 col-md-12 col-lg-5">

                                <img style="height: auto;max-height: 500px;max-width: 500px; width: auto; margin-left: 10%; border-radius: 20px" alt="image" src="https://i.ytimg.com/vi/AU2_cwQ6Zz4/maxresdefault.jpg" >
                                <div style="text-align: center; font-size: 20px;font-weight: bold; margin-top: 20px">Name: Ha ri macws hai</div>
                            </div>

                            <div class="col-12 col-md-12 col-lg-7">
                                <div class="card">
                                    <form method="post" class="needs-validation" novalidate="">

                                        <div class="card-body">
                                            <div class="row">
                                                <div class="form-group col-md-12 col-12">
                                                    <h3>General information</h3>
                                                </div>

                                                <div class="form-group col-md-6 col-12">
                                                    <label>Name</label>
                                                    <input type="text" class="form-control" value="Ujang" required="">
                                                    <div class="invalid-feedback">
                                                        Please fill in the first name
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="form-group col-md-7 col-12">
                                                    <label>Gender</label>
                                                    <input type="email" class="form-control" value="ujang@maman.com"
                                                           required="">
                                                    <div class="invalid-feedback">
                                                        Please fill in the email
                                                    </div>
                                                </div>
                                                <div class="form-group col-md-5 col-12">
                                                    <label>Birthday</label>
                                                    <input type="tel" class="form-control" value="">
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="form-group col-12">
                                                    <label>Address</label>
                                                    <textarea style="height: 100px;"
                                                              class="form-control summernote-simple"> VN.</textarea>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="form-group col-md-12 col-12">
                                                    <h3>Contact</h3>
                                                </div>

                                                <div class="form-group col-md-6 col-12">
                                                    <label>Email</label>
                                                    <input type="email" class="form-control" value="ujang@maman.com"
                                                           required="">
                                                    <div class="invalid-feedback">
                                                        Please fill in the email
                                                    </div>
                                                </div>
                                                <div class="form-group col-md-6 col-12">
                                                    <label>Phone</label>
                                                    <input type="text" class="form-control" value="Maman" required="">
                                                    <div class="invalid-feedback">
                                                        Please fill in the last name
                                                    </div>
                                                </div>

                                            </div>



                                        </div>
                                        <div class="card-footer text-right">
                                            <button class="btn btn-primary">Save Change</button>
                                        </div>
                                    </form>
                                </div>
                            </div>

                        </div>

                </div>
                </section>
            </div>
            <footer class="main-footer">
                <div class="footer-left">
                    DIPBRO
                </div>

            </footer>
        </div>
    </div>

    <!-- General JS Scripts -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"
    integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
    crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
    crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.nicescroll/3.7.6/jquery.nicescroll.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
    <script src="assets/js/stisla.js"></script>

    <!-- JS Libraies -->

    <!-- Template JS File -->
    <script src="assets/js/scripts.js"></script>
    <script src="assets/js/custom.js"></script>

    <!-- Page Specific JS File -->
</body>

</html>
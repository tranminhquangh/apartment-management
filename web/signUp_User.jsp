<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, shrink-to-fit=no" name="viewport">
        <title>Login User </title>

        <!-- General CSS Files -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">

        <!-- CSS Libraries -->
        <link rel="stylesheet" href="node_modules/bootstrap-social/bootstrap-social.css">

        <!-- Template CSS -->
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/components.css">
    </head>

    <body>
        <div id="app">
            <section class="section">
                <div class="d-flex flex-wrap align-items-stretch">
                    <div class="col-lg-4 col-md-6 col-12 order-lg-1 min-vh-100 order-2 bg-white">
                        <div class="p-4 m-3">
                            <img src="assets/img/Logo.png" alt="logo" width="80" class="shadow-light rounded-circle mb-5 mt-2">

                            <h4 class="text-dark font-weight-normal">Welcome to <span class="font-weight-bold">DIPBRO</span></h4>
                            <br/>
                            <br/>
                            <br/>
                            <form method="POST" action="MainController" class="needs-validation" novalidate="">
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input id="email" type="text" class="form-control" name="username" tabindex="1" required autofocus>
                                    <div class="invalid-feedback">
                                        Please fill in your email
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="d-block">
                                        <label for="password" class="control-label">Password</label>
                                        <div class="float-right">

                                        </div>
                                    </div>
                                    <input id="password" type="password" class="form-control" name="password" tabindex="2" required>
                                    <div class="invalid-feedback">
                                        please fill in your password
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="d-block">
                                        <label for="password" class="control-label">RoleID</label>
                                    </div>
                                    <select name="roleid" class="form-control">
                                        <option class="form-control" value="GS">Guest</option>
                                        <option class="form-control" value="SL">Seller</option>
                                    </select>
                                </div>
                                
                                <div class="form-group">
                                    <div class="d-block">
                                        <label for="password" class="control-label">FullName</label>
                                        <div class="float-right">

                                        </div>
                                    </div>
                                    <input id="password" type="text" class="form-control" name="fullname" tabindex="2" required>
                                    <div class="invalid-feedback">
                                        please fill in your password
                                    </div>
                                </div>

                                <div class="form-group">
                                    <button style=" background-image: linear-gradient(to right, #6777ef,#acb5f6)" name="action" value="signupuser" type="submit" class="btn btn-primary btn-lg btn-block" tabindex="4">
                                        SignUp
                                    </button>
                                </div>
                                 
                            </form>


                        </div>
                        
                    </div>
                    <div class="col-lg-8 col-12 order-lg-2 order-1 min-vh-100 background-walk-y position-relative overlay-gradient-bottom" data-background="https://images.unsplash.com/photo-1485628390555-1a7bd503f9fe?crop=entropy&cs=tinysrgb&fm=jpg&ixlib=rb-1.2.1&q=80&raw_url=true&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2070">
                        <div class="absolute-bottom-left index-2">
                            <div class="text-light p-5 pb-2">
                                <div class="mb-5 pb-3">
                                    <h1 class="mb-2 display-4 font-weight-bold">Good Morning</h1>
                                    <h5 class="font-weight-normal text-muted-transparent">TP Ho Chi Minh, Viet Nam</h5>
                                </div>
                                Photo by <a class="text-light bb" target="_blank" href="https://unsplash.com/photos/a8lTjWJJgLA">Group 3</a> on <a class="text-light bb" target="_blank" href="https://unsplash.com">TP hcm</a>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>

        <!-- General JS Scripts -->
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
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

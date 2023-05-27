<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ page import="java.util.List" %>
        <%@ page import="java.sql.*,
        				javax.servlet.http.*,
        				java.util.*,
        				site.dao.*,
                        java.sql.ResultSet,
                        site.model.BlogPost,
                        site.web.LoginController,
                        site.utils.JDBCUtils,
        	 			site.model.*,
        				javax.servlet.*,
        				java.io.IOException" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Dashboard - SB Admin</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="<%= request.getContextPath() %>/backend/css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <style>
            /* Remove border for all input elements */
          input {
        border: none;
      width: 100%;
  box-sizing: border-box;
  outline: none;
  resize: vertical;
    }
        
            /* Add additional styles when input is focused */
            input:focus {
                outline: none;
            }
        
            /* Add additional styles when input is active */
            input:active {
                outline: none;
            }
        </style>
    </head>

    <body class="sb-nav-fixed">



        <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
            <!-- Navbar Brand-->
            <a class="navbar-brand ps-3" href="E:\java\may 2023\ZenBlog\index.html">Blog Website</a>
            <!-- Sidebar Toggle-->
            <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i
                    class="fas fa-bars"></i></button>
            <!-- Navbar Search-->
            <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">

            </form>
            <!-- Navbar-->
            <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button"
                        data-bs-toggle="dropdown" aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="">Account Settings</a></li>
                        <li>
                            <hr class="dropdown-divider" />
                        </li>
                        <li><a class="dropdown-item" href="#">Logout</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <div class="sb-sidenav-menu-heading"> </div>
                            <a class="nav-link" href="<%=request.getContextPath()%>/backend/index.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Dashboard
                            </a>


                            <a class="nav-link" href="<%=request.getContextPath()%>/backend/comment.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-comments"></i></div>
                                Comments Management
                            </a>
                            <a class="nav-link" href="<%=request.getContextPath()%>/backend/addpost.jsp">
                                <div class="sb-nav-link-icon"><i class="fas fa-plus"></i></div>
                                create Post
                            </a>

                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        Bootstrap
                    </div>
                </nav>
            </div>
            <%
            String SELECT_USER = "SELECT * FROM users WHERE username = '" + LoginController.usekaro + "'";
            try (Connection connection = JDBCUtils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER);) {
            System.out.println("USERt");
            ResultSet rs = preparedStatement.executeQuery();
            System.out.println("USERCONNET");
            
            while (rs.next()) {
            String firstName = rs.getString("firstname");
            String lastName = rs.getString("lastname");
            String passWord = rs.getString("password");
            String userName = rs.getString("username");
                        
            %>

            <div id="layoutSidenav_content">
                <main>
                <section class="vh-100" style="background-color: #f4f5f7;">
                    <div class="container py-5 h-100">
                        <div class="row d-flex justify-content-center align-items-center h-100">
                            <div class="col col-lg-6 mb-4 mb-lg-0">
                                <div class="card mb-3" style="border-radius: .5rem;">
                                    <div class="row g-0">
                                        <div class="col-md-4 gradient-custom text-center text-white"
                                            style="border-top-left-radius: .5rem; border-bottom-left-radius: .5rem;">
                                            <img src="https://static.vecteezy.com/system/resources/previews/000/550/731/original/user-icon-vector.jpg"
                                                alt="Avatar" class="img-fluid my-5" style="width: 80px;" />
                                       
                                            <i class="far fa-edit mb-5"></i>
                                        </div>
                                        <form action="/newblog/editprofile" method="post" class="col-md-8">
                                            <div class="card-body p-4">
                                                <h6>Information</h6>
                                                <hr class="mt-0 mb-4">
                                                <div class="row pt-1">
                                                    <div class="col-6 mb-3">
                                                        <h6>First Name</h6>
                                                        <input  class="text-muted" name="firstName" type="text" value="<%= firstName %>">
                                                     
                                                    </div>
                                                    <div class="col-6 mb-3">
                                                        <h6>Last Name</h6>
                                                    <input class="text-muted" type="text" name="lastName" value="<%= lastName %>">
                                                    </div>
                                                    <div class="col-6 mb-3">
                                                        <h6>Password</h6>
                                                        <input class="text-muted" type="text" name="passWord" value="<%= passWord %>">
                                                    </div>
                                                    <div class="col-6 mb-3">
                                                        <h6>Email</h6>
                                                        <input class="text-muted" type="text" name="email" value="<%= userName %>" readonly>
                                                    </div>
                                                    <div class="col-6 mb-3">
                                                        
                                                        <input class="text-muted" type="submit" value="submit" >
                                                    </div>
                                                </div>
                                                
                                        
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <% } } catch (SQLException exception) { JDBCUtils.printSQLException(exception); }%>
                </section>
                </main>
                
                <footer class="py-4 bg-light mt-auto">
                    <div class="container-fluid px-4">
                        <div class="d-flex align-items-center justify-content-between small">
                            <div class="text-muted">Copyright &copy; @...........2023</div>
                            <div>
                                <a href="#">Privacy Policy</a>
                                &middot;
                                <a href="#">Terms &amp; Conditions</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            crossorigin="anonymous"></script>
        <script src="<%= request.getContextPath() %>/backend/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"
            crossorigin="anonymous"></script>
        <script src="<%= request.getContextPath() %>/backend/assets/demo/chart-area-demo.js"></script>
        <script src="<%= request.getContextPath() %>/backend/assets/demo/chart-bar-demo.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
            crossorigin="anonymous"></script>
        <script src="<%= request.getContextPath() %>/backend/js/datatables-simple-demo.js"></script>
    </body>

    </html>
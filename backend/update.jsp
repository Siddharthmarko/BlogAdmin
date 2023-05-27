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
                                    <p style="color: white;">add a picture here</p>
                                </form>
                                <!-- Navbar-->
                                <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
                                    <li class="nav-item dropdown">
                                        <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown"
                                            aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                                        <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                            <li><a class="dropdown-item" href="#">Account Settings</a></li>
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
                                <div id="layoutSidenav_content">
                                    <% String SELECT_ALL_BLOG_POSTS="SELECT * FROM blog_posts WHERE user = '" + LoginController.usekaro + "'" ; try
                                        (Connection connection=JDBCUtils.getConnection(); PreparedStatement
                                        preparedStatement=connection.prepareStatement(SELECT_ALL_BLOG_POSTS);) { System.out.println("connecXXt"); ResultSet
                                        rs=preparedStatement.executeQuery(); System.out.println("RSonnecXXt"); while (rs.next()) {
                 String id=rs.getString("id");
                 String title=rs.getString("title"); 
                 String content=rs.getString("content");
                  String author=rs.getString("author");
                   String user=rs.getString("user");
                    String category=rs.getString("category"); %>
                                    <main>
                                        <div class="container-fluid px-4">
                                            <h1 class="mt-4">Add Post</h1>
                                            <ol class="breadcrumb mb-4">
                                                <li class="breadcrumb-item active">Add Post</li>
                                            </ol>
                                            <div class="container">
                        
                        
                                                <div class="col-lg-11 contact-form__wrapper p-5 order-lg-1">
                                                    <form action="<%=request.getContextPath()%>/updateblog?id=<%= id %>" method="post" class="contact-form form-validate" novalidate="novalidate">
                                                        <div class="row">
                                                            <div class="mb-3">
                                                                <div class="form-group">
                                                                    <label class="required-field" for="firstName">Title</label>
                                                                    <input type="text" value="<%= title %>" class="form-control" id="firstName" name="title">
                                                                </div>
                                                            </div>
                        
                                                            <div class=" mb-3">
                                                                <div class="form-group">
                                                                    <label class="required-field" for="email">author</label>
                                                                    <input type="text" class="form-control" id="email" value="<%= author %>" name="author">
                                                                </div>
                                                            </div>
                        
                                                            <div class=" mb-3">
                                                                <div class="form-group">
                                                                    <label for="phone">Category</label>
                                                                    <input type="tex" value="<%= category %>" class="form-control" id="phone" name="Category">
                                                                </div>
                                                            </div>
                        
                                                            <div class="col-sm-12 mb-3">
                                                                <div class="form-group">
                                                                    <label class="required-field" for="message">Content</label>
                                                                    <textarea class="form-control"  id="message" name="Content"
                                                                        rows="4"><%= content %></textarea>
                                                                </div>
                                                            </div>
                        
                                                            <div class="col-sm-12 mb-3">
                                                                <button type="submit" name="submit" class="btn btn-primary">Submit</button>
                                                            </div>
                        
                                                        </div>
                                                    </form>
                                                </div>
                                                <!-- End Contact Form Wrapper -->
                        
                                            </div>
                                        </div>
                                    </main>
                                    <% } } catch (SQLException exception) { JDBCUtils.printSQLException(exception); }%>

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
                            <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
                            <script src="<%= request.getContextPath() %>/backend/assets/demo/chart-area-demo.js"></script>
                            <script src="<%= request.getContextPath() %>/backend/assets/demo/chart-bar-demo.js"></script>
                            <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
                                crossorigin="anonymous"></script>
                            <script src="<%= request.getContextPath() %>/backend/js/datatables-simple-demo.js"></script>
                        </body>
                        
                        </html>
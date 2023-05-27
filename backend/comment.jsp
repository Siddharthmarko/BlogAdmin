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
    <link href="css/styles.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
    <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
        <!-- Navbar Brand-->
        <a class="navbar-brand ps-3" href="index.html">Bootstrap</a>
        <!-- Sidebar Toggle-->
        <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i
                class="fas fa-bars"></i></button>
        <!-- Navbar Search-->
        <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
            Add a picture here
        </form>
        <!-- Navbar-->
        <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown"
                    aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                    <li><a class="dropdown-item" href="#!">Account Settings</a></li>
                    <li>
                        <hr class="dropdown-divider" />
                    </li>
                    <li><a class="dropdown-item" href="">Logout</a></li>
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
            <main>
                <div class="container-fluid px-4">
                    <h1 class="mt-4">Comments Management</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item active">Comments Management</li>
                    </ol>
                    <div class="container-fluid px-4">
                        <div class="card mb-4">
                            <div class="card-header">
                                <i class="fas fa-table me-1"></i>

                            </div>
                            <div class="card-body">
                                <div
                                    class="datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns">
                                    <div class="datatable-top">
                                        <div class="datatable-dropdown">

                                        </div>
                                        
                                    </div>
                                    <div class="datatable-container">
                                        <table id="dashboardTable" class="datatable-table">
                                            <thead>
                                                <tr>
                                                    <th data-sortable="true" style="width: 17.04433497536946%;">
                                                        <a href="#" class="datatable-sorter">Title</a>
                                                    </th>
                                                    <th data-sortable="true" aria-sort="ascending"
                                                        class="datatable-ascending" style="width: 23.054187192118228%;">
                                                        <a href="#" class="datatable-sorter">Comments</a>
                                                    </th>
                                                    <th data-sortable="true" style="width: 15.566502463054189%;">
                                                        <a href="#" class="datatable-sorter">Comment User</a>
                                                    </th>
                                                    <th data-sortable="true" style="width: 11.330049261083744%;">
                                                        <a href="#" class="datatable-sorter">Author of post</a>
                                                    </th>
                                                    <th data-sortable="true" style="width: 11.330049261083744%;">
                                                        <a href="#" class="datatable-sorter">Operations</a>
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                    <%  String sql = "SELECT c.comment_id, c.post_id, c.author, c.content, b.title " +
                    "FROM comments c " +
                    "JOIN blog_posts b ON c.post_id = b.id";
                     try (Connection connection=JDBCUtils.getConnection(); PreparedStatement
                                                        preparedStatement=connection.prepareStatement(sql);) { System.out.println("connecXXt"); ResultSet
                                                        rs=preparedStatement.executeQuery(); System.out.println("RSonnecXXt"); 
                                                        while (rs.next()) {
                                                            
                String id = rs.getString("comment_id");
                String author = rs.getString("author");
                String content = rs.getString("content");
                String title = rs.getString("title");
                                                         %>
                                                    
                                                    
                                                        <tr data-index="2">
                                                            <td>
                                                                <%= title %>
                                                            </td>
                                                            <td>
                                                                <%= content %>
                                                            </td>
                                                            <td>
                                                                <%= author %>
                                                            </td>
                                                            <td>
                                                                <%= LoginController.usekaro %>
                                                            </td>
                                                            <td>
                                                            <a href="<%=request.getContextPath()%>/deletecomment?id=<%= id %>">delete</a>
                                                                <span style="margin-right: 20px;"></span>
                                                            
                                                            </td>
                                                    
                                                        </tr>
                                                        <% } } catch (SQLException exception) { JDBCUtils.printSQLException(exception); }%>

                                            </tbody>
                                        </table>

                                    </div>
                                    <div class="datatable-bottom">
                                        <nav class="datatable-pagination">
                                            <ul class="datatable-pagination-list"></ul>
                                        </nav>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
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
    <script src="js/scripts.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="assets/demo/chart-area-demo.js"></script>
    <script src="assets/demo/chart-bar-demo.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js"
        crossorigin="anonymous"></script>
    <script src="js/datatables-simple-demo.js"></script>
</body>

</html>
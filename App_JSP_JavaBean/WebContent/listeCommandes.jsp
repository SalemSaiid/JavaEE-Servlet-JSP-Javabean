<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="dao.*"%>
    <%@page import="java.util.ArrayList"%>
    
     <%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>


    <%
    
    Utilisateur utilisateur = (Utilisateur) request.getSession().getAttribute("user");
    	
    	if(utilisateur == null){
    		
    		 System.out.println( "c'est un anonyme !! ");
    		 response.sendRedirect("login.jsp");
    		
    	}else if( utilisateur.getRole().equals("admin") )
    	   
        {
        	
    		
        	
        }else  {
        	     
        	response.sendRedirect("Home");
        }
   
   %>

<%
  Operateur operateur = new Operateur();
  ArrayList<Commande> listeCommandes = operateur.getAllCommandes();
  
%>


<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
   <meta charset="utf-8" />
   <title>Data Tables</title>
   <meta content="width=device-width, initial-scale=1.0" name="viewport" />
   <meta content="" name="description" />
   <meta content="" name="author" />
   <link href="./assets/TemplateAdmin/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
   <link href="./assets/TemplateAdmin/assets/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" />
   <link href="./assets/TemplateAdmin/assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
   <link href="./assets/TemplateAdmin/css/style.css" rel="stylesheet" />
   <link href="./assets/TemplateAdmin/css/style_responsive.css" rel="stylesheet" />
   <link href="./assets/TemplateAdmin/css/style_default.css" rel="stylesheet" id="style_color" />

   <link href="./assets/TemplateAdmin/assets/fancybox/source/jquery.fancybox.css" rel="stylesheet" />
   <link rel="stylesheet" type="text/css" href="./assets/TemplateAdmin/assets/uniform/css/uniform.default.css" />
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="fixed-top">
   <!-- BEGIN HEADER -->
   <div id="header" class="navbar navbar-inverse navbar-fixed-top">
       <!-- BEGIN TOP NAVIGATION BAR -->
       <div class="navbar-inner">
           <div class="container-fluid">
               <!-- BEGIN LOGO -->
               <a class="brand" href="index.html">
                   <img src="./assets/TemplateAdmin/img/logo.png" alt="Admin Lab" />
               </a>
               <!-- END LOGO -->
               <!-- BEGIN RESPONSIVE MENU TOGGLER -->
               <a class="btn btn-navbar collapsed" id="main_menu_trigger" data-toggle="collapse" data-target=".nav-collapse">
                   <span class="icon-bar"></span>
                   <span class="icon-bar"></span>
                   <span class="icon-bar"></span>
                   <span class="arrow"></span>
               </a>
               <!-- END RESPONSIVE MENU TOGGLER -->
               
               <!-- END  NOTIFICATION -->
               <div class="top-nav ">
                   <ul class="nav pull-right top-menu" >
                      
                       <!-- BEGIN USER LOGIN DROPDOWN -->
                       <li class="dropdown">
                           <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                               <img width="20" height="20" src="<%= utilisateur.getPhoto() %>" alt="">
                               <span class="username"><%= utilisateur.getUsername() %></span>
                               <b class="caret"></b>
                           </a>
                           <ul class="dropdown-menu">
                               
                               <li><a href="logout.jsp"><i class="icon-key"></i> Log Out</a></li>
                           </ul>
                       </li>
                       <!-- END USER LOGIN DROPDOWN -->
                   </ul>
                   <!-- END TOP NAVIGATION MENU -->
               </div>
           </div>
       </div>
       <!-- END TOP NAVIGATION BAR -->
   </div>
   <!-- END HEADER -->
   <!-- BEGIN CONTAINER -->
   <div id="container" class="row-fluid">
      <!-- BEGIN SIDEBAR -->
      <div id="sidebar" class="nav-collapse collapse">
         <div class="sidebar-toggler hidden-phone"></div>
         <!-- BEGIN RESPONSIVE QUICK SEARCH FORM -->
         <div class="navbar-inverse">
            <form class="navbar-search visible-phone">
               <input type="text" class="search-query" placeholder="Search" />
            </form>
         </div>
         <!-- END RESPONSIVE QUICK SEARCH FORM -->
         <!-- BEGIN SIDEBAR MENU -->
          <ul class="sidebar-menu">

            <li class="has-sub active">
                  <a href="listeCommandes.jsp" class="">
                      <span class="icon-box"> <i class="icon-book"></i></span> Commades
                      
                  </a>
              </li>


                <li class="has-sub ">
                  <a href="listUtilisateur.jsp" class="">
                      <span class="icon-box"> <i class="icon-book"></i></span> Users
                      
                  </a>
              </li>


               <li class="has-sub">
                  <a href="listProduit.jsp" class="">
                      <span class="icon-box"> <i class="icon-book"></i></span> Produits
                      
                  </a>
              </li>


        </ul>


              </li>
              
          </ul>
         <!-- END SIDEBAR MENU -->
      </div>
      <!-- END SIDEBAR -->
      <!-- BEGIN PAGE -->
      <div id="main-content">
         <!-- BEGIN PAGE CONTAINER-->
         <div class="container-fluid">
            <!-- BEGIN PAGE HEADER-->
            <div class="row-fluid">
               <div class="span12">
                   <!-- BEGIN THEME CUSTOMIZER-->
                   <div id="theme-change" class="hidden-phone">
                       <i class="icon-cogs"></i>
                        <span class="settings">
                            <span class="text">Theme:</span>
                            <span class="colors">
                                <span class="color-default" data-style="default"></span>
                                <span class="color-gray" data-style="gray"></span>
                                <span class="color-purple" data-style="purple"></span>
                                <span class="color-navy-blue" data-style="navy-blue"></span>
                            </span>
                        </span>
                   </div>
                   <!-- END THEME CUSTOMIZER-->
                  <!-- BEGIN PAGE TITLE & BREADCRUMB-->     
                  <h3 class="page-title">
                     Data Tables
                     <small>Full DataTables Integration</small>
                  </h3>
                   <ul class="breadcrumb">
                       <li>
                           <a href="#"><i class="icon-home"></i></a><span class="divider">&nbsp;</span>
                       </li>
                       <li>
                           <a href="#">Administration</a> <span class="divider">&nbsp;</span>
                       </li>
                       <li><a href="#">Commandes</a><span class="divider-last">&nbsp;</span></li>
                   </ul>
                  <!-- END PAGE TITLE & BREADCRUMB-->
               </div>
            </div>
            <!-- END PAGE HEADER-->
            <!-- BEGIN PAGE CONTENT-->   
            <div class="row-fluid">
            </div>
            <!-- BEGIN ADVANCED TABLE widget-->
            <div class="row-fluid">
                <div class="span12">
                    <!-- BEGIN EXAMPLE TABLE widget-->
                    <div class="widget">
                        <div class="widget-title">
                            <h4><i class="icon-reorder"></i>Managed Table</h4>
                            <span class="tools">
                                <a href="javascript:;" class="icon-chevron-down"></a>
                                <a href="javascript:;" class="icon-remove"></a>
                            </span>
                        </div>
                        <div class="widget-body">
                             <table class="table table-striped table-bordered" id="sample_1">
                            <thead>
                               <tr>
                
                                             <th class="hidden-phone">ID</th>
                                             <th class="hidden-phone">IDUser</th>
                                             <th class="hidden-phone">Commande</th>
                                             <th class="hidden-phone">Prix Totale</th>
                                             <th>Action</th>
                
                                </tr>
                            </thead>
                            <tbody>
                               
                                 <% for(Commande u : listeCommandes) { %>
             <tr>
              
                
                <td><a href="Produit?id=<%= u.getId()%>&action=show"><%= u.getId() %></a></td>
                <td><%= u.getIdUser()%></td>
                <td><%= u.getCommande()%></td>
                <td><%= u.getTotale()%></td>
                
                
                <td> <a href="Commande?id=<%= u.getId()%>&action=deliver"> <input class="btn btn-success" type="button" value="Deliver"> </a> </td>
                
             </tr>
            <%} %>
                             </tbody>
                        </table>
                         
                        </div>
                    </div>
                    <!-- END EXAMPLE TABLE widget-->
                </div>
            </div>

            <!-- END ADVANCED TABLE widget-->

            <!-- END PAGE CONTENT-->
         </div>
         <!-- END PAGE CONTAINER-->
      </div>
      <!-- END PAGE -->
   </div>
   <!-- END CONTAINER -->
   <!-- BEGIN FOOTER -->
   <div id="footer">
       2013 &copy; Admin Lab Dashboard.
      <div class="span pull-right">
         <span class="go-top"><i class="icon-arrow-up"></i></span>
      </div>
   </div>
   <!-- END FOOTER -->
   <!-- BEGIN JAVASCRIPTS -->
   <!-- Load javascripts at bottom, this will reduce page load time -->
   <script src="./assets/TemplateAdmin/js/jquery-1.8.3.min.js"></script>
   <script src="./assets/TemplateAdmin/assets/bootstrap/js/bootstrap.min.js"></script>   
   <script src="./assets/TemplateAdmin/js/jquery.blockui.js"></script>
   <!-- ie8 fixes -->
   <!--[if lt IE 9]>
   <script src="./assets/TemplateAdmin/js/excanvas.js"></script>
   <script src="./assets/TemplateAdmin/js/respond.js"></script>
   <![endif]-->   
   <script type="text/javascript" src="./assets/TemplateAdmin/assets/uniform/jquery.uniform.min.js"></script>
   <script type="text/javascript" src="./assets/TemplateAdmin/assets/data-tables/jquery.dataTables.js"></script>
   <script type="text/javascript" src="./assets/TemplateAdmin/assets/data-tables/DT_bootstrap.js"></script>
   <script src="./assets/TemplateAdmin/js/scripts.js"></script>
   <script>
      jQuery(document).ready(function() {       
         // initiate layout and plugins
         App.init();
      });
   </script>
</body>
<!-- END BODY -->
</html>

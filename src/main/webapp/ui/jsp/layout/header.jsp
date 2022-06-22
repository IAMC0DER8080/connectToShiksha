<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- Topbar Start -->
<style>
.text-color{
color: #F9FCF9;
}
    
</style>

<div class="navbar-custom bgit-primary">
   <div class="container customContainer">
      <div class="nav-content">
         <div class="custom-logo-box text-color">
            
            MPASC College Portal
            
         </div>
         <ul class="list-unstyled mb-0 ml-auto listnav-others">
            <li class="button-menu-wrapper">
               <button class="button-menu-mobile waves-effect waves-light">
               <i class="fas fa-bars"></i>
               </button>
            </li>
         <%--   <li class="itgov-icon">
               <a href="javascript:void(0);">
               <img src="${pageContext.request.contextPath}/assets/images/notification.svg" alt="" />
               </a>
            </li>  --%> 
            <li class="itgov-icon">
               <a href="/connect-to-class/logout">  
               <img src="${pageContext.request.contextPath}/assets/images/logout.svg" alt="" />
               </a>
            </li>
         </ul>
      </div>
   </div>
</div>
<!-- end Topbar -->
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding='UTF-8'%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <!-- ========== Left Sidebar Start ========== -->
 
<div class="left-side-menu">
    <div class="h-100" data-simplebar>
        <!--- Sidemenu -->
   <div id="sidebar-menu">
       <ul id="side-menu">
           <li class="menu-title">
               <span class="menu-title-wel">Welcome,</span>
               <span class="menu-title-name">${username}</span>
           </li>
           <li class="side-menu-plist">
               <a href="/connect-to-class/dashboard">
                   <span> Dashboard </span> 
               </a>
           </li>
           <li class="side-menu-plist">
               <a href="/connect-to-class/search-page/all-lectures">
                   <span> Lectures </span>
               </a>
           </li>
           <li class="side-menu-plist">
               <a href="/connect-to-class/search-page/all-assignments">
                   <span> Assignments </span>
               </a>
           </li>
           <li class="side-menu-plist">
               <a href="/connect-to-class/search-page/calendar">
                   <span> Calendar </span>
               </a>
           </li>
           <!-- <li class="side-menu-plist">
               <a href="/connect-to-class/search-page/Packges">
                   <span> self service </span>
               </a>
           </li> -->
          <!--  <li class="side-menu-plist">
               <a href="/connect-to-class/search-page/Procedure">
                   <span> Search Procedure </span>
               </a>
           </li> -->
          <!--  <li class="side-menu-plist">
               <a href="/connect-to-class/search-page/Trigger">
                   <span> Search Trigger </span>
               </a>
           </li> -->
        
           <!-- <li class="side-menu-plist">
               <a href="/connect-to-class/difference-page">
                   <span> Compare Environment </span>
               </a>
           </li> -->
         
       </ul>
   </div>
   <!-- End Sidebar -->

    <div class="clearfix"></div>
</div>
<!-- Sidebar -left -->
</div>
<!-- Left Sidebar End -->
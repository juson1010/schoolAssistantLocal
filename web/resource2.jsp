<%--
  Created by IntelliJ IDEA.
  User: cqx
  Date: 16/6/1
  Time: 下午10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">
<head>

    <!-- start: Meta -->
    <meta charset="utf-8">
    <title>Bootstrap Metro Dashboard by Dennis Ji for ARM demo</title>
    <meta name="description" content="Bootstrap Metro Dashboard">
    <meta name="author" content="Dennis Ji">
    <meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
    <!-- end: Meta -->

    <!-- start: Mobile Specific -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- end: Mobile Specific -->

    <!-- start: CSS -->
    <link id="bootstrap-style" href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-responsive.min.css" rel="stylesheet">
    <link id="base-style" href="css/style.css" rel="stylesheet">
    <link id="base-style-responsive" href="css/style-responsive.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
    <!-- end: CSS -->


    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <link id="ie-style" href="css/ie.css" rel="stylesheet">
    <![endif]-->

    <!--[if IE 9]>
    <link id="ie9style" href="css/ie9.css" rel="stylesheet">
    <![endif]-->

    <!-- start: Favicon -->
    <link rel="shortcut icon" href="img/favicon.ico">
    <!-- end: Favicon -->




</head>

<body>

<!-- start: Header -->
<div class="navbar">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="index.html"><span>校园助手</span></a>

            <!-- start: Header Menu -->
            <div class="nav-no-collapse header-nav">
                <ul class="nav pull-right">
                    <li class="dropdown hidden-phone">
                        <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="icon-bell"></i>
								<span class="badge red">
								7 </span>
                        </a>
                        <ul class="dropdown-menu notifications">
                            <li class="dropdown-menu-title">
                                <span>You have 11 notifications</span>
                                <a href="#refresh"><i class="icon-repeat"></i></a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon blue"><i class="icon-user"></i></span>
                                    <span class="message">New user registration</span>
                                    <span class="time">1 min</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon green"><i class="icon-comment-alt"></i></span>
                                    <span class="message">New comment</span>
                                    <span class="time">7 min</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon green"><i class="icon-comment-alt"></i></span>
                                    <span class="message">New comment</span>
                                    <span class="time">8 min</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon green"><i class="icon-comment-alt"></i></span>
                                    <span class="message">New comment</span>
                                    <span class="time">16 min</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon blue"><i class="icon-user"></i></span>
                                    <span class="message">New user registration</span>
                                    <span class="time">36 min</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon yellow"><i class="icon-shopping-cart"></i></span>
                                    <span class="message">2 items sold</span>
                                    <span class="time">1 hour</span>
                                </a>
                            </li>
                            <li class="warning">
                                <a href="#">
                                    <span class="icon red"><i class="icon-user"></i></span>
                                    <span class="message">User deleted account</span>
                                    <span class="time">2 hour</span>
                                </a>
                            </li>
                            <li class="warning">
                                <a href="#">
                                    <span class="icon red"><i class="icon-shopping-cart"></i></span>
                                    <span class="message">New comment</span>
                                    <span class="time">6 hour</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon green"><i class="icon-comment-alt"></i></span>
                                    <span class="message">New comment</span>
                                    <span class="time">yesterday</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon blue"><i class="icon-user"></i></span>
                                    <span class="message">New user registration</span>
                                    <span class="time">yesterday</span>
                                </a>
                            </li>
                            <li class="dropdown-menu-sub-footer">
                                <a>View all notifications</a>
                            </li>
                        </ul>
                    </li>
                    <!-- start: Notifications Dropdown -->
                    <!--<li class="dropdown hidden-phone">-->
                    <!--<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">-->
                    <!--<i class="icon-calendar"></i>-->
                    <!--<span class="badge red">-->
                    <!--5 </span>-->
                    <!--</a>-->
                    <!--<ul class="dropdown-menu tasks">-->
                    <!--<li class="dropdown-menu-title">-->
                    <!--<span>You have 17 tasks in progress</span>-->
                    <!--<a href="#refresh"><i class="icon-repeat"></i></a>-->
                    <!--</li>-->
                    <!--<li>-->
                    <!--<a href="#">-->
                    <!--<span class="header">-->
                    <!--<span class="title">iOS Development</span>-->
                    <!--<span class="percent"></span>-->
                    <!--</span>-->
                    <!--<div class="taskProgress progressSlim red">80</div> -->
                    <!--</a>-->
                    <!--</li>-->
                    <!--<li>-->
                    <!--<a href="#">-->
                    <!--<span class="header">-->
                    <!--<span class="title">Android Development</span>-->
                    <!--<span class="percent"></span>-->
                    <!--</span>-->
                    <!--<div class="taskProgress progressSlim green">47</div> -->
                    <!--</a>-->
                    <!--</li>-->
                    <!--<li>-->
                    <!--<a href="#">-->
                    <!--<span class="header">-->
                    <!--<span class="title">ARM Development</span>-->
                    <!--<span class="percent"></span>-->
                    <!--</span>-->
                    <!--<div class="taskProgress progressSlim yellow">32</div> -->
                    <!--</a>-->
                    <!--</li>-->
                    <!--<li>-->
                    <!--<a href="#">-->
                    <!--<span class="header">-->
                    <!--<span class="title">ARM Development</span>-->
                    <!--<span class="percent"></span>-->
                    <!--</span>-->
                    <!--<div class="taskProgress progressSlim greenLight">63</div> -->
                    <!--</a>-->
                    <!--</li>-->
                    <!--<li>-->
                    <!--<a href="#">-->
                    <!--<span class="header">-->
                    <!--<span class="title">ARM Development</span>-->
                    <!--<span class="percent"></span>-->
                    <!--</span>-->
                    <!--<div class="taskProgress progressSlim orange">80</div> -->
                    <!--</a>-->
                    <!--</li>-->
                    <!--<li>-->
                    <!--<a class="dropdown-menu-sub-footer">View all tasks</a>-->
                    <!--</li>	-->
                    <!--</ul>-->
                    <!--</li>-->
                    <!-- end: Notifications Dropdown -->
                    <!-- start: Message Dropdown -->
                    <li class="dropdown hidden-phone">
                        <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="icon-envelope"></i>
								<span class="badge red">
								4 </span>
                        </a>
                        <ul class="dropdown-menu messages">
                            <li class="dropdown-menu-title">
                                <span>You have 9 messages</span>
                                <a href="#refresh"><i class="icon-repeat"></i></a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="avatar"><img src="img/avatar.jpg" alt="Avatar"></span>
										<span class="header">
											<span class="from">
										    	Dennis Ji
										     </span>
											<span class="time">
										    	6 min
										    </span>
										</span>
                                        <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="avatar"><img src="img/avatar.jpg" alt="Avatar"></span>
										<span class="header">
											<span class="from">
										    	Dennis Ji
										     </span>
											<span class="time">
										    	56 min
										    </span>
										</span>
                                        <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="avatar"><img src="img/avatar.jpg" alt="Avatar"></span>
										<span class="header">
											<span class="from">
										    	Dennis Ji
										     </span>
											<span class="time">
										    	3 hours
										    </span>
										</span>
                                        <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="avatar"><img src="img/avatar.jpg" alt="Avatar"></span>
										<span class="header">
											<span class="from">
										    	Dennis Ji
										     </span>
											<span class="time">
										    	yesterday
										    </span>
										</span>
                                        <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="avatar"><img src="img/avatar.jpg" alt="Avatar"></span>
										<span class="header">
											<span class="from">
										    	Dennis Ji
										     </span>
											<span class="time">
										    	Jul 25, 2012
										    </span>
										</span>
                                        <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                                </a>
                            </li>
                            <li>
                                <a class="dropdown-menu-sub-footer">View all messages</a>
                            </li>
                        </ul>
                    </li>

                    <!-- start: User Dropdown -->
                    <li class="dropdown">
                        <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="halflings-icon white user"></i> Dennis Ji
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-menu-title">
                                <span>Account Settings</span>
                            </li>
                            <li><a href="#"><i class="halflings-icon user"></i> Profile</a></li>
                            <li><a href="login.jsp"><i class="halflings-icon off"></i> Logout</a></li>
                        </ul>
                    </li>
                    <!-- end: User Dropdown -->
                </ul>
            </div>
            <!-- end: Header Menu -->

        </div>
    </div>
</div>
<!-- start: Header -->

<div class="container-fluid-full">
    <div class="row-fluid">


        <!-- start: Main Menu -->
        <div id="sidebar-left" class="span2">
            <div class="nav-collapse sidebar-nav">
                <ul class="nav nav-tabs nav-stacked main-menu">
                    <li><a href="index.html"><i class="icon-bar-chart"></i><span class="hidden-tablet"> 功能面板</span></a></li>

                    <li>
                        <!--<a class="dropmenu" href="#"><i class="icon-folder-close-alt"></i><span class="hidden-tablet"> 表格模块</span><span class="label label-important"> 3 </span></a>-->
                        <a class="dropmenu" href="#"><i class="icon-folder-close-alt"></i><span class="hidden-tablet"> 表格模块</span></a>
                        <ul>
                            <li><a class="submenu" href="#">&nbsp;&nbsp;<i class="icon-file-alt"></i><span class="hidden-tablet"> 发布表格</span></a></li>
                            <li><a class="submenu" href="#">&nbsp;&nbsp;<i class="icon-file-alt"></i><span class="hidden-tablet"> 查看结果</span></a></li>
                            <li><a class="submenu" href="#">&nbsp;&nbsp;<i class="icon-file-alt"></i><span class="hidden-tablet"> 查看记录</span></a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="dropmenu" href="#"><i class="icon-folder-close-alt"></i><span class="hidden-tablet"> 问卷模块</span></a>
                        <ul>
                            <li><a class="submenu" href="#">&nbsp;&nbsp;<i class="icon-file-alt"></i><span class="hidden-tablet"> 发布问卷</span></a></li>
                            <li><a class="submenu" href="#">&nbsp;&nbsp;<i class="icon-file-alt"></i><span class="hidden-tablet"> 查看结果</span></a></li>
                            <li><a class="submenu" href="#">&nbsp;&nbsp;<i class="icon-file-alt"></i><span class="hidden-tablet"> 查看记录</span></a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="dropmenu" href="#"><i class="icon-folder-close-alt"></i><span class="hidden-tablet"> 资源搜索</span></a>
                        <ul>
                            <li><a class="submenu" href="#">&nbsp;&nbsp;<i class="icon-file-alt"></i><span class="hidden-tablet"> 课件搜索</span></a></li>
                            <li><a class="submenu" href="#">&nbsp;&nbsp;<i class="icon-file-alt"></i><span class="hidden-tablet"> 试卷搜索</span></a></li>
                            <li><a class="submenu" href="#">&nbsp;&nbsp;<i class="icon-file-alt"></i><span class="hidden-tablet"> 表格搜索</span></a></li>
                            <li><a class="submenu" href="#">&nbsp;&nbsp;<i class="icon-file-alt"></i><span class="hidden-tablet"> 问卷搜索</span></a></li>
                            <li><a class="submenu" href="#">&nbsp;&nbsp;<i class="icon-file-alt"></i><span class="hidden-tablet"> 电子书搜</span></a></li>
                        </ul>

                    </li>
                    <li><a href="#"><i class="icon-edit"></i><span class="hidden-tablet"> 点名模块</span></a></li>
                    <li><a href="#"><i class="icon-list-alt"></i><span class="hidden-tablet"> 论坛模块</span></a></li>
                    <!--<li><a href="messages.html"><i class="icon-envelope"></i><span class="hidden-tablet"> Messages</span></a></li>-->
                    <!--<li><a href="tasks.html"><i class="icon-tasks"></i><span class="hidden-tablet"> Tasks</span></a></li>-->
                    <!--<li><a href="ui.html"><i class="icon-eye-open"></i><span class="hidden-tablet"> UI Features</span></a></li>-->
                    <!--<li><a href="widgets.html"><i class="icon-dashboard"></i><span class="hidden-tablet"> Widgets</span></a></li>-->
                    <!--<li><a href="typography.html"><i class="icon-font"></i><span class="hidden-tablet"> Typography</span></a></li>-->
                    <!--<li><a href="gallery.html"><i class="icon-picture"></i><span class="hidden-tablet"> Gallery</span></a></li>-->
                    <!--<li><a href="table.html"><i class="icon-align-justify"></i><span class="hidden-tablet"> Tables</span></a></li>-->
                    <!--<li><a href="calendar.html"><i class="icon-calendar"></i><span class="hidden-tablet"> Calendar</span></a></li>-->
                    <!--<li><a href="file-manager.html"><i class="icon-folder-open"></i><span class="hidden-tablet"> File Manager</span></a></li>-->
                    <!--<li><a href="icon.html"><i class="icon-star"></i><span class="hidden-tablet"> Icons</span></a></li>-->
                    <!--<li><a href="login.jsp"><i class="icon-lock"></i><span class="hidden-tablet"> Login Page</span></a></li>-->
                </ul>
            </div>
        </div>
        <!-- end: Main Menu -->

        <noscript>
            <div class="alert alert-block span10">
                <h4 class="alert-heading">Warning!</h4>
                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
            </div>
        </noscript>

        <!-- start: Content -->
        <div id="content" class="span10">


            <ul class="breadcrumb">
                <li>
                    <i class="icon-home"></i>
                    <a href="index.html">Home</a>
                    <i class="icon-angle-right"></i>
                </li>
                <li><a href="#">Tables</a></li>
            </ul>


            <div class="row-fluid">
                <div class="box blue span12">
                    <div class="box-header">
                        <h2><i class="halflings-icon white white hand-top"></i><span class="break"></span>选择模块</h2>
                        <div class="box-icon">
                            <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
                        </div>
                    </div>
                    <div class="box-content">

                        <a class="quick-button span2  search_btn" id="formSearch" value="form">
                            <i class="icon-table"></i>
                            <p>表格</p>
                        </a>

                        <a class="quick-button span2 search_btn" id="questionnaireSearch" value="questionnaire">
                            <i class="icon-edit"></i>
                            <p>问卷</p>
                        </a>
                        <a class="quick-button span2 search_btn" id="coursewareSearch" value="courseware">
                            <i class="icon-print"></i>
                            <p>课件</p>
                        </a>
                        <a class="quick-button span2 search_btn" id="ebookSearch" value="ebook">
                            <i class="icon-book"></i>
                            <p>电子书</p>
                        </a>

                        <a class="quick-button span2 search_btn" id="paperSearch" value="paper">
                            <i class="icon-list-alt"></i>
                            <p>试卷</p>
                        </a>

                        <a class="quick-button span2 " id="resource_upload">
                            <i  class="icon-file"></i>
                            <p>资源上传</p>
                        </a>

                        <div class="clearfix"></div>
                    </div>
                </div><!--/span-->

            </div><!--/row-->
            <div class="row-fluid " >
                <div class="box span12 " >
                    <div class="box-header" data-original-title>
                        <h2><i class="halflings-icon white user"></i><span class="break"></span>资源查找</h2>
                        <div class="box-icon">
                            <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
                        </div>
                    </div>
                    <div class="box-content" >
                        <table class="table table-striped table-bordered bootstrap-datatable datatable" id="search_datatable">
                            <thead>
                            <tr>
                                <th>资源名</th>
                                <th>上传时间</th>
                                <th>上传者</th>
                                <th>可信度</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>



                            <tr>
                                <td>Dennis Ji</td>
                                <td class="center">2012/03/01</td>
                                <td class="center">Member</td>
                                <td class="center">
                                    <span class="label label-warning">Pending</span>
                                </td>
                                <td class="center">
                                    <a class="btn btn-success" href="#">
                                        <i class="halflings-icon white zoom-in"></i>
                                    </a>

                                    <a class="btn btn-danger" href="#">
                                        <i class="halflings-icon white download"></i>
                                    </a>


                                </td>
                            </tr>


                            </tbody>
                        </table>
                    </div>
                </div><!--/span-->

            </div><!--/row-->

        </div><!--/.fluid-container-->

        <!-- end: Content -->
    </div><!--/#content.span10-->
</div><!--/fluid-row-->

<div class="modal hide fade" id="myModal">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h3>Settings</h3>
    </div>
    <div class="modal-body">
        <p>Here settings can be configured...</p>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn" data-dismiss="modal">Close</a>
        <a href="#" class="btn btn-primary">Save changes</a>
    </div>
</div>



<div class="modal hide fade" id="commentModel">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h3 id="commentModel_ResourceName">资源名</h3>
    </div>
    <div class="modal-body">
        <form class="form-horizontal" >
            <div class="control-group">
                <label class="control-label" for="focusedInput">标题名</label>
                <div class="controls">
                    <input class="input-xlarge focused" id="focusedInput" type="text">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="selectError">单元类型</label>
                <div class="controls">
                    <select id="selectError" data-rel="chosen">
                        <option>普通文本</option>
                        <option>多选</option>
                        <option>单选</option>
                        <option>身份证</option>
                        <option>手机号</option>
                        <option>学生证</option>
                    </select>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">是否必填</label>
                <div class="controls">
                    <label class="radio">
                        <input type="radio" name="unitType" value="required" checked=""/>是
                    </label>
                    <label class="radio">
                        <input type="radio" name="unitType" value="optional"/>否
                    </label>
                </div>
            </div>
        </form>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn" data-dismiss="modal">Close</a>
        <a href="#" class="btn btn-primary">Save changes</a>
    </div>
</div>



<div class="common-modal modal fade" id="common-Modal1" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-content">
        <ul class="list-inline item-details">
            <li><a href="http://themifycloud.com">Admin templates</a></li>
            <li><a href="http://themescloud.org">Bootstrap themes</a></li>
        </ul>
    </div>
</div>
<div class="clearfix"></div>

<footer>

    <p>
        <span style="text-align:left;float:left">&copy; 2013 <a href="http://themifycloud.com/downloads/janux-free-responsive-admin-dashboard-template/" alt="Bootstrap_Metro_Dashboard">JANUX Responsive Dashboard</a></span>

    </p>

</footer>

<!-- start: JavaScript-->

<script src="js/jquery-1.9.1.min.js"></script>
<script src="js/jquery-migrate-1.0.0.min.js"></script>

<script src="js/jquery-ui-1.10.0.custom.min.js"></script>

<script src="js/jquery.ui.touch-punch.js"></script>

<script src="js/modernizr.js"></script>

<script src="js/bootstrap.min.js"></script>

<script src="js/jquery.cookie.js"></script>

<script src='js/fullcalendar.min.js'></script>

<script src='js/jquery.dataTables.min.js'></script>

<script src="js/excanvas.js"></script>
<script src="js/jquery.flot.js"></script>
<script src="js/jquery.flot.pie.js"></script>
<script src="js/jquery.flot.stack.js"></script>
<script src="js/jquery.flot.resize.min.js"></script>

<script src="js/jquery.chosen.min.js"></script>

<script src="js/jquery.uniform.min.js"></script>

<script src="js/jquery.cleditor.min.js"></script>

<script src="js/jquery.noty.js"></script>

<script src="js/jquery.elfinder.min.js"></script>

<script src="js/jquery.raty.min.js"></script>

<script src="js/jquery.iphone.toggle.js"></script>

<script src="js/jquery.uploadify-3.1.min.js"></script>

<script src="js/jquery.gritter.min.js"></script>

<script src="js/jquery.imagesloaded.js"></script>

<script src="js/jquery.masonry.min.js"></script>

<script src="js/jquery.knob.modified.js"></script>

<script src="js/jquery.sparkline.min.js"></script>

<script src="js/counter.js"></script>

<script src="js/retina.js"></script>

<script src="js/custom.js"></script>


<script type="text/javascript">


    $(document).ready(function(){


        var searchDataTable = $("#search_datatable");

        $(".search_btn").click(function(){

            var resource_type =  $(this).attr("value");

            $("#search_datatable").dataTable({



                "sAjaxSource":"ajax/"+resource_type+"SearchResource.action",
//                'iDisplayLength': 10,
                "sPaginationType":"full_numbers",
                "serverSide": true,
                'bPaginate': true,
                "bLengthChange": false,
                "bDestroy":true,
                "sInfo":"_TOTAL_ entries to show (_START_ to _END_)",
                "oLanguage": {
                    "sZeroRecords": "NO Records for Table",
                    "sEmptyTable": "NO Records for Table",
                },
                "bScrollCollapse":true,
                "columns": [
                    {"data":"name" },
                    {"data":"uploadDate"},
                    {"data":"upload_user"},
                    {"data":"reliablity"},
                    {"defaultContent":
                    "<a class='btn btn-success' href='#'>"+
                    "<i class='halflings-icon white zoom-in'></i></a>"+
                    "<a class='btn btn-danger' href='#'> <i class='halflings-icon white download'></i></a>"}
                ],



                "fnServerData": function (sUrl, aoData, fnCallback) {



                    $.ajax({
                        type: "post",
                        url: sUrl,
                        dataType: 'json',
                        data:{"aoData":JSON.stringify(aoData)},
                        async:true,
                        success: function(result){
//                            alert("success "+result);
                            fnCallback(result);

                            alert("done!?");
                        },
                        error:function(result){
                            alert("fail "+result);
                        }
                    });
                }


            });




        });



        $("#resource_upload").click(function(){



        });






    });



</script>





<!-- end: JavaScript-->

</body>
</html>


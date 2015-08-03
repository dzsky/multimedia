<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<!--引入bootstrap CSS样式  -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css">
    <!--引入自定义样式  -->
    <link rel="stylesheet" href="css/main.css" type="text/css">
	<!--引入bootstrapValidator样式  -->
    <link rel="stylesheet" href="css/bootstrapValidator.min.css" type="text/css">
	<!--引入jquery  -->
	<script type="text/javascript" src="bootstrap/js/jquery-1.11.3.min.js"></script>
	<!--引入bootstrap JS插件 -->
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<!--引入bootstrapValidator JS插件 -->
	<script type="text/javascript" src="js/bootstrapValidator.js"></script> 

	<!--引入main.js -->
	<script type="text/javascript" src="js/main.js"></script>
	
	<title>首页</title>
</head>


<body>
	<div class="header">
		<div class="container">
			<div class="row">
				<nav class="navbar navbar-default col-lg-12 navbar-fixed-top navbar-inverse" role="navigation">
					<!-- <div class="header-logo"> -->
						<div class="navbar-header col-lg-2">
							
							<a href="index.html" class="navbar-brand "><strong>首 页</strong></a>
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
					<!-- </div> --><!-- header-logo结束 -->
					
					
						<div class="collapse navbar-collapse " id="navbar-collapse">
							<div class="header-nav">
								<ul class="nav navbar-nav">
									<li><a href="video.html">视频</a></li>
									<li><a href="audio.html">音频</a></li>
									<li><a href="picture.html">图像</a></li>
									<li><a href="document.html">文档</a></li>
								</ul>
							</div><!-- header-nav结束 -->	

							<form action="#" class="form-inline header-search" methed="post" id="search">
								<div class="form-group">
									<select class="form-control">

								    	<option value="all">全部</option>
								    	<option value="video">视频</option>
								    	<option value="audio">音频</option>
								    	<option value="picture">图像</option>
								    	<option value="document">文档</option>
								  	</select>
								 </div>
								<div class="form-group">
									<input type="text" class="form-control " placeholder="视频/音频/图像/文档"  size="20" id="searchText"/>
									<a href="javascript:void(0);" onclick="checkSearch()"><span class="glyphicon glyphicon-search"></span></a>
								</div>
							</form>
							<!-- header-search 结束-->	
							<div class="header-zone-login btn-group">
							
								<button type="button" class=" btn-group btn btn-primary " onclick="forwardToZone()"> 个人中心</button>	
							<%if(session.getAttribute("email") == null || (String)session.getAttribute("email") == "") {%>
								<button type="button" class="btn btn-info" data-toggle="modal" data-target=".login-reg">登录/注册</button>
							<%} 
								String myname = (String) session.getAttribute("myname");
								if(myname != null) {
							%>
								<button type="button" class=" btn-group btn btn-primary "><%=myname%></button>
							<%} %>
							</div>
						</div>	
					</nav>			
				</div>
			
		</div>
	</div><!-- header结束-->


		

	<div class="wrap">

		<div class="container index-backcolor">
		<div class="carousel">
			<div class="row col-lg-12 ">
				<div id="carousel" class="carousel slide" data-ride="carousel">
		  			<ol class="carousel-indicators">
			    		<li data-target="#carousel" data-slide-to="0" class="active"></li>
			    		<li data-target="#carousel" data-slide-to="1"></li>
			    		<li data-target="#carousel" data-slide-to="2"></li>
		  			</ol>
		  			<div class="carousel-inner" role="listbox">
		   	 			<div class="item active">
			  				<a href="videoPlay.html"><img src="images/1.jpg" alt="..."></a>
			  				<div class="carousel-caption">
			    				饥饿游戏
			  				</div>
		    			</div>
		    			<div class="item">
			      			<img src="images/2.jpg" alt="...">
			     	 			<div class="carousel-caption">
			        			灵魂尽头
			      			</div>
		    			</div>
		    			<div class="item">
					      	<img src="images/3.jpg" alt="...">
					     	 <div class="carousel-caption">
					        	蜘蛛侠
					      	</div>
		    			</div>
		  			</div>
		  			<a class="left carousel-control" href="#carousel" role="button" data-slide="prev">
			    		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			    		<span class="sr-only">Previous</span>
		  			</a>
		  			<a class="right carousel-control" href="#carousel" role="button" data-slide="next">
			    		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			    		<span class="sr-only">Next</span>
		  			</a>
				</div>
			</div>
		</div><!-- carousel结束-->

		<div class="content">
			<!-- <div class="container"> -->
			<div class="content-movie row col-lg-12 ">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#hotVideo" data-toggle="tab">热门</a></li>
					<li><a href="#newVideo" data-toggle="tab">最新</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="hotVideo">
						
					</div>
					
					<div class="tab-pane " id="newVideo">
						
					</div>
				</div>
			</div><!-- content-movie结束-->

			<div class="content-movie row col-lg-12">
				<ul class="nav nav-tabs">
					<li><a href="#hotAudio" data-toggle="tab">热门</a></li>
					<li><a href="#newAudio" data-toggle="tab">最新</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="hotAudio">
						
					</div>
					
					<div class="tab-pane " id="newAudio">
						
					</div>
				</div>
			</div><!-- content-movie结束-->

			<div class="content-movie row col-lg-12 ">
				<ul class="nav nav-tabs">
					<li><a href="#hotPicture" data-toggle="tab">热门</a></li>
					<li><a href="#newPicture" data-toggle="tab">最新</a></li>
				</ul>
				<div class="tab-content">
					
					</div>
					
					<div class="tab-pane " id="newPicture">
						
					</div>
				</div>
			</div><!-- content-movie结束-->
			<div class="content-movie row col-lg-12 ">
				<ul class="nav nav-tabs">
					<li><a href="#hotDocument" data-toggle="tab">热门</a></li>
					<li><a href="#newDocument" data-toggle="tab">最新</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="hotDocument">
						
					</div>
					
					<div class="tab-pane " id="newDocument">
						
					</div>
				</div>
			</div><!-- content-movie结束-->
			<!-- </div> -->
		</div><!-- content结束-->
	</div><!--container-->
	</div><!-- wrap结束-->


	<div class="footer">
		
		<div class="container">
			<div class="row">
				
			</div>
		</div>

	</div>



	
	<!-- 登录注册弹出框-->
	<div class="modal fade login-reg" tabindex="-1" role="dialog" aria-labelledby="LargeModalLabel" aria-hidden="true">
    	<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
				</div>
				<ul id="myTab" class="nav nav-pills" role="tablist">
				    <li class="active"><a href="#login" role="tab" data-toggle="pill">登录</a></li>
				    <li><a href="#rgs" role="tab" data-toggle="pill">注册</a></li>
				</ul>

				<div id="myTabContent" class="tab-content">
				    <div class="tab-pane fade in active" id="login">
				    	<div class="container">
					        <div class="row">
					            <!-- form: -->
					            <section>
					                <div class="col-lg-6 col-lg-offset-2">
					                    <div class="page-header">
					                        <h2>登录</h2>
					                    </div>

					                    <form id="loginForm" method="post" class="form-horizontal" action="loginAction.action">					                        
					                        <div class="form-group">
					                            <label class="col-lg-3 control-label">Email</label>
					                            <div class="col-lg-5">
					                                <input type="text" class="form-control" name="email" />
					                            </div>
					                        </div>

					                        <div class="form-group">
					                            <label class="col-lg-3 control-label">密码</label>
					                            <div class="col-lg-5">
					                                <input type="password" class="form-control" name="password" />
					                            </div>
					                        </div>

					                        <div class="form-group">
					                            <label class="col-lg-3 control-label" id="captchaOperation"></label>
					                            <div class="col-lg-2">
					                                <input type="text" class="form-control" name="captcha" />
					                            </div>
					                        </div>

					                        <div class="form-group">
					                            <div class="col-lg-9 col-lg-offset-3">
					                                <button type="submit" class="btn btn-primary" name="login" value="login">登录</button>
					                                <button type="button" class="btn btn-info" id="resetBtn">重置</button>
					                            </div>
					                        </div>
					                    </form>
					                </div>
					            </section>
					            <!-- :form -->
					        </div>
					    </div>
				    </div><!-- login结束-->

				    <div class="tab-pane fade" id="rgs">
				    	<div class="container">
					        <div class="row">
					            <!-- form: -->
					            <section>
					                <div class="col-lg-6 col-lg-offset-2">
					                    <div class="page-header">
					                        <h2>注册</h2>
					                    </div>

					                    <form id="rgsForm" method="post" class="form-horizontal" action="registerAction.action">
					                        

					                        <div class="form-group">
					                            <label class="col-lg-3 control-label">用户名</label>
					                            <div class="col-lg-5">
					                                <input type="text" class="form-control" name="username" />
					                            </div>
					                        </div>

					                        <div class="form-group">
					                            <label class="col-lg-3 control-label">Email</label>
					                            <div class="col-lg-5">
					                                <input type="text" class="form-control" name="rgsEmail" />
					                            </div>
					                        </div>

					                        <div class="form-group">
					                            <label class="col-lg-3 control-label">密码</label>
					                            <div class="col-lg-5">
					                                <input type="password" class="form-control" name="rgsPassword" />
					                            </div>
					                        </div>

					                        <div class="form-group">
					                            <label class="col-lg-3 control-label">重复密码</label>
					                            <div class="col-lg-5">
					                                <input type="password" class="form-control" name="confirmPassword" />
					                            </div>
					                        </div>            

					                        <div class="form-group">
					                            <label class="col-lg-3 control-label" id="rgsCaptchaOperation"></label>
					                            <div class="col-lg-2">
					                                <input type="text" class="form-control" name="rgsCaptcha" />
					                            </div>
					                        </div>

					                        <div class="form-group">
					                            <div class="col-lg-9 col-lg-offset-3">
					                                <button type="submit" class="btn btn-primary" name="signup" value="Sign up">注册</button>
					                              
					                                <button type="button" class="btn btn-info" id="rgsResetBtn">重置</button>
					                            </div>
					                        </div>
					                    </form>
					                </div>
					            </section>
					            <!-- :form -->
					        </div>
					    </div>
				    </div><!-- rgs结束-->
				</div>
				<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>

			</div><!-- content结束-->
		</div><!-- /.modal-dialog结束 -->	
	</div><!-- /.modal结束 -->




	<!-- 搜索为空时弹出提示框-->
	<div class="modal fade" id="searchModal"  tabindex="-1">
	    <div class="modal-dialog">
	    	<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
					<h4 class="modal-title">出错啦</h4>
				</div>
				<div class="modal-body">
					<p>搜索框内容不能为空</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>					
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal-dialog -->
	</div><!-- /.modal -->

<script type="text/javascript">
	
	/*
	取得视频信息
	 */
	function getIndexInfoByAjax(url, id){
		$.getJSON(url, function(data){

			for (var i = 0; i < 2; i++) {
				$("#"+id).append(
					"<div class='movie-info'>"
					+	"<a href='resourceViewAction.action?resourceId="+data.list[i].resourceId+"'><img src='images/movie-1.jpg' alt=''/></a>"
					+	"<div></div>"
					+	"<span class='movie-info-name'>"+data.list[i].resourceName+"</span>"
					+	"<span class='movie-info-view'>"+data.list[i].resourceView+"</span>"
					+"</div>"
				);		
			};
			
		});
	}

		
	getIndexInfoByAjax("indexGetVideoAction.action?type=hot", "hotVideo");
	getIndexInfoByAjax("indexGetVideoAction.action?type=new", "newVideo");
	getIndexInfoByAjax("indexGetVoiceAction.action?type=hot", "hotAudio");
	getIndexInfoByAjax("indexGetVoiceAction.action?type=new", "newAudio");
	getIndexInfoByAjax("indexGetPictureAction.action?type=hot", "hotPicture");
	getIndexInfoByAjax("indexGetPictureAction.action?type=new", "newPicture");
	getIndexInfoByAjax("indexGetDocumentAction.action?type=hot", "hotDocument");
	getIndexInfoByAjax("indexGetDocumentAction.action?type=new", "newDocument");

</script>

<!-- 登录JS判定-->
<script type="text/javascript">
	$(document).ready(function() {
   
    	function randomNumber(min, max) {
       		return Math.floor(Math.random() * (max - min + 1) + min);
    	};

    	$('#captchaOperation').html([randomNumber(1, 20), '+', randomNumber(1, 20), '='].join(' '));

    	$('#loginForm').bootstrapValidator({
        	message: '不可用',
        	feedbackIcons: {
            	valid: 'glyphicon glyphicon-ok',
            	invalid: 'glyphicon glyphicon-remove',
            	validating: 'glyphicon glyphicon-refresh'
        	},
        	fields: {

	            email: {
	            	message: 'Email不可用',
	                validators: {
	                    emailAddress: {
	                        message: '请输入有效的Email地址'
	                    },
	                    notEmpty: {
                        	message: 'Email不能为空'
                    	}
            
	                }
	            },

	            password: {
	                validators: {
	                    notEmpty: {
	                        message: '密码不能为空'
	                    }
	                }
	            },
          
	            captcha: {
	                validators: {
	                    callback: {
	                        message: '答案错误',
	                        callback: function(value, validator) {
	                            var items = $('#captchaOperation').html().split(' '), sum = parseInt(items[0]) + parseInt(items[2]);
	                            return value == sum;
	                        }
	                    }
	                }
	            }

        	}
    	});

    	
    	$('#loginBtn').click(function() {
        	$('#loginForm').bootstrapValidator('validate');
        	
    	});

    	$('#resetBtn').click(function() {
        	$('#loginForm').data('bootstrapValidator').resetForm(true);
    	});

	});
</script>



<!-- 注册JS判定-->
<script type="text/javascript">
	$(document).ready(function() {
    
    	function randomNumber(min, max) {
       		return Math.floor(Math.random() * (max - min + 1) + min);
    	};

    	$('#rgsCaptchaOperation').html([randomNumber(1, 20), '+', randomNumber(1, 20), '='].join(' '));

    	$('#rgsForm').bootstrapValidator({
        	message: '不可用',
        	feedbackIcons: {
            	valid: 'glyphicon glyphicon-ok',
            	invalid: 'glyphicon glyphicon-remove',
            	validating: 'glyphicon glyphicon-refresh'
        	},
        	fields: {
     
            	username: {
                	
                	validators: {
                    	notEmpty: {
                        	message: '用户名不能为空'
                    	},
                    	stringLength: {
                        	min: 6,
                        	max: 20,
                        	message: '用户名必须不少于6个字符，不多于20个字符'
                    	},
	                    regexp: {
	                        regexp: /^[a-zA-Z0-9_\u4e00-\u9fa5]+$/,
	                        message: '用户名只能包含中文、字母、数字和下划线'
	                    }
	                   
                	}
           	 	},

	            rgsEmail: {
	            	message: 'Email不可用',
	                validators: {
	                    emailAddress: {
	                        message: '请输入有效的Email地址'
	                    },
	                    notEmpty: {
                        	message: 'Email不能为空'
                    	}
	                }
	            },

	            rgsPassword: {
	                validators: {
	                    notEmpty: {
	                        message: '密码不能为空'
	                    },
	                    stringLength: {
                        	min: 6,
                        	max: 16,
                        	message: '密码必须不少于6个字符，不多于16个字符'
                    	},
	                    regexp: {
	                        regexp: /^[a-zA-Z0-9_]+$/,
	                        message: '密码只能包含英文字母、数字和下划线'
	                    },
	                    identical: {
	                        field: 'confirmPassword',
	                        message: '密码和确认密码不一致'
	                    },
	                    different: {
	                        field: 'username',
	                        message: '密码不能和用户名一致'
	                    }
	                }
	            },

	            confirmPassword: {
	                validators: {
	                    notEmpty: {
	                        message: '两次输入密码不一致'
	                    },
	                    identical: {
	                        field: 'rgsPassword',
	                        message: '密码和确认密码不一致'
	                    },
	                    different: {
	                        field: 'username',
	                        message: '密码不能和用户名一致'
	                    }
	                }
	            },
          
	            rgsCaptcha: {
	                validators: {
	                    callback: {
	                        message: '答案错误',
	                        callback: function(value, validator) {
	                            var items = $('#rgsCaptchaOperation').html().split(' '), sum = parseInt(items[0]) + parseInt(items[2]);
	                            return value == sum;
	                        }
	                    }
	                }
	            }

        	}
    	});

    	
    	$('#rgsBtn').click(function() {
        	$('#rgsForm').bootstrapValidator('validate');
        	
    	});

    	$('#rgsResetBtn').click(function() {
        	$('#rgsForm').data('bootstrapValidator').resetForm(true);
    	});

	});
</script>



</body>
</html>





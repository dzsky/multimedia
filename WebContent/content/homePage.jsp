<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<!--引入bootstrap CSS样式  -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css"/>
    <!--引入自定义样式  -->
    <link rel="stylesheet" href="css/main.css" type="text/css"/>
	<!--引入bootstrapValidator样式  -->
    <link rel="stylesheet" href="css/bootstrapValidator.min.css" type="text/css"/>
    <!--引入文件上传样式样式  -->
    <link rel="stylesheet" type="text/css" href="css/fileinput.min.css"/>
	<!--引入jquery  -->
	<script type="text/javascript" src="bootstrap/js/jquery-1.11.3.min.js"></script>
	<!--引入bootstrap JS插件 -->
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<!--引入bootstrapValidator JS插件 -->
	<script type="text/javascript" src="js/bootstrapValidator.js"></script> 
	<!--引入文件上传插件 -->
	<script type="text/javascript" src="js/fileinput.min.js"></script>

	<script type="text/javascript" src="js/fileinput_locale_zh.js"></script>
	<!--引入main.js -->
	<script type="text/javascript" src="js/main.js"></script>
	<!--引入分页插件 -->
	<script type="text/javascript" src="js/jquery.twbsPagination.js"></script>
	
	<title>个人中心</title>

</head>




<body>
<div align="left"><a href="index.jsp">首页</a></div>
<div align="center"><h2>个人主页 </h2></div>
<br/><hr/>
<div align="center">
	<a href="upload.jsp">上传文件</a>&nbsp;&nbsp;
	<a href="uploadRecordAction.action">上传记录</a>&nbsp;&nbsp;
	<a href="personalCommentAction.action">评论记录</a>&nbsp;&nbsp;
	<a href="personalInforAction.action">个人信息</a>
	<a href="collectRecordAction.action">我的收藏</a>
</div>
<br/>
<hr/>

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
									<li><a href="#">图像</a></li>
									<li><a href="#">文档</a></li>
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
								<button type="button" class="btn btn-info" >退出</button>
								<button type="button" class=" btn-group btn btn-primary "><span onclick="forwardToZone()">蓝天白云</span></button>
							</div>
						</div>	
					</nav>			
				</div>
			
		</div>
	</div><!-- header结束-->

	<div class="wrap wrap-zone">
		<div class="zone-user-info" >
			<div class="container">
				<div class="row col-lg-4 col-lg-offset-4">
					<div class="headPic" >
					<!-- <img  src="img/140.png" alt="140x140" > -->
						<img  class="img-circle" alt="140x140" src="img/headPic.jpg" onclick="alertZoneHeadPic()" style="cursor:pointer">
						<div >
						名侦探柯南
						</div>
					</div>
				</div>	
			</div>
		</div><!-- 用户信息结束-->

		<div class="zone-content">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#upload" data-toggle="tab" >上传资源</a></li>
							<li id="myUpload"><a href="#myUploadContent">我的上传</a></li>
							<!--   <li id="downloadRecord"><a href="#downloadRecordContent">下载记录</a></li> -->
							<li id="commentRecord"><a href="#commentRecordContent">评论记录</a></li>
							<li id="collection"><a href="#collectionContent">我的收藏</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="upload">
								<form enctype="multipart/form-data" method="post" action="uploadAction.action">
									<select name="selection">
										<option value="1">视频</option>
										<option value="2">音频</option>
										<option value="3">图片</option>
										<option value="4">文档</option>
									</select>
									<br/>
									<input id="input-upload" type="file" name="upload" multiple class="file-loading">
								</form>
								<!-- multiple class="file-loading" -->
							</div><!--upload结束 -->

							<div class="tab-pane" id="myUploadContent">
								<table class="table table-striped  table-hover">
									<thead>
										<tr>
											<th>序号</th>
											<th>名称</th>											
											<th>上传时间</th>
											<th>浏览量</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody id="uploadTable">
							
									</tbody>
								</table>
								<div class="container">
									<div class="row col-lg-6 col-lg-offset-3">
										<ul class="pagination" id="uploadPages">
										</ul>
									</div>
								</div>
							</div>

							<div class="tab-pane" id="commentRecordContent">
								<table class="table table-striped  table-hover">
									<thead>
										<tr>
											<th>序号</th>
<!-- 											<th>资源名称</th> -->
											<th>内容</th>
											<th>评论时间</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody id="commentTable">
										
									</tbody>
								</table>
								<div class="container">
									<div class="row col-lg-6 col-lg-offset-3">
										<ul class="pagination" id="commentPages"></ul>
									</div>
								</div>
							</div><!--commentRecordContent结束 -->

							<div class="tab-pane" id="collectionContent">
								<table class="table table-striped  table-hover">
									<thead>
										<tr>
											<th>序号</th>
											<th>名称</th>
											<th>收藏时间</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody id="collectTable">
										
									</tbody>
								</table>
								<div class="container">
									<div class="row col-lg-6 col-lg-offset-3">
										<ul class="pagination" id="collectPages">
										</ul>
									</div>
								</div>
							</div><!--download结束 -->

						</div><!--content结束 -->
					</div>
				</div>
			</div>
	</div>	



<div class="modal fade" id="zoneHeadPic">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">修改个人资料</h4>
            </div>
            <div class="modal-body">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#updateHeadPic" data-toggle="tab" >修改头像</a></li>
					<li><a href="#updateUsername" data-toggle="tab" >修改用户名</a></li>
					<li><a href="#updatePassword" data-toggle="tab" >修改密码</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active" id="updateHeadPic">
						<form enctype="multipart/form-data" method="post" action="#Action.action">
							<input id="userInfoUpload" type="file" name="file" multiple class="file-loading">
						</form>
					</div>
					<div class="tab-pane" id="updateUsername">
						<form role="form" id="rename" class="form-horizontal zone-update-margin" 	>
						  	<div class="form-group">
						  		<label class="col-lg-3 control-label">用户名</label>
						  		<div class="col-lg-5">    
						    		<input type="text" class="form-control" name="username" id="userName">
						    	</div>
							</div>
							<div class="form-group">
	                            <div class="col-lg-9 col-lg-offset-4">
	                                <button type="button" class="btn btn-primary" name="rename" onclick="toReUserName()">修改</button>
	                                <button type="button" class="btn btn-info" id="renameResetBtn">重置</button>
	                            </div>
	                        </div>
						</form> 
					</div>
					<div class="tab-pane" id="updatePassword">
						<form role="form"  id="repwd" class="form-horizontal zone-update-margin">
						  	<div class="form-group">
						  		<label class="col-lg-3 control-label">正在使用的密码</label>
						  		<div class="col-lg-5">		    
						    		<input type="text" class="form-control"  name="nowpwd" id="nowpwd">
						    	</div>
						    </div>
						    <div class="form-group">
						    	<label class="col-lg-3 control-label">新密码</label>
						  		<div class="col-lg-5">	
						    		<input type="text" class="form-control"  name="newpwd" id="newpwd">
						    	</div>
						    </div>
						    <div class="form-group">
						    	<label class="col-lg-3 control-label">确认新密码</label>
						  		<div class="col-lg-5">
						    		<input type="text" class="form-control"  name="confirmpwd" id="confirmpwd">
						    	</div>
							</div>
							<div class="form-group">
	                            <div class="col-lg-9 col-lg-offset-4">
	                                <button type="button" class="btn btn-primary" name="repwd" onclick="toRepwd()">修改</button>
	                                <button type="button" class="btn btn-info" id="repwdResetBtn">重置</button>
	                            </div>
	                        </div>
						</form> 
					</div>
				</div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->





<div class="modal fade" id="delete">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h2 class="modal-title">删除</h2>
            </div>
             <div class="modal-body">
				<h4 id="tishi">确定要删除么，一旦删除，不可恢复</h4>
             </div>
             <div class="modal-footer">
             	<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="confirmDelete()">确定</button>

                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<input type="hidden" value="1" id="uploadNowPage">
<input type="hidden" value="1" id="commentNowPage">
<input type="hidden" value="1" id="collectNowPage">
<input type="hidden" value="1" id="uploadTotalPage">
<input type="hidden" value="1" id="commentTotalPage">
<input type="hidden" value="1" id="collectTotalPage">

<input type="hidden" value="1" id="commentContent">

<input type="hidden" value="0" id="toDeleteId">
<input type="hidden" value="0" id="toDeleteType">

<script type="text/javascript">

	//将要删除的资源id和类型写入隐藏域
	function toDeleteUpload(resourceId){
		$('#delete').modal();
		$('#toDeleteId').val(resourceId);
		$('#toDeleteType').val("upload");
		
	}
	function toDeleteComment(resourceId){
		$('#delete').modal();
		$('#toDeleteId').val(resourceId);
		$('#toDeleteType').val("comment");
	}
	function toDeleteCollect(resourceId){
		$('#delete').modal();
		$('#toDeleteId').val(resourceId);
		$('#toDeleteType').val("collect");
	}


	function confirmDelete(){
		var resourceId = $('#toDeleteId').val();
		var deleteType = $("#toDeleteType").val();

		var url = "";
		var data = "";
		if (deleteType == 'upload') {
			$.ajax({
				type: "POST",
				url: "deleteResourceAction.action",     
				dataType: "json",
				data: 
				{
		            resourceId : resourceId
			    },
			    success: function(data)
			    {
			    	if (data) {
			    		alert("删除成功");
			    	}
			    	else{
			    		alert("删除失败");
			    	}
			    },
			    error: function()
			    {
			    	
			    	// $("#tishi").html("服务器连接失败");
			    	alert("服务器连接失败");
			    	
			    }

			});
		}

		if (deleteType == 'comment') {
			var comment = $("#commentContent").val();
			$.ajax({
				type: "POST",
				url: "deleteCommentAction.action",     
				dataType: "json",
				data: 
				{
		            resourceId : resourceId,
		            comment: comment
			    },
			    success: function(data)
			    {
			    	if (data) {
			    		alert("删除成功");
			    	}
			    	else{
			    		alert("删除失败");
			    	}
			    },
			    error: function()
			    {
			    	alert("服务器连接失败");
			    }

			});
		}

		if (deleteType == 'collect') {
			$.ajax({
				type: "POST",
				url: "deleteCollectAction.action",     
				dataType: "json",
				data: 
				{
		            resourceId : resourceId
			    },
			    success: function(data)
			    {
			    	if (data) {
			    		alert("删除成功");
			    	}
			    	else{
			    		alert("删除失败");
			    	}
			    },
			    error: function()
			    {
			    	alert("服务器连接失败");
			    }

			});
		}
		
	}

</script>


<script type="text/javascript">
																	
		
					
			function getUploadDataByAjax(url){
				$.getJSON(url, function(data){
					$("#uploadTotalPage").val(data.pageTotal);
					for(var i=0; i<5; i++){
						$("#uploadTable").append(
							"<tr>"
							+	"<td>"+data.list[i].resourceId+"</td>"
							+	"<td>"+data.list[i].resourceName+"</td>"					
							+	"<td>"+data.list[i].resourceUploadTime+"</td>"
							+	"<td>"+data.list[i].resourceView+"</td>"
							+	"<td><button class='btn btn-info' type='button' onclick='toDeleteUpload("+data.list[i].resourceId+")'>删除</button></td>"
							+"</tr>"						
	    				);				
					}
	    		});
			}

			function getCommentDataByAjax(url){ 
				$.getJSON(url, function(data){
					// alert(data.listStr[0].resourceId);
					$("#commentTotalPage").val(data.pageTotal);
					for (var i = 0; i < 5; i++) {
						$("#commentTable").append(
							"<tr>"
							+	"<td>"+data.listStr[i].resourceId+"</td>"
							// +	"<td>"+data.listStr[i].resourceName+"</td>"					
							+	"<td>"+data.listStr[i].comment+"</td>"
							+	"<td>"+data.listStr[i].commentTime+"</td>"
							+	"<td><button class='btn btn-info' type='button' onclick='toDeleteComment("+data.listStr[i].resourceId+")'>删除</button></td>"
							+"</tr>"
						);
					};
						
				});
			}



			function getCollectDataByAjax(url){
				$.getJSON(url, function(data){
					$("#collectTotalPage").val(data.pageTotal);
					for(var i=0; i<5; i++){
						$("#collectTable").append(
							"<tr>"
							+	"<td>"+data.list[i].resourceId+"</td>"
							+	"<td>"+data.list[i].resourceName+"</td>"					
							+	"<td>"+data.list[i].collectTime+"</td>"
							+	"<td><button class='btn btn-info' type='button' onclick='toDelete("+data.list[i].resourceId+")'>删除</button></td>"
							+"</tr>"						
	    				);				
					}
				});
			}

			function setData(id){
				$("#"+id+"Table").html("");
				switch(id){
					case 'upload':
						getUploadDataByAjax('uploadRecordAction.action?page='+$("#"+id+"NowPage").val());
						break;
					case 'comment':
						getCommentDataByAjax('personalCommentAction.action?page='+$("#"+id+"NowPage").val());
						break;
					case 'collect':
						getCollectDataByAjax('collectRecordAction.action?page='+$("#"+id+"NowPage").val());
						break;
				}
		        
		        $('#'+id+'Pages').twbsPagination({
			        totalPages: $("#"+id+"TotalPage").val(),
			        visiblePages: 5,
			        version: '1.1',
			        onPageClick: function (event, page) {
			            $('#page-content').text('Page ' + page);
			            $("#"+id+"NowPage").val(page);
			         	if(page > 1){
			         		$("#"+id+"Table").html("");
			         		switch(id){
								case 'upload':
									getUploadDataByAjax('uploadRecordAction.action?page='+$("#"+id+"NowPage").val());
									break;
								case 'comment':
									getCommentDataByAjax('personalCommentAction?page='+$("#"+id+"NowPage").val());
									break;
								case 'collect':
									getCollectDataByAjax('collectRecordAction.action?page='+$("#"+id+"NowPage").val());
									break;
							}
			         		
			         	}
			    	}
				});
			}


			$("#myUpload a").click(function(e){
				e.preventDefault();
		        $(this).tab("show");
		        setData('upload');
			});


			$("#commentRecord a").click(function(e){
				e.preventDefault();
		        $(this).tab("show");
		        setData('comment');
			});

			$("#collection a").click(function(e){
				e.preventDefault();
		        $(this).tab("show");
		        setData('collect');
			});










		    // 验证修改用户名的合法性
		    $("#rename").bootstrapValidator({
		    	message: '不可用',
		    	feedbackIcons: {
            		valid: 'glyphicon glyphicon-ok',
            		invalid: 'glyphicon glyphicon-remove',
            		validating: 'glyphicon glyphicon-refresh'
        		},
        		fields:{
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
	           	 	}
        		}
		    });
		    $('#renameResetBtn').click(function() {
        		$('#rename').data('bootstrapValidator').resetForm(true);
        	});

		    //验证用户修改密码的合法性
		    $("#repwd").bootstrapValidator({
		    	message: '不可用',
		    	feedbackIcons: {
		    		valid: 'glyphicon glyphicon-ok',
            		invalid: 'glyphicon glyphicon-remove',
            		validating: 'glyphicon glyphicon-refresh'
		    	},
		    	fields: {
		    		nowpwd: {
		    			validators: {
		    				notEmpty: {
		    					message: '正在使用的密码不能为空'
		    				},
		    				different: {
		    					field: 'newpwd',
		    					message: '正在使用的密码不能和新密码一致'
		    				}
		    			}
		    		},
		    		newpwd: {
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
	                        	field: 'confirmpwd',
	                        	message: '密码和确认密码不一致'
	                    	}
	                	}
	            	},
	            	confirmpwd: {
	                	validators: {
	                    	notEmpty: {
	                        	message: '两次输入密码不一致'
	                    	},
	                    	identical: {
	                        	field: 'newpwd',
	                        	message: '密码和确认密码不一致'
	                    	}
	                	}
	            	}
		    	}
		    });
			$('#repwdResetBtn').click(function() {
        		$('#repwd').data('bootstrapValidator').resetForm(true);
        	});



	// 文件上传
	$("#input-upload").fileinput({
		language: "zh",
		browseClass: "btn btn-primary btn-block",
		showCaption: false,
		removeClass: "btn btn-danger",
		removeLabel: "删除",
		removeIcon: '<i class="glyphicon glyphicon-trash"></i>',
		uploadClass: "btn btn-info",
		uploadLabel: "上传",
		uploadIcon: '<i class="glyphicon glyphicon-upload"></i>',
		allowedFileExtensions : ['jpg', 'png','mp3','mp4','flv','doc','pdf','txt'],
		showUpload: true,
		maxFileSize: 1000000,
        maxFileCount: 1
   

        
	});

	$("#userInfoUpload").fileinput({
			language: "zh",
			previewFileType: "image",
			browseClass: "btn btn-success",
			browseLabel: "头像",
			browseIcon: '<i class="glyphicon glyphicon-picture"></i>',
			removeClass: "btn btn-danger",
			removeLabel: "删除",
			removeIcon: '<i class="glyphicon glyphicon-trash"></i>',
			uploadClass: "btn btn-info",
			uploadLabel: "上传",
			uploadIcon: '<i class="glyphicon glyphicon-upload"></i>',
			allowedFileExtensions : ['jpg', 'png','jpeg'],
			maxFileSize: 1000,
        	maxFileCount: 1
	});
	
	function toReUserName(){
		var username = $("#userName").val();
		$.ajax({
				type: "POST",
				url: "changeUsernameAction.action",     
				dataType: "json",
				data: 
				{
		            username : username
			    },
			    success: function(data)
			    {
			    	if (data) {
			    		alert("修改成功");
			    		$("#zoneHeadPic").modal('toggle');
			    		
			    	}
			    	else{
			    		alert("修改失败");
			    	}
			    },
			    error: function()
			    {
			    	alert("服务器连接失败");	    	
			    }

			});
		

	 }
	 
	 function toRepwd(){
	 	var nowpwd = $("#nowpwd").val();
	 	var newpwd = $("#newpwd").val();
	 	$.ajax({
				type: "POST",
				url: "changeInforAction.action.action",     
				dataType: "json",
				data: 
				{
		            nowpwd : nowpwd,
		            newpwd : newpwd
			    },
			    success: function(data)
			    {
			    	if (data) {
			    		alert("修改成功");
			    		$("#zoneHeadPic").modal('toggle');
			    		
			    	}
			    	else{
			    		alert("修改失败");
			    	}
			    },
			    error: function()
			    {
			    	alert("服务器连接失败");	    	
			    }

			});
	 }

	
</script>
	
</body>
</html>
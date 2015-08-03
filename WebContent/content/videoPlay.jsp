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

	<!-- 引入 Video.js 样式 -->
	<link href="js/video-js/video-js.css" rel="stylesheet" type="text/css">
	<!-- 引入 Video.js -->
	<script type="text/javascript" src="js/video-js/video.js"></script>
	<!--引入分页插件 -->
	<script type="text/javascript" src="js/jquery.twbsPagination.js"></script>
	<!-- 引入 Video.js语言包 -->
	<script type="text/javascript" src="js/video-js/zh-CN.js"></script>
	<!-- 本地flash -->
	<script>
	    videojs.options.flash.swf = "js/video-js/video-js.swf";
	</script>
	


	<!-- 如果没有使用Modernizr，则使用以下代码做shiv -->
	<script type="text/javascript">
	    document.createElement('video');document.createElement('audio');document.createElement('track');
	</script>



	<title>播放</title>
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
								<button type="button" class=" btn-group btn btn-primary "><span onclick="forwardToZone()">个人中心</span></button>
								<button type="button" class="btn btn-info" data-toggle="modal" data-target=".login-reg">登录/注册</button>
								<button type="button" class=" btn-group btn btn-primary "><span onclick="forwardToZone()">蓝天白云</span></button>
							</div>
						</div>	
					</nav>			
				</div>
			
		</div>
	</div><!-- header结束-->

	<div class="wrap-videoPlay">
		<div class="videoPlay-video">
			<div class="container">
				<div class="row col-lg-6 col-lg-offset-1">


					<!--   <object class id="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" width="960" height="400">
					  <param name="movie" value="flvplayer.swf">
					  <param name="quality" value="high">
					  <param name="allowFullScreen" value="true">
					  <param name="FlashVars" value="vcastr_file=<s:property value="resourceDomain.resourceList"/>&LogoText=duomeiti&BufferTime=3&IsAutoPlay=0">
					  <embed src="flvplayer.swf" allowfullscreen="true" flashvars="vcastr_file=<s:property value="resourceDomain.resourceList"/>&LogoText=duomeiti&IsAutoPlay=0" quality="high" pluginspage="http://www.macromedia.com/go/getflashplayer" type="application/x-shockwave-flash" width="960" height="400"></embed>

					</object> -->

				 <!-- <video id="example_video_1" class="video-js vjs-default-skin" controls preload="none" width="960" height="400"
	      			poster="http://video-js.zencoder.com/oceans-clip.png"
	      			data-setup="{}">
				    <source src="D:\hh.mp4" type='video/mp4' />
				
				    <track kind="captions" src="demo.captions.vtt" srclang="en" label="English"></track>
				    <track kind="subtitles" src="demo.captions.vtt" srclang="en" label="English"></track>
				    <p class="vjs-no-js"> <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a></p>
				  </video> -->

				  
				</div>
			</div>
		</div>
		<div class="video-operate">
			<div class="container">
				<div class="row col-lg-4 col-lg-offset-5">
					<button type="button" class="btn btn-info dispaly" id="addCollect" onclick="addCollect()">收藏</button>
					<button type="button" class="btn btn-info none" id="deleteCollect" onclick="deleteCollect()">取消收藏</button>
					<button type="button" class="btn btn-info" onclick="download()">下载</button>
				</div>
			</div>
			<br>
			<div class="container ">
				<div class="row col-lg-10 col-lg-offset-1 ">
					<div class="panel-group" id="accordion">
					    <div class="panel panel-default comment-back-color">
					        <div class="panel-heading">
					            <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#collapseOne"><button type="button" class="btn btn-info">评论 <span class="badge">42</span></button></a></h4>
					        </div>
					        <div id="collapseOne" class="panel-collapse collapse in">
					        
					        </div>
					        <div class="container">
								<div class="row col-lg-6 col-lg-offset-2">
									<ul class="pagination" id="coment-page">
									</ul>
								</div>
							</div>
					    </div><!-- 他人评论结束-->
					    <div class="panel panel-default comment-back-color" >
					        <div class="panel-heading">
					            <h4 class="panel-title"><a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo"><button type="button" class="btn btn-info">添加评论</button></a></h4>
					        </div>
					        <div id="collapseTwo" class="panel-collapse collapse">
					            <div class="panel-body">
					            	<div class="form-group">
								  		<div class="col-lg-5"> 
								  			<form >
									    		<textarea class="form-control" rows="3" name="comment-content" id="comment-content"></textarea>
									    		<br>
									    		<button type="button" class="btn btn-primary col-lg-3 col-lg-offset-4" onclick="submitComment()">提交</button>
								    		</form>   
								    	</div>
									</div>
					            </div>
					        </div>
					    </div><!-- 添加评论结束-->
					</div>
				</div>
			</div><!-- 评论和添加评论结束-->
			
		</div><!-- video-operate-->

		
	</div>


	<!-- <a href="images/1.jpg" download="ceshi.jpg">下载</a> -->

	

<div class="modal" id="commentStatus">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <p>评论</p>
            </div>
            <div class="modal-body">
				
				<p class="commentStatus">已评论</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


   <div class="modal" id="collectStatus">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <p>收藏</p>
            </div>
            <div class="modal-body">
				
				<p class="collectStatus">收藏成功</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->




<input type="hidden" value="1" id="commentNowPage">
<input type="hidden" value="1" id="commentTotalPage">



<script type="text/javascript">

	getCommnetDataByAjax();
	
	function getCommnetDataByAjax(){
		url = "resourceViewAction2.action?resourceId=<s:property value="resourceId"/>";
		$.getJSON(url, function(data){
			for (var i = 0; i < 2; i++) {
				$("#collapseOne").append(
					"<div class='panel-body'>"
		            +	"<div class='panel panel-info'>"
					+	    "<div class='panel-heading'>"+data.list2[i].userName+"<span style='float:right'>"+data.list2[i].commentTime+"</span></div>"
					+	    "<div class='panel-body'>"+data.list2[i].comment+"</div>"		
					+	"</div>"
		            +"</div>"
            	);
			};
		});
	}

	

		function submitComment(){
			var comment = $("#comment-content").val();
			
			$.ajax({
				type: "POST",
				url: "commentAction.action?resourceId=<s:property value="resourceId"/>",
				dataType: "json",
				data:
				{
					comment : comment
				},
				success: function(data)
				{
					if (data) {
						$('.commentStatus').text("已添加评论");
						$('#commentStatus').modal();
						$("#comment-content").val("");
						$('#collapseOne').html("");
						getCommnetDataByAjax();

					}
					else{
						$('.commentStatus').text("评论失败");
						$('#commentStatus').modal();
					}
				},
				error: function()
				{
					$('.commentStatus').text("服务器连接失败");
					$('#commentStatus').modal();
				}
			});
		}


		function addCollect(){
			$.ajax({
	            type: "POST",
	            url: "collectAction.action",
	            dataType: "json",
	            data: {
	                resourceId : <s:property value="resourceId"/>
	            },
	            success: function(data)
	            {
	                if (data)
	                {
	                    $("#addCollect").removeClass("dispaly");
	                    $("#addCollect").addClass("none");
	                    $(".collectStatus").text("收藏成功");
	      				alertCollectStatus();
	      				$("#deleteCollect").removeClass("none");
	                    $("#deleteCollect").addClass("dispaly");
	                }
	                else
	                {
	                	$(".collectStatus").text("收藏失败");
	                    alertCollectStatus();
	                }
	            },
	            error: function()
	            {
	            	$(".collectStatus").text("服务器连接失败");
	                alertCollectStatus();
	            }
	        });
	    }

	    function deleteCollect(){
			$.ajax({
	            type: "POST",
	            url: "deleteCollectAction.action",
	            dataType: "json",
	            data: {
	                resourceId : <s:property value="resourceId"/>
	            },
	            success: function(data)
	            {
	                if (data)
	                {
	                    $("#deleteCollect").removeClass("dispaly");
	                    $("#deleteCollect").addClass("none");
	                    $(".collectStatus").text("取消收藏成功");
	                    $("#addCollect").removeClass("none");
	                    $("#addCollect").addClass("dispaly");
	      				alertCollectStatus();
	                }
	                else
	                {
	                	$(".collectStatus").text("取消收藏失败");
	                    alertCollectStatus();
	                }
	            },
	            error: function()
	            {

	                $(".collectStatus").text("取消收藏失败");
	                    alertCollectStatus();
	            }
	        });
	    }

	    function download(){
	    	window.location.href="downloadAction.action?resourceId=<s:property value="resourceId"/>";
	    }


</script>
</body>
</html>
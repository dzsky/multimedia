<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<!--引入bootstrap CSS样式  -->
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css"/>
    <!--引入自定义样式  -->
    <link rel="stylesheet" href="css/main.css" type="text/css"/>
	<!--引入bootstrapValidator样式  -->
    <link rel="stylesheet" href="css/bootstrapValidator.min.css" type="text/css"/>
    <!-- 引入播放条样式-->
    <link rel="stylesheet" href="css/musicplaystyle.css" type="text/css"/>
	<!--引入jquery  -->
	<script type="text/javascript" src="bootstrap/js/jquery-1.11.3.min.js"></script>
	<!--引入bootstrap JS插件 -->
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<!--引入bootstrapValidator JS插件 -->
	<script type="text/javascript" src="js/bootstrapValidator.js"></script> 
	
	<!--引入main.js -->
	<script type="text/javascript" src="js/main.js"></script>
	<!--引入分页插件 -->
	<script type="text/javascript" src="js/jquery.twbsPagination.js"></script>
	<title>音频</title>
	<style type="text/css">
		.body{
			padding-top: 70px;
		}
	</style>
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
									<li class="active"><a href="audio.html">音频</a></li>
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
								<button type="button" class=" btn-group btn btn-primary "><span onclick="forwardToZone()">个人中心</span></button>
								<button type="button" class="btn btn-info" data-toggle="modal" data-target=".login-reg">登录/注册</button>
								<button type="button" class=" btn-group btn btn-primary "><span onclick="forwardToZone()">蓝天白云</span></button>
							</div>
						</div>	
					</nav>			
				</div>
			
		</div>
	</div><!-- header结束-->
<!-- ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| -->

	<div class="wrap" style="margin-top:50px;">
		<div class="container audio-backcolor">
			<div class="contet-audio row">
				<div class="col-lg-12" id="audioInfo">
					
					
		
				</div>
			</div>
			<!-- 分页 -->
			<div class="container">
				<div class="row col-lg-6 col-lg-offset-3">
					<ul class="pagination" id="pages"></ul>
				</div>
			</div><!-- 分页 -->
		</div>	
	</div>	

<!-- 播放器 ///////////////////////////////////////////////////////////////////  -->




	<div class="music_wrap">
		<div class="artist_info">
			<div class="artist_avatar"></div>
		</div>

		<div class="track">
			<a class="music_name">歌曲</a>	
		</div>

		<div class="control">
			<div class="option">
				<div class="time">-00:00</div>
				<div class="volume" title="音量">
					<p>&#xe604;</p>
				</div>
				<div class="volume_wrap hidden">
					<div class="volume_bar">
						<div class="volume_now"></div>
					</div>
				</div>
                <div class="progress_bar" id="bar">
				<div class="progress progress-striped">
					<div class="progress-bar progress-bar-info active" style="width:100%"></div>
				</div>
				<div class="buffer"></div>
			</div>
				<ul id="option_list">
					<li class="repeat" title="单曲循环">&#xe609;</li>
					<li class="shuffle" title="随机播放">&#xe608;</li>
					<li class="list" title="列表循环">&#xe606;</li>
				</ul>
			</div>

			

		  <div class="action_button">
				<div class="prev1" title="上一首">&#xe60d;</div>
			  <div class="play1" title="播放" id="play">&#xe60a;</div>
			  <div class="pause hidden" title="暂停">&#xe60b;</div>
				<div class="next1" title="下一首">&#xe60c;</div>
			</div>
		</div>

		<audio id="audio">
			<p>您的浏览器不支持HTML5播放器!</p>
		</audio>
	</div>
<script type="text/javascript" src="js/musicindex.js"></script>

<script type="text/javascript" src="js/musiclist.js"></script>


<input type="hidden" value="1" id="audioNowPage">
<input type="hidden" value="1" id="audioTotalPage">

<script type="text/javascript">




	
		function getAudioDataByAjax(url){

			$.getJSON(url, function(data){
				$("#audioTotalPage").val(data.pageToal);//存储总页码
				for (var i = 0; i < 8; i++) {
					$("#audioInfo").append(
						"<div class='movie-info'>"
						+	"<a href='javascript:void(0)' id='movie_"+i+"'><img src='images/movie-1.jpg' alt='' /></a>"
						+	"<div></div>"
						+	"<span class='movie-info-name'>"+data.list[i].resourceName+"</span>"
						+	"<span class='movie-info-view'>"+data.list[i].resourceView+"</span>"
						+"</div>"
					);
				}
				
			});
		}

		function setData(){
			$("#audioInfo").html("");
			getAudioDataByAjax("getVoiceAction.action?page="+$("#audioNowPage").val());
			$("#pages").twbsPagination({
				totalPages: $("#audioTotalPage").val(),
				visiblePages: 5,
				version: '1.1',
				onPageClick: function (event, page) {
			    	$('#page-content').text('Page ' + page);
			    	$("#audioNowPage").val(page);
			    	if (page > 1) {
			    		$("#audioInfo").html("");
			    		getAudioDataByAjax("getVoiceAction.action?page="+page);
			    	};
			    }
			});
		}


	setData();



</script>




<!--  |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| -->
	<!-- 登录注册弹出框-->
	



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




</body>
</html>
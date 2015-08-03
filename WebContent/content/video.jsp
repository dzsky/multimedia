<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <!--引入video css样式  -->
    <link rel="stylesheet" href="css/video-style.css"/>
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
	<title>视频</title>
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
									<li class="active"><a href="video.html" >视频</a></li>
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

<script type="text/javascript">
	movie();
</script>



<!-- ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| -->

	<div class="wrap-movie" style="top:auto;">
		<div class="container audio-backcolor">
			<div class="contet-audio row">
				<div class="col-lg-12">

               		<div class="g-doc">
					    <div class="g-bd">
					        <div class="g-mn">
					            <div class="m-slides">
					                <div class="imgwrap f-cb" id="imgwrap">
					                    <div class="banner banner-0" data-index="0"></div>
					                    <div class="banner banner-1" data-index="1"></div>
					                    <div class="banner banner-2" data-index="2"></div>
					                    <div class="banner banner-3" data-index="3"></div>
					                    <div class="banner banner-4" data-index="4"></div>
					                    <div class="banner banner-5" data-index="5"></div>
					                </div>
					            </div>
					            <div class="m-nav">
					                <div class="navswrap f-cb" id="navswrap">
					                    <div class="navwrap navwrap-0" data-index="0">
					                        <div class="nav"></div>
					                        <div class="prcsswrap">
					                            <div class="prcss"></div>
					                        </div>
					                    </div>
					                    <div class="navwrap navwrap-1" data-index="1">
					                        <div class="nav"></div>
					                        <div class="prcsswrap">
					                            <div class="prcss"></div>
					                        </div>
					                    </div>
					                    <div class="navwrap navwrap-2" data-index="2">
					                        <div class="nav"></div>
					                        <div class="prcsswrap">
					                            <div class="prcss"></div>
					                        </div>
					                    </div>
					                    <div class="navwrap navwrap-3" data-index="3">
					                        <div class="nav"></div>
					                        <div class="prcsswrap">
					                            <div class="prcss"></div>
					                        </div>
					                    </div>
					                    <div class="navwrap navwrap-4" data-index="4">
					                        <div class="nav nav-4"></div>
					                        <div class="prcsswrap">
					                            <div class="prcss"></div>
					                        </div>
					                    </div>
					                    <div class="navwrap navwrap-5" data-index="5">
					                        <div class="nav"></div>
					                        <div class="prcsswrap">
					                            <div class="prcss"></div>
					                        </div>
					                    </div>
					                </div>
					            </div>
					        </div>
					    </div>
					</div><!-- 轮播结束-->

					<ul class="nav nav-tabs nav-pills">
						<!-- <li class="active" id="byPlay"><a href="#play" >播放量</a></li> -->
						<li class="active" id="byDownload"><a href="#download">下载量</a></li>
						<li id="byTime"><a href="#time">上传时间</a></li>
						
					</ul>
					<div class="tab-content">

				<!-- 		<div class="tab-pane active" id="play">

							<div class="container" id="plays">
								<div class="row col-lg-6 col-lg-offset-3">
									<ul class='pagination' id='playPages'></ul>
								</div>
							</div>

						</div> -->


						<div class="tab-pane" id="download">

							<div class="container" id="downloads">
								<div class="row col-lg-6 col-lg-offset-3">
									<ul class='pagination' id='downloadPages'></ul>
								</div>
							</div>	
						</div>

						<div class="tab-pane" id="time">
							<div class="container" id="times">
								<div class="row col-lg-6 col-lg-offset-3">
									<ul class='pagination' id='timePages'></ul>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>	

<!-- <input type="hidden" value="1" id="playNowPage"> -->
<input type="hidden" value="1" id="downloadNowPage">
<input type="hidden" value="1" id="downloadTotalPage">
<input type="hidden" value="1" id="timeNowPage">
<input type="hidden" value="1" id="timeTotalPage">
<!-- <input type="hidden" value="1" id="generalNowPage"> -->



<script type="text/javascript">
	//$("#playNowPage").val();//取值
	//$("#playNowPage").val("10");//赋值


	// function page(page1){
	// 	addActive(page1);
	// 	//var page = page1;
	// 	// alert($("#page1").text());
		
	// 	// page = page1;
	// 	// $("#"+"page"+page).parent().addClass("active");
	// }

	// //求余
	// function getCompliment(page){
	
	// 	// return (Integer.valueOf(page) % 5);
	// 	if (page % 5 == 0) {
	// 		return 5;
	// 	};
	// 	/*else{
	// 		return (page % 5);
	// 	}	
	// }


	// //添加active样式
	// function addActive(page){
	// 	if(page > 1){
	// 		$("#previous").parent().removeClass();
	// 	}
	// 	else{
	// 		$("#previous").parent().addClass("disabled");
	// 	}

	// 	for(var page1=1; page1<=5; page1++)
	// 	{
	// 		$("#"+"page"+page1).parent().removeClass();
	// 	}
	// 	var activePage = getCompliment(page);
	// 	$("#"+"page"+activePage).parent().addClass("active");
	// }


	// function nextPage(){

	// }*/
	
	// $(document).ready(function () {
	//     $('#pages').twbsPagination({
	//         totalPages: 30,
	//         visiblePages: 5,
	//         version: '1.1',
	//         onPageClick: function (event, page) {
	//             $('#page-content').text('Page ' + page);
	//             alert(page);
	//         }
	//     });
	// });
	// 
	//
	
$(document).ready(function () {
	    

////测试dom加载后向后台请求后台数据////////////////////////////////////////////////////////////
///
	/*
		从后台获取数据
	 */
	function getVideoInfoByAjax(url, id){
		var url = url;
		var id = id;
	    $.getJSON(url, function(data){
	    	$("#"+id+"TotalPage").val(data.pageTotal);
	    		for(var i = 0; i < 6; i++){
	    			$("#"+id).before(
	    	    			"<a href='resourceViewAction.action?resourceId="+data.list[i].resourceId+"'><div class='audio-info' id='"+id+"ReadyToRefresh" +i+"'><img src='images/movie-1.jpg' alt=''/></a>"
	    	    			+ "<div></div>"
	    	    			+ "<span class='audio-info-name'>"+data.list[i].resourceName+"</span>"
	    	    			+ "<span class='audio-info-view'>"+data.list[i].resourceView+"</span>"
	    	    			+"</div>"
	    	    	);
	    		}
	    		
	    	});   	
	     
	}
	
	/*
	嵌入数据
	 */
	function setData(id, type){
    	for (var i = 1; i <= 12; i++) {
    		$("#"+id+"sReadyToRefresh"+i).remove();
    	};
    
    	getVideoInfoByAjax('getVideoAction.action?type='+type+'&page='+$("#"+id+"NowPage").val(), id+'s');
    	
        $('#'+id+'Pages').twbsPagination({
			totalPages: $("#"+id+"TotalPage").val(),
			visiblePages: 5,
			version: '1.1',
			onPageClick: function (event, page) {
			    $('#page-content').text('Page ' + page);
			    $("#"+id+"NowPage").val(page);
			    if (page > 1) {		    	
			    	for (var i = 1; i <= 12; i++) {
			    		$("#"+id+"sReadyToRefresh"+i).remove();
			    	};
			    	getVideoInfoByAjax('getVideoAction.action?type='+type+'&page='+page, id+'s');
			    };   
			}

		});
	
    }


	getVideoInfoByAjax('getVideoAction.action?type=hot&page=1', 'downloads');


	$('#downloadPages').twbsPagination({
	    totalPages: $("#downloadTotalPage").val(),
	    visiblePages: 5,
	    version: '1.1',
	    onPageClick: function (event, page) {
	        $('#page-content').text('Page ' + page);
	        $("#playNowPage").val(page);


	        if (page > 1) {
	        	
	        	for (var i = 1; i <= 12; i++) {
	        		$("#downloadsReadyToRefresh"+i).remove();
	        	};
	        	getVideoInfoByAjax('getVideoAction.action?type=hot&page='+page, 'downloads');
	        }; 
	    }     
	});






	// $("#byPlay a").click(function(e){
	// 	e.preventDefault();
 //        $(this).tab("show");
 // 		setData("play");
	// });

    $("#byDownload a").click(function(e){
    	e.preventDefault();
    	$(this).tab("show");
    	setData("download");
 	});

    $("#byTime a").click(function(e){
    	e.preventDefault();
        $(this).tab("show");
        setData("time");
 	});
    

    
////////////////////////////////////////////////////////////////////////////////////////////////

});
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

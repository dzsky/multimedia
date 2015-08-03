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
	<!--引入jquery media插件 -->
	<script type="text/javascript" src="js/jquery.media.js"></script>  
	<script type="text/javascript">  
	    $(function() {  
	        $('a.media').media({width:467, height:606});  
	    });  
	</script>  
	<title>搜索</title>
</head>


<body>
	<div class="header">
		<div class="container">
			<div class="row">
				<nav class="navbar navbar-default col-lg-12 navbar-fixed-top navbar-inverse" role="navigation">
					<!-- <div class="header-logo"> -->
						<div class="navbar-header col-lg-2">
							
							<a href="index.html" class="navbar-brand "><strong>首 页</strong></a>
							<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-1">
								<span class="sr-only">Toggle navigation</span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
								<span class="icon-bar"></span>
							</button>
						</div>
					<!-- </div> --><!-- header-logo结束 -->
					
					
						<div class="collapse navbar-collapse " id="navbar-collapse-1">
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

								    	<option>全部</option>
								    	<option>视频</option>
								    	<option>音频</option>
								    	<option>图像</option>
								    	<option>文档</option>
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
							</div>
						</div>	
					</nav>			
				</div>
			
		</div>
	</div><!-- header结束-->
	

	<div class="wrap">
		<div class="container audio-backcolor">
			<div class="contet-audio row">
				<div class="col-lg-12">
					<ul class="nav nav-tabs nav-pills">
						<li class="active"><a href="#download" data-toggle="tab" >下载量</a></li>
						<li id="uploadTime"><a href="#time">上传时间</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="download">
							<table class="table table-striped  table-hover">
								<thead>
									<tr>
										<th>序号</th>
										<th>名称</th>
										<th>上传者</th>
										<th>上传时间</th>
										<th>收藏</th>
										<th>下载</th>
										<th>预览</th>
									</tr>
								</thead>
								<tbody id="downloadTable">
									<tr>
										<td>001</td>
										<td>年轮 </td>
										<td>Tom</td>
										<td>2015.07.23</td>
										<td><button class="btn btn-info" type="button" onclick="collectResult()">收藏</button></td>
										<td><button class="btn btn-info" type="button" onclick="downloadRequest(id)">下载</button></td>
										<td><button class="btn btn-info" type="button" data-toggle="modal" data-target="#chakan">试听</button></td>
									</tr>
									<tr>
										<td>002</td>
										<td>年轮</td>
										<td>Jack</td>
										<td>2015.07.23</td>
										<td><button class="btn btn-info" type="button">收藏</button></td>
										<td><button class="btn btn-info" type="button">下载</button></td>
										<td><button class="btn btn-info" type="button">试听</button></td>
									</tr>
									<tr>
										<td>003</td>
										<td>年轮</td>
										<td>Frank</td>
										<td>2015.07.23</td>
										<td><button class="btn btn-info" type="button">收藏</button></td>
										<td><button class="btn btn-info" type="button">下载</button></td>
										<td><button class="btn btn-info" type="button">试听</button></td>
									</tr>
								</tbody>
							</table>
							<!-- 分页 -->
							<div class="container">
								<div class="row col-lg-6 col-lg-offset-3">
									<ul class="pagination" id="downloadPages">
									</ul>
								</div>
							</div>
						</div><!-- 下载量结束-->

						<div class="tab-pane" id="time">
							<table class="table table-striped  table-hover">
								<thead>
									<tr>
										<th>序号</th>
										<th>名称</th>
										<th>上传者</th>
										<th>上传时间</th>
										<th>收藏</th>
										<th>下载</th>
									</tr>
								</thead>
								<tbody id="timeTable">
									<tr>
										<td>001</td>
										<td>年轮</td>
										<td>Tom</td>
										<td>2015.07.23</td>
										<td><button class="btn btn-info" type="button">收藏</button></td>
										<td><button class="btn btn-info" type="button">下载</button></td>
									</tr>
									
								</tbody>
							</table>
							<!-- 分页 -->
							<div class="container">
								<div class="row col-lg-6 col-lg-offset-3">
									<ul class="pagination" id="timePages">
									</ul>
								</div>
							</div>

						</div><!-- 上传时间-->
					</div>
				</div>
			</div>
		</div>
	</div>	


<input type="hidden" value="1" id="downloadNowPage">
<input type="hidden" value="1" id="timeNowPage">
<input type="hidden" value="1" id="downloadTotalPage">
<input type="hidden" value="1" id="timeTotalPage">


<div class="modal fade" id="chakan">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h2 class="modal-title">试听</h2>
            </div>
             <div class="modal-body">
				<audio src="love in ccnu.mp3" controls  id="music">不支持html5</audio>
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



	<script type="text/javascript">

	function downloadRequest(id){
		window.location.href="#?"+id;
	}

			function collectResult(id){
				$.ajax({
		            type: "POST",
		            url: "#",
		            dataType: "json",
		            data: {
		                resourceId : id
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
		            	$(".collectStatus").text("收藏失败");
		                alertCollectStatus();
		            }
		        });
			}
	</script>

	<script type="text/javascript">

	function chakan(id){
		$("#chakan").modal();
	}

		$(document).ready(function () {

			

			function getSearchDataByAjax(url, id){
				$.getJSON(url, function(data){
					//获取数据并嵌入到html中
					$("#"+id+"TotalPage").val(data.pageToal);
					$("#"+id+"Table").append(
						"<tr>"
						+	"<td>"001"</td>"
						+	"<td>"年轮"</td>"
						+	"<td>"Tom"</td>"
						+	"<td>"2015.07.23"</td>"
						+	"<td><button class='btn btn-info' type='button' onclick='collectResult(id)'>收藏</button></td>"
						+	"<td><button class='btn btn-info' type='button' onclick='downloadRequest(id)'>下载</button></td>"
						+	"<td><button class='btn btn-info' type='button' onclick='chakan(id)'>查看</button></td>"
						+"</tr>"
					);
				});
			}

			function setData(url, id){
				$("#"+id+"Table").html("");
				getSearchDataByAjax(url+'?page='+$("#"+id+"NowPage").val(), id);


				$('#'+id+'Pages').twbsPagination({
			        totalPages: $("#"+id+"TotalPage").val(),
			        visiblePages: 5,
			        version: '1.1',
			        onPageClick: function (event, page) {
			            $('#page-content').text('Page ' + page);
			            $("#"+id+"NowPage").val(page);
			            if(page > 1){
			         		$("#"+id+"Table").html("");
			         		getSearchDataByAjax(url+'?page='+page, id);
			         	}
			         }
			     });
			}

			$("#download a").click(function(e){
				e.preventDefault();
			    $(this).tab("show");
				setData("#.action?type=","download");
			});	

			$("#uploadTime a").click(function(e){
				e.preventDefault();
			    $(this).tab("show");
				setData("#.action?type=","time");
			});


			getSearchDataByAjax(url,id);

			$('#downloadPages').twbsPagination({
			    totalPages: $("#downloadTotalPage").val(),
			    visiblePages: 5,
			    version: '1.1',
			    onPageClick: function (event, page) {
			        $('#page-content').text('Page ' + page);
			        $("#downloadNowPage").val(page);

			        if(page > 1){
		         		$("#"+id+"Table").html("");
		         		getSearchDataByAjax(url+'?page='+page,'download');
		         	} 
			    }     
			});


		    // $('#downloadPages').twbsPagination({
		    //     totalPages: 30,
		    //     visiblePages: 5,
		    //     version: '1.1',
		    //     onPageClick: function (event, page) {
		    //         $('#page-content').text('Page ' + page);
		         
		    //     }
		    // });


		    // $('#uploadTimePages').twbsPagination({
		    //     totalPages: 30,
		    //     visiblePages: 5,
		    //     version: '1.1',
		    //     onPageClick: function (event, page) {
		    //         $('#page-content').text('Page ' + page);
		            
		    //     }
		    // });
		    
		});

	</script>
</body>
</html>
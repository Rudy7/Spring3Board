<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
		<link rel="stylesheet" href="magnific-popup/magnific-popup.css">
		<script src="${path.js}/jquery-3.3.1.min.js"></script>
		<script src="magnific-popup/jquery.magnific-popup.js"></script>
		<script src="${path.js}/bootstrap.js"></script>
	<style>
		#tab-list-title{
			/* border: 1px solid gray; */
			margin: 0 auto;
			margin-top: 80px;
		}
		#tab-list{
			/* border: 1px solid gray; */
			margin: 0 auto;
			margin-top: 80px;
			width: 80%;
		}
		#tab-list tr{
			/* border: 1px solid gray; */
		}
		#tab-list tr td{
		    border: 1px solid gray;
		   /*  width: 70px; */
		}
		.text-center{
			text-align: center;
		}
		#inp-list{
			width: 97%;
		}
		#btn-list-search{
			/* border: 1px solid gray; */
			margin: 0 auto;
		}
		#div-page{
			margin: 0 auto;
			width: 24%;
		}
		#span-list-pagination{
			margin-left: 12%
		}
		.text-pagination{
			margin-left: 10%;
		} 
		#tr-list-attribute{
			margin-top: 30px;
		}
	</style>
</head>
<body>
		<a class="image-popup-vertical-fit" href="http://farm9.staticflickr.com/8241/8589392310_7b6127e243_b.jpg" 
		   title="Caption. Can be aligned to any side and contain any HTML.">
			  <img src="http://farm9.staticflickr.com/8241/8589392310_7b6127e243_s.jpg" width="75" height="75">
		</a>
		<table id="tab-list-title">
			
			<tr>
				<td>리스트</td>
			</tr>
		</table>
		
		<table id="tab-list">
			<tr>
				<td colspan="4">
					<input id="inp-list" name="inp-list" type="text" />
				</td>
				<td>
					<button id="btn-list-search" >검색</button>
				</td>
				<td>
					<button id="btn-list-write" >글쓰기</button>
				</td>
			</tr>
			<tr id="tr-list-attribute">
				<th class="text-center">NO</th>
				<th class="text-center">제목</th>
				<th class="text-center">작성자</th>
				<th class="text-center">작성일</th>
				<th class="text-center">조회수 </th>
				<th class="text-center">좋아요 :${pagi.startPage!=1}</th>
			</tr>
			<c:forEach begin="0" end="${pagi.pageSize-1}" items="${list}" step="1" var="board" varStatus=""> 
				<tr>
					<td class="text-center">${board.bbsSeq}</td>  <%-- ${i.index+1} --%>
					<td class="text-center">${board.title}</td>
					<td class="text-center">${board.userid}</td>
					<td class="text-center">${board.writedate}</td>
					<td class="text-center">${board.viewCount}</td>
					<td class="text-center">${board.good}</td>
					<td class="text-center">
						<a href="" 
						   id="btn-list-update">수정
						</a>
					</td>
					<td class="text-center">
						<a href="${path.context}/list/delete/${board.bbsSeq}" 
						   id="btn-list-delete${i.index+1}">삭제
						</a>
					</td>
				</tr>  <!-- ss -->
			</c:forEach>
		</table>
		
		<div id="div-page">
			<c:if test="${pagi.startPage!=1}">
				<a style="margin-right: 7px" href="${path.context}/list/${pagi.startPage-1}"><</a>
			</c:if>
			
			<c:forEach begin="${pagi.startPage}" end="${pagi.endPage}" step="1" var="pagi" varStatus="i">       
				<span id="span-list-pagination" class="text-pagination">
					<a href="${path.context}/list/${i.index}">${i.index}</a>
				</span>
			</c:forEach>
			
			<c:if test="${pagi.endPage!=pagi.totalPageCount}">
					<a style="margin-left: 7px;" href="${path.context}/list/${pagi.endPage+1}">></a>				
			</c:if>
		</div>
</body>
	<script>
		$('#btn-list-write').on('click', function(){
			alert("글쓰기 클릭이벤트");
			location.href="${path.context}/write";
		});  
		$('#btn-list-search').on('click', function(){
			alert("검색 클릭이벤트");
			location.href="${path.context}/list/1";
		});
		$(function(){
			$('.image-popup-vertical-fit').magnificPopup({
				type: 'image',
				closeOnContentClick: true,
				mainClass: 'mfp-img-mobile',
				image: {
					verticalFit: true
				}
			})
		});
		
	</script>
</html>
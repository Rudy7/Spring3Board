<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
		<script src="${path.js}/jquery-3.3.1.min.js"></script>
		<script src="${path.js}/bootstrap.js"></script>
	<style>
		#tab-mypage-title{
			/* border: 1px solid gray; */ 
			margin: 0 auto;
			margin-top: 80px;
		}
		#tab-mypage {
			/* border: 1px solid gray; */ 
			margin: 0 auto;
			margin-top: 80px;
		}
		#tab-mypage tr{
			/* border: 1px solid gray;  */
		}
		#tab-mypage tr td{
		    border: 1px solid gray; 
		}
		
	</style>	
		
</head>
<body>
	<table id="tab-mypage-title">
   		<tr>
   			<td>나의 페이지</td>
   		</tr>
 	</table> 	
	<table id="tab-mypage">
		<tr>
			<td>아이디</td>
			<td colspan="2">${loginUser.userid}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td colspan="2">${loginUser.name}</td>
		</tr>
		<tr>
			<td>가입날짜</td>
			<td  colspan="2">${loginUser.regdate}</td>
		</tr>
		<tr>
			<td>테스트 비밀번호</td>
			<td  colspan="2">${loginUser.password}</td>
		</tr>
		<tr>
			<td>
				<button id="btn-mypage-write">게시판</button>
			</td>
			<td>
				<button id="btn-mypage-enter">비밀번호 변경</button>
			</td>
			<td>
				<button id="btn-mypage-delete">탈퇴하기</button>
			</td>
		</tr>
	</table>
</body>
	<script>
		$('#btn-mypage-enter').on('click', function(){
			alert("변경 클릭");
			location.href="${path.context}/change";
		});
		$('#btn-mypage-delete').on('click', function(){
			alert("탈퇴 클릭");
			location.href="${path.context}/delete";
		})
		$('#btn-mypage-write').on('click', function(){
			alert("글씀 클릭");
			location.href="${path.context}/list/1";
		});
	</script>

</html>



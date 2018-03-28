<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
		<script src="${path.js}/jquery-3.3.1.min.js"></script>
		<script src="${path.js}/bootstrap.js"></script>
		<style>
		#tab-write-title{
			/* border: 1px solid gray; */
			margin: 0 auto;
			margin-top: 80px;
		}
		#tab-write{
			/* border: 1px solid gray; */
			margin: 0 auto;
			margin-top: 80px;
			width: 80%;
		}
		#tab-write tr{
			/* border: 1px solid gray; */
		}
		#tab-write tr td{
			/* border: 1px solid gray; */
			width:20%;
		}
		#inp-write-content{
			/* border: 1px solid gray; */
			width: 100%;
			height: 300px;
		}
		#inp-write-title{
			/* border: 1px solid gray; */
			width: 100%;
		}
		
		</style>
</head>
<body>
  <form id="form-write">
  
	<table id="tab-write-title">
		<tr>	
			<td>글쓰기</td>
		</tr>
	</table>
	<table id="tab-write">
		<tr>
			<td>제목</td>
			<td colspan="4">
				<input id="inp-write-title" name="inp-write-title" type="text" />
			</td>
		</tr>
		<tr>
			<td>이미지 첨부</td>
			<td colspan="4"></td>
		</tr>
		<tr>
			<td colspan="5" >
				<input id="inp-write-content" name="inp-write-content" type="text" placeholder="내용" />
			</td>
		</tr>
		<tr>
			<td colspan="3"></td>
			<td>
				<button id="btn-write-enter">확인</button>
			</td>
			<td>
				<button>취소</button>
			</td>
		</tr>
	</table>
	
  </form>	
</body>
	<script>	
		$('#btn-write-enter').on('click', function(){
			alert("확인 클릭");
			$('#form-write')
			.attr('action','${path.context}/write/insert')
			.attr('method','post')
			.submit();
		});
	</script>
</html>

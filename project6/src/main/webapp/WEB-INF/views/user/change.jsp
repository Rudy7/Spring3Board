<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
	<script src="${path.js}/jquery-3.3.1.min.js"></script>
	<script src="${path.js}/bootstrap.js"></script>
	<style>
		#tab-change-title{
			/* border: 1px solid gray;  */
			margin: 0 auto;
			margin-top: 80px;
		}
		#tab-change {
			/* border: 1px solid gray; */ 
			margin: 0 auto;
			margin-top: 80px;
		}
		#tab-change tr{
			/* border: 1px solid gray;  */
		}
		#tab-change tr td{
			/* border: 1px solid gray;  */
		}
		
	</style>
</head>
<body>
	<form id="from-change">
		<table id="tab-change-title">
    		<tr>
    			<td>비밀번호 변경하기</td>
    		</tr>
    	</table> 
		<table id="tab-change">
			<tr>
				<td>기존 비밀번호</td>
				<td>
					<input id="inp-change-before" name="inp-change-before" type="text" />
				</td>
			</tr>
			<tr>
				<td>변경할 비밀번호</td>
				<td>
					<input id="inp-change-after" name="inp-change-after" type="text" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button id="btn-change-enter">변경하기</button>
				</td>
			</tr>
		</table>
	
	</form>
</body>
	<script>
		$('#btn-change-enter').on('click', function(){
			alert("변경 클릭");
			$('#from-change')
			.attr('action', '${path.context}/login/change')
			.attr('method', 'post')
			.submit();
		})
	</script>
</html>
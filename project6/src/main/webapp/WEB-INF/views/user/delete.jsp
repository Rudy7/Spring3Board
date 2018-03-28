<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
		<script src="${path.js}/jquery-3.3.1.min.js"></script>	
		<script src="${path.js}/bootstrap.js"></script>
	<style>
		#tab-delete-title{
			/* border: 1px solid gray;  */
			margin: 0 auto;
			margin-top: 80px;
		}
		#tab-delete {
			/* border: 1px solid gray; */ 
			margin: 0 auto;
			margin-top: 80px;
		}
		#tab-delete tr{
			/* border: 1px solid gray;  */
		}
		#tab-delete tr td{
			/* border: 1px solid gray; */ 
		}
		
	</style>
</head>
<body>
	<form id="form-delete">
		<table id="tab-delete-title">
    		<tr>
    			<td>탈퇴하기</td>
    		</tr>
  	    </table> 
		<table id="tab-delete">
			<tr>
				<td>비밀번호</td>
				<td>
					<input id="inp-delete-password" name="inp-delete-password" type="text" />
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button id="btn-delete" >탈퇴하기</button>
				</td>
			</tr>
		</table>
	
	</form>
</body>
	<script>
		$('#btn-delete').on('click', function(){
			alert("탈퇴 클릭");
			$('#form-delete')
			.attr('action', '${path.context}/delete/member')
			.attr('method', 'post')
			.submit();
		});	
	
	</script>
</html>
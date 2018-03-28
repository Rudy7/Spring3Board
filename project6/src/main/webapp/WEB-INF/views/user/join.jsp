<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>Document</title>
		<script src="${path.js}/jquery-3.3.1.min.js"></script>
		<script src="${path.js}/bootstrap.js"></script>
	<style>
		#tab-join-title{
			/* border: 1px solid gray;  */
			margin: 0 auto;
			margin-top: 80px;
		}
		#tab-join {
			/* border: 1px solid gray;  */
			margin: 0 auto;
			margin-top: 80px;
		}
		#tab-join tr{
			/* border: 1px solid gray;  */
		}
		#tab-join tr td{
			/* border: 1px solid gray;  */
		}
		
	</style>
</head>
<body>
						
  <form id="form-join" >
	<table id="tab-join-title">
   		<tr>
   			<td>회원가입</td>
   		</tr>
    </table> 	
	<table id="tab-join">
		<tr>
			<td>아이디</td>
			<td>
				<input id="inp-join-userid" name="inp-join-userid" type="text" />
			</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>
				<input id="inp-join-password" name="inp-join-password" type="text" />
			</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>
				<input id="inp-join-name" name="inp-join-name" type="text" />
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<button id="btn-join-enter">확인 
				</button>
			</td>
		</tr>
	</table>
	
  </form>
</body>
	<script>
		$('#btn-join-enter').on('click', function(){
			alert("확인 클릭");
			$('#form-join')
			.attr('action','${path.context}/login/open')
			.attr('method','post')
			.submit();
		});
	</script>
</html>



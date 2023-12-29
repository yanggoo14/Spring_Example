<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- AJAX를 사용하려면 jquery원본 필요 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct" crossorigin="anonymous"></script>
</head>

<body>
	<div class="container">
		<h1>회원 정보 추가</h1>

		<form method="post" action="/lesson04/ex01/add_user">
			<div class="form-group">
				<label for="name"><b>이름</b></label> <input type="text" id="name"
					name="name" class="form-control col-3" placeholder="이름을 입력하세요">
			</div>
			<div class="form-group">
				<label for="yyyymmdd"><b>생년월일</b></label> <input type="text"
					id="yyyymmdd" name="yyyymmdd" class="form-control col-3"
					placeholder="예)20190101">
			</div>
			<div class="form-group">
				<label for="email"><b>이메일</b></label> <input type="text" id="email"
					name="email" class="form-control col-3" placeholder="이메일주소를 입력하세요">
			</div>
			<div class="form-group">
				<label for="introduce"><b>자기소개</b></label>
				<textarea id="introduce" name="introduce" class="form-control col-5"
					rows="10"></textarea>
			</div>

		<!-- AJAX로 할때는 submit이 되면 안되므로 button으로 변경 -->
			<input type="button" id="joinBtn" class="btn btn-success" value="추가">
		</form>
	</div>
	<script>
		$(document).ready(function(){
			
			//1. jquery sumit 이용하기 (원래 했던 방식)
			/*
			$("form").on('submit', function(e){
				//e.preventDefault(); //서브밋 기능 중단(다음 화면으로 넘어가지 않음)
				//alert("서브밋");
				
				// validation 처리
				let name = $("#name").val();
				if(name.length < 1){     // 1. 입력안했을때 
					alert("이름을 입력하세요.");
					return false;  //중간이 alert띄우고 빠져나가야함 (서브밋 X)
				}
				let yyyymmdd = $("#yyyymmdd").val();
				if(yyyymmdd == ""){     // 2. 입력안했을때 
					alert("생년월일을 입력하세요.");
					return false;  
				}
				let email = $("#email").val(); 
				if(!email){     //3. 입력안했을때 
					alert("이메일을 입력하세요");
					return false;
				}
				
				//여기까지 도달하면 submilt (화면이동)
			});
			*/
		
			// 2.) jquery의 AJAX 통신을 이용하기
			$("#joinBtn").on('click', function() {
				//alert("클릭");
				
				// validation 처리
				
				let name = $("#name").val();
				if(name.length < 1){     // 1. 입력안했을때 
					alert("이름을 입력하세요.");
					return;  //click은 return할때 false 없어도 빠져나옴
				}
				let yyyymmdd = $("#yyyymmdd").val();
				if(yyyymmdd == ""){     // 2. 입력안했을때 
					alert("생년월일을 입력하세요.");
					return;  
				}
				let email = $("#email").val(); 
				if(!email){     //3. 입력안했을때 
					alert("이메일을 입력하세요");
					return;
				}
				let introduce = $("#introduce").val();
				
				// 데이터가 넘어가는지 콘솔로 에러 확인해주기
				console.log(name);
				console.log(yyyymmdd);
				console.log(email);
				console.log(introduce);
				
				// AJAX: 비동기로 서버에 요청
				$.ajax({
					//request
					type:"POST"         // key명은 무조건 소문자로 해주기
					, url:"/lesson06/ex01/add-user"    //post방식일때 적어줘야함
					, data:{"name":name, "yyyymmdd":yyyymmdd, "email":email, "introduce":introduce}     //json으로 데이터를 보냄(기존 데이터명, id명)
					
					//response  
					, success:function(data) {  //콜백함수  요청을 하고 다시 요청을 받음, data param: 응답값
						alert(data);  //"성공"
						if(data == "성공"){
							location.href="/lesson06/ex01/after-add-user-view";  // 성공 후 GET요청
						}
					}
					, error:function(request, status, error) {
						alert(request);
						alert(status);
						alert(error);
					}
					, complete:function(data){  // 평소에는 안써도됨
						alert("성공이든 실패든 완료");
					}
				}); //ajax의 끝
			}); //click이벤트 끝
		}); // ready홤수 끝
	</script>
</body>
</html>
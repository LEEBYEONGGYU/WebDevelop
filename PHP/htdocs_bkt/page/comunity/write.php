<?php 
	if(isset($_SESSION['id'])){
?>

	
<!--- 글쓰기 form =-->
	<div class="wri_bottom">

<form action="write_ok" method="post" enctype="multipart/form-data">
<div class="board_write">
	<div style="height:50px;"></div>
		<textarea name="title" id="te_title" placeholder="제목" cols="41" rows="1"></textarea>
		<textarea name="content" id="te_title2" placeholder="내용" cols="100" rows="20"></textarea>
	</div>
	<div class="file_in">
		<ul>
			<li><input type="file" name="pic" style="width:500px;" /></li>
		</ul>
	</div>
	<div class="wri_ok">
		<button>발행</button>
	</div>
</form>
</div>
<?php 
		}else{
			echo "<script>alert('회원만 글쓰기가 가능합니다'); location.href='/comunity/board'; </script>";
		}
		?>
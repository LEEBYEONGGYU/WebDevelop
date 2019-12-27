<?php
include "../../include/db.php"; 
include "../../include/header.php"; 
?>
<style>
	h2 {
		margin-top:10px;
		margin-left: 10px;
	}
	#add_line {
		margin-top:10px;
		border:solid 1px #333;
	}
	#add_list {
		width:500px;;
	}
	#add_table {
		padding:0 20px 0 20px; 
	}
	#ad_bt {
		margin-top:30px; 
	}
</style>
<h2>쪽지 주소록 추가</h2>
<div id="add_line"></div>
<div id="add_list">
<form action="write.php" method="post" target="adrload"><!--- target속성은 action을 취할 것을 현재창이 아닌 다른창으로 넘깁니다.--->
	<table class="list-table" id="add_table">
		<thead>
			<tr>
				<th width="100">선택</th>
				<th width="200">아이디</th>
				<th width="300">이름</th>
				<th width="200">이메일</th>
			</tr>
		</thead>
		<?php
			$sql = mq("select * from friends where user='".$_SESSION['userid']."' order by idx desc"); //friends테이블에서 user가 로그인된 아이디와 같은거에서 idx를 기준으로 내림차순정렬합니다.
			while($adress = $sql->fetch_array()){
		?>
		<tbody>
			<tr class="tc">
			<td><input type="checkbox" name="addck" value="<?php echo $adress['fri_name']; ?>" onClick="ckonly(this);" /></td> <!---체크박스 -->
			<td><?php echo $adress['fri_name']; ?></td>
			<td><?php echo $adress['name']; ?></td>
			<td><?php echo $adress['email']; ?></td>
		</tr>
	</tbody>
<?php } ?>
</table>
<button onclick="close_wri();" id="ad_bt">추가하기</button>
</form>
</div>
<script type="text/javascript">
	function ckonly(chk){
	var obj = document.getElementsByName("addck"); //obj변수에 addck name값을 넣는다
	for(var i=0; i<obj.length; i++){// for문으로 i를 반복시켜 obj길이만큼 반복(4개일 경우 4개까지)
		if(obj[i] != chk){ // if만약 obj(addck)가 여러개 선택되었다면
			obj[i].checked = false; //체크를 해제한다
		}
	}
   }

	function close_wri(){
		self.close();
	}
</script>
<?php include "../../include/footer.php"; ?>

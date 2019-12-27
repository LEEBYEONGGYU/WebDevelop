<!--- SUB PAGE=-->
<!--- SUB VISUAL=-->
<div id="s_flash">
	<div id="s_flash_in">
		<?php img("/imgs/s_flash.jpg","s_flash","s_falsh");?>
	</div>
</div>
<!--- SUB VISUAL END --->

<!--- SUB CONTENT=-->
	<div id="left_menu">
		<div id="left_mt">
		<?php
			$sql = "select * from menu where main='".$url[0]."' && type='main'";
			$res = mysql_query($sql);
			$sub_n = mysql_fetch_array($res);
		?>
		<li><?php echo $sub_n['title'];?></li>
		<?php
			$sql2 = "select * from menu where main='".$url[0]."' && type!='main'";
			$res2 = mysql_query($sql2);
			while($sub_list = mysql_fetch_array($res2)){
		?>
		<?php
			if($url[1] == $sub_list['sub']){
		?>
		<li class="lmt lmtop bg bg_t"><a href="/<?php echo $sub_list['main']?>/<?php echo $sub_list['sub'];?>"><?php echo $sub_list['title'];?></a></li>
		<?php } else {?>
			<li class="lmt lmtop"><a href="/<?php echo $sub_list['main']?>/<?php echo $sub_list['sub'];?>"><?php echo $sub_list['title'];?></a></li>
		<?php }?>
	<?php }?>
</ul>
</div>
</div>
<div id="s_content_inner">
	<!---sub name=-->
	<div id="sub_nv">
	<div id="sub_n">
		<ul>
		<?php
			$sql3 = "select * from menu where main='".$url[0]."' && sub='".$url[1]."' && type!='main' ";
			$res3 = mysql_query($sql3);
			$sub_title = mysql_fetch_array($res3);
		?>
			<li><?php echo $sub_title['title'];?></li>
		</ul>
	</div>
	<div id="sub_navi">
		<ul>
			<li>HOME</li>
			<li>></li>
			<li><?php echo $sub_n['title'];?></li>
			<li>></li>
			<li><?php echo $sub_title['title'];?></li>
		</ul>
	</div>
	</div>
	<div id="sub_con">
	<?php 
		if($sub_title['type'] == "html"){
			echo $sub_title['content'];
		}else{
			include_once "/page/".$url[0]."/".$url[1].".php";
		}
		?>

	</div>

</div>

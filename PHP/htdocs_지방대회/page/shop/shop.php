<!--- 쇼핑=-->
<!--- top name =-->
<ul class="board">
	<li class="title2 b_name ti_color wline">사진</li>
	<li class="title1 w100 ti_color wline">이름</li>
	<li class="title1 w100 ti_color wline">원산지</li>
	<li class="title1 w7 ti_color wline">가격</li>
	<li class="title1 w5 ti_color wline"><input type="checkbox" /></li>

</ul>

<?php
	$sql = "select * from shop order by no desc";
	$res = mysql_query($sql." limit 0,5");
	while($shop  = mysql_fetch_array($res)){
?>
<!--- board DB road =--->
<ul class="board">
	<li class="shop_list title2 b_name  wline"><img src="/upload/<?php echo $shop['photo']; ?>" width="110" height="80" alt="photo" title="photo" /></li>
	<li class="shop_list title1 w100  wline"><?php echo $shop['name']; ?></li>
	<li class="shop_list title1 w100 wline"><?php echo $shop['wot']; ?></li>
	<li class="shop_list title1 w7  wline"><?php echo $shop['amout']; ?></li>
	<li class="shop_list title1 w5  wline"><input type="checkbox" id="s_chk" title="s_chk" name="s_chk" /></li>
</ul>
<?php } ?>
<ul>
	<li><a href="/shop/shop_form">글쓰기</a></li>
</ul>
<ul id="wb_bt">
	<li><a href="/active/basket"><?php img("/imgs/bas_bt.png","bas_bt","bas_bt"); ?></a></li>
</ul>
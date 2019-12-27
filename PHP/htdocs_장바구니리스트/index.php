<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<title>jquery장바구니</title>
<link rel="stylesheet" type="text/css" href="/css/common.css" />
<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/js/jquery-ui.js"></script>
</head>
<body>
  <h1>jQuery 장바구니 예제</h1>
<div id="pro_list">
  <span>제품리스트</span>
    <ul class="pro_box">
      <li class="fl"><img src="/imgs/img1.png" alt="img1" title="img1" width="200" height="200"  data-src="img1" data-title="탁자" data-price="23,000원"/></li>
      <li class="fl"><img src="/imgs/img2.png" alt="img2" title="img2" width="200" height="200"  data-src="img2" data-title="카메라 캐논80D" data-price="987,020원"/></li>
      <li class="fl"><img src="/imgs/img3.png" alt="img3" title="img3" width="200" height="200"  data-src="img3" data-title="인텔코어 i5" data-price="250,000원"/></li>
      <li class="fl"><img src="/imgs/img4.png" alt="img4" title="img4" width="200" height="200"  data-src="img4" data-title="WD SSD 1TB" data-price="356,700원"/></li>
      <li class="fl"><img src="/imgs/img5.png" alt="img5" title="img5" width="200" height="200"  data-src="img5" data-title="삼성모니터" data-price="257,020원"/></li>
    </ul>
    <div class="pro_info">
      <span>제품상세정보</span>
        <form action="/basket/requ_ok.php" method="post">
          <ul>
            <li class="pro_empty"><img src="/imgs/empty.png" alt="empty" title="empty" class="empty_img" width="350" height="350" /></li><input type="hidden" name="pr_img" class="pro_img" />
            <li class="pro_name">제품명 : <span class="ps_name"></span></li><input type="hidden" class="p_name" name="pr_name" />
            <li class="pro_price">가격 : <span class="ps_price"></span><input type="hidden" class="p_price" name="pr_price" /></li>
            <li>수량 : <input type="text" size="5" value="1" name="pro_count" /></li>
        </ul>
      <div id="servi_bt">
        <ul>
          <li><input type="submit" id="fo_bt" value="등록하기"></li>
          <li><a href="/basket/mypage.php" id="mybaket">내 장바구니<a></li>
        </ul>
      </div>
    </form>
  </div>
</div>
<script type="text/javascript">
  $(function(){
    $(".pro_box li img").draggable({
      revert: true,
      helper : "clone"
    });

  $(".pro_info").droppable({
    drop : function(e,ui){
      ui.helper.remove();

      var src = ui.draggable.attr("data-src"); //src변수에 드래그된 data-src속성값을 가져온다
      $(".empty_img").attr("src","/imgs/"+src+".png");
      $(".pro_img").val(src); //pro_img클래스에 src변수를 삽입한다.

      var title = ui.draggable.attr("data-title"); //title변수에 드래그된 data-title속성값을 가져온다
      $(".ps_name").html(title);//ps_name클래스에 html형식으로 title변수를 넣는다.
      $(".p_name").val(title); //p_name클래스에 title변수를 넣는다.

      var price = ui.draggable.attr("data-price"); //price변수에 data-price속성값을 가져온다.
      $(".ps_price").html(price);//ps_price변수에 html형식으로 price변수를 넣는다.
      $(".p_price").val(price);//p_price클래스에 price변수를 넣는다.
    }
  });
});
</script>
</body>
</html>
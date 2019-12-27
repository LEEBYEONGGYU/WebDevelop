<?php include "../db.php"; ?>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<title>jquery장바구니</title>
<link rel="stylesheet" type="text/css" href="../css/common.css" />
</head>
<body>
  <h1>jQuery 장바구니 예제</h1>
    <div id="mylist">
      <a href="../index.php"><b><<상품리스트</b></a>
      <table class="list-table">
        <thead>
          <tr>
            <th width="100">번호</th>
            <th width="170">제품사진</th>
            <th width="400">제품이름</th>
            <th width="150">가격</th>
            <th width="120">수량</th>
            <th width="130">날짜</th>
            <th width="100">삭제</th>
          </tr>
        </thead>
        <?php
          $sql = mq("select * from product order by idx desc");  
          while($product = $sql->fetch_array()){?>
        <tbody>
          <tr>
            <td width="100"><?php echo $product['idx']; ?></td>
            <td width="170"><img src="../imgs/<?php echo $product['pro_pic']; ?>.png" width="120" height="80" /></td>
            <td width="400"><?php echo $product['pro_name']?></td>
            <td width="150"><?php echo $product['price']; ?></td>
            <td width="120"><?php echo $product['pro_count']; ?></td>
            <td width="100"><?php echo $product['date']; ?></td>
            <td width="100"><a href="delete.php?idx=<?php echo $product['idx'];?>"><button>삭제하기</button></a></td>
          </tr>
        </tbody>
      <?php } ?>
    </table>
</div>
</body>
</html>
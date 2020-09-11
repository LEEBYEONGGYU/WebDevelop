<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BK샵 - 장바구니</title>
<link rel="stylesheet" type="text/css" href="common.css" />
</head>
<body>
	<section>
	<br>
		<h2>상품리스트</h2>
		<form action="my_basket.jsp" method="post">
			<table class="list-table">
      <thead>
          <tr>
              <th width="150">제품이름</th>
              <th width="100">가격</th>
              <th width="150">이미지</th>
              <th width="70">추가</th>
            </tr>
        </thead>
		<tbody>
        <tr>
        <form action="my_basket.jsp" method="post">
          <td width="150" ><input type="hidden" value="소니A6000" name="product" />소니A6000</td>
          <td width="100"><input type="hidden" value="778,252원" name="price" />778,252원</td>
          <td width="150"><input type="hidden" value="1" name="img" /><img src="imgs/1.jpg" alt="sony" title="sony" width="180" /></td>
          <td width="70"><input type="submit" value="담기" name="chk" /></td>
          </form>
        </tr>
        
        <tr>
         <form action="my_basket.jsp" method="post">
          <td width="150"><input type="hidden" value="소니A77" name="product" />소니A77</td>
          <td width="100"><input type="hidden" value="100,858원" name="price" />100,858원</td>
          <td width="150"><input type="hidden" value="2" name="img" /><img src="imgs/2.jpg" alt="sony" title="sony" width="180" /></td>
          <td width="70"><input type="submit" value="담기" name="chk2" /></td>
           </form>
        </tr>
        
        <tr>
         <form action="my_basket.jsp" method="post">
          <td width="150"><input type="hidden" value="소니A7" name="product" />소니A7</td>
          <td width="100"><input type="hidden" value="708,252원" name="price" />708,252원</td>
          <td width="150"><input type="hidden" value="3" name="product" /><img src="imgs/3.jpg" alt="sony" title="sony" width="180"/></td>
          <td width="70"><input type="submit" value="담기" name="chk" /></td>
           </form>
        </tr>
        
        <tr>
         <form action="my_basket.jsp" method="post">
          <td width="150"><input type="hidden" value="니콘Z6" name="product" />니콘Z6</td>
          <td width="100"><input type="hidden" value="978,252원" name="price" />978,252원</td>
          <td width="150"><input type="hidden" value="4" name="product" /><img src="imgs/4.png" alt="sony" title="sony" width="180"/></td>
          <td width="70"><input type="submit" value="담기" name="chk" /></td>
           </form>
        </tr>
        
        <tr>
         <form action="my_basket.jsp" method="post">
          <td width="150"><input type="hidden" value="니콘Z7" name="product" />니콘Z7</td>
          <td width="100"><input type="hidden" value="478,252원" name="product" />478,252원</td>
          <td width="150"><input type="hidden" value="5" name="product" /><img src="imgs/5.png" alt="sony" title="sony" width="180"/></td>
          <td width="70"><input type="submit" value="담기" name="chk" /></td>
           </form>
        </tr>
      </tbody>
    </table>
	</section>
</body>
</html>
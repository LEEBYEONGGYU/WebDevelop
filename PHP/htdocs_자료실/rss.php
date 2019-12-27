<!DOCTYPE html>
<html>
<head>
<title></title>
<meta charset="utf-8" />
</head>
<body>

<form>
    <fieldset>
    <legend>블로그 RSS 파싱 테스트</legend>
   
    <?php
    $rss = simplexml_load_file('https://rss.joins.com/joins_news_list.xml');
    ?>
    <h3><?php echo $rss->channel->title?></h3>
   
    <ul>
    <?php
    foreach($rss->channel->item as $chan) {  
            echo "<p>카테고리 : [" . $chan->category . "]</p>";
            echo "<li>제목 : <a href=\"". $chan->link ."\">";
            echo $chan->title;    
            echo "</a></li>\n";
            echo "<p>글 내용 : [" . $chan->description . "]</p>";
            echo "<p>태그 : " . $chan->tag . ", </p><br>";
    }  
    ?>
   
    </fieldset>
</form>
</body>
</html>
<!--- 공지사항 =-->
<div class="board_in">
	<div class="sub_bt">
		<ul>
			<li>자유게시판</li>
			<li class="sub_bt2">자유롭게 글을 쓸수있는 게시판입니다.</li>
		</ul>
	</div>
		<form action="write">
		<div class="write_btn">
			<button>글쓰기</button>
		</div>
	</form>

	</div>
<table class="list-table">
	<thead>
    	<tr>
        	<th width="70">번호</th>
            <th width="500">제목</th>
            <th width="120">글쓴이</th>
            <th width="100">작성일</th>
            <th width="100">조회수</th>
        </tr>
    </thead>	
	</table>

<div class="bo_list"></div>
<script type="text/javascript">
    var start = 0;
    var list = 5;
    function append_list(){
        $.post("/page/comunity/bo_append.php",{start:start,list:list},function(data){
            if(data){
                setTimeout(function(e){
                    $(".bo_list").append(data);
                },500);
                    start += list;
            }
        });
    }

    $(function(){
        append_list();

        $(window).scroll(function(){
            var dh = $(document).height();
            var wh = $(window).height();
            var wt = $(window).scrollTop();
            if(dh == (wh + wt)){
                append_list();
            }
        });
    });
    </script>

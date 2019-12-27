<!--- 공지사항 =-->
<div class="board_in">
    <div class="sub_bt">
        <ul>
            <li>공지사항</li>
            <li class="sub_bt2">BK Telcom의 공지를 빠르게 확인 할 수 있습니다.</li>
        </ul>
    </div>
    </div>
<table class="list-table">
    <thead>
        <tr>
            <th width="70">번호</th>
            <th width="600">제목</th>
            <th width="80">글쓴이</th>
            <th width="100">작성일</th>
            <th width="100">조회수</th>
        </tr>
    </thead>    
    </table>

<div class="comm_list"></div>
<script type="text/javascript">
    var start = 0;
    var list = 5;
    function append_list(){
        $.post("/page/comunity/notice_append.php",{start:start,list:list},function(data){
            if(data){
                setTimeout(function(e){
                    $(".comm_list").append(data);
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
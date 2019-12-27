<?php include $_SERVER['DOCUMENT_ROOT']."/db.php"; ?>
<?php include $_SERVER['DOCUMENT_ROOT']."/include/header.php"; ?>
<div id="visual"></div>
    <div id="sub_main">
        <div id="board_write">
            <h1><a href="/">자유게시판</a></h1>
            <h4>글을 작성하는 공간입니다.</h4>
                <div id="write_area">
                    <form action="write_ok.php" method="post" enctype="multipart/form-data">
                        <div id="in_title">
                            <textarea name="title" id="utitle" rows="1" cols="55" placeholder="제목" maxlength="100" required></textarea>
                        </div>
                        <div class="wi_line"></div>
                        <div id="in_name">
                            <textarea name="name" id="uname" rows="1" cols="55" placeholder="글쓴이" maxlength="100" required></textarea>
                        </div>
                        <div class="wi_line"></div>
                        <div id="in_content">
                            <textarea name="content" id="ucontent" placeholder="내용" required></textarea>
                        </div>
                        <div id="in_pw">
                            <input type="password" name="pw" id="upw"  placeholder="비밀번호" required />  
                        </div>
                        <div id="in_lock">
                            <input type="checkbox" value="1" name="lockpost" /> 비밀글입니다
                        </div>
                        <div id="in_file">
                            <input type="file" value="1" name="b_file" />
                        </div>
                        <div class="bt_se">
                            <button type="submit">글 작성</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    <?php include $_SERVER['DOCUMENT_ROOT']."/include/footer.php"; ?>
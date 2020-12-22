<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 20. 12. 22.
  Time: 오전 1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../include/head.jsp"/>

    <script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/marked/marked.min.js"></script>

    <link rel='stylesheet' href='//cdnjs.cloudflare.com/ajax/libs/highlight.js/10.4.1/styles/atom-one-light.min.css'>
    <script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/10.4.1/highlight.min.js"></script>

    <script type="module" src="/resources/js/board/postEdit.js"></script>
    <script type="module" src="/resources/js/board/ajax_repos.js"></script>
    <script type="module" src="/resources/js/board/ajax_commits.js"></script>
    <script type="module" src="/resources/js/board/ajax_commit.js"></script>
    <link rel="stylesheet" href="/resources/css/board/boardPost.css"/>
    <link rel="stylesheet" href="/resources/css/board/postCommitComponent.css"/>
    <title>post</title>
</head>
<body>
<script>
    function createItem_repo() {
        $(createBox_repo())
            .appendTo("#itemBoxWrap")
            .hover(
                function () {
                    $(this).find('.deleteBox').show();
                },
                function () {
                    $(this).find('.deleteBox').hide();
                }
            )
            .append("<span class='deleteBox'>[삭제]</span>")
            .find(".deleteBox").click(function () {
            $(this).parent().remove();
        });
    }

    // 아이템을 구성할 태그를 반환합니다.
    // itemBox 내에 번호를 표시할 itemNum 과 입력필드가 있습니다.
    function createBox_repo() {
        var contents
            = '<div class="itemBox">'
            + '<div>'
            + '<svg class="sortDragSVG" xmlns="http://www.w3.org/2000/svg" width="15" height="30" viewBox="0 0 15 30">'
            + '<path d="M20.075,38.816a2.355,2.355,0,0,1-1.988-1.043L12.926,29.9a2.054,2.054,0,0,1-.049-2.218,2.335,2.335,0,0,1,2.038-1.123H25.235a2.335,2.335,0,0,1,2.038,1.123,2.054,2.054,0,0,1-.05,2.219l-5.161,7.875A2.357,2.357,0,0,1,20.075,38.816Zm5.16-17.741H14.914a2.335,2.335,0,0,1-2.038-1.123,2.054,2.054,0,0,1,.049-2.218l5.162-7.875a2.416,2.416,0,0,1,3.977,0l5.161,7.875a2.054,2.054,0,0,1,.05,2.219A2.335,2.335,0,0,1,25.235,21.075Z" transform="translate(-12.575 -8.816)" fill="#707070"/>'
            + '</svg>'
            + '<div class="markdown-view">'
            + '</div>'
            + '<div class="textarea-box">'
            + '<hr>'
            + '<textarea onkeydown="if(event.keyCode===9){var v=this.value,s=this.selectionStart,e=this.selectionEnd;this.value=v.substring(0, s)+\'\t\'+v.substring(e);this.selectionStart=this.selectionEnd=s+1;return false;}" class="autosize"></textarea>'
            + '</div>'
            + '</div>'
            + '</div>';
        console.log($('#itemBoxWrap').find('textarea').val());
        return contents;
    }

    function createBox_commit() {
        var contents
            = '<div class="itemBox">'
            +'<div>'
            +'<svg class="sortDragSVG" xmlns="http://www.w3.org/2000/svg" width="15" height="30" viewBox="0 0 15 30">'
            +'<path d="M20.075,38.816a2.355,2.355,0,0,1-1.988-1.043L12.926,29.9a2.054,2.054,0,0,1-.049-2.218,2.335,2.335,0,0,1,2.038-1.123H25.235a2.335,2.335,0,0,1,2.038,1.123,2.054,2.054,0,0,1-.05,2.219l-5.161,7.875A2.357,2.357,0,0,1,20.075,38.816Zm5.16-17.741H14.914a2.335,2.335,0,0,1-2.038-1.123,2.054,2.054,0,0,1,.049-2.218l5.162-7.875a2.416,2.416,0,0,1,3.977,0l5.161,7.875a2.054,2.054,0,0,1,.05,2.219A2.335,2.335,0,0,1,25.235,21.075Z" transform="translate(-12.575 -8.816)" fill="#707070"/>'
            +'</svg>'
            +'<div class="commit-view-comtainer">'
            +'</div>'
            +'<div class="add-commit-container">'
            +'<button class="btn-select-repo">search repository</button>'
            +'<h3>repositorys</h3>'
            +'<div class="repo-buttons">'
            +'</div>'
            +'<h3>commits</h3>'
            +'<div class="commit-buttons">'
            +'</div>'
            +'</div>'
            +'</div>'
            +'</div>';
        return contents;
    }
    function createItem_commit() {
        $(createBox_commit())
            .appendTo("#itemBoxWrap")
            .hover(
                function () {
                    $(this).find('.deleteBox').show();
                },
                function () {
                    $(this).find('.deleteBox').hide();
                }
            )
            .append("<span class='deleteBox'>[삭제]</span>")
            .find(".deleteBox").click(function () {
            $(this).parent().remove();
        });
    }

</script>
<jsp:include page="../include/header.jsp"/>
<div class="container">
    <div>
        <div>
            <input type="button" class="addItem" id="addItem-markdown" value="Add markdown" onclick="createItem_repo();" />
            <input type="button" class="addItem" id="addItem-commit" value="Add commit" onclick="createItem_commit();" />
        </div>
    </div>
    <br />
    <div class="item-container">
        <div id="itemBoxWrap">
            <div class='itemBox'>
                <div>
                    <svg class="sortDragSVG" xmlns="http://www.w3.org/2000/svg" width="15" height="30" viewBox="0 0 15 30">
                        <path d="M20.075,38.816a2.355,2.355,0,0,1-1.988-1.043L12.926,29.9a2.054,2.054,0,0,1-.049-2.218,2.335,2.335,0,0,1,2.038-1.123H25.235a2.335,2.335,0,0,1,2.038,1.123,2.054,2.054,0,0,1-.05,2.219l-5.161,7.875A2.357,2.357,0,0,1,20.075,38.816Zm5.16-17.741H14.914a2.335,2.335,0,0,1-2.038-1.123,2.054,2.054,0,0,1,.049-2.218l5.162-7.875a2.416,2.416,0,0,1,3.977,0l5.161,7.875a2.054,2.054,0,0,1,.05,2.219A2.335,2.335,0,0,1,25.235,21.075Z" transform="translate(-12.575 -8.816)" fill="#707070"></path>
                    </svg>
                    <div class="markdown-view">

                    </div>

                    <div class="textarea-box">
                        <hr>
                        <textarea onkeydown="if(event.keyCode===9){var v=this.value,s=this.selectionStart,e=this.selectionEnd;this.value=v.substring(0, s)+'\t'+v.substring(e);this.selectionStart=this.selectionEnd=s+1;return false;}" class="autosize"></textarea>
                    </div>
                </div>
                <span class='deleteBox'>[삭제]</span>
            </div>
        </div>
    </div>
</div>
</body>
</html>

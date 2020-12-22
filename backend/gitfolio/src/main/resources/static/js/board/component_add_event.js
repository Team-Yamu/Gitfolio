$(document).ready(function () {
    $(document).on("mousedown", "#addItem-markdown", function(e) {
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
    });
    $(document).on("mousedown", "#addItem-commit", function(e) {
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
    });
});

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
        + '<button class="component-close">close</button>'
        + '<div class="textarea-box edit-component">'
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
        +'<div class="commit-view-container">'
        +'</div>'
        +'<button class="component-close">close</button>'
        +'<div class="add-commit-container edit-component">'
        + '<hr>'
        +'<button class="btn-select-repo">search repository</button>'
        +'<h3>repository</h3>'
        +'<div class="repo-buttons">'
        +'</div>'
        +'<h3>commit</h3>'
        +'<div class="commit-buttons">'
        +'</div>'
        +'</div>'
        +'</div>'
        +'</div>';
    return contents;
}
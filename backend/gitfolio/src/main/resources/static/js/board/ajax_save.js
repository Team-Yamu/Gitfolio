$(document).ready(function () {
    $(document).on("mousedown", "#btn-save", function(e) {
        console.log($('#input-box-title').val());
        if($('#input-box-title').val()==="")
        {
            alert("제목을 입력해주세요");
            return;
        }
        $.ajax({
            type: "POST",
            url: "/board",
            dataType : "json",
            data:{
                title: $('#input-box-title').val(),
                viewContent: getViewContent(),
                originalContent: getOriginalContent(),
                previewImageUrl:"/resources/images/defaultImage.png",
                tag:" "
            },
            success: function(result)
            {
                if(result === true)
                {
                    alert("success");
                    $(location).attr('href', '/page/user');
                }
                else
                {
                    alert("fail");
                }
            },
            error: function()
            {
                alert("Failed to connect to server");
            }
        });
    });
});

function getViewContent() {
    let node = $('.itemBox');

    let tempNode = $('<div/>').attr({
        id:'contentView'
    });

    for(let i = 0; i<2;i++)
    {
        tempNode.append($(node[i]).find('.commit-view-container'));
        tempNode.append($(node[i]).find('.markdown-view'));
    }
    console.log(tempNode.get(0).outerHTML);
    return tempNode.get(0).outerHTML;
}

function getOriginalContent() {
    let tempNode = $('#itemBoxWrap');
    return tempNode.get(0).outerHTML;
}
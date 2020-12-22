$(document).ready(function () {
    $(document).on("mousedown", "#btn-save", function(e) {
        if($('#input-box-title').val()==="")
        {
            alert("제목을 입력해주세요");
            return;
        }

        let imageUrl;
        let tempNode = $('#itemBoxWrap');
        tempNode = $(tempNode).find('img');
        if(tempNode.length === 0)
        {
            imageUrl =  "/resources/images/defaultImage.png";
        }
        else
        {
            imageUrl =  $(tempNode[0]).attr('src');
        }

        let node = $('.itemBox');

        tempNode = $('<div/>').attr({
            id:'contentView'
        });

        console.log($(node).length);

        for(let i = 0; i<$(node).length;i++)
        {
            tempNode.append($(node[i]).clone().find('.commit-view-container'));
            tempNode.append($(node[i]).clone().find('.markdown-view'));
        }
        console.log($(tempNode));
        let viewNode = tempNode.clone().get(0).outerHTML;

        tempNode = $('#itemBoxWrap');
        let originalNode = tempNode.clone().get(0).outerHTML;

        $.ajax({
            type: "POST",
            url: "/board",
            dataType : "json",
            data:{
                title: $('#input-box-title').val(),
                viewContent: viewNode,
                originalContent: originalNode,
                previewImageUrl: imageUrl,
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
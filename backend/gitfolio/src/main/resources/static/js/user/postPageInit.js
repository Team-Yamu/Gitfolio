$(document).ready(function () {

    $.ajax({
        url: "/api/user",
        type: "GET",
        success: function(result)
        {
            $('#user_name').text(result['login']);
            $('#user_icon').attr({
                src:result['avatar_url'],
                alt:result['login'] + "'s icon"
            })

            $('#github_link').attr('href',result['html_url']);

            var tempArray = result['board_metadata'];

            for(var i = 0; i<tempArray.length;i++)
            {
                var rootTag = $('<article class="post"></article>');
                var tempTag = $("<a/>");
                tempTag.attr({
                    class:'post_image_href',
                    href:"/board/id/"+tempArray[i]['id']
                });
                var tempTag2 = $('<img/>');
                tempTag2.attr({
                    class:'post_image',
                    src:"/resources/images/defaultImage.png"
                        // tempArray[i]['preview_image_url']
                });
                tempTag.append(tempTag2);
                rootTag.append(tempTag);
                rootTag.append($('<h4 class="post_title"><a href="#">'+tempArray[i]['title']+'</a></h4>'));
                rootTag.append($('<div class="post_info"><p class="post_info_last_update">'+tempArray[i]['register_date_time']+'</p></div>'));
                $('#post_container').append(rootTag);
            }

            $('<span>domTest</span>');
        // <a class="post_image_href" href="#"><img class="post_image" src="../img/dooli.png" alt="이미지에 대한 설명"></a>
        //     <h4 class="post_title"><a href="#">{title}</a></h4>
        // <div class="post_info">
        //     <p class="post_info_last_update">마지막 업데이트 2020년 12월 19일</p>
        // </div>
        },
        error: function()
        {
            alert("Failed to connect to server");
        }
    });
})
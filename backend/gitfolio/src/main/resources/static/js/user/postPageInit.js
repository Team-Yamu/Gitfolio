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

            let tempArray = result['board_metadata'];

            for(let i = 0; i<tempArray.length;i++)
            {
                let rootTag = $('<article class="post"></article>');
                let tempTag = $("<a/>");
                tempTag.attr({
                    class:'post_image_href',
                    href:"/board/id/"+tempArray[i]['id']
                });
                let tempTag2 = $('<img/>');
                tempTag2.attr({
                    class:'post_image',
                    src: tempArray[i]['preview_image_url']
                });
                tempTag.append(tempTag2);
                rootTag.append(tempTag);
                rootTag.append($('<h4 class="post_title"><a href="#">'+tempArray[i]['title']+'</a></h4>'));
                rootTag.append($('<div class="post_info"><p class="post_info_last_update">'+tempArray[i]['register_date_time']+'</p></div>'));
                $('#post_container').append(rootTag);
            }

            $('<span>domTest</span>');
        },
        error: function()
        {
            alert("Failed to connect to server");
        }
    });
})
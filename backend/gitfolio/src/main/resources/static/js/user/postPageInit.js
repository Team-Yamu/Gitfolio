$(document).ready(function () {
    let userId = window.location.pathname;
    userId = userId.replace('/page/user','');
    $.ajax({
        url: "/api/user"+userId,
        type: "GET",
        success: function(result)
        {
            console.log(result);
            $('#user_name').text(result['login']);
            if(result['avatarUrl'])
            {
                $('#user_icon').attr({
                    src:result['avatarUrl'],
                    alt:result['login'] + "'s icon"
                })
            }
            else
            {
                $('#user_icon').attr({
                    src:result['avatar_url'],
                    alt:result['login'] + "'s icon"
                })
            }

            if(result['is_admin'])
            {
                $('#post_create').css('display','inline-block');
            }
            else
            {
                $('#post_create').css('display','none');
            }

            $('#github_link').attr('href',result['html_url']);

            let tempArray = result['board_metadata'];

            for(let i = 0; i<tempArray.length;i++)
            {
                let rootTag = $('<article class="post"></article>');
                let tempTag = $("<a/>");
                tempTag.attr({
                    class:'post_image_href',
                    href:"/board/"+tempArray[i]['id']
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
            alert("Not Found Page");
            history.back();
        }
    });
})
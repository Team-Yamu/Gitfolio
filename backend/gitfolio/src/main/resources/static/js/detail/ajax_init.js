$(document).ready(function () {
    let boardId = window.location.pathname;
    boardId = boardId.replace('/board/','');

    $.ajax({
        url: "/board/id/"+boardId,
        type: "GET",
        dataType:"json",
        success: function(result)
        {
            console.log(result);
            let viewContent = $.parseHTML(result['viewContent']);
            $('#container').append(viewContent);
        },
        error: function()
        {
            alert("Failed to connect to server");
        }
    });
});
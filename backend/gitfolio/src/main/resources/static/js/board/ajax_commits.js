$(document).ready(function () {

    $(document).on("mousedown", ".repo-button", function(e) {
        var tempNodeCommit = $($(e.target.parentNode.parentNode).find('.commit-buttons'));
        console.log($(e.target.parentNode));
        $(e.target.parentNode).find('button').attr('id','');
        $(e.target).attr('id','click');
        $(tempNodeCommit).empty();
        $.ajax({
            url: "/api/commits",
            data:{
                full_name: $(e.target).text()
            },
            type: "GET",
            dataType:"json",
            success: function(result)
            {
                for(var i = 0; i<result.length; i++)
                {
                    $(tempNodeCommit).append($('<button/>')
                        .attr('value',result[i]['sha'])
                        .attr('class','commit-button')
                        .html(result[i]['commit']['message']));
                }
            },
            error: function()
            {
                alert("Failed to connect to server");
            }
        });
    });
});
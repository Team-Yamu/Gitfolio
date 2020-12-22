$(document).ready(function () {

    $(document).on("mousedown", ".btn-select-repo", function(e) {
        $.ajax({
            url: "/api/repos",
            type: "GET",
            dataType:"json",
            success: function(result)
            {
                var tempNodeRepo = $($(e.target.parentNode).find('.repo-buttons'));
                var tempNodeCommit = $($(e.target.parentNode).find('.commit-buttons'))
                console.log(tempNodeRepo);
                console.log(tempNodeCommit);
                $(tempNodeRepo).empty();
                $(tempNodeCommit).empty();
                $().empty();
                for(let i = 0; i<result.length;i++)
                {
                    console.log(result[i]['full_name']);
                    $(tempNodeRepo).append($('<button/>').attr('class','repo-button').html(result[i]['full_name']));
                }
            },
            error: function()
            {
                alert("Failed to connect to server");
            }
        });
    });
});
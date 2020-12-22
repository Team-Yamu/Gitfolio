$(document).ready(function () {

    $(document).on("mousedown", ".commit-button", function(e) {
        var tempNodeparent = $($(e.target.parentNode.parentNode.parentNode).find('.commit-view-container'));
        tempNodeparent.empty();
        $(e.target.parentNode).find('button').attr('id','');
        $(e.target).attr('id','click');
        var tempNodeContainer = $($(e.target.parentNode.parentNode));
        var tempNodeClickRepo = $(tempNodeContainer).find('.repo-buttons').find('#click');
        var tempNodeClickCommit = $(tempNodeContainer).find('.commit-buttons').find('#click');
        $.ajax({
            url: "/api/commit",
            data:{
                full_name: $(tempNodeClickRepo).text(),
                sha: $(tempNodeClickCommit).val()
            },
            type: "GET",
            dataType:"json",
            success: function(result)
            {
                var tempNode = $('<a/>').attr({
                    class:"commit-url",
                    href:result['html_url']
                }).text($(tempNodeClickCommit).text());

                $(tempNodeparent).append($(tempNode));
            },
            error: function()
            {
                alert("Failed to connect to server");
            }
        });
    });
});
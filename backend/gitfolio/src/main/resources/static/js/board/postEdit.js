$(function() {
    $("#itemBoxWrap").sortable({
        placeholder: "itemBoxHighlight itemBox",
        start: function (event, ui) {
            ui.item.data('start_pos', ui.item.index());
            $(this).find('.deleteBox').hide();
            $(this).css('background', 'none');
        },
        stop: function (event, ui) {
            var spos = ui.item.data('start_pos');
            var epos = ui.item.index();
        }
    });
});

$(document).ready(function() {
    $(document).on("keyup", "textarea", function(e) {
        $(this).css("height", "auto");
        $(this).height(this.scrollHeight);
        const html = marked($(e.target).val());
        let target = $(this).parent().parent().find('.markdown-view')
        $(target).html(html);
        document.querySelectorAll('pre code').forEach((block) => {
            hljs.highlightBlock(block);
        });
    });

    $(document).on("mousedown", ".component-close", function(e) {
        var tempNode = $(e.target.parentNode).find('.edit-component')
        if($(tempNode).css('display') === 'none')
        {
            $(tempNode).css('display','block');
            $(e.target).text('close');
        }
        else
        {
            $(tempNode).css('display','none');
            $(e.target).text('open');
        }
    });

    $(document).find("textarea").keyup();

    $('.itemBox').find(".deleteBox").remove();
    $('.itemBox').hover(
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
})
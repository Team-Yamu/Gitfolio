$(document).ready(function () {

    $.ajax({
        url: "/api/user/algo2000",
        type: "GET",
        success: function(result)
        {
            console.log(result);
        },
        error: function()
        {
            alert("Failed to connect to server");
        }
    });
})
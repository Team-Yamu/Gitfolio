$('#searchBox').keydown(function(key) {
    if (key.keyCode === 13) {
        console.log("/page/user"+$('#searchBox').val());
        location.href="/page/user/"+$('#searchBox').val()
    }
});
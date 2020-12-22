$(document).ready(function () {
    let logInUri = window.location.pathname;

    if (logInUri === "/login") {
        $('#logOutBtn').css('display', 'none');
    }
});
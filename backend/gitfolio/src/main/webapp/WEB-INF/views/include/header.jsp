<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 20. 12. 21.
  Time: 오후 12:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="/resources/css/common/header.css"/>
<script type="module" src="/resources/js/common/deleteLogOut.js"></script>
<script type="module" src="/resources/js/common/searchUser.js"></script>
<div class="header">
    <svg onclick="location.href='/'" class="logo logo-header" width="112" height="30" viewBox="0 0 112 30">
        <path
            d="M103.568,25.6v-.585c0-6.124,3.549-9.789,8.775-9.789,5.459,0,8.775,3.549,8.775,9.672v.545c0,6.162-3.588,9.828-8.815,9.828C106.844,35.275,103.568,31.765,103.568,25.6Zm3.042-.9v.975c0,5.382,2.534,7.137,5.772,7.137,3.51,0,5.694-2.457,5.694-7.02v-.975c0-5.382-2.614-7.137-5.773-7.137C108.794,17.686,106.61,20.182,106.61,24.706Zm-41.575.9v-.585c0-6.124,3.55-9.789,8.775-9.789,5.46,0,8.775,3.549,8.775,9.672v.545c0,6.162-3.587,9.828-8.814,9.828C68.312,35.275,65.036,31.765,65.036,25.6Zm3.042-.9v.975c0,5.382,2.535,7.137,5.773,7.137,3.51,0,5.693-2.457,5.693-7.02v-.975c0-5.382-2.613-7.137-5.772-7.137C70.262,17.686,68.078,20.182,68.078,24.706ZM96.041,34.924v-19.3h2.965v19.3Zm-8.892,0V7h3V34.924ZM11,21.366v-.7c0-9.828,5.773-13.338,12.363-13.338a14.329,14.329,0,0,1,6.825,1.521v2.691a15.126,15.126,0,0,0-7.059-1.6c-6.513,0-8.814,4.758-8.814,10.3v1.053c0,6.084,1.872,10.452,8.892,10.452a14.921,14.921,0,0,0,4.914-.779V23.823H22.505V21.249h8.658v11.66a23.132,23.132,0,0,1-8.034,1.444C15.719,34.353,11,30.335,11,21.366Zm35.608,8.19V23.182H44.128V20.532h2.479V10.017h.021V8.755H61.8v2.613H49.709v9.164H59.03v2.652H49.571v5.9c0,1.872.624,2.613,2.847,2.613a8.98,8.98,0,0,0,2.5-.351v2.028a6.78,6.78,0,0,1-3.276.78C48.6,34.158,46.607,32.832,46.607,29.556Zm-9.828,4.368V14.619h2.964V33.924ZM96,11.719V8.6h3.042v3.12Zm-59.262-1V7.6h3.042v3.12Z"
            transform="translate(-10 -6)" fill="#ffffff" stroke="#ffffff" stroke-width="2"></path>
    </svg>
    <span class="sign-container">
        <input id="searchBox" type="text" placeholder="Search">
        <a id="logOutBtn" href="/logout" style="color: whitesmoke">Sign Out</a>
    </span>
</div>

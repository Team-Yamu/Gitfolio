<%--
  Created by IntelliJ IDEA.
  User: leo
  Date: 20. 12. 22.
  Time: 오전 1:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../include/head.jsp"/>

    <script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/marked/marked.min.js"></script>

    <link rel='stylesheet' href='//cdnjs.cloudflare.com/ajax/libs/highlight.js/10.4.1/styles/atom-one-light.min.css'>
    <script src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/10.4.1/highlight.min.js"></script>

    <script type="module" src="/resources/js/board/postEdit.js"></script>
    <script type="module" src="/resources/js/board/ajax_repos.js"></script>
    <script type="module" src="/resources/js/board/ajax_commits.js"></script>
    <script type="module" src="/resources/js/board/ajax_commit.js"></script>
    <script type="module" src="/resources/js/board/ajax_save.js"></script>
    <script type="module" src="/resources/js/board/component_add_event.js"></script>

    <link rel="stylesheet" href="/resources/css/board/boardPost.css"/>
    <link rel="stylesheet" href="/resources/css/board/postCommitComponent.css"/>
    <link rel="stylesheet" href="/resources/css/board/markdownStyle.css"/>
    <title>post</title>
</head>
<body>

<jsp:include page="../include/header.jsp"/>
<div class="container">
    <div id="btn-editer">
        <input type="button" class="addItem" id="addItem-markdown" value="Add markdown" />
        <input type="button" class="addItem" id="addItem-commit" value="Add commit" />
        <input type="button" class="addItem" id="btn-save" value="Save"/>
    </div>
    <input type="text" id="input-box-title" placeholder="Title">
    <br />
    <div class="item-container">
        <div id="itemBoxWrap">
        </div>
    </div>
</div>
</body>
</html>

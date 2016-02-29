<%--
  Created by IntelliJ IDEA.
  User: Aladinne
  Date: 22/02/2016
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-2.2.1.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/js.js"></script>

<link rel="stylesheet" type="text/css" href="js/styles.css">

    <title>$Title$</title>

  </head>
  <body>
  <div class="header">
    <input type="text" id="searchKey"/>
    <button id="btnSearch" onclick="search()">Rechercher</button>
    <button id="btnAdd">Nouveau</button>
  </div>
  <div class="leftArea">
    <ul id="tl_List"></ul>
  </div>

  <form id="Form" action="">
    <div class="mainArea">
      <label>isbn:</label>
      <input id="isbn" name="isbn" type="text"  />
      <label>titre:</label>
      <input type="text" id="titre" name="titre" required>
      <label>auteur:</label>
      <input type="text" id="auteur" name="auteur" required>
      <button id="btnSave" onclick="save()">Enregistrer</button>
      <button id="btnDelete">Supprimer</button>

    </div>

    <div class="rightArea">
      <label>Notes:</label>
      <textarea id="description" name="description"></textarea>
    </div>
  </form>


  <div id="test">


  </div>
  </body>


</html>

<%--
  Created by IntelliJ IDEA.
  User: hadoop
  Date: 3/24/16
  Time: 1:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body ng-app = "parkbanApp.module">

<div id="wrapper">
    <ul class="menu">
        <li><a href="#/parkPriceList">Park Price</a></li>
        <li><a href="#/common">Common</a></li>
        <li><a href="#/showFiscalList">Fiscal</a></li>
    </ul>

    <%--<div boarder = "1" ng-controller = "parkPriceController">
        {{ desc }}
    </div>

    <div boarder = "1" ng-controller = "parkRegionController">
        {{ desc }}
    </div>--%>

    <div ng-view=""></div>
</div>


<%--<script src="App/lib/angular/angular.js"></script>--%>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.25/angular-route.js"></script>
<script src="App/parkbanApp.module.js"></script>
<script src="App/base/parkPrice.ctrl.js"></script>
<script src="App/base/parkRegion.ctrl.js"></script>
<script src="App/base/base.module.js"></script>

<script src="App/fiscal/fiscal.ctrl.js"></script>
<script src="App/fiscal/fiscal.module.js"></script>



</body>
</html>

<html>
<head lang="en">
    <meta name="layout" content="main"/>
    <script language="JavaScript">function loadDoc() {
        var http = new XMLHttpRequest();
        http.onreadystatechange = function() {//Call a function when the state changes.
            document.getElementById("MyEdit").innerHTML="Previous hotel bookings: 10,10,25,10,20";
            document.getElementById("reco").innerHTML="Recommended hotel bookings: 10";
        };
        http.send(postData);
        return false
    }
    </script>
</head>
<body>

<div class="nav" role="navigation">
            <ul>
                    <li><a class="home" href="${createLink(uri: '/status')}"><g:message code="default.home.label"/></a></li>
                    <li><g:link controller="person">Users</g:link></li>
                    <li><g:link controller="functionalTests">functionalTests</g:link></li>
                    <li><g:link controller="fuzzyLogic">fuzzyLogic</g:link></li>
                    <li><g:link controller="ColloborativeFiltering">ColloborativeFiltering</g:link></li>
                    <li><g:link controller="ContentBasedRecommendation">ContentBasedRecommendation</g:link></li>
                <li><a href="/logout">Logout</a></li>
                </ul>
</div>


<div class="pageBody">
<h1>Please enter email address of customer</h1>
<form>
<label><b>Enter email address</b></label>
<label for="user_input"></label><input type="text" name="message" id="user_input">
<input type="submit" onclick="loadDoc();return false;"><br/>

<p><span id='MyEdit'></span></p>
    <p><span id='reco'></span></p>
</form>
</div>

</body>

</html>

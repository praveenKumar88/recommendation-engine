<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Gelo</title>
    <style type="text/css" media="screen">
    #status {
        background-color: #eee;
        border: .2em solid #fff;
        margin: 2em 2em 1em;
        padding: 1em;
        width: 12em;
        float: left;
        -moz-box-shadow: 0px 0px 1.25em #ccc;
        -webkit-box-shadow: 0px 0px 1.25em #ccc;
        box-shadow: 0px 0px 1.25em #ccc;
        -moz-border-radius: 0.6em;
        -webkit-border-radius: 0.6em;
        border-radius: 0.6em;
    }

    .ie6 #status {
        display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
    }

    #status ul {
        font-size: 0.9em;
        list-style-type: none;
        margin-bottom: 0.6em;
        padding: 0;
    }

    #status li {
        line-height: 1.3;
    }

    #status h1 {
        text-transform: uppercase;
        font-size: 1.1em;
        margin: 0 0 0.3em;
    }

    #page-body {
        margin: 2em 1em 1.25em 18em;
    }

    h2 {
        margin-top: 1em;
        margin-bottom: 0.3em;
        font-size: 1em;
    }

    p {
        line-height: 1.5;
        margin: 0.25em 0;
    }

    #controller-list ul {
        list-style-position: inside;
    }

    #controller-list li {
        line-height: 1.3;
        list-style-position: inside;
        margin: 0.25em 0;
    }

    @media screen and (max-width: 480px) {
        #status {
            display: none;
        }

        #page-body {
            margin: 0 1em 1em;
        }

        #page-body h1 {
            margin-top: 0;
        }
    }
    </style>
</head>
<body>
<div id="status" role="complementary">
    <h1>Application Status</h1>
    <ul>
        <li><b>Metasearch:</b></li>
        <li>Box name:CHEIJVAMSS001</li>
        <li>version: 2.60</li>
        <li><b>Gelo:</b></li>
        <li>Box name:CHEIOMSSOLR004</li>
        <li>version: 2.37</li>
        <li><b>java version: 1.8</b></li>
        <li><b>Tests: ${grailsApplication.controllerClasses.size()}</b></li>
        <li><b>Environment: MAUI</b></li>
    </ul>
    <h2><input type="submit" value="Run existing tests..."></h2>
</div>

<div id="page-body" role="main">
    <h1>Welcome to the end-to-end search functional tests</h1>
    <p>This inserts payloads into rabbit and checks the following:
        <br>1. Is Maui available?
        <br>2. Does the rabbit payload make it into solr?
        <br>3. Is metasearch query working?
        <br>To kick start the tests, please input the rabbitmq payload and the metasearch endpoint below</p>

%{--<div id="controller-list" role="navigation">--}%
%{--<h2>Available Tests:</h2>--}%
%{--<ul>--}%
%{--<g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">--}%
%{--<li class="controller"><g:link controller="${c.logicalPropertyName}">${c.fullName}</g:link></li>--}%
%{--</g:each>--}%
%{--</ul>--}%
%{--</div>--}%
%{--<h1>Please enter rabbit xml payload</h1>--}%
%{--<g:form>--}%
%{--<g:textField name="a"/><br/>--}%
%{--<g:actionSubmit value="Submit" action="calculateSum"/>--}%
%{--</g:form>--}%
%{--<h1>Please enter metasearch maui endpoint</h1>--}%
%{--<g:form>--}%
%{--<g:textField name="b"/><br/>--}%
%{--<g:actionSubmit value="Submit" action="calculateDiff"/>--}%
%{--</g:form>--}%
    <g:form controller="functionalTests" method="post" >
        First Number: <g:textField name="a"/><br/>
        Second Number: <g:textField name="b"/><br/>
        <g:actionSubmit value="calculateSum" action="calculateSum"/>
        <g:actionSubmit value="calculateDiff" action="calculateDiff"/>
        <g:actionSubmit value="calculateProduct" action="calculateProduct"/>
        <g:actionSubmit value="calculateQuotient" action="calculateQuotient"/>
    </g:form>

%{--<form>--}%
%{--  <input type="text" name="firstname" value="Mickey"><br>--}%
%{--  <input type="submit" value="Submit">--}%
%{--<input type="submit" href="${createLink(controller:'gelo', action:'insert')}">--}%
%{--</form>--}%
%{--<form>--}%
%{--  <input type="text" name="firstname" value="Mickey"><br>--}%
%{--  <input type="submit" value="Submit">--}%
%{--</form>--}%
</div>
</body>
</html>
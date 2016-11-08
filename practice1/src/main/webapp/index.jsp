<%@ page import="stingion.Practice2" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ex" uri="/WEB-INF/custom.tld" %>
<html>
    <body>
        <h2>Hello World!</h2>
        <h3><%=new Practice2().getWord()%></h3>
        <c:out value="Some outpout!"/>
        <ex:h/>
        <br />
        <ex:ha attr="22" second="okey now"/>
    </body>
</html>

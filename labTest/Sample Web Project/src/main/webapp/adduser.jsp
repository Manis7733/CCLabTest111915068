<%@page import="com.subodh.Signup"%>  
<jsp:useBean id="u" class="com.subodh.User"></jsp:useBean>  
<jsp:setProperty property="*" name="u"/>  
  
<%  
int i=Signup.save(u);  
if(i>0){  
response.sendRedirect("adduser-success.jsp");  
}else{  
response.sendRedirect("adduser-error.jsp");  
}  
%>  
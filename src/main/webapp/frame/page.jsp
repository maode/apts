<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib  prefix="s"  uri="/struts-tags" %>
<%@taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="pageDiv">
<pg:pager items="${pager.totalRecords}" url="${url}" maxPageItems="${pager.pageSize}" export="currentPageNumber=pageNumber">  
<s:iterator  value="#paramslist">
	<pg:param name="${key}" value="${val}"/> 
</s:iterator>
               <pg:first><a href="${pageUrl}"><nobr>[首页]</nobr></a></pg:first>  
                <pg:prev><a href="${pageUrl}">前一页</a></pg:prev>   
               <pg:pages>  
               <%
               String curr=pageContext.getAttribute("currentPageNumber").toString();
               String  pageNum=pageContext.getAttribute("pageNumber").toString();
               if(curr.equals(pageNum)) {%>
                           <font color="red">${pageNumber}</font>   
              <%}else {%>
                           <a href="${pageUrl}">${pageNumber}</a>  
                           <%}; %>  
               </pg:pages>   
               <pg:next><a href="${pageUrl}">下一页</a></pg:next>   
               <pg:last><a href="${pageUrl}"><nobr>[尾页]</nobr></a></pg:last>   
        </pg:pager> 
  </div>
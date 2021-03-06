<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MayEye BAEKJH Board</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>제목</th>
			<td>${boardDTO.title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${boardDTO.contents}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${boardDTO.date}</td>
		</tr>	
		<tr>
			<th>조회수</th>
			<td>${boardDTO.count}</td>
		</tr>	
		<c:forEach var="file" items="${fileDetailList}" varStatus="loop">
		<tr>
			<th>첨부파일${loop.count}</th>
			<td><a href="<c:url value="/fileDownload/${boardDTO.num}/${file.atch_file_id}/${file.file_sn}" />">${file.ori_name}</a></td>
		</tr>
		</c:forEach>
	</table>
	<div>
		<a href="<c:url value="/boardEdit/${boardDTO.num}" />">수정</a>
		<a href="<c:url value="/boardDelete/${boardDTO.num}" />">삭제</a>
		<form id="frm" action="<c:url value="/boardSearchList" />" >
			<input type="hidden" name="searchType" value="${searchCriteria.searchType }"/>
			<input type="hidden" name="keyword" value="${searchCriteria.keyword }"/>
			<input type="hidden" name="page" value="${searchCriteria.page }"/>
			<input type="hidden" name="perPageNum" value="${searchCriteria.perPageNum }"/>
			<button>목록</button>
		</form>
	</div>
</body>
</html>
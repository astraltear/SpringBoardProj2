<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<form name="han_form" action="testhangul" method="GET">
<input type="text" name='searchText' id="searchText"
						value='${t3.searchText }'>
					<input type="submit" value="전송">
<br><br>
han.searchText:${han.searchText }	<br>
t3.searchText:${t3.searchText }	<br>
t4.searchText:${t4.searchText }	<br>

han.searchText:테스트	
t3.searchText:테스트	
t4.searchText:	
				
</form>					

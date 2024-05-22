<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("UTF-8");
  int age = Integer.parseInt(request.getParameter("age"));
  String gender = request.getParameter("gender");
  int height = Integer.parseInt(request.getParameter("height"));
  int weight = Integer.parseInt(request.getParameter("weight"));
  int exerciseEXP = Integer.parseInt(request.getParameter("exerciseEXP"));
  int goals = Integer.parseInt(request.getParameter("goals"));
  
%>

나이: <%= age %> (타입: <%= ((Object) age).getClass().getName() %>) <br>
성별: <%= gender %> (타입: <%= gender.getClass().getName() %>) <br>
신장: <%= height %> (타입: <%= ((Object) height).getClass().getName() %>) <br>
체중: <%= weight %> (타입: <%= ((Object) weight).getClass().getName() %>) <br>
경험: <%= exerciseEXP %> (타입: <%= ((Object) exerciseEXP).getClass().getName() %>) <br>
목표: <%= goals %> (타입: <%= ((Object) goals).getClass().getName() %>) <br>



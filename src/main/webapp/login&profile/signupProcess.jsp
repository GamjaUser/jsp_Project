<%@ page import="login.MemberInfoDAO"%>
<%@ page import="login.MemberDAO"%>
<%@ page import="DTO.MemberInfoDTO"%>
<%@ page import="DTO.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
  // 폼 데이터 읽기
  request.setCharacterEncoding("UTF-8");
  String id = request.getParameter("id");
  String password = request.getParameter("password");
  int age = Integer.parseInt(request.getParameter("age"));
  String gender = request.getParameter("gender");
  int height = Integer.parseInt(request.getParameter("height"));
  int weight = Integer.parseInt(request.getParameter("weight"));
  int exerciseEXP = Integer.parseInt(request.getParameter("exerciseEXP"));
  int goals = Integer.parseInt(request.getParameter("goals"));

  // DTO 객체 생성 및 데이터 저장
  MemberDTO member = new MemberDTO();
  member.setId(id);
  member.setPassword(password);
  member.setAge(age);
  member.setGender(gender);
  member.setExerciseEXP(exerciseEXP);
  member.setGoals(goals);

  MemberInfoDTO memberInfo = new MemberInfoDTO();
  memberInfo.setId(id);
  memberInfo.setHeight(height);
  memberInfo.setWeight(weight);

  // DAO 객체 생성 및 데이터 저장
  
  MemberDAO memberdao = new MemberDAO(application);
	MemberInfoDAO memberinfodao = new MemberInfoDAO(application);

	int memberisSuccess = memberdao.insertMember(member);
	int memberinfoisSuccess = memberinfodao.insertMemberInfo(memberInfo);
//   isSuccess = memberdao.insertMember(member) && memberinfodao.insertMemberInfo(memberInfo);

  if (memberisSuccess==1 && memberinfoisSuccess==1) {
    out.print("success");
  } else {
    out.print("failure\n");
    out.print("id: " + id + "\n");
    out.print("password: " + password + "\n");
    out.print("age: " + age + "\n");
    out.print("gender: " + gender + "\n");
    out.print("height: " + height + "\n");
    out.print("weight: " + weight + "\n");
    out.print("exerciseEXP: " + exerciseEXP + "\n");
    out.print("goals: " + goals + "\n");
  }
%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class="table-container" style="--data-limit: 9">
	<div class="table" id="table-0" data-limit="9">
		<div class="table-row table-heading">
			<div class="table-col">
				#
			</div>
			<div class="table-col">
				title
			</div>
			<div class="table-col">
				writer
			</div>
			<div class="table-col">
				views
			</div>
			<div class="table-col">
				date
			</div>
		</div>
		<div class="table-row" data-copy="103">
			<div class="table-col">
				<span class="auto-increment">0</span>
			</div>
			<div class="table-col">
				<span class="auto-firstname"></span>
			</div>
			<div class="table-col">
				<span class="auto-lastname"></span>
			</div>
			<div class="table-col">
				<span class="auto-title"></span>
			</div>
			<div class="table-col">
				<span class="auto-integer" min="0" max="250"></span>
			</div>
		</div>
	</div>

	<div class="pagination-container">
		<div class="d-flex row flex-fill align-items-end justify-content-center">
			<span class="pagination-info"></span>
			<button class="pagination-extreme pagination-left">
				<i class="fa-solid fa-angles-left"></i>
			</button>
			<button class="pagination-extreme pagination-left-one">
				<i class="fa-solid fa-angle-left"></i>
			</button>
			<div class="d-flex flex-fill justify-content-center">
				<div class="pagination-wrapper">
					<ul class="pagination" data-table="table-0"></ul>
				</div>
			</div>
			<button class="pagination-extreme pagination-right-one">
				<i class="fa-solid fa-angle-right"></i>
			</button>
			<button class="pagination-extreme pagination-right">
				<i class="fa-solid fa-angles-right"></i>
			</button>
		</div>
	</div>
	
	<div class="progress-bar">
		<div class="progress-point"></div>
	</div>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../css/survey_popup.css">
  
</head>
<body>
  
    <form action = "" id="survey-form" method="GET" class="columns column is-4 is-offset-4 form">
        <header>
            <h1 class="title is-2" id="title">��������</h1>
            
            <hr>
        </header>
        <fieldset>
            ����
           
         <select class="input-text" name="age" id="age"  required autofocus>
           <option value="" disabled selected></option>
           <option value="1" >1</option>
           <option value="1" >1</option>
           <option value="1" >1</option>
           <option value="1" >1</option>
           
           
           </select>
            ���� <br>
              <td>
            <input  type="radio" name="gender" id="gender" value="��" required>����
            <input  type="radio" name="gender" id="gender" value="��" required>����
              </td>
          <br><br>
            ����
            <input class="input-text" type="number" name = "height "id="height" min="120" max="300" required>
            ü��
          <input class="input-text" type="number" name="weight" id="weight" min="20" max="300" required>
            

            ��ҿ� ��� ������� �ϰ� �����Ű���? 
            <div class="input-click">
                <span><input type="radio" name="healthyEXP" value="1" required>Ȱ���� ���ų� ��� ���ϴ� ���
</span>
                <span><input type="radio" name="healthyEXP" value="2">������ Ȱ�� �� ��� �ϴ� ���(1~3��/1��)</span>
                <span><input type="radio" name="healthyEXP" value="3">������ Ȱ�� �� ��� �ϴ� ���(3~5��/1��)
</span>
                <span><input type="radio" name="healthyEXP" value="4">�������� Ȱ�� �� ��� �ϴ� ���(6~7��/1��)
</span>
              <span><input type="radio" name="healthyEXP" value="5">�ſ� �������� Ȱ�� �� �, �����
</span>
            </div>


            ���ǥ
            <div id="goals" class="input-click" >
                <span><input type="radio" name="goals" value="1" required>ü�� ����
</span>
                <span><input type="radio" name="goals" value="2">��ũ��</span>
                <span><input type="radio" name="goals" value="3">ü�� ���
</span>
                <span><input type="radio" name="goals" value="4">������ ���
</span>
              
            </div>
            
            <button id="submit" class="button is-primary" type="submit">Submit</button>
        </fieldset>
        
    </form>
    <script>
        function populateAgeOptions() {
            const selectElement = document.getElementById('age');

            // ���� ���� ���� (��: 1 ~ 100)
            const minAge = 1;
            const maxAge = 100;

            // �ɼ��� �ݺ����� ����Ͽ� ����
            for (let age = minAge; age <= maxAge; age++) {
                const option = document.createElement('option');
                option.value = age; // �ɼ� ������ ������ ����
                option.textContent = age; // �ɼ� ǥ�� �ؽ�Ʈ�� ������ ����
                selectElement.appendChild(option); // ������ �ɼ��� <select> ��ҿ� �߰�
            }
        }

        // ������ �ε� �� �ɼ��� ����
        window.addEventListener('DOMContentLoaded', populateAgeOptions);
        
        
        
    </script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>

<script>  
var app=angular.module('myApp',[]);
app.controller('Ctrl',function($scope,$http)
		{
	
	
	$scope.show = 0;
	
	$scope.registerStudent = function(){
		$http.post('Controller?action=registerStu&&stuName='+$scope.stuName+
				'&&stuEmail='+$scope.stuEmail+'&&stuNum='+$scope.stuNum).then(function(response){
					//$scope.message=response.data;
					$scope.student = response.data;
					$scope.show = 2;
				});
		};
		
		$scope.view = function(){
			
			$http.post('Controller?action=view').then(function(response){
				$scope.students=response.data;
				$scope.show=3;
				
			});
			
			
			
		};
		$scope.deleteStudent = function(){
			$http.post('Controller?action=deletestu&&stuid='+$scope.stuid
					).then(function(response){
						//$scope.message=response.data;
						$scope.deletemessage = response.data;
						$scope.show = 5;
					});
			};
$scope.updateStudent = function(){
			$http.post('Controller?action=updatestu&&studentid='+$scope.stuid+'&&studentname='+$scope.studentname+
					'&&studentnumber='+$scope.studentnumber
					).then(function(response){
						//$scope.message=response.data;
						$scope.updatemessage = response.data;
						$scope.show = 7;
					});
			};
		
		
	               
		});

</script>

</head>
<body>

<h1>Student Profile</h1>
<div ng-app="myApp" ng-controller="Ctrl">
<input type=submit value=RegisterStudent ng-click="show=1">
<input type=submit value=ViewStudent ng-click="view()"></br></br>
<input type=submit value="Deletestudent" ng-click="show=4">
<input type=submit value="updatestudent" ng-click="show=6">
</br>
</br>

<div ng-show="show==1">
<form name="myForm">
<table align=center>
<tr><td>Name:</td><td><input type=text name=stuName ng-model=stuName required></td>
<td><span style="color:red" ng-show="myForm.stuName.$touched && myForm.empName.$invalid">This is required<br></span></td></tr>
<tr><td>Email:</td><td><input type=email name=stuEmail ng-model=stuEmail></td>
<td><span style="color:red" ng-show="myForm.stuEmail.$error.email">Please enter valid email<br></span></td></tr>


<tr><td>Number:</td><td><input type=tel name=stuNum ng-model=stuNum required ng-pattern=/^[0-9]*$/ ng-maxlength=10></td></tr></table>

        <span style="color:red" ng-show="myForm.stuNum.$error.pattern">Not a valid number!</span>
        <span ng-show="myForm.stuNum.$error.required">Please enter contact number</span>
        <span style="color:red" ng-show="myForm.stuNum.$invalid">contact number should have 10 digits</span>
<input type=submit value=Register ng-click=registerStudent()>
</form>
</div>
<div ng-show="show==2">

<table>
		<tr>
			<td><label>StudentId</label></td>
			<td><label>:</label></td>
			<td>{{student.id}}<br></td>
		</tr>
		<tr>
			<td><label>Student name</label></td>
			<td><label>:</label></td>
			<td>{{student.name | uppercase}}<br></td>
		</tr>
		<tr>
			<td><label>Student Number</label></td>
			<td><label>:</label></td>
			<td>{{student.number}}<br></td>

		</tr>
		<tr>
			<td><label>Email</label></td>
			<td><label>:</label></td>
			<td>{{student.email}}<br></td>

		</tr>
	</table>

</div>
<div ng-show="show==3">



Search<input type="text" ng-model="test" required></br>
<table border=1>
<tr>
<th>ID</th>
<th>NAME</th>
<th>EMAIL</th>
<th>NUMBER</th>
</tr>
<tr ng-repeat="stu in students | filter:test">

<td>{{stu.id}}</td>
<td>{{stu.name}}</td>
<td>{{stu.email}}</td>
<td>{{stu.number}}</td>

</tr>

</table>
<!-- Delete -->
</div>
<div ng-show="show==4">
<form name="myForm">
<table align=center>

<tr><td>enter the id<input type="text" ng-model="stuid"></td>
<tr><td><center><input type=submit value="DeleteStudent" ng-click="deleteStudent()"></center></td></tr>
</table>
</form>
</div>
<div ng-show="show==5">
{{deletemessage}}

</div>
<!-- Update --> 
<div ng-show="show==6">
<form name="myForm">
<table align=center>
<tr><td>enter student   id<input type="text" ng-model="stuid"></td>
<tr><td>enter student name<input type="text" ng-model="studentname"></td>
<tr><td>enter student  num<input type="text" ng-model="studentnumber"></td>
<tr><td><input type=submit value="update" ng-click="updateStudent()"></td></tr>
</table>
</form>
</div>
<div ng-show="show==7">
{{updatemessage}}

</div>
</div>
</body>
</html>
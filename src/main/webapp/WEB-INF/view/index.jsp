<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/index.css">
<!-- jQuery library -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Fizz Buzz</title>
</head>
<body>
<div class="container">
   <div class="row">
       <div class="col-sm-4"><!-- NO CONTENT --></div>
       <div class="col-sm-4">
           <div class="well">FIZZ BUZZ TESTING</div>
           <input type="text" class="form-control" id="inputNumber0" data="inputNumber0" placeholder="Enter a new testing number">
           <div class="alert alert-warning" id="errorNumber0">Your entered is not a number, please try again!</div>
            <button type="button" class="btn btn-default" name="addBtn">
		      <span class="glyphicon glyphicon-plus"></span> Add more number
		    </button>
		    <button type="button" class="btn btn-default" name="searchBtn">
		      <span class="glyphicon glyphicon-search"></span> Get result
		    </button>
           <div class="alert alert-warning">Service is getting down, please try again later!</div>
       </div>
       <div class="col-sm-4"><!-- NO CONTENT --></div>
   </div><!-- row -->
</div><!-- container -->
<script type="text/javascript" src="js/index.js"></script>
</body>
</html>
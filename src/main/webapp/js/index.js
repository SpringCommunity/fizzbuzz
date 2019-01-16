/* Add more number event */
var LKM = 0;
$("button[name='addBtn']").on("touch click", function(){
	LKM ++;
	$('<input type="text" class="form-control" id="inputNumber'+LKM+'" data="#errorNumber'+LKM+'" placeholder="Enter a new testing number">'+
	  '<div class="alert alert-warning" id="errorNumber'+LKM+'">Your entered is not a number, please try again!</div>'+
	  '<div class="alert alert-success" id="resultNumber'+LKM+'"></div>')
	  .insertAfter("#errorNumber"+ (LKM -1));
});

$( document ).on("focus", "input[type='text']", function(){
	$($(this).attr("data")).hide();
});
var getUrl = function() {
	return window.location.href.split("/")[0] + "//" + window.location.href.split("/")[2] + "/";
};
var fetchDataFromApi = function(){
	return $.ajax({
		url: getUrl()+"fizzbuzz",
		method: "get",
		dataType: "json"
	})
};

var validateInput = function(input){
    return (input.trim().length == 0 || isNaN(input))? true : false;
};

var getResult = function(data){
};

$("button[name='searchBtn']").on("touch click", function(){
	$("input[type='text']").each(function(){
		var input = $(this).val();
		var errorId = $(this).attr("data");
		var result = errorId.split("errorNumber")[1];
		console.log(validateInput(input));
		if(validateInput(input)){
			console.log(errorId);
			$(errorId).show();
		}else{
			$(errorId).hide();
			var promies = fetchDataFromApi();
			promies.then(data => {
				$("#resultNumber"+result).html(getResult(data));
			})
			.catch(error => $(".alert-warning").children().eq(2).show());
		}
	});
});
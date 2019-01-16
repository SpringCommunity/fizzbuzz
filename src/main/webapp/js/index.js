/* Add more number event */
var LKM = 0;
$("button[name='addBtn']").on("touch click", function(){
	LKM ++;
	$('<input type="text" class="form-control" id="inputNumber'+LKM+'" data="#errorNumber'+LKM+'" placeholder="Enter next testing number">'+
	  '<div class="alert alert-warning" id="errorNumber'+LKM+'">Your entered is not a number, please try again!</div>')
	  .insertAfter("#errorNumber"+ (LKM -1));
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
    return (input.trim().length > 0 && isNaN(input))
};

var getResult = function(data){
};

$("button[name='searchBtn']").on("touch click", function(){
	$("input[type='text']").each(function(){
		var input = $(this).val();
		var errorId = $(this).attr("data");
		if(validateInput(input)){
			$(errorId).show();
		}else{
			$(".alert-warning").children().eq(1).hide();
			var promies = fetchDataFromApi();
			promies.then(data => {
				$(".alert-warning:first-child").html(getResult(data));
			})
			.catch(error => $(".alert-warning").children().eq(2).show());
		}
	});
});
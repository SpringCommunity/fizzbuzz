/* Add more number event */
var LKM = 0;
$("button[name='addBtn']").on("touch click", function(){
	LKM ++;
	$('<input type="text" class="form-control" id="inputNumber'+LKM+'" data="#errorNumber'+LKM+'" placeholder="Enter a new testing number">'+
	  '<div class="alert alert-warning" id="errorNumber'+LKM+'">Your entered is not a number or empty input, please try again!</div>')
	  .insertAfter("#errorNumber"+ (LKM -1));
});

$( document ).on("focus", "input[type='text']", function(){
	$($(this).attr("data")).hide();
});

$("button[name='resetBtn']").on("touch click", function(){
	location.reload();
});

var getUrl = function() {
	return window.location.href.split("/")[0] + "//" + window.location.href.split("/")[2] + "/";
};
var fetchDataFromApi = function(){
	return $.ajax({
		url: getUrl()+"api",
		method: "get",
		dataType: "json"
	})
};

var validateInput = function(input){
    return (input.trim().length == 0 || isNaN(input));
};

var getResult = function(data, input){
	var number = parseInt(input);
	return (number%15 == 0)? data.fizzbuzz : ((number%5 == 0)? data.buzz : ((number%3 == 0)? data.fizz : number));
};

$("button[name='searchBtn']").on("touch click", function(){
	$(".alert.alert-success").remove();
	var promies = fetchDataFromApi();
	promies.then(data => {
		$("input[type='text']").each(function(){
			var input = $(this).val().trim();
			var errorId = $(this).attr("data");
			var resultId = errorId.split("errorNumber")[1];
			if(validateInput(input)){
				console.log(errorId);
				$(errorId).show();
			}else{
				$(errorId).hide();
				$('<div class="alert alert-success">Result: '+getResult(data, input)+'</div>').insertAfter($(this));
			}
		});
	})
	.catch(error => $(".alert-warning").children().eq(2).show());
});
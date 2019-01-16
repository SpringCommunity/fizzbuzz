var getUrl = function() {
	return window.location.href.split("/")[0] + "//" + window.location.href.split("/")[2] + "/";
}
var fetchDataFromApi = function(){
	return $.ajax({
		url: getUrl()+"fizzbuzz",
		method: "get",
		dataType: "json"
	})
}

var compareInputNumber = function(input){
	
}

$("#inputNumbers").on("keyup", function(){
	var promies = fetchDataFromApi();
	promies.then(data => {
		
	})
	.catch(error => $(".alert-warning:last-child").show());
});
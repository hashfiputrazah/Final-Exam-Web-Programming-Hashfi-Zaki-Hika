$(document).ready(function() {
    //console.log(today);
	console.log("a")
	getLib();

})
function getLib() {
	 $.ajax({
	        url: "/get_Book",
	        type: "GET",
	        success: function(res) {
	        	console.log("res",res)
	        }
	 })
}
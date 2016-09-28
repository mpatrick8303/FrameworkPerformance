angular
	.module("framework")
	.controller("FrameworkListController", FrameworkListCtrl)
	
FrameworkListCtrl.$inject = ['$http']
function FrameworkListCtrl($http){
	var ctrl = this;
	
	$http.get("./frameworks").then(function(response){
		ctrl.list = response.data;
	});
}
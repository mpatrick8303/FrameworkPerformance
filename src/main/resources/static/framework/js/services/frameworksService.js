angular.module("framework").factory("Frameworks", Frameworks)
	
Frameworks.$inject = ['$http']
function Frameworks($http){
	
	return {
		all: function(){
			return $http.get("json/frameworks").then(function(response){
				return response.data;
			});
		}
	}
}
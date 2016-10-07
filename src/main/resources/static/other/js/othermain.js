angular.module("otherFrame", ["ui.router"]).config(configure)

configure.$inject = ['$stateProvider', '$urlRouterProvider']
function configure($stateProvider, $urlRouterProvider) {
	
	$stateProvider
		.state('hello',{
			url:'/',
			controller: 'OtherStartController',
			controllerAs: 'oc',
			templateUrl: 'other/template/oth.html'
		})
}
angular
	.module("framework", ["ui.router"])
	.config(configure)
	
configure.$inject = ['$stateProvider', '$urlRouterProvider']
function configure($stateProvider, $urlRouterProvider) {
	
	$stateProvider
		.state('framesworks', {
			url: 'json/frameworks',
			controller: 'FrameworkListController',
			controllerAs: 'fc',
			templateUrl: 'templates/benchmarks.html'
		})
		
	$urlRouterProvider.otherwise('/')
}
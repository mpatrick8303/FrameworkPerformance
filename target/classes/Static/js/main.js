angular.module("framework", ["ui.router"]).config(configure)
	
configure.$inject = ['$stateProvider', '$urlRouterProvider']
function configure($stateProvider, $urlRouterProvider) {
	
	$stateProvider
		.state('dashboard', {
			url:'/',
			controller: 'DashboardController',
			controllerAs: 'dash',
			templateUrl: 'templates/dashboard.html'
		})
		.state('frameworks', {
			url: '/frameworks',
			controller: 'FrameworkListController',
			controllerAs: 'fc',
			templateUrl: 'templates/benchmarks.html'
		})
		
	$urlRouterProvider.otherwise('/')
}
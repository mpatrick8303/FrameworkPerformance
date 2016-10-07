angular.module("framework", ["ui.router"]).config(configure)

configure.$inject = ['$stateProvider', '$urlRouterProvider']
function configure($stateProvider, $urlRouterProvider) {

	$stateProvider
		.state('start', {
			url: '/',
			controller: 'StartController',
			controllerAs: 'start',
			templateUrl: 'framework/templates/start.html'
		})
		.state('dashboard', {
			url:'/frameworks/dash',
			controller: 'DashboardController',
			controllerAs: 'dash',
			templateUrl: 'framework/templates/dashboard.html'
		})
		.state('frameworks', {
			url: '/frameworks',
			controller: 'FrameworkListController',
			controllerAs: 'fc',
			templateUrl: 'framework/templates/benchmarks.html'
		})
		.state('details', {
			url:'/:id',
			controller: 'detailsController',
			controllerAs: 'dc',
			templateUrl: 'framework/templates/details.html'
		})


	$urlRouterProvider.otherwise('/')
}

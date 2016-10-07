angular.module("framework").controller("DashboardController",DashboardCtrl)

DashboardCtrl.$inject = ['Frameworks']
function DashboardCtrl(Frameworks){
	var ctrl = this;

	console.log('dash called');

	Frameworks.all().then(function (frameworks){
		ctrl.count = frameworks.length;
	})
}

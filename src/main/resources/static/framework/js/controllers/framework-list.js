angular.module("framework").controller("FrameworkListController", FrameworkListCtrl)

FrameworkListCtrl.$inject = ['Frameworks']
function FrameworkListCtrl(Frameworks){
	var ctrl = this;

	console.log('list called')

	Frameworks.all().then(function(frameworks){
		ctrl.frameworks = frameworks;
	});
	ctrl.benchmarkName = 'framework';
}

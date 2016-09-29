angular.module("framework").controller("FrameworkListController", FrameworkListCtrl)
	
FrameworkListCtrl.$inject = ['Frameworks']
function FrameworkListCtrl(Frameworks){
	var ctrl = this;
	
	Frameworks.all().then(function(frameworks){
		ctrl.frameworks = frameworks;
	});
	ctrl.benchmarkName = 'framework';
}
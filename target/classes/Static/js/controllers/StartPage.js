angular.module("framework").controller("StartController",StartCtrl)

StartCtrl.$inject = ['Frameworks']
function StartCtrl(Frameworks){
	var ctrl = this;
	Frameworks.all().then(function (frameworks){
		ctrl.number = frameworks.length;
	})
}

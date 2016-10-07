angular.module("framework").controller("detailsController", detailsCtrl)

detailsCtrl.$inject = ['$state', 'Frameworks']
function detailsCtrl($state, Frameworks){
	var ctrl = this;

  console.log('details called')
  console.log('state', $state)
  console.log('id isads', $state.params.id);

	Frameworks.all().then(function(frameworks){
		frameworks.forEach(function (obj) {
      if(obj.id === Number($state.params.id)){
        ctrl.framework = obj
      }
    })
	});

}

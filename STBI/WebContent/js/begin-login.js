angular.module("myLogin",['ui.bootstrap']).controller("loginCtrl", function($scope,$filter){
		    $scope.emailid = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
	        $scope.mobiles = /^(\+\91{1,2}[- ])\d{10}$/;
	        $scope.landline = /^[0-9]\d{2,5}-\d{6,8}$/;
	        $scope.numberonly = /^[0-9]{1,6}$/;
	        $scope.stringonly = /^[a-zA-Z ]{1,25}$/;
	        $scope.ages = /^[0-9]{1,2}$/;
	        $scope.debitcard = /^[0-9]{16,16}$/;
	        $scope.cvvs = /^[0-9]{3,3}$/;
	        $scope.pincodes = /^[0-9]{6,6}$/;
	        $scope.adhar = /^[0-9]{12,12}$/;
	        $scope.date = /^(0?[1-9]|1[012])\/(0?[1-9]|[12][0-9]|3[01])\/(199\d)|([2-9]\d{3})$/; 
	        
	        
	        $scope.processDate = function(dt)
	        {
	          return $filter('date')(dt, 'dd/MM/yyyy');
	        }
});
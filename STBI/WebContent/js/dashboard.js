angular.module("myDashboard",[]).controller("dashboard", function($scope){
	 $scope.today = new Date();
	 $scope.rating = 5;
	 
	 $scope.emailid = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    $scope.mobiles = /^(\+\91{1,2}[- ])\d{10}$/;
    $scope.landline = /^[0-9]\d{2,5}-\d{6,8}$/;
    $scope.numberonly = /^[0-9]{1,6}$/;
    $scope.stringonly = /^[a-zA-Z ]{1,25}$/;
    $scope.ages = /^[0-9]{1,2}$/;
    $scope.dateformat = /^[0,1]?\d{1}\/(([0-2]?\d{1})|([3][0,1]{1}))\/(([1]{1}[9]{1}[9]{1}\d{1})|([2-9]{1}\d{3}))$/ ;
	 
	 $scope.setFile = function(element) {
        $scope.$apply(function($scope) {
            $scope.theFile = element.files[0];
            $scope.FileMessage = '';
            var filename = $scope.theFile.name;
            console.log(filename.length)
            var index = filename.lastIndexOf(".");
            var strsubstring = filename.substring(index, filename.length);
            if (strsubstring == '.pdf' || strsubstring == '.doc')
            {
              console.log('File Uploaded sucessfully');
            }
            else {
                $scope.theFile = '';
                  $scope.FileMessage = 'please upload correct File Name, File extension should be .pdf, .doc or';
            }

        });
    };
})
.directive('starRating',
		function() {
			return {
				restrict : 'A',
				template : '<ul class="rating">'
						 + '	<li ng-repeat="star in stars" ng-class="star" ng-click="toggle($index)">'
						 + '\u2605'
						 + '</li>'
						 + '</ul>',
				scope : {
					ratingValue : '=',
					max : '=',
					onRatingSelected : '&'
				},
				link : function(scope, elem, attrs) {
					var updateStars = function() {
						scope.stars = [];
						for ( var i = 0; i < scope.max; i++) {
							scope.stars.push({
								filled : i < scope.ratingValue
							});
						}
					};
					
					scope.toggle = function(index) {
						scope.ratingValue = index + 1;
						scope.onRatingSelected({
							rating : index + 0
						});
					};
					
					scope.$watch('ratingValue',
						function(oldVal, newVal) {
							if (newVal) {
								updateStars();
							}
						}
					);
				}
			};
		}
	);
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="upgradeDashboard" ng-controller="upgradeCtrl">
    <head>
	    <title>Dashboard</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	    <link rel="stylesheet" href="css/upgrade-dashboard.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.2/angular.min.js"></script>
	    <script src="js/city-navbar.js"></script>
    </head>
	<body>
		<div ng-include="'upgrade-navbar.jsp'"></div>
		<div class="containers" >
			<div class="top">
				<ul class="nav nav-tabs navs">
				    <li class="active"><a data-toggle="tab" href="#schools-level-program" class="tab-font-grorgia">SCHOOL/Jr. COLLEGE LEVEL SKILLS</a></li>
				    <li><a data-toggle="tab" href="#graduate-level-program" class="tab-font-grorgia">GRADUATE LEVEL SKILLS</a></li>
				    <li><a data-toggle="tab" href="#professional-level-program" class="tab-font-grorgia">PROFESSIONAL LEVEL SKILLS</a></li>
				</ul>
				<div class="tab-content">
				    <div id="schools-level-program" class="tab-pane fade in active">
					    <div class="panel panel-default card panels">
					    	<div class="panel-body">
					    	    <button type="button" class="btn btn-info active" data-toggle="collapse" data-target="#school-level">Filter</button>
								<div id="school-level" class="collapse center ">
								   <form>
								      <input type="search" name="googlesearch" placeholder="Program Name" class="search"> 
								      <input type="search" name="googlesearch" placeholder="Skill Name" class="search"> 
								      <input type="search" name="googlesearch" placeholder="State" class="search">
								      <input type="search" name="googlesearch" placeholder="City" class="search"> 
								      <button class="btn btn-info btn-lg active "> <span class="glyphicon glyphicon-search "></span></button>
								    </form>
								</div>
					    	   <div><hr>
								<table class="table table-list table-hover card">
								    <thead>
								      <tr>
								        <th class="table-fent-gray">ID</th>
								        <th class="table-dark-gray">LIST OF PROGRAM</th>
								        <th class="table-fent-gray">DATE </th>
								        <th class="table-fent-gray"></th>
								      </tr>
								    </thead>
								    <tbody>
								      <tr>
								        <td><b>325335</b></td>
								        <td><p class="table-idea"><a href="upgrade-view-available-program.jsp" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
								        <td><p class="table-data">23/06/2017</p></td>
								        <td><p class=" fload_right table-data-button">
											<a class="btn btn-xs btn-info active" href="upgrade-view-available-program.jsp" target="_blank">Apply & View</a>
										</p></td>
								      </tr>
								      <tr>
								        <td><b>325335</b></td>
								        <td><p class="table-idea"><a href="upgrade-view-available-program.jsp" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
								        <td><p class="table-data">23/06/2017</p></td>
								        <td><p class=" fload_right table-data-button">
											<a class="btn btn-xs btn-info active" href="upgrade-view-available-program.jsp" target="_blank">Apply & View</a>
										</p></td>
								      </tr>
								    </tbody>
								  </table><hr>
								  <!-------------------------------Delete----------------------------------->
								  <div class="modal fade" id="delete" role="dialog">
									    <div class="modal-dialog modal-md">
									      <div class="modal-content">
									        <div class="modal-header">
									          <button type="button" class="close" data-dismiss="modal">&times;</button>
									          <h5 class="modal-title">Say reason for deleting your idea.</h5>
									        </div>
									        <div class="modal-body">
									          <textarea rows="" cols="" class="form-control"></textarea>
									        </div>
									        <div class="modal-footer">
									          <button type="Submit" class="btn btn-warning active" data-dismiss="modal">Submit</button>
									          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
									        </div>
									    </div>
									  </div>
								 </div>
					          </div>
					      </div>
					   </div>
					</div>
					<!------------------------------------------------------COURSES------------------------------------------->
					<div id="graduate-level-program" class="tab-pane fade">
					    <div class="panel panel-default card panels">
						    <div class="panel-body">
						        <button type="button" class="btn btn-info active" data-toggle="collapse" data-target="#graduate-level">Filter</button>
								<div id="graduate-level" class="collapse center ">
								    <form>
								      <input type="search" name="googlesearch" placeholder="Program Name" class="search"> 
								      <input type="search" name="googlesearch" placeholder="Skill Name" class="search"> 
								      <input type="search" name="googlesearch" placeholder="State" class="search">
								      <input type="search" name="googlesearch" placeholder="City" class="search"> 
								      <button class="btn btn-info btn-lg active "> <span class="glyphicon glyphicon-search "></span></button>
								    </form>
								</div>
						    	<div><hr>
									<table class="table table-list table-hover card">
									    <thead>
									      <tr>
									        <th class="table-fent-gray">ID</th>
									        <th class="table-dark-gray">LIST OF PROGRAM</th>
									        <th class="table-fent-gray">DATE </th>
									        <th class="table-fent-gray"></th>
									      </tr>
									    </thead>
									    <tbody>
									      <tr>
									        <td><b>325335</b></td>
									        <td><p class="table-idea"><a href="upgrade-view-available-program.jsp" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
									        <td><p class="table-data">23/06/2017</p></td>
									        <td><p class=" fload_right table-data-button">
												<a class="btn btn-xs btn-info active" href="upgrade-view-available-program.jsp" target="_blank">Apply & View</a>
											</p></td>
									      </tr>
									      <tr>
									        <td><b>325335</b></td>
									        <td><p class="table-idea"><a href="upgrade-view-available-program.jsp" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
									        <td><p class="table-data">23/06/2017</p></td>
									        <td><p class=" fload_right table-data-button">
												<a class="btn btn-xs btn-info active" href="upgrade-view-available-program.jsp" target="_blank">Apply & View</a>
											</p></td>
									      </tr>
									    </tbody>
									  </table><hr>
									  <!-------------------------------Delete----------------------------------->
									  <div class="modal fade" id="delete" role="dialog">
										    <div class="modal-dialog modal-md">
										      <div class="modal-content">
										        <div class="modal-header">
										          <button type="button" class="close" data-dismiss="modal">&times;</button>
										          <h5 class="modal-title">Say reason for deleting your idea.</h5>
										        </div>
										        <div class="modal-body">
										          <textarea rows="" cols="" class="form-control"></textarea>
										        </div>
										        <div class="modal-footer">
										          <button type="Submit" class="btn btn-warning active" data-dismiss="modal">Submit</button>
										          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
										        </div>
										    </div>
										  </div>
									 </div>
						          </div>
						      </div>
						    </div>
					    </div>
						<!------------------------------------------------------Professional level program------------------------------------- -->
						<div id="professional-level-program" class="tab-pane fade">
						    <div class="panel panel-default card panels">
							    <div class="panel-body">
							        <button type="button" class="btn btn-info active" data-toggle="collapse" data-target="#professional-level">Filter</button>
									<div id="professional-level" class="collapse center ">
									  <form>
									      <input type="search" name="googlesearch" placeholder="Program Name" class="search"> 
									      <input type="search" name="googlesearch" placeholder="Skill Name" class="search"> 
									      <input type="search" name="googlesearch" placeholder="State" class="search">
									      <input type="search" name="googlesearch" placeholder="City" class="search"> 
									      <button class="btn btn-info btn-lg active "> <span class="glyphicon glyphicon-search "></span></button>
								    </form>
									</div>
							    	<div><hr>
										<table class="table table-list table-hover card">
										    <thead>
										      <tr>
										        <th class="table-fent-gray">ID</th>
										        <th class="table-dark-gray">LIST OF PROGRAM</th>
										        <th class="table-fent-gray">DATE </th>
										        <th class="table-fent-gray"></th>
										      </tr>
										    </thead>
										    <tbody>
										      <tr>
										        <td><b>325335</b></td>
										        <td><p class="table-idea"><a href="upgrade-view-available-program.jsp" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
										        <td><p class="table-data">23/06/2017</p></td>
										        <td><p class=" fload_right table-data-button">
													<a class="btn btn-xs btn-info active" href="upgrade-view-available-program.jsp" target="_blank">Apply & View</a>
												</p></td>
										      </tr>
										      <tr>
										        <td><b>325335</b></td>
										        <td><p class="table-idea"><a href="upgrade-view-available-program.jsp" target="_blank">The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.The English Wikipedia is the English-language edition of the free online encyclopedia Wikipedia.</a></p></td>
										        <td><p class="table-data">23/06/2017</p></td>
										        <td><p class=" fload_right table-data-button">
													<a class="btn btn-xs btn-info active" href="upgrade-view-available-program.jsp" target="_blank">Apply & View</a>
												</p></td>
										      </tr>
										    </tbody>
										  </table><hr>
										  <!-------------------------------Delete----------------------------------->
										  <div class="modal fade" id="delete" role="dialog">
											    <div class="modal-dialog modal-md">
											      <div class="modal-content">
											        <div class="modal-header">
											          <button type="button" class="close" data-dismiss="modal">&times;</button>
											          <h5 class="modal-title">Say reason for deleting your idea.</h5>
											        </div>
											        <div class="modal-body">
											          <textarea rows="" cols="" class="form-control"></textarea>
											        </div>
											        <div class="modal-footer">
											          <button type="Submit" class="btn btn-warning active" data-dismiss="modal">Submit</button>
											          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
											        </div>
											    </div>
											  </div>
										 </div>
							          </div>
							      </div>
							 </div>
						</div>
				   </div>
			  </div><!-----------------------------------end--------------------------------------------->
		 </div>
	</body>
</html>
<script>
	angular.module("upgradeDashboard",[]).controller("upgradeCtrl", function($scope){
		 $scope.today = new Date();
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
	});
</script>

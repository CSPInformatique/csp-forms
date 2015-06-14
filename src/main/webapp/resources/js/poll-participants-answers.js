var app = angular.module("PollParticipantsAnswers", []);

var pollId = window.location.pathname.split("/")[2];

app.config(function($locationProvider){
	$locationProvider.html5Mode(true);
});

app.controller("PollParticipantsAnswersController", function($scope, $http, $location){
	$scope.lang = "fr";
	
	$scope.changePage = function(page){
		$location.search("page", page);
		
		$scope.loadPollParticipantAnswers();
	}
	
	$scope.loadPollParticipantAnswers = function(){
		$http.get("/poll/1/pollParticipantAnswers?" + $.param($location.search())).success(function(pollParticipantAnswersPage){
			$scope.pollParticipantAnswersPage = pollParticipantAnswersPage;
		});
	};
	
	$scope.openPollParticipantAnswers = function(pollParticipantAnswers){
		location.href = "/pollParticipantAnswers/" + pollParticipantAnswers.id;
	};	

	var search = $location.search();
	if(search.page == undefined) $location.search("page", 0);
	if(search.resultPerPage == undefined) $location.search("resultPerPage", 50);
	if(search.sortBy == undefined) $location.search("sortBy", "id");
	if(search.direction == undefined) $location.search("direction", "DESC");
	
	$scope.loadPollParticipantAnswers();
});
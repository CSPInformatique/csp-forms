var app = angular.module("PollParticipantAnswers", []);
var pollParticipantAnswersId = window.location.pathname.split("/")[2];

app.controller("PollParticipantAnswersController", function($timeout, $scope, $http){
	$scope.lang = "fr";
	
	$http.get("/pollParticipantAnswers/" + pollParticipantAnswersId).success(function(pollParticipantAnswers){
		$scope.pollParticipantAnswers = pollParticipantAnswers;
		$scope.answers = {};
		
		for(var answerIndex in $scope.pollParticipantAnswers.answers){
			var answer = $scope.pollParticipantAnswers.answers[answerIndex];
			
			if(answer.question != null){
				$scope.answers[answer.question.id] = answer;
			}
		}
	});
});
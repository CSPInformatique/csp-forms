var app = angular.module("Poll", []);

app.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

app.service('fileUpload', ['$http', function ($scope, $http) {
    this.uploadQuestionFileToUrl = function($http, question, file, uploadUrl, success, error){
        var fd = new FormData();
        fd.append('file', file);
        $http.post(uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        })
        .success(function(response){
        	if(success != undefined){
        		success(question, response);
        	}
        })
        .error(function(msg){
        	if(error != undefined){
        		error(msg);
        	}
        });
    }
}]);

app.controller("PollController", function($timeout, $scope, $http, $sce, fileUpload){
	$scope.lang = "fr";
	
	$scope.hideAlerts = function(){
		$(".error").addClass("hidden");
	}
	
	$scope.postForm = function(){
		var answersArray = [];
		for(var answerIndex in $scope.answers){
			answersArray.push($scope.answers[answerIndex]);
		}		
		
		$http.post("/pollParticipantAnswers", {poll : $scope.poll, answers : answersArray}).success(function(pollParticipantAnswers){
			$scope.poll.submited = true;
		}).finally(function(){
			$scope.poll.loading = null;
		});
	}
	
	$scope.submit = function(){
		$scope.poll.loading = true; 
		var success;
		var fileCount = 0;
		
		// Uploading files.
		
		var filesArray = [];
		for(var fileIndex in $scope.files){
			filesArray.push($scope.files[fileIndex]);
		}
		
		for(var questionGroupIndex in $scope.poll.questionGroups){
			var questionGroup = $scope.poll.questionGroups[questionGroupIndex];
			for(var questionIndex in questionGroup.questions){
				var question = questionGroup.questions[questionIndex];
				
				var file = $scope.files[question.id];
				if(file != undefined){			
					fileUpload.uploadQuestionFileToUrl(
						$http, 
						question, 
						file, 
						"/image", 
						function(question, filename){
							// File uploaded successfully.
							$scope.answers[question.id] = {filePath : filename};
							
							++fileCount;
							
							if(fileCount == filesArray.length){
								// All files have been uploaded. Posting the form.
								$scope.postForm();
							}
						}, 
						function(message){
							$scope.errorMessage = message;
							$(".error").removeClass("hidden");
						}
					);
				}
			}
		}
	};
	
	$scope.validateField = function($event){
		$element = $($event.target);
		
		if($element.val() == ""){
			$element.addClass("invalid");
		}else{
			$element.removeClass("invalid");
		}
		
		$scope.validateFields();
	}
	
	$scope.validateFields = function(){
		$scope.valid = true;
		$("input[type='text'], textarea").each(function($index, element){
			var $element = $(element);
			
			if($element.val() == ""){
				$scope.valid = false;
			}
		});
		
		$("input[type='file'").each(function($index, element){
			if(element.files.length == 0){
				$scope.valid = false;
			}else if(element.files[0].size > 10000000 ){
				$scope.valid = false;
				$scope.errorMessage = "L'image ne peut excéder 10Mb.";
				$(".error").removeClass("hidden");
			}
		});
	}
	
	$http.get("/poll/1").success(function(poll){
		$scope.poll = poll;
		$scope.answers = {};
		$scope.files = {};
		
		for(var questionGroupIndex in $scope.poll.questionGroups){
			var questionGroup = $scope.poll.questionGroups[questionGroupIndex];
			for(var questionIndex in questionGroup.questions){
				var question = questionGroup.questions[questionIndex];
				
				$scope.answers[question.id] = {question : question};
			}
		}

		$scope.pollDescriptionHtml = $sce.trustAsHtml(poll.descriptionByLanguages['fr']);
		$scope.pollNoticeHtml = $sce.trustAsHtml(poll.noticeByLanguages['fr']);

		$timeout(function(){
			$("input[type='file']").change(function(){ 
				 $scope.validateFields(); 
				 $scope.$apply();
			 });
		});
	});
});
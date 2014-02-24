angular.module('core.controllers', []).
  controller('GroupsController', ['$scope', 'GroupsService', function($scope, GroupsService) {
          $scope.groups = GroupsService.query();
          
          $scope.add = function (newGroup) {
              $scope.groups.push(newGroup);
          };
  }]);
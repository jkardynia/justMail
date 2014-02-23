angular.module('coreApp.controllers', []).
  controller('GroupsController', [function() {
          this.groups = ['group first', 'group second', 'group third'];
          this.add = function () {
              this.groups.push(this.groupNew);
          };
  }]);
'use strict';

describe('Controller: GroupsController', function () {

  // load the controller's module
  beforeEach(module('core'));

  var GroupsController,
    scope,
    $httpBackend;

  // Initialize the controller and a mock scope
  beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
    $httpBackend = _$httpBackend_;
    $httpBackend.expectGET('/groups').
        respond([{name: 'Grupa1', id: 1}, {name: 'Grupa2', id: 2}]);

    scope = $rootScope.$new();
    GroupsController = $controller('GroupsController', {$scope: scope});
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    $httpBackend.flush();
    
    var group2 = scope.groups.pop();
    var group1 = scope.groups.pop();
    
    expect(group2.name).toEqual('Grupa2');
    expect(group2.id).toEqual(2);
    expect(group1.name).toEqual('Grupa1');
    expect(group1.id).toEqual(1);
  });
});

angular.module('core.services', ['ngResource']).
  factory('GroupsService', ['$resource',
    function($resource){
        return $resource('/groups', {}, {
            query: {method:'GET', params:{}, isArray:true}
        });
    }
]);


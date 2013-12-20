"use strict";

angular.module('app.services', [])
    .factory('raceService', function ($resource) {
        return $resource('/api/races', {}, {
            query: {method: 'GET', isArray: true}
        })
    })


"use strict";

angular.module('app.services', [])
    .factory('racesService', function ($resource) {
        return $resource('/api/races', {}, {
            query: {method: 'GET', isArray: true}
        })
    })
    .factory('raceService', function ($resource) {
        return $resource('/api/race/:id', {}, {
            get: {method: 'GET'}
        })
    });


"use strict";

angular.module('app.controllers', ['app.services'])
    .controller('tableRaceController', ['$scope', 'racesService', function ($scope, racesService) {
        $scope.races = racesService.query();
    }])
    .controller('raceController', ['$scope', '$routeParams', 'raceService', function ($scope, $routeParams, raceService) {
        var raceId = $routeParams.id;
        var race = raceService.get({id: raceId}, function() {
            $scope.race = race;
        });
    }]);

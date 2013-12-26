"use strict";

angular.module('app.controllers', ['app.services'])
    .controller('tableRaceController', ['$scope', 'Race', function ($scope, Race) {
        $scope.races = Race.query();
    }])
    .controller('raceController', ['$scope', '$routeParams', '$location', 'Race', function ($scope, $routeParams, $location, Race) {
        var raceId = $routeParams.id;
        var race = Race.get({id: raceId}, function() {
            $scope.race = race;
        });

        $scope.save = function () {
            race.$update({id: raceId}, function () {
                $location.url('/index');
            });
        }
    }]);

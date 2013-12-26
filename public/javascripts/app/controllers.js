"use strict";

angular.module('app.controllers', ['app.services'])
    .controller('tableRaceController', ['$scope', '$location', 'Race', function ($scope, $location, Race) {
        $scope.races = Race.query();

        $scope.createNewRace = function() {
            $location.url('/race/new');
        }
    }])
    .controller('updateRaceController', ['$scope', '$routeParams', '$location', 'Race', function ($scope, $routeParams, $location, Race) {
        var raceId = $routeParams.id;
        var race = Race.get({id: raceId}, function() {
            $scope.race = race;
        });

        $scope.save = function () {
            race.$update({id: raceId}, function () {
                $location.url('/index');
            });
        }
    }])
    .controller('newRaceController', ['$scope', '$location', 'Race', function ($scope, $location, Race) {
        $scope.race = new Race();
        $scope.create = function() {
            $scope.race.$save(function() {
                $location.url('/index');
            });
        }
    }]);

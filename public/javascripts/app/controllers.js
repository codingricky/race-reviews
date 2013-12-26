"use strict";

angular.module('app.controllers', ['app.services'])
    .controller('tableRaceController', ['$scope', '$location', '$route', 'Race', function ($scope, $location, $route, Race) {
        $scope.races = Race.query();

        $scope.createNewRace = function() {
            $location.url('/race/new');
        }
        $scope.deleteRace = function(raceId) {
            if (confirm('Are you sure you want to delete this race?')) {
                Race.remove({id: raceId}, function() {
                    $route.reload();
                })
            }
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
        $scope.cancel = function() {
            $location.url('/index');
        }
    }])
    .controller('newRaceController', ['$scope', '$location', 'Race', function ($scope, $location, Race) {
        $scope.race = new Race();
        $scope.create = function() {
            $scope.race.$save(function() {
                $location.url('/index');
            });
        }
        $scope.cancel = function() {
            $location.url('/index');
        }
    }]);

"use strict";

angular.module('app.controllers', ['app.services'])
    .controller('raceController', ['$scope', 'raceService', function ($scope, raceService) {
        $scope.races = raceService.query();
    }]);

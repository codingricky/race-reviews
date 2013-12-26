"use strict";

angular.module('app', ['ui.bootstrap.datetimepicker', 'ngResource', 'ngRoute', 'app.services', 'app.controllers'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/index', {templateUrl: 'assets/angular/index.html', controller: 'tableRaceController'})
            .when('/race/new', {templateUrl: 'assets/angular/new.html', controller: 'newRaceController'})
            .when('/race/:id', {templateUrl: 'assets/angular/details.html', controller: 'updateRaceController'})
            .otherwise({redirectTo: '/index'});
    }]);

"use strict";

angular.module('app', ['ngResource', 'ngRoute', 'app.services', 'app.controllers'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/index', {templateUrl: 'assets/angular/index.html', controller: 'raceController'})
            .otherwise({redirectTo: '/index'});
    }]);

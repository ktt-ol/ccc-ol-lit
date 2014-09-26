'use strict';

/**
 * @ngdoc overview
 * @name litol2014DemoApp
 * @description
 * # litol2014DemoApp
 *
 * Main module of the application.
 */
angular
  .module('litol2014DemoApp', [
    'ngAnimate',
    'ngRoute'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });

'use strict';

/**
 * @ngdoc function
 * @name litol2014DemoApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the litol2014DemoApp
 */
angular.module('litol2014DemoApp').controller('MainCtrl', function ($scope, $log, Devicedataservice, $timeout) {

    /*
     CONFIG
     */

    var WAITING = 5000;

    /*
     private
     */

    function hasValue(toCheck) {
      if (angular.isArray(toCheck)) {
        return hasValue(toCheck[0]);
      }
      return angular.isDefined(toCheck) && toCheck !== -1;
    }

    function upateUI(data) {
      if (!hasValue(data.machine)) {
        $log.debug('no machine value');
        return;
      }
      if ($scope.deviceData.machine !== data.machine) {
        $log.debug('setting machine data');
        $scope.deviceData.machine = data.machine;
        $scope.deviceData.progress.machine = true;
        return;
      }

      if (!hasValue(data.os)) {
        $log.debug('no os value');
        return;
      }
      if ($scope.deviceData.progress.machine && $scope.deviceData.os !== data.os) {
        $log.debug('setting os data');
        $scope.deviceData.os = data.os;
        $scope.deviceData.progress.os = true;
        return;
      }

      if (!hasValue(data.browser)) {
        $log.debug('no browser value');
        return;
      }
      if ($scope.deviceData.progress.os && $scope.deviceData.browser !== data.browser) {
        $log.debug('setting browser value');
        $scope.deviceData.browser = data.browser;
        $scope.deviceData.progress.browser = true;
        return;
      }

      if (!angular.isArray(data.browserHistory)) {
        $log.debug('no browserHistory');
        return;
      }

      if (!$scope.deviceData.progress.browser) {
        return;
      }
      if (data.browserHistory.length > $scope.deviceData.browserHistory.length) {
        $scope.deviceData.browserHistory.push(data.browserHistory[$scope.deviceData.browserHistory.length]);
        $log.debug('update browerHistory (new urls)');
        $scope.deviceData.progress.browserHistory = true;
      }

    }

    function updateData() {
      Devicedataservice.getData().then(
        function ok(data) {
          console.log('Update...', data);

          upateUI(data);

          // wait and update again
          $timeout(updateData, WAITING);
        },
        function err() {
          $scope.ui.error = 'Keine Verbindung zum Server möglich. :(';
        }
      );
    }

    function random(count) {
      return Math.random().toString(36).substr(2, count);
    }


    /*
     * scope vars
     */

    $scope.ui = {
      showDebug: false,
      error: null
    };

    $scope.M = Devicedataservice.MAPPING;
    $scope.deviceData = {
      progress: {
        machine: false,
        os: false,
        browser: false,
        browserHistory: false
      },
      browserHistory: []
    };

    /*
     Scope functions
     */

    $scope.debug = function (dataItem, mappingItem) {
      window._staticTestData[dataItem] = (window._staticTestData[dataItem] + 1) % Devicedataservice.MAPPING[mappingItem].length;
    };

    $scope.debugHistory = function () {
      window._staticTestData.browserHistory.push(
          'http://www.' + random(7) + '.' + random(3) + '/' + random(4) + '/' + random(6) + '.html'
      );
    };

    // init

    $timeout(updateData, WAITING);

  }
)
;

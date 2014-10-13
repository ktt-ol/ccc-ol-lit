'use strict';

/**
 * @ngdoc directive
 * @name litol2014DemoApp.directive:scrollToEnd
 * @description
 * # scrollToEnd
 */
angular.module('litol2014DemoApp').directive('scrollToEnd', function () {
  return {
    restrict: 'EA',
    link: function postLink(scope, element, attrs) {
      scope.$on(attrs.scrollToEnd, function () {
        element[0].scrollTop = 9999999999;
      });
    }
  };
});

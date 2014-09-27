'use strict';

/**
 *
 */
angular.module('litol2014DemoApp').directive('applyWindowHeight', function ($log, $window, debounce) {
  return {
    restrict: 'A',
    link: function (scope, element) {
      var windowElm = angular.element($window);

      var debouncedResize = debounce(function () {
        updateElement();
      }, 1000);

      function updateElement() {
        element.css('height', windowElm[0].innerHeight + 'px');
      }

      function onResize(event) {
        debouncedResize();
      }

      windowElm.on('resize', onResize);

      // send event on start
      updateElement();

      // cleanup
      scope.$on('$destroy', function () {
        windowElm.off('resize', onResize);
        debouncedResize.cancel();
      });
    }
  };
});

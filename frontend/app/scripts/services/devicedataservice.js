'use strict';

/**
 * @ngdoc service
 * @name litol2014DemoApp.Devicedataservice
 * @description
 * # Devicedataservice
 * Service in the litol2014DemoApp.
 */
angular.module('litol2014DemoApp').service('Devicedataservice', function Devicedataservice($q, $http) {

  function V(name, image) {
    this.name = name;
    this.image = image;
  }

//  var t1 = {
//    machine: -1, // <int>, (Samsung, IPhone, Laptop, Smatphone) -> Gerätetyp
//    os: -1, // <int>, (iOS, Android, Windows, ...)
//    browser: [-1, -1], //: <int>, (FF, Chrome, ...)
//    browserHistory: [
//      'http://google.de'
//    ],
//    email: 'holger@foo.com' //<string>, (Adresse)
//  };

  var t2 = {
    'adMap': {
      'entry': []
    },
    'browser': [2, 35],
    'browserHistory': ['www.google.de', 'www.spiegel.de', 'www.googleadservices.com', 'www.blogblog.com', 'www.fireball.de', 'www.test.de', 'www.squid-handbuch.de', 'www.nwzonline.de', 'www.afup.a36.de', 'www.eu.squid-cache.org', 'www.squarefree.com', 'www.squid-cache.org', 'www.aliexpress.com', 'www.google.com', 'www.bknoop.de', 'www.heise.de', 'www.gstatic.com', 'www.youtube.com', 'www.blogger.com', 'www.google-analytics.com', 'www.linuxhomenetworking.com'],
    'eMail': '',
    'machine': 3,
    'os': 2};

  window._staticTestData = t2;

  this.getData = function () {

    return $q.when(window._staticTestData);

  };

  this.MAPPING = {
    MACHINE: [
      new V('unknown', 'unknown.png'),
      new V('iPhone', 'machine/iPhone.jpg'),
      new V('Android', 'machine/Samsung_Galaxy_Nexusr.png'),
      new V('Laptop', 'machine/laptop.png'),
      new V('MacBook', 'machine/Macbook_Pro_Retina_13_2013.jpg')
    ],
    OS: [
      new V('unknown', 'unknown.png'),
      new V('Windows', 'os/windows.png'),
      new V('Linux', 'os/linux.png'),
      new V('iOS', 'os/IOS.png'),
      new V('MacOS', 'os/osx.png'),
      new V('Android OS', 'os/android.png')
    ],
    BROWSER: [
      new V('unknown', 'unknown.png'),
      new V('Firefox', 'browser/firefox.jpg'),
      new V('Chrome', 'browser/chrome.png'),
      new V('IE', 'browser/ie.jpg'),
      new V('Safari', 'browser/safari.jpg')
    ]

  };
});
